
public class Ride {
	
	public Position startPos;
	public Position finishPos;
	public Integer startTime;
	public Integer finishTime;
	public Integer distance;
	public boolean isEmpty;
	
	public Ride(Position _startPos, Position _finishPos, Integer _startTime, Integer _finishTime) {
		this.startPos = _startPos;
		this.finishPos = _finishPos;
		this.startTime = _startTime;
		this.finishTime = _finishTime;
		this.distance = Math.abs(_finishPos.x - _startPos.x) + Math.abs(_finishPos.y - _startPos.y);
		this.isEmpty = false;
	}
}