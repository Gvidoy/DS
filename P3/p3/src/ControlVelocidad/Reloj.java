package ControlVelocidad;
public class Reloj extends Thread {
	private final int INTERVALO = 250;
	private ControlVelocidad control;
	public Reloj(ControlVelocidad ControlVelocidad_c) {
		this.control = ControlVelocidad_c;
	}
	public void run() {
		while(true){
			try{ 
				sleep(INTERVALO);
			}catch(java.lang.InterruptedException e){e.printStackTrace();}	
			control.controlarEstado();
		}
	}
	
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
	
		if(obj instanceof Reloj){
			Reloj aux = (Reloj) obj;
		
			if(this.getState().equals(aux.getState()))
				result = true;
		}
		return result;
	}
	
}