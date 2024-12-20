package adviento.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class dayOne {

	public static void main(String[] args) {
		
		//System.out.println(System.getProperty("user.dir"));
		
		String file = "AdventCode24/src/adviento/files/file1.txt";
		Map<String, ArrayList<Integer>> anotaciones = leerFichero(file);
		
		ArrayList<Integer> listColA = anotaciones.get("colA");
		ArrayList<Integer> listColB = anotaciones.get("colB");
		
		Collections.sort(listColA);
		Collections.sort(listColB);
		
		int diferencia = 0;
		
		for(int i = 0; i < listColA.size(); i++) {
			
			diferencia = diferencia += Math.abs(listColA.get(i) - listColB.get(i));
		}
		
		System.out.println("Diferencia: "+diferencia);
		
		System.out.println("Similitud: "+ getSimilitud(listColA, listColB));
	
	}
	
	private static int getSimilitud(ArrayList<Integer> listColA, ArrayList<Integer> listColB) {
		int resultado=0;
		
		for(int numero : listColA) {
			int multiplicador = 0;
			for(int numeroB : listColB) {
				if(numero == numeroB) {
					multiplicador++;
				}
			}
			resultado += numero*multiplicador;
		}
		
		return resultado;
	}

	public static Map<String, ArrayList<Integer>> leerFichero (String file){
		
		ArrayList<Integer> colA = new ArrayList<>();
		ArrayList<Integer> colB = new ArrayList<>();
		String linea;
		
		try {			
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while ((linea = br.readLine()) != null) {
				StringTokenizer toke = new StringTokenizer(linea);
				
				if(toke.countTokens() == 2) {
					colA.add(Integer.parseInt(toke.nextToken()));
					colB.add(Integer.parseInt(toke.nextToken()));
				}
			}
			
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map<String, ArrayList<Integer>> resultado = new HashMap<>();
		resultado.put("colA", colA);
		resultado.put("colB", colB);
		
		return resultado;
	}

}
