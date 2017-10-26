
public abstract class Equipo {

	  private String nombre;

	  public Equipo(String nombre){

	    this.nombre= nombre; 

	  }

	  public String nombre(){

	    return nombre;

	  }

	  abstract public double potencia();

	  abstract public double precioNeto();

	  abstract public double precioConDescuento();

	  abstract public void aceptar(VisitanteEquipo ve);
	
}
