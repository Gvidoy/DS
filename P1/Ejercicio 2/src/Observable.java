import java.util.ArrayList;

public abstract class Observable {
	//Array de Observadores
	protected ArrayList<Observador> observadores;
	
	Observable(){
		observadores = new ArrayList<Observador>();
	}
	//Añadir Observadores
	public void incluisObservador(Observador unObservador){
		observadores.add(unObservador);
	}
	//Notificar al observador
	public abstract void notificarObservador(int dato);
}
