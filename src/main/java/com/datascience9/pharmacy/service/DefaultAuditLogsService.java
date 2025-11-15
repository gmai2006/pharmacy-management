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

import com.datascience9.pharmacy.dao.AuditLogsDao;
import com.datascience9.pharmacy.entity.AuditLogs;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultAuditLogsService")
public class DefaultAuditLogsService implements AuditLogsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final AuditLogsDao dao;

    @Inject
    @Named("DefaultAuditLogsDao")
    public DefaultAuditLogsService(final AuditLogsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public AuditLogs find(Long id) {

        final AuditLogs result = dao.find(id);
        logger.info("find(AuditLogs) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Long delete(Long id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<AuditLogs> select(int maxResult) {
        final List<AuditLogs> result = dao.select(maxResult);
        logger.info("select(AuditLogs) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<AuditLogs> selectAll() {
        final List<AuditLogs> results = dao.selectAll();
        logger.info("selectAll(AuditLogs) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public AuditLogs create(AuditLogs bean) {
        requireNonNull(bean);
        logger.info("create(AuditLogs={}) - entered bean ");

        final AuditLogs result = dao.create(bean);

        logger.info("create(AuditLogs) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public AuditLogs update(AuditLogs bean) {
        requireNonNull(bean);
        logger.info("update(AuditLogs={}) - entered bean ");

        final AuditLogs result = dao.update(bean);

        logger.info("update(AuditLogs) - exited - return value={} result ");
        return result;
    }
}
