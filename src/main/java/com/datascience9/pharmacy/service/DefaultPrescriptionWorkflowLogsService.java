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

import com.datascience9.pharmacy.dao.PrescriptionWorkflowLogsDao;
import com.datascience9.pharmacy.entity.PrescriptionWorkflowLogs;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPrescriptionWorkflowLogsService")
public class DefaultPrescriptionWorkflowLogsService implements PrescriptionWorkflowLogsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PrescriptionWorkflowLogsDao dao;

    @Inject
    @Named("DefaultPrescriptionWorkflowLogsDao")
    public DefaultPrescriptionWorkflowLogsService(final PrescriptionWorkflowLogsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public PrescriptionWorkflowLogs find(Long id) {

        final PrescriptionWorkflowLogs result = dao.find(id);
        logger.info("find(PrescriptionWorkflowLogs) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Long delete(Long id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<PrescriptionWorkflowLogs> select(int maxResult) {
        final List<PrescriptionWorkflowLogs> result = dao.select(maxResult);
        logger.info("select(PrescriptionWorkflowLogs) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<PrescriptionWorkflowLogs> selectAll() {
        final List<PrescriptionWorkflowLogs> results = dao.selectAll();
        logger.info("selectAll(PrescriptionWorkflowLogs) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public PrescriptionWorkflowLogs create(PrescriptionWorkflowLogs bean) {
        requireNonNull(bean);
        bean.setChangedAt(LocalDateTime.now());
        final PrescriptionWorkflowLogs result = dao.create(bean);

        logger.info("create(PrescriptionWorkflowLogs) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public PrescriptionWorkflowLogs update(PrescriptionWorkflowLogs bean) {
        requireNonNull(bean);
        logger.info("update(PrescriptionWorkflowLogs={}) - entered bean ");

        final PrescriptionWorkflowLogs result = dao.update(bean);

        logger.info("update(PrescriptionWorkflowLogs) - exited - return value={} result ");
        return result;
    }
}
