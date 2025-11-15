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

import com.datascience9.pharmacy.entity.Users;
import com.datascience9.pharmacy.service.UsersService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})

/** Auto generated from a schema generated on $date$ */
public class UsersResource {

    @Inject private UsersService service;

    public UsersResource() {}

    public UsersResource(final UsersService service) {
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
     * InIdempotent method. Update existing Users.
     *
     * @param obj - instance of Users.
     * @return Users.
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Users update(Users obj) {
        return this.service.update(obj);
    }

    /**
     * Create a new AdminPasswords.
     *
     * @param obj - instance of AdminPasswords.
     * @return Users.
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Users create(Users obj) {
        return this.service.create(obj);
    }

    /**
     * Delete User.
     *
     * @param userId - user Id.
     * @return Users.
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{userId}")
    @DELETE
    public Object delete(@PathParam("userId") String userId) {
        return this.service.delete(UUID.fromString(userId));
    }

    /**
     * Delete existing Users.
     *
     * @param id instance of Users.
     * @return Users.
     */

    /**
     * Select all Users with limit of returned records.
     *
     * @param max - number of records.
     * @return a list Users.
     */
    @GET
    @Path("select/{max}")
    public List<Users> findWithLimit(@PathParam("max") String max) {
        Integer input = null;
        try {
            input = Integer.valueOf(max);
        } catch (NumberFormatException ex) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return service.select(input);
    }

    /**
     * Select all Users records.
     *
     * @return a list Users.
     */
    @GET
    @Path("selectAll")
    public List<Users> selectAll() {
        return service.selectAll();
    }
}
