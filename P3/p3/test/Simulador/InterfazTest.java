package Simulador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ControlVelocidad.ControlVelocidad;
import Monitorizacion.Monitorizacion;

public class InterfazTest {
	private Interfaz obj;

	@Before
	public void setUp() throws Exception {
		obj = new Interfaz();
	}

	@Test
	public void testInterfaz() {
		assertNotNull(obj);
		assertNotNull(obj.control);
		assertNotNull(obj.monitor);
		assertNotNull(obj.simulacion);
	
	}

	@Test
	public void testEqualsObject() {
		Interfaz obj1 = new Interfaz();
		Interfaz obj2 = new Interfaz();
		Interfaz obj3 = new Interfaz();
		
		//Comprobamos que se han inicializado bien los valores en el test del constructor

		assertNotNull(obj1); //Comprobamos que no son nulos
		assertNotNull(obj2); //Comprobamos que no son nulos
		assertNotNull(obj3); //Comprobamos que no son nulos
		
		assertEquals(obj1,obj1); //Comprobamos que son iguales a sí mismos
		assertEquals(obj2,obj2); // P.reflexiva
		assertEquals(obj3,obj3); 
		
		assertNotEquals(obj1,obj2); // P.Transitiva
		assertNotEquals(obj2,obj3);
		assertNotEquals(obj3,obj1);
		
		assertNotEquals(obj1,obj2); // P.Simetrica
		assertNotEquals(obj2,obj1);
	}

}
