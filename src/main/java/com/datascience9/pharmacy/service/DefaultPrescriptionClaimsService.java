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

import com.datascience9.pharmacy.dao.PrescriptionClaimsDao;
import com.datascience9.pharmacy.entity.PrescriptionClaims;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPrescriptionClaimsService")
public class DefaultPrescriptionClaimsService implements PrescriptionClaimsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PrescriptionClaimsDao dao;

    @Inject
    @Named("DefaultPrescriptionClaimsDao")
    public DefaultPrescriptionClaimsService(final PrescriptionClaimsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public PrescriptionClaims find(java.util.UUID id) {

        final PrescriptionClaims result = dao.find(id);
        logger.info("find(PrescriptionClaims) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<PrescriptionClaims> select(int maxResult) {
        final List<PrescriptionClaims> result = dao.select(maxResult);
        logger.info("select(PrescriptionClaims) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<PrescriptionClaims> selectAll() {
        final List<PrescriptionClaims> results = dao.selectAll();
        logger.info("selectAll(PrescriptionClaims) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public PrescriptionClaims create(PrescriptionClaims bean) {
        requireNonNull(bean);
        logger.info("create(PrescriptionClaims={}) - entered bean ");

        final PrescriptionClaims result = dao.create(bean);

        logger.info("create(PrescriptionClaims) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public PrescriptionClaims update(PrescriptionClaims bean) {
        requireNonNull(bean);
        logger.info("update(PrescriptionClaims={}) - entered bean ");

        final PrescriptionClaims result = dao.update(bean);

        logger.info("update(PrescriptionClaims) - exited - return value={} result ");
        return result;
    }
}
