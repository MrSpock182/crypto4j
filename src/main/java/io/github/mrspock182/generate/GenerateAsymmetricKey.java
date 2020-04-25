package io.github.mrspock182.generate;

import io.github.mrspock182.GenerateKey;
import io.github.mrspock182.exception.CryptographyException;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class GenerateAsymmetricKey implements GenerateKey {

    private final String type;
    private final Integer keySize;
    private final String publicPath;
    private final String privatePath;

    public GenerateAsymmetricKey(String type, String path, Integer keySize) {
        this.keySize = keySize;
        this.type = type;
        this.publicPath = path + "/public.key";
        this.privatePath = path + "/private.key";
    }

    @Override
    public void generate() throws CryptographyException {
        try {
            final KeyPairGenerator keyGen = KeyPairGenerator.getInstance(type);
            keyGen.initialize(keySize);
            final KeyPair key = keyGen.generateKeyPair();

            new PrivateKey(key, privatePath).start();
            new PublicKey(key, publicPath).start();
        } catch (Exception ex) {
            throw new CryptographyException(ex);
        }
    }




}
