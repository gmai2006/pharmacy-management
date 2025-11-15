-- check any items needs be reorder
SELECT i.id, i.name,
       SUM(b.quantity_on_hand) AS total_stock,
       r.min_level, r.max_level
FROM inventory_items i
JOIN inventory_batches b ON b.inventory_item_id = i.id
JOIN reorder_rules r ON r.inventory_item_id = i.id
GROUP BY i.id, i.name, r.min_level, r.max_level
HAVING SUM(b.quantity_on_hand) < r.min_level;


-- candiates for reorder
CREATE OR REPLACE VIEW v_inventory_reorder_candidates_base AS
SELECT
    i.id AS inventory_item_id,
    i.name AS item_name,
    i.ndc,
    r.min_level,
    r.max_level,
    COALESCE(SUM(b.quantity_on_hand), 0) AS total_on_hand,
    GREATEST(r.min_level - COALESCE(SUM(b.quantity_on_hand), 0), 0) AS shortage_units,
    GREATEST(r.max_level - COALESCE(SUM(b.quantity_on_hand), 0), 0) AS suggested_order_qty,
    r.preferred_wholesalers[1] AS primary_wholesaler_id
FROM inventory_items i
JOIN reorder_rules r ON r.inventory_item_id = i.id
LEFT JOIN inventory_batches b ON b.inventory_item_id = i.id
GROUP BY
    i.id, i.name, i.ndc,
    r.min_level, r.max_level,
    r.preferred_wholesalers
HAVING COALESCE(SUM(b.quantity_on_hand), 0) < r.min_level
   AND GREATEST(r.max_level - COALESCE(SUM(b.quantity_on_hand), 0), 0) > 0;

-- ignore the items in the process of ordering
CREATE OR REPLACE VIEW v_inventory_reorder_candidates AS
   SELECT *
   FROM v_inventory_reorder_candidates_base c
   WHERE NOT EXISTS (
       SELECT 1
       FROM purchase_orders po
       WHERE po.wholesaler_id = c.primary_wholesaler_id
         AND po.status IN ('open', 'submitted')
         AND po.payload @> jsonb_build_object(
               'lines', jsonb_build_array(
                   jsonb_build_object('inventory_item_id', c.inventory_item_id::text)
             )
         )
   );