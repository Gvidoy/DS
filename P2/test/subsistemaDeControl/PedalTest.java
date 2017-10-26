package subsistemaDeControl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PedalTest {
	
	private static Pedal obj1;
	private static Pedal obj2;
	
	@Before
	public void setUp() throws Exception{
		obj1 = new Pedal();
		obj2 = new Pedal();
	}

	@Test
	public void testEquals(){
		Pedal obj3 = new Pedal();
		Pedal obj4 = new Pedal();
		Pedal obj5 = new Pedal();
		
		//Comprobamos que se han creado bien En el Test del constructor
		
		//Cambiamos los objetos para que no sean iguales
		
		obj4.setEstado(true);
		obj5.setAutomatico(true);
		
		
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


	@Test
	public void testPedal() {
		assertNotNull(obj1);
		assertFalse(obj1.getEstado());
	}

	@Test
	public void testGetEstado() {
		assertFalse(obj2.getEstado());
	}

	@Test
	public void testGetEstadoToString() {
		assertEquals("libre",obj2.getEstadoToString());
	}

	@Test
	public void testSetEstado() {
		obj1.setEstado(true);
		assertTrue(obj1.getEstado());
	}

	@Test
	public void testSetAutomatico() {
		obj1.setAutomatico(true);
		assertEquals("FRENADO AUTOMATICO",obj1.getEstadoToString());
		
	}

}
