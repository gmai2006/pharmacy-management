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

import com.datascience9.pharmacy.dao.UserPermissionsDao;
import com.datascience9.pharmacy.entity.UserPermissions;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultUserPermissionsService")
public class DefaultUserPermissionsService implements UserPermissionsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final UserPermissionsDao dao;

    @Inject
    @Named("DefaultUserPermissionsDao")
    public DefaultUserPermissionsService(final UserPermissionsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public UserPermissions find(Integer id) {

        final UserPermissions result = dao.find(id);
        logger.info("find(UserPermissions) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<UserPermissions> select(int maxResult) {
        final List<UserPermissions> result = dao.select(maxResult);
        logger.info("select(UserPermissions) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<UserPermissions> selectAll() {
        final List<UserPermissions> results = dao.selectAll();
        logger.info("selectAll(UserPermissions) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public UserPermissions create(UserPermissions bean) {
        requireNonNull(bean);
        logger.info("create(UserPermissions={}) - entered bean ");

        final UserPermissions result = dao.create(bean);

        logger.info("create(UserPermissions) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public UserPermissions update(UserPermissions bean) {
        requireNonNull(bean);
        logger.info("update(UserPermissions={}) - entered bean ");

        final UserPermissions result = dao.update(bean);

        logger.info("update(UserPermissions) - exited - return value={} result ");
        return result;
    }
}
