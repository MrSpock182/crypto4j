package io.github.mrspock182;

import io.github.mrspock182.constant.Cipher;
import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.constant.Unicode;
import io.github.mrspock182.decryption.DecryptionSymmetrical;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;

public class DecryptionSymmetricalTest {

    Decryption decryption = new DecryptionSymmetrical(TypeEncryption.AES, Unicode.UTF8,
            "O!Wed567BxC@xz1B", Cipher.PKCS5PADDING);

    @Test
    public void testDecryptLong() {
        Long value = decryption.toLong("0nacAW1wV6EcZhW6Bx53KA==");
        assertNotNull(value);
    }

    @Test
    public void testDecryptString() {
        String value = decryption.toString("JBoUx-Gr2FbtQLdci1fkKA==");
        assertNotNull(value);
    }

    @Test
    public void testDecryptInteger() {
        Integer value = decryption.toInteger("0nacAW1wV6EcZhW6Bx53KA==");
        assertNotNull(value);
    }

    @Test
    public void testDecryptBigDecimal() {
        BigDecimal value = decryption.toBigDecimal("0nacAW1wV6EcZhW6Bx53KA==");
        assertNotNull(value);
    }

    @Test
    public void testDecryptBigInteger() {
        BigInteger value = decryption.toBigInteger("0nacAW1wV6EcZhW6Bx53KA==");
        assertNotNull(value);
    }

    @Test
    public void testDecryptLocalDate() {
        LocalDate value = decryption.toLocalDate("RM0Bx-mID0W72PggcGKdMQ==", "yyyy-MM-dd");
        assertNotNull(value);
    }

    @Test
    public void testDecryptLocalDateTime() {
        LocalDateTime value = decryption.toLocalDateTime("eSDbBdPjCUh1G_31p-9X6RSm0VQsm2SJ1HPhqonyQlo=",
                "yyyy-MM-dd HH:mm:ss");
        assertNotNull(value);
    }

}
