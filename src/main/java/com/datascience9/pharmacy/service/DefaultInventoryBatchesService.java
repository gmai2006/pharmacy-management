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

import com.datascience9.pharmacy.dao.InventoryBatchesDao;
import com.datascience9.pharmacy.entity.InventoryBatches;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultInventoryBatchesService")
public class DefaultInventoryBatchesService implements InventoryBatchesService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final InventoryBatchesDao dao;

    @Inject
    @Named("DefaultInventoryBatchesDao")
    public DefaultInventoryBatchesService(final InventoryBatchesDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public InventoryBatches find(java.util.UUID id) {

        final InventoryBatches result = dao.find(id);
        logger.info("find(InventoryBatches) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<InventoryBatches> select(int maxResult) {
        final List<InventoryBatches> result = dao.select(maxResult);
        logger.info("select(InventoryBatches) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<InventoryBatches> selectAll() {
        final List<InventoryBatches> results = dao.selectAll();
        logger.info("selectAll(InventoryBatches) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public InventoryBatches create(InventoryBatches bean) {
        requireNonNull(bean);
        logger.info("create(InventoryBatches={}) - entered bean ");

        final InventoryBatches result = dao.create(bean);

        logger.info("create(InventoryBatches) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public InventoryBatches update(InventoryBatches bean) {
        requireNonNull(bean);
        logger.info("update(InventoryBatches={}) - entered bean ");

        final InventoryBatches result = dao.update(bean);

        logger.info("update(InventoryBatches) - exited - return value={} result ");
        return result;
    }
}
