package io.github.mrspock182.decryption;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.mrspock182.Decryption;
import io.github.mrspock182.exception.CryptographyException;

import javax.crypto.Cipher;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class DecryptionAsymmetric implements Decryption {

    private final String utf;
    private final String type;
    private final String pathKey;
    private final ObjectMapper mapper = new ObjectMapper();

    public DecryptionAsymmetric(String utf, String type, String pathKey) {
        this.utf = utf;
        this.type = type;
        this.pathKey = pathKey;
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

    @Override
    public <T> T toObject(String value, Class<T> var2) throws CryptographyException {
        try {
            if(value != null) {
                return mapper.readValue(toString(value), var2);
            }
        } catch (JsonProcessingException ex) {
            throw new CryptographyException(ex);
        }

        return null;
    }

    private String baseEncrypt(String text) throws CryptographyException {
        try (ObjectInputStream publicStream = new ObjectInputStream(new FileInputStream(pathKey))) {
            if (!text.isEmpty()) {
                byte[] value = Base64.getUrlDecoder().decode(text);

                final PrivateKey key = (PrivateKey) publicStream.readObject();

                final Cipher cipher = Cipher.getInstance(type);
                cipher.init(Cipher.DECRYPT_MODE, key);
                return new String(cipher.doFinal(value), utf);
            }

            return "";
        } catch (Exception ex) {
            throw new CryptographyException(ex);
        }
    }

}
