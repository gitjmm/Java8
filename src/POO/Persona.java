package POO;

public class Persona {
	
	//Atributos
	private String nombre;
	private String apellidos;
	private int edad;
	private int altura;
	private float peso;
	
	//Constructor
	public Persona() {
		this.nombre = "desconocido";
		this.apellidos = "desconocido";
		this.edad = 0;
	}
	
	public Persona(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public Persona(String nombre, String apellidos, int edad) {
		this(nombre,apellidos);
		this.edad = edad;
	}
	
	//Generado con eclipse: source - generar constructor con los campos
	
	public Persona(String nombre, String apellidos, int edad, int altura, float peso) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.altura = altura;
		this.peso = peso;
	}

	// métodos
	void caminar() {
		System.out.println("Estoy caminando");
	}
	
	void nacer() {
		System.out.println("Estoy naciendo");
	}
	
	void hablar() {
		System.out.println("Estoy hablando");
	}
	
	void morir() {
		System.out.println("Adiós");
	}

}
