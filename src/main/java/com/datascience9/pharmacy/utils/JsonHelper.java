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

import com.datascience9.pharmacy.entity.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.Objects;

/** Auto generated from a schema generated on $date$ */
public class JsonHelper {
    static final Gson gson =
            new GsonBuilder()
                    .registerTypeHierarchyAdapter(byte[].class, new ByteArrayToBase64TypeAdapter())
                    .setDateFormat("yyyy-MM-dd HH:mm:ss.S")
                    .create();

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Roles.
     */
    public static Roles fromJson2Roles(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Roles.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Users.
     */
    public static Users fromJson2Users(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Users.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The UserSso.
     */
    public static UserSso fromJson2UserSso(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, UserSso.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The UserPermissions.
     */
    public static UserPermissions fromJson2UserPermissions(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, UserPermissions.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Patients.
     */
    public static Patients fromJson2Patients(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Patients.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The PatientAliases.
     */
    public static PatientAliases fromJson2PatientAliases(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, PatientAliases.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Pharmacists.
     */
    public static Pharmacists fromJson2Pharmacists(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Pharmacists.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Wholesalers.
     */
    public static Wholesalers fromJson2Wholesalers(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Wholesalers.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The InventoryItems.
     */
    public static InventoryItems fromJson2InventoryItems(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, InventoryItems.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The InventoryBatches.
     */
    public static InventoryBatches fromJson2InventoryBatches(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, InventoryBatches.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The DscsaSerials.
     */
    public static DscsaSerials fromJson2DscsaSerials(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, DscsaSerials.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The ReorderRules.
     */
    public static ReorderRules fromJson2ReorderRules(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, ReorderRules.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The PurchaseOrders.
     */
    public static PurchaseOrders fromJson2PurchaseOrders(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, PurchaseOrders.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Prescriptions.
     */
    public static Prescriptions fromJson2Prescriptions(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Prescriptions.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The PrescriptionItems.
     */
    public static PrescriptionItems fromJson2PrescriptionItems(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, PrescriptionItems.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The PrescriptionTransfers.
     */
    public static PrescriptionTransfers fromJson2PrescriptionTransfers(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, PrescriptionTransfers.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The PrescriptionAudit.
     */
    public static PrescriptionAudit fromJson2PrescriptionAudit(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, PrescriptionAudit.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Workflows.
     */
    public static Workflows fromJson2Workflows(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Workflows.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The WorkflowSteps.
     */
    public static WorkflowSteps fromJson2WorkflowSteps(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, WorkflowSteps.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Queues.
     */
    public static Queues fromJson2Queues(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Queues.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Tasks.
     */
    public static Tasks fromJson2Tasks(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Tasks.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The TaskRouting.
     */
    public static TaskRouting fromJson2TaskRouting(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, TaskRouting.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The BarcodeLabels.
     */
    public static BarcodeLabels fromJson2BarcodeLabels(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, BarcodeLabels.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The PosTransactions.
     */
    public static PosTransactions fromJson2PosTransactions(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, PosTransactions.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The PosSignatures.
     */
    public static PosSignatures fromJson2PosSignatures(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, PosSignatures.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Payments.
     */
    public static Payments fromJson2Payments(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Payments.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Claims.
     */
    public static Claims fromJson2Claims(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Claims.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The DirFees.
     */
    public static DirFees fromJson2DirFees(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, DirFees.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The AwpReclaims.
     */
    public static AwpReclaims fromJson2AwpReclaims(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, AwpReclaims.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The ProfitAuditWarnings.
     */
    public static ProfitAuditWarnings fromJson2ProfitAuditWarnings(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, ProfitAuditWarnings.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The AlertRules.
     */
    public static AlertRules fromJson2AlertRules(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, AlertRules.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The AlertLogs.
     */
    public static AlertLogs fromJson2AlertLogs(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, AlertLogs.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Integrations.
     */
    public static Integrations fromJson2Integrations(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Integrations.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The IntegrationEvents.
     */
    public static IntegrationEvents fromJson2IntegrationEvents(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, IntegrationEvents.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The Reports.
     */
    public static Reports fromJson2Reports(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, Reports.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The AuditLogs.
     */
    public static AuditLogs fromJson2AuditLogs(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, AuditLogs.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The ConsentRecords.
     */
    public static ConsentRecords fromJson2ConsentRecords(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, ConsentRecords.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The EncryptionKeysMeta.
     */
    public static EncryptionKeysMeta fromJson2EncryptionKeysMeta(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, EncryptionKeysMeta.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The PdmpQueries.
     */
    public static PdmpQueries fromJson2PdmpQueries(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, PdmpQueries.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The AccessLogs.
     */
    public static AccessLogs fromJson2AccessLogs(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, AccessLogs.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The EfaxRecipients.
     */
    public static EfaxRecipients fromJson2EfaxRecipients(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, EfaxRecipients.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The EfaxJobs.
     */
    public static EfaxJobs fromJson2EfaxJobs(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, EfaxJobs.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The EfaxAttachments.
     */
    public static EfaxAttachments fromJson2EfaxAttachments(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, EfaxAttachments.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The EfaxStatusLogs.
     */
    public static EfaxStatusLogs fromJson2EfaxStatusLogs(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, EfaxStatusLogs.class);
    }

    /**
     * Helper function that converts JSON to an POJO.
     *
     * @param json The JSON string.
     * @return The EfaxIncoming.
     */
    public static EfaxIncoming fromJson2EfaxIncoming(JsonElement json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, EfaxIncoming.class);
    }

    /**
     * Helper function that converts JSON to an JSON array.
     *
     * @param json The JSON string.
     * @return an JSON array.
     */
    public static JsonArray fromJson2Arr(String json) {
        Objects.requireNonNull(json);
        return gson.fromJson(json, JsonArray.class);
    }
}
