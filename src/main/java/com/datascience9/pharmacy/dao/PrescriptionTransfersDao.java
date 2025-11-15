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
import com.datascience9.pharmacy.entity.PrescriptionTransfers;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("PrescriptionTransfersDao")
public class PrescriptionTransfersDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public PrescriptionTransfersDao(JpaDao dao) {
        this.dao = dao;
    }

    public PrescriptionTransfersDao() {}

    /**
     * Find an entity.
     *
     * @param id An PrescriptionTransfers id.
     * @return The same PrescriptionTransfers.
     */
    public PrescriptionTransfers find(java.util.UUID id) {
        return dao.find(PrescriptionTransfers.class, id);
    }

    /**
     * Delete an entity.
     *
     * @param id An PrescriptionTransfers id.
     * @return The Id.
     */
    public java.util.UUID delete(java.util.UUID id) {
        dao.delete(PrescriptionTransfers.class, id);
        return id;
    }

    /**
     * Retrieve all records PrescriptionTransfers.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of PrescriptionTransfers
     */
    public List<PrescriptionTransfers> select(int maxResult) {
        return dao.select(
                "select a from PrescriptionTransfers a", PrescriptionTransfers.class, maxResult);
    }

    /**
     * Retrieve all records PrescriptionTransfers.
     *
     * @return A list of PrescriptionTransfers
     */
    public List<PrescriptionTransfers> selectAll() {
        return dao.selectAll("select a from PrescriptionTransfers a", PrescriptionTransfers.class);
    }

    /**
     * Create an PrescriptionTransfers.
     *
     * @param e the PrescriptionTransfers.
     * @return The same PrescriptionTransfers.
     */
    public PrescriptionTransfers create(PrescriptionTransfers e) {
        return dao.create(e);
    }

    /**
     * Update the PrescriptionTransfers.
     *
     * @param e the PrescriptionTransfers.
     * @return The same PrescriptionTransfers.
     */
    public PrescriptionTransfers update(PrescriptionTransfers e) {
        return dao.update(e);
    }
}
