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

import com.datascience9.pharmacy.dao.PurchaseOrdersDao;
import com.datascience9.pharmacy.entity.PurchaseOrders;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPurchaseOrdersService")
public class DefaultPurchaseOrdersService implements PurchaseOrdersService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PurchaseOrdersDao dao;

    @Inject
    @Named("DefaultPurchaseOrdersDao")
    public DefaultPurchaseOrdersService(final PurchaseOrdersDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public PurchaseOrders find(java.util.UUID id) {

        final PurchaseOrders result = dao.find(id);
        logger.info("find(PurchaseOrders) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<PurchaseOrders> select(int maxResult) {
        final List<PurchaseOrders> result = dao.select(maxResult);
        logger.info("select(PurchaseOrders) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<PurchaseOrders> selectAll() {
        final List<PurchaseOrders> results = dao.selectAll();
        logger.info("selectAll(PurchaseOrders) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public PurchaseOrders create(PurchaseOrders bean) {
        requireNonNull(bean);
        logger.info("create(PurchaseOrders={}) - entered bean ");

        final PurchaseOrders result = dao.create(bean);

        logger.info("create(PurchaseOrders) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public PurchaseOrders update(PurchaseOrders bean) {
        requireNonNull(bean);
        logger.info("update(PurchaseOrders={}) - entered bean ");

        final PurchaseOrders result = dao.update(bean);

        logger.info("update(PurchaseOrders) - exited - return value={} result ");
        return result;
    }
}
