package API_lambda;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Stringbuilder
 * Tamaño inicial de 16. Es lo que ocupa realmente. Length. setLength(int)
 * Capacidad. Tamaño máximo. ensureCapacity(int min)
 * Otros métodos. append, delete, insert, replace, setCharAt, reverse, toString.
 */

/*Fechas
 * Libreria joda-time. Calendario predeterminado 
 * Clases: LocalDate, LocalDateTime, Duration, Period...
 * https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
 * 
 */

/*
 * ArrayList. Creación inicial de 10 elementos
 * Genéricos. Permite crear ArrayList de cualquier tipo. List<String> cars = new ArrayList<>()
 * Metodos. add, addAll, clear, contains, get, isEmpty, remove, size, toArray.
 */

public class Apis {
	
	static Scanner sc;
	static ArrayList<Persona> listaPersonas;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------String----------");
		String palindromo = "dabale arroz a la zorra el abad";
		int longitud = palindromo.length();
		//char[] tempCharArray = new char[longitud];
		char[] charArray = new char[longitud];
		
		//Transformar string en array de char. Se puede usar bucle normal
		char[] chars = palindromo.toCharArray();
		//for (char c : chars) {};
		for (int i=0; i<longitud; i++) {
			charArray[i] = chars[longitud - 1 - i];
		}
		
		for (char c : charArray) {
			System.out.print(c);
		}
		System.out.println("\n");
		String palindromoInvertido = new String(charArray);
		System.out.println(palindromoInvertido);
		
		
		System.out.println("-----------StringBuilder----------");
		String palindromo2 = "dabale arroz a la zorra el abad";
		StringBuilder sb = new StringBuilder(palindromo2);
		sb.reverse();
		System.out.println(sb);
		
		System.out.println("-----------Fechas----------");
		
		//Fecha actual
		LocalDate hoy = LocalDate.now();
		int year = hoy.getYear();
		int month = hoy.getMonthValue();
		int day = hoy.getDayOfMonth();
		System.out.printf("Año: %d Mes: %d Dia: %d \t %n",year,month,day);
		
		//Otra fecha. of nos permite obtener un objeto fecha of(año,mes,dia)
		LocalDate fecha = LocalDate.of(1973, 4, 30);
		LocalDate today = LocalDate.now();
		if (fecha.equals(today)) {
			System.out.println("La fecha de nacimiento son iguales a hoy");
		}else {
			System.out.println("Las fecha de nacimiento son diferentes a hoy");
		}
		
		//MonthDay guarda mes y día de una fecha
		LocalDate hoy2 = LocalDate.of(1973,4,30);
		MonthDay diaMes = MonthDay.of(hoy2.getMonth(), hoy2.getDayOfMonth());
		System.out.println("Mes y día de nacimiento: "+diaMes);
		
		//Hora con LocalTime
		LocalTime hora = LocalTime.now();
		System.out.println(hora);
		
		LocalTime horaMasDos = hora.plusHours(2);
		System.out.println("Sumamos dos horas a actual: "+horaMasDos);
		
		LocalDate proxSemana = LocalDate.now().plus(1,ChronoUnit.WEEKS);
		System.out.println(proxSemana);
		
		//Decidir si un año es bisiesto isLeapYear
		LocalDate hoy3 = LocalDate.now();
		if (hoy3.isLeapYear()) {
			System.out.println("Es bisiesto");
		}else {
			System.out.println("No es bisiesto");
		}
		
		//Periodo de tiempo. Diferencia entre dos fechas: P añosY mesesM diasD
		Period periodoTiempo = Period.between(hoy2, hoy);
		System.out.println("Periodo entre hoy y mi cumpleaños"+periodoTiempo);
		
		//Transformación de cadena a fecha
		String diaDespues = "20220819";
		//Formateamos cadena a fecha
		LocalDate formateoFecha = LocalDate.parse(diaDespues,DateTimeFormatter.BASIC_ISO_DATE);
		//Damos nuestro propio formato de fecha (se puede incluir horas,minutos y segundos
		String fecha2 = "10/08/2022";
		DateTimeFormatter miformato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate nuevaFecha = LocalDate.parse(fecha2,miformato);
		System.out.println(nuevaFecha);
		
		System.out.println("-------ARRAYLIST----------");
		listaPersonas = new ArrayList<>();
		sc = new Scanner(System.in);
		int opcion;
		
		do {
			menu();
			opcion = Integer.parseInt(sc.nextLine());
			
			switch(opcion) {
			case 1:
				listarPersonas();
				break;
			case 2:
				anadirPersonas();
				break;
			case 3: 
				eliminarPersonas();
				break;
			case 0:
				System.out.println("Adiós");
				break;
			}
		}while (opcion !=0);
		
		
		
		
	
		
	}//main
	
	public static void menu() {
		System.out.println("1.Listar 2.Crear 3.Eliminar 0.Salir");
	}
	
	public static void anadirPersonas() {
		System.out.println("Introduzca nombre: ");
		String nombre = sc.nextLine();
		System.out.println("Introduzca apellido: ");
		String apellido = sc.nextLine();
		
		listaPersonas.add(new Persona(nombre,apellido));
		System.out.println("");
		
	}
	
	public static void listarPersonas() {
		for (Persona p : listaPersonas) {
			System.out.println(p);
		}
		
		System.out.println("");
	}
	
	public static void eliminarPersonas() {
		listarPersonas();
		System.out.println("Posicion a eliminar");
		int posicion = Integer.parseInt(sc.nextLine());
		listaPersonas.remove(posicion);
		System.out.println("");
	}
	
	

}
