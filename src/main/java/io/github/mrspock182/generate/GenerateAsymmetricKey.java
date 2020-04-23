package io.github.mrspock182.generate;

import io.github.mrspock182.GenerateKey;
import io.github.mrspock182.exception.CryptographyException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class GenerateAsymmetricKey implements GenerateKey {

    private Integer keySize;
    private String type;
    private String publicPath;
    private String privatePath;

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

            publicKey(key);
            privateKey(key);
        } catch (Exception ex) {
            throw new CryptographyException(ex);
        }
    }

    private void publicKey(final KeyPair key) throws Exception {
        File publicFileKey = new File(publicPath);

        if (!publicFileKey.exists()) {
            if (publicFileKey.getParentFile() != null) {
                publicFileKey.getParentFile().mkdirs();
            }

            if (publicFileKey.createNewFile()) {
                try (ObjectOutputStream publicOutputStream = new ObjectOutputStream(new FileOutputStream(publicFileKey))) {
                    publicOutputStream.writeObject(key.getPublic());
                }
            }
        }
    }

    private void privateKey(final KeyPair key) throws Exception {
        File privateFileKey = new File(privatePath);

        if (!privateFileKey.exists()) {
            if (privateFileKey.getParentFile() != null) {
                privateFileKey.getParentFile().mkdirs();
            }

            if (privateFileKey.createNewFile()) {
                try (ObjectOutputStream privateOutputStream = new ObjectOutputStream(new FileOutputStream(privateFileKey))) {
                    privateOutputStream.writeObject(key.getPrivate());
                }
            }
        }
    }
}
