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

import com.datascience9.pharmacy.dao.EfaxStatusLogsDao;
import com.datascience9.pharmacy.entity.EfaxStatusLogs;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultEfaxStatusLogsService")
public class DefaultEfaxStatusLogsService implements EfaxStatusLogsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final EfaxStatusLogsDao dao;

    @Inject
    @Named("DefaultEfaxStatusLogsDao")
    public DefaultEfaxStatusLogsService(final EfaxStatusLogsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public EfaxStatusLogs find(Long id) {

        final EfaxStatusLogs result = dao.find(id);
        logger.info("find(EfaxStatusLogs) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<EfaxStatusLogs> select(int maxResult) {
        final List<EfaxStatusLogs> result = dao.select(maxResult);
        logger.info("select(EfaxStatusLogs) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<EfaxStatusLogs> selectAll() {
        final List<EfaxStatusLogs> results = dao.selectAll();
        logger.info("selectAll(EfaxStatusLogs) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public EfaxStatusLogs create(EfaxStatusLogs bean) {
        requireNonNull(bean);
        logger.info("create(EfaxStatusLogs={}) - entered bean ");

        final EfaxStatusLogs result = dao.create(bean);

        logger.info("create(EfaxStatusLogs) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public EfaxStatusLogs update(EfaxStatusLogs bean) {
        requireNonNull(bean);
        logger.info("update(EfaxStatusLogs={}) - entered bean ");

        final EfaxStatusLogs result = dao.update(bean);

        logger.info("update(EfaxStatusLogs) - exited - return value={} result ");
        return result;
    }
}
