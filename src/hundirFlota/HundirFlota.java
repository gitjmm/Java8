/**
 * HUDIR LA FLOTA
 * 
 * Se trata de un juego clásico, en el que nos vamos a enfrentar al ordenador. Cada usuario dispone de un mapa
 * de 10x10 casillas, donde se colocarán barcos (dos de tamaño 5, tres de tamaño 3, y cinco de tamaño 1). 
 * Jugador y ordenador irán diciendo posiciones en el mapa, y el jugador opuesto tendrá que indicar si la "bomba"
 * ha caído en el agua, o ha tocado algún barco.
 * 
 * Para simplificar el juego, en lugar de verificar si un barco completo se ha hundido, y cuantos barcos quedan a flote,
 * contabilizamos el número total de casillas correspondientes a un barco que no han sido "hundidas". Se parte con
 * 24 puntos (5+5+3+3+3+1+1+1+1+1) 
 * 
 * Este código está inspirado (aunque reescrito y simplificado) de un código original de Manuel Jesús Gallego Vela
 */
package hundirFlota;

import java.util.Random;
import java.util.Scanner;

public class HundirFlota {

	//CONSTANTES
	final static char AGUA_NO_TOCADO = '.';
	final static char AGUA = 'A';
	final static char TOCADO = 'X';
	
	//TAMAÑO TABLERO
	final static int TAMANIO = 10;
	
	private static Scanner sc;
	
	/* ------ METODOS ------------ */
	
	/* 
	 * Inicialización de mapas
	 */
	public static void inicializacion(char[][] m1,char[][] m2) {
		inicializaMapa(m1);
		inicializaMapa(m2);
	}
	
	
	//Devuelve un número aleatorio
	private static int aleatorio() {
		Random r = new Random(System.currentTimeMillis());
		return r.nextInt(TAMANIO);
	}
	
	/*
	 * Método que inicializa un mapa de juego, colocando
	 * los barcos sobre el mismo.
	 */
	
	private static void inicializaMapa(char[][] mapa) {
		// Inicializamos mapa a AGUA_NO_TOCADO
		for (int i=0; i<TAMANIO; i++)
			for (int j=0; j<TAMANIO; j++)
				mapa[i][j] = AGUA_NO_TOCADO;
		
		//2 portaaviones (5 casillas)
		//3 buques (3 casillas)
		//5 lanchas (1 casilla)
		int[] barcos = {5,5,3,3,3,1,1,1,1,1};
		
		//Dirección colocación barco
		char[] direccion = {'V','H'};
		
		//Por cada barco
		for (int b : barcos) {
			// Intentamos tantas veces sea necesarias para colocar el barco en el mapa.
			// Vamos de mayor tamaño a menor, para que sea menos
			// dificultoso encontrar un hueco
			boolean colocado = false;
			while(!colocado) {
				//Posición y dirección aleatorias
				int fila = aleatorio();
				int columna = aleatorio();
				char direcc = direccion[aleatorio() % 2];
				
				//Comprobar si barco va en posición indicada. 
				if (direcc == 'V') {
					if (fila + b <= (TAMANIO-1)) {
						//Comprobamos que no hay otro barco que se solape. Recorremos las posiciones que ocupará.
						//Nos colocamos en pos fila. i menor que el tamaño del barco y no hay otro.
						boolean otro = false;
						for (int i = fila; (i <= fila + b) && !otro; i++ ) {
							if (mapa[i][columna] != AGUA_NO_TOCADO)
								otro = true;
						}
						
						//Si no hay otro barco, lo colocamos
						if (!otro) {
							for (int i = fila; i < fila + b; i++) {
								mapa[i][columna] = Integer.toString(b).charAt(0);
							}
							colocado = true;
						}
					}
				}else {//direccion H
					if (columna + b <= (TAMANIO-1)) {
						//Comprobamos que no hay otro barco que se solape. Recorremos las posiciones que ocupará.
						//Nos colocamos en pos fila. i menor que el tamaño del barco y no hay otro.
						boolean otro = false;
						for (int j = columna; (j <= columna + b) && !otro; j++ ) {
							if (mapa[fila][j] != AGUA_NO_TOCADO)
								otro = true;
						}
						
						//Si no hay otro barco, lo colocamos. Convierte el entero en char.
						if (!otro) {
							for (int j = columna; j < columna + b; j++) {
								mapa[fila][j] = Integer.toString(b).charAt(0);
							}
							colocado = true;
						}
					}
				}
			}
		}
		
	}
	/*
	 * Método que inicializa el mapa que mostramos al usuario
	 * con las tiradas que ha hecho sobr el mapa del ordenador.
	 */
	private static void inicializaMapaRegistro(char[][] mapa) {
		// Inicializamos el mapa entero a AGUA_NO_TOCADO
		for (int i = 0; i < TAMANIO; i++)
			for (int j = 0; j < TAMANIO; j++)
				mapa[i][j] = AGUA_NO_TOCADO;
		
	}
	
