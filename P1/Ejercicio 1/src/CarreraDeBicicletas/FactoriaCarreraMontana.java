package CarreraDeBicicletas;

import java.util.ArrayList;

	public class FactoriaCarreraMontana {
		protected ArrayList<Bicicleta> prueba = new ArrayList<Bicicleta>();
		
	public ArrayList<Bicicleta> CrearCarrera(int nCorredores){
			for (int i = 0; i < nCorredores; i++){
				prueba.add(new Bicicleta(i,TC.MONTANA));
			}
			return prueba;
	}
}
