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

import com.datascience9.pharmacy.dao.BarcodeLabelsDao;
import com.datascience9.pharmacy.entity.BarcodeLabels;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultBarcodeLabelsService")
public class DefaultBarcodeLabelsService implements BarcodeLabelsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final BarcodeLabelsDao dao;

    @Inject
    @Named("DefaultBarcodeLabelsDao")
    public DefaultBarcodeLabelsService(final BarcodeLabelsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public BarcodeLabels find(java.util.UUID id) {

        final BarcodeLabels result = dao.find(id);
        logger.info("find(BarcodeLabels) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    public List<BarcodeLabels> select(int maxResult) {
        final List<BarcodeLabels> result = dao.select(maxResult);
        logger.info("select(BarcodeLabels) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<BarcodeLabels> selectAll() {
        final List<BarcodeLabels> results = dao.selectAll();
        logger.info("selectAll(BarcodeLabels) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public BarcodeLabels create(BarcodeLabels bean) {
        requireNonNull(bean);
        logger.info("create(BarcodeLabels={}) - entered bean ");

        final BarcodeLabels result = dao.create(bean);

        logger.info("create(BarcodeLabels) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public BarcodeLabels update(BarcodeLabels bean) {
        requireNonNull(bean);
        logger.info("update(BarcodeLabels={}) - entered bean ");

        final BarcodeLabels result = dao.update(bean);

        logger.info("update(BarcodeLabels) - exited - return value={} result ");
        return result;
    }
}
