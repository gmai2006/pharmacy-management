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

import com.datascience9.pharmacy.dao.IntegrationsDao;
import com.datascience9.pharmacy.entity.Integrations;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultIntegrationsService")
public class DefaultIntegrationsService implements IntegrationsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final IntegrationsDao dao;

    @Inject
    @Named("DefaultIntegrationsDao")
    public DefaultIntegrationsService(final IntegrationsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public Integrations find(java.lang.Integer id) {

        final Integrations result = dao.find(id);
        logger.info("find(Integrations) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<Integrations> select(int maxResult) {
        final List<Integrations> result = dao.select(maxResult);
        logger.info("select(Integrations) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<Integrations> selectAll() {
        final List<Integrations> results = dao.selectAll();
        logger.info("selectAll(Integrations) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public Integrations create(Integrations bean) {
        requireNonNull(bean);
        logger.info("create(Integrations={}) - entered bean ");

        final Integrations result = dao.create(bean);

        logger.info("create(Integrations) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Integrations update(Integrations bean) {
        requireNonNull(bean);
        logger.info("update(Integrations={}) - entered bean ");

        final Integrations result = dao.update(bean);

        logger.info("update(Integrations) - exited - return value={} result ");
        return result;
    }
}
