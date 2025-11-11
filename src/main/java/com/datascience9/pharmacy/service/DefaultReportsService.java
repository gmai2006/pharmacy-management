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

import com.datascience9.pharmacy.dao.ReportsDao;
import com.datascience9.pharmacy.entity.Reports;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultReportsService")
public class DefaultReportsService implements ReportsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final ReportsDao dao;

    @Inject
    @Named("DefaultReportsDao")
    public DefaultReportsService(final ReportsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public Reports find(java.util.UUID id) {

        final Reports result = dao.find(id);
        logger.info("find(Reports) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<Reports> select(int maxResult) {
        final List<Reports> result = dao.select(maxResult);
        logger.info("select(Reports) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<Reports> selectAll() {
        final List<Reports> results = dao.selectAll();
        logger.info("selectAll(Reports) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public Reports create(Reports bean) {
        requireNonNull(bean);
        logger.info("create(Reports={}) - entered bean ");

        final Reports result = dao.create(bean);

        logger.info("create(Reports) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Reports update(Reports bean) {
        requireNonNull(bean);
        logger.info("update(Reports={}) - entered bean ");

        final Reports result = dao.update(bean);

        logger.info("update(Reports) - exited - return value={} result ");
        return result;
    }
}
