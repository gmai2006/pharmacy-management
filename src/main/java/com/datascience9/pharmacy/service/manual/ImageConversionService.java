package com.datascience9.pharmacy.service.manual;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Image Conversion Service Handles conversion and processing of barcode images Provides utilities
 * for image manipulation and format conversion
 */
public class ImageConversionService {

    private static final Logger logger = Logger.getLogger(ImageConversionService.class.getName());

    private static final String PNG_MIME_TYPE = "image/png";
    private static final String JPEG_MIME_TYPE = "image/jpeg";
    private static final String GIF_MIME_TYPE = "image/gif";
    private static final String BMP_MIME_TYPE = "image/bmp";
    private static final String SVG_MIME_TYPE = "image/svg+xml";

    private static final Map<String, String> SUPPORTED_FORMATS = new HashMap<>();

    static {
        SUPPORTED_FORMATS.put("png", PNG_MIME_TYPE);
        SUPPORTED_FORMATS.put("jpg", JPEG_MIME_TYPE);
        SUPPORTED_FORMATS.put("jpeg", JPEG_MIME_TYPE);
        SUPPORTED_FORMATS.put("gif", GIF_MIME_TYPE);
        SUPPORTED_FORMATS.put("bmp", BMP_MIME_TYPE);
    }

    /** Image data wrapper */
    public static class ImageData {
        public byte[] data;
        public String mimeType;
        public String format;
        public long fileSize;
        public int width;
        public int height;

        public ImageData(byte[] data, String mimeType, String format) {
            this.data = data;
            this.mimeType = mimeType;
            this.format = format;
            this.fileSize = data.length;
        }

        public ImageData(byte[] data, String mimeType, String format, int width, int height) {
            this(data, mimeType, format);
            this.width = width;
            this.height = height;
        }

        @Override
        public String toString() {
            return "ImageData{"
                    + "format='"
                    + format
                    + '\''
                    + ", mimeType='"
                    + mimeType
                    + '\''
                    + ", fileSize="
                    + fileSize
                    + ", width="
                    + width
                    + ", height="
                    + height
                    + '}';
        }
    }

    /**
     * Read barcode image from file
     *
     * @param filePath Path to the barcode image file
     * @param format Image format (png, jpg, etc.)
     * @return ImageData object containing image bytes and metadata
     * @throws IOException If file cannot be read
     */
    public ImageData readBarcodeImage(String filePath, String format) throws IOException {
        logger.info("Reading barcode image from: " + filePath);

        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            logger.warning("Image file not found: " + filePath);
            throw new FileNotFoundException("Image file not found: " + filePath);
        }

        // Read file bytes
        byte[] imageBytes = Files.readAllBytes(path);

        // Determine MIME type
        String mimeType = getMimeType(format);

        // Create image data
        ImageData imageData = new ImageData(imageBytes, mimeType, format);

