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

import com.datascience9.pharmacy.dao.DeviceFingerprintsDao;
import com.datascience9.pharmacy.entity.DeviceFingerprints;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
@Stateless
@Named("DefaultDeviceFingerprintsService")
public class DefaultDeviceFingerprintsService implements DeviceFingerprintsService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final DeviceFingerprintsDao dao;

    @Inject
    @Named("DefaultDeviceFingerprintsDao")
    public DefaultDeviceFingerprintsService(final DeviceFingerprintsDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    /** {@inheritDoc} */
    @Override
    public DeviceFingerprints find(Integer id) {

        final DeviceFingerprints result = dao.find(id);
        logger.info("find(DeviceFingerprints) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public Integer delete(Integer id) {
        return dao.delete(id);
    }

    /** {@inheritDoc} */
    public List<DeviceFingerprints> select(int maxResult) {
        final List<DeviceFingerprints> result = dao.select(maxResult);
        logger.info("select(DeviceFingerprints) - exited - return value={} result ");

        return result;
    }

    /** {@inheritDoc} */
    public List<DeviceFingerprints> selectAll() {
        final List<DeviceFingerprints> results = dao.selectAll();
        logger.info("selectAll(DeviceFingerprints) - exited - return value={} result ");
        return results;
    }

    /** {@inheritDoc} */
    @Override
    public DeviceFingerprints create(DeviceFingerprints bean) {
        requireNonNull(bean);
        logger.info("create(DeviceFingerprints={}) - entered bean ");

        final DeviceFingerprints result = dao.create(bean);

        logger.info("create(DeviceFingerprints) - exited - return value={} result ");
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public DeviceFingerprints update(DeviceFingerprints bean) {
        requireNonNull(bean);
        logger.info("update(DeviceFingerprints={}) - entered bean ");

        final DeviceFingerprints result = dao.update(bean);

        logger.info("update(DeviceFingerprints) - exited - return value={} result ");
        return result;
    }
}
