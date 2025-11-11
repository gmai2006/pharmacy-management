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
package com.datascience9.pharmacy.api.core;

import com.datascience9.pharmacy.dao.core.JpaDao;
import com.datascience9.pharmacy.service.*;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Path("/meta")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})

/** Auto generated from a schema generated on $date$ */
public class DatabaseMetaResource {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public DatabaseMetaResource() {}

    @Inject private RolesService service;

    @Inject
    @Named("DefaultJpaDao")
    JpaDao jpa;

    /**
     * hello.
     *
     * @return a hello.
     */
    @GET
    @Path("")
    public Response hello() {
        return Response.status(Response.Status.OK).entity(this.getClass().getName()).build();
    }

    /**
     * Select all tables.
     *
     * @return a list tables.
     */
    @GET
    @Path("tables")
    public List<String> selectAll() {
        List<String> result =
                Arrays.asList(
                        new String[] {
                            "Roles",
                            "Users",
                            "UserSso",
                            "UserPermissions",
                            "Patients",
                            "PatientAliases",
                            "Pharmacists",
                            "Wholesalers",
                            "InventoryItems",
                            "InventoryBatches",
                            "DscsaSerials",
                            "ReorderRules",
                            "PurchaseOrders",
                            "Prescriptions",
                            "PrescriptionItems",
                            "PrescriptionTransfers",
                            "PrescriptionAudit",
                            "Workflows",
                            "WorkflowSteps",
                            "Queues",
                            "Tasks",
                            "TaskRouting",
                            "BarcodeLabels",
                            "PosTransactions",
                            "PosSignatures",
                            "Payments",
                            "Claims",
                            "DirFees",
                            "AwpReclaims",
                            "ProfitAuditWarnings",
                            "AlertRules",
                            "AlertLogs",
                            "Integrations",
                            "IntegrationEvents",
                            "Reports",
                            "AuditLogs",
                            "ConsentRecords",
                            "EncryptionKeysMeta",
                            "PdmpQueries",
                            "AccessLogs",
                            "EfaxRecipients",
                            "EfaxJobs",
                            "EfaxAttachments",
                            "EfaxStatusLogs",
                            "EfaxIncoming",
                        });
        return result;
    }
}
