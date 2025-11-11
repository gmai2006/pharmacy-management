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

import com.datascience9.pharmacy.dao.AlertRulesDao;
import com.datascience9.pharmacy.entity.AlertRules;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultAlertRulesService")
public class DefaultAlertRulesService implements AlertRulesService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final AlertRulesDao dao;

    @Inject
    @Named("DefaultAlertRulesDao")
    public DefaultAlertRulesService(final AlertRulesDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public AlertRules find(java.lang.Integer id) {

        final AlertRules result = dao.find(id);
        logger.info("find(AlertRules) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<AlertRules> select(int maxResult) {
        final List<AlertRules> result = dao.select(maxResult);
        logger.info("select(AlertRules) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<AlertRules> selectAll() {
        final List<AlertRules> results = dao.selectAll();
        logger.info("selectAll(AlertRules) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public AlertRules create(AlertRules bean) {
        requireNonNull(bean);
        logger.info("create(AlertRules={}) - entered bean ");

        final AlertRules result = dao.create(bean);

        logger.info("create(AlertRules) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public AlertRules update(AlertRules bean) {
        requireNonNull(bean);
        logger.info("update(AlertRules={}) - entered bean ");

        final AlertRules result = dao.update(bean);

        logger.info("update(AlertRules) - exited - return value={} result ");
        return result;
    }
}
