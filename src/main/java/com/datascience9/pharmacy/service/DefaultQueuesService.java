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

import com.datascience9.pharmacy.dao.QueuesDao;
import com.datascience9.pharmacy.entity.Queues;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultQueuesService")
public class DefaultQueuesService implements QueuesService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final QueuesDao dao;

    @Inject
    @Named("DefaultQueuesDao")
    public DefaultQueuesService(final QueuesDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public Queues find(Integer id) {

        final Queues result = dao.find(id);
        logger.info("find(Queues) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<Queues> select(int maxResult) {
        final List<Queues> result = dao.select(maxResult);
        logger.info("select(Queues) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<Queues> selectAll() {
        final List<Queues> results = dao.selectAll();
        logger.info("selectAll(Queues) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public Queues create(Queues bean) {
        requireNonNull(bean);
        logger.info("create(Queues={}) - entered bean ");

        final Queues result = dao.create(bean);

        logger.info("create(Queues) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Queues update(Queues bean) {
        requireNonNull(bean);
        logger.info("update(Queues={}) - entered bean ");

        final Queues result = dao.update(bean);

        logger.info("update(Queues) - exited - return value={} result ");
        return result;
    }
}
