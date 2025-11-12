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
import com.datascience9.pharmacy.entity.ProfitAuditWarnings;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("ProfitAuditWarningsDao")
public class ProfitAuditWarningsDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public ProfitAuditWarningsDao(JpaDao dao) {
        this.dao = dao;
    }

    public ProfitAuditWarningsDao() {}

    /**
     * Find an entity.
     *
     * @param id An ProfitAuditWarnings id.
     * @return The same ProfitAuditWarnings.
     */
    public ProfitAuditWarnings find(Long id) {
        final EntityManager em = dao.getEntityManager();
        return em.find(ProfitAuditWarnings.class, id);
    }

    /**
     * Retrieve all records ProfitAuditWarnings.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of ProfitAuditWarnings
     */
    public List<ProfitAuditWarnings> select(int maxResult) {
        return dao.select(
                "select a from ProfitAuditWarnings a", ProfitAuditWarnings.class, maxResult);
    }

    /**
     * Retrieve all records ProfitAuditWarnings.
     *
     * @return A list of ProfitAuditWarnings
     */
    public List<ProfitAuditWarnings> selectAll() {
        return dao.selectAll("select a from ProfitAuditWarnings a", ProfitAuditWarnings.class);
    }

    /**
     * Create an ProfitAuditWarnings.
     *
     * @param e the ProfitAuditWarnings.
     * @return The same ProfitAuditWarnings.
     */
    public ProfitAuditWarnings create(ProfitAuditWarnings e) {
        return dao.create(e);
    }

    /**
     * Update the ProfitAuditWarnings.
     *
     * @param e the ProfitAuditWarnings.
     * @return The same ProfitAuditWarnings.
     */
    public ProfitAuditWarnings update(ProfitAuditWarnings e) {
        return dao.update(e);
    }
}
