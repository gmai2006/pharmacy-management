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
import com.datascience9.pharmacy.entity.AuthLogs;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("AuthLogsDao")
public class AuthLogsDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public AuthLogsDao(JpaDao dao) {
        this.dao = dao;
    }

    public AuthLogsDao() {}

    /**
     * Find an entity.
     *
     * @param id An AuthLogs id.
     * @return The same AuthLogs.
     */
    public AuthLogs find(Long id) {
        return dao.find(AuthLogs.class, id);
    }

    /**
     * Delete an entity.
     *
     * @param id An AuthLogs id.
     * @return The Id.
     */
    public Long delete(Long id) {
        dao.delete(AuthLogs.class, id);
        return id;
    }

    /**
     * Retrieve all records AuthLogs.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of AuthLogs
     */
    public List<AuthLogs> select(int maxResult) {
        return dao.select("select a from AuthLogs a", AuthLogs.class, maxResult);
    }

    /**
     * Retrieve all records AuthLogs.
     *
     * @return A list of AuthLogs
     */
    public List<AuthLogs> selectAll() {
        return dao.selectAll("select a from AuthLogs a", AuthLogs.class);
    }

    /**
     * Create an AuthLogs.
     *
     * @param e the AuthLogs.
     * @return The same AuthLogs.
     */
    public AuthLogs create(AuthLogs e) {
        return dao.create(e);
    }

    /**
     * Update the AuthLogs.
     *
     * @param e the AuthLogs.
     * @return The same AuthLogs.
     */
    public AuthLogs update(AuthLogs e) {
        return dao.update(e);
    }
}
