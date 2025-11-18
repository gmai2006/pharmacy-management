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

import com.datascience9.pharmacy.entity.manual.*;
import java.util.List;
import java.util.UUID;

public interface ViewService {
    public List<PrescriptionSummary> selectPrescriptionSummary(int max);

    public PrescriptionSummary findById(UUID id);

    List<InventoryOverview> selectAllInventoryOverviews(int max);

    List<AlertLogDetailsView> selectAlertLogView(int max);

    List<TransactionSummary> selectTransactionSummary(int max);

    List<InventoryOverview> reorderInventoryNeeded();

    List<InventoryOverview> expiringInventory();

    List<ClaimProcessing> selectClaimProcessing(int max);
}
