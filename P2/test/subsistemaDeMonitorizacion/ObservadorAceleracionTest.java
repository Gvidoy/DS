package subsistemaDeMonitorizacion;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import subsistemaDeControl.Coche;
import simuladorVelocidad.SimuladorVelocidad;;

public class ObservadorAceleracionTest {
	ObservadorAceleracion obj1;
	Coche coche;
	SimuladorVelocidad simulador;
	Observable observable;
	@Before
	public void setUp() throws Exception {
		
		coche = Coche.getCoche();
		simulador = new SimuladorVelocidad();
		observable =  new Observable(coche);
		obj1 = new ObservadorAceleracion(observable, simulador);
	}

	@Test
	public void testObservadorAceleracion() {
		assertNotNull(obj1);
	}

	@Test
	public void testUpdate() {
		
		coche.desacelerar();
		obj1.update();
		assertEquals(0.0,coche.getAceleracion(),0.0);
		assertEquals("libre",coche.getFreno().getEstadoToString());

		coche.encenderMotor();
		coche.acelerar();
		coche.getAcelerador().setEstado(true);
		obj1.update();
		
		
		assertEquals(10.0,coche.getAceleracion(),0.0);
		
		
	}

	@Test
	public void testEqualsObject() {
		
		SimuladorVelocidad simulador2 = new SimuladorVelocidad();
		SimuladorVelocidad simulador3 = new SimuladorVelocidad();
		
		simulador2.setAceleracion(10.0);
		simulador3.setAceleracion(11.0);
		
		
		ObservadorAceleracion obj3 = new ObservadorAceleracion(observable, simulador);
		ObservadorAceleracion obj4 = new ObservadorAceleracion(observable, simulador2);
		ObservadorAceleracion obj5 = new ObservadorAceleracion(observable, simulador3);
		
		
		//Comprobamos que se han creado bien En el Test del constructor
	
		
		
		assertNotNull(obj3); //Comprobamos que no son nulos
		assertNotNull(obj4); //Comprobamos que no son nulos
		assertNotNull(obj5); //Comprobamos que no son nulos
		
		assertEquals("Objeto 1 igual a si mismo",obj3,obj3); //Comprobamos que son iguales a si mismo
		assertEquals("Objeto 2 igual a si mismo",obj4,obj4); // P.reflexiva
		assertEquals("Objeto 2 igual a si mismo",obj5,obj5); 
		
		
		
		
		assertNotEquals(obj3,obj4); // P.Transitiva
		assertNotEquals(obj4,obj5);
		assertNotEquals(obj3,obj5);
		
		assertNotEquals(obj5,obj3); // P.Simetrica
		assertNotEquals(obj3,obj5);
	}

}
