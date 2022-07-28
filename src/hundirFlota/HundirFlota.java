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
		
		
		
		
	}

}
