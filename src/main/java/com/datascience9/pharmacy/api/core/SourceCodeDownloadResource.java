/**
 * %% Copyright (C) 2021 DataScience 9 LLC %% Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License. #L%
 *
 * <p>This code is 100% AUTO generated. Please do not modify it DIRECTLY If you need new features or
 * function or changes please update the templates then submit the template through our web
 * interface.
 */
package com.datascience9.pharmacy.api.core;

import com.datascience9.pharmacy.utils.FileUtils;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

@Path("/source")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON})
public class SourceCodeDownloadResource {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public SourceCodeDownloadResource() {}

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

    @GET
    @Path("{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getSourceCode(@PathParam("name") String name) {
        try {
            InputStream in = SourceCodeDownloadResource.class.getResourceAsStream("/" + name);
            return FileUtils.convertInputStreamToString(in);

        } catch (IOException e) {
            return Response.serverError().build().toString();
        }
    }
}
