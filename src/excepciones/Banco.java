package excepciones;

public class Banco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CuentaCorriente cc = new CuentaCorriente("Antonio",100.0);
		try {
			cc.sacarDinero(150.0);
			System.out.println("Saldo: "+cc.getSaldo());
		}catch(SaldoNegativoException e) {
			System.out.println("Saldo: "+cc.getSaldo());
			System.out.println("Te has quedado al descubierto");
		}

	}

}
