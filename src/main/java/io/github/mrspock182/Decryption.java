package io.github.mrspock182;

import br.com.studiotrek.crypto4j.exception.CryptographyException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Decryption {
    Long toLong(String value) throws CryptographyException;

    String toString(String value) throws CryptographyException;

    Integer toInteger(String value) throws CryptographyException;

    BigDecimal toBigDecimal(String value) throws CryptographyException;

    BigInteger toBigInteger(String value) throws CryptographyException;

    LocalDate toLocalDate(String value, String dateFormatter) throws CryptographyException;

    LocalDateTime toLocalDateTime(String value, String dateFormatter) throws CryptographyException;
}
