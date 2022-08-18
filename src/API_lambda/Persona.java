package API_lambda;

public class Persona {
	
	//Atributos
	private String nombre;
	private String apellidos;
	private int edad;
	private int altura;
	private float peso;
	
	/* Constructor.  
	 * Si no se define, existe por defecto. Si lo creamos tenemos que definir uno por defecto
	 * super(). Hace una llamada al constructor padre por defecto. Esta llamada siempre se hace.
	 * this(). Hace llamada al constructor de la clase por defecto.
	 * No se pueden usar ambos, uno u otro.
	 * Si se define un constructor ya no se puede usar el constructor por defecto, debemos crearlo.
	 */
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
	
	// Métodos getter y setter
	

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the altura
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * @return the peso
	 */
	public float getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(float peso) {
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

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", altura=" + altura
				+ ", peso=" + peso + "]";
	}
	
	

}
