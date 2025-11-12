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

import com.datascience9.pharmacy.dao.WholesalersDao;
import com.datascience9.pharmacy.entity.Wholesalers;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultWholesalersService")
public class DefaultWholesalersService implements WholesalersService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final WholesalersDao dao;

    @Inject
    @Named("DefaultWholesalersDao")
    public DefaultWholesalersService(final WholesalersDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public Wholesalers find(Integer id) {

        final Wholesalers result = dao.find(id);
        logger.info("find(Wholesalers) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<Wholesalers> select(int maxResult) {
        final List<Wholesalers> result = dao.select(maxResult);
        logger.info("select(Wholesalers) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<Wholesalers> selectAll() {
        final List<Wholesalers> results = dao.selectAll();
        logger.info("selectAll(Wholesalers) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public Wholesalers create(Wholesalers bean) {
        requireNonNull(bean);
        logger.info("create(Wholesalers={}) - entered bean ");

        final Wholesalers result = dao.create(bean);

        logger.info("create(Wholesalers) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Wholesalers update(Wholesalers bean) {
        requireNonNull(bean);
        logger.info("update(Wholesalers={}) - entered bean ");

        final Wholesalers result = dao.update(bean);

        logger.info("update(Wholesalers) - exited - return value={} result ");
        return result;
    }
}
