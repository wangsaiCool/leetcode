import com.ibm.icu.impl.Assert;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * Created by WangSai on 2023/3/24
 */
public class testBase64 {
    private static final Random rand = new Random();
    private static final DataProtectionWrapperMock provider = new DataProtectionWrapperMock("test_sid");

    public static void main(String[] args) {
        // encode & decode
        String raw = "micloudquotaservice-3Rhc2Vydml3Rhc2VydmljZQjZQbWljbG91ZHF1b";
        String encodeBase64 = encodeBase64(raw);
        String decodeBase64 = decodeBase64(encodeBase64);
        Assert.assrt(StringUtils.equals(raw, decodeBase64));

        // encrypt & decrypt
        String encrypted = encrypt(raw);
        String decrypt = decrypt(encrypted);
        Assert.assrt(StringUtils.equals(raw, decrypt));
    }

    private static String decrypt(String encrypted) {
        byte[] decodeBase64 = Base64.decodeBase64(encrypted);
        byte[] decrypted = provider.decrypt(decodeBase64, false);
        return new String(decrypted);
    }

    private static String encrypt(String raw) {
        byte[] encrypted = provider.encrypt(raw.getBytes(StandardCharsets.UTF_8), false);
        return Base64.encodeBase64URLSafeString(encrypted);
    }

    private static String encodeBase64(String raw) {
        byte[] bytes = raw.getBytes(StandardCharsets.UTF_8);
        return Base64.encodeBase64URLSafeString(bytes);
    }

    private static String decodeBase64(String encode) {
        byte[] bytes2 = Base64.decodeBase64(encode);
        return new String(bytes2, StandardCharsets.UTF_8);
    }

    static class DataProtectionWrapperMock {
        private final String sid;

        public DataProtectionWrapperMock(String sid) {
            this.sid = sid;
        }

        public byte[] decrypt(byte[] encryptedBytes, boolean doSnappyCompression) {
            return encryptedBytes;
        }

        public byte[] encrypt(byte[] rawBytes, boolean doSnappyCompression) {
            return rawBytes;
        }

    }
}
