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

import com.datascience9.pharmacy.dao.InsuranceCompaniesDao;
import com.datascience9.pharmacy.entity.InsuranceCompanies;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultInsuranceCompaniesService")
public class DefaultInsuranceCompaniesService implements InsuranceCompaniesService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final InsuranceCompaniesDao dao;

    @Inject
    @Named("DefaultInsuranceCompaniesDao")
    public DefaultInsuranceCompaniesService(final InsuranceCompaniesDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public InsuranceCompanies find(java.util.UUID id) {

        final InsuranceCompanies result = dao.find(id);
        logger.info("find(InsuranceCompanies) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public java.util.UUID delete(java.util.UUID id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<InsuranceCompanies> select(int maxResult) {
        final List<InsuranceCompanies> result = dao.select(maxResult);
        logger.info("select(InsuranceCompanies) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<InsuranceCompanies> selectAll() {
        final List<InsuranceCompanies> results = dao.selectAll();
        logger.info("selectAll(InsuranceCompanies) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public InsuranceCompanies create(InsuranceCompanies bean) {
        requireNonNull(bean);
        logger.info("create(InsuranceCompanies={}) - entered bean ");

        final InsuranceCompanies result = dao.create(bean);

        logger.info("create(InsuranceCompanies) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public InsuranceCompanies update(InsuranceCompanies bean) {
        requireNonNull(bean);
        logger.info("update(InsuranceCompanies={}) - entered bean ");

        final InsuranceCompanies result = dao.update(bean);

        logger.info("update(InsuranceCompanies) - exited - return value={} result ");
        return result;
    }
}
