package com.datascience9.pharmacy.api.manual;

import com.datascience9.pharmacy.entity.InventoryItems;
import com.datascience9.pharmacy.service.manual.InventoryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;

@Path("/inventory")
@Consumes({"application/json"})
@Produces({"application/json"})
public class InventoryResource {
    @Inject private InventoryService service;

    public InventoryResource() {}

    public InventoryResource(InventoryService service) {
        Objects.requireNonNull(service);
        this.service = service;
    }

    @GET
    @Path("")
    public Response hello() {
        return Response.status(Response.Status.OK).entity(getClass().getName()).build();
    }

    @GET
    @Path("select/{max}")
    public List<InventoryItems> findWithLimit(@PathParam("max") String max) {
        int input;
        try {
            input = Integer.parseInt(max);
        } catch (NumberFormatException ex) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        return this.service.select(input);
    }
}
