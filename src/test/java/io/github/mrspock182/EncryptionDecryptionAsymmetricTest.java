package io.github.mrspock182;

import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.constant.Unicode;
import io.github.mrspock182.decryption.DecryptionAsymmetric;
import io.github.mrspock182.encryption.EncryptionAsymmetric;
import io.github.mrspock182.object.ClientTest;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EncryptionDecryptionAsymmetricTest {

    Encryption encryption = new EncryptionAsymmetric(Unicode.UTF8,
                TypeEncryption.RSA, "src/test/java/resources/public.key");

    Decryption decryption = new DecryptionAsymmetric(Unicode.UTF8,
            TypeEncryption.RSA, "src/test/java/resources/private.key");

    @Test
    public void testEncryptLong() {
        String valueEncryption = encryption.encrypt(10L);
        assertNotNull(valueEncryption);

        long valueDecryption = decryption
                .toLong(valueEncryption);
        assertEquals(10L, valueDecryption);

    }

    @Test
    public void testEncryptString() {
        String valueEncryption = encryption.encrypt("TEST");
        assertNotNull(valueEncryption);

        String valueDecryption = decryption
                .toString(valueEncryption);
        assertEquals("TEST", valueDecryption);
    }

    @Test
    public void testEncryptInteger() {
        String valueEncryption = encryption.encrypt(10);
        assertNotNull(valueEncryption);

        int valueDecryption = decryption
                .toInteger(valueEncryption);
        assertEquals(10, valueDecryption);
    }

    @Test
    public void testEncryptBigDecimal() {
        String valueEncryption = encryption.encrypt(BigDecimal.valueOf(10L));
        assertNotNull(valueEncryption);

        BigDecimal valueDecryption = decryption
                .toBigDecimal(valueEncryption);
        assertEquals(BigDecimal.valueOf(10), valueDecryption);
    }

    @Test
    public void testEncryptBigInteger() {
        String valueEncryption = encryption.encrypt(BigInteger.valueOf(10L));
        assertNotNull(valueEncryption);

        BigInteger valueDecryption = decryption
                .toBigInteger(valueEncryption);
        assertEquals(BigInteger.valueOf(10), valueDecryption);
    }

    @Test
    public void testEncryptLocalDate() {
        LocalDate localDate = LocalDate.of(2020, Month.APRIL, 24);
        String valueEncryption = encryption.encrypt(localDate, "yyyy-MM-dd");
        assertNotNull(valueEncryption);

        LocalDate valueDecryption = decryption
                .toLocalDate(valueEncryption,
                        "yyyy-MM-dd");
        assertEquals(localDate, valueDecryption);
    }

    @Test
    public void testEncryptLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2020, Month.APRIL, 24, 1,
                10, 10);
        String valueEncryption = encryption.encrypt(localDateTime, "yyyy-MM-dd HH:mm:ss");
        assertNotNull(valueEncryption);

        LocalDateTime valueDecryption = decryption
                .toLocalDateTime(valueEncryption,"yyyy-MM-dd HH:mm:ss");
        assertEquals(localDateTime, valueDecryption);
    }

    @Test
    public void testEncryptOptional() {
        ClientTest clientTest = new ClientTest();
        clientTest.setName("TEST");
        clientTest.setAddress(Arrays.asList("OptionA", "OptionB"));

        String valueEncryption = encryption.encrypt(clientTest);
        assertNotNull(valueEncryption);

        ClientTest valueDecryption = decryption.toObject(valueEncryption,  ClientTest.class);
        assertEquals(valueDecryption.getName(), clientTest.getName());
        valueDecryption.getAddress().forEach(Assert::assertNotNull);
    }

}
