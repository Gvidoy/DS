
public class Vip extends VisitanteEquipo {

	private double Descuento;
	private double CosteTotal;
	
	public Vip (){
		Nombre = "VIP";
		Descuento = 10;
		CosteTotal = 0;
	}
	
	@Override
	public void visitar(Equipo UnEquipo) {

		CosteTotal = CosteTotal + UnEquipo.precioNeto();
	}
	@Override
	public double costeTotal(){
		return CosteTotal - ((CosteTotal * Descuento) / 100);
	}

}
