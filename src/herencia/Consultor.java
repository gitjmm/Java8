package herencia;

public class Consultor extends Trabajador {
	private int horas;
	private int tarifa;
	
	public Consultor(String nombre, String puesto, String direccion, String telefono, String nSS, int horas, int tarifa) {
		super(nombre, puesto, direccion, telefono, nSS);
		this.horas = horas;
		this.tarifa = tarifa;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	@Override
	public String toString() {
		return "Consultor [horas=" + horas + ", tarifa=" + tarifa + ", getNombre()=" + getNombre() + ", getPuesto()="
				+ getPuesto() + ", getDireccion()=" + getDireccion() + ", getTelefono()=" + getTelefono()
				+ ", getnSS()=" + getnSS() + "]";
	}

	public double calcularPaga() {
		return horas*tarifa;
	}
	
	
}
