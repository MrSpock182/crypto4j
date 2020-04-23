package io.github.mrspock182.encryption;

import io.github.mrspock182.Encryption;
import io.github.mrspock182.exception.CryptographyException;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.PublicKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class EncryptionAsymmetric implements Encryption {

    private final String utf;
    private final String type;
    private final String pathKey;

    public EncryptionAsymmetric(String utf, String type, String pathKey) {
        this.utf = utf;
        this.type = type;
        this.pathKey = pathKey;
    }

    @Override
    public String encrypt(Long value) throws CryptographyException {
        if (value != null) {
            return baseEncrypt(value.toString());
        }
        return null;
    }

    @Override
    public String encrypt(String value) throws CryptographyException {
        if (value != null) {
            return baseEncrypt(value);
        }
        return null;
    }

    @Override
    public String encrypt(Integer value) throws CryptographyException {
        if (value != null) {
            return baseEncrypt(value.toString());
        }
        return null;
    }

    @Override
    public String encrypt(BigDecimal value) throws CryptographyException {
        if (value != null) {
            return baseEncrypt(value.toString());
        }
        return null;
    }

    @Override
    public String encrypt(BigInteger value) throws CryptographyException {
        if (value != null) {
            return baseEncrypt(value.toString());
        }
        return null;
    }

    @Override
    public String encrypt(LocalDate value, String dateFormatter) throws CryptographyException {
        if (value != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatter);
            String data = value.format(formatter);
            return baseEncrypt(data);
        }
        return null;
    }

    @Override
    public String encrypt(LocalDateTime value, String dateFormatter) throws CryptographyException {
        if (value != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatter);
            String data = value.format(formatter);
            return baseEncrypt(data);
        }
        return null;
    }

    private String baseEncrypt(String value) throws CryptographyException {
        byte[] cipherText;
        try (ObjectInputStream privateStream =
                     new ObjectInputStream(new FileInputStream(pathKey))) {
            final PublicKey key = (PublicKey) privateStream.readObject();
            final Cipher cipher = Cipher.getInstance(type);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            cipherText = cipher.doFinal(value.getBytes(utf));
            return Base64.getUrlEncoder().encodeToString(cipherText);
        } catch (Exception ex) {
            throw new CryptographyException(ex);
        }
    }
}
