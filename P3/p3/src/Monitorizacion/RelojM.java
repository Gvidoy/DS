package Monitorizacion;

import ControlVelocidad.Reloj;

public class RelojM extends Thread{
	private final int INTERVALO = 250;
	private  Monitorizacion monitor;
	public RelojM(Monitorizacion Monitorizacion_m) {
		this.monitor = Monitorizacion_m;		
	}
	public void run() {
		while(true){
			try{ 
				sleep(INTERVALO);
			}catch(java.lang.InterruptedException e){e.printStackTrace();}
			
			monitor.notificaciones();
		}
	}
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
	
		if(obj instanceof RelojM){
			RelojM aux = (RelojM) obj;
		
			if(this.getState().equals(aux.getState()))
				result = true;
		}
		return result;
	}
}