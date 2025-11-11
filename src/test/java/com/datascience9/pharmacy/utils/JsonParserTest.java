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

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.datascience9.pharmacy.entity.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/** Auto generated from a schema generated on $date$ */
public class JsonParserTest {
    @Test
    public void testParsingRoles() throws IOException {
        final String inputFile = "Roles.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Roles> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Roles(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("id").getAsInt(), result.get(i).getId(), 0.0001);
            assertEquals(o.get("name").getAsString(), result.get(i).getName());
            assertEquals(o.get("description").getAsString(), result.get(i).getDescription());
        }

        result.clear();
    }

    @Test
    public void testParsingUsers() throws IOException {
        final String inputFile = "Users.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Users> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Users(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("username").getAsString(), result.get(i).getUsername());
            assertEquals(o.get("displayName").getAsString(), result.get(i).getDisplayName());
            assertEquals(o.get("email").getAsString(), result.get(i).getEmail());
            assertEquals(o.get("roleId").getAsInt(), result.get(i).getRoleId(), 0.0001);
            assertEquals(o.get("isActive").getAsBoolean(), result.get(i).getIsActive());
        }

        result.clear();
    }

    @Test
    public void testParsingUserSso() throws IOException {
        final String inputFile = "UserSso.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<UserSso> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2UserSso(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("provider").getAsString(), result.get(i).getProvider());
            assertEquals(o.get("externalId").getAsString(), result.get(i).getExternalId());
        }

        result.clear();
    }

    @Test
    public void testParsingUserPermissions() throws IOException {
        final String inputFile = "UserPermissions.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<UserPermissions> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2UserPermissions(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("id").getAsInt(), result.get(i).getId(), 0.0001);
            assertEquals(o.get("permissionKey").getAsString(), result.get(i).getPermissionKey());
            assertEquals(o.get("granted").getAsBoolean(), result.get(i).getGranted());
        }

        result.clear();
    }

    @Test
    public void testParsingPatients() throws IOException {
        final String inputFile = "Patients.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Patients> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Patients(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("mrn").getAsString(), result.get(i).getMrn());
            assertEquals(o.get("firstName").getAsString(), result.get(i).getFirstName());
            assertEquals(o.get("lastName").getAsString(), result.get(i).getLastName());
            assertEquals(o.get("gender").getAsString(), result.get(i).getGender());
            assertEquals(
                    o.get("isStudentRecord").getAsBoolean(), result.get(i).getIsStudentRecord());
            assertEquals(
                    o.get("preferredLanguage").getAsString(), result.get(i).getPreferredLanguage());
        }

        result.clear();
    }

    @Test
    public void testParsingPatientAliases() throws IOException {
        final String inputFile = "PatientAliases.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<PatientAliases> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2PatientAliases(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("id").getAsInt(), result.get(i).getId(), 0.0001);
            assertEquals(o.get("aliasType").getAsString(), result.get(i).getAliasType());
            assertEquals(o.get("aliasValue").getAsString(), result.get(i).getAliasValue());
        }

        result.clear();
    }

    @Test
    public void testParsingPharmacists() throws IOException {
        final String inputFile = "Pharmacists.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Pharmacists> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Pharmacists(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("licenseNumber").getAsString(), result.get(i).getLicenseNumber());
            assertEquals(o.get("licenseState").getAsString(), result.get(i).getLicenseState());
            assertEquals(o.get("active").getAsBoolean(), result.get(i).getActive());
        }

        result.clear();
    }

    @Test
    public void testParsingWholesalers() throws IOException {
        final String inputFile = "Wholesalers.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Wholesalers> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Wholesalers(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("id").getAsInt(), result.get(i).getId(), 0.0001);
            assertEquals(o.get("name").getAsString(), result.get(i).getName());
            assertEquals(
                    o.get("tradingPartnerId").getAsString(), result.get(i).getTradingPartnerId());
        }

        result.clear();
    }

    @Test
    public void testParsingInventoryItems() throws IOException {
        final String inputFile = "InventoryItems.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<InventoryItems> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2InventoryItems(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("ndc").getAsString(), result.get(i).getNdc());
            assertEquals(o.get("sku").getAsString(), result.get(i).getSku());
            assertEquals(o.get("name").getAsString(), result.get(i).getName());
            assertEquals(o.get("strength").getAsString(), result.get(i).getStrength());
            assertEquals(o.get("form").getAsString(), result.get(i).getForm());
            assertEquals(o.get("packSize").getAsInt(), result.get(i).getPackSize(), 0.0001);
            assertEquals(
                    o.get("reorderRuleId").getAsInt(), result.get(i).getReorderRuleId(), 0.0001);
        }

        result.clear();
    }

    @Test
    public void testParsingInventoryBatches() throws IOException {
        final String inputFile = "InventoryBatches.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<InventoryBatches> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2InventoryBatches(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("lotNumber").getAsString(), result.get(i).getLotNumber());
            assertEquals(
                    o.get("quantityOnHand").getAsInt(), result.get(i).getQuantityOnHand(), 0.0001);
            assertEquals(o.get("location").getAsString(), result.get(i).getLocation());
            assertEquals(o.get("wholesalerId").getAsInt(), result.get(i).getWholesalerId(), 0.0001);
        }

        result.clear();
    }

    @Test
    public void testParsingDscsaSerials() throws IOException {
        final String inputFile = "DscsaSerials.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<DscsaSerials> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2DscsaSerials(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("serialNumber").getAsString(), result.get(i).getSerialNumber());
            assertEquals(o.get("status").getAsString(), result.get(i).getStatus());
        }

        result.clear();
    }

    @Test
    public void testParsingReorderRules() throws IOException {
        final String inputFile = "ReorderRules.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<ReorderRules> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2ReorderRules(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("id").getAsInt(), result.get(i).getId(), 0.0001);
            assertEquals(o.get("minLevel").getAsInt(), result.get(i).getMinLevel(), 0.0001);
            assertEquals(o.get("maxLevel").getAsInt(), result.get(i).getMaxLevel(), 0.0001);
            assertEquals(
                    o.get("preferredWholesalers").getAsInt(),
                    result.get(i).getPreferredWholesalers(),
                    0.0001);
        }

        result.clear();
    }

    @Test
    public void testParsingPurchaseOrders() throws IOException {
        final String inputFile = "PurchaseOrders.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<PurchaseOrders> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2PurchaseOrders(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("wholesalerId").getAsInt(), result.get(i).getWholesalerId(), 0.0001);
            assertEquals(o.get("status").getAsString(), result.get(i).getStatus());
        }

        result.clear();
    }

    @Test
    public void testParsingPrescriptions() throws IOException {
        final String inputFile = "Prescriptions.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Prescriptions> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Prescriptions(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("prescriberName").getAsString(), result.get(i).getPrescriberName());
            assertEquals(o.get("prescriberDea").getAsString(), result.get(i).getPrescriberDea());
            assertEquals(o.get("status").getAsString(), result.get(i).getStatus());
            assertEquals(o.get("priority").getAsString(), result.get(i).getPriority());
            assertEquals(o.get("notes").getAsString(), result.get(i).getNotes());
        }

        result.clear();
    }

    @Test
    public void testParsingPrescriptionItems() throws IOException {
        final String inputFile = "PrescriptionItems.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<PrescriptionItems> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2PrescriptionItems(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("quantity").getAsInt(), result.get(i).getQuantity(), 0.0001);
            assertEquals(o.get("daysSupply").getAsInt(), result.get(i).getDaysSupply(), 0.0001);
            assertEquals(o.get("sig").getAsString(), result.get(i).getSig());
            assertEquals(
                    o.get("refillsAllowed").getAsInt(), result.get(i).getRefillsAllowed(), 0.0001);
            assertEquals(o.get("isControlled").getAsBoolean(), result.get(i).getIsControlled());
            assertEquals(o.get("status").getAsString(), result.get(i).getStatus());
        }

        result.clear();
    }

    @Test
    public void testParsingPrescriptionTransfers() throws IOException {
        final String inputFile = "PrescriptionTransfers.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<PrescriptionTransfers> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2PrescriptionTransfers(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("transferType").getAsString(), result.get(i).getTransferType());
            assertEquals(o.get("provider").getAsString(), result.get(i).getProvider());
            assertEquals(o.get("externalId").getAsString(), result.get(i).getExternalId());
            assertEquals(o.get("status").getAsString(), result.get(i).getStatus());
            assertEquals(o.get("signed").getAsBoolean(), result.get(i).getSigned());
        }

        result.clear();
    }

    @Test
    public void testParsingPrescriptionAudit() throws IOException {
        final String inputFile = "PrescriptionAudit.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<PrescriptionAudit> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2PrescriptionAudit(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("action").getAsString(), result.get(i).getAction());
            assertEquals(o.get("reason").getAsString(), result.get(i).getReason());
        }

        result.clear();
    }

    @Test
    public void testParsingWorkflows() throws IOException {
        final String inputFile = "Workflows.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Workflows> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Workflows(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("id").getAsInt(), result.get(i).getId(), 0.0001);
            assertEquals(o.get("name").getAsString(), result.get(i).getName());
            assertEquals(o.get("description").getAsString(), result.get(i).getDescription());
        }

        result.clear();
    }

    @Test
    public void testParsingWorkflowSteps() throws IOException {
        final String inputFile = "WorkflowSteps.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<WorkflowSteps> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2WorkflowSteps(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("id").getAsInt(), result.get(i).getId(), 0.0001);
            assertEquals(o.get("workflowId").getAsInt(), result.get(i).getWorkflowId(), 0.0001);
            assertEquals(o.get("stepKey").getAsString(), result.get(i).getStepKey());
            assertEquals(o.get("displayName").getAsString(), result.get(i).getDisplayName());
        }

        result.clear();
    }

    @Test
    public void testParsingQueues() throws IOException {
        final String inputFile = "Queues.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Queues> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Queues(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("id").getAsInt(), result.get(i).getId(), 0.0001);
            assertEquals(o.get("name").getAsString(), result.get(i).getName());
            assertEquals(o.get("description").getAsString(), result.get(i).getDescription());
        }

        result.clear();
    }

    @Test
    public void testParsingTasks() throws IOException {
        final String inputFile = "Tasks.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Tasks> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Tasks(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("objectType").getAsString(), result.get(i).getObjectType());
            assertEquals(o.get("workflowId").getAsInt(), result.get(i).getWorkflowId(), 0.0001);
            assertEquals(o.get("stepId").getAsInt(), result.get(i).getStepId(), 0.0001);
            assertEquals(o.get("queueId").getAsInt(), result.get(i).getQueueId(), 0.0001);
            assertEquals(o.get("status").getAsString(), result.get(i).getStatus());
            assertEquals(o.get("priority").getAsInt(), result.get(i).getPriority(), 0.0001);
        }

        result.clear();
    }

    @Test
    public void testParsingTaskRouting() throws IOException {
        final String inputFile = "TaskRouting.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<TaskRouting> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2TaskRouting(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("id").getAsInt(), result.get(i).getId(), 0.0001);
            assertEquals(o.get("queueId").getAsInt(), result.get(i).getQueueId(), 0.0001);
            assertEquals(o.get("ruleOrder").getAsInt(), result.get(i).getRuleOrder(), 0.0001);
        }

        result.clear();
    }

    @Test
    public void testParsingBarcodeLabels() throws IOException {
        final String inputFile = "BarcodeLabels.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<BarcodeLabels> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2BarcodeLabels(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("barcode").getAsString(), result.get(i).getBarcode());
            assertEquals(o.get("labelType").getAsString(), result.get(i).getLabelType());
        }

        result.clear();
    }

    @Test
    public void testParsingPosTransactions() throws IOException {
        final String inputFile = "PosTransactions.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<PosTransactions> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2PosTransactions(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("stationId").getAsString(), result.get(i).getStationId());
            assertEquals(o.get("totalAmount").getAsFloat(), result.get(i).getTotalAmount());
            assertEquals(o.get("status").getAsString(), result.get(i).getStatus());
        }

        result.clear();
    }

    @Test
    public void testParsingPosSignatures() throws IOException {
        final String inputFile = "PosSignatures.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<PosSignatures> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2PosSignatures(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("stationId").getAsString(), result.get(i).getStationId());
        }

        result.clear();
    }

    @Test
    public void testParsingPayments() throws IOException {
        final String inputFile = "Payments.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Payments> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Payments(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("paymentMethod").getAsString(), result.get(i).getPaymentMethod());
            assertEquals(o.get("amount").getAsFloat(), result.get(i).getAmount());
        }

        result.clear();
    }

    @Test
    public void testParsingClaims() throws IOException {
        final String inputFile = "Claims.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Claims> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Claims(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("payerName").getAsString(), result.get(i).getPayerName());
            assertEquals(o.get("claimStatus").getAsString(), result.get(i).getClaimStatus());
        }

        result.clear();
    }

    @Test
    public void testParsingDirFees() throws IOException {
        final String inputFile = "DirFees.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<DirFees> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2DirFees(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("amount").getAsFloat(), result.get(i).getAmount());
            assertEquals(o.get("reason").getAsString(), result.get(i).getReason());
        }

        result.clear();
    }

    @Test
    public void testParsingAwpReclaims() throws IOException {
        final String inputFile = "AwpReclaims.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<AwpReclaims> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2AwpReclaims(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("amount").getAsFloat(), result.get(i).getAmount());
            assertEquals(o.get("notes").getAsString(), result.get(i).getNotes());
        }

        result.clear();
    }

    @Test
    public void testParsingProfitAuditWarnings() throws IOException {
        final String inputFile = "ProfitAuditWarnings.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<ProfitAuditWarnings> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2ProfitAuditWarnings(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(
                    o.get("relatedObjectType").getAsString(), result.get(i).getRelatedObjectType());
            assertEquals(o.get("warningCode").getAsString(), result.get(i).getWarningCode());
            assertEquals(o.get("description").getAsString(), result.get(i).getDescription());
        }

        result.clear();
    }

    @Test
    public void testParsingAlertRules() throws IOException {
        final String inputFile = "AlertRules.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<AlertRules> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2AlertRules(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("id").getAsInt(), result.get(i).getId(), 0.0001);
            assertEquals(o.get("name").getAsString(), result.get(i).getName());
            assertEquals(o.get("description").getAsString(), result.get(i).getDescription());
            assertEquals(o.get("severity").getAsString(), result.get(i).getSeverity());
            assertEquals(o.get("active").getAsBoolean(), result.get(i).getActive());
        }

        result.clear();
    }

    @Test
    public void testParsingAlertLogs() throws IOException {
        final String inputFile = "AlertLogs.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<AlertLogs> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2AlertLogs(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("alertRuleId").getAsInt(), result.get(i).getAlertRuleId(), 0.0001);
            assertEquals(o.get("actionTaken").getAsString(), result.get(i).getActionTaken());
            assertEquals(o.get("overrideReason").getAsString(), result.get(i).getOverrideReason());
        }

        result.clear();
    }

    @Test
    public void testParsingIntegrations() throws IOException {
        final String inputFile = "Integrations.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Integrations> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Integrations(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("id").getAsInt(), result.get(i).getId(), 0.0001);
            assertEquals(o.get("name").getAsString(), result.get(i).getName());
            assertEquals(o.get("type").getAsString(), result.get(i).getType());
        }

        result.clear();
    }

    @Test
    public void testParsingIntegrationEvents() throws IOException {
        final String inputFile = "IntegrationEvents.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<IntegrationEvents> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2IntegrationEvents(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(
                    o.get("integrationId").getAsInt(), result.get(i).getIntegrationId(), 0.0001);
            assertEquals(o.get("eventType").getAsString(), result.get(i).getEventType());
            assertEquals(o.get("externalId").getAsString(), result.get(i).getExternalId());
            assertEquals(o.get("status").getAsString(), result.get(i).getStatus());
        }

        result.clear();
    }

    @Test
    public void testParsingReports() throws IOException {
        final String inputFile = "Reports.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<Reports> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2Reports(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("name").getAsString(), result.get(i).getName());
            assertEquals(o.get("description").getAsString(), result.get(i).getDescription());
        }

        result.clear();
    }

    @Test
    public void testParsingAuditLogs() throws IOException {
        final String inputFile = "AuditLogs.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<AuditLogs> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2AuditLogs(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("entityType").getAsString(), result.get(i).getEntityType());
            assertEquals(o.get("action").getAsString(), result.get(i).getAction());
            assertEquals(o.get("ipAddress").getAsString(), result.get(i).getIpAddress());
            assertEquals(o.get("userAgent").getAsString(), result.get(i).getUserAgent());
        }

        result.clear();
    }

    @Test
    public void testParsingConsentRecords() throws IOException {
        final String inputFile = "ConsentRecords.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<ConsentRecords> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2ConsentRecords(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("consentType").getAsString(), result.get(i).getConsentType());
            assertEquals(o.get("granted").getAsBoolean(), result.get(i).getGranted());
            assertEquals(o.get("source").getAsString(), result.get(i).getSource());
        }

        result.clear();
    }

    @Test
    public void testParsingEncryptionKeysMeta() throws IOException {
        final String inputFile = "EncryptionKeysMeta.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<EncryptionKeysMeta> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2EncryptionKeysMeta(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("id").getAsInt(), result.get(i).getId(), 0.0001);
            assertEquals(o.get("keyId").getAsString(), result.get(i).getKeyId());
            assertEquals(o.get("purpose").getAsString(), result.get(i).getPurpose());
        }

        result.clear();
    }

    @Test
    public void testParsingPdmpQueries() throws IOException {
        final String inputFile = "PdmpQueries.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<PdmpQueries> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2PdmpQueries(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("state").getAsString(), result.get(i).getState());
            assertEquals(o.get("queryReason").getAsString(), result.get(i).getQueryReason());
            assertEquals(o.get("status").getAsString(), result.get(i).getStatus());
            assertEquals(o.get("responseCode").getAsString(), result.get(i).getResponseCode());
            assertEquals(o.get("errorMessage").getAsString(), result.get(i).getErrorMessage());
        }

        result.clear();
    }

    @Test
    public void testParsingAccessLogs() throws IOException {
        final String inputFile = "AccessLogs.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<AccessLogs> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2AccessLogs(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("entityType").getAsString(), result.get(i).getEntityType());
            assertEquals(o.get("action").getAsString(), result.get(i).getAction());
            assertEquals(o.get("accessReason").getAsString(), result.get(i).getAccessReason());
            assertEquals(o.get("ipAddress").getAsString(), result.get(i).getIpAddress());
            assertEquals(o.get("userAgent").getAsString(), result.get(i).getUserAgent());
        }

        result.clear();
    }

    @Test
    public void testParsingEfaxRecipients() throws IOException {
        final String inputFile = "EfaxRecipients.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<EfaxRecipients> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2EfaxRecipients(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("name").getAsString(), result.get(i).getName());
            assertEquals(o.get("organization").getAsString(), result.get(i).getOrganization());
            assertEquals(o.get("faxNumber").getAsString(), result.get(i).getFaxNumber());
            assertEquals(o.get("email").getAsString(), result.get(i).getEmail());
            assertEquals(o.get("contactType").getAsString(), result.get(i).getContactType());
            assertEquals(o.get("isVerified").getAsBoolean(), result.get(i).getIsVerified());
        }

        result.clear();
    }

    @Test
    public void testParsingEfaxJobs() throws IOException {
        final String inputFile = "EfaxJobs.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<EfaxJobs> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2EfaxJobs(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("direction").getAsString(), result.get(i).getDirection());
            assertEquals(o.get("subject").getAsString(), result.get(i).getSubject());
            assertEquals(o.get("faxNumber").getAsString(), result.get(i).getFaxNumber());
            assertEquals(o.get("providerName").getAsString(), result.get(i).getProviderName());
            assertEquals(o.get("status").getAsString(), result.get(i).getStatus());
            assertEquals(o.get("totalPages").getAsInt(), result.get(i).getTotalPages(), 0.0001);
            assertEquals(o.get("priority").getAsString(), result.get(i).getPriority());
            assertEquals(o.get("errorMessage").getAsString(), result.get(i).getErrorMessage());
            assertEquals(o.get("retryCount").getAsInt(), result.get(i).getRetryCount(), 0.0001);
        }

        result.clear();
    }

    @Test
    public void testParsingEfaxAttachments() throws IOException {
        final String inputFile = "EfaxAttachments.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<EfaxAttachments> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2EfaxAttachments(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("fileName").getAsString(), result.get(i).getFileName());
            assertEquals(o.get("fileType").getAsString(), result.get(i).getFileType());
            assertEquals(o.get("encryptedPath").getAsString(), result.get(i).getEncryptedPath());
            assertEquals(o.get("checksum").getAsString(), result.get(i).getChecksum());
            assertEquals(o.get("pageNumber").getAsInt(), result.get(i).getPageNumber(), 0.0001);
        }

        result.clear();
    }

    @Test
    public void testParsingEfaxStatusLogs() throws IOException {
        final String inputFile = "EfaxStatusLogs.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<EfaxStatusLogs> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2EfaxStatusLogs(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("status").getAsString(), result.get(i).getStatus());
            assertEquals(o.get("message").getAsString(), result.get(i).getMessage());
            assertEquals(o.get("providerCode").getAsString(), result.get(i).getProviderCode());
        }

        result.clear();
    }

    @Test
    public void testParsingEfaxIncoming() throws IOException {
        final String inputFile = "EfaxIncoming.json";
        final String json =
                FileUtils.readFileFromResource2String(inputFile, Charset.defaultCharset());
        JsonArray arr = JsonHelper.fromJson2Arr(json);
        final List<EfaxIncoming> result = new ArrayList<>();
        arr.forEach(o -> result.add(JsonHelper.fromJson2EfaxIncoming(o)));
        for (int i = 0; i < arr.size(); i++) {
            JsonObject o = arr.get(i).getAsJsonObject();
            assertEquals(o.get("fromFaxNumber").getAsString(), result.get(i).getFromFaxNumber());
            assertEquals(o.get("fromName").getAsString(), result.get(i).getFromName());
            assertEquals(o.get("totalPages").getAsInt(), result.get(i).getTotalPages(), 0.0001);
            assertEquals(o.get("filePath").getAsString(), result.get(i).getFilePath());
            assertEquals(o.get("checksum").getAsString(), result.get(i).getChecksum());
        }

        result.clear();
    }
}
