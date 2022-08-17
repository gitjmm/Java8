package interfaces;

public class Interfaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Vamos a comparar el área de dos rectángulos
		
		//Creamos dos rectángulos. El segundo desde la interfaz
		RectanglePlus rectangleOne = new RectanglePlus(10,30);
		Relatable rectangleTwo = new RectanglePlus(10,20);
		
		switch (rectangleOne.isLargerThan(rectangleTwo)) {
		case -1:
			System.out.println("Es menor");
			break;
		case 1:
			System.out.println("Es mayor");
			break;
		case 0:
			System.out.println("Es igual");
			break;
		}
		
		rectangleOne.print();
		//Relatable no tiene el metodo print
		
		//Uso de metodos abstractos, defecto y estáticos de Interfaz
		//Abstracto
		rectangleOne.metodo();
		//Por defecto
		rectangleOne.metodoPorDefecto();
		//Estático en interfaz
		Interfaz.metodoEstatico();
	}

}
