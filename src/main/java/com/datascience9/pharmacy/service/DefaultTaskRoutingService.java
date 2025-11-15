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

import com.datascience9.pharmacy.dao.TaskRoutingDao;
import com.datascience9.pharmacy.entity.TaskRouting;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultTaskRoutingService")
public class DefaultTaskRoutingService implements TaskRoutingService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final TaskRoutingDao dao;

    @Inject
    @Named("DefaultTaskRoutingDao")
    public DefaultTaskRoutingService(final TaskRoutingDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public TaskRouting find(Integer id) {

        final TaskRouting result = dao.find(id);
        logger.info("find(TaskRouting) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Integer delete(Integer id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<TaskRouting> select(int maxResult) {
        final List<TaskRouting> result = dao.select(maxResult);
        logger.info("select(TaskRouting) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<TaskRouting> selectAll() {
        final List<TaskRouting> results = dao.selectAll();
        logger.info("selectAll(TaskRouting) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public TaskRouting create(TaskRouting bean) {
        requireNonNull(bean);
        logger.info("create(TaskRouting={}) - entered bean ");

        final TaskRouting result = dao.create(bean);

        logger.info("create(TaskRouting) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public TaskRouting update(TaskRouting bean) {
        requireNonNull(bean);
        logger.info("update(TaskRouting={}) - entered bean ");

        final TaskRouting result = dao.update(bean);

        logger.info("update(TaskRouting) - exited - return value={} result ");
        return result;
    }
}
