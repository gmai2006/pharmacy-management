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
import com.datascience9.pharmacy.entity.Queues;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("QueuesDao")
public class QueuesDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public QueuesDao(JpaDao dao) {
        this.dao = dao;
    }

    public QueuesDao() {}

    /**
     * Find an entity.
     *
     * @param id An Queues id.
     * @return The same Queues.
     */
    public Queues find(Integer id) {
        return dao.find(Queues.class, id);
    }

    /**
     * Delete an entity.
     *
     * @param id An Queues id.
     * @return The Id.
     */
    public Integer delete(Integer id) {
        dao.delete(Queues.class, id);
        return id;
    }

    /**
     * Retrieve all records Queues.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of Queues
     */
    public List<Queues> select(int maxResult) {
        return dao.select("select a from Queues a", Queues.class, maxResult);
    }

    /**
     * Retrieve all records Queues.
     *
     * @return A list of Queues
     */
    public List<Queues> selectAll() {
        return dao.selectAll("select a from Queues a", Queues.class);
    }

    /**
     * Create an Queues.
     *
     * @param e the Queues.
     * @return The same Queues.
     */
    public Queues create(Queues e) {
        return dao.create(e);
    }

    /**
     * Update the Queues.
     *
     * @param e the Queues.
     * @return The same Queues.
     */
    public Queues update(Queues e) {
        return dao.update(e);
    }
}
