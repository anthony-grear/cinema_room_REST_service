package cinema;

import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class SeatController {
    SeatLayout seatLayout = new SeatLayout();
    Map<String, Seat> tokenMap = new ConcurrentHashMap<>();

    @GetMapping("/seats")
    public SeatLayout getSeatLayout() {
        return seatLayout;
    }

    @PostMapping("/purchase")
    public ResponseEntity<RequestToken> purchaseSeat(@RequestBody SeatInfo seatInfo) {
        int count = 0;
        int row = seatInfo.getRow();
        int column = seatInfo.getColumn();

        if (row > 9 || row < 1 || column > 9 || column < 1) {
            throw new SeatOutOfBoundsException();
        }

        for (Seat seat : seatLayout.available_seats) {
            count++;
            if (seat.getRow()==row && seat.getColumn()==column) {
                if (!seat.getAvailable()) {
                    throw new SeatAlreadyReservedException();
                } else {
                    break;
                }
            }
        }
        seatLayout.available_seats.get(count-1).setAvailable(false);
        Seat seat = seatLayout.available_seats.get(count-1);
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        tokenMap.put(uuidString, seat);
        RequestToken requestToken = new RequestToken(uuidString, seat);
        Statistics.increaseCurrent_income(seat.getPrice());
        Statistics.decrementNumber_of_available_seats();
        Statistics.incrementNumber_of_purchased_tickets();
        return new ResponseEntity<RequestToken>(requestToken , HttpStatus.OK);

    }

    @PostMapping("/return")
    public ResponseEntity<Map<String,Object>> returnSeat(@RequestBody ReturnToken returnToken) {
        int count = 0;

        if (!tokenMap.containsKey(returnToken.getToken())) {
            throw new WrongTokenException();
        }
        for (Seat seat : seatLayout.available_seats) {
            count++;
            if (seat.getRow() == tokenMap.get(returnToken.getToken()).getRow() &&
            seat.getColumn() == tokenMap.get(returnToken.getToken()).getColumn()) {
                break;
            }
        }
        Seat seat = seatLayout.available_seats.get(count-1);
        tokenMap.remove(returnToken.getToken());
        Statistics.decreaseCurrent_income(seat.getPrice());
        Statistics.incrementNumber_of_available_seats();
        Statistics.decrementNumber_of_purchased_tickets();
        return new ResponseEntity<Map<String, Object>>(Map.of("returned_ticket", seat), HttpStatus.OK);
    }

    @PostMapping("/stats")
    public Statistics getStatistics(@RequestParam("password") String password) {
        if (!password.equals("super_secret")) {
            throw new MissingPasswordException();
        }
        return new Statistics();
    }
}
