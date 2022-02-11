package cinema;

public class RequestToken {
    String token;
    Seat ticket;

    public RequestToken() {}

    public RequestToken(String token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Seat getTicket() {
        return this.ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }
}
