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

import com.datascience9.pharmacy.dao.StationsDao;
import com.datascience9.pharmacy.entity.Stations;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultStationsService")
public class DefaultStationsService implements StationsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final StationsDao dao;

    @Inject
    @Named("DefaultStationsDao")
    public DefaultStationsService(final StationsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public Stations find(Integer id) {

        final Stations result = dao.find(id);
        logger.info("find(Stations) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Integer delete(Integer id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<Stations> select(int maxResult) {
        final List<Stations> result = dao.select(maxResult);
        logger.info("select(Stations) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<Stations> selectAll() {
        final List<Stations> results = dao.selectAll();
        logger.info("selectAll(Stations) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public Stations create(Stations bean) {
        requireNonNull(bean);
        logger.info("create(Stations={}) - entered bean ");

        final Stations result = dao.create(bean);

        logger.info("create(Stations) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Stations update(Stations bean) {
        requireNonNull(bean);
        logger.info("update(Stations={}) - entered bean ");

        final Stations result = dao.update(bean);

        logger.info("update(Stations) - exited - return value={} result ");
        return result;
    }
}
