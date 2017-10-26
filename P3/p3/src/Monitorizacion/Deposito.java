package Monitorizacion;

import ControlVelocidad.Eje;
public final class Deposito {
	private double _nivelActual;
	private final double NIVEL_INICIAL = 100;
	private final double RATIO_CONUSMO = 0.0000000005;
	protected Deposito() {
		_nivelActual = NIVEL_INICIAL;
	}
	protected double leerNivelActual() {
		return _nivelActual;
	}
	protected double leerNivelInicial() {
		return NIVEL_INICIAL;
	}
	protected void actualizarDeposito(Eje Eje_e) {
		int rev = Eje_e.leerRevoluciones();
		_nivelActual -= (rev*(rev/15))*RATIO_CONUSMO;
		if(_nivelActual <= 0){
			_nivelActual = 0;
		}
	}
	protected void cambiarANivelInicial() {
		_nivelActual = NIVEL_INICIAL;
	}
	
	//Metodos para pruebas junit
	public void set_nivelactual(double nivel){
		this._nivelActual = nivel;
	}
	
	public double getRATIO_CONUSMO() {
		return RATIO_CONUSMO;
	}
	//Sobreecribir el emtodo equals
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
		
		if(obj instanceof Deposito){
			Deposito aux = (Deposito) obj;
		
			if(this._nivelActual == aux._nivelActual)
						result = true;
		}
		return result;
	}
	

	
	
}




