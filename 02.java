class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getHoursParked() {
        return hoursParked;
    }

    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }
}

class ParkingLot {
    private Vehicle[] vehicles;
    private int vehicleCount;

    public ParkingLot() {
        vehicles = new Vehicle[5];
        vehicleCount = 0;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (vehicleCount < 5) {
            vehicles[vehicleCount] = vehicle;
            vehicleCount++;
        } else {
            System.out.println("Parking lot is full. Cannot park more vehicles.");
        }
    }

    public void removeVehicle(String licensePlate) {
        int index = -1;
        for (int i = 0; i < vehicleCount; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Vehicle with license plate " + licensePlate + " not found.");
            return;
        }

        // Shift remaining vehicles
        for (int i = index; i < vehicleCount - 1; i++) {
            vehicles[i] = vehicles[i + 1];
        }
        vehicleCount--;
        vehicles[vehicleCount] = null;
    }

    public void displayAllVehicles() {
        for (int i = 0; i < vehicleCount; i++) {
            System.out.printf("License: "+vehicles[i].getLicensePlate()); 
            System.out.println( "Owner: "+vehicles[i].getOwnerName());
            System.out.println("Hours Parked: " +vehicles[i].getHoursParked()+"hour");
        }
    }
}

class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        
        // Park vehicles
        parkingLot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        parkingLot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        parkingLot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));
        
        // Remove a vehicle
        parkingLot.removeVehicle("XYZ789");
        
        // Display all vehicles
        parkingLot.displayAllVehicles();
    }
}
