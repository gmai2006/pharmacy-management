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

import com.datascience9.pharmacy.dao.AccessLogsDao;
import com.datascience9.pharmacy.entity.AccessLogs;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultAccessLogsService")
public class DefaultAccessLogsService implements AccessLogsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final AccessLogsDao dao;

    @Inject
    @Named("DefaultAccessLogsDao")
    public DefaultAccessLogsService(final AccessLogsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public AccessLogs find(Long id) {

        final AccessLogs result = dao.find(id);
        logger.info("find(AccessLogs) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<AccessLogs> select(int maxResult) {
        final List<AccessLogs> result = dao.select(maxResult);
        logger.info("select(AccessLogs) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<AccessLogs> selectAll() {
        final List<AccessLogs> results = dao.selectAll();
        logger.info("selectAll(AccessLogs) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public AccessLogs create(AccessLogs bean) {
        requireNonNull(bean);
        logger.info("create(AccessLogs={}) - entered bean ");

        final AccessLogs result = dao.create(bean);

        logger.info("create(AccessLogs) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public AccessLogs update(AccessLogs bean) {
        requireNonNull(bean);
        logger.info("update(AccessLogs={}) - entered bean ");

        final AccessLogs result = dao.update(bean);

        logger.info("update(AccessLogs) - exited - return value={} result ");
        return result;
    }
}
