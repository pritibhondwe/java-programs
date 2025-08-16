import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelBooking {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Room> rooms = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static int bookingIdCounter = 1001;

   
    static class Room {
        private int roomNumber;
        private String type;
        private double pricePerNight;
        private boolean isAvailable;

        public Room(int roomNumber, String type, double pricePerNight) {
            this.roomNumber = roomNumber;
            this.type = type;
            this.pricePerNight = pricePerNight;
            this.isAvailable = true;
        }

        public int getRoomNumber() { return roomNumber; }
        public String getType() { return type; }
        public double getPricePerNight() { return pricePerNight; }
        public boolean isAvailable() { return isAvailable; }
        public void setAvailable(boolean available) { isAvailable = available; }

        @Override
        public String toString() {
            return String.format("Room %d - %s (₹%.2f/night) - %s",
                    roomNumber, type, pricePerNight,
                    isAvailable ? "Available" : "Occupied");
        }
    }

    
    static class Booking {
        private int bookingId;
        private String guestName;
        private int roomNumber;
        private LocalDate checkInDate;
        private LocalDate checkOutDate;
        private double totalCost;
        private String status;

        public Booking(String guestName, int roomNumber, LocalDate checkInDate,
                       LocalDate checkOutDate, double totalCost) {
            this.bookingId = bookingIdCounter++;
            this.guestName = guestName;
            this.roomNumber = roomNumber;
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
            this.totalCost = totalCost;
            this.status = "Confirmed";
        }

        public int getBookingId() { return bookingId; }
        public String getGuestName() { return guestName; }
        public int getRoomNumber() { return roomNumber; }
        public LocalDate getCheckInDate() { return checkInDate; }
        public LocalDate getCheckOutDate() { return checkOutDate; }
        public double getTotalCost() { return totalCost; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        @Override
        public String toString() {
            return String.format("Booking #%d - %s, Room %d, %s to %s, ₹%.2f, Status: %s",
                    bookingId, guestName, roomNumber,
                    checkInDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    checkOutDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
                    totalCost, status);
        }
    }

    public static void main(String[] args) {
        initializeRooms();

        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeBooking();
                    break;
                case 3:
                    viewAllBookings();
                    break;
                case 4:
                    cancelBooking();
                    break;
                case 5:
                    checkIn();
                    break;
                case 6:
                    checkOut();
                    break;
                case 7:
                    searchBooking();
                    break;
                case 8:
                    System.out.println("Thank you for using Hotel Booking System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        }
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Standard", 1000.0));
        rooms.add(new Room(102, "Standard", 1000.0));
        rooms.add(new Room(103, "Standard", 1000.0));
        rooms.add(new Room(201, "Deluxe", 1500.0));
        rooms.add(new Room(202, "Deluxe", 1500.0));
        rooms.add(new Room(301, "Suite", 2500.0));
        rooms.add(new Room(302, "Suite", 2500.0));
        rooms.add(new Room(401, "Presidential Suite", 5000.0));
    }

    private static void displayMenu() {
        System.out.println("\n=== HOTEL BOOKING SYSTEM ===");
        System.out.println("1. View Available Rooms");
        System.out.println("2. Make a Booking");
        System.out.println("3. View All Bookings");
        System.out.println("4. Cancel Booking");
        System.out.println("5. Check In");
        System.out.println("6. Check Out");
        System.out.println("7. Search Booking");
        System.out.println("8. Exit");
        System.out.println("============================");
    }

    private static void viewAvailableRooms() {
        System.out.println("\n=== AVAILABLE ROOMS ===");
        boolean hasAvailable = false;
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
                hasAvailable = true;
            }
        }
        if (!hasAvailable) {
            System.out.println("No rooms available at the moment.");
        }
    }

    private static void makeBooking() {
        System.out.println("\n=== MAKE A BOOKING ===");

        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }

        if (availableRooms.isEmpty()) {
            System.out.println("No rooms available for booking.");
            return;
        }

        System.out.println("Available rooms:");
        for (Room room : availableRooms) {
            System.out.println(room);
        }

        String guestName = getStringInput("Enter guest name: ");
        int roomNumber = getIntInput("Enter room number: ");

        Room selectedRoom = null;
        for (Room room : availableRooms) {
            if (room.getRoomNumber() == roomNumber) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Invalid room number or room not available!");
            return;
        }

        LocalDate checkInDate = getDateInput("Enter check-in date (yyyy-MM-dd): ");
        LocalDate checkOutDate = getDateInput("Enter check-out date (yyyy-MM-dd): ");

        if (checkInDate.isAfter(checkOutDate)) {
            System.out.println("Check-in date cannot be after check-out date!");
            return;
        }

        if (checkInDate.isBefore(LocalDate.now())) {
            System.out.println("Check-in date cannot be in the past!");
            return;
        }

        long nights = java.time.temporal.ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        double totalCost = selectedRoom.getPricePerNight() * nights;

        Booking booking = new Booking(guestName, roomNumber, checkInDate, checkOutDate, totalCost);
        bookings.add(booking);
        selectedRoom.setAvailable(false);

        System.out.println("\nBooking confirmed!");
        System.out.println("Booking ID: " + booking.getBookingId());
        System.out.println("Total cost: ₹" + String.format("%.2f", totalCost));
    }

    private static void viewAllBookings() {
        System.out.println("\n=== ALL BOOKINGS ===");
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    private static void cancelBooking() {
        System.out.println("\n=== CANCEL BOOKING ===");
        int bookingId = getIntInput("Enter booking ID to cancel: ");

        Booking bookingToCancel = null;
        for (Booking booking : bookings) {
            if (booking.getBookingId() == bookingId) {
                bookingToCancel = booking;
                break;
            }
        }

        if (bookingToCancel == null) {
            System.out.println("Booking not found!");
            return;
        }

        if (bookingToCancel.getStatus().equals("Cancelled")) {
            System.out.println("Booking is already cancelled!");
            return;
        }

        for (Room room : rooms) {
            if (room.getRoomNumber() == bookingToCancel.getRoomNumber()) {
                room.setAvailable(true);
                break;
            }
        }

        bookingToCancel.setStatus("Cancelled");
        System.out.println("Booking cancelled successfully!");
    }

    private static void checkIn() {
        System.out.println("\n=== CHECK IN ===");
        int bookingId = getIntInput("Enter booking ID: ");

        Booking booking = null;
        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId) {
                booking = b;
                break;
            }
        }

        if (booking == null) {
            System.out.println("Booking not found!");
            return;
        }

        if (!booking.getStatus().equals("Confirmed")) {
            System.out.println("Booking cannot be checked in. Status: " + booking.getStatus());
            return;
        }

        if (!booking.getCheckInDate().equals(LocalDate.now())) {
            System.out.println("Check-in date is " + booking.getCheckInDate() + ". Cannot check in today.");
            return;
        }

        booking.setStatus("Checked In");
        System.out.println("Check-in successful!");
    }

    private static void checkOut() {
        System.out.println("\n=== CHECK OUT ===");
        int bookingId = getIntInput("Enter booking ID: ");

        Booking booking = null;
        for (Booking b : bookings) {
            if (b.getBookingId() == bookingId) {
                booking = b;
                break;
            }
        }

        if (booking == null) {
            System.out.println("Booking not found!");
            return;
        }

        if (!booking.getStatus().equals("Checked In")) {
            System.out.println("Guest is not checked in!");
            return;
        }

        for (Room room : rooms) {
            if (room.getRoomNumber() == booking.getRoomNumber()) {
                room.setAvailable(true);
                break;
            }
        }

        booking.setStatus("Checked Out");
        System.out.println("Check-out successful!");
        System.out.println("Total amount paid: ₹" + String.format("%.2f", booking.getTotalCost()));
    }

    private static void searchBooking() {
        System.out.println("\n=== SEARCH BOOKING ===");
        System.out.println("1. Search by Booking ID");
        System.out.println("2. Search by Guest Name");
        int choice = getIntInput("Enter choice: ");

        if (choice == 1) {
            int bookingId = getIntInput("Enter booking ID: ");
            for (Booking booking : bookings) {
                if (booking.getBookingId() == bookingId) {
                    System.out.println(booking);
                    return;
                }
            }
            System.out.println("Booking not found!");
        } else if (choice == 2) {
            String guestName = getStringInput("Enter guest name: ");
            boolean found = false;
            for (Booking booking : bookings) {
                if (booking.getGuestName().toLowerCase().contains(guestName.toLowerCase())) {
                    System.out.println(booking);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No bookings found for this guest!");
            }
        } else {
            System.out.println("Invalid choice!");
        }
    }

    // Utility methods
    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    private static LocalDate getDateInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String dateStr = scanner.nextLine();
                return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (Exception e) {
                System.out.println("Please enter date in format yyyy-MM-dd (e.g., 2025-12-25)!");
            }
        }
    }
}
