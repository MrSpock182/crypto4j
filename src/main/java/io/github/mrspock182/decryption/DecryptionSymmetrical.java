package io.github.mrspock182.decryption;

import io.github.mrspock182.Decryption;
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

public class DecryptionSymmetrical implements Decryption {

    private final String utf;
    private final String type;
    private final String cipher;
    private final String cryptKey;

    public DecryptionSymmetrical(String type, String utf, String cryptKey, String cipher) {
        this.utf = utf;
        this.type = type;
        this.cipher = cipher;
        this.cryptKey = cryptKey;
    }

    @Override
    public Long toLong(String value) throws CryptographyException {
        if (value != null) {
            String desc = baseEncrypt(value);
            return Long.valueOf(desc);
        }
        return null;
    }

    @Override
    public String toString(String value) throws CryptographyException {
        if (value != null) {
            return baseEncrypt(value);
        }
        return null;
    }

    @Override
    public Integer toInteger(String value) throws CryptographyException {
        if (value != null) {
            String desc = baseEncrypt(value);
            return Integer.valueOf(desc);
        }
        return null;
    }

    @Override
    public BigDecimal toBigDecimal(String value) throws CryptographyException {
        if (value != null) {
            String desc = baseEncrypt(value);
            return new BigDecimal(desc);
        }
        return null;
    }

    @Override
    public BigInteger toBigInteger(String value) throws CryptographyException {
        if (value != null) {
            String desc = baseEncrypt(value);
            return new BigInteger(desc);
        }
        return null;
    }

    @Override
    public LocalDate toLocalDate(String value, String dateFormatter) throws CryptographyException {
        if (value != null) {
            String desc = baseEncrypt(value);
            return LocalDate.parse(desc, DateTimeFormatter.ofPattern(dateFormatter));
        }
        return null;
    }

    @Override
    public LocalDateTime toLocalDateTime(String value, String dateFormatter) throws CryptographyException {
        if (value != null) {
            String desc = baseEncrypt(value);
            return LocalDateTime.parse(desc, DateTimeFormatter.ofPattern(dateFormatter));
        }
        return null;
    }

    private String baseEncrypt(String text) throws CryptographyException {
        try {
            if (!text.isEmpty()) {
                byte[] bytes = Base64.getUrlDecoder().decode(text);
                Cipher decripta = Cipher.getInstance(this.cipher);
                SecretKey key = new SecretKeySpec(cryptKey.getBytes(utf), this.type);
                decripta.init(Cipher.DECRYPT_MODE, key);
                return new String(decripta.doFinal(bytes), utf);
            }
            return "";
        } catch (Exception ex) {
            throw new CryptographyException(ex);
        }
    }

}
