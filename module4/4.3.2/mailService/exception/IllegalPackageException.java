package simple.mailService.exception;

public class IllegalPackageException extends RuntimeException {
    public IllegalPackageException() {
        super();
    }

    public IllegalPackageException(String message) {
        super(message);
    }
}
