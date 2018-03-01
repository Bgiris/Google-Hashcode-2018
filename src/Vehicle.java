import java.util.ArrayList;

public class Vehicle {
	public Position currentPos;
	public boolean isEmpty;
	public ArrayList<String> rideList;
	public Integer id;
	public Integer finishT;
	
	public Vehicle(Integer id) {
		this.id = id;
		this.rideList = new ArrayList<String>();
		this.currentPos = new Position(0,0);
		this.isEmpty = true;
		this.finishT = 0;
	}
	
	public String toString() {
		String ridelist = new String();
		for(int i=0;i < rideList.size();i++) {
			ridelist = i + "	" + rideList.get(i) +"\n"; 
		}
		return "Id:" + this.id + "	" + "CurrentPos x:" + this.currentPos.x + "	y:" + 
				this.currentPos.y + "	IsEmpty:" + this.isEmpty + "RideList:\n" + ridelist + "\n";  
	}
}
