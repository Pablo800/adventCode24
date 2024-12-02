package adviento.part2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class daySecond {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String file = "AdventCode24/src/adviento/files/file2.txt";
		String linea;
		int seguros=0;
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		while ((linea = br.readLine()) != null && !linea.trim().isEmpty()) {
            StringTokenizer toke = new StringTokenizer(linea);
            List<Integer> niveles = new ArrayList<>();
            while (toke.hasMoreTokens()) {
                niveles.add(Integer.parseInt(toke.nextToken()));
            }

            if (esInformeSeguro(niveles)) {
                seguros++;
            }
        }
		
		br.close();

        System.out.println("Informes seguros: " + seguros);

	}
	
	public static boolean esInformeSeguro(List<Integer> niveles) {
        if (niveles.size() < 2) {
            return false; // No se puede determinar con menos de 2 niveles
        }

        // Determinar la tendencia inicial (ascendente o descendente)
        int tendencia = Integer.compare(niveles.get(1), niveles.get(0));
        if (tendencia == 0) {
            return false; // No puede haber niveles consecutivos iguales
        }

        // Verificar las condiciones para todos los niveles
        for (int i = 1; i < niveles.size(); i++) {
            int diferencia = niveles.get(i) - niveles.get(i - 1);

            // Verificar que la diferencia esté en el rango [1, 3] o [-1, -3]
            if (Math.abs(diferencia) < 1 || Math.abs(diferencia) > 3) {
                return false; // Diferencia fuera del rango permitido
            }

            // Verificar que la tendencia sea consistente
            if (Integer.compare(diferencia, 0) != tendencia) {
                return false; // Cambio de tendencia detectado
            }
        }

        return true; // Cumple con todas las reglas
    }

}
