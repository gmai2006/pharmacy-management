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
import com.datascience9.pharmacy.entity.PrescriptionAudit;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("PrescriptionAuditDao")
public class PrescriptionAuditDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public PrescriptionAuditDao(JpaDao dao) {
        this.dao = dao;
    }

    public PrescriptionAuditDao() {}

    /**
     * Find an entity.
     *
     * @param id An PrescriptionAudit id.
     * @return The same PrescriptionAudit.
     */
    public PrescriptionAudit find(Long id) {
        return dao.find(PrescriptionAudit.class, id);
    }

    /**
     * Delete an entity.
     *
     * @param id An PrescriptionAudit id.
     * @return The Id.
     */
    public Long delete(Long id) {
        dao.delete(PrescriptionAudit.class, id);
        return id;
    }

    /**
     * Retrieve all records PrescriptionAudit.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of PrescriptionAudit
     */
    public List<PrescriptionAudit> select(int maxResult) {
        return dao.select("select a from PrescriptionAudit a", PrescriptionAudit.class, maxResult);
    }

    /**
     * Retrieve all records PrescriptionAudit.
     *
     * @return A list of PrescriptionAudit
     */
    public List<PrescriptionAudit> selectAll() {
        return dao.selectAll("select a from PrescriptionAudit a", PrescriptionAudit.class);
    }

    /**
     * Create an PrescriptionAudit.
     *
     * @param e the PrescriptionAudit.
     * @return The same PrescriptionAudit.
     */
    public PrescriptionAudit create(PrescriptionAudit e) {
        return dao.create(e);
    }

    /**
     * Update the PrescriptionAudit.
     *
     * @param e the PrescriptionAudit.
     * @return The same PrescriptionAudit.
     */
    public PrescriptionAudit update(PrescriptionAudit e) {
        return dao.update(e);
    }
}
