package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class CinemaExceptionController {

    @ExceptionHandler(value = SeatOutOfBoundsException.class)
    public ResponseEntity<Object> exception(SeatOutOfBoundsException exception) {
        return new ResponseEntity<>(Map.of("error", "The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = SeatAlreadyReservedException.class)
    public ResponseEntity<Object> exception(SeatAlreadyReservedException exception) {
        return new ResponseEntity<>(Map.of("error", "The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = WrongTokenException.class)
    public ResponseEntity<Object> exception(WrongTokenException exception) {
        return new ResponseEntity<>(Map.of("error", "Wrong token!"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MissingPasswordException.class)
    public ResponseEntity<Object> exception(MissingPasswordException exception) {
        return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
    }
}
