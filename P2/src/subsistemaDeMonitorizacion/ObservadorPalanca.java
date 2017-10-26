package subsistemaDeMonitorizacion;

import javax.swing.JLabel;
import subsistemaDeControl.EEstadoPalanca;

public class ObservadorPalanca implements IObserver {
	private Observable observable;
	private JLabel estado_palanca;
	
	public ObservadorPalanca(Observable observable, JLabel estado_palanca){
		this.observable = observable;
		this.observable.addObserver(this);
		this.estado_palanca = estado_palanca;
	}
	
	@Override
	public void update(){
		String Mensaje = "SIN VALOR";
		
		EEstadoPalanca estado = observable.getCoche().getPalanca().getEstado(); 
		
		if(estado == EEstadoPalanca.ACELERANDO){
			Mensaje = "ACELERAR";
		}else if (estado == EEstadoPalanca.APAGADO){
			Mensaje = "PARAR";
		}else if (estado == EEstadoPalanca.AUTOMATICO){
			Mensaje = "MANTENER";
		}else if (estado == EEstadoPalanca.REINICIAR){
			Mensaje = "REINICIAR";
		}
		this.estado_palanca.setText(Mensaje);
	}	
	
	@Override
	public boolean equals(Object obj){
		boolean result = false;
		ObservadorPalanca aux;
		
		if(obj instanceof ObservadorPalanca){
			aux = (ObservadorPalanca) obj;
		
			if((this.observable.equals(aux.observable))
				&& (this.estado_palanca.equals(aux.estado_palanca)))
						result = true;
		}
		return result;
	}
}

