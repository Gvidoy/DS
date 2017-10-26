package CarreraDeBicicletas;

import java.util.ArrayList;
import java.util.Random;

public class Prueba {
	

	    public static void main(String[] args) {

	    	final long DURACIONMAXIMA = 60000;
	 
	    	TC tipo = TC.MONTANA;
	    	TC tipo2 = TC.CARRETERA;
	    	int participantes = 20;
	    	int participantes2 = 30;
	    	ArrayList<Bicicleta> pruebaDeMontana, pruebaDeCarretera;
	    	
	    	Carrera unaCarrera =  new FactoriaCarreraAbstracta();

	    	pruebaDeMontana = unaCarrera.CrearCarrera(tipo, participantes);
	    	
	    	EjecutarCarrera carreraMontana = new EjecutarCarrera(pruebaDeMontana);
	    	
	    	pruebaDeCarretera = unaCarrera.CrearCarrera(tipo2, participantes2);
	    	
	    	EjecutarCarrera carreraCarretera = new EjecutarCarrera(pruebaDeCarretera);
	    	
	    	System.out.println("---------Esta es la parrilla de la carrera de Montaña---------");
	    	carreraMontana.mostrarDatos();
	    	System.out.println("---------Esta es la parrilla de la carrera Carretera---------");
	    	carreraCarretera.mostrarDatos();
	    	
	    	//Cuento inicio el tiempo para ajustar la duración de la carrera
	    	//Tiempo inicial de referencia
	    	long initialTime = System.currentTimeMillis();
	    	//Lanzo las hebras
	    	carreraMontana.start();
	    	carreraCarretera.start();

	    	try {
				carreraMontana.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	try {
				carreraCarretera.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	//Tiempo en el que terminan las hebras
	    	long finalTime = System.currentTimeMillis();
	    	
	    	//Ajusto el tiempo de parada
	    	
	    	long interTime = ((finalTime - initialTime)/1000);

	    	
	    	long parada = DURACIONMAXIMA - interTime;
	    	
	    	System.out.println("****************COMIENZA LA CARRERA*****************************");
	    	
	    	//Hacemos el para ajustado a 60 segundos
			try{
				Thread.sleep(parada);
			}catch (InterruptedException ex){
				Thread.currentThread().interrupt();
			}
	    	
	    	System.out.println("---------resultados de la carrera de Montaña---------");
	    	carreraMontana.mostrarDatos();
	    	System.out.println("---------resultados de la carrera de Carretera---------");
	    	carreraCarretera.mostrarDatos();
	    	
	    }
	
}
