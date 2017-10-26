package subsistemaDeMonitorizacion;
import java.awt.Color;

import javax.swing.JProgressBar;

import subsistemaDeControl.ETiposNiveles;

//import subsistemaDeControl.coche;
public class ObservadorMantenimientoAceite implements IObserver {
	private Observable observable;
	private JProgressBar estado_aceite;
	private boolean alerta;
	
	public ObservadorMantenimientoAceite(Observable observable, JProgressBar estado_aceite){
		this.observable = observable;
		this.observable.addObserver(this);
		this.alerta = false;
		
		this.estado_aceite = estado_aceite;
	}
	
	@Override
	public void update(){
		double totalRotaciones = observable.getCoche().getMotor().getRotacionTotalMotor();
		double ultimoCambio = observable.getCoche().getNivel(ETiposNiveles.ACEITE).getRotacion();
		
		double valor = totalRotaciones - ultimoCambio;
		
		double maximo= observable.getCoche().getNivel(ETiposNiveles.ACEITE).getMAX();
		double porcentaje = porcentaje(valor,maximo);
		
		if (alerta == true && porcentaje < 100){
			estado_aceite.setBackground(null);
			estado_aceite.setStringPainted(false);
			alerta = false;
		}
		
		if (!alerta){
			estado_aceite.setValue(100-(int)porcentaje);
		}
		
		if( porcentaje > 100 && !alerta){
			estado_aceite.setBackground(new Color(255,100,100));
			estado_aceite.setStringPainted(true);
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
		ObservadorMantenimientoAceite aux;
		
		if(obj instanceof ObservadorMantenimientoAceite){
			aux = (ObservadorMantenimientoAceite) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.estado_aceite.equals(aux.estado_aceite))
				&& (this.alerta == aux.alerta))
						result = true;
		}
		return result;
	}
}

