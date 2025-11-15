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
import com.datascience9.pharmacy.entity.EfaxRecipients;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("EfaxRecipientsDao")
public class EfaxRecipientsDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public EfaxRecipientsDao(JpaDao dao) {
        this.dao = dao;
    }

    public EfaxRecipientsDao() {}

    /**
     * Find an entity.
     *
     * @param id An EfaxRecipients id.
     * @return The same EfaxRecipients.
     */
    public EfaxRecipients find(java.util.UUID id) {
        return dao.find(EfaxRecipients.class, id);
    }

    /**
     * Delete an entity.
     *
     * @param id An EfaxRecipients id.
     * @return The Id.
     */
    public java.util.UUID delete(java.util.UUID id) {
        dao.delete(EfaxRecipients.class, id);
        return id;
    }

    /**
     * Retrieve all records EfaxRecipients.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of EfaxRecipients
     */
    public List<EfaxRecipients> select(int maxResult) {
        return dao.select("select a from EfaxRecipients a", EfaxRecipients.class, maxResult);
    }

    /**
     * Retrieve all records EfaxRecipients.
     *
     * @return A list of EfaxRecipients
     */
    public List<EfaxRecipients> selectAll() {
        return dao.selectAll("select a from EfaxRecipients a", EfaxRecipients.class);
    }

    /**
     * Create an EfaxRecipients.
     *
     * @param e the EfaxRecipients.
     * @return The same EfaxRecipients.
     */
    public EfaxRecipients create(EfaxRecipients e) {
        return dao.create(e);
    }

    /**
     * Update the EfaxRecipients.
     *
     * @param e the EfaxRecipients.
     * @return The same EfaxRecipients.
     */
    public EfaxRecipients update(EfaxRecipients e) {
        return dao.update(e);
    }
}
