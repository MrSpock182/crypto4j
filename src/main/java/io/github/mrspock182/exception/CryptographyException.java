package io.github.mrspock182.exception;

public class CryptographyException extends RuntimeException {
    public CryptographyException() {
        super();
    }

    public CryptographyException(String message) {
        super(message);
    }

    public CryptographyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CryptographyException(Throwable cause) {
        super(cause);
    }

    protected CryptographyException(String message, Throwable cause,
                                    Boolean enableSuppression,
                                    Boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
