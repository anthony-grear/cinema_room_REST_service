package cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SeatController {
    SeatLayout seatLayout = new SeatLayout();

    @GetMapping("/seats")
    public SeatLayout getSeatLayout() {
        return seatLayout;
    }

    @PostMapping("/purchase")
    public Seat purchaseSeat(@RequestBody SeatInfo seatInfo) {
        int count = 0;
        int row = seatInfo.getRow();
        int column = seatInfo.getColumn();

        if (row > 9 || row < 1 || column > 9 || column < 1) {
            throw new SeatOutOfBoundsException();
        }

        for (Seat seat : seatLayout.available_seats) {
            count++;
            if (seat.getRow()==row && seat.getColumn()==column) {
                if (seat.getAvailable() == false) {
                    throw new SeatAlreadyReservedException();
                } else {
                    break;
                }
            }
        }
        seatLayout.available_seats.get(count-1).setAvailable(false);
        return seatLayout.available_seats.get(count - 1);

    }
}
