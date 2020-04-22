package io.github.mrspock182.generate;

import io.github.mrspock182.GenerateKey;
import io.github.mrspock182.exception.CryptographyException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class GenerateAsymmetricKey implements GenerateKey {

    private final String type;
    private final Integer keySize;
    private final String publicPath;
    private final String privatePath;

    public GenerateAsymmetricKey(String type, String path, Integer keySize) {
        this.type = type;
        this.keySize = keySize;
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
        checkingFile(key, publicFileKey);
    }

    private void privateKey(final KeyPair key) throws Exception {
        File privateFileKey = new File(privatePath);
        checkingFile(key, privateFileKey);
    }

    private void checkingFile(final KeyPair key, final File fileKey) throws Exception {
        if (!fileKey.exists()) {
            if (fileKey.getParentFile() != null) {
                fileKey.getParentFile().mkdirs();
            }

            if (fileKey.createNewFile()) {
                try (ObjectOutputStream privateOutputStream = new ObjectOutputStream(new FileOutputStream(fileKey))) {
                    privateOutputStream.writeObject(key.getPrivate());
                }
            }
        }
    }
}
