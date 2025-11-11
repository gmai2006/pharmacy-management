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

import com.datascience9.pharmacy.dao.AlertLogsDao;
import com.datascience9.pharmacy.entity.AlertLogs;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultAlertLogsService")
public class DefaultAlertLogsService implements AlertLogsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final AlertLogsDao dao;

    @Inject
    @Named("DefaultAlertLogsDao")
    public DefaultAlertLogsService(final AlertLogsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public AlertLogs find(java.lang.Long id) {

        final AlertLogs result = dao.find(id);
        logger.info("find(AlertLogs) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<AlertLogs> select(int maxResult) {
        final List<AlertLogs> result = dao.select(maxResult);
        logger.info("select(AlertLogs) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<AlertLogs> selectAll() {
        final List<AlertLogs> results = dao.selectAll();
        logger.info("selectAll(AlertLogs) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public AlertLogs create(AlertLogs bean) {
        requireNonNull(bean);
        logger.info("create(AlertLogs={}) - entered bean ");

        final AlertLogs result = dao.create(bean);

        logger.info("create(AlertLogs) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public AlertLogs update(AlertLogs bean) {
        requireNonNull(bean);
        logger.info("update(AlertLogs={}) - entered bean ");

        final AlertLogs result = dao.update(bean);

        logger.info("update(AlertLogs) - exited - return value={} result ");
        return result;
    }
}
