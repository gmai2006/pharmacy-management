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
package com.datascience9.pharmacy.api.manual;

import com.datascience9.pharmacy.entity.manual.ClaimProcessing;
import com.datascience9.pharmacy.entity.manual.InventoryOverview;
import com.datascience9.pharmacy.entity.manual.PrescriptionSummary;
import com.datascience9.pharmacy.service.manual.ViewService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/view")
@Consumes({"application/json"})
@Produces({"application/json"})
public class ViewResource {
    @Inject private ViewService service;

    public ViewResource() {}

    public ViewResource(ViewService service) {
        Objects.requireNonNull(service);
        this.service = service;
    }

    @GET
    @Path("")
    public Response hello() {
        return Response.status(Response.Status.OK).entity(getClass().getName()).build();
    }

    @GET
    @Path("prescriptions/{max}")
    public List<PrescriptionSummary> getPrescriptionSummary(@PathParam("max") String max) {
        int input;
        try {
            input = Integer.parseInt(max);
        } catch (NumberFormatException ex) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return this.service.selectPrescriptionSummary(input);
    }

    @GET
    @Path("inventoryview/{max}")
    public List<InventoryOverview> getInventoryOverviews(@PathParam("max") String max) {
        int input;
        try {
            input = Integer.parseInt(max);
        } catch (NumberFormatException ex) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return this.service.selectAllInventoryOverviews(input);
    }

    @GET
    @Path("claimprocessing/{max}")
    public List<ClaimProcessing> getClaimProcessing(@PathParam("max") String max) {
        int input;
        try {
            input = Integer.parseInt(max);
        } catch (NumberFormatException ex) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return this.service.selectClaimProcessing(input);
    }

    @GET
    @Path("inventoryneededorder/")
    public List<InventoryOverview> reorderInventoryNeeded() {
        return this.service.reorderInventoryNeeded();
    }

    @GET
    @Path("inventoryexpiry/")
    public List<InventoryOverview> expiringInventory() {
        return this.service.expiringInventory();
    }
}
