package subsistemaDeMonitorizacion;

import java.text.DecimalFormat;
import javax.swing.JLabel;

public class ObservadorVelocidad implements IObserver {
	private Observable observable;
	private JLabel velocidad_actual;
	
	public ObservadorVelocidad(Observable observable, JLabel velocidad_actual){
		this.observable = observable;
		this.observable.addObserver(this);
		this.velocidad_actual = velocidad_actual;
	}
	
	@Override
	public void update(){
		DecimalFormat formateador = new DecimalFormat("########");
		velocidad_actual.setText(formateador.format(observable.getCoche().getVelocidad()) + " Km/h");
	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		ObservadorVelocidad aux;
		
		if(obj instanceof ObservadorVelocidad){
			aux = (ObservadorVelocidad) obj;
			if((this.observable.equals(aux.observable))
				&& (this.velocidad_actual.equals(aux.velocidad_actual)))
						result = true;
		}
		return result;
	}
}
