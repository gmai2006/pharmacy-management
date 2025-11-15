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

import com.datascience9.pharmacy.dao.ProfitAuditWarningsDao;
import com.datascience9.pharmacy.entity.ProfitAuditWarnings;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultProfitAuditWarningsService")
public class DefaultProfitAuditWarningsService implements ProfitAuditWarningsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final ProfitAuditWarningsDao dao;

    @Inject
    @Named("DefaultProfitAuditWarningsDao")
    public DefaultProfitAuditWarningsService(final ProfitAuditWarningsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public ProfitAuditWarnings find(Long id) {

        final ProfitAuditWarnings result = dao.find(id);
        logger.info("find(ProfitAuditWarnings) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Long delete(Long id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<ProfitAuditWarnings> select(int maxResult) {
        final List<ProfitAuditWarnings> result = dao.select(maxResult);
        logger.info("select(ProfitAuditWarnings) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<ProfitAuditWarnings> selectAll() {
        final List<ProfitAuditWarnings> results = dao.selectAll();
        logger.info("selectAll(ProfitAuditWarnings) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public ProfitAuditWarnings create(ProfitAuditWarnings bean) {
        requireNonNull(bean);
        logger.info("create(ProfitAuditWarnings={}) - entered bean ");

        final ProfitAuditWarnings result = dao.create(bean);

        logger.info("create(ProfitAuditWarnings) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public ProfitAuditWarnings update(ProfitAuditWarnings bean) {
        requireNonNull(bean);
        logger.info("update(ProfitAuditWarnings={}) - entered bean ");

        final ProfitAuditWarnings result = dao.update(bean);

        logger.info("update(ProfitAuditWarnings) - exited - return value={} result ");
        return result;
    }
}
