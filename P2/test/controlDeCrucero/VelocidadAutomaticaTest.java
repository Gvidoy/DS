package controlDeCrucero;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class VelocidadAutomaticaTest {

	private VelocidadAutomatica obj1;
	private VelocidadAutomatica obj2;
	
	@Before
	public void setUp() throws Exception {
		obj1 = new VelocidadAutomatica();
		obj2 = new VelocidadAutomatica();
	}

	@Test
	public void testVelocidadAutomatica() {
		assertNotNull(obj1);
		assertFalse(obj1.getEstadoAceleradorAuto());
		assertFalse(obj1.getEstadoFrenoAuto());
		assertEquals(0.0,obj1.getVelocidadMantener(),0.0);
	}

	@Test
	public void testGetVelocidadMantener() {
		assertEquals(0.0,obj2.getVelocidadMantener(),0.0);
	}

	@Test
	public void testSetVelocidadMantener() {
		obj1.setVelocidadMantener(10);
		assertEquals(10,obj1.getVelocidadMantener(),0.0);
	}

	@Test
	public void testGetEstadoAceleradorAuto() {
		obj1.setVelocidadMantener(10);
		obj1.automatica(1);
		assertTrue(obj1.getEstadoAceleradorAuto());
		
	}

	@Test
	public void testGetEstadoFrenoAuto() {
		obj1.setVelocidadMantener(10);
		obj1.automatica(20);
		assertTrue(obj1.getEstadoFrenoAuto());
	}

	@Test
	public void testAutomatica() {
		obj2.setVelocidadMantener(10);
		obj2.automatica(20);
		assertTrue(obj2.getEstadoFrenoAuto());
		assertFalse(obj2.getEstadoAceleradorAuto());
	}
	
	@Test
	public void testEqualsObject() {
		VelocidadAutomatica obj3 = new VelocidadAutomatica();
		VelocidadAutomatica obj4 = new VelocidadAutomatica();
		VelocidadAutomatica obj5 = new VelocidadAutomatica();
		
		
		//Comprobamos que se han creado bien En el Test del constructor
	
		//Cambiamos los objetos para que no sean iguales
		
		obj3.setVelocidadMantener(10); 
		obj4.setVelocidadMantener(5);
		obj5.setVelocidadMantener(22);
		
		
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
