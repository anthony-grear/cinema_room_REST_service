package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class SeatOutOfBoundsException extends RuntimeException {
    private static final long serialVersionUID = 1L;
}
