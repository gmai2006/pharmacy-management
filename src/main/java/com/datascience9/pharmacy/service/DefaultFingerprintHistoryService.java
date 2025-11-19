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

import com.datascience9.pharmacy.dao.FingerprintHistoryDao;
import com.datascience9.pharmacy.entity.FingerprintHistory;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultFingerprintHistoryService")
public class DefaultFingerprintHistoryService implements FingerprintHistoryService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final FingerprintHistoryDao dao;

    @Inject
    @Named("DefaultFingerprintHistoryDao")
    public DefaultFingerprintHistoryService(final FingerprintHistoryDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public FingerprintHistory find(Integer id) {

        final FingerprintHistory result = dao.find(id);
        logger.info("find(FingerprintHistory) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Integer delete(Integer id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<FingerprintHistory> select(int maxResult) {
        final List<FingerprintHistory> result = dao.select(maxResult);
        logger.info("select(FingerprintHistory) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<FingerprintHistory> selectAll() {
        final List<FingerprintHistory> results = dao.selectAll();
        logger.info("selectAll(FingerprintHistory) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public FingerprintHistory create(FingerprintHistory bean) {
        requireNonNull(bean);
        logger.info("create(FingerprintHistory={}) - entered bean ");

        final FingerprintHistory result = dao.create(bean);

        logger.info("create(FingerprintHistory) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public FingerprintHistory update(FingerprintHistory bean) {
        requireNonNull(bean);
        logger.info("update(FingerprintHistory={}) - entered bean ");

        final FingerprintHistory result = dao.update(bean);

        logger.info("update(FingerprintHistory) - exited - return value={} result ");
        return result;
    }
}
