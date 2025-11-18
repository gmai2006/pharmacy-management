package com.datascience9.pharmacy.service.manual;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Prescription Barcode Generator Utility - Jakarta Version Generates CODE128 and QR code barcodes
 * from prescription and patient information Uses Java logging (java.util.logging.Logger) instead of
 * SLF4J
 */
public class PrescriptionBarcodeGenerator {

    private static final Logger logger =
            Logger.getLogger(PrescriptionBarcodeGenerator.class.getName());

    private static final int BARCODE_WIDTH = 600;
    private static final int BARCODE_HEIGHT = 200;

    /** Prescription Data Model */
    public static class PrescriptionData {
        public String prescriptionId;
        public long issueDate;
        public String status;
        public String priority;
        public String drugName;
        public String drugStrength;
        public String drugForm;
        public String firstName;
        public String lastName;
        public String patientMrn;
        public int[] patientDob;
        public String patientGender;
        public String prescriberName;
        public Double copayFixed;
        public String insuranceCompanyName;

        // Constructor
        public PrescriptionData() {}

        @Override
        public String toString() {
            return "PrescriptionData{"
                    + "prescriptionId='"
                    + prescriptionId
                    + '\''
                    + ", firstName='"
                    + firstName
                    + '\''
                    + ", lastName='"
                    + lastName
                    + '\''
                    + ", patientMrn='"
                    + patientMrn
                    + '\''
                    + ", drugName='"
                    + drugName
                    + '\''
                    + ", drugStrength='"
                    + drugStrength
                    + '\''
                    + '}';
        }
    }

    /**
     * Generate barcode from prescription data Creates both CODE128 and QR code barcodes
     *
     * @param prescriptionData The prescription and patient data
     * @param outputPath The path where barcode images will be saved
     * @return Map containing paths to generated barcode files
     * @throws WriterException If barcode writing fails
     * @throws IOException If file I/O fails
     */
    public static Map<String, String> generatePrescriptionBarcode(
            PrescriptionData prescriptionData, String outputPath)
            throws WriterException, IOException {

        // Create output directory if it doesn't exist
        File outputDir = new File(outputPath);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        Map<String, String> generatedBarcodes = new HashMap<>();

        // Generate CODE128 barcode (for standard retail barcode scanning)
        String code128Path = generateCode128Barcode(prescriptionData, outputPath);
        generatedBarcodes.put("code128", code128Path);

        // Generate QR code (for digital/mobile scanning)
        String qrCodePath = generateQRCode(prescriptionData, outputPath);
        generatedBarcodes.put("qrcode", qrCodePath);

        return generatedBarcodes;
    }

    /**
     * Generate CODE128 barcode with prescription ID
     *
     * @param prescriptionData The prescription data
     * @param outputPath The output directory path
     * @return Path to the generated barcode file
     * @throws WriterException If barcode writing fails
     * @throws IOException If file I/O fails
     */
    private static String generateCode128Barcode(
            PrescriptionData prescriptionData, String outputPath)
            throws WriterException, IOException {

        // Create barcode data: RX-{PrescriptionID}-{MRN}
        String barcodeData =
                String.format(
                        "RX-%s-%s",
                        prescriptionData.prescriptionId.substring(0, 8),
                        prescriptionData.patientMrn);

        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix bitMatrix =
                writer.encode(barcodeData, BarcodeFormat.CODE_128, BARCODE_WIDTH, BARCODE_HEIGHT);

        String fileName =
                String.format(
                        "%s/prescription_%s_code128.png",
                        outputPath, prescriptionData.prescriptionId.substring(0, 8));
        Path path = FileSystems.getDefault().getPath(fileName);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        logger.info("CODE128 Barcode generated: " + fileName);

        return fileName;
    }

