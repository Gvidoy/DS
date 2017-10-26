package simuladorVelocidad;

import java.util.logging.Logger;

public class SimuladorVelocidad implements Runnable{
	
	private Thread hiloDeEjecucion;
	
	private double velocidad;
	private double aceleracion;
	private long tiempo_ms;
	private double tiempo;
	private double masa;
	private double peso;
	
	public SimuladorVelocidad(){
		velocidad = 0;
		aceleracion = 0;
		tiempo_ms = 100;
		tiempo = (double)tiempo_ms / 1000;
		masa = 1200; // masa del coche en KG, o peso en Kilopondios
		peso = masa * 9.8; // peso del coche en Newtons
	}

	
	private void generarVelocidad(){
		/*
		 * aceleración: 
		 * 		Aceleración del coche en m*s^2
		 * ((0.045*peso)/masa): 
		 * 		Deceleración provocada por el rozamiento de los neumáticos con el suelo. Es casi despreciable
		 * ((0.65*peso)/masa)*tiempo*(aceleracion/(aceleracion+0.001)): 
		 * 		Este factor simula la fricción mecánica del coche, es decir, la fuerza perdida al acelerar por el rozamiento de los ejes, engranajes, etc.
		 * ((0.5*1.225*2.56*0.44*velocidad*velocidad)/masa):
		 * 		Simulación de la resistencia aerodinámica que provoca el aire en la aceleración del coche. A más rápido va, más fuerte choca con el aire.
		 * 		1.225 es la densidad del aire
		 * 		2.56 es la superficie frontal del coche que choca con el aire. Basada en un coche poco aerodinámico
		 * 		0.44 es el coeficiente de penetración
		*/
		
		velocidad += aceleracion * tiempo - ((0.045*peso)/masa)*tiempo - ((0.65*peso)/masa)*tiempo*(aceleracion/(aceleracion+0.001)) - ((0.5*1.225*2.56*0.44*velocidad*velocidad)/masa)*tiempo;

		if (velocidad < 0)
			velocidad = 0;
		
	}
	
	
	public void setAceleracion(double ac){
		aceleracion = ac;
	}
	
	public void start(){
		hiloDeEjecucion = new Thread(this);
		hiloDeEjecucion.start();
	}
	
	
	public void run(){
		synchronized (this){
			while(true){
				try{
					this.wait(tiempo_ms);
					generarVelocidad();
				}catch (InterruptedException ex){
					Logger.getLogger("Se produjo una excepción en el simulador");
				}
			}
		}
	}

	
	public double getVelocidad() {
		return velocidad * (2.777); // 1000/3600 = 2.777
	}
	
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
		SimuladorVelocidad aux;
		
		if(obj instanceof SimuladorVelocidad){
			aux = (SimuladorVelocidad) obj;
		
			if((this.tiempo_ms == aux.tiempo_ms)
				&& (this.aceleracion == aux.aceleracion)
				&& (this.velocidad == aux.velocidad)
				&& (this.tiempo == aux.tiempo)
				&& (this.masa == aux.masa)
				&& (this.peso == aux.peso))
						result = true;
		}
		return result;
	}
}
