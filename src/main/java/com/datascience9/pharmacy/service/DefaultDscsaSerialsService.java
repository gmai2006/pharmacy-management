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

import com.datascience9.pharmacy.dao.DscsaSerialsDao;
import com.datascience9.pharmacy.entity.DscsaSerials;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultDscsaSerialsService")
public class DefaultDscsaSerialsService implements DscsaSerialsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final DscsaSerialsDao dao;

    @Inject
    @Named("DefaultDscsaSerialsDao")
    public DefaultDscsaSerialsService(final DscsaSerialsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public DscsaSerials find(java.util.UUID id) {

        final DscsaSerials result = dao.find(id);
        logger.info("find(DscsaSerials) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<DscsaSerials> select(int maxResult) {
        final List<DscsaSerials> result = dao.select(maxResult);
        logger.info("select(DscsaSerials) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<DscsaSerials> selectAll() {
        final List<DscsaSerials> results = dao.selectAll();
        logger.info("selectAll(DscsaSerials) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public DscsaSerials create(DscsaSerials bean) {
        requireNonNull(bean);
        logger.info("create(DscsaSerials={}) - entered bean ");

        final DscsaSerials result = dao.create(bean);

        logger.info("create(DscsaSerials) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public DscsaSerials update(DscsaSerials bean) {
        requireNonNull(bean);
        logger.info("update(DscsaSerials={}) - entered bean ");

        final DscsaSerials result = dao.update(bean);

        logger.info("update(DscsaSerials) - exited - return value={} result ");
        return result;
    }
}
