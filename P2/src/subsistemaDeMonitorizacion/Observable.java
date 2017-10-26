package subsistemaDeMonitorizacion;
import subsistemaDeControl.Coche;


import java.util.ArrayList;
//import coche.coche;
import java.util.logging.Logger;

public class Observable implements IObservable, Runnable{
	private ArrayList<IObserver> observers;
	private Thread hiloDeEjecucion;
	
	private Coche coche;

	public Observable(Coche uncoche){
		this.observers = new ArrayList<IObserver>();
		this.coche = uncoche;
		
		
	}
	public Coche getCoche(){
		return coche;
	}
	
	@Override
	public void addObserver(IObserver observer) {
		observers.add(observer);
		
	}
	@Override
	public void removeObserver(IObserver observer) {
		observers.remove(observer);
		
	}
	
	private void notificar(){

		for(IObserver t : observers){
			t.update();
		}
	}
	
	public void start(){
		hiloDeEjecucion = new Thread(this);
		hiloDeEjecucion.start();
	}
	
	public void run(){
		synchronized (this){
			while(true){
				try{
					this.wait(10);
					if(coche.getMotor().getEstado() == true){
						notificar();
					}
				}catch (InterruptedException ex){
					Logger.getLogger("Se produjo una excepción en la ejecucion");
				}
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		Observable aux;
		
		if(obj instanceof Observable){
			aux = (Observable) obj;
			if(this.coche.equals(aux.coche)){
				if(this.observers.equals(aux.observers)){	
					result = true;
				}
			}
		}
		return result;
	}
}
