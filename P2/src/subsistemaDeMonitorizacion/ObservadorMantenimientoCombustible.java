package subsistemaDeMonitorizacion;

import java.awt.Color;
import javax.swing.JProgressBar;
import subsistemaDeControl.EEstadoPalanca;
import subsistemaDeControl.ETiposNiveles;

public class ObservadorMantenimientoCombustible implements IObserver {
	private Observable observable;
	private JProgressBar barraCombustible;
	private boolean alerta;
	
	public ObservadorMantenimientoCombustible(Observable observable, JProgressBar barraCombustible){
		this.observable = observable;
		this.observable.addObserver(this);
		this.alerta = false;
		this.barraCombustible = barraCombustible;
	}
	
	@Override
	public void update(){
		double totalRotaciones = observable.getCoche().getMotor().getRotacionTotalMotor();
		double ultimoCambio = observable.getCoche().getNivel(ETiposNiveles.COMBUSTIBLE).getRotacion();
		
		double valor = totalRotaciones - ultimoCambio;
		
		double maximo= observable.getCoche().getNivel(ETiposNiveles.COMBUSTIBLE).getMAX();
		double porcentaje = porcentaje(valor,maximo);
		
		if (alerta == true && porcentaje < 100){
			barraCombustible.setBackground(null);
			barraCombustible.setStringPainted(false);
			alerta = false;
		}
		
		if (!alerta){
			barraCombustible.setValue(100-(int)porcentaje);
		}
		
		if( porcentaje > 100 && !alerta){
			barraCombustible.setBackground(new Color(255,100,100));
			barraCombustible.setStringPainted(true);
			alerta = true;
			
			observable.getCoche().getPalanca().setEstado(EEstadoPalanca.APAGADO);
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
		ObservadorMantenimientoCombustible aux;
		
		if(obj instanceof ObservadorMantenimientoCombustible){
			aux = (ObservadorMantenimientoCombustible) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.barraCombustible.equals(aux.barraCombustible))
				&& (this.alerta == aux.alerta))
						result = true;
		}
		return result;
	}
}

