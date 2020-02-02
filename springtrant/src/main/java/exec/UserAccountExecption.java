package exec;

public class UserAccountExecption extends RuntimeException {
    public UserAccountExecption() {
    }

    public UserAccountExecption(String message) {
        super(message);
    }

    public UserAccountExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccountExecption(Throwable cause) {
        super(cause);
    }

    public UserAccountExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
