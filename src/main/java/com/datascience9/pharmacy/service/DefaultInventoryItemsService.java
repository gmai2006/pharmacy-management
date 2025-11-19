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
package com.datascience9.pharmacy.service;

import static java.util.Objects.requireNonNull;

import com.datascience9.pharmacy.dao.InventoryItemsDao;
import com.datascience9.pharmacy.entity.InventoryItems;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultInventoryItemsService")
public class DefaultInventoryItemsService implements InventoryItemsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final InventoryItemsDao dao;

    @Inject
    @Named("DefaultInventoryItemsDao")
    public DefaultInventoryItemsService(final InventoryItemsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public InventoryItems find(java.util.UUID id) {

        final InventoryItems result = dao.find(id);
        logger.info("find(InventoryItems) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public java.util.UUID delete(java.util.UUID id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<InventoryItems> select(int maxResult) {
        final List<InventoryItems> result = dao.select(maxResult);
        logger.info("select(InventoryItems) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<InventoryItems> selectAll() {
        final List<InventoryItems> results = dao.selectAll();
        logger.info("selectAll(InventoryItems) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public InventoryItems create(InventoryItems bean) {
        requireNonNull(bean);
        bean.setId(UUID.randomUUID());
        bean.setCreatedAt(java.time.LocalDateTime.now());
        logger.info("create(InventoryItems={}) - entered bean ");

        final InventoryItems result = dao.create(bean);

        logger.info("create(InventoryItems) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public InventoryItems update(InventoryItems bean) {
        requireNonNull(bean);
        logger.info("update(InventoryItems={}) - entered bean ");

        final InventoryItems result = dao.update(bean);

        logger.info("update(InventoryItems) - exited - return value={} result ");
        return result;
    }
}
