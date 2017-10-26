package Monitorizacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ControlVelocidad.ControlVelocidad;
import ControlVelocidad.Eje;
import ControlVelocidad.Reloj;

public class RelojMTest {
	
	private RelojM obj;
	
	
	@Before
	public void setUp() throws Exception{ 
		Eje eje = new Eje();
		Monitorizacion monitor = new Monitorizacion(eje);
		obj = new RelojM(monitor);
	}

	@Test
	public void testRun() {
		obj.start();
		
		boolean valorObtenido = obj.isAlive();
		assertTrue(valorObtenido);
	}

	@Test
	public void testRelojM() {
		assertNotNull(obj);
	}

	@Test
	public void testEqualsObject() {
		Eje eje = new Eje();
		Monitorizacion monitor = new Monitorizacion(eje);
		RelojM obj1 = new RelojM(monitor);
		RelojM obj2 = new RelojM(monitor);
		RelojM obj3 = new RelojM(monitor);
		
		

		
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
