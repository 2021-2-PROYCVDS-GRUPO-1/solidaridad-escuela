package edu.eci.cvds.services;

public class ServicesException extends Exception {
    public ServicesException() {
        super();
    }

    public ServicesException(String msg){
        super(msg);
    }

    public ServicesException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicesException(Throwable cause) {
        super(cause);
    }

    protected ServicesException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
