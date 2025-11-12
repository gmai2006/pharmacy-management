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
package com.datascience9.pharmacy.dao;

import com.datascience9.pharmacy.dao.core.JpaDao;
import com.datascience9.pharmacy.entity.Workflows;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("WorkflowsDao")
public class WorkflowsDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public WorkflowsDao(JpaDao dao) {
        this.dao = dao;
    }

    public WorkflowsDao() {}

    /**
     * Find an entity.
     *
     * @param id An Workflows id.
     * @return The same Workflows.
     */
    public Workflows find(Integer id) {
        final EntityManager em = dao.getEntityManager();
        return em.find(Workflows.class, id);
    }

    /**
     * Retrieve all records Workflows.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of Workflows
     */
    public List<Workflows> select(int maxResult) {
        return dao.select("select a from Workflows a", Workflows.class, maxResult);
    }

    /**
     * Retrieve all records Workflows.
     *
     * @return A list of Workflows
     */
    public List<Workflows> selectAll() {
        return dao.selectAll("select a from Workflows a", Workflows.class);
    }

    /**
     * Create an Workflows.
     *
     * @param e the Workflows.
     * @return The same Workflows.
     */
    public Workflows create(Workflows e) {
        return dao.create(e);
    }

    /**
     * Update the Workflows.
     *
     * @param e the Workflows.
     * @return The same Workflows.
     */
    public Workflows update(Workflows e) {
        return dao.update(e);
    }
}
