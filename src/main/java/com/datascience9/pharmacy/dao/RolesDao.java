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
import com.datascience9.pharmacy.entity.Roles;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("RolesDao")
public class RolesDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public RolesDao(JpaDao dao) {
        this.dao = dao;
    }

    public RolesDao() {}

    /**
     * Find an entity.
     *
     * @param id An Roles id.
     * @return The same Roles.
     */
    public Roles find(Integer id) {
        return dao.find(Roles.class, id);
    }

    /**
     * Delete an entity.
     *
     * @param id An Roles id.
     * @return The Id.
     */
    public Integer delete(Integer id) {
        dao.delete(Roles.class, id);
        return id;
    }

    /**
     * Retrieve all records Roles.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of Roles
     */
    public List<Roles> select(int maxResult) {
        return dao.select("select a from Roles a", Roles.class, maxResult);
    }

    /**
     * Retrieve all records Roles.
     *
     * @return A list of Roles
     */
    public List<Roles> selectAll() {
        return dao.selectAll("select a from Roles a", Roles.class);
    }

    /**
     * Create an Roles.
     *
     * @param e the Roles.
     * @return The same Roles.
     */
    public Roles create(Roles e) {
        return dao.create(e);
    }

    /**
     * Update the Roles.
     *
     * @param e the Roles.
     * @return The same Roles.
     */
    public Roles update(Roles e) {
        return dao.update(e);
    }
}
