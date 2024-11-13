package n2;

import java.util.ArrayList;
import java.util.List;

public class Airline {

    private String destination;
    private int flightNumber;
    private String aircraftType;
    private String departureTime;
    private List<String> daysOfWeek;

    public Airline(String destination, int flightNumber, String aircraftType, String departureTime, String... daysOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.departureTime = departureTime;
        this.daysOfWeek = new ArrayList<>();
        for (String day : daysOfWeek) {
            this.daysOfWeek.add(day);
        }
    }

    public String getDestination() {
        return destination;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public List<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "destination='" + destination  +
                ", flightNumber=" + flightNumber +
                ", aircraftType='" + aircraftType  +
                ", departureTime='" + departureTime  +
                ", daysOfWeek=" + daysOfWeek +
                '}';
    }
}

class FlightManager {

    private List<Airline> flights;

    public FlightManager() {
        flights = new ArrayList<>();
    }

    public void addFlight(Airline flight) {
        flights.add(flight);
    }

    public List<Airline> getFlightsByDestination(String destination) {
        List<Airline> result = new ArrayList<>();
        for (Airline flight : flights) {
            if (flight.getDestination().equals(destination)) {
                result.add(flight);
            }
        }
        return result;
    }

    public List<Airline> getFlightsByDayOfWeek(String dayOfWeek) {
        List<Airline> result = new ArrayList<>();
        for (Airline flight : flights) {
            if (flight.getDaysOfWeek().contains(dayOfWeek)) {
                result.add(flight);
            }
        }
        return result;
    }

    public List<Airline> getFlightsByDayOfWeekAndTime(String dayOfWeek, String time) {
        List<Airline> result = new ArrayList<>();
        for (Airline flight : flights) {
            if (flight.getDaysOfWeek().contains(dayOfWeek) && flight.getDepartureTime().compareTo(time) > 0) {
                result.add(flight);
            }
        }
        return result;
    }

    public void printFlights(List<Airline> flights) {
        if (flights.isEmpty()) {
            System.out.println("Рейсы не найдены.");
        } else {
            for (Airline flight : flights) {
                System.out.println(flight);
            }
        }
    }

    public static void main(String[] args) {
        FlightManager manager = new FlightManager();

        manager.addFlight(new Airline("Москва", 123, "Boeing 737", "10:00", "Понедельник", "Вторник"));
        manager.addFlight(new Airline("Санкт-Петербург", 456, "Airbus A320", "12:30", "Среда", "Четверг", "Пятница"));
        manager.addFlight(new Airline("Москва", 789, "Boeing 747", "14:00", "Суббота", "Воскресенье"));

        System.out.println("Рейсы в Москву:");
        manager.printFlights(manager.getFlightsByDestination("Москва"));

        System.out.println("\nРейсы в понедельник:");
        manager.printFlights(manager.getFlightsByDayOfWeek("Понедельник"));

        System.out.println("\nРейсы в понедельник, после 11:00:");
        manager.printFlights(manager.getFlightsByDayOfWeekAndTime("Понедельник", "11:00"));
    }
}
