package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PalancaTest {

	Palanca obj;
	
	@Before
	public void setUp() throws Exception {
		obj = new Palanca();
	}

	@Test
	public void testPalanca() {
		assertNotNull(obj);
		int valorEsperado = 0;
		assertEquals("Estado ",valorEsperado,obj.leerEstado());
		
	}
	
	@Test
	public void testEquals(){
		Palanca obj1 = new Palanca();
		Palanca obj2 = new Palanca();
		Palanca obj3 = new Palanca();
		

		
		//Comprobamos que se han inicializado bien los valores en el test del constructor

		//Cambiamos lor valores para que los objetos sean diferentes
		obj2.cambiarEstado(1);
		obj3.cambiarEstado(2);
		
		
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
