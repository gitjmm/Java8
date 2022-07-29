package poo2;

import poo2.paquetea.A;

public class metodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		imprimeMensajes("Esto","es","un mensaje");
		imprimeMensajes("Mensaje número 2");
		imprimeMensajes("Mensaje con dos","argumentos");
		
		// Argumentos tipos simples. Paso valor(copia y no se modifican) o NO EXISTE JAVA: referencia (se modifican)
		int x = 3;
		pasoValor(x);
		System.out.println("Después de paso valor x = " + x);
		
		//Argumentos objetos. Se pasa por valor (copia del objeto) pero permite cambiar el interior del objeto
		// Trabajo con clases y paquetes
		//Mismo paquete
		B b = new B();
		String hola = b.getB();
		//Desde subpaquete paquetea. Hay que importarlo
		A a = new A();
		String hola2 = a.getA();
		
		// static. Común a todos los objetos, es decir que pertenece a la clase. No se crean instancias.
		// Clase.metodoestatico Ejemplo: String.Arrays o static final double PI = 3.1416
		// Clase Bicicleta
		
		Bicicleta b1 = new Bicicleta(2, 50, 1);
		Bicicleta b2 = new Bicicleta(2, 60, 2);
		System.out.println("Numero de bicicletas: "+Bicicleta.numBicicletas);
		
	}
	
	/* ---- METODOS ----------*/
	// Uso de varargs. Un método puede recibir de 0 a n argumentos. Realmente es un array de argumentos.
	// Siempre va al final
	public static void imprimeMensajes(String... mensajes) {
		for (String mensaje : mensajes)
			System.out.println(mensaje);
	}
	
	public static void pasoValor(int p) {
		p = 10;
	}
	
	// Sobrecarga métodos. Métodos con el mismo nombre. Distinto numero de argumentos o tipos.
	
	
	
	
	
}
