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

import com.datascience9.pharmacy.dao.EfaxRecipientsDao;
import com.datascience9.pharmacy.entity.EfaxRecipients;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultEfaxRecipientsService")
public class DefaultEfaxRecipientsService implements EfaxRecipientsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final EfaxRecipientsDao dao;

    @Inject
    @Named("DefaultEfaxRecipientsDao")
    public DefaultEfaxRecipientsService(final EfaxRecipientsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public EfaxRecipients find(java.util.UUID id) {

        final EfaxRecipients result = dao.find(id);
        logger.info("find(EfaxRecipients) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<EfaxRecipients> select(int maxResult) {
        final List<EfaxRecipients> result = dao.select(maxResult);
        logger.info("select(EfaxRecipients) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<EfaxRecipients> selectAll() {
        final List<EfaxRecipients> results = dao.selectAll();
        logger.info("selectAll(EfaxRecipients) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public EfaxRecipients create(EfaxRecipients bean) {
        requireNonNull(bean);
        logger.info("create(EfaxRecipients={}) - entered bean ");

        final EfaxRecipients result = dao.create(bean);

        logger.info("create(EfaxRecipients) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public EfaxRecipients update(EfaxRecipients bean) {
        requireNonNull(bean);
        logger.info("update(EfaxRecipients={}) - entered bean ");

        final EfaxRecipients result = dao.update(bean);

        logger.info("update(EfaxRecipients) - exited - return value={} result ");
        return result;
    }
}
