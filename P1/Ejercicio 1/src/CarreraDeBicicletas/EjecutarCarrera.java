package CarreraDeBicicletas;

import java.util.ArrayList;
import java.util.Random;

public class EjecutarCarrera extends Thread {
	private ArrayList<Bicicleta> prueba = new ArrayList<Bicicleta>();

	public EjecutarCarrera(ArrayList<Bicicleta> unaCarrera){
		prueba = unaCarrera;
	}
	
	@Override
	public void run(){
		Random rnd = new Random();
		int eliminado = rnd.nextInt() % prueba.size();
		int neliminadosCarretera = 0;
		int neliminadosMontana = 0;
		
		//Cuento cuantos eliminaremos en funcion de el tipo de prueba que sea
		if(prueba.get(0).tipo() == TC.CARRETERA){
			if(prueba.size() < 10){
				neliminadosCarretera = 1;
			}else{
				neliminadosCarretera = (prueba.size() * 10)/100;
			}
			System.out.println("Eliminaremos el 10% de la carrera de Carretera a " + neliminadosCarretera + " De " + prueba.size());

		}else if(prueba.get(0).tipo() == TC.MONTANA){
			if(prueba.size() < 5){
				neliminadosMontana = 1;
			}else{
				neliminadosMontana = (prueba.size() * 20 )/ 100;
			}
			System.out.println("Eliminaremos el 20% de la carrera de Montaña a " + neliminadosMontana + " De " + prueba.size());
		}
		
		//Procedemos a eliminar los descalificados
		
		while(neliminadosMontana > 0){
			eliminado = rnd.nextInt(prueba.size());

			prueba.remove(eliminado);

			neliminadosMontana--;
		}
		
		while(neliminadosCarretera >0){
			eliminado = rnd.nextInt(prueba.size());
			prueba.remove(eliminado);
			neliminadosCarretera--;
		}
		
	}
	public void mostrarDatos(){
    	for(Bicicleta T:prueba){
    		System.out.println(T.toString());
    	}
	}

}
