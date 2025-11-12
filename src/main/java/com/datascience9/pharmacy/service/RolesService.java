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

import com.datascience9.pharmacy.entity.Roles;
import java.util.List;

public interface RolesService {
    public Roles find(Integer id);

    /**
     * Select a list of Roles based on a given maximum number of returning records.
     *
     * @param maxResult : a specified maximum number of returned records.
     * @return Roles records.
     */
    public List<Roles> select(int maxResult);

    /**
     * Select all Roles.
     *
     * @return all Roles records.
     */
    public List<Roles> selectAll();

    /**
     * Create Roles.
     *
     * @param bean The Roles.
     * @return The Roles.
     */
    public Roles create(Roles bean);

    /**
     * Update a Roles.
     *
     * @param bean - The Roles.
     * @return Roles.
     */
    public Roles update(Roles bean);
}
