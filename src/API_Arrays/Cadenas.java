package API_Arrays;

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
		

	}

}
