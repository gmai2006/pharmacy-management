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

import com.datascience9.pharmacy.dao.IntegrationEventsDao;
import com.datascience9.pharmacy.entity.IntegrationEvents;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultIntegrationEventsService")
public class DefaultIntegrationEventsService implements IntegrationEventsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final IntegrationEventsDao dao;

    @Inject
    @Named("DefaultIntegrationEventsDao")
    public DefaultIntegrationEventsService(final IntegrationEventsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public IntegrationEvents find(java.util.UUID id) {

        final IntegrationEvents result = dao.find(id);
        logger.info("find(IntegrationEvents) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<IntegrationEvents> select(int maxResult) {
        final List<IntegrationEvents> result = dao.select(maxResult);
        logger.info("select(IntegrationEvents) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<IntegrationEvents> selectAll() {
        final List<IntegrationEvents> results = dao.selectAll();
        logger.info("selectAll(IntegrationEvents) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public IntegrationEvents create(IntegrationEvents bean) {
        requireNonNull(bean);
        logger.info("create(IntegrationEvents={}) - entered bean ");

        final IntegrationEvents result = dao.create(bean);

        logger.info("create(IntegrationEvents) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public IntegrationEvents update(IntegrationEvents bean) {
        requireNonNull(bean);
        logger.info("update(IntegrationEvents={}) - entered bean ");

        final IntegrationEvents result = dao.update(bean);

        logger.info("update(IntegrationEvents) - exited - return value={} result ");
        return result;
    }
}
