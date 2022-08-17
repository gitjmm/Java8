package abstractas;

public class Abstractas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//No podemos instanciar una clase abstracta
		//AbstractaSencilla abstracta = new AbstractaSencilla();
		AbstractaSencilla extendida = new ClaseExtendida();
		
		extendida.saludo();
		extendida.get();
	}

}