    /**
     * Generate QR code with comprehensive prescription information QR code contains JSON-formatted
     * prescription data for mobile scanning
     *
     * @param prescriptionData The prescription data
     * @param outputPath The output directory path
     * @return Path to the generated QR code file
     * @throws WriterException If barcode writing fails
     * @throws IOException If file I/O fails
     */
    private static String generateQRCode(PrescriptionData prescriptionData, String outputPath)
            throws WriterException, IOException {

        // Create comprehensive QR code data
        String qrData = buildQRCodeData(prescriptionData);

        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix bitMatrix =
                writer.encode(qrData, BarcodeFormat.QR_CODE, BARCODE_WIDTH, BARCODE_HEIGHT);

        String fileName =
                String.format(
                        "%s/prescription_%s_qr.png",
                        outputPath, prescriptionData.prescriptionId.substring(0, 8));
        Path path = FileSystems.getDefault().getPath(fileName);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        logger.info("QR Code generated: " + fileName);

        return fileName;
    }

    /**
     * Build QR code data string with prescription information Format: pipe-delimited for easy
     * parsing
     *
     * @param data The prescription data
     * @return Formatted string for QR code encoding
     */
    private static String buildQRCodeData(PrescriptionData data) {
        LocalDate dob = LocalDate.of(data.patientDob[0], data.patientDob[1], data.patientDob[2]);

        return String.format(
                "RX|ID:%s|PAT:%s|MRN:%s|DOB:%s|DRUG:%s|STR:%s|FORM:%s|PRESC:%s|INS:%s|COPAY:$%.2f",
                data.prescriptionId,
                data.firstName + " " + data.lastName,
                data.patientMrn,
                dob,
                data.drugName,
                data.drugStrength,
                data.drugForm,
                data.prescriberName,
                data.insuranceCompanyName,
                data.copayFixed != null ? data.copayFixed : 0.0);
    }

    /**
     * Generate barcode with custom formatting (for printing)
     *
     * @param prescriptionData The prescription data
     * @param outputPath The output directory path
     * @return Path to the generated barcode with label file
     * @throws WriterException If barcode writing fails
     * @throws IOException If file I/O fails
     */
    public static String generateLabeledBarcode(
            PrescriptionData prescriptionData, String outputPath)
            throws WriterException, IOException {

        // Generate basic barcode first
        String barcodeData =
                String.format(
                        "RX-%s-%s",
                        prescriptionData.prescriptionId.substring(0, 8),
                        prescriptionData.patientMrn);

        MultiFormatWriter writer = new MultiFormatWriter();
        BitMatrix bitMatrix =
                writer.encode(barcodeData, BarcodeFormat.CODE_128, BARCODE_WIDTH, BARCODE_HEIGHT);

        String fileName =
                String.format(
                        "%s/prescription_%s_labeled.png",
                        outputPath, prescriptionData.prescriptionId.substring(0, 8));
        Path path = FileSystems.getDefault().getPath(fileName);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

        return fileName;
    }

    /**
     * Validate prescription data before barcode generation
     *
     * @param data The prescription data to validate
     * @return true if data is valid, false otherwise
     */
    public static boolean validatePrescriptionData(PrescriptionData data) {
        if (data == null) {
            logger.severe("Error: Prescription data is null");
            return false;
        }

        if (data.prescriptionId == null || data.prescriptionId.isEmpty()) {
            logger.severe("Error: Prescription ID is required");
            return false;
        }

        if (data.patientMrn == null || data.patientMrn.isEmpty()) {
            logger.severe("Error: Patient MRN is required");
            return false;
        }

        if (data.firstName == null || data.firstName.isEmpty()) {
            logger.severe("Error: Patient first name is required");
            return false;
        }

        if (data.lastName == null || data.lastName.isEmpty()) {
            logger.severe("Error: Patient last name is required");
            return false;
        }

        if (data.drugName == null || data.drugName.isEmpty()) {
            logger.severe("Error: Drug name is required");
            return false;
        }

        if (data.patientDob == null || data.patientDob.length != 3) {
            logger.severe("Error: Patient DOB must be in [year, month, day] format");
            return false;
        }

        return true;
    }

