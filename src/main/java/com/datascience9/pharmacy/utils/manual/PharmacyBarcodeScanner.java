package com.datascience9.pharmacy.utils.manual;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import javax.imageio.ImageIO;

public class PharmacyBarcodeScanner {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: java PharmacyBarcodeScanner <image-path>");
            System.exit(1);
        }

        File imageFile = new File(args[0]);
        String result = scanBarcodeFromImage(imageFile);

        if (result != null) {
            System.out.println("Decoded barcode text: " + result);
        } else {
            System.out.println("No barcode detected.");
        }
    }

    public static String scanBarcodeFromImage(File imageFile) {
        try {
            BufferedImage bufferedImage = ImageIO.read(imageFile);
            if (bufferedImage == null) {
                System.err.println("Unable to read image: " + imageFile);
                return null;
            }

            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Map<DecodeHintType, Object> hints = new EnumMap<>(DecodeHintType.class);
            hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
            hints.put(
                    DecodeHintType.POSSIBLE_FORMATS,
                    EnumSet.of(
                            BarcodeFormat.CODE_128,
                            BarcodeFormat.EAN_13,
                            BarcodeFormat.CODE_39,
                            BarcodeFormat.DATA_MATRIX,
                            BarcodeFormat.QR_CODE,
                            BarcodeFormat.UPC_A,
                            BarcodeFormat.UPC_E));

            Result result = new MultiFormatReader().decode(bitmap, hints);
            System.out.println("Barcode format: " + result.getBarcodeFormat());
            return result.getText();

        } catch (NotFoundException e) {
            // Barcode not found
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
