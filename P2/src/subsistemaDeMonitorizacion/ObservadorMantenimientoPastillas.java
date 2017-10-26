package subsistemaDeMonitorizacion;

import java.awt.Color;
import javax.swing.JProgressBar;
import subsistemaDeControl.ETiposNiveles;

public class ObservadorMantenimientoPastillas implements IObserver {
	private Observable observable;
	private JProgressBar barraPastillas;
	private boolean alerta;
	
	public ObservadorMantenimientoPastillas(Observable observable, JProgressBar barraPastillas){
		this.observable = observable;
		this.observable.addObserver(this);
		this.alerta = false;
		
		this.barraPastillas = barraPastillas;
	}
	
	@Override
	public void update(){
		double totalRotaciones = observable.getCoche().getMotor().getRotacionTotalMotor();
		double ultimoCambio = observable.getCoche().getNivel(ETiposNiveles.PASTILLAS).getRotacion();
		
		double valor = totalRotaciones - ultimoCambio;
		
		double maximo= observable.getCoche().getNivel(ETiposNiveles.PASTILLAS).getMAX();
		double porcentaje = porcentaje(valor,maximo);
		
		if (alerta == true && porcentaje < 100){
			barraPastillas.setBackground(null);
			barraPastillas.setStringPainted(false);
			alerta = false;
		}
		
		if (!alerta){
			barraPastillas.setValue(100-(int)porcentaje);
		}
		
		if( porcentaje > 100 && !alerta){
			barraPastillas.setBackground(new Color(255,100,100));
			barraPastillas.setStringPainted(true);
			alerta = true;
		} 
	}
	
	public double porcentaje(double valor, double maximo){
		double porcentaje = 0;
		
		porcentaje = (valor / maximo) * 100 ;
		
		return porcentaje;
	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		ObservadorMantenimientoPastillas aux;
		
		if(obj instanceof ObservadorMantenimientoPastillas){
			aux = (ObservadorMantenimientoPastillas) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.barraPastillas.equals(aux.barraPastillas))
				&& (this.alerta == aux.alerta))
						result = true;
		}
		return result;
	}
	
}

