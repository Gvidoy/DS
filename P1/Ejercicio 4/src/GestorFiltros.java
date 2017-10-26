
public class GestorFiltros {
	private CadenaFiltros unaCadenaDeFiltros;
	
	public GestorFiltros(Interfaz o){
		this.unaCadenaDeFiltros = new CadenaFiltros();
		this.unaCadenaDeFiltros.setObjetivo(o);

	}
	public void setFiltro(Filtro f){
		this.unaCadenaDeFiltros.addFiltro(f);
	}
	public void peticionfiltro(double p){
		this.unaCadenaDeFiltros.ejecutar(p);
	}
}
