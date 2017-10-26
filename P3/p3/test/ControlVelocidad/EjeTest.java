package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EjeTest {
	private Eje eje;
	@Before
	public void setUp() throws Exception {
		eje = new Eje();
	}

	@Test
	public void testEje() {
		
		int valorEsperado = 0;
		
		assertNotNull(eje);
		assertNotNull(eje.getCalculadorVel());
		assertEquals("Vueltas",valorEsperado,eje.leerRevoluciones());
		assertEquals("Vueltas Totales",(long)valorEsperado,eje.leerRevolucionesTotales());

	}
	@Test
	synchronized public void testIncrementarVueltas(){
		eje.incrementarVueltas(3);
		long valorEsperado = 3;
		assertEquals("Vueltas incrementadas",valorEsperado,eje.leerRevoluciones());
	}
	
	
	@Test
	synchronized public void testResetear() {
		
		Almacenamiento almacena = new Almacenamiento();
		eje.incrementarVueltas(100);
		eje.calcularVelocidad(almacena);
		eje.resetear();
		long valorEsperado = 0;
		assertEquals("reseteado",valorEsperado,eje.leerRevolucionesTotales());

	}
	@Test
	synchronized public void testCalcularVelocidad(){
		Almacenamiento almacena = new Almacenamiento();
		
		eje.incrementarVueltas(100);
		eje.calcularVelocidad(almacena);
		
		double valorEsperado = 100/24;
		
		assertEquals("Calculando velocidad", valorEsperado, eje.leerRevolucionesTotales(),0.0);
	}
	
	@Test
	public void testEquals(){
		Eje obj1 = new Eje();
		Eje obj2 = new Eje();
		Eje obj3 = new Eje();
		
		

		
		//Comprobamos que se han inicializado bien los valores en el test del constructor

		//Cambiamos lor valores para que los objetos sean diferentes
		obj2.incrementarVueltas(20);
		obj3.incrementarVueltas(50);
		
		
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
