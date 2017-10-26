package subsistemaDeMonitorizacion;

import java.text.DecimalFormat;
import javax.swing.JLabel;

public class ObservadorRotacionesTotales implements IObserver {
	private Observable observable;
	private JLabel rotaciones_totales;
	
	public ObservadorRotacionesTotales(Observable observable, JLabel rotaciones_totales){
		this.observable = observable;
		this.observable.addObserver(this);
		this.rotaciones_totales = rotaciones_totales;
	}
	
	@Override
	public void update(){
		DecimalFormat formateador = new DecimalFormat("########.##");
		observable.getCoche().calcularDistancia();
		rotaciones_totales.setText(formateador.format((observable.getCoche().getMotor().getRotacionTotalMotor())) + " Km" );		
	}
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		ObservadorRotacionesTotales aux;
		
		if(obj instanceof ObservadorRotacionesTotales){
			aux = (ObservadorRotacionesTotales) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.rotaciones_totales.equals(aux.rotaciones_totales)))
						result = true;
		}
		return result;
	}
}
