package herencia;

public class Trabajador {
	private String nombre;
	private String puesto;
	private String direccion;
	private String telefono;
	private String nSS;
	
	//Polimorfismo
	private static final double SALARIO_BASE = 40000.0;
	
	/*Constructores. La clase derivada siempre va a llamar a un constructor por defecto sin argumentos
	 * 
	 */
	public Trabajador() {
		this.nombre = "";
		this.puesto = "";
		this.direccion = "";
		this.telefono = "";
		this.nSS = "";
	}
	
	//Constructor con argumentos
	public Trabajador(String nombre, String puesto, String direccion, String telefono, String nSS) {
		this.nombre = nombre;
		this.puesto = puesto;
		this.direccion = direccion;
		this.telefono = telefono;
		this.nSS = nSS;
	}
	
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
	 * @return the puesto
	 */
	public String getPuesto() {
		return puesto;
	}
	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the nSS
	 */
	public String getnSS() {
		return nSS;
	}
	/**
	 * @param nSS the nSS to set
	 */
	public void setnSS(String nSS) {
		this.nSS = nSS;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Trabajador [nombre=" + nombre + ", puesto=" + puesto + ", direccion=" + direccion + ", telefono="
				+ telefono + ", nSS=" + nSS + "]";
	}
	
	//Polimorfismo
	
	public double calcularPaga() {
		return SALARIO_BASE;
	}
	
}
