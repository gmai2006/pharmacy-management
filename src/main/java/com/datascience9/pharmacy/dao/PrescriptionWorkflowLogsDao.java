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
import com.datascience9.pharmacy.entity.PrescriptionWorkflowLogs;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("PrescriptionWorkflowLogsDao")
public class PrescriptionWorkflowLogsDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public PrescriptionWorkflowLogsDao(JpaDao dao) {
        this.dao = dao;
    }

    public PrescriptionWorkflowLogsDao() {}

    /**
     * Find an entity.
     *
     * @param id An PrescriptionWorkflowLogs id.
     * @return The same PrescriptionWorkflowLogs.
     */
    public PrescriptionWorkflowLogs find(Long id) {
        return dao.find(PrescriptionWorkflowLogs.class, id);
    }

    /**
     * Delete an entity.
     *
     * @param id An PrescriptionWorkflowLogs id.
     * @return The Id.
     */
    public Long delete(Long id) {
        dao.delete(PrescriptionWorkflowLogs.class, id);
        return id;
    }

    /**
     * Retrieve all records PrescriptionWorkflowLogs.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of PrescriptionWorkflowLogs
     */
    public List<PrescriptionWorkflowLogs> select(int maxResult) {
        return dao.select(
                "select a from PrescriptionWorkflowLogs a",
                PrescriptionWorkflowLogs.class,
                maxResult);
    }

    /**
     * Retrieve all records PrescriptionWorkflowLogs.
     *
     * @return A list of PrescriptionWorkflowLogs
     */
    public List<PrescriptionWorkflowLogs> selectAll() {
        return dao.selectAll(
                "select a from PrescriptionWorkflowLogs a", PrescriptionWorkflowLogs.class);
    }

    /**
     * Create an PrescriptionWorkflowLogs.
     *
     * @param e the PrescriptionWorkflowLogs.
     * @return The same PrescriptionWorkflowLogs.
     */
    public PrescriptionWorkflowLogs create(PrescriptionWorkflowLogs e) {
        return dao.create(e);
    }

    /**
     * Update the PrescriptionWorkflowLogs.
     *
     * @param e the PrescriptionWorkflowLogs.
     * @return The same PrescriptionWorkflowLogs.
     */
    public PrescriptionWorkflowLogs update(PrescriptionWorkflowLogs e) {
        return dao.update(e);
    }
}
