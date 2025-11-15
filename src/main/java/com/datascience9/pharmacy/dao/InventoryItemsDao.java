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
package com.datascience9.pharmacy.dao;

import com.datascience9.pharmacy.dao.core.JpaDao;
import com.datascience9.pharmacy.entity.InventoryItems;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("InventoryItemsDao")
public class InventoryItemsDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public InventoryItemsDao(JpaDao dao) {
        this.dao = dao;
    }

    public InventoryItemsDao() {}

    /**
     * Find an entity.
     *
     * @param id An InventoryItems id.
     * @return The same InventoryItems.
     */
    public InventoryItems find(java.util.UUID id) {
        return dao.find(InventoryItems.class, id);
    }

    /**
     * Delete an entity.
     *
     * @param id An InventoryItems id.
     * @return The Id.
     */
    public java.util.UUID delete(java.util.UUID id) {
        dao.delete(InventoryItems.class, id);
        return id;
    }

    /**
     * Retrieve all records InventoryItems.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of InventoryItems
     */
    public List<InventoryItems> select(int maxResult) {
        return dao.select("select a from InventoryItems a", InventoryItems.class, maxResult);
    }

    /**
     * Retrieve all records InventoryItems.
     *
     * @return A list of InventoryItems
     */
    public List<InventoryItems> selectAll() {
        return dao.selectAll("select a from InventoryItems a", InventoryItems.class);
    }

    /**
     * Create an InventoryItems.
     *
     * @param e the InventoryItems.
     * @return The same InventoryItems.
     */
    public InventoryItems create(InventoryItems e) {
        return dao.create(e);
    }

    /**
     * Update the InventoryItems.
     *
     * @param e the InventoryItems.
     * @return The same InventoryItems.
     */
    public InventoryItems update(InventoryItems e) {
        return dao.update(e);
    }
}
