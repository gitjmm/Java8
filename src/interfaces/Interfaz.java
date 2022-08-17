package interfaces;

/*
 * En esta interfaz vamos a ver el funcionamiento de métodos abastractos, defecto y estáticos
 */

public interface Interfaz {
	//Método abstracto sin implementar.
	public void metodo();
	
	default public void metodoPorDefecto() {
		System.out.println("Método por defecto");
	}
	
	public static void metodoEstatico() {
		System.out.println("Método estático");
	}
}
