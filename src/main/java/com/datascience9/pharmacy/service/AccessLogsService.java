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

import com.datascience9.pharmacy.entity.AccessLogs;
import java.util.List;

public interface AccessLogsService {
    public AccessLogs find(java.lang.Long id);

    /**
     * Select a list of AccessLogs based on a given maximum number of returning records.
     *
     * @param maxResult : a specified maximum number of returned records.
     * @return AccessLogs records.
     */
    public List<AccessLogs> select(int maxResult);

    /**
     * Select all AccessLogs.
     *
     * @return all AccessLogs records.
     */
    public List<AccessLogs> selectAll();

    /**
     * Create AccessLogs.
     *
     * @param bean The AccessLogs.
     * @return The AccessLogs.
     */
    public AccessLogs create(AccessLogs bean);

    /**
     * Update a AccessLogs.
     *
     * @param bean - The AccessLogs.
     * @return AccessLogs.
     */
    public AccessLogs update(AccessLogs bean);
}
