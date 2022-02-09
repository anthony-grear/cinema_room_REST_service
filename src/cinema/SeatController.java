package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SeatController {
    SeatLayout seatLayout = new SeatLayout();

    @GetMapping("/seats")
    public SeatLayout getSeatLayout() {
        return seatLayout;
    }

    @PostMapping("/request")
    public Seat purchaseSeat()
}
