
public class Mayorista extends VisitanteEquipo {

	private double Descuento;
	private double CosteTotal;
	
	public Mayorista (){
		Nombre = "MAYORISTA";
		Descuento = 15;
		CosteTotal = 0;
	}
	
	@Override
	public void visitar(Equipo UnEquipo) {
		CosteTotal = CosteTotal + UnEquipo.precioNeto();
	}
	public double costeTotal(){
		return CosteTotal - ((CosteTotal * Descuento) / 100);
	}

}
