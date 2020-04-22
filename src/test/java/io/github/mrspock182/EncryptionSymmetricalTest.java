package io.github.mrspock182;

import io.github.mrspock182.constant.Cipher;
import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.constant.Unicode;
import io.github.mrspock182.encryption.EncryptionSymmetrical;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.assertNotNull;

public class EncryptionSymmetricalTest {

    private Encryption encryption = new EncryptionSymmetrical(TypeEncryption.AES, Unicode.UTF8,
            "O!Wed567BxC@xz1B", Cipher.PKCS5PADDING);

    @Test
    public void testEncryptLong() {
        String value = encryption.encrypt(10L);
        assertNotNull(value);
    }

    @Test
    public void testEncryptString() {
       String value = encryption.encrypt("TEST");
       assertNotNull(value);
    }

    @Test
    public void testEncryptInteger() {
        String value = encryption.encrypt(10);
        assertNotNull(value);
    }

    @Test
    public void testEncryptBigDecimal() {
        String value = encryption.encrypt(BigDecimal.valueOf(10L));
        assertNotNull(value);
    }

    @Test
    public void testEncryptBigInteger() {
        String value = encryption.encrypt(BigInteger.valueOf(10L));
        assertNotNull(value);
    }

    @Test
    public void testEncryptLocalDate() {
        LocalDate localDate = LocalDate.now();
        String value = encryption.encrypt(localDate, "yyyy-MM-dd");
        assertNotNull(value);
    }

    @Test
    public void testEncryptLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String value = encryption.encrypt(localDateTime, "yyyy-MM-dd HH:mm:ss");
        assertNotNull(value);
    }

}
