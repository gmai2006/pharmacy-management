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

import com.datascience9.pharmacy.dao.AuthLogsDao;
import com.datascience9.pharmacy.entity.AuthLogs;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultAuthLogsService")
public class DefaultAuthLogsService implements AuthLogsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final AuthLogsDao dao;

    @Inject
    @Named("DefaultAuthLogsDao")
    public DefaultAuthLogsService(final AuthLogsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public AuthLogs find(Long id) {

        final AuthLogs result = dao.find(id);
        logger.info("find(AuthLogs) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Long delete(Long id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<AuthLogs> select(int maxResult) {
        final List<AuthLogs> result = dao.select(maxResult);
        logger.info("select(AuthLogs) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<AuthLogs> selectAll() {
        final List<AuthLogs> results = dao.selectAll();
        logger.info("selectAll(AuthLogs) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public AuthLogs create(AuthLogs bean) {
        requireNonNull(bean);
        logger.info("create(AuthLogs={}) - entered bean ");

        final AuthLogs result = dao.create(bean);

        logger.info("create(AuthLogs) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public AuthLogs update(AuthLogs bean) {
        requireNonNull(bean);
        logger.info("update(AuthLogs={}) - entered bean ");

        final AuthLogs result = dao.update(bean);

        logger.info("update(AuthLogs) - exited - return value={} result ");
        return result;
    }
}
