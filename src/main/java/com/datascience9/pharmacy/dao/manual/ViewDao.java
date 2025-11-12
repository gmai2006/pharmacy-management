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
package com.datascience9.pharmacy.dao.manual;

import com.datascience9.pharmacy.dao.core.JpaDao;
import com.datascience9.pharmacy.entity.manual.PrescriptionSummary;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Stateless
@Named("ViewDao")
public class ViewDao {

    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private JpaDao dao;

    @Inject
    @Named("DefaultJpaDao")
    public ViewDao(JpaDao dao) {
        this.dao = dao;
    }

    public ViewDao() {}

    public List<PrescriptionSummary> select(int max) {
        return dao.select("SELECT p FROM PrescriptionSummary p", PrescriptionSummary.class, max);
    }

    public PrescriptionSummary findById(UUID id) {
        return dao.find(PrescriptionSummary.class, id);
    }
}
