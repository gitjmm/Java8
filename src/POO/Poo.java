/**
 * 
 */
package POO;

/**
 * @author Usuario
 *
 */
public class Poo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
		
		persona.nacer();
		persona.caminar();
		persona.hablar();
		persona.morir();
		
		//Uso de getter/setter
		System.out.println("Uso de getter/setter y toString");
		persona.setNombre("Jorge");
		persona.setApellidos("Martinez");
		persona.setAltura(180);
		persona.setEdad(49);
		persona.setPeso(75);
		
		//Uso de toString
		System.out.println(persona);
		
		// Clases envoltorio. Todo tipo de dato tiene una clase envoltorio. int - Integer...
		int n = 12345;
		int n2 = 12346;
		int max = Integer.max(n,n2);
		int n3 = Integer.parseInt("123");
		
		System.out.println(n);
		System.out.println(n2);
		System.out.println(n3);

	}

}
