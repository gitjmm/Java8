package herencia;

public class Herencia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Trabajador trabajador;
		Empleado empleado;
		Consultor consultor;
		
		trabajador = new Trabajador("Juan","Presidente","Malaga","","");
		empleado = new Empleado("Antonio","Contable","Madrid","","",10000.0,1000.0);
		consultor = new Consultor("Pepe","Contable","Valencia","","",20,1000);
		
		System.out.println(trabajador);
		System.out.println(empleado);
		System.out.println(empleado.calcularPaga());
		System.out.println(consultor);
		
		
		//Polimorfismo. Referencia a subclases.
		saludar(trabajador);
		saludar(empleado);
		saludar(consultor);
		
		imprimirPaga(trabajador);
		imprimirPaga(empleado);
		imprimirPaga(consultor);

	}
	
	//Polimorfismo. Referencia a subclases
	public static void saludar(Trabajador t) {
		System.out.println("Hola, " + t.getNombre()); 
	}
	
	//Polimorfismo. Sobrecarga calcularPaga
	public static void imprimirPaga(Trabajador t) {
		System.out.printf("El trabajador %s tiene paga de %.2f€ \n",t.getNombre(),t.calcularPaga());
	}
	
	

}
