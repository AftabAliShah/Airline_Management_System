public class Booking {
    private String bookingId;

    private Passenger passenger;
    private Flight flight;
    public Booking() {
    }

    public Booking(String bookingId, Passenger passenger, Flight flight) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flight = flight;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", passenger=" + passenger +
                ", flight=" + flight +
                '}';
    }
}
