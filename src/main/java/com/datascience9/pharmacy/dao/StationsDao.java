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
import com.datascience9.pharmacy.entity.Stations;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("StationsDao")
public class StationsDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public StationsDao(JpaDao dao) {
        this.dao = dao;
    }

    public StationsDao() {}

    /**
     * Find an entity.
     *
     * @param id An Stations id.
     * @return The same Stations.
     */
    public Stations find(Integer id) {
        return dao.find(Stations.class, id);
    }

    /**
     * Delete an entity.
     *
     * @param id An Stations id.
     * @return The Id.
     */
    public Integer delete(Integer id) {
        dao.delete(Stations.class, id);
        return id;
    }

    /**
     * Retrieve all records Stations.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of Stations
     */
    public List<Stations> select(int maxResult) {
        return dao.select("select a from Stations a", Stations.class, maxResult);
    }

    /**
     * Retrieve all records Stations.
     *
     * @return A list of Stations
     */
    public List<Stations> selectAll() {
        return dao.selectAll("select a from Stations a", Stations.class);
    }

    /**
     * Create an Stations.
     *
     * @param e the Stations.
     * @return The same Stations.
     */
    public Stations create(Stations e) {
        return dao.create(e);
    }

    /**
     * Update the Stations.
     *
     * @param e the Stations.
     * @return The same Stations.
     */
    public Stations update(Stations e) {
        return dao.update(e);
    }
}
