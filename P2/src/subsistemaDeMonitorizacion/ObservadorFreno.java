package subsistemaDeMonitorizacion;
import javax.swing.JLabel;

public class ObservadorFreno implements IObserver {
	private Observable observable;
	private JLabel estado_freno;
	
	public ObservadorFreno(Observable observable, JLabel estado_freno){
		this.observable = observable;
		this.observable.addObserver(this);
		this.estado_freno = estado_freno;
	}
	@Override
	public void update(){
		this.estado_freno.setText(observable.getCoche().getFreno().getEstadoToString());
		
		if(observable.getCoche().getFreno().getEstado() == true){
			observable.getCoche().frenar();
		}
	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		ObservadorFreno aux;
		
		if(obj instanceof ObservadorFreno){
			aux = (ObservadorFreno) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.estado_freno.equals(aux.estado_freno)))
						result = true;
		}
		return result;
	}
}

