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

import com.datascience9.pharmacy.dao.UsersDao;
import com.datascience9.pharmacy.entity.Users;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultUsersService")
public class DefaultUsersService implements UsersService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final UsersDao dao;

    @Inject
    @Named("DefaultUsersDao")
    public DefaultUsersService(final UsersDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public Users find(java.util.UUID id) {
        final Users result = dao.find(id);
        logger.info("find(Users) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public java.util.UUID delete(java.util.UUID id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<Users> select(int maxResult) {
        final List<Users> result = dao.select(maxResult);
        logger.info("select(Users) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<Users> selectAll() {
        final List<Users> results = dao.selectAll();
        logger.info("selectAll(Users) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public Users create(Users bean) {
        requireNonNull(bean);
        bean.setId(UUID.randomUUID());
        bean.setCreatedAt(new Timestamp(new Date().getTime()));
        final Users result = dao.create(bean);
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Users update(Users bean) {
        requireNonNull(bean);
        final Users result = dao.update(bean);
        return result;
    }
}
