package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MotorTest {
	private Motor obj;
	@Before
	public void setUp() throws Exception {
		obj = new Motor();
		
	}

	@Test
	public void testMotor() {
		boolean valor_obtenido = obj.leerEstado();
		assertFalse(valor_obtenido);
		assertNotNull(obj);
	}

	@Test
	public void testCambiarEstado() {
		obj.cambiarEstado();
		boolean valor_obtenido = obj.leerEstado();
		assertTrue(valor_obtenido);
		obj.cambiarEstado();
		valor_obtenido = obj.leerEstado();
		assertFalse(valor_obtenido);
		
	}
	
	@Test
	public void testEquals(){
		Motor obj1 = new Motor();
		Motor obj2 = new Motor();


		
		//Comprobamos que se han inicializado bien los valores en el test del constructor

		//Cambiamos lor valores para que los objetos sean diferentes
		obj2.cambiarEstado();
		
		
		assertNotNull(obj1); //Comprobamos que no son nulos
		assertNotNull(obj2); //Comprobamos que no son nulos
		
		assertEquals(obj1,obj1); //Comprobamos que son iguales a sí mismos
		assertEquals(obj2,obj2); // P.reflexiva
		
		
		assertNotEquals(obj1,obj2); // P.Transitiva
		assertNotEquals(obj2,obj1);

		
		assertNotEquals(obj1,obj2); // P.Simetrica
		assertNotEquals(obj2,obj1);
	}

}
