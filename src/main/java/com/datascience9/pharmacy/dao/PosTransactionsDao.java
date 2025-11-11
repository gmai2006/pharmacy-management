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
import com.datascience9.pharmacy.entity.PosTransactions;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("PosTransactionsDao")
public class PosTransactionsDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public PosTransactionsDao(JpaDao dao) {
        this.dao = dao;
    }

    public PosTransactionsDao() {}

    /**
     * Find an entity.
     *
     * @param id An PosTransactions id.
     * @return The same PosTransactions.
     */
    public PosTransactions find(java.util.UUID id) {
        final EntityManager em = dao.getEntityManager();
        return em.find(PosTransactions.class, id);
    }

    /**
     * Retrieve all records PosTransactions.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of PosTransactions
     */
    public List<PosTransactions> select(int maxResult) {
        return dao.select("select a from PosTransactions a", PosTransactions.class, maxResult);
    }

    /**
     * Retrieve all records PosTransactions.
     *
     * @return A list of PosTransactions
     */
    public List<PosTransactions> selectAll() {
        return dao.selectAll("select a from PosTransactions a", PosTransactions.class);
    }

    /**
     * Create an PosTransactions.
     *
     * @param e the PosTransactions.
     * @return The same PosTransactions.
     */
    public PosTransactions create(PosTransactions e) {
        return dao.create(e);
    }

    /**
     * Update the PosTransactions.
     *
     * @param e the PosTransactions.
     * @return The same PosTransactions.
     */
    public PosTransactions update(PosTransactions e) {
        return dao.update(e);
    }
}
