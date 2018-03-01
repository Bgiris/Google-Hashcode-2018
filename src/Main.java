import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		String everything;
		BufferedReader br = new BufferedReader(new FileReader("./input/small.in"));
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
		for(String line: lines){
			String[] data = line.split(" ");
			System.out.println("hehe");
			System.out.println(data[0]);
		}
		
	}

}
