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

import com.datascience9.pharmacy.entity.PatientInsurances;
import java.util.List;

public interface PatientInsurancesService {
    public PatientInsurances find(java.util.UUID id);

    /**
     * Select a list of PatientInsurances based on a given maximum number of returning records.
     *
     * @param maxResult : a specified maximum number of returned records.
     * @return PatientInsurances records.
     */
    public List<PatientInsurances> select(int maxResult);

    /**
     * Select all PatientInsurances.
     *
     * @return all PatientInsurances records.
     */
    public List<PatientInsurances> selectAll();

    /**
     * Create PatientInsurances.
     *
     * @param bean The PatientInsurances.
     * @return The PatientInsurances.
     */
    public PatientInsurances create(PatientInsurances bean);

    /**
     * Update a PatientInsurances.
     *
     * @param bean - The PatientInsurances.
     * @return PatientInsurances.
     */
    public PatientInsurances update(PatientInsurances bean);
}
