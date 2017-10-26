package subsistemaDeMonitorizacion;

import java.text.DecimalFormat;
import javax.swing.JLabel;
public class ObservadorDeRevoluciones implements IObserver {
	private Observable observable;
	private JLabel revoluciones_actuales;
	
	public ObservadorDeRevoluciones(Observable observable, JLabel revoluciones_actuales){
		this.observable = observable;
		this.observable.addObserver(this);
		this.revoluciones_actuales = revoluciones_actuales;
	}
	
	@Override
	public void update(){
		DecimalFormat formateador = new DecimalFormat("########");
		
		revoluciones_actuales.setText(formateador.format(observable.getCoche().getRevoluciones()) + " RPM");
	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		ObservadorDeRevoluciones aux;
		
		if(obj instanceof ObservadorDeRevoluciones){
			aux = (ObservadorDeRevoluciones) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.observable.equals(aux.observable))
				&& (this.revoluciones_actuales.equals(aux.revoluciones_actuales)))
						result = true;
		}
		return result;
	}
}
