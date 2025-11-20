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
package com.datascience9.pharmacy.dao.manual;

import com.datascience9.pharmacy.dao.core.JpaDao;
import com.datascience9.pharmacy.entity.AuthLogs;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
@Named("AuthLogDao")
public class AuthLogDao {

    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public AuthLogDao(JpaDao dao) {
        this.dao = dao;
    }

    public AuthLogDao() {}

    public List<AuthLogs> findLogs(
            int page,
            int size,
            String sort,
            String dir,
            String status,
            String q,
            OffsetDateTime from,
            OffsetDateTime to) {
        CriteriaBuilder cb = dao.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<AuthLogs> cq = cb.createQuery(AuthLogs.class);
        Root<AuthLogs> root = cq.from(AuthLogs.class);

        List<Predicate> predicates = new ArrayList<>();

        if (status != null && !status.isEmpty())
            predicates.add(cb.equal(root.get("status"), status));

        if (q != null && !q.isEmpty()) {
            predicates.add(
                    cb.or(
                            cb.like(cb.lower(root.get("username")), "%" + q.toLowerCase() + "%"),
                            cb.like(cb.lower(root.get("ipAddress")), "%" + q.toLowerCase() + "%"),
                            cb.like(cb.lower(root.get("userAgent")), "%" + q.toLowerCase() + "%")));
        }

        if (from != null) predicates.add(cb.greaterThanOrEqualTo(root.get("createdAt"), from));

        if (to != null) predicates.add(cb.lessThanOrEqualTo(root.get("createdAt"), to));

        cq.where(predicates.toArray(new Predicate[0]));

        if (sort != null) {
            cq.orderBy(
                    "desc".equalsIgnoreCase(dir)
                            ? cb.desc(root.get(sort))
                            : cb.asc(root.get(sort)));
        }

        return dao.getEntityManager()
                .createQuery(cq)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .getResultList();
    }

    public long countLogs(String status, String q, OffsetDateTime from, OffsetDateTime to) {
        CriteriaBuilder cb = dao.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AuthLogs> root = cq.from(AuthLogs.class);

        List<Predicate> predicates = new ArrayList<>();

        if (status != null && !status.isEmpty())
            predicates.add(cb.equal(root.get("status"), status));

        if (q != null && !q.isEmpty()) {
            predicates.add(
                    cb.or(
                            cb.like(cb.lower(root.get("username")), "%" + q.toLowerCase() + "%"),
                            cb.like(cb.lower(root.get("ipAddress")), "%" + q.toLowerCase() + "%"),
                            cb.like(cb.lower(root.get("userAgent")), "%" + q.toLowerCase() + "%")));
        }

        if (from != null) predicates.add(cb.greaterThanOrEqualTo(root.get("createdAt"), from));

        if (to != null) predicates.add(cb.lessThanOrEqualTo(root.get("createdAt"), to));

        cq.select(cb.count(root)).where(predicates.toArray(Predicate[]::new));

        return dao.getEntityManager().createQuery(cq).getSingleResult();
    }
}
