package personalFinance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String exceptionMsg) {
        super(exceptionMsg);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, exceptionMsg);
    }
}
