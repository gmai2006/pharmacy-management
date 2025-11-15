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

import com.datascience9.pharmacy.dao.ConsentRecordsDao;
import com.datascience9.pharmacy.entity.ConsentRecords;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultConsentRecordsService")
public class DefaultConsentRecordsService implements ConsentRecordsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final ConsentRecordsDao dao;

    @Inject
    @Named("DefaultConsentRecordsDao")
    public DefaultConsentRecordsService(final ConsentRecordsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public ConsentRecords find(java.util.UUID id) {

        final ConsentRecords result = dao.find(id);
        logger.info("find(ConsentRecords) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public java.util.UUID delete(java.util.UUID id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<ConsentRecords> select(int maxResult) {
        final List<ConsentRecords> result = dao.select(maxResult);
        logger.info("select(ConsentRecords) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<ConsentRecords> selectAll() {
        final List<ConsentRecords> results = dao.selectAll();
        logger.info("selectAll(ConsentRecords) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public ConsentRecords create(ConsentRecords bean) {
        requireNonNull(bean);
        logger.info("create(ConsentRecords={}) - entered bean ");

        final ConsentRecords result = dao.create(bean);

        logger.info("create(ConsentRecords) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public ConsentRecords update(ConsentRecords bean) {
        requireNonNull(bean);
        logger.info("update(ConsentRecords={}) - entered bean ");

        final ConsentRecords result = dao.update(bean);

        logger.info("update(ConsentRecords) - exited - return value={} result ");
        return result;
    }
}
