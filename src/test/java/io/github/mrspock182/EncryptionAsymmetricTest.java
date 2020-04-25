package io.github.mrspock182;

import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.constant.Unicode;
import io.github.mrspock182.encryption.EncryptionAsymmetric;
import io.github.mrspock182.object.ClientTest;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

public class EncryptionAsymmetricTest {

    Encryption encryption = new EncryptionAsymmetric(Unicode.UTF8,
                TypeEncryption.RSA, "src/test/java/resources/public.key");

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
        LocalDate localDate = LocalDate.of(2020, Month.APRIL, 24);
        String value = encryption.encrypt(localDate, "yyyy-MM-dd");
        assertNotNull(value);
    }

    @Test
    public void testEncryptLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2020, Month.APRIL, 24, 1,
                10, 10, 30);
        String value = encryption.encrypt(localDateTime, "yyyy-MM-dd HH:mm:ss");
        assertNotNull(value);
    }

    @Test
    public void testEncryptOptional() {
        ClientTest clientTest = new ClientTest();
        clientTest.setName("TEST");
        clientTest.setAddress(Arrays.asList("OptionA", "OptionB"));

        String value = encryption.encrypt(clientTest);
        assertNotNull(value);
    }

}
