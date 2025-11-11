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

import com.datascience9.pharmacy.dao.PatientAliasesDao;
import com.datascience9.pharmacy.entity.PatientAliases;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPatientAliasesService")
public class DefaultPatientAliasesService implements PatientAliasesService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PatientAliasesDao dao;

    @Inject
    @Named("DefaultPatientAliasesDao")
    public DefaultPatientAliasesService(final PatientAliasesDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public PatientAliases find(java.lang.Integer id) {

        final PatientAliases result = dao.find(id);
        logger.info("find(PatientAliases) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<PatientAliases> select(int maxResult) {
        final List<PatientAliases> result = dao.select(maxResult);
        logger.info("select(PatientAliases) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<PatientAliases> selectAll() {
        final List<PatientAliases> results = dao.selectAll();
        logger.info("selectAll(PatientAliases) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public PatientAliases create(PatientAliases bean) {
        requireNonNull(bean);
        logger.info("create(PatientAliases={}) - entered bean ");

        final PatientAliases result = dao.create(bean);

        logger.info("create(PatientAliases) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public PatientAliases update(PatientAliases bean) {
        requireNonNull(bean);
        logger.info("update(PatientAliases={}) - entered bean ");

        final PatientAliases result = dao.update(bean);

        logger.info("update(PatientAliases) - exited - return value={} result ");
        return result;
    }
}
