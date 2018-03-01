import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static Integer R;
	public static Integer C;
	public static Integer F;
	public static Integer N;
	public static Integer B;
	public static Integer T;
	
	private static void FileWrite(String filename) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("./output/"+filename+".out", "UTF-8");
		writer.println("The first line");
		writer.println("The second line");
		writer.close();
	}
	
	private static String[] FileRead(String filename) throws IOException{
		String everything;
		BufferedReader br = new BufferedReader(new FileReader("./input/"+filename+".in"));
		
		try {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    everything = sb.toString();
		} finally {
		    br.close();
		}
		String[] lines = everything.split("\\n");
		
		return lines;
	}
	
	public static void main(String[] args) throws IOException {
		
		ArrayList<Ride> emptyRides = new ArrayList<Ride>();
		ArrayList<Ride> nonEmptyRides = new ArrayList<Ride>();
		ArrayList<Vehicle> emptyVehicles = new ArrayList<Vehicle>();
		ArrayList<Vehicle> nonEmptyVehicles = new ArrayList<Vehicle>();
		
		
		
		
		// INPUT FILE NAME
		BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
		String filename = brin.readLine();
		
		// READ
		String[] inputLines = FileRead(filename);
		String[] firstLine = inputLines[0].split(" ");
		R = Integer.parseInt(firstLine[0]);
		C = Integer.parseInt(firstLine[1]);
		F = Integer.parseInt(firstLine[2]);
		N = Integer.parseInt(firstLine[3]);
		B = Integer.parseInt(firstLine[4]);
		T = Integer.parseInt(firstLine[5].split("\\r")[0]); 
		
		for(int i = 1; i <= F; i++) {
			emptyVehicles.add(new Vehicle(i));
		}
		
		for(int i = 1; i <= N; i++) {
			String[] line = inputLines[i].split(" ");
			Integer a,b,x,y,s,f;
			a = Integer.parseInt(line[0]);
			b = Integer.parseInt(line[1]);
			x = Integer.parseInt(line[2]);
			y = Integer.parseInt(line[3]);
			s = Integer.parseInt(line[4]);
			f = Integer.parseInt(line[5].split("\\r")[0]);
			emptyRides.add(new Ride(i-1, new Position(a,b), new Position(x,y), s, f));
		}
		
		Collections.sort(emptyRides);
		
		for(int i = 0; i < F; i++) {
			System.out.println(emptyVehicles.get(i));
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(emptyRides.get(i));
		}
		for(int t =0; t <= T;t++) {
			for(int i =0; i < emptyRides.size();i++) {
				Ride ride = emptyRides.get(i);
				if(ride.finishTime <= t) {
					emptyRides.remove(i);
					i--;
					continue;
				}
				Vehicle vehicle; 
				Integer min = Integer.MAX_VALUE;
				int minIndex = -1;
				for(int j=0; j < emptyVehicles.size();j++) {
					vehicle = emptyVehicles.get(j);
					Integer dist = Math.abs(vehicle.currentPos.x - ride.startPos.x) + Math.abs(vehicle.currentPos.y - ride.startPos.y);
					if(dist < min) {
						min = dist;
						minIndex = j;
					}
					
				}
				if(min + ride.distance + t > ride.finishTime) {
					emptyRides.remove(i);
					i--;
					continue;
				}
				if(minIndex != -1) {
					emptyRides.remove(i);
					vehicle = emptyVehicles.get(minIndex);
					emptyVehicles.remove(minIndex);
					nonEmptyVehicles.add(vehicle);
					vehicle.rideList.add(Integer.toString(ride.id));
					vehicle.isEmpty = false;
					vehicle.finishT = min + ride.distance + t;
					i--;
					
				}
			}
			for(int i = 0; i<nonEmptyVehicles.size(); i++) {
				Vehicle tempVehicle = nonEmptyVehicles.get(i);
				//mape at t basina cikar
				if(tempVehicle.finishT == t) {
					nonEmptyVehicles.remove(i--);
					emptyVehicles.add(tempVehicle);
				}
			}
		}
		
		System.out.println("heheh");
		for(int i = 0; i < F; i++) {
			System.out.println(emptyVehicles.get(i).rideList);
		}
		
		
		//FileWrite(filename);
		PrintWriter writer = new PrintWriter("./output/"+filename+".out", "UTF-8");
		for(int i = 0; i < emptyVehicles.size(); i++) {
			String x ="";
			for(int j = 0; j < emptyVehicles.get(i).rideList.size(); j++) {
				x += emptyVehicles.get(i).rideList.get(j);
				if(j != emptyVehicles.get(i).rideList.size() - 1)
					x+= " ";
			}
			writer.println(emptyVehicles.get(i).id + " " + x);
		}
		System.out.println("DONE");
		writer.close();
	}

}
