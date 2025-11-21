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

import com.datascience9.pharmacy.dao.PrescriptionsDao;
import com.datascience9.pharmacy.entity.Prescriptions;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPrescriptionsService")
public class DefaultPrescriptionsService implements PrescriptionsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PrescriptionsDao dao;

    @Inject
    @Named("DefaultPrescriptionsDao")
    public DefaultPrescriptionsService(final PrescriptionsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public Prescriptions find(java.util.UUID id) {

        final Prescriptions result = dao.find(id);
        logger.info("find(Prescriptions) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public java.util.UUID delete(java.util.UUID id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<Prescriptions> select(int maxResult) {
        final List<Prescriptions> result = dao.select(maxResult);
        logger.info("select(Prescriptions) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<Prescriptions> selectAll() {
        final List<Prescriptions> results = dao.selectAll();
        logger.info("selectAll(Prescriptions) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public Prescriptions create(Prescriptions bean) {
        requireNonNull(bean);
        bean.setId(UUID.randomUUID());
        final Prescriptions result = dao.create(bean);

        logger.info("create(Prescriptions) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Prescriptions update(Prescriptions bean) {
        requireNonNull(bean);
        logger.info("update(Prescriptions={}) - entered bean ");

        final Prescriptions result = dao.update(bean);

        logger.info("update(Prescriptions) - exited - return value={} result ");
        return result;
    }
}
