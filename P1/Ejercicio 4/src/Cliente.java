
public class Cliente {
	private GestorFiltros unGestor;
	
	public  Cliente(){
	}
	public void setGestorFiltros(GestorFiltros g){
		this.unGestor = g;
	}
	public void sentPeticion(double p){
		this.unGestor.peticionfiltro(p);
	}
		
}
