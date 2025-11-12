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

import com.datascience9.pharmacy.dao.PrescriptionCopaysDao;
import com.datascience9.pharmacy.entity.PrescriptionCopays;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPrescriptionCopaysService")
public class DefaultPrescriptionCopaysService implements PrescriptionCopaysService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PrescriptionCopaysDao dao;

    @Inject
    @Named("DefaultPrescriptionCopaysDao")
    public DefaultPrescriptionCopaysService(final PrescriptionCopaysDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public PrescriptionCopays find(java.util.UUID id) {

        final PrescriptionCopays result = dao.find(id);
        logger.info("find(PrescriptionCopays) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<PrescriptionCopays> select(int maxResult) {
        final List<PrescriptionCopays> result = dao.select(maxResult);
        logger.info("select(PrescriptionCopays) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<PrescriptionCopays> selectAll() {
        final List<PrescriptionCopays> results = dao.selectAll();
        logger.info("selectAll(PrescriptionCopays) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public PrescriptionCopays create(PrescriptionCopays bean) {
        requireNonNull(bean);
        logger.info("create(PrescriptionCopays={}) - entered bean ");

        final PrescriptionCopays result = dao.create(bean);

        logger.info("create(PrescriptionCopays) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public PrescriptionCopays update(PrescriptionCopays bean) {
        requireNonNull(bean);
        logger.info("update(PrescriptionCopays={}) - entered bean ");

        final PrescriptionCopays result = dao.update(bean);

        logger.info("update(PrescriptionCopays) - exited - return value={} result ");
        return result;
    }
}
