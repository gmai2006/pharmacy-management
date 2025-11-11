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

import com.datascience9.pharmacy.dao.TasksDao;
import com.datascience9.pharmacy.entity.Tasks;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultTasksService")
public class DefaultTasksService implements TasksService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final TasksDao dao;

    @Inject
    @Named("DefaultTasksDao")
    public DefaultTasksService(final TasksDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public Tasks find(java.util.UUID id) {

        final Tasks result = dao.find(id);
        logger.info("find(Tasks) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<Tasks> select(int maxResult) {
        final List<Tasks> result = dao.select(maxResult);
        logger.info("select(Tasks) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<Tasks> selectAll() {
        final List<Tasks> results = dao.selectAll();
        logger.info("selectAll(Tasks) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public Tasks create(Tasks bean) {
        requireNonNull(bean);
        logger.info("create(Tasks={}) - entered bean ");

        final Tasks result = dao.create(bean);

        logger.info("create(Tasks) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Tasks update(Tasks bean) {
        requireNonNull(bean);
        logger.info("update(Tasks={}) - entered bean ");

        final Tasks result = dao.update(bean);

        logger.info("update(Tasks) - exited - return value={} result ");
        return result;
    }
}
