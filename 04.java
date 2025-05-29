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

    public String getCustomerName() {
        return customerName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}

class BookingSystem {
    private Ticket[] tickets;
    private boolean[] seats;
    private int ticketCount;
    private static final int MAX_SEATS = 10;

    public BookingSystem() {
        tickets = new Ticket[MAX_SEATS];
        seats = new boolean[MAX_SEATS];
        ticketCount = 0;
    }

    public boolean bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (seatNumber < 1 || seatNumber > MAX_SEATS) {
            System.out.println("Invalid seat number.");
            return false;
        }

        if (seats[seatNumber - 1]) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return false;
        }

        if (ticketCount >= MAX_SEATS) {
            System.out.println("All seats are booked.");
            return false;
        }

        tickets[ticketCount] = new Ticket(ticketNumber, customerName, seatNumber);
        seats[seatNumber - 1] = true;
        ticketCount++;
        return true;
    }

    public boolean cancelTicket(int ticketNumber) {
        for (int i = 0; i < ticketCount; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                int seat = tickets[i].getSeatNumber();
                seats[seat - 1] = false;
                
                // Shift remaining tickets
                for (int j = i; j < ticketCount - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }
                ticketCount--;
                tickets[ticketCount] = null;
                return true;
            }
        }
        System.out.println("Ticket with number " + ticketNumber + " not found.");
        return false;
    }

    public void displayAllBookings() {
        
        for (int i = 0; i < ticketCount; i++) {
            System.out.println("Ticket"+tickets[i].getTicketNumber());
             System.out.println("Customer: " + tickets[i].getCustomerName()); 
              System.out.println( "Seat"+tickets[i].getSeatNumber());
        }
    }
}

 class Main {
    public static void main(String[] args) {
        BookingSystem cinema = new BookingSystem();
        
        // Book tickets
        cinema.bookTicket(1, "Customer 1", 1);
        cinema.bookTicket(2, "Customer 2", 2);
        cinema.bookTicket(3, "Customer 3", 3);
        
        // Cancel a ticket
        cinema.cancelTicket(2);
        
        // Book a new ticket in the freed seat
        cinema.bookTicket(4, "Customer 4", 2);
        
        // Display all bookings
        cinema.displayAllBookings();
    }
}
