import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Main {
	
	private static void FileWrite(String filename) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("./output/"+filename+".out", "UTF-8");
		writer.println("The first line");
		writer.println("The second line");
		writer.close();
	}
	
	private static void FileRead(String filename) throws IOException{
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
		for(String line: lines){
			String[] data = line.split(" ");
			System.out.println("hehe");
			System.out.println(data[0]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		// INPUT FILE NAME
		BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
		String filename = brin.readLine();
		
		// READ
		FileRead(filename);
		FileWrite(filename);
		
	}

}
