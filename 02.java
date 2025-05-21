class Vehicle{
	private String licensePlate;
	private String ownerName;
	private int hoursParked;
	
	Vehicle(String lp, String on, int hp){
		licensePlate=lp;
		ownerName=on;
		hoursParked=hp;
	}
	
	String getLicensePlate(){
		return licensePlate;
	}
	
	void setLicensePlate(String licensePlate){
		this.licensePlate=licensePlate;
	}
	
	String getOwnerName(){
		return ownerName;
	}
	
	void  setOwnerName(String ownerName){
		this.ownerName=ownerName;
	}
	
	int getHoursParked(){
		return hoursParked;
	}
	
	void setHoursParked(int hoursParked){
		this.hoursParked=hoursParked;
	}
	
	void displayInfo(){
		System.out.println("License plate: "+licensePlate+ ", Owner: "+ownerName+", Hours Parked: "+hoursParked);
	}
}

class ParkingLot{
	private Vehicle[] vehicles;
	private  int count;
	
	ParkingLot(){
		vehicles= new Vehicle[5];
		count=0;
	}
	
	void parkVehicle(Vehicle v){
		if(count<5){
			vehicles[count]=v;
			count++;
			System.out.println("Vehicle parked: "+v.getLicensePlate());	
		}else{
			System.out.println("Parking lot is full. Can't park vehicle: "+v.getLicensePlate());
		}
	}
	
	void removeVehicle(String licensePlate){
		int index=-1;
		for(int i=0; i<count; i++){
			if(vehicles[i].getLicensePlate().equalsIgnoreCase(licensePlate)){
				index=i;
				break;
			}
		}
		if(index==-1){
			System.out.println("Vehicle with license plate "+licensePlate+" not found.");
			return;
		}
		for(int i=index; i<count-1; i++){
			vehicles[i]=vehicles[i+1];
		}
		vehicles[count-1]=null;
		count--;
		System.out.println("Vehicle with license plate "+licensePlate+ " removed");
	}
	
	void displayAllVehicle(){
		if(count==0){
			System.out.println("Parking lot is empty");
			return;
		}
		System.out.println("Parked Vehicles: ");
		for(int i=0; i<count; i++){
			vehicles[i].displayInfo();
		}
	}
	
}

class Main{
	public static void main(String[] args){
		ParkingLot lot=new ParkingLot();
		
		lot.parkVehicle(new Vehicle("ABC123","John Doe", 2));
		lot.parkVehicle(new Vehicle("XYZ789","Jane Smith", 4));
		lot.parkVehicle(new Vehicle("LMN456","Bob Brown", 1));
		
		lot.removeVehicle("XYZ789");
		
		lot.displayAllVehicle();
	}
}