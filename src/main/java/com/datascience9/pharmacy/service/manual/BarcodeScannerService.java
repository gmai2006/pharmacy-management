package com.datascience9.pharmacy.service.manual;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;

public class BarcodeScannerService {

    public ScanResult scanBase64(String base64Image) {
        try {
            // Clean data URL prefix if present
            if (base64Image.contains(",")) {
                base64Image = base64Image.substring(base64Image.indexOf(",") + 1);
            }

            byte[] imageBytes = Base64.getDecoder().decode(base64Image);
            InputStream imageStream = new ByteArrayInputStream(imageBytes);

            return scan(imageStream);
        } catch (Exception e) {
            return ScanResult.error("Invalid Base64 image: " + e.getMessage());
        }
    }

    public ScanResult scan(InputStream imageStream) {
        try {
            BufferedImage bufferedImage = ImageIO.read(imageStream);
            if (bufferedImage == null) {
                return ScanResult.error("Unable to decode image");
            }

            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Map<DecodeHintType, Object> hints = new EnumMap<>(DecodeHintType.class);
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            hints.put(
                    DecodeHintType.POSSIBLE_FORMATS,
                    EnumSet.of(
                            BarcodeFormat.CODE_128,
                            BarcodeFormat.CODE_39,
                            BarcodeFormat.EAN_13,
                            BarcodeFormat.UPC_A,
                            BarcodeFormat.UPC_E,
                            BarcodeFormat.DATA_MATRIX,
                            BarcodeFormat.QR_CODE
                    )
            );

            Result result = new MultiFormatReader().decode(bitmap, hints);

            return ScanResult.success(result.getText(), result.getBarcodeFormat().name());

        } catch (NotFoundException e) {
            return ScanResult.error("No barcode detected in image");
        } catch (Exception e) {
            e.printStackTrace();
            return ScanResult.error("Error processing barcode: " + e.getMessage());
        }
    }

    // DTO for results
    public static class ScanResult {
        public boolean success;
        public String message;
        public String format;

        public static ScanResult success(String message, String format) {
            ScanResult r = new ScanResult();
            r.success = true;
            r.message = message;
            r.format = format;
            return r;
        }

        public static ScanResult error(String msg) {
            ScanResult r = new ScanResult();
            r.success = false;
            r.message = msg;
            return r;
        }
    }
}

