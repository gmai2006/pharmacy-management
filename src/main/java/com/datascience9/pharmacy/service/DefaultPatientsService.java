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
package com.datascience9.pharmacy.service;

import static java.util.Objects.requireNonNull;

import com.datascience9.pharmacy.dao.PatientsDao;
import com.datascience9.pharmacy.entity.Patients;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPatientsService")
public class DefaultPatientsService implements PatientsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PatientsDao dao;

    @Inject
    @Named("DefaultPatientsDao")
    public DefaultPatientsService(final PatientsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public Patients find(java.util.UUID id) {

        final Patients result = dao.find(id);
        logger.info("find(Patients) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public java.util.UUID delete(java.util.UUID id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<Patients> select(int maxResult) {
        final List<Patients> result = dao.select(maxResult);
        logger.info("select(Patients) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<Patients> selectAll() {
        final List<Patients> results = dao.selectAll();
        logger.info("selectAll(Patients) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public Patients create(Patients bean) {
        requireNonNull(bean);
        logger.info("create(Patients={}) - entered bean ");
        bean.setId(UUID.randomUUID());
        bean.setCreatedAt(java.time.LocalDateTime.now());
        final Patients result = dao.create(bean);

        logger.info("create(Patients) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Patients update(Patients bean) {
        requireNonNull(bean);
        logger.info("update(Patients={}) - entered bean ");

        final Patients result = dao.update(bean);

        logger.info("update(Patients) - exited - return value={} result ");
        return result;
    }
}
