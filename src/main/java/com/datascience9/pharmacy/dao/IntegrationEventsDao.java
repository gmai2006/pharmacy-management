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
import com.datascience9.pharmacy.entity.IntegrationEvents;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("IntegrationEventsDao")
public class IntegrationEventsDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public IntegrationEventsDao(JpaDao dao) {
        this.dao = dao;
    }

    public IntegrationEventsDao() {}

    /**
     * Find an entity.
     *
     * @param id An IntegrationEvents id.
     * @return The same IntegrationEvents.
     */
    public IntegrationEvents find(java.util.UUID id) {
        return dao.find(IntegrationEvents.class, id);
    }

    /**
     * Delete an entity.
     *
     * @param id An IntegrationEvents id.
     * @return The Id.
     */
    public java.util.UUID delete(java.util.UUID id) {
        dao.delete(IntegrationEvents.class, id);
        return id;
    }

    /**
     * Retrieve all records IntegrationEvents.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of IntegrationEvents
     */
    public List<IntegrationEvents> select(int maxResult) {
        return dao.select("select a from IntegrationEvents a", IntegrationEvents.class, maxResult);
    }

    /**
     * Retrieve all records IntegrationEvents.
     *
     * @return A list of IntegrationEvents
     */
    public List<IntegrationEvents> selectAll() {
        return dao.selectAll("select a from IntegrationEvents a", IntegrationEvents.class);
    }

    /**
     * Create an IntegrationEvents.
     *
     * @param e the IntegrationEvents.
     * @return The same IntegrationEvents.
     */
    public IntegrationEvents create(IntegrationEvents e) {
        return dao.create(e);
    }

    /**
     * Update the IntegrationEvents.
     *
     * @param e the IntegrationEvents.
     * @return The same IntegrationEvents.
     */
    public IntegrationEvents update(IntegrationEvents e) {
        return dao.update(e);
    }
}
