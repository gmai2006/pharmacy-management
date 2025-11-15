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

import com.datascience9.pharmacy.dao.PaymentsDao;
import com.datascience9.pharmacy.entity.Payments;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPaymentsService")
public class DefaultPaymentsService implements PaymentsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PaymentsDao dao;

    @Inject
    @Named("DefaultPaymentsDao")
    public DefaultPaymentsService(final PaymentsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public Payments find(java.util.UUID id) {

        final Payments result = dao.find(id);
        logger.info("find(Payments) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public java.util.UUID delete(java.util.UUID id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<Payments> select(int maxResult) {
        final List<Payments> result = dao.select(maxResult);
        logger.info("select(Payments) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<Payments> selectAll() {
        final List<Payments> results = dao.selectAll();
        logger.info("selectAll(Payments) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public Payments create(Payments bean) {
        requireNonNull(bean);
        logger.info("create(Payments={}) - entered bean ");

        final Payments result = dao.create(bean);

        logger.info("create(Payments) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Payments update(Payments bean) {
        requireNonNull(bean);
        logger.info("update(Payments={}) - entered bean ");

        final Payments result = dao.update(bean);

        logger.info("update(Payments) - exited - return value={} result ");
        return result;
    }
}
