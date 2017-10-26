
public class Demostracion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorFiltros gestorFiltros = new GestorFiltros(new Interfaz());
		gestorFiltros.setFiltro(new Calcular());
		Cliente cliente = new Cliente();
		cliente.setGestorFiltros(gestorFiltros);
		cliente.sentPeticion(500.000);//numero inicial de vueltasdel eje
		
	}

}
