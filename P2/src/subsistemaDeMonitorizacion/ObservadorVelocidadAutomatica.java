package subsistemaDeMonitorizacion;

import java.text.DecimalFormat;
import javax.swing.JLabel;
import controlDeCrucero.VelocidadAutomatica;
import subsistemaDeControl.EEstadoPalanca;

public class ObservadorVelocidadAutomatica implements IObserver {
	private Observable observable;
	private JLabel velocidad_crucero;
	VelocidadAutomatica controlDeVelocidad;

	
	public ObservadorVelocidadAutomatica(Observable observable, JLabel velocidad_crucero, VelocidadAutomatica controlDeVelocidad){
		this.observable = observable;
		this.observable.addObserver(this);
		this.velocidad_crucero = velocidad_crucero;
		this.controlDeVelocidad = controlDeVelocidad;
		
	}
	
	@Override
	public void update(){
		DecimalFormat formateador = new DecimalFormat("########.#");
		this.velocidad_crucero.setText(formateador.format(observable.getCoche().getVelocidadAutomatica()) + " Km/h");
		if(observable.getCoche().getPalanca().getEstado() == EEstadoPalanca.AUTOMATICO || observable.getCoche().getPalanca().getEstado() == EEstadoPalanca.REINICIAR){
			controlDeVelocidad.automatica(observable.getCoche().getVelocidad());
			if (controlDeVelocidad.getEstadoFrenoAuto() == true){
				observable.getCoche().frenoAutomatico();
			}
			observable.getCoche().getAcelerador().setEstado(controlDeVelocidad.getEstadoAceleradorAuto());
			
		}	
	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		ObservadorVelocidadAutomatica aux;
		
		if(obj instanceof ObservadorVelocidadAutomatica){
			aux = (ObservadorVelocidadAutomatica) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.velocidad_crucero.equals(aux.velocidad_crucero))
				&& (this.controlDeVelocidad.equals(aux.controlDeVelocidad)))
						result = true;
		}
		return result;
	}
}

