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
import com.datascience9.pharmacy.entity.Prescriptions;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("PrescriptionsDao")
public class PrescriptionsDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public PrescriptionsDao(JpaDao dao) {
        this.dao = dao;
    }

    public PrescriptionsDao() {}

    /**
     * Find an entity.
     *
     * @param id An Prescriptions id.
     * @return The same Prescriptions.
     */
    public Prescriptions find(java.util.UUID id) {
        final EntityManager em = dao.getEntityManager();
        return em.find(Prescriptions.class, id);
    }

    /**
     * Retrieve all records Prescriptions.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of Prescriptions
     */
    public List<Prescriptions> select(int maxResult) {
        return dao.select("select a from Prescriptions a", Prescriptions.class, maxResult);
    }

    /**
     * Retrieve all records Prescriptions.
     *
     * @return A list of Prescriptions
     */
    public List<Prescriptions> selectAll() {
        return dao.selectAll("select a from Prescriptions a", Prescriptions.class);
    }

    /**
     * Create an Prescriptions.
     *
     * @param e the Prescriptions.
     * @return The same Prescriptions.
     */
    public Prescriptions create(Prescriptions e) {
        return dao.create(e);
    }

    /**
     * Update the Prescriptions.
     *
     * @param e the Prescriptions.
     * @return The same Prescriptions.
     */
    public Prescriptions update(Prescriptions e) {
        return dao.update(e);
    }
}
