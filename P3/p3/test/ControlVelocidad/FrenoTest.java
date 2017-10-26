package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FrenoTest {
	private Freno obj;
	@Before
	public void setUp() throws Exception {
		obj = new Freno();
	}

	@Test
	public void testFreno() {
		assertFalse(obj.leerEstado());
		assertNotNull(obj);
	}

	@Test
	public void testDecremento() {
		int valorEsperado = 0;
		Eje eje = new Eje();
		obj.decremento(7,eje);
		assertEquals("Decrementar ",valorEsperado,eje.leerRevoluciones());
	}

	@Test
	public void testActualizarFreno() {		
		double valorEsperado = 700 + 100;
		assertEquals("Actualizar Freno",valorEsperado,obj.actualizarFreno(),0.0);
	}

	@Test
	public void testSoltarFreno() {
		obj.soltarFreno();
		assertFalse(obj.leerEstado());
	}

	@Test
	public void testPresionarFreno() {
		obj.presionarFreno();
		assertTrue(obj.leerEstado());
	}



	@Test
	public void testEqualsObject() {
		Freno obj1 = new Freno();
		Freno obj2 = new Freno();
		

		
		//Comprobamos que se han inicializado bien los valores en el test del constructor

		//Cambiamos lor valores para que los objetos sean diferentes
		obj1.presionarFreno();;
		obj2.soltarFreno();;
		
		
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
