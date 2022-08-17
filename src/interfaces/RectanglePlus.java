package interfaces;
import java.awt.Point;

public class RectanglePlus implements Relatable, MyInterface, Interfaz{

	public int width = 0;
	public int height = 0;
	public Point origin;
	
	//Constructores
	
	//Rectángulo sin alto ni ancho
	public RectanglePlus() {
		origin = new Point(0,0);
	}
	
	//Rectángulo sin alto ni ancho
	public RectanglePlus(Point p) {
		origin = p;
	}
	
	//Rectángulo con ancho y alto
	public RectanglePlus(int w,int h) {
		origin = new Point(0,0);
		width = w;
		height = h;
	}
	
	public RectanglePlus(Point p,int w,int h) {
		origin = p;
		width = w;
		height = h;
	}
	
	public void move(int x, int y) {
		origin.x = x;
		origin.y = y;
	}
	
	public int getArea() {
		return width * height;
	}

	//Método de interfaz Relatable
	@Override
	public int isLargerThan(Relatable other) {
		// TODO Auto-generated method stub
		RectanglePlus otherRect = (RectanglePlus)other;
		/*
		 * -1 El area del rectangulo de la clase es menor que el area del otro rectangulo
		 * 1 En caso contrario
		 * 0 son iguales
		 */
		if (this.getArea()<otherRect.getArea())
			return -1;
		else if (this.getArea()>otherRect.getArea())
			return 1;
		else return 0;
		
	}
	
	//Método de la interface MyInterface
	
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println(this.toString());
	}
	
	//Método de la interface Interfaz: metodo, metodoPorDefecto y metodoEstatico
	
	@Override
	public void metodo() {
		// TODO Auto-generated method stub
		System.out.println("Método abstracto");
		
	}
	
	public void metodoPorDefecto() {
		System.out.println("Metodo por defecto modificado en la clase RectanglePlus");
	}

	@Override
	public String toString() {
		return "RectanglePlus [width=" + width + ", height=" + height + ", origin=" + origin + ", getArea()="
				+ getArea() + "]";
	}
	
	
	
}
