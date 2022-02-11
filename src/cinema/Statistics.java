package cinema;

public class Statistics {
    static int current_income;
    static int number_of_available_seats = 81;
    static int number_of_purchased_tickets = 0;

    public Statistics(){}

    public int getCurrent_income() {
        return this.current_income;
    }

    public void setCurrent_income(int current_income) {
        this.current_income = current_income;
    }

    public int getNumber_of_available_seats() {
        return this.number_of_available_seats;
    }

    public void setNumber_of_available_seats(int number_of_available_seats) {
        this.number_of_available_seats = number_of_available_seats;
    }

    public int getNumber_of_purchased_tickets() {
        return this.number_of_purchased_tickets;
    }



    public void setNumber_of_purchased_tickets(int number_of_purchased_tickets) {
        this.number_of_purchased_tickets = number_of_purchased_tickets;
    }











    static void increaseCurrent_income (int amount) {
        current_income += amount;
    }

    static void decreaseCurrent_income (int amount) {
        current_income -= amount;
    }

    static void decrementNumber_of_available_seats() {
        number_of_available_seats -= 1;
    }

    static void incrementNumber_of_available_seats() {
        number_of_available_seats += 1;
    }

    static void incrementNumber_of_purchased_tickets() {
        number_of_purchased_tickets += 1;
    }

    static void decrementNumber_of_purchased_tickets() {
        number_of_purchased_tickets -= 1;
    }

}
