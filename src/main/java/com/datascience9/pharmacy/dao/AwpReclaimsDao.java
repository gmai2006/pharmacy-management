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
import com.datascience9.pharmacy.entity.AwpReclaims;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("AwpReclaimsDao")
public class AwpReclaimsDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public AwpReclaimsDao(JpaDao dao) {
        this.dao = dao;
    }

    public AwpReclaimsDao() {}

    /**
     * Find an entity.
     *
     * @param id An AwpReclaims id.
     * @return The same AwpReclaims.
     */
    public AwpReclaims find(java.lang.Long id) {
        final EntityManager em = dao.getEntityManager();
        return em.find(AwpReclaims.class, id);
    }

    /**
     * Retrieve all records AwpReclaims.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of AwpReclaims
     */
    public List<AwpReclaims> select(int maxResult) {
        return dao.select("select a from AwpReclaims a", AwpReclaims.class, maxResult);
    }

    /**
     * Retrieve all records AwpReclaims.
     *
     * @return A list of AwpReclaims
     */
    public List<AwpReclaims> selectAll() {
        return dao.selectAll("select a from AwpReclaims a", AwpReclaims.class);
    }

    /**
     * Create an AwpReclaims.
     *
     * @param e the AwpReclaims.
     * @return The same AwpReclaims.
     */
    public AwpReclaims create(AwpReclaims e) {
        return dao.create(e);
    }

    /**
     * Update the AwpReclaims.
     *
     * @param e the AwpReclaims.
     * @return The same AwpReclaims.
     */
    public AwpReclaims update(AwpReclaims e) {
        return dao.update(e);
    }
}