    /**
     * Generate prescription barcode from JSON-like data
     *
     * @param jsonData The JSON prescription data as a map
     * @param outputPath The output directory path
     * @return Map of generated barcode file paths
     * @throws WriterException If barcode writing fails
     * @throws IOException If file I/O fails
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> generateFromJsonData(
            Map<String, Object> jsonData, String outputPath) throws WriterException, IOException {

        PrescriptionData prescriptionData = mapJsonToPrescriptionData(jsonData);

        if (!validatePrescriptionData(prescriptionData)) {
            throw new IllegalArgumentException("Invalid prescription data");
        }

        return generatePrescriptionBarcode(prescriptionData, outputPath);
    }

    /**
     * Convert JSON/Map data to PrescriptionData object
     *
     * @param jsonData The JSON data as a map
     * @return PrescriptionData object
     */
    @SuppressWarnings("unchecked")
    private static PrescriptionData mapJsonToPrescriptionData(Map<String, Object> jsonData) {
        PrescriptionData data = new PrescriptionData();

        data.prescriptionId = (String) jsonData.getOrDefault("prescriptionId", "");
        data.issueDate = ((Number) jsonData.getOrDefault("issueDate", 0L)).longValue();
        data.status = (String) jsonData.getOrDefault("status", "");
        data.priority = (String) jsonData.getOrDefault("priority", "");
        data.drugName = (String) jsonData.getOrDefault("drugName", "");
        data.drugStrength = (String) jsonData.getOrDefault("drugStrength", "");
        data.drugForm = (String) jsonData.getOrDefault("drugForm", "");
        data.firstName = (String) jsonData.getOrDefault("firstName", "");
        data.lastName = (String) jsonData.getOrDefault("lastName", "");
        data.patientMrn = (String) jsonData.getOrDefault("patientMrn", "");
        data.patientGender = (String) jsonData.getOrDefault("patientGender", "");
        data.prescriberName = (String) jsonData.getOrDefault("prescriberName", "");
        data.insuranceCompanyName = (String) jsonData.getOrDefault("insuranceCompanyName", "");
        data.copayFixed = ((Number) jsonData.getOrDefault("copayFixed", 0.0)).doubleValue();

        Object dobObj = jsonData.get("patientDob");
        if (dobObj instanceof int[]) {
            data.patientDob = (int[]) dobObj;
        } else if (dobObj instanceof java.util.List) {
            java.util.List<Integer> dobList = (java.util.List<Integer>) dobObj;
            data.patientDob = new int[] {dobList.get(0), dobList.get(1), dobList.get(2)};
        }

        return data;
    }

    /** Main method demonstrating barcode generation */
    public static void main(String[] args) {
        try {
            // Create sample prescription data
            PrescriptionData prescription = new PrescriptionData();
            prescription.prescriptionId = "dd0e8400-e29b-41d4-a716-446655440001";
            prescription.issueDate = 1762765708409022000L;
            prescription.status = "filled";
            prescription.priority = "normal";
            prescription.drugName = "Lisinopril";
            prescription.drugStrength = "10mg";
            prescription.drugForm = "tablet";
            prescription.firstName = "James";
            prescription.lastName = "Anderson";
            prescription.patientMrn = "MRN001";
            prescription.patientDob = new int[] {1985, 3, 15};
            prescription.patientGender = "Male";
            prescription.prescriberName = "Dr. James Smith";
            prescription.insuranceCompanyName = "BlueCross BlueShield";
            prescription.copayFixed = 25.00;

            // Validate data
            if (!validatePrescriptionData(prescription)) {
                System.exit(1);
            }

            // Generate barcodes
            System.out.println("Generating barcodes for: " + prescription);
            Map<String, String> barcodes = generatePrescriptionBarcode(prescription, ".");

            System.out.println("\nBarcodes generated successfully:");
            barcodes.forEach((type, path) -> System.out.println("  " + type + ": " + path));

        } catch (WriterException | IOException e) {
            System.err.println("Error generating barcode: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
