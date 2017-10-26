package subsistemaDeMonitorizacion;
import javax.swing.JLabel;

public class ObservadorTiempoTotal implements IObserver {private Observable observable;
	private JLabel tiempo_en_marcha;
	
	public ObservadorTiempoTotal(Observable observable, JLabel tiempo_en_marcha){
		this.observable = observable;
		this.observable.addObserver(this);
		this.tiempo_en_marcha = tiempo_en_marcha;
	}
	
	@Override
	public void update(){
		this.tiempo_en_marcha.setText(Long.toString(observable.getCoche().calcularTiempo()) + " s");
	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		ObservadorTiempoTotal aux;
		
		if(obj instanceof ObservadorTiempoTotal){
			aux = (ObservadorTiempoTotal) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.tiempo_en_marcha.equals(aux.tiempo_en_marcha)))
						result = true;
		}
		return result;
	}
}

