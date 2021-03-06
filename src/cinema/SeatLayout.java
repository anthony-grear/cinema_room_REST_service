package cinema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeatLayout {
    int total_rows;
    int total_columns;
    List<Seat> available_seats= Collections.synchronizedList(new ArrayList<>());

    public SeatLayout() {
        this.total_rows = 9;
        this.total_columns = 9;
        int price;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i <= 4) {
                    price = 10;
                } else {
                    price = 8;
                }
                available_seats.add(new Seat(i, j, price));
            }
        }
    }

    public int getTotal_rows() {
        return this.total_rows;
    }

    public int getTotal_columns() {
        return this.total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return this.available_seats;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }
}
