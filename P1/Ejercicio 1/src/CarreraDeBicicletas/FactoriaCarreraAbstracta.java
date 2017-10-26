package CarreraDeBicicletas;

import java.util.ArrayList;

public class FactoriaCarreraAbstracta implements Carrera{


	public ArrayList<Bicicleta> CrearCarrera (TC tipo, int nCorredores){
		if(tipo == TC.CARRETERA){
			return new FactoriaCarreraCarretera().CrearCarrera(nCorredores);
		
		} else if(tipo == TC.MONTANA){
			return new FactoriaCarreraMontana().CrearCarrera(nCorredores);

		}else{
			return null;
		}
	}


}