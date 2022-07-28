package API_Arrays;

import java.util.Arrays;

public class Cadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Concatenar
		String nombre = "Jorge";
		String apellido = "Martinez";
		String cadena = nombre + apellido;
		String cadena2 = nombre.concat(apellido);
		
		System.out.println(cadena);
		System.out.println(cadena2);
		System.out.println(cadena.toLowerCase());
		
		String mensaje = "te saludo";
		
		//Utilizamos printf (print con formato)
		System.out.printf("Hola, soy %s %s y %s", nombre, apellido, mensaje);
		
		//Comparar cadenas
		int compara = nombre.compareTo(apellido);
		System.out.println(compara);
		System.out.println(nombre.contains("o"));
		
		
		/* -------------ARRAYS ----------- */
		System.out.println("--------ARRAYS---------");
		int[] unArray = new int[10];
		unArray[1] = 100;
		for (int i=0; i<unArray.length; i++)
			unArray[i]  = 0;
		
		int[] miArray = { 1,3,5,7,9,2,4,6,8,10 };
		for (int i : miArray)
				System.out.println("Elemento de miArray "+ i);
		System.out.println("----Arrays bidimensionales------");
		int[][] biArray = new int[3][4];
		byte cont = 0;
		for (int i=0; i < biArray.length; i++) {
			for (int j=0; j < biArray[0].length; j++) {//biArray[0] - columnas
				biArray[i][j] = cont++;
				System.out.print(biArray[i][j]+"\t");
			}
			System.out.println(" ");
		}
		
		/* Métodos java.util.Arrays */
		//Copiar
		int[] copia = Arrays.copyOf(miArray, 10);
		for (int a : copia)
			System.out.println(a + "\t");
		//Buscar en arrays. consultar binarySearch????
		int num = 10;
		int pos = Arrays.binarySearch(copia, num);
		System.out.println("El elemento " + num + " está en posición "+pos);
		
		//Ordenar array
		Arrays.sort(copia);
		for (int a : copia)
			System.out.println(a + "\t");
	}

}