	/*
	 * Método que imprime un mapa, con una fila y columna de encabezados
	 */
	
	private static void imprimirMapa(char[][] mapa) {
		// Calculamos las letras
		char[] letras = new char[TAMANIO];
		for (int i=0; i<TAMANIO; i++)
			letras[i] = (char)('A'+i);
		
		// Imprimir fila de encabezado
		System.out.println("   ");
		System.out.print("    ");
		for (int i = 0; i<TAMANIO; i++){
			System.out.print("["+ i + "]");
			System.out.print(" ");
		}
		
		System.out.println("");
		
		// Imprimimos resto de filas
		for (int i = 0; i < TAMANIO; i++) {
			System.out.print("[" + letras[i] + "]  ");
			for (int j = 0; j < TAMANIO; j++) {
				System.out.print(mapa[i][j] + "   ");
			}
			System.out.println("");
		}
		
	}
	
	// Método por el que el usuario introduce una casilla de tirada
	private static int[] pedirCasilla() {
		System.out.println("Introduzca casilla (Ejemplo A1)");
		String linea = sc.nextLine();
		linea = linea.toUpperCase();
		int[] t;
		
		// Comprobamos que lo introducido por el usuario es correcto con expresiones regulares
		if (linea.matches("^[A-Z][0-9]*$")) {
			// Obtenemos letra
			char letra = linea.charAt(0);
			// getNumericValue - Devuelve el valor entero de un caracter. 
			// El número de fila es VALOR_NUMERICO(LETRA) - VALOR_NUMERICO(A).
			int fila = Character.getNumericValue(letra) - Character.getNumericValue('A');
			// Para la columna, tan solo tenemos que procesar el número
			int columna = Integer.parseInt(linea.substring(1, linea.length()));
			// Si las coordenadas están dentro del tamaño del tablero, las devolvemos
			if (fila >= 0 && fila < TAMANIO && columna >= 0 && columna <= TAMANIO) {
				t = new int[]{ fila, columna };
			} else //En otro caso, devolvemos -1, para que vuelva a solicitar el tiro
				t =  new int[] { -1, -1 };
		} else 
			t =  new int[] { -1, -1 };
		
		
		return t;
		}
	
	/*
	 * Método que nos permite evaluar si un tiro es CORRECTO (AGUA o TOCADO)
	 * o se trata de una casilla por la que ya hemos pasado antes.
	 */
	
	
	public static boolean evaluarTiro(char[][] mapa, int[] t) {
		int fila = t[0];
		int columna = t[1];
		return mapa[fila][columna] == AGUA_NO_TOCADO || (mapa[fila][columna] >= '1' && mapa[fila][columna] <= '5'); 
		
	}
	
	/*
	 * Método que actualiza el mapa, con un determinado tiro. 
	 * Devolvemos el número de puntos restantes.
	 */
	private static int actualizarMapa(char[][] mapa, int[] t, int puntos) {
		int fila = t[0];
		int columna = t[1];
		
		if (mapa[fila][columna] == AGUA_NO_TOCADO) {
			mapa[fila][columna] = AGUA;
			System.out.println("AGUA");
		} else {			
			mapa[fila][columna] = TOCADO;
			System.out.println("HAS ALCANZADO A ALGÚN BARCO");
			--puntos;
		}
		
		return puntos;
		
		
	}
	
	/*
	 * Método que sirve para que el ordenador pueda hacer un disparo
	 */
	private static int[] generaDisparoAleatorio() {		
		return new int[] {aleatorio(), aleatorio()};
	}
	
