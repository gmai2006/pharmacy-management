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

import com.datascience9.pharmacy.dao.EncryptionKeysMetaDao;
import com.datascience9.pharmacy.entity.EncryptionKeysMeta;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultEncryptionKeysMetaService")
public class DefaultEncryptionKeysMetaService implements EncryptionKeysMetaService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final EncryptionKeysMetaDao dao;

    @Inject
    @Named("DefaultEncryptionKeysMetaDao")
    public DefaultEncryptionKeysMetaService(final EncryptionKeysMetaDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public EncryptionKeysMeta find(java.lang.Integer id) {

        final EncryptionKeysMeta result = dao.find(id);
        logger.info("find(EncryptionKeysMeta) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<EncryptionKeysMeta> select(int maxResult) {
        final List<EncryptionKeysMeta> result = dao.select(maxResult);
        logger.info("select(EncryptionKeysMeta) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<EncryptionKeysMeta> selectAll() {
        final List<EncryptionKeysMeta> results = dao.selectAll();
        logger.info("selectAll(EncryptionKeysMeta) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public EncryptionKeysMeta create(EncryptionKeysMeta bean) {
        requireNonNull(bean);
        logger.info("create(EncryptionKeysMeta={}) - entered bean ");

        final EncryptionKeysMeta result = dao.create(bean);

        logger.info("create(EncryptionKeysMeta) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public EncryptionKeysMeta update(EncryptionKeysMeta bean) {
        requireNonNull(bean);
        logger.info("update(EncryptionKeysMeta={}) - entered bean ");

        final EncryptionKeysMeta result = dao.update(bean);

        logger.info("update(EncryptionKeysMeta) - exited - return value={} result ");
        return result;
    }
}
