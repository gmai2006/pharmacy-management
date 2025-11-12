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

import com.datascience9.pharmacy.dao.WorkflowsDao;
import com.datascience9.pharmacy.entity.Workflows;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultWorkflowsService")
public class DefaultWorkflowsService implements WorkflowsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final WorkflowsDao dao;

    @Inject
    @Named("DefaultWorkflowsDao")
    public DefaultWorkflowsService(final WorkflowsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public Workflows find(Integer id) {

        final Workflows result = dao.find(id);
        logger.info("find(Workflows) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<Workflows> select(int maxResult) {
        final List<Workflows> result = dao.select(maxResult);
        logger.info("select(Workflows) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<Workflows> selectAll() {
        final List<Workflows> results = dao.selectAll();
        logger.info("selectAll(Workflows) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public Workflows create(Workflows bean) {
        requireNonNull(bean);
        logger.info("create(Workflows={}) - entered bean ");

        final Workflows result = dao.create(bean);

        logger.info("create(Workflows) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Workflows update(Workflows bean) {
        requireNonNull(bean);
        logger.info("update(Workflows={}) - entered bean ");

        final Workflows result = dao.update(bean);

        logger.info("update(Workflows) - exited - return value={} result ");
        return result;
    }
}
