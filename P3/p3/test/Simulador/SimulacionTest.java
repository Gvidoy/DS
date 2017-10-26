package Simulador;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimulacionTest {
	private Simulacion obj;
	@Before
	public void setUp() throws Exception {
		obj = new Simulacion(new PanelEtiquetas(new Interfaz()), new PanelBotones(new Interfaz()));
	}

	@Test
	public void testRun() {
		obj.start();
		assertTrue(obj.isAlive());
	}

	@Test
	public void testSimulacion() {
		assertNotNull(obj);
	}

	@Test
	public void testEqualsObject() {
		Simulacion obj1 = new Simulacion(new PanelEtiquetas(new Interfaz()), new PanelBotones(new Interfaz()));
		Simulacion obj2 = new Simulacion(new PanelEtiquetas(new Interfaz()), new PanelBotones(new Interfaz()));
		Simulacion obj3 = new Simulacion(new PanelEtiquetas(new Interfaz()), new PanelBotones(new Interfaz()));
		
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
