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
import com.datascience9.pharmacy.entity.PrescriptionCopays;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("PrescriptionCopaysDao")
public class PrescriptionCopaysDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public PrescriptionCopaysDao(JpaDao dao) {
        this.dao = dao;
    }

    public PrescriptionCopaysDao() {}

    /**
     * Find an entity.
     *
     * @param id An PrescriptionCopays id.
     * @return The same PrescriptionCopays.
     */
    public PrescriptionCopays find(java.util.UUID id) {
        final EntityManager em = dao.getEntityManager();
        return em.find(PrescriptionCopays.class, id);
    }

    /**
     * Retrieve all records PrescriptionCopays.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of PrescriptionCopays
     */
    public List<PrescriptionCopays> select(int maxResult) {
        return dao.select(
                "select a from PrescriptionCopays a", PrescriptionCopays.class, maxResult);
    }

    /**
     * Retrieve all records PrescriptionCopays.
     *
     * @return A list of PrescriptionCopays
     */
    public List<PrescriptionCopays> selectAll() {
        return dao.selectAll("select a from PrescriptionCopays a", PrescriptionCopays.class);
    }

    /**
     * Create an PrescriptionCopays.
     *
     * @param e the PrescriptionCopays.
     * @return The same PrescriptionCopays.
     */
    public PrescriptionCopays create(PrescriptionCopays e) {
        return dao.create(e);
    }

    /**
     * Update the PrescriptionCopays.
     *
     * @param e the PrescriptionCopays.
     * @return The same PrescriptionCopays.
     */
    public PrescriptionCopays update(PrescriptionCopays e) {
        return dao.update(e);
    }
}
