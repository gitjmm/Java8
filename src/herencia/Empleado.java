package herencia;

public class Empleado extends Trabajador{
	private double sueldo;
	private double impuestos;
	
	public final int PAGAS = 14;
	
	public Empleado(String nombre, String puesto, String direccion, String telefono, String nSS, double sueldo, double impuestos) {
		super(nombre, puesto, direccion, telefono, nSS); //Si no lo indicamos hace super()
		this.sueldo = sueldo;
		this.impuestos = impuestos;
		
		
		
	}

	/**
	 * @return the sueldo
	 */
	public double getSueldo() {
		return sueldo;
	}

	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	/**
	 * @return the impuestos
	 */
	public double getImpuestos() {
		return impuestos;
	}

	/**
	 * @param impuestos the impuestos to set
	 */
	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}
	
	public double calcularPaga() {
		return (sueldo - impuestos) / PAGAS;
	}

	@Override
	public String toString() {
		return "Empleado [sueldo=" + sueldo + ", impuestos=" + impuestos + ", getNombre()=" + getNombre()
				+ ", getPuesto()=" + getPuesto() + ", getDireccion()=" + getDireccion() + ", getTelefono()="
				+ getTelefono() + ", getnSS()=" + getnSS() + "]";
	}
	
	

}
