package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculadorVelTest {
	private CalculadorVel obj;
	private Almacenamiento almacena;
	@Before
	public void setUp() throws Exception {
		obj = new CalculadorVel();
		almacena = new Almacenamiento();
	}

	@Test
	public void testAlmacenarVelocidad() {
		int valor_esperado = 100;
		
		obj.almacenarVelocidad(valor_esperado, almacena);
		assertEquals("Velocidad Almacenada",valor_esperado, almacena.leerVelocidad());
	}

	@Test
	public void testCalcularVelocidad() {
		int vueltas = 2000;
		double radio = 15;
		
		int valor_esperado = (int) (vueltas*radio/40);

		assertEquals("Velocidad Calculada", valor_esperado, obj.calcularVelocidad(vueltas, radio, almacena));	
	}
	
	@Test
	public void testEquals(){
		CalculadorVel obj1 = new CalculadorVel();
		CalculadorVel obj2 = new CalculadorVel();
		CalculadorVel obj3 = new CalculadorVel();
		

		
		//Comprobamos que se han inicializado bien los valores en el test del constructor

		//Cambiamos lor valores para que los objetos sean diferentes
		//obj2.almacenarVelocidad(100);
		//obj3.almacenarVelocidad(150);
		
		
		assertNotNull(obj1); //Comprobamos que no son nulos
		assertNotNull(obj2); //Comprobamos que no son nulos
		assertNotNull(obj3); //Comprobamos que no son nulos
		
		assertEquals(obj1,obj1); //Comprobamos que son iguales a sí mismos
		assertEquals(obj2,obj2); // P.reflexiva
		assertEquals(obj3,obj3); 
		
		assertEquals(obj1,obj2); // P.Transitiva
		assertEquals(obj2,obj3);
		assertEquals(obj3,obj1);
		
		assertEquals(obj1,obj2); // P.Simetrica
		assertEquals(obj2,obj1);
	}

}
