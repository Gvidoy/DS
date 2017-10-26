package subsistemaDeMonitorizacion;

import java.text.DecimalFormat;
import javax.swing.JLabel;

public class ObservadorVelocidadMedia implements IObserver {
	private Observable observable;
	private JLabel velocidad_media;
	
	public ObservadorVelocidadMedia(Observable observable, JLabel velocidad_media){
		this.observable = observable;
		this.observable.addObserver(this);
		this.velocidad_media = velocidad_media;
	}
	
	@Override
	public void update(){
		DecimalFormat formateador = new DecimalFormat("########.#");
		velocidad_media.setText(formateador.format(observable.getCoche().getVelocidadMedia()) + " Km/h");

	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		ObservadorVelocidadMedia aux;
		
		if(obj instanceof ObservadorVelocidadMedia){
			aux = (ObservadorVelocidadMedia) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.velocidad_media.equals(aux.velocidad_media)))
						result = true;
		}
		return result;
	}
}
