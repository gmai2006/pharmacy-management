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

import com.datascience9.pharmacy.dao.UserSsoDao;
import com.datascience9.pharmacy.entity.UserSso;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultUserSsoService")
public class DefaultUserSsoService implements UserSsoService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final UserSsoDao dao;

    @Inject
    @Named("DefaultUserSsoDao")
    public DefaultUserSsoService(final UserSsoDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public UserSso find(java.util.UUID id) {

        final UserSso result = dao.find(id);
        logger.info("find(UserSso) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<UserSso> select(int maxResult) {
        final List<UserSso> result = dao.select(maxResult);
        logger.info("select(UserSso) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<UserSso> selectAll() {
        final List<UserSso> results = dao.selectAll();
        logger.info("selectAll(UserSso) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public UserSso create(UserSso bean) {
        requireNonNull(bean);
        logger.info("create(UserSso={}) - entered bean ");

        final UserSso result = dao.create(bean);

        logger.info("create(UserSso) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public UserSso update(UserSso bean) {
        requireNonNull(bean);
        logger.info("update(UserSso={}) - entered bean ");

        final UserSso result = dao.update(bean);

        logger.info("update(UserSso) - exited - return value={} result ");
        return result;
    }
}
