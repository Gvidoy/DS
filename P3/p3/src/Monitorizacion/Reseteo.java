package Monitorizacion;
import ControlVelocidad.Eje;
public class Reseteo {
		protected void inicializarValores(CalculadorVelMed velMed, Eje eje) {
		eje.resetear();
		velMed.resetearTiempo();
	}

//Sobreescribir el metodo equals
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
		
		if(obj instanceof Reseteo){
				result = true;
		}
		return result;
	}
		
}