        logger.info("Image read successfully: " + imageData);
        return imageData;
    }

    /**
     * Convert barcode file to ImageData Handles PNG files (standard barcode output)
     *
     * @param filePath Path to the PNG barcode file
     * @return ImageData object with PNG image
     * @throws IOException If file cannot be read
     */
    public ImageData convertBarcodeToImage(String filePath) throws IOException {
        return convertBarcodeToImage(filePath, "png");
    }

    /**
     * Convert barcode file to specific image format
     *
     * @param filePath Path to the barcode image file
     * @param targetFormat Target format (png, jpg, gif, bmp)
     * @return ImageData object with converted image
     * @throws IOException If file cannot be read or converted
     */
    public ImageData convertBarcodeToImage(String filePath, String targetFormat)
            throws IOException {
        logger.info("Converting barcode image to format: " + targetFormat);

        if (!SUPPORTED_FORMATS.containsKey(targetFormat.toLowerCase())) {
            logger.warning("Unsupported format: " + targetFormat);
            throw new IllegalArgumentException(
                    "Unsupported format: "
                            + targetFormat
                            + ". Supported formats: "
                            + SUPPORTED_FORMATS.keySet());
        }

        // For now, read the PNG and return as-is (or convert if needed)
        ImageData imageData = readBarcodeImage(filePath, "png");

        // If target format is PNG, return as-is
        if ("png".equalsIgnoreCase(targetFormat)) {
            return imageData;
        }

        // TODO: Add format conversion using ImageIO if needed
        logger.warning("Format conversion not yet implemented. Returning original PNG format.");

        return imageData;
    }

    /**
     * Get image as Base64 encoded string Useful for embedding in HTML/JSON
     *
     * @param filePath Path to the barcode image file
     * @return Base64 encoded image string with data URI prefix
     * @throws IOException If file cannot be read
     */
    public String getImageAsBase64(String filePath) throws IOException {
        logger.info("Converting image to Base64: " + filePath);

        ImageData imageData = readBarcodeImage(filePath, "png");
        String base64 = Base64.getEncoder().encodeToString(imageData.data);
        String dataUri = "data:" + imageData.mimeType + ";base64," + base64;

        logger.info("Base64 conversion successful, size: " + dataUri.length() + " bytes");
        return dataUri;
    }

    /**
     * Get image as Base64 with metadata
     *
     * @param filePath Path to the barcode image file
     * @return Map containing base64 data and metadata
     * @throws IOException If file cannot be read
     */
    public Map<String, Object> getImageAsBase64WithMetadata(String filePath) throws IOException {
        logger.fine("Getting image as Base64 with metadata: " + filePath);

        ImageData imageData = readBarcodeImage(filePath, "png");
        String base64 = Base64.getEncoder().encodeToString(imageData.data);
        String dataUri = "data:" + imageData.mimeType + ";base64," + base64;

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("base64", base64);
        result.put("dataUri", dataUri);
        result.put("mimeType", imageData.mimeType);
        result.put("format", imageData.format);
        result.put("fileSize", imageData.fileSize);
        result.put("width", imageData.width);
        result.put("height", imageData.height);

        return result;
    }

    /**
     * Get raw image bytes
     *
     * @param filePath Path to the barcode image file
     * @return Byte array of image data
     * @throws IOException If file cannot be read
     */
    public byte[] getImageBytes(String filePath) throws IOException {
        logger.fine("Getting raw image bytes: " + filePath);
        ImageData imageData = readBarcodeImage(filePath, "png");
        return imageData.data;
    }

    /**
     * Get image information/metadata
     *
     * @param filePath Path to the barcode image file
     * @return Map containing image metadata
     * @throws IOException If file cannot be read
     */
    public Map<String, Object> getImageMetadata(String filePath) throws IOException {
        logger.fine("Getting image metadata: " + filePath);

        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            throw new FileNotFoundException("Image file not found: " + filePath);
        }

        File file = new File(filePath);
        ImageData imageData = readBarcodeImage(filePath, "png");

        Map<String, Object> metadata = new LinkedHashMap<>();
        metadata.put("fileName", file.getName());
        metadata.put("filePath", filePath);
        metadata.put("fileSize", imageData.fileSize);
        metadata.put("format", imageData.format);
        metadata.put("mimeType", imageData.mimeType);
        metadata.put("lastModified", file.lastModified());
        metadata.put("width", imageData.width);
        metadata.put("height", imageData.height);

        return metadata;
    }

    /**
     * Check if image file exists and is readable
     *
     * @param filePath Path to the image file
     * @return true if file exists and is readable
     */
    public boolean isImageValid(String filePath) {
        Path path = Paths.get(filePath);
        boolean exists = Files.exists(path);
        boolean readable = exists && Files.isReadable(path);

        logger.fine(
                "Image validation for "
                        + filePath
                        + ": exists="
                        + exists
                        + ", readable="
                        + readable);
        return readable;
    }

    /**
     * Get supported image formats
     *
     * @return List of supported formats
     */
    public List<String> getSupportedFormats() {
        return new ArrayList<>(SUPPORTED_FORMATS.keySet());
    }

    /**
     * Get MIME type for image format
     *
     * @param format Image format (png, jpg, etc.)
     * @return MIME type string
     */
    public String getMimeType(String format) {
        String mimeType = SUPPORTED_FORMATS.getOrDefault(format.toLowerCase(), PNG_MIME_TYPE);
        logger.fine("MIME type for format '" + format + "': " + mimeType);
        return mimeType;
    }

    /**
     * Validate image file
     *
     * @param filePath Path to image file
     * @return Map with validation results
     */
    public Map<String, Object> validateImage(String filePath) {
        Map<String, Object> validation = new LinkedHashMap<>();

        try {
            Path path = Paths.get(filePath);

            validation.put("filePath", filePath);
            validation.put("exists", Files.exists(path));
            validation.put("isFile", Files.isRegularFile(path));
            validation.put("isReadable", Files.isReadable(path));

            if (Files.exists(path)) {
                long fileSize = Files.size(path);
                validation.put("fileSizeBytes", fileSize);
                validation.put("fileSizeKB", fileSize / 1024.0);
                validation.put("fileSize", String.format("%.2f KB", fileSize / 1024.0));
            }

            validation.put("valid", true);
            validation.put("message", "Image file is valid");

            logger.info("Image validation successful: " + filePath);

        } catch (IOException e) {
            logger.log(Level.WARNING, "Image validation failed: " + filePath, e);
            validation.put("valid", false);
            validation.put("message", "Error validating image: " + e.getMessage());
        }

        return validation;
    }

    /**
     * Get image in multiple formats Returns same image data with different MIME types
     *
     * @param filePath Path to image file
     * @return Map with image data and metadata
     * @throws IOException If file cannot be read
     */
    public Map<String, Object> getImageMultiFormat(String filePath) throws IOException {
        logger.fine("Getting image in multiple formats: " + filePath);

        ImageData imageData = readBarcodeImage(filePath, "png");

        Map<String, Object> result = new LinkedHashMap<>();
        result.put(
                "formats",
                new LinkedHashMap<String, Object>() {
                    {
                        put(
                                "png",
                                new LinkedHashMap<String, Object>() {
                                    {
                                        put("mimeType", PNG_MIME_TYPE);
                                        put("fileSize", imageData.fileSize);
                                        put(
                                                "base64",
                                                Base64.getEncoder().encodeToString(imageData.data));
                                        put(
                                                "dataUri",
                                                "data:"
                                                        + PNG_MIME_TYPE
                                                        + ";base64,"
                                                        + Base64.getEncoder()
                                                                .encodeToString(imageData.data));
                                    }
                                });
                    }
                });
        result.put(
                "metadata",
                new LinkedHashMap<String, Object>() {
                    {
                        put("width", imageData.width);
                        put("height", imageData.height);
                        put("format", imageData.format);
                        put("mimeType", imageData.mimeType);
                    }
                });

        return result;
    }

    /**
     * Get thumbnail/preview of image as Base64 For now returns full image (thumbnail generation
     * would require image scaling)
     *
     * @param filePath Path to image file
     * @param maxSize Maximum size for thumbnail (width/height)
     * @return Map with thumbnail data
     * @throws IOException If file cannot be read
     */
    public Map<String, Object> getImageThumbnail(String filePath, int maxSize) throws IOException {
        logger.info("Getting image thumbnail: " + filePath + ", maxSize: " + maxSize);

        ImageData imageData = readBarcodeImage(filePath, "png");
        String base64 = Base64.getEncoder().encodeToString(imageData.data);

        Map<String, Object> thumbnail = new LinkedHashMap<>();
        thumbnail.put("base64", base64);
        thumbnail.put("dataUri", "data:" + imageData.mimeType + ";base64," + base64);
        thumbnail.put("mimeType", imageData.mimeType);
        thumbnail.put("originalSize", imageData.fileSize);
        thumbnail.put(
                "note",
                "Thumbnail generation requires image scaling library. Returning full image.");

        return thumbnail;
    }

    /** Main method for testing */
    public static void main(String[] args) {
        try {
            ImageConversionService service = new ImageConversionService();

            System.out.println("Supported formats: " + service.getSupportedFormats());
            System.out.println("MIME type for PNG: " + service.getMimeType("png"));

            logger.info("ImageConversionService test completed successfully");

        } catch (Exception e) {
            System.err.println("Error in test: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
