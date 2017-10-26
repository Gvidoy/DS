package ControlVelocidad;
public class Freno {
	private boolean _estado;
	private final int desaceleracion=700;
	public static final int ROZAMIENTO=100;
	public Freno() {
		_estado = false;
	}
	public void decremento(int desaceleracion, Eje eje) {	
		eje.incrementarVueltas(-desaceleracion);
	}
	public int actualizarFreno() {
		return desaceleracion + ROZAMIENTO;
	}
	public void soltarFreno() {
		_estado = false;
	}
	public void presionarFreno() {
		_estado = true; 
	}
	public boolean leerEstado() {
		return _estado;
	}
	
	//Metodo equal sobreescrito
	
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
		
		if(obj instanceof Freno){
			Freno aux = (Freno) obj;
			if(this._estado == aux._estado){
				if(this.desaceleracion == aux.desaceleracion){
					if(this.ROZAMIENTO == aux.ROZAMIENTO){
						result = true;
					}
				}
			}
		}
		return result;
	}
}