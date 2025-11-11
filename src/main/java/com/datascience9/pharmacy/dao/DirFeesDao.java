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
import com.datascience9.pharmacy.entity.DirFees;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DirFeesDao")
public class DirFeesDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public DirFeesDao(JpaDao dao) {
        this.dao = dao;
    }

    public DirFeesDao() {}

    /**
     * Find an entity.
     *
     * @param id An DirFees id.
     * @return The same DirFees.
     */
    public DirFees find(java.lang.Long id) {
        final EntityManager em = dao.getEntityManager();
        return em.find(DirFees.class, id);
    }

    /**
     * Retrieve all records DirFees.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of DirFees
     */
    public List<DirFees> select(int maxResult) {
        return dao.select("select a from DirFees a", DirFees.class, maxResult);
    }

    /**
     * Retrieve all records DirFees.
     *
     * @return A list of DirFees
     */
    public List<DirFees> selectAll() {
        return dao.selectAll("select a from DirFees a", DirFees.class);
    }

    /**
     * Create an DirFees.
     *
     * @param e the DirFees.
     * @return The same DirFees.
     */
    public DirFees create(DirFees e) {
        return dao.create(e);
    }

    /**
     * Update the DirFees.
     *
     * @param e the DirFees.
     * @return The same DirFees.
     */
    public DirFees update(DirFees e) {
        return dao.update(e);
    }
}
