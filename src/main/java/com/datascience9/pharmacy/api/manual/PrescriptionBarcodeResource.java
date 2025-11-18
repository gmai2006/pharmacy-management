package com.datascience9.pharmacy.api.manual;

import com.datascience9.pharmacy.service.manual.ImageConversionService;
import com.datascience9.pharmacy.service.manual.PrescriptionBarcodeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Jakarta REST Resource for Prescription Barcode Generation Provides endpoints for generating and
 * retrieving prescription barcodes Includes image conversion endpoints
 */
@Path("/prescription")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PrescriptionBarcodeResource {

    private static final Logger logger =
            Logger.getLogger(PrescriptionBarcodeResource.class.getName());
    private final PrescriptionBarcodeService barcodeService = new PrescriptionBarcodeService();
    private final ImageConversionService imageService = new ImageConversionService();

    /**
     * Generate single prescription barcode POST /api/prescription/generate-barcode
     *
     * @param prescriptionData The prescription and patient data
     * @return Response with barcode paths
     */
    @POST
    @Path("/generate-barcode")
    public Response generateBarcode(Map<String, Object> prescriptionData) {
        try {
            logger.info(
                    "Generating barcode for prescription: "
                            + prescriptionData.get("prescriptionId"));

            // Validate data
            if (!barcodeService.validatePrescriptionData(prescriptionData)) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(createErrorResponse("Invalid prescription data"))
                        .build();
            }

            // Generate barcodes
            Map<String, String> barcodes =
                    barcodeService.generatePrescriptionBarcodes(prescriptionData);

            Map<String, Object> response =
                    createSuccessResponse("Barcodes generated successfully", barcodes);
            return Response.ok(response).build();

        } catch (IllegalArgumentException e) {
            logger.warning("Invalid prescription data: " + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(createErrorResponse("Invalid prescription data: " + e.getMessage()))
                    .build();
        } catch (Exception e) {
            logger.severe("Error generating barcode: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createErrorResponse("Error generating barcode: " + e.getMessage()))
                    .build();
        }
    }

    /**
     * Batch generate barcodes for multiple prescriptions POST /api/prescription/batch-generate
     *
     * @param prescriptions List of prescription data
     * @return Response with results map
     */
    @POST
    @Path("/batch-generate")
    public Response batchGenerateBarcodes(List<Map<String, Object>> prescriptions) {
        try {
            Map<String, Map<String, String>> results = new HashMap<>();
            int processed = 0;
            int failed = 0;

            for (Map<String, Object> prescription : prescriptions) {
                try {
                    if (barcodeService.validatePrescriptionData(prescription)) {
                        Map<String, String> barcodes =
                                barcodeService.generatePrescriptionBarcodes(prescription);
                        results.put((String) prescription.get("prescriptionId"), barcodes);
                        processed++;
                    } else {
                        failed++;
                    }
                } catch (Exception e) {
                    logger.warning("Failed to generate barcode: " + e.getMessage());
                    failed++;
                }
            }

            Map<String, Object> response = new LinkedHashMap<>();
            response.put("success", true);
            response.put("message", "Batch barcode generation completed");
            response.put("totalProcessed", processed);
            response.put("totalFailed", failed);
            response.put("results", results);

            logger.info(
                    "Batch generation completed: "
                            + processed
                            + " successful, "
                            + failed
                            + " failed");
            return Response.ok(response).build();

        } catch (Exception e) {
            logger.severe("Error in batch generation: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createErrorResponse("Batch generation failed: " + e.getMessage()))
                    .build();
        }
    }

    /**
     * Get barcode image by prescription ID and type GET
     * /api/prescription/{prescriptionId}/barcode/{type}
     *
     * @param prescriptionId The prescription ID
     * @param type The barcode type (code128 or qrcode)
     * @return The barcode image file
     */
    @GET
    @Path("/{prescriptionId}/barcode/{type}")
    @Produces("image/png")
    public Response getBarcode(
            @PathParam("prescriptionId") String prescriptionId, @PathParam("type") String type) {
        try {
            // Validate type
            if (!("code128".equals(type) || "qrcode".equals(type))) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(
                                createErrorResponse(
                                        "Invalid barcode type. Use 'code128' or 'qrcode'"))
                        .build();
            }

            String filePath = barcodeService.getBarcodePath(prescriptionId, type);
            File barcodeFile = new File(filePath);

            if (!barcodeFile.exists()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(createErrorResponse("Barcode file not found"))
                        .build();
            }

            byte[] fileContent = Files.readAllBytes(Paths.get(filePath));

            logger.info("Barcode retrieved: " + prescriptionId + " - " + type);

            return Response.ok(fileContent)
                    .header("Content-Type", "image/png")
                    .header("Content-Length", fileContent.length)
                    .build();

        } catch (Exception e) {
            logger.severe("Error retrieving barcode: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createErrorResponse("Error retrieving barcode"))
                    .build();
        }
    }

    /**
     * Download barcode image GET /api/prescription/download/{prescriptionId}/{type}
     *
     * @param prescriptionId The prescription ID
     * @param type The barcode type
     * @return The barcode image with download headers
     */
    @GET
    @Path("/download/{prescriptionId}/{type}")
    @Produces("image/png")
    public Response downloadBarcode(
            @PathParam("prescriptionId") String prescriptionId, @PathParam("type") String type) {
        try {
            String filePath = barcodeService.getBarcodePath(prescriptionId, type);
            File barcodeFile = new File(filePath);

            if (!barcodeFile.exists()) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(createErrorResponse("Barcode file not found"))
                        .build();
            }

            byte[] fileContent = Files.readAllBytes(Paths.get(filePath));
            String fileName = "prescription_" + prescriptionId + "_" + type + ".png";

            logger.info("Barcode downloaded: " + prescriptionId + " - " + type);

            return Response.ok(fileContent)
                    .header("Content-Type", "image/png")
                    .header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
                    .header("Content-Length", fileContent.length)
                    .build();

        } catch (Exception e) {
            logger.severe("Error downloading barcode: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createErrorResponse("Error downloading barcode"))
                    .build();
        }
    }

    /**
     * Get barcode generation status GET /api/prescription/status/{prescriptionId}
     *
     * @param prescriptionId The prescription ID
     * @return Status information
     */
    @GET
    @Path("/status/{prescriptionId}")
    public Response getBarcodeStatus(@PathParam("prescriptionId") String prescriptionId) {
        try {
            Map<String, Object> status = barcodeService.getBarcodeStatus(prescriptionId);
            return Response.ok(status).build();
        } catch (Exception e) {
            logger.severe("Error checking status: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createErrorResponse("Error checking status"))
                    .build();
        }
    }

    /**
     * Health check endpoint GET /api/prescription/health
     *
     * @return Health status
     */
    @GET
    @Path("/health")
    public Response health() {
        Map<String, Object> health = new LinkedHashMap<>();
        health.put("status", "UP");
        health.put("service", "Prescription Barcode Generator");
        health.put("timestamp", System.currentTimeMillis());
        health.put("version", "1.0.0");

        logger.info("Health check requested");
        return Response.ok(health).build();
    }

    /**
     * API information endpoint GET /api/prescription/info
     *
     * @return API information
     */
    @GET
    @Path("/info")
    public Response info() {
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("service", "Prescription Barcode Generator REST API");
        info.put("version", "1.0.0");
        info.put(
                "endpoints",
                new String[] {
                    "POST /api/prescription/generate-barcode - Generate single barcode",
                    "POST /api/prescription/batch-generate - Batch generate barcodes",
                    "GET /api/prescription/{id}/barcode/{type} - Get barcode image",
                    "GET /api/prescription/download/{id}/{type} - Download barcode",
                    "GET /api/prescription/status/{id} - Get barcode status",
                    "GET /api/prescription/health - Health check",
                    "GET /api/prescription/info - API information"
                });

        return Response.ok(info).build();
    }

    /** Create error response map */
    private Map<String, Object> createErrorResponse(String message) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", false);
        response.put("message", message);
        return response;
    }

    /** Create success response map */
    private Map<String, Object> createSuccessResponse(String message, Object data) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("success", true);
        response.put("message", message);
        response.put("data", data);
        return response;
    }

    // ===== IMAGE CONVERSION ENDPOINTS =====

    /**
     * Convert barcode to image and return as Base64 GET
     * /api/prescription/{prescriptionId}/image/{type}
     *
     * @param prescriptionId The prescription ID
     * @param type The barcode type (code128 or qrcode)
     * @return Response with Base64 encoded image
     */
    @GET
    @Path("/{prescriptionId}/image/{type}")
    public Response getBarcodeAsImage(
            @PathParam("prescriptionId") String prescriptionId, @PathParam("type") String type) {
        try {
            // Validate type
            if (!("code128".equals(type) || "qrcode".equals(type))) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(
                                createErrorResponse(
                                        "Invalid barcode type. Use 'code128' or 'qrcode'"))
                        .build();
            }

            String filePath = barcodeService.getBarcodePath(prescriptionId, type);

            // Validate image
            if (!imageService.isImageValid(filePath)) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(createErrorResponse("Barcode image not found or not readable"))
                        .build();
            }

            // Convert to Base64
            String base64Image = imageService.getImageAsBase64(filePath);

            Map<String, Object> response =
                    createSuccessResponse(
                            "Barcode converted to Base64 image",
                            new LinkedHashMap<String, Object>() {
                                {
                                    put("dataUri", base64Image);
                                    put("prescriptionId", prescriptionId);
                                    put("barcodeType", type);
                                }
                            });

            logger.info("Barcode converted to Base64 image: " + prescriptionId + " - " + type);
            return Response.ok(response).build();

        } catch (Exception e) {
            logger.severe("Error converting barcode to image: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(
                            createErrorResponse(
                                    "Error converting barcode to image: " + e.getMessage()))
                    .build();
        }
    }

    /**
     * Get barcode image with metadata as Base64 GET
     * /api/prescription/{prescriptionId}/image-base64/{type}
     *
     * @param prescriptionId The prescription ID
     * @param type The barcode type
     * @return Response with Base64 image and metadata
     */
    @GET
    @Path("/{prescriptionId}/image-base64/{type}")
    public Response getBarcodeAsBase64WithMetadata(
            @PathParam("prescriptionId") String prescriptionId, @PathParam("type") String type) {
        try {
            if (!("code128".equals(type) || "qrcode".equals(type))) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(createErrorResponse("Invalid barcode type"))
                        .build();
            }

            String filePath = barcodeService.getBarcodePath(prescriptionId, type);

            if (!imageService.isImageValid(filePath)) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(createErrorResponse("Barcode image not found"))
                        .build();
            }

            // Get image with metadata
            Map<String, Object> imageData = imageService.getImageAsBase64WithMetadata(filePath);

            Map<String, Object> response =
                    createSuccessResponse(
                            "Barcode image with metadata",
                            new LinkedHashMap<String, Object>() {
                                {
                                    putAll(imageData);
                                    put("prescriptionId", prescriptionId);
                                    put("barcodeType", type);
                                }
                            });

            logger.info("Barcode Base64 with metadata retrieved: " + prescriptionId);
            return Response.ok(response).build();

        } catch (Exception e) {
            logger.severe("Error retrieving image metadata: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createErrorResponse("Error retrieving image metadata"))
                    .build();
        }
    }

    /**
     * Get barcode image metadata GET /api/prescription/{prescriptionId}/image-info/{type}
     *
     * @param prescriptionId The prescription ID
     * @param type The barcode type
     * @return Response with image metadata
     */
    @GET
    @Path("/{prescriptionId}/image-info/{type}")
    public Response getBarcodeImageMetadata(
            @PathParam("prescriptionId") String prescriptionId, @PathParam("type") String type) {
        try {
            if (!("code128".equals(type) || "qrcode".equals(type))) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(createErrorResponse("Invalid barcode type"))
                        .build();
            }

            String filePath = barcodeService.getBarcodePath(prescriptionId, type);

            if (!imageService.isImageValid(filePath)) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(createErrorResponse("Barcode image not found"))
                        .build();
            }

            // Get metadata
            Map<String, Object> metadata = imageService.getImageMetadata(filePath);

            Map<String, Object> response =
                    createSuccessResponse("Barcode image metadata", metadata);

            logger.info("Barcode image metadata retrieved: " + prescriptionId);
            return Response.ok(response).build();

        } catch (Exception e) {
            logger.severe("Error retrieving image metadata: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createErrorResponse("Error retrieving image metadata"))
                    .build();
        }
    }

    /**
     * Validate barcode image GET /api/prescription/{prescriptionId}/image-validate/{type}
     *
     * @param prescriptionId The prescription ID
     * @param type The barcode type
     * @return Response with validation results
     */
    @GET
    @Path("/{prescriptionId}/image-validate/{type}")
    public Response validateBarcodeImage(
            @PathParam("prescriptionId") String prescriptionId, @PathParam("type") String type) {
        try {
            if (!("code128".equals(type) || "qrcode".equals(type))) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(createErrorResponse("Invalid barcode type"))
                        .build();
            }

            String filePath = barcodeService.getBarcodePath(prescriptionId, type);

            // Validate image
            Map<String, Object> validation = imageService.validateImage(filePath);

            Map<String, Object> response =
                    createSuccessResponse("Barcode image validation result", validation);

            logger.info("Barcode image validated: " + prescriptionId);
            return Response.ok(response).build();

        } catch (Exception e) {
            logger.severe("Error validating image: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createErrorResponse("Error validating image"))
                    .build();
        }
    }

    /**
     * Get barcode image as HTML embed Returns HTML with embedded Base64 image GET
     * /api/prescription/{prescriptionId}/image-html/{type}
     *
     * @param prescriptionId The prescription ID
     * @param type The barcode type
     * @return HTML response with embedded image
     */
    @GET
    @Path("/{prescriptionId}/image-html/{type}")
    @Produces(MediaType.TEXT_HTML)
    public Response getBarcodeAsHtml(
            @PathParam("prescriptionId") String prescriptionId, @PathParam("type") String type) {
        try {
            if (!("code128".equals(type) || "qrcode".equals(type))) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("<h2>Error</h2><p>Invalid barcode type</p>")
                        .build();
            }

            String filePath = barcodeService.getBarcodePath(prescriptionId, type);

            if (!imageService.isImageValid(filePath)) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("<h2>Error</h2><p>Barcode image not found</p>")
                        .build();
            }

            // Get Base64 image
            String base64Image = imageService.getImageAsBase64(filePath);

            // Create HTML
            String html =
                    "<!DOCTYPE html>"
                            + "<html>"
                            + "<head>"
                            + "<title>Barcode - "
                            + prescriptionId
                            + "</title><style>body { font-family: Arial, sans-serif; margin: 20px;"
                            + " }.container { max-width: 800px; margin: 0 auto; }.header {"
                            + " background-color: #f0f0f0; padding: 10px; border-radius: 5px;"
                            + " margin-bottom: 20px; }.image-section { text-align: center; padding:"
                            + " 20px; border: 1px solid #ddd; border-radius: 5px; }img { max-width:"
                            + " 100%; height: auto; margin: 20px 0; }.info { background-color:"
                            + " #f9f9f9; padding: 10px; margin-top: 20px; border-left: 4px solid"
                            + " #0066cc; }</style></head><body><div class=\"container\"><div"
                            + " class=\"header\"><h1>Prescription"
                            + " Barcode</h1><p><strong>Prescription ID:</strong> "
                            + prescriptionId
                            + "</p>"
                            + "<p><strong>Barcode Type:</strong> "
                            + type
                            + "</p>"
                            + "</div>"
                            + "<div class=\"image-section\">"
                            + "<h2>Barcode Image</h2>"
                            + "<img src=\""
                            + base64Image
                            + "\" alt=\""
                            + type
                            + " Barcode\"></div><div class=\"info\"><p><strong>Note:</strong> This"
                            + " is a self-contained HTML document with an embedded barcode"
                            + " image.</p></div></div></body></html>";

            logger.info("Barcode HTML document generated: " + prescriptionId);
            return Response.ok(html).build();

        } catch (Exception e) {
            logger.severe("Error generating HTML: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("<h2>Error</h2><p>Error generating HTML document</p>")
                    .build();
        }
    }

    /**
     * Get image format information GET /api/prescription/image-formats
     *
     * @return Response with supported image formats
     */
    @GET
    @Path("/image-formats")
    public Response getImageFormats() {
        try {
            List<String> formats = imageService.getSupportedFormats();

            Map<String, Object> response =
                    createSuccessResponse(
                            "Supported image formats",
                            new LinkedHashMap<String, Object>() {
                                {
                                    put("formats", formats);
                                    put("count", formats.size());
                                    put("primaryFormat", "png");
                                }
                            });

            return Response.ok(response).build();

        } catch (Exception e) {
            logger.severe("Error retrieving formats: " + e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(createErrorResponse("Error retrieving formats"))
                    .build();
        }
    }
}
