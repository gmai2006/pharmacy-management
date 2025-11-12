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

import com.datascience9.pharmacy.entity.ProfitAuditWarnings;
import java.util.List;

public interface ProfitAuditWarningsService {
    public ProfitAuditWarnings find(Long id);

    /**
     * Select a list of ProfitAuditWarnings based on a given maximum number of returning records.
     *
     * @param maxResult : a specified maximum number of returned records.
     * @return ProfitAuditWarnings records.
     */
    public List<ProfitAuditWarnings> select(int maxResult);

    /**
     * Select all ProfitAuditWarnings.
     *
     * @return all ProfitAuditWarnings records.
     */
    public List<ProfitAuditWarnings> selectAll();

    /**
     * Create ProfitAuditWarnings.
     *
     * @param bean The ProfitAuditWarnings.
     * @return The ProfitAuditWarnings.
     */
    public ProfitAuditWarnings create(ProfitAuditWarnings bean);

    /**
     * Update a ProfitAuditWarnings.
     *
     * @param bean - The ProfitAuditWarnings.
     * @return ProfitAuditWarnings.
     */
    public ProfitAuditWarnings update(ProfitAuditWarnings bean);
}
