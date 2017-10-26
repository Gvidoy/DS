public class PantallaKelvin implements Observador {
	//Pantalla Grados Kelvin

	
	private double dato;
	
	public void manejarEvento(int dato){
		this.dato = dato;	
		this.refrescarPantalla();
	}

	public void refrescarPantalla(){
		System.out.println("Pantalla Kelvin: La temperatura es " + (double)(dato + 273.15) + " Kelvin");
	}

}
