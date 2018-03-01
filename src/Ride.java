
public class Ride implements Comparable<Ride>{
	
	public Integer id;
	public Position startPos;
	public Position finishPos;
	public Integer startTime;
	public Integer finishTime;
	public Integer distance;
	public boolean isEmpty;
	
	public Ride(Integer _id, Position _startPos, Position _finishPos, Integer _startTime, Integer _finishTime) {
		this.id = _id;
		this.startPos = _startPos;
		this.finishPos = _finishPos;
		this.startTime = _startTime;
		this.finishTime = _finishTime;
		this.distance = Math.abs(_finishPos.x - _startPos.x) + Math.abs(_finishPos.y - _startPos.y);
		this.isEmpty = false;
	}
	
	public String toString() {
		return "Id:" + this.id + "   "
				+ "Start position:" + this.startPos.x + ", " + this.startPos.y + "   "
                + "finish position:" + this.finishPos.x + ", " + this.finishPos.y + "   "
                + "start time:" + this.startTime + "  " 
                + "finish time:" + this.finishTime + "   "
                + "distance:" + this.distance + "  " 
                + "isEmpty:" + this.isEmpty;
	}
	
	public int compareTo(Ride other) {
        return distance.compareTo(other.distance);
    }
	
}