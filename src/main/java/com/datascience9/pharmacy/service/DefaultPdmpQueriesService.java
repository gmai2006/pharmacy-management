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

import com.datascience9.pharmacy.dao.PdmpQueriesDao;
import com.datascience9.pharmacy.entity.PdmpQueries;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPdmpQueriesService")
public class DefaultPdmpQueriesService implements PdmpQueriesService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PdmpQueriesDao dao;

    @Inject
    @Named("DefaultPdmpQueriesDao")
    public DefaultPdmpQueriesService(final PdmpQueriesDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public PdmpQueries find(java.util.UUID id) {

        final PdmpQueries result = dao.find(id);
        logger.info("find(PdmpQueries) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public java.util.UUID delete(java.util.UUID id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<PdmpQueries> select(int maxResult) {
        final List<PdmpQueries> result = dao.select(maxResult);
        logger.info("select(PdmpQueries) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<PdmpQueries> selectAll() {
        final List<PdmpQueries> results = dao.selectAll();
        logger.info("selectAll(PdmpQueries) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public PdmpQueries create(PdmpQueries bean) {
        requireNonNull(bean);
        logger.info("create(PdmpQueries={}) - entered bean ");

        final PdmpQueries result = dao.create(bean);

        logger.info("create(PdmpQueries) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public PdmpQueries update(PdmpQueries bean) {
        requireNonNull(bean);
        logger.info("update(PdmpQueries={}) - entered bean ");

        final PdmpQueries result = dao.update(bean);

        logger.info("update(PdmpQueries) - exited - return value={} result ");
        return result;
    }
}
