public class PantallaCelsius implements Observador {
	//Pantalla Grados Celsius
	private int dato;
	
	public void manejarEvento(int dato){
		this.dato = dato;	
		this.refrescarPantalla();
	}

	public void refrescarPantalla(){
		System.out.println("Pantalla Clesius: La temperatura es " + (dato) + " Celsius");
	}

}
