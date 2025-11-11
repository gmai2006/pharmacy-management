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
package com.datascience9.pharmacy.api;

import static java.util.Objects.requireNonNull;

import com.datascience9.pharmacy.entity.InventoryItems;
import com.datascience9.pharmacy.service.InventoryItemsService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/inventoryitems")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})

/** Auto generated from a schema generated on $date$ */
public class InventoryItemsResource {

    @Inject private InventoryItemsService service;

    public InventoryItemsResource() {}

    public InventoryItemsResource(final InventoryItemsService service) {
        requireNonNull(service);
        this.service = service;
    }

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
     * InIdempotent method. Update existing InventoryItems.
     *
     * @param obj - instance of InventoryItems.
     * @return InventoryItems.
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public InventoryItems update(InventoryItems obj) {
        return this.service.update(obj);
    }

    /**
     * Create a new AdminPasswords.
     *
     * @param obj - instance of AdminPasswords.
     * @return InventoryItems.
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public InventoryItems create(InventoryItems obj) {
        return this.service.create(obj);
    }

    /**
     * Delete existing InventoryItems.
     *
     * @param id instance of InventoryItems.
     * @return InventoryItems.
     */

    /**
     * Select all InventoryItems with limit of returned records.
     *
     * @param max - number of records.
     * @return a list InventoryItems.
     */
    @GET
    @Path("select/{max}")
    public Response findWithLimit(@PathParam("max") String max) {
        Integer input = null;
        try {
            input = Integer.valueOf(max);
        } catch (NumberFormatException ex) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        List<InventoryItems> result = service.select(input);

        return Response.status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header(
                        "Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(result)
                .build();
    }

    /**
     * Select all InventoryItems records.
     *
     * @return a list InventoryItems.
     */
    @GET
    @Path("selectAll")
    public Response selectAll() {
        List<InventoryItems> result = service.selectAll();

        return Response.status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header(
                        "Access-Control-Allow-Headers",
                        "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(result)
                .build();
    }
}
