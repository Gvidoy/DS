package ControlVelocidad;
public class Motor {
	private boolean _estado;
	public Motor() {
		_estado = false;
	}
	public boolean leerEstado() {
		return _estado;
	}
	public void cambiarEstado() {
		if(_estado == false){
			_estado = true;
		}
		else{
			_estado = false;
		}
	}
	
	//Redefinicion del metodo equals
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
		Motor aux;
		
		if(obj instanceof Motor){
			aux = (Motor) obj;
		
			if(this._estado == aux._estado)
						result = true;
		}
		return result;
	}
	
}