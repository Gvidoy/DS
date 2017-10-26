
public abstract class VisitanteEquipo {
	protected String Nombre;
	
	abstract public void visitar (Equipo UnEquipo);
	abstract public double costeTotal();
	
	public String getNombreVisitante(){
		return Nombre;
	}
	
}
