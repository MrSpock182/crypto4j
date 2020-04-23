package io.github.mrspock182;

import io.github.mrspock182.constant.TypeEncryption;
import io.github.mrspock182.generate.GenerateAsymmetricKey;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateAsymmetricKeyTest {

    GenerateKey generateKey = new GenerateAsymmetricKey(TypeEncryption.RSA, "src/test/java/resources", 2048);

    @Test
    public void testGenerate() {
        try {
            generateKey.generate();
            assertTrue(true);
        } catch (Exception ex) {
            fail();
        }
    }

}
