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

import com.datascience9.pharmacy.dao.PosTransactionsDao;
import com.datascience9.pharmacy.entity.PosTransactions;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPosTransactionsService")
public class DefaultPosTransactionsService implements PosTransactionsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PosTransactionsDao dao;

    @Inject
    @Named("DefaultPosTransactionsDao")
    public DefaultPosTransactionsService(final PosTransactionsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public PosTransactions find(java.util.UUID id) {

        final PosTransactions result = dao.find(id);
        logger.info("find(PosTransactions) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public java.util.UUID delete(java.util.UUID id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<PosTransactions> select(int maxResult) {
        final List<PosTransactions> result = dao.select(maxResult);
        logger.info("select(PosTransactions) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<PosTransactions> selectAll() {
        final List<PosTransactions> results = dao.selectAll();
        logger.info("selectAll(PosTransactions) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public PosTransactions create(PosTransactions bean) {
        requireNonNull(bean);
        logger.info("create(PosTransactions={}) - entered bean ");

        final PosTransactions result = dao.create(bean);

        logger.info("create(PosTransactions) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public PosTransactions update(PosTransactions bean) {
        requireNonNull(bean);
        logger.info("update(PosTransactions={}) - entered bean ");

        final PosTransactions result = dao.update(bean);

        logger.info("update(PosTransactions) - exited - return value={} result ");
        return result;
    }
}
