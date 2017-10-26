import java.util.ArrayList;

public class CadenaFiltros {
	private ArrayList<Filtro> filtros;
	private Interfaz objetivo;
	
	public CadenaFiltros(){
		this.filtros = new ArrayList<Filtro>();
		this.objetivo = null;
	}
	public void addFiltro(Filtro filtro){
		filtros.add(filtro);
	}
	public void ejecutar(double peticion){
		for(Filtro filtro : filtros){
			System.out.println("Nueva velocidad (m/s) "+filtro.
					ejecutar(peticion));
		}
		objetivo.ejecutar(peticion);
	}
	public void setObjetivo(Interfaz objetivo){
		this.objetivo = objetivo;
	}
}