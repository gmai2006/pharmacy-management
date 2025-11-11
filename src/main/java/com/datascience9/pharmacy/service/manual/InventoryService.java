package com.datascience9.pharmacy.service.manual;

import com.datascience9.pharmacy.entity.InventoryItems;
import java.util.List;

public interface InventoryService {

    /**
     * Select a list of Inventory based on a given maximum number of returning records.
     *
     * @param maxResult : a specified maximum number of returned records.
     * @return Inventory records.
     */
    public List<InventoryItems> select(int maxResult);
}
