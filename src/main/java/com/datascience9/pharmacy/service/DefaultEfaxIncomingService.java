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

import com.datascience9.pharmacy.dao.EfaxIncomingDao;
import com.datascience9.pharmacy.entity.EfaxIncoming;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultEfaxIncomingService")
public class DefaultEfaxIncomingService implements EfaxIncomingService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final EfaxIncomingDao dao;

    @Inject
    @Named("DefaultEfaxIncomingDao")
    public DefaultEfaxIncomingService(final EfaxIncomingDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public EfaxIncoming find(java.util.UUID id) {

        final EfaxIncoming result = dao.find(id);
        logger.info("find(EfaxIncoming) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public java.util.UUID delete(java.util.UUID id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<EfaxIncoming> select(int maxResult) {
        final List<EfaxIncoming> result = dao.select(maxResult);
        logger.info("select(EfaxIncoming) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<EfaxIncoming> selectAll() {
        final List<EfaxIncoming> results = dao.selectAll();
        logger.info("selectAll(EfaxIncoming) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public EfaxIncoming create(EfaxIncoming bean) {
        requireNonNull(bean);
        logger.info("create(EfaxIncoming={}) - entered bean ");

        final EfaxIncoming result = dao.create(bean);

        logger.info("create(EfaxIncoming) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public EfaxIncoming update(EfaxIncoming bean) {
        requireNonNull(bean);
        logger.info("update(EfaxIncoming={}) - entered bean ");

        final EfaxIncoming result = dao.update(bean);

        logger.info("update(EfaxIncoming) - exited - return value={} result ");
        return result;
    }
}
