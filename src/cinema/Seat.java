package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    int row;
    int column;
    boolean available;
    int price;

    Seat() {};

    public Seat(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.available = true;
        this.price = price;
    }

    public int getRow() {
        return this.row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @JsonIgnore
    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
