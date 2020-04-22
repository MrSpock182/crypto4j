package io.github.mrspock182;

import io.github.mrspock182.exception.CryptographyException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Encryption {
    String encrypt(Long value) throws CryptographyException;

    String encrypt(String value) throws CryptographyException;

    String encrypt(Integer value) throws CryptographyException;

    String encrypt(BigDecimal value) throws CryptographyException;

    String encrypt(BigInteger value) throws CryptographyException;

    String encrypt(LocalDate value, String dateFormatter) throws CryptographyException;

    String encrypt(LocalDateTime value, String dateFormatter) throws CryptographyException;
}
