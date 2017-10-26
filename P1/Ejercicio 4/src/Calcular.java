
public class Calcular implements Filtro {
	private static double INTERVALO = 0.65;
	private static double PI = 3.14;
	@Override
	public double ejecutar(Object o) {
		double distancia = (double) o;
		double velocidad =  (distancia/60) * (PI * INTERVALO); 
		
		return velocidad;
	}

}
