package io.github.mrspock182;

import io.github.mrspock182.constant.Cipher;
import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.constant.Unicode;
import io.github.mrspock182.decryption.DecryptionSymmetrical;
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

public class DecryptionSymmetricalTest {

    Decryption decryption = new DecryptionSymmetrical(TypeEncryption.AES, Unicode.UTF8,
            "O!Wed567BxC@xz1B", Cipher.PKCS5PADDING);

    @Test
    public void testDecryptLong() {
        long value = decryption.toLong("0nacAW1wV6EcZhW6Bx53KA==");
        assertEquals(10L, value);
    }

    @Test
    public void testDecryptString() {
        String value = decryption.toString("JBoUx-Gr2FbtQLdci1fkKA==");
        assertEquals("TEST", value);
    }

    @Test
    public void testDecryptInteger() {
        int value = decryption.toInteger("0nacAW1wV6EcZhW6Bx53KA==");
        assertEquals(10, value);
    }

    @Test
    public void testDecryptBigDecimal() {
        BigDecimal value = decryption.toBigDecimal("0nacAW1wV6EcZhW6Bx53KA==");
        assertEquals(BigDecimal.valueOf(10), value);
    }

    @Test
    public void testDecryptBigInteger() {
        BigInteger value = decryption.toBigInteger("0nacAW1wV6EcZhW6Bx53KA==");
        assertEquals(BigInteger.valueOf(10), value);
    }

    @Test
    public void testDecryptLocalDate() {
        LocalDate localDate = LocalDate.of(2020, Month.APRIL, 24);

        LocalDate value = decryption.toLocalDate("Q4KwtZmEZVddI4qx5UnNqg==", "yyyy-MM-dd");
        assertEquals(localDate, value);
    }

    @Test
    public void testDecryptLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.of(2020, Month.APRIL, 24, 1,
                10, 10);
        LocalDateTime value = decryption.toLocalDateTime("Y8ckQ2GbscLmOZvfTU_W8J14eZp5sAdxwb7U1C49JI0=",
                "yyyy-MM-dd HH:mm:ss");
        assertEquals(localDateTime, value);
    }

    @Test
    public void testDecryptOptional() {
        ClientTest clientTest = new ClientTest();
        clientTest.setName("TEST");
        clientTest.setAddress(Arrays.asList("OptionA", "OptionB"));

        ClientTest value = decryption.toObject("HXxFMKlbYuA3u24L7Lj8qmpJ3ZZ6x1WYk9hbsOgSRBefXS1-LWTkC6EJ9lIKt8de",
                ClientTest.class);
        assertEquals(value.getName(), clientTest.getName());
        value.getAddress().forEach(Assert::assertNotNull);
    }
}
