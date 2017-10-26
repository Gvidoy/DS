package subsistemaDeMonitorizacion;
import simuladorVelocidad.SimuladorVelocidad;;

public class ObservadorAceleracion implements IObserver {
	private Observable observable;
	private SimuladorVelocidad simulador;
	
	
	public ObservadorAceleracion(Observable observable, SimuladorVelocidad simulador){
		this.observable = observable;
		this.observable.addObserver(this);
		this.simulador = simulador;
		
	}
	
	@Override
	public void update(){
		simulador.setAceleracion(observable.getCoche().getAceleracion());
		observable.getCoche().setVelocidad(simulador.getVelocidad());
		
		if(observable.getCoche().getAcelerador().getEstado() == true){
			observable.getCoche().acelerar();
		}else{
			observable.getCoche().desacelerar();
		}
	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		ObservadorAceleracion aux;
		
		if(obj instanceof ObservadorAceleracion){
			aux = (ObservadorAceleracion) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.simulador.equals(aux.simulador)))
						result = true;
		}
		return result;
	}
}

