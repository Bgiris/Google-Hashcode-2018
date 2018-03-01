import java.util.ArrayList;

public class Vehicle {
	public Position currentPos;
	public boolean isEmpty;
	public ArrayList<String> rideList = new ArrayList<String>();
	
	public Vehicle(Position current) {
		this.currentPos = current;
		this.isEmpty = true;
	}
}
