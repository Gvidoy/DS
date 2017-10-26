
public class ObservablePantalla extends Observable{
	
	public ObservablePantalla(){
		super();
	}
	
	public void notificarObservador(int dato){
		for(Observador T:observadores){
			T.manejarEvento(dato);
		}
	}
}
