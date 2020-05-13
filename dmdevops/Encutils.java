package dmdevops;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;

/**
 * Utility Functions for Encryption and Decryption
 */
public class Encutils {
    private static String SYMMETRIC_KEY_ALGORITHM = "AES";
    private static int SYMMETRIC_KEY_LENGTH = 256;
    private static String HELP =
            "To encrypt -> java -cp dm-devops-encutil.jar dmdevops.Encutils -e key valueToEncrypt" + "\n" +
                    "To decrypt -> java -cp dm-devops-encutil.jar dmdevops.Encutils -d key valueToDecrypt";

    public static void main(String args[]) {
        try {
            String mode = args[0];
            String key = args[1];
            String value = args[2];

            if (args.length == 3) {
                if ("-e".equals(mode)) {
                    System.out.println("encrypted - " + encrypt(key.trim(), value.trim()));
                } else if ("-d".equals(mode)) {
                    System.out.println("decrypted - " + decrypt(key.trim(), value.trim()));
                } else {
                    System.out.println(HELP);
                }
            } else {
                System.out.println(HELP);
            }
        } catch (ArrayIndexOutOfBoundsException ex1) {
            System.out.println(HELP);
        } catch (Exception ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
    }

    public static String generateSymmetricKey() {
        try {
            KeyGenerator kg = KeyGenerator.getInstance(SYMMETRIC_KEY_ALGORITHM);
            kg.init(SYMMETRIC_KEY_LENGTH);
            return encode2Hex(KeyGenerator.getInstance(SYMMETRIC_KEY_ALGORITHM).generateKey().getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public static String encrypt(String key, String data) {
        try {
            Cipher c = Cipher.getInstance(SYMMETRIC_KEY_ALGORITHM);
            SecretKeySpec k = new SecretKeySpec(decodeFromHex(key), SYMMETRIC_KEY_ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, k);
            return encode2Hex(c.doFinal(data.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String key, String encrypted) {
        try {
            Cipher c = Cipher.getInstance(SYMMETRIC_KEY_ALGORITHM);
            SecretKeySpec k = new SecretKeySpec(decodeFromHex(key), SYMMETRIC_KEY_ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, k);
            return new String(c.doFinal(decodeFromHex(encrypted)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Encutils() {
    }

    public static String encode2Hex(byte[] bytes) {
        return DatatypeConverter.printHexBinary(bytes).toLowerCase();
    }

    public static byte[] decodeFromHex(String hexString) {
        return DatatypeConverter.parseHexBinary(hexString);
    }
}
