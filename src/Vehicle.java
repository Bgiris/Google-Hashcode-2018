import java.util.ArrayList;

public class Vehicle {
	public Position currentPos;
	public boolean isEmpty;
	public ArrayList<String> rideList;
	public Integer id;
	
	public Vehicle(Integer id) {
		this.rideList = new ArrayList<String>();
		this.currentPos = new Position(0,0);
		this.isEmpty = true;
	}
}
