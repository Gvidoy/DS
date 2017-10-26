package subsistemaDeControl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MotorTest {
	private Motor obj1;
	private Motor obj2;
	
	@Before
	public void setUp() throws Exception {
		obj1 = new Motor();
		obj2 = new Motor();
	}
	

	@Test
	public void testMotor() {
		assertNotNull(obj1);
		assertFalse(obj1.getEstado());
		assertEquals(0.0,obj1.getRevolucionActual(),0.0);
		assertEquals(0.0,obj1.getRotacionTotalMotor(),0.0);
		assertEquals(0,obj1.getRotacionUltimoEncendido(),0.0);
		
	}

	@Test
	public void testGetEstado() {
		assertFalse(obj1.getEstado());
	}
	

	@Test
	public void testGetRevolucionActual() {
		assertEquals(0.0,obj1.getRevolucionActual(),0.0);
	}
	

	@Test
	public void testGetRotacionTotalMotor() {
		assertEquals(0.0,obj2.getRotacionTotalMotor(),0.0);
	}

	@Test
	public void testGetEstadoToString() {
		assertEquals( "apagado",obj1.getEstadoToString());
	}

	@Test
	public void testGetRotacionUltimoEncendido() {
		assertEquals(0,obj1.getRotacionUltimoEncendido(),0.0);
	}

	@Test
	public void testSetEstado() {
		obj1.setEstado(true);
		assertTrue(obj1.getEstado());
	}

	@Test
	public void testSetRevolucionActual() {
		obj1.setRevolucionActual(8.0);
		assertEquals(8.0,obj1.getRevolucionActual(),0.0);
	}

	@Test
	public void testSetRotacionTotalMotor() {
		obj1.setRotacionTotalMotor(8.0);
		assertEquals(8.0,obj1.getRotacionTotalMotor(),0.0);
	}

	@Test
	public void testSetRotacionUltimoEncendido() {
		obj1.setRotacionUltimoEncendido(8.0);
		assertEquals(8.0,obj1.getRotacionUltimoEncendido(),0.0);
	}

	@Test
	public void testEqualsObject() {
		Motor obj3 = new Motor();
		Motor obj4 = new Motor();
		Motor obj5 = new Motor();
		
		
		//Comprobamos que se han creado bien En el Test del constructor
	
		//Cambiamos los objetos para que no sean iguales
		
		obj3.setEstado(true);
		obj4.setRevolucionActual(5.0);
		obj5.setRotacionTotalMotor(10.0);
		
		
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
