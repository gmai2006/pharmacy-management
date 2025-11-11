/**
 * %% Copyright (C) 2025 DataScience 9 LLC %% Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License. #L%
 */
package com.datascience9.pharmacy.service.manual;

import com.datascience9.pharmacy.dao.core.JpaDao;
import com.datascience9.pharmacy.entity.InventoryBatches;
import com.datascience9.pharmacy.entity.InventoryItems;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultInventoryService")
public class DefaultInventoryService implements InventoryService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public DefaultInventoryService(JpaDao dao) {
        this.dao = dao;
    }

    @Override
    public List<InventoryItems> select(int maxResult) {
        List<InventoryItems> items =
                dao.select("select a from InventoryItems a", InventoryItems.class, maxResult);
        return items.stream().map(this::createInventory).toList();
    }

    private InventoryItems createInventory(InventoryItems item) {
        List<InventoryBatches> batches =
                dao.selectAllWithParameters(
                        "select a from InventoryBatches a where a.inventoryItemId=:uuidString",
                        InventoryBatches.class,
                        Map.of("uuidString", item.getId()));
        logger.info(
                String.format(
                        "found %s inventory batches for item %s", batches.size(), item.getName()));
        item.setInventoryBatches(batches);
        return item;
    }
}
