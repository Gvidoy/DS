package ControlVelocidad;
public class Acelerador {
	private boolean _estado;
	private final int aceleracion=300;
	public static final int ROZAMIENTO=100;
	public Acelerador() {
		_estado = false;
	}
	public void incrementar(int aceleracion, Eje eje) {	
		eje.incrementarVueltas(aceleracion);
	}
	public double actualizarAcelerador(double velAnterior) {
		return (aceleracion - (ROZAMIENTO*0.015*velAnterior));
	}
	public void soltarAcelerador() {
		_estado = false;
	}
	public boolean leerEstado() {
		return _estado;
	}
	public void pisarAcelerador() {
		_estado = true;
	}
	
	//Metodo equal sobreescrito
	
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
		
		if(obj instanceof Acelerador){
			Acelerador aux = (Acelerador) obj;
			if(this._estado == aux._estado){
				if(this.aceleracion == aux.aceleracion){
					if(this.ROZAMIENTO == aux.ROZAMIENTO){
						result = true;
					}
				}
			}
		}
		return result;
	}
	
	
}