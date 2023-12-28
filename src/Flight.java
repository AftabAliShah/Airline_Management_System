import java.util.ArrayList;
import java.util.List;

public class Flight {
    public static List<Flight> flightList = new ArrayList<>(List.of(
            new Flight("JA101", "New York", "Los Angeles", "2023-08-10 08:00", 5, 300d)
            , new Flight("JA202", "London", "Paris", "2023-08-12 11:30", 100, 250d),
            new Flight("JA303", "Tokyo", "Singapore", "2023-08-15 14:45", 200, 400d)));



    private String flightNumber;
    private String departure;
    private String destination;
    private String departureTime;
    private Integer seatCapacity;
    private Double pricePerSeat;

    public Flight(String flightNumber, String departure, String destination, String departureTime, Integer seatCapacity, Double pricePerSeat) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.departureTime = departureTime;
        this.seatCapacity = seatCapacity;
        this.pricePerSeat = pricePerSeat;
    }

    public Flight() {


    }


    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public Double getPricePerSeat() {
        return pricePerSeat;
    }

    public void setPricePerSeat(Double pricePerSeat) {
        this.pricePerSeat = pricePerSeat;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightNumber='" + flightNumber + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", seatCapacity=" + seatCapacity +
                ", pricePerSeat=" + pricePerSeat +
                '}';
    }
}
