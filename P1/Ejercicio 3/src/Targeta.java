
public class Targeta extends Equipo{

	private double potencia;
	private double precioNeto;
	private double descuento;
	
	public Targeta(String nombre, double potencia, double precioNeto, double descuento) {
		super(nombre);
		this.potencia = potencia;
		this.precioNeto = precioNeto;
		this.descuento = descuento;
	}
	@Override
	public double potencia() {
		return potencia;
	}

	@Override
	public double precioNeto() {
		return precioNeto;
	}

	@Override
	public double precioConDescuento() {
		return descuento;
	}

	@Override
	public void aceptar(VisitanteEquipo ve) {
		ve.visitar(this);
	}

}
