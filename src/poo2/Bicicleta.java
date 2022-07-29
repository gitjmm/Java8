package poo2;

public class Bicicleta {
	private int numMarchas;
	private int velocidad;
	private int id;
	
	public static int numBicicletas = 0;

	public Bicicleta(int numMarchas, int velocidad, int id) {
		super();
		this.numMarchas = numMarchas;
		this.velocidad = velocidad;
		this.id = id;
		numBicicletas++;
	}

	/**
	 * @return the numMarchas
	 */
	public int getNumMarchas() {
		return numMarchas;
	}

	/**
	 * @param numMarchas the numMarchas to set
	 */
	public void setNumMarchas(int numMarchas) {
		this.numMarchas = numMarchas;
	}

	/**
	 * @return the velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}

	/**
	 * @param velocidad the velocidad to set
	 */
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the numBicicletas
	 */
	public static int getNumBicicletas() {
		return numBicicletas;
	}

	/**
	 * @param numBicicletas the numBicicletas to set
	 */
	public static void setNumBicicletas(int numBicicletas) {
		Bicicleta.numBicicletas = numBicicletas;
	}

	@Override
	public String toString() {
		return "Bicicleta [numMarchas=" + numMarchas + ", velocidad=" + velocidad + ", id=" + id + "]";
	}
	
	
	
	
}
