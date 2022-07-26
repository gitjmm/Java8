/* VARIABLES Y TIPOS DATOS */ 
public class HolaMundo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Variables
		System.out.println("Hola Mundo");
		String nombre = "Jorge";
		char letra = 'a';
		int numero = 1234;
		final int NUM_HORAS = 8;
		boolean resultado = true;
		System.out.println("Mi nombre es : "+nombre);
		System.out.println("Mi numero es : "+numero);
		System.out.println("Mi edad es 49 años");
		System.out.println("Trabajo : "+NUM_HORAS);
		System.out.println(nombre);
		System.out.println(resultado);
		
		/* Números enteros
		 * byte, short, int, long
		 * Números reales
		 * float 0.0f, double 0.0d
		 */
		
		/* Operadores numéricos
		 * prefijo, postfijo, unarios, multiplicativo  , aditivo, movimiento
		 */
		
		float precio = 12.35f;
		double otroPrecio = 123.40d;
		
		System.out.println("Precio : "+precio + " otro precio : "+ otroPrecio);
		
		double division = precio / numero;
		System.out.println("Division: "+division);
		byte x= 1;
		int z = x++;
		System.out.println("z: "+z);
		System.out.println("x: "+x);
		
		/* Operadores nivel bits
		 * &, |, ^
		 */
		
		int bits1 = 0b111;
		int bits2 = 0b101;
		int miand = bits1 & bits2; //101
		int mior = bits1 | bits2; //111
		System.out.println("AND: "+Integer.toBinaryString(miand) +" OR: "+Integer.toBinaryString(mior));
		
		/*Booleanos: true, false
		 * &&, ||, !
		 */
		
		/* Casting. Tipos de datos compatibles */
		System.out.println((double)5/9);
		System.out.println(5d/9);
		
		/* Estructuras de decisión
		 * Expresión: construcción con variables suma = 1 + 2
		 * Sentencia (linea de código) int suma = 1 + 2;
		 * Bloque de código. Código que va entre llaves
		 * Estructuras de decisión: if else else if
		 * switch(var){ case valor_var:expresion; break; ... default: expresion; }
		 * Si omitimos break pasa al siguiente case
		 */
		
		int n1 = 7, n2 = 4, n3 = 10;
		if (n1 > n2) {
			System.out.println("n1 > n2");
		} else {
			System.out.println("n1 < n2");
		}
		
		float nota =  6.3f;
		System.out.println("Nota: "+ nota);
		if (nota >= 5 && nota <=6) {
			System.out.println("Suficiente");
		} else if (nota > 6 && nota <=7){
			System.out.println("Bien");
		}
		
		int nota2 =  7;
		System.out.println("Nota: " + nota2);
		switch(nota2) {
		case 4: System.out.println("Suspenso"); break;
		case 5: System.out.println("Aprobado"); break;
		case 6: System.out.println("Bien"); break;
		case 7: System.out.println("Notable"); break; 
		default: System.out.println("Valo no válido");
		}
		
		/* Estructuras de repetición
		 * for (inicial; condición; inc/dec)
		 * while(condición)
		 * do while(condición)
		 */
		
	}

}
