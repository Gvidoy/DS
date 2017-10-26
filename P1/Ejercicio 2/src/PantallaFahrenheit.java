
public class PantallaFahrenheit implements Observador {
	//Pantalla Grados Fahrenheit

	private int dato;
	
	public void manejarEvento(int dato){
		this.dato = dato;	
		this.refrescarPantalla();
	}

	public void refrescarPantalla(){
		System.out.println("Pantalla Fahrenheit: La temperatura es " + (dato + 32) + " Fahrenheit");
	}

}
