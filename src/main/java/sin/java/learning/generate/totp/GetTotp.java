package sin.java.learning.generate.totp;

import org.apache.commons.codec.binary.Base32;

import java.nio.ByteBuffer;
import java.time.Instant;

public class GetTotp {
    public String getTOTP() {
        final int TIME_STEP = 30; // Time step in seconds
        final int TOTP_LENGTH = 6; // TOTP length in digits

        Base32 base32 = new Base32();
        byte[] keyBytes = base32.decode(System.getenv("TOTP_KEY"));
        try {

            long currentTime = Instant.now().getEpochSecond();
            long counter = currentTime / TIME_STEP;

            ByteBuffer buffer = ByteBuffer.allocate(8);
            buffer.putLong(0, counter);

            // Generate HMAC-SHA1 hash
            javax.crypto.Mac mac = javax.crypto.Mac.getInstance("HmacSHA1");
//            mac.init(new javax.crypto.spec.SecretKeySpec(secretKey, "RAW"));
            mac.init(new javax.crypto.spec.SecretKeySpec(keyBytes, "RAW"));
            byte[] hmac = mac.doFinal(buffer.array());

            // Determine the offset
            int offset = hmac[hmac.length - 1] & 0x0f;

            // Calculate the truncated value
            int truncatedHash = (hmac[offset] & 0x7f) << 24 |
                    (hmac[offset + 1] & 0xff) << 16 |
                    (hmac[offset + 2] & 0xff) << 8 |
                    (hmac[offset + 3] & 0xff);

            // Generate the TOTP value
            int totpValue = truncatedHash % (int) Math.pow(10, TOTP_LENGTH);
            String totp = String.format("%0" + TOTP_LENGTH + "d", totpValue);
            return totp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
