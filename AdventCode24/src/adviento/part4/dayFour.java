package adviento.part4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class dayFour {
	
	public static void main(String[] args) throws IOException, FileNotFoundException {
		String file = "AdventCode24/src/adviento/files/file4.txt";
		String linea;
		int resultado=0;
		
		BufferedReader br = new BufferedReader(new FileReader(file));
			
		while ((linea = br.readLine()) != null && !linea.trim().isEmpty()) {
			resultado += recogerXmas(linea);
		}
		
		br.close();
		
		System.out.println("Resultado: "+resultado);
			
	}

	private static int recogerXmas(String linea) {
		int count=0;
		
		
		
		return count;
	}

}
