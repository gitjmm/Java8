package excepciones;

public class CuentaCorriente{
	public String propietario;
	public double saldo;
	public CuentaCorriente(String propietario, double saldo) {
		super();
		this.propietario = propietario;
		this.saldo = saldo;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void sacarDinero(double dinero) throws SaldoNegativoException {
		setSaldo(saldo - dinero);
		if (saldo < 0) {
			throw new SaldoNegativoException(saldo);
		}
	}
	
	public void ingersarDinero(double dinero) {
		setSaldo(saldo + dinero);
	}

}
