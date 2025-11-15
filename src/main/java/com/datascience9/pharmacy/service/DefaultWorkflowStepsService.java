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

import com.datascience9.pharmacy.dao.WorkflowStepsDao;
import com.datascience9.pharmacy.entity.WorkflowSteps;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultWorkflowStepsService")
public class DefaultWorkflowStepsService implements WorkflowStepsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final WorkflowStepsDao dao;

    @Inject
    @Named("DefaultWorkflowStepsDao")
    public DefaultWorkflowStepsService(final WorkflowStepsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public WorkflowSteps find(Integer id) {

        final WorkflowSteps result = dao.find(id);
        logger.info("find(WorkflowSteps) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Integer delete(Integer id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<WorkflowSteps> select(int maxResult) {
        final List<WorkflowSteps> result = dao.select(maxResult);
        logger.info("select(WorkflowSteps) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<WorkflowSteps> selectAll() {
        final List<WorkflowSteps> results = dao.selectAll();
        logger.info("selectAll(WorkflowSteps) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public WorkflowSteps create(WorkflowSteps bean) {
        requireNonNull(bean);
        logger.info("create(WorkflowSteps={}) - entered bean ");

        final WorkflowSteps result = dao.create(bean);

        logger.info("create(WorkflowSteps) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public WorkflowSteps update(WorkflowSteps bean) {
        requireNonNull(bean);
        logger.info("update(WorkflowSteps={}) - entered bean ");

        final WorkflowSteps result = dao.update(bean);

        logger.info("update(WorkflowSteps) - exited - return value={} result ");
        return result;
    }
}
