package subsistemaDeMonitorizacion;

import java.awt.Color;
import javax.swing.JProgressBar;
import subsistemaDeControl.ETiposNiveles;

public class ObservadorMantenimientoGeneral implements IObserver {


	private Observable observable;
	private JProgressBar barraRevision;
	private boolean alerta;
	
	public ObservadorMantenimientoGeneral(Observable observable, JProgressBar barraRevision){
		this.observable = observable;
		this.observable.addObserver(this);
		this.alerta = false;
		
		this.barraRevision = barraRevision;
	}
	
	@Override
	public void update(){
		double totalRotaciones = observable.getCoche().getMotor().getRotacionTotalMotor();
		double ultimoCambio = observable.getCoche().getNivel(ETiposNiveles.GENERAL).getRotacion();
		
		double valor = totalRotaciones - ultimoCambio;
		
		double maximo= observable.getCoche().getNivel(ETiposNiveles.GENERAL).getMAX();
		double porcentaje = porcentaje(valor,maximo);
		
		if (alerta == true && porcentaje < 100){
			barraRevision.setBackground(null);
			barraRevision.setStringPainted(false);
			alerta = false;
		}
		
		if (!alerta){
			barraRevision.setValue(100-(int)porcentaje);
		}
		
		if( porcentaje > 100 && !alerta){
			barraRevision.setBackground(new Color(255,100,100));
			barraRevision.setStringPainted(true);
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
		ObservadorMantenimientoGeneral aux;
		
		if(obj instanceof ObservadorMantenimientoGeneral){
			aux = (ObservadorMantenimientoGeneral) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.barraRevision.equals(aux.barraRevision))
				&& (this.alerta == aux.alerta))
						result = true;
		}
		return result;
	}
}

