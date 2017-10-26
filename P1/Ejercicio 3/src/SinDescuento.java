
public class SinDescuento extends VisitanteEquipo {
	private double CosteTotal;
	
	public SinDescuento (){
		Nombre = "SinDescuento";
		CosteTotal = 0;
	}
	
	@Override
	public void visitar(Equipo UnEquipo) {
		CosteTotal = CosteTotal + UnEquipo.precioNeto();
	}
	public double costeTotal(){
		return CosteTotal;
	}

}
