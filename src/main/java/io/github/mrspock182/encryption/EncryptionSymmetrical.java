package io.github.mrspock182.encryption;

import io.github.mrspock182.Encryption;
import io.github.mrspock182.exception.CryptographyException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import static javax.crypto.Cipher.ENCRYPT_MODE;

public class EncryptionSymmetrical implements Encryption {

    private final String utf;
    private final String type;
    private final String cipher;
    private final String cryptKey;

    public EncryptionSymmetrical(String type, String utf, String cryptKey, String cipher) {
        this.utf = utf;
        this.type = type;
        this.cipher = cipher;
        this.cryptKey = cryptKey;
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
        try {
            if (!value.isEmpty()) {
                Cipher encrypt = Cipher.getInstance(this.cipher);
                SecretKey key = new SecretKeySpec(cryptKey.getBytes(utf), this.type);
                encrypt.init(ENCRYPT_MODE, key);
                byte[] crypt = encrypt.doFinal(value.getBytes(utf));
                return Base64.getUrlEncoder().encodeToString(crypt);
            }
            return "";
        } catch (Exception ex) {
            throw new CryptographyException(ex);
        }
    }
}
