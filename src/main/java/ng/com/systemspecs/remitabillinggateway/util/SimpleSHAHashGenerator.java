package ng.com.systemspecs.remitabillinggateway.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * A util class used for SHA512 encryption
 *
 *
 * @author Ilesanmi Omoniyi
 *
 * @since 1.0.0
 */
public class SimpleSHAHashGenerator {

    private static final String ALGORITHM_SHA_512 = "SHA-512";

    private static final String ENCODING_UTF_8 = "UTF-8";


    public static String generateSHA512SecurePassword(String inputToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(inputToHash.getBytes("UTF-8"));
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            byte[] var5 = bytes;
            int var6 = bytes.length;
            for (int var7 = 0; var7 < var6; ++var7) {
                byte b = var5[var7];
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException var9) {
            var9.printStackTrace();
        } catch (UnsupportedEncodingException var10) {
            var10.printStackTrace();
        }
        return generatedPassword;
    }


    public SimpleSHAHashGenerator() {
    }
}
