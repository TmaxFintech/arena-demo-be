package kr.co.tmax.arenademobe.exception;

public class EmailSigninFailedException extends RuntimeException {
    public EmailSigninFailedException(String msg, Throwable t) {
        super(msg, t);
    }

    public EmailSigninFailedException(String msg) {
        super(msg);
    }

    public EmailSigninFailedException() {
        super();
    }
}
