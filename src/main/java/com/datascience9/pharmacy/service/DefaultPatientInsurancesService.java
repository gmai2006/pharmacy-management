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

import com.datascience9.pharmacy.dao.PatientInsurancesDao;
import com.datascience9.pharmacy.entity.PatientInsurances;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPatientInsurancesService")
public class DefaultPatientInsurancesService implements PatientInsurancesService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PatientInsurancesDao dao;

    @Inject
    @Named("DefaultPatientInsurancesDao")
    public DefaultPatientInsurancesService(final PatientInsurancesDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public PatientInsurances find(java.util.UUID id) {

        final PatientInsurances result = dao.find(id);
        logger.info("find(PatientInsurances) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public java.util.UUID delete(java.util.UUID id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<PatientInsurances> select(int maxResult) {
        final List<PatientInsurances> result = dao.select(maxResult);
        logger.info("select(PatientInsurances) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<PatientInsurances> selectAll() {
        final List<PatientInsurances> results = dao.selectAll();
        logger.info("selectAll(PatientInsurances) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public PatientInsurances create(PatientInsurances bean) {
        requireNonNull(bean);
        logger.info("create(PatientInsurances={}) - entered bean ");

        final PatientInsurances result = dao.create(bean);

        logger.info("create(PatientInsurances) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public PatientInsurances update(PatientInsurances bean) {
        requireNonNull(bean);
        logger.info("update(PatientInsurances={}) - entered bean ");

        final PatientInsurances result = dao.update(bean);

        logger.info("update(PatientInsurances) - exited - return value={} result ");
        return result;
    }
}
