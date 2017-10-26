package Monitorizacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ControlVelocidad.Eje;

public class MonitorizacionTest {
	
	public Monitorizacion obj;
	
	@Before
	public void setUp() throws Exception {
		Eje eje = new Eje();
		obj = new Monitorizacion(eje);
	}

	@Test
	public void testMonitorizacion() {
		assertNotNull(obj.getDeposi());
		assertNotNull(obj.getNotify());
		assertNotNull(obj.getRest());
		assertNotNull(obj.getVelMed());
		assertNotNull(obj.getReloj());
		assertNotNull(obj.getEje());
		assertNotNull(obj);
	}

	@Test
	public void testStart() {
		obj.start();
		
		boolean valorObtenido = obj.getReloj().isAlive();
		assertTrue(valorObtenido);
		
	}


	@Test
	public void testEqualsObject() {
		Eje e = new Eje();
		Monitorizacion obj1 = new Monitorizacion(e);
		Monitorizacion obj2 = new Monitorizacion(e);
		Monitorizacion obj3 = new Monitorizacion(e);
		
		obj1.start();
		obj2.start();
		obj3.start();
		
		//Comprobamos que se han inicializado bien los valores en el test del constructor

		assertNotNull(obj1); //Comprobamos que no son nulos
		assertNotNull(obj2); //Comprobamos que no son nulos
		assertNotNull(obj3); //Comprobamos que no son nulos
		
		assertEquals(obj1,obj1); //Comprobamos que son iguales a sí mismos
		assertEquals(obj2,obj2); // P.reflexiva
		assertEquals(obj3,obj3); 
		
		assertEquals(obj1,obj2); // P.Transitiva
		assertEquals(obj2,obj3);
		assertEquals(obj3,obj1);
		
		assertEquals(obj1,obj2); // P.Simetrica
		assertEquals(obj2,obj1);
	}

}