	/*
	 * Método que actualiza el mapa de registro
	 */
	private static void actualizarMapaRegistro(char[][] mapa, int[] t, char valor) {
		int fila = t[0];
		int columna = t[1];

		mapa[fila][columna] = valor;
	}

	
	
	
	/* --------MAIN--------------*/

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Leer desde teclado
		sc = new Scanner(System.in);
		
		//Mapas
		char[][] mapaUsuario = new char[TAMANIO][TAMANIO];
		char[][] mapaOrdenador = new char[TAMANIO][TAMANIO];
		
		//Mapa para anotar las tiradas realizadas
		char[][] mapaOrdenadorParaUsuario = new char[TAMANIO][TAMANIO];
		
		//puntos de comienzo
		int puntosUsuario = 24;
		int puntosOrdenador = 24;
		
		//Variable que controla fin del juego. Si  no quedan barcos se pone a true
		boolean juegoTerminado = false;
		
		//Indica si el tiro es correcto
		boolean tiroCorrecto = false;
		
		//Posición tirada
		int[] tiro = new int[2];
		
		//Inicialización de mapas y colocar los barcos
		inicializacion(mapaUsuario,mapaOrdenador);
		//Mapa de tiradas. Inicializamos a AGUA_NO_TOCADO
		inicializaMapaRegistro(mapaOrdenadorParaUsuario);
		
		while (!juegoTerminado) {
			
			//Mostramos mapa usuario
			System.out.println("Mapa Usuario");
			imprimirMapa(mapaUsuario);
			
			System.out.printf("PUNTOS RESTANTES DEL JUGADOR: %d\n",puntosUsuario);
			System.out.println("TURNO DEL JUGADOR");
			
			// Tirada de usuario
			tiroCorrecto = false;
			while (!tiroCorrecto) {
				// Solicitamos datos del tiro por teclado
				tiro = pedirCasilla();
				
				// Verificar si el tiro es correcto
				if (tiro[0] != -1 && tiro[1] != -1) {
					tiroCorrecto = evaluarTiro(mapaOrdenador,tiro);
					if (!tiroCorrecto) 
						System.out.println("TIRO INCORRECTO");
				}else {
					System.out.println("TIRO INCORRECTO");
				}
				
			}
			
			//Actualizamos mapa de ordenador y puntos
			int puntosOrdenadorAnterior = puntosOrdenador;
			puntosOrdenador = actualizarMapa(mapaOrdenador, tiro, puntosOrdenador);
			
			// Si el número de puntos es > 0 es tocado sino es agua
			char tipoTiro = (puntosOrdenadorAnterior - puntosOrdenador) > 0 ? TOCADO : AGUA; 
			actualizarMapaRegistro(mapaOrdenadorParaUsuario,tiro, tipoTiro);
			System.out.println("\nREGISTRO DEL MAPA DEL ORDENADOR");
			imprimirMapa(mapaOrdenadorParaUsuario);
			
			//El juego termina si el número de puntos llega a 0
			juegoTerminado = (puntosOrdenador == 0);
			
			
			//Si no ha ganado el jugador, le toca a la máquina
			if (!juegoTerminado) {
				
				System.out.printf("PUNTOS RESTANTES DEL ORDENADOR: %d\n\n", puntosOrdenador);
				System.out.println("TURNO DEL ORDENADOR");
				tiroCorrecto = false;
				//Seguimos los mismos parámetros de comprobación que en la tirada del usuario
				while (!tiroCorrecto) {
					tiro = generaDisparoAleatorio();
					tiroCorrecto = evaluarTiro(mapaUsuario, tiro);
				}
			}
			//Actualizamos mapa
			puntosUsuario = actualizarMapa(mapaUsuario, tiro, puntosUsuario);
			//El juego termina si el número de puntos llega a 0			
			juegoTerminado = (puntosUsuario == 0);

			} //FIN DE LA PARTIDA. Alguien ha ganado
					
			if (puntosOrdenador == 0) {
				System.out.println("EL VENCEDOR HA SIDO EL JUGADOR");
			} else 
				System.out.println("EL VENCEDOR HA SIDO EL ORDENADOR");
	
			sc.close();
			
			
		}
		
		
	}


