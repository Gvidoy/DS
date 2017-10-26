package simuladorVelocidad;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import simuladorVelocidad.SimuladorVelocidad;

public class SimuladorVelocidadTest {

	@Test
	public void testSimuladorVelocidad() {
		SimuladorVelocidad simulador = new SimuladorVelocidad();
		assertNotNull(simulador);
	}

	@Test
	public void testRunGenerarVelocidad(){
		double velocidad_esperada = 0.0;
		double aceleracion_prueba = 10.0;
		int i = 0;
		while (i < 20){
			velocidad_esperada += aceleracion_prueba * 0.1 - ((0.045*1200*9.8)/1200)*0.1 - ((0.65*1200*9.8)/1200)*0.1*(aceleracion_prueba/(aceleracion_prueba+0.001)) - ((0.5*1.225*2.56*0.44*velocidad_esperada*velocidad_esperada)/1200)*0.1;
			if (velocidad_esperada < 0)
				velocidad_esperada = 0;
			i++;
		}
		SimuladorVelocidad simulador = new SimuladorVelocidad();
		simulador.setAceleracion(aceleracion_prueba);
		simulador.start();
		try {
			TimeUnit.MILLISECONDS.sleep(100*i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertEquals(velocidad_esperada*2.777,simulador.getVelocidad(),1.0);
	}

	@Test
	public void testEqualsObject() {
		SimuladorVelocidad obj3 = new SimuladorVelocidad();
		SimuladorVelocidad obj4 = new SimuladorVelocidad();
		SimuladorVelocidad obj5 = new SimuladorVelocidad();
		
		// Constructor ya comprobado
		assertNotNull(obj3); //Comprobamos que no son nulos
		assertNotNull(obj4); //Comprobamos que no son nulos
		assertNotNull(obj5); //Comprobamos que no son nulos
		
		assertEquals(obj3,obj3); //Comprobamos que son iguales a si mismo
		assertEquals(obj4,obj4); // P.reflexiva
		assertEquals(obj5,obj5); 
		
		assertEquals(obj3,obj4); // P.Transitiva
		assertEquals(obj4,obj5);
		assertEquals(obj3,obj5);
		
		assertEquals(obj5,obj3); // P.Simetrica
		assertEquals(obj3,obj5);
		
	}

}
