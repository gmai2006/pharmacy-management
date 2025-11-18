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
package com.datascience9.pharmacy.service.manual;

import static java.util.Objects.requireNonNull;

import com.datascience9.pharmacy.dao.manual.ViewDao;
import com.datascience9.pharmacy.entity.manual.*;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Stateless
@Named("DefaultViewService")
public class DefaultViewService implements ViewService {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private final ViewDao dao;

    @Inject
    @Named("ViewDao")
    public DefaultViewService(final ViewDao dao) {
        requireNonNull(dao);
        this.dao = dao;
    }

    @Override
    public List<PrescriptionSummary> selectPrescriptionSummary(int max) {
        return dao.selectPrescriptionSummary(max);
    }

    @Override
    public PrescriptionSummary findById(UUID id) {
        return dao.findById(id);
    }

    @Override
    public List<InventoryOverview> selectAllInventoryOverviews(int max) {
        return dao.selectAllInventoryOverviews(max);
    }

    @Override
    public List<AlertLogDetailsView> selectAlertLogView(int max) {
        return dao.selectAlertLogView(max);
    }

    @Override
    public List<TransactionSummary> selectTransactionSummary(int max) {
        return dao.selectTransactionSummary(max);
    }

    @Override
    public List<InventoryOverview> reorderInventoryNeeded() {
        return dao.reorderInventoryNeeded();
    }

    @Override
    public List<InventoryOverview> expiringInventory() {
        return dao.expiringInventory();
    }

    @Override
    public List<ClaimProcessing> selectClaimProcessing(int max) {
        return dao.selectClaimProcessing(max);
    }
}
