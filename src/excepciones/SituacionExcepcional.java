package excepciones;

public class SituacionExcepcional {
	/*
	 * Excepciones
	 * El lenguaje Java utiliza un mecanismo de excepciones, 
	 * las excepciones son objetos que se lanzan cuando se produce una condición de error. 
	 * Todas las excepciones en Java heredan de Throwable subdividiéndose en Error y Exception, 
	 * las primeras son condiciones de error del sistema y las segundas condiciones de error 
	 * del programa. A su vez las Exception pueden ser checked si heredan de esta y son aquellas 
	 * que el compilador fuerza a que sean capturadas no pudiendo ignorarse, han de capturarse en 
	 * una construcción try catch o declarar que el método puede lanzar la excepción no capturada. 
	 * Las excepciones unchecked heredan de RuntimeException que heredan a su vez de Exception pero 
	 * tienen la particularidad de que no es necesario capturarlas ni declararlas como que se 
	 * pueden lanzar debido a que se consideran condiciones de error en la programación como 
	 * un acceso a un array fuera de rango que produce un ArrayIndexOutOfBounds, el conocido 
	 * NullPointerException cuando se utiliza una referencia nula, otro es ArithmeticException 
	 * que se produce al dividir por 0.
	 */
	
	/*
	 * Try-catch
	 * finally no es obligatorio. Se ejecuta siempre.
	 * Más de un catch. De más concreto a más genérico
	 * Podemos recoger en un mismo catch más de una excepción con |
	 */
	
	/*
	 * Excepciones más comunes
	 * https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html
	 * https://www.clasesdeinformaticaweb.com/java-desde-cero/excepciones-en-java-y-control-de-errores/
	 */
	
	/*
	 * Lanzar excepciones
	 * Throws. Permite propagar (delegar en la clase superior) la excepción
	 * Excepción propia con Exception
	 * public class ClaseExcep extends Exception{ public ClaseExcep(){ super("MiExcepcion"); }
	 * Lanzar de forma explicita una excepción: throw new ClaseExcep("excepción")
	 * Si no se lanza (throw) tenemos que tratar la excepción en el propio método
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Excepciones controladas
		//String name = null;
		String name = "Nombre";
		System.out.println(name);
		System.out.println(name.length());
		
		//Excepciones no controladas
		
		int a = 5;
		int b = 0;
		try {
			System.out.println(a / b); //error división por cero
		//Excepción concreta
		}catch(ArithmeticException ex) {
			//e.printStackTrace();
			System.out.println("Error división por cero"+ ex.getMessage());
		//Excpción genérica
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Error división por cero genérica Exception");
		}
		System.out.println("El programa continúa");
		
		System.out.println("--------- Excepciones en arrays----------");
		
		String[] mensajes = {"En un lugar ", null, "de la Mancha " , "de cuyo nombre ", "no quiero acordarme"};
		
		try {
			for (int i=0; i < 5; i++) {
				System.out.println(mensajes[i].toUpperCase());
			}
		}catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.err.println("Tratamiento común a excepciones "); //Imprime errores en color rojo
		}
		
		System.out.println("Mensaje final de programa");
	}
	

}
