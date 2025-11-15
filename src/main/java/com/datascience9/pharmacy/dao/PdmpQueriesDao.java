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
import com.datascience9.pharmacy.entity.PdmpQueries;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("PdmpQueriesDao")
public class PdmpQueriesDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public PdmpQueriesDao(JpaDao dao) {
        this.dao = dao;
    }

    public PdmpQueriesDao() {}

    /**
     * Find an entity.
     *
     * @param id An PdmpQueries id.
     * @return The same PdmpQueries.
     */
    public PdmpQueries find(java.util.UUID id) {
        return dao.find(PdmpQueries.class, id);
    }

    /**
     * Delete an entity.
     *
     * @param id An PdmpQueries id.
     * @return The Id.
     */
    public java.util.UUID delete(java.util.UUID id) {
        dao.delete(PdmpQueries.class, id);
        return id;
    }

    /**
     * Retrieve all records PdmpQueries.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of PdmpQueries
     */
    public List<PdmpQueries> select(int maxResult) {
        return dao.select("select a from PdmpQueries a", PdmpQueries.class, maxResult);
    }

    /**
     * Retrieve all records PdmpQueries.
     *
     * @return A list of PdmpQueries
     */
    public List<PdmpQueries> selectAll() {
        return dao.selectAll("select a from PdmpQueries a", PdmpQueries.class);
    }

    /**
     * Create an PdmpQueries.
     *
     * @param e the PdmpQueries.
     * @return The same PdmpQueries.
     */
    public PdmpQueries create(PdmpQueries e) {
        return dao.create(e);
    }

    /**
     * Update the PdmpQueries.
     *
     * @param e the PdmpQueries.
     * @return The same PdmpQueries.
     */
    public PdmpQueries update(PdmpQueries e) {
        return dao.update(e);
    }
}
