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

import com.datascience9.pharmacy.dao.PharmacistsDao;
import com.datascience9.pharmacy.entity.Pharmacists;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultPharmacistsService")
public class DefaultPharmacistsService implements PharmacistsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final PharmacistsDao dao;

    @Inject
    @Named("DefaultPharmacistsDao")
    public DefaultPharmacistsService(final PharmacistsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public Pharmacists find(java.util.UUID id) {

        final Pharmacists result = dao.find(id);
        logger.info("find(Pharmacists) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public java.util.UUID delete(java.util.UUID id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<Pharmacists> select(int maxResult) {
        final List<Pharmacists> result = dao.select(maxResult);
        logger.info("select(Pharmacists) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<Pharmacists> selectAll() {
        final List<Pharmacists> results = dao.selectAll();
        logger.info("selectAll(Pharmacists) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public Pharmacists create(Pharmacists bean) {
        requireNonNull(bean);
        logger.info("create(Pharmacists={}) - entered bean ");

        final Pharmacists result = dao.create(bean);

        logger.info("create(Pharmacists) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Pharmacists update(Pharmacists bean) {
        requireNonNull(bean);
        logger.info("update(Pharmacists={}) - entered bean ");

        final Pharmacists result = dao.update(bean);

        logger.info("update(Pharmacists) - exited - return value={} result ");
        return result;
    }
}
