package adviento.part3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class daythree {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		String file = "AdventCode24/src/adviento/files/file3.txt";
		String linea;
		int resultado=0;
		
		BufferedReader br = new BufferedReader(new FileReader(file));
			
		while ((linea = br.readLine()) != null && !linea.trim().isEmpty()) {
			resultado += recogerMultiplicaciones(linea);
		}
		
		br.close();
		
		System.out.println("Resultado: "+resultado);
			
	}

	private static int recogerMultiplicaciones(String linea) {
		
		int resultado=0;
		
		String regex = "mul\\((\\d+),(\\d+)\\)";
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(linea);
        
        while(matcher.find()) {
        	int num1 = Integer.parseInt(matcher.group(1));
        	int num2 = Integer.parseInt(matcher.group(2));
        	
        	resultado += num1*num2;
        }
				
		return resultado;
	}

}