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

import com.datascience9.pharmacy.entity.DeviceFingerprints;
import com.datascience9.pharmacy.service.DeviceFingerprintsService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/devicefingerprints")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})

/** Auto generated from a schema generated on $date$ */
public class DeviceFingerprintsResource {

    @Inject private DeviceFingerprintsService service;

    public DeviceFingerprintsResource() {}

    public DeviceFingerprintsResource(final DeviceFingerprintsService service) {
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
     * InIdempotent method. Update existing DeviceFingerprints.
     *
     * @param obj - instance of DeviceFingerprints.
     * @return DeviceFingerprints.
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public DeviceFingerprints update(DeviceFingerprints obj) {
        return this.service.update(obj);
    }

    /**
     * Create a new AdminPasswords.
     *
     * @param obj - instance of AdminPasswords.
     * @return DeviceFingerprints.
     */
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public DeviceFingerprints create(DeviceFingerprints obj) {
        return this.service.create(obj);
    }

    /**
     * Delete existing DeviceFingerprints.
     *
     * @param id instance of DeviceFingerprints.
     * @return DeviceFingerprints.
     */

    /**
     * Select all DeviceFingerprints with limit of returned records.
     *
     * @param max - number of records.
     * @return a list DeviceFingerprints.
     */
    @GET
    @Path("select/{max}")
    public List<DeviceFingerprints> findWithLimit(@PathParam("max") String max) {
        Integer input = null;
        try {
            input = Integer.valueOf(max);
        } catch (NumberFormatException ex) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return service.select(input);
    }

    /**
     * Select all DeviceFingerprints records.
     *
     * @return a list DeviceFingerprints.
     */
    @GET
    @Path("selectAll")
    public List<DeviceFingerprints> selectAll() {
        return service.selectAll();
    }
}
