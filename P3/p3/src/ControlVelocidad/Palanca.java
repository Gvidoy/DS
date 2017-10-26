package ControlVelocidad;
public class Palanca {
	private int estado;
	public static final int APAGADO = 0;
	public static final int REINICIANDO = 1;
	public static final int MANTENIENDO = 2;
	public Palanca() {
		estado = 0;
	}
	public void cambiarEstado(int aInt_p) {
		estado = aInt_p;
	}
	public int leerEstado() {
		return estado;
	}
	
	//Sobrescribir metoro qeuals
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
		
		if(obj instanceof Palanca){
			Palanca aux;
			aux = (Palanca) obj;
		
			if(this.estado == aux.estado)
						result = true;
		}
		return result;
	}
	
}