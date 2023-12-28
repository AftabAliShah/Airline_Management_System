import java.util.*;

public class Main {
    List<Flight> flights = Flight.flightList;
    List<Passenger> passengers = Passenger.passengerList;

    List<Booking> bookings = new ArrayList<>();

    Map<String, Integer> flightSeatBooking = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Main main = new Main();
        String choice = "";
        do {
            System.out.println("====== Welcome to Sindhu Desh Airport ======");
            System.out.println("1.Add New Flight");
            System.out.println("2.Add Passenger ");
            System.out.println("3.Book a Ticket");
            System.out.println("4.Search For A Flight by Flight Number");
            System.out.println("5.Display Passengers");
            System.out.println("6.Display Flights");
            System.out.println("7.Search a Passenger by Name or Contact");
            System.out.println("8.Display Bookings ");
            System.out.println("9.Cancel a ticket");
            System.out.println("10.Search Passenger By Contact Number");
            String option = input.next();
            switch (option) {
                case "1":
                    System.out.println("Enter the Flight Details ");
                    System.out.print("Flight Number : ");
                    String flightNumber = input.next();
                    System.out.print("Destination : ");
                    String destination = input.next();
                    System.out.print("Departure : ");
                    String departure = input.next();
                    System.out.print("Departure Time : ");
                    String departureTime = input.next();
                    System.out.print("Seat Capacity : ");
                    Integer seatCapacity = input.nextInt();
                    System.out.print("Seat Per Person Amount : ");
                    Double pricePerSeat = input.nextDouble();
                    Flight flight = new Flight(flightNumber, departure, destination, departureTime, seatCapacity, pricePerSeat);
                    main.addFlight(flight);
                    System.out.println("Your Flight is added");
                    break;
                case "2":
                    System.out.println("Enter Passenger Details");
                    System.out.print("Enter Name : ");
                    String name = input.next();
                    System.out.print("Enter Age : ");
                    Integer age = input.nextInt();
                    System.out.print("Enter Gender :");
                    String gender = input.next();
                    System.out.print("Enter email :");
                    String email = input.next();
                    System.out.print("Enter contact :");
                    String contactNumber = input.next();
                    Passenger passenger = new Passenger(name, age, gender, email, contactNumber);
                    main.addPassenger(passenger);
                    System.out.println("Passenger added.");
                    break;
                case "3":
                    System.out.println("Enter the Booking Details ");
                    do {
                        System.out.println("Enter the Flight Details ");
                        System.out.print("Flight Number : ");
                        flightNumber = input.next();
                        System.out.print("Destination : ");
                        destination = input.next();


                        flight = main.searchFlightByDestinationOrNumber(flightNumber, destination);

                        if (flight == null) {
                            System.out.println("No Flight Found with flight number " + flightNumber + ", Destination " + destination);
                        } else {
                            System.out.println("Flight Found with flight number " + flightNumber + ", Destination " + destination);
                        }
                    } while (flight == null);

                    if (flight != null) {
                        System.out.println("Enter Passenger Details:");
                        System.out.print("Enter name");
                        name = input.next();
                        System.out.print("Enter contact : ");
                        contactNumber = input.next();
                        Passenger p = main.searchPassengerByNameOrContact(name, contactNumber);


                        if (p == null) {
                            System.out.println("No Passenger Found");
                            System.out.println("Please add Passenger");
                            System.out.println("Enter Passenger Details");
                            System.out.print("Enter Name : ");
                            name = input.next();
                            System.out.print("Enter Age : ");
                            age = input.nextInt();
                            System.out.print("Enter Gender :");
                            gender = input.next();
                            System.out.print("Enter email :");
                            email = input.next();
                            System.out.print("Enter contact :");
                            contactNumber = input.next();
                            p = new Passenger(name, age, gender, email, contactNumber);
                            main.addPassenger(p);
                            System.out.println("Passenger added.");
                        }

                        System.out.print("How many seats want to book : ");
                        Integer seats = input.nextInt();

                        if (!main.flightSeatBooking.containsKey(flightNumber + "-total")) {
                            main.flightSeatBooking.put(flightNumber + "-total", flight.getSeatCapacity()); //PIA101-total,200
                        }
                        int remaining = main.flightSeatBooking.get(flightNumber + "-total") - seats;
                        if (remaining > 0) {
                            System.out.println("");
                            main.flightSeatBooking.put(flightNumber + "-total", remaining); //PIA101-total,200
                            Booking booking = main.bookTicket(p, flight);
                            if (booking != null) {
                                main.bookings.add(booking);
                            }
                            System.out.println("Your " + seats + " Seats Booked in Flight" + flight);
                        } else {
                            System.out.println("Not these much seats Available " + main.flightSeatBooking.get(flightNumber + "-total"));
                        }

                    }

                    break;
                case "4":
                    System.out.println("Please Enter the flight number");
                    flightNumber = input.next();
                    Flight f = main.searchFlightByFlightNumber(flightNumber);
                    if (f == null) {
                        System.out.println("No Flight Found with Flight Number " + flightNumber);
                    } else {
                        System.out.println(f);
                    }
                    break;
                case "5":
                    System.out.println("Available Passengers : ");
                    main.displayPassengers();
                    break;
                case "6":
                    System.out.println("Available Flights :");
                    main.displayFlights();
                    break;
                case "7":
                    System.out.println("Enter Passenger Details:");
                    System.out.print("Enter name");
                    name = input.next();
                    System.out.print("Enter contact : ");
                    contactNumber = input.next();
                    Passenger p = main.searchPassengerByNameOrContact(name, contactNumber);
                    if (p == null) {
                        System.out.println("No Passenger Found with name " + name + ", contact " + contactNumber);
                    } else {
                        System.out.println(p);
                    }
                    break;
                case "8":
                    System.out.println("Available Bookings ");
                    main.displayBookings();
                    break;
                case "9":
                    System.out.print("Enter name : ");
                    name = input.next();
                    main.cancelBooking(name);
                    break;
                case "10":
                    System.out.println("Enter Passengers Contactnumber");
                    contactNumber = input.next();
                    Passenger p1 = main.passengerByContact(contactNumber);
                    System.out.println("Contact Number Found " + p1);
                    break;
                default:
                    System.out.println("Invalid input");
            }

            System.out.print("Continue y/n : ");
            choice = input.next();
        } while (choice.equalsIgnoreCase("y"));
    }

    public Flight searchFlightByDestinationOrNumber(String flightNumber, String destination) {
        Flight flight = null;
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightNumber().equalsIgnoreCase(flightNumber) || flights.get(i).getDestination().equalsIgnoreCase(destination)) {
                flight = flights.get(i);
            }

        }
        return flight;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Flight searchFlightByFlightNumber(String flightNumber) {
        Flight flight = null;
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightNumber().equalsIgnoreCase(flightNumber)) {
                flight = flights.get(i);
            }
        }
        return flight;
    }

    public void displayFlights() {
        for (int i = 0; i < flights.size(); i++) {
            System.out.println(flights.get(i));
        }
    }

    public Booking bookTicket(Passenger passenger, Flight flight) {
        Booking booking = new Booking();
        booking.setBookingId(UUID.randomUUID().toString());
        booking.setPassenger(passenger);
        booking.setFlight(flight);
        return booking;
    }

    public Passenger searchPassengerByNameOrContact(String name, String contact) {
        Passenger passenger = null;
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getName().equalsIgnoreCase(name) || passengers.get(i).getContactNumber().equalsIgnoreCase(contact))
                passenger = passengers.get(i);
        }
        return passenger;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void displayPassengers() {
        for (int i = 0; i < passengers.size(); i++) {
            System.out.println(passengers.get(i));
        }
    }

    public void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No Booking Found");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    public void cancelBooking(String passengerName) {
        Booking booking = searchBookingByPassengerName(passengerName);

        if (booking != null) {
            bookings.remove(booking);
            System.out.println("Your Ticket is Cancelled " + booking.getBookingId());
        } else {
            System.out.println("No Booking Found with Name " + passengerName);
        }
    }

    public Booking searchBookingByPassengerName(String passengerName) {
        Booking booking = null;
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getPassenger().getName().equalsIgnoreCase(passengerName)) {
                booking = bookings.get(i);
            }
        }
        return booking;
    }

    public Passenger passengerByContact(String contactNum) {
        Passenger passenger = null;
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getContactNumber().equals(contactNum)) {
                passenger = passengers.get(i);

            }

        }
        return passenger;
    }

}

