class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String toString() {
        return "Ticket Number: " + ticketNumber + ", Customer: " + customerName + ", Seat: " + seatNumber;
    }
}

class BookingSystem {
    private Ticket[] tickets = new Ticket[10];
    private int ticketCount = 0;

    public void bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number.");
            return;
        }

        if (ticketCount >= 10) {
            System.out.println("All seats are booked.");
            return;
        }

        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getSeatNumber() == seatNumber) {
                System.out.println("Seat number " + seatNumber + " is already booked.");
                return;
            }
        }

        tickets[ticketCount++] = new Ticket(ticketNumber, customerName, seatNumber);
        System.out.println("Ticket booked successfully for " + customerName + " at seat " + seatNumber);
    }

    public void cancelTicket(int ticketNumber) {
        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                System.out.println("Cancelling ticket for seat " + tickets[i].getSeatNumber());

                for (int j = i; j < ticketCount - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }
                tickets[--ticketCount] = null;
                return;
            }
        }
        System.out.println("Ticket number " + ticketNumber + " not found.");
    }

    public void displayBookings() {
        if (ticketCount == 0) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("Current Bookings:");
        for (int i = 0; i < ticketCount; i++) {
            System.out.println(tickets[i]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        system.bookTicket(1, "Alice", 1);
        system.bookTicket(2, "Bob", 2);
        system.bookTicket(3, "Charlie", 3);

        system.cancelTicket(2);

        system.bookTicket(4, "David", 2);

        system.displayBookings();
    }
}
