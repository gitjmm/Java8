package Calculadora;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Calculadora");
		int opcion = 0;
		Scanner sc;
		
		do {
			System.out.println("\n");
			System.out.println("1.Sumar");
			System.out.println("2.Resar");
			System.out.println("3.Multiplicar");
			System.out.println("4.Dividir");
			System.out.println("0.Salir");
			System.out.print("Introduzca opcion : ");
			
			// Leemos desde teclado. Pasamos de string a integer
			sc = new Scanner(System.in);
			opcion = Integer.parseInt(sc.nextLine());
			
			if (opcion < 0 || opcion > 4) {
				System.out.println("Opción no válida");
				//opcion entre 0 y 4
			} else if (opcion != 0) {
				//pedimos números
				System.out.println("\n");
				float num1, num2;
				System.out.println("Primer número");
				num1 = Float.parseFloat(sc.nextLine());
				System.out.println("Segundo número");
				num2 = Float.parseFloat(sc.nextLine());
				
				System.out.println("\n");
				switch(opcion) {
					case 1:
						System.out.println("Sumar: "+ (num1+num2)); break;
					case 2:
						System.out.println("Restar: "+ (num1-num2)); break;
					case 3:
						System.out.println("Multiplicar: "+ (num1*num2)); break;
					case 4:
						System.out.println("Dividir: "+ (num1/num2)); break;
				}
			}
			
		} while(opcion != 0);
		
		sc.close();
		System.out.println("Adiós");

	}

}
