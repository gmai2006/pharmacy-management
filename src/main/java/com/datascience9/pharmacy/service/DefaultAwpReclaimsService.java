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

import com.datascience9.pharmacy.dao.AwpReclaimsDao;
import com.datascience9.pharmacy.entity.AwpReclaims;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultAwpReclaimsService")
public class DefaultAwpReclaimsService implements AwpReclaimsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final AwpReclaimsDao dao;

    @Inject
    @Named("DefaultAwpReclaimsDao")
    public DefaultAwpReclaimsService(final AwpReclaimsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public AwpReclaims find(Long id) {

        final AwpReclaims result = dao.find(id);
        logger.info("find(AwpReclaims) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<AwpReclaims> select(int maxResult) {
        final List<AwpReclaims> result = dao.select(maxResult);
        logger.info("select(AwpReclaims) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<AwpReclaims> selectAll() {
        final List<AwpReclaims> results = dao.selectAll();
        logger.info("selectAll(AwpReclaims) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public AwpReclaims create(AwpReclaims bean) {
        requireNonNull(bean);
        logger.info("create(AwpReclaims={}) - entered bean ");

        final AwpReclaims result = dao.create(bean);

        logger.info("create(AwpReclaims) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public AwpReclaims update(AwpReclaims bean) {
        requireNonNull(bean);
        logger.info("update(AwpReclaims={}) - entered bean ");

        final AwpReclaims result = dao.update(bean);

        logger.info("update(AwpReclaims) - exited - return value={} result ");
        return result;
    }
}
