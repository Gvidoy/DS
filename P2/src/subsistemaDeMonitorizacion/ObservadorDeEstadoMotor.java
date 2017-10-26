package subsistemaDeMonitorizacion;
import javax.swing.JLabel;

public class ObservadorDeEstadoMotor implements IObserver {
	private  Observable observable;
	private JLabel estado_motor;
	
	public ObservadorDeEstadoMotor(Observable observable, JLabel estado_motor){
		this.observable = observable;
		this.observable.addObserver(this);
		
		this.estado_motor = estado_motor;
	}
	
	@Override
	public void update(){
		this.estado_motor.setText(observable.getCoche().getMotor().getEstadoToString());
	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		ObservadorDeEstadoMotor aux;
		
		if(obj instanceof ObservadorDeEstadoMotor){
			aux = (ObservadorDeEstadoMotor) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.estado_motor.equals(aux.estado_motor)))
						result = true;
		}
		return result;
	}
}


