package excepciones;

public class SaldoNegativoException extends Exception{
	
	public SaldoNegativoException(double saldo) {
		super("Saldo Negativo");
	}
	
}
