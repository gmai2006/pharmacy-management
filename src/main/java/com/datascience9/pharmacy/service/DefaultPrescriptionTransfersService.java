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

import com.datascience9.pharmacy.dao.PrescriptionTransfersDao;
import com.datascience9.pharmacy.entity.PrescriptionTransfers;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPrescriptionTransfersService")
public class DefaultPrescriptionTransfersService implements PrescriptionTransfersService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PrescriptionTransfersDao dao;

    @Inject
    @Named("DefaultPrescriptionTransfersDao")
    public DefaultPrescriptionTransfersService(final PrescriptionTransfersDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public PrescriptionTransfers find(java.util.UUID id) {

        final PrescriptionTransfers result = dao.find(id);
        logger.info("find(PrescriptionTransfers) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<PrescriptionTransfers> select(int maxResult) {
        final List<PrescriptionTransfers> result = dao.select(maxResult);
        logger.info("select(PrescriptionTransfers) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<PrescriptionTransfers> selectAll() {
        final List<PrescriptionTransfers> results = dao.selectAll();
        logger.info("selectAll(PrescriptionTransfers) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public PrescriptionTransfers create(PrescriptionTransfers bean) {
        requireNonNull(bean);
        logger.info("create(PrescriptionTransfers={}) - entered bean ");

        final PrescriptionTransfers result = dao.create(bean);

        logger.info("create(PrescriptionTransfers) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public PrescriptionTransfers update(PrescriptionTransfers bean) {
        requireNonNull(bean);
        logger.info("update(PrescriptionTransfers={}) - entered bean ");

        final PrescriptionTransfers result = dao.update(bean);

        logger.info("update(PrescriptionTransfers) - exited - return value={} result ");
        return result;
    }
}
