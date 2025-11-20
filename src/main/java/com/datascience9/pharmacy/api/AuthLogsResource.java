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

import com.datascience9.pharmacy.entity.AuthLogs;
import com.datascience9.pharmacy.service.AuthLogsService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;

@Path("/authlogs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})

/** Auto generated from a schema generated on $date$ */
public class AuthLogsResource {

    @Inject private AuthLogsService service;

    public AuthLogsResource() {}

    public AuthLogsResource(final AuthLogsService service) {
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
     * InIdempotent method. Update existing AuthLogs.
     *
     * @param obj - instance of AuthLogs.
     * @return AuthLogs.
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public AuthLogs update(AuthLogs obj) {
        return this.service.update(obj);
    }

    /**
     * Create a new AdminPasswords.
     *
     * @param obj - instance of AdminPasswords.
     * @return AuthLogs.
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public AuthLogs create(AuthLogs obj) {
        obj.setCreatedAt(LocalDateTime.now());
        return this.service.create(obj);
    }

    /**
     * Delete existing AuthLogs.
     *
     * @param id instance of AuthLogs.
     * @return AuthLogs.
     */

    /**
     * Select all AuthLogs with limit of returned records.
     *
     * @param max - number of records.
     * @return a list AuthLogs.
     */
    @GET
    @Path("select/{max}")
    public List<AuthLogs> findWithLimit(@PathParam("max") String max) {
        Integer input = null;
        try {
            input = Integer.valueOf(max);
        } catch (NumberFormatException ex) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return service.select(input);
    }

    /**
     * Select all AuthLogs records.
     *
     * @return a list AuthLogs.
     */
    @GET
    @Path("selectAll")
    public List<AuthLogs> selectAll() {
        return service.selectAll();
    }
}
