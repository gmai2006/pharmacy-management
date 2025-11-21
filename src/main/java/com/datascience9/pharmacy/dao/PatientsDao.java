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
import com.datascience9.pharmacy.entity.Patients;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("PatientsDao")
public class PatientsDao {
    private static final int BATCH_SIZE = 50;
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public PatientsDao(JpaDao dao) {
        this.dao = dao;
    }

    public PatientsDao() {}

    /**
     * Find an entity.
     *
     * @param id An Patients id.
     * @return The same Patients.
     */
    public Patients find(java.util.UUID id) {
        return dao.find(Patients.class, id);
    }

    /**
     * Delete an entity.
     *
     * @param id An Patients id.
     * @return The Id.
     */
    public java.util.UUID delete(java.util.UUID id) {
        dao.delete(Patients.class, id);
        return id;
    }

    /**
     * Retrieve all records Patients.
     *
     * @param maxResult a maximum number of returned records.
     * @return A list of Patients
     */
    public List<Patients> select(int maxResult) {
        return dao.select("select a from Patients a", Patients.class, maxResult);
    }

    /**
     * Retrieve all records Patients.
     *
     * @return A list of Patients
     */
    public List<Patients> selectAll() {
        return dao.selectAll("select a from Patients a", Patients.class);
    }

    /**
     * Create an Patients.
     *
     * @param e the Patients.
     * @return The same Patients.
     */
    public Patients create(Patients e) {
        return dao.create(e);
    }

    /**
     * Update the Patients.
     *
     * @param e the Patients.
     * @return The same Patients.
     */
    public Patients update(Patients e) {
        return dao.update(e);
    }

    public List<Patients> searchPatients(String firstName, String lastName, LocalDateTime dob) {

        // Normalize whitespace
        firstName = normalize(firstName);
        lastName = normalize(lastName);

        StringBuilder jpql = new StringBuilder("SELECT p FROM Patients p");
        boolean hasCondition = false;

        if (firstName != null) {
            jpql.append(" WHERE LOWER(p.firstName) LIKE LOWER(CONCAT(:firstName, '%'))");
            hasCondition = true;
        }

        if (lastName != null) {
            jpql.append(hasCondition ? " AND" : " WHERE");
            jpql.append(" LOWER(p.lastName) LIKE LOWER(CONCAT(:lastName, '%'))");
            hasCondition = true;
        }

        if (dob != null) {
            jpql.append(hasCondition ? " AND" : " WHERE");
            jpql.append(" p.dob = :dob");
            hasCondition = true;
        }

        TypedQuery<Patients> query =
                dao.getEntityManager().createQuery(jpql.toString(), Patients.class);

        if (firstName != null) {
            query.setParameter("firstName", firstName);
        }
        if (lastName != null) {
            query.setParameter("lastName", lastName);
        }
        if (dob != null) {
            query.setParameter("dob", dob);
        }

        return query.getResultList();
    }

    private String normalize(String input) {
        if (input == null) return null;
        String trimmed = input.trim();
        if (trimmed.isEmpty()) return null;
        return trimmed.replaceAll("\\s+", " "); // collapse multiple spaces
    }
}
