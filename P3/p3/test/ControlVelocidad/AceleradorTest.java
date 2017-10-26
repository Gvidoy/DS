package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AceleradorTest {

	private Acelerador obj;
	
	@Before
	public void setUp() throws Exception {
		obj = new Acelerador();
	}

	@Test
	public void testAcelerador() {
		assertFalse(obj.leerEstado());
		assertNotNull(obj);
	}

	@Test
	public void testIncrementar() {
		int valorEsperado = 7;
		Eje eje = new Eje();
		obj.incrementar(valorEsperado,eje);
		assertEquals("Incrementar ",valorEsperado,eje.leerRevoluciones());
	}

	@Test
	public void testActualizarAcelerador() {
		double velAnterior = 5;
		double valorEsperado = 300 - (100*0.015*velAnterior);
		assertEquals("Actualizar aceleracion",valorEsperado,obj.actualizarAcelerador(velAnterior),0.0);
		
	}

	@Test
	public void testSoltarAcelerador() {
		obj.soltarAcelerador();
		assertFalse(obj.leerEstado());

	}

	@Test
	public void testPisarAcelerador() {
		obj.pisarAcelerador();
		assertTrue(obj.leerEstado());
	}

	@Test
	public void testEqualsObject() {
		Acelerador obj1 = new Acelerador();
		Acelerador obj2 = new Acelerador();
		

		
		//Comprobamos que se han inicializado bien los valores en el test del constructor

		//Cambiamos lor valores para que los objetos sean diferentes
		obj1.pisarAcelerador();;
		obj2.soltarAcelerador();;
		
		
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
