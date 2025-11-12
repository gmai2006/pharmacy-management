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

import com.datascience9.pharmacy.entity.PrescriptionClaims;
import com.datascience9.pharmacy.service.PrescriptionClaimsService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/prescriptionclaims")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})

/** Auto generated from a schema generated on $date$ */
public class PrescriptionClaimsResource {

    @Inject private PrescriptionClaimsService service;

    public PrescriptionClaimsResource() {}

    public PrescriptionClaimsResource(final PrescriptionClaimsService service) {
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
     * InIdempotent method. Update existing PrescriptionClaims.
     *
     * @param obj - instance of PrescriptionClaims.
     * @return PrescriptionClaims.
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public PrescriptionClaims update(PrescriptionClaims obj) {
        return this.service.update(obj);
    }

    /**
     * Create a new AdminPasswords.
     *
     * @param obj - instance of AdminPasswords.
     * @return PrescriptionClaims.
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public PrescriptionClaims create(PrescriptionClaims obj) {
        return this.service.create(obj);
    }

    /**
     * Delete existing PrescriptionClaims.
     *
     * @param id instance of PrescriptionClaims.
     * @return PrescriptionClaims.
     */

    /**
     * Select all PrescriptionClaims with limit of returned records.
     *
     * @param max - number of records.
     * @return a list PrescriptionClaims.
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
        List<PrescriptionClaims> result = service.select(input);

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
     * Select all PrescriptionClaims records.
     *
     * @return a list PrescriptionClaims.
     */
    @GET
    @Path("selectAll")
    public Response selectAll() {
        List<PrescriptionClaims> result = service.selectAll();

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
