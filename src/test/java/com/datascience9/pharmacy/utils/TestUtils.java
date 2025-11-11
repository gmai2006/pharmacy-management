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
package com.datascience9.pharmacy.utils;

import java.text.SimpleDateFormat;
import java.util.logging.Logger;

/** Auto generated from a schema generated on $date$ */
public class TestUtils {
    private static final Logger LOGGER = Logger.getLogger(TestUtils.class.getName());

    /**
     * Get date object.
     *
     * @param d the date
     * @return a string value of a date object.
     */
    public static String getDateObject(java.util.Date d) {
        final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        return formater.format(d);
    }

    /**
     * Get time object.
     *
     * @param d the timestamp
     * @return a string value of a timestamp object.
     */
    public static String getTimeObject(java.sql.Timestamp d) {
        final SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        return formater.format(d);
    }
}
