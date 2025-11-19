package com.datascience9.pharmacy.api.manual;

import com.datascience9.pharmacy.service.manual.BarcodeScannerService;
import com.datascience9.pharmacy.service.manual.BarcodeScannerService.ScanResult;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/barcode")
public class BarcodeResource {

    private final BarcodeScannerService scanner = new BarcodeScannerService();

    @POST
    @Path("/scan")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response scanBarcode(BarcodeScanRequest request) {
        if (request == null || request.imageBase64 == null || request.imageBase64.isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"imageBase64 is required\"}")
                    .build();
        }

        ScanResult result = scanner.scanBase64(request.imageBase64);
        return Response.ok(result).build();
    }
}
