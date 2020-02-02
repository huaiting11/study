package exec;

public class BookExecption extends  RuntimeException {
    public BookExecption() {
    }

    public BookExecption(String message) {
        super(message);
    }

    public BookExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public BookExecption(Throwable cause) {
        super(cause);
    }

    public BookExecption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
