package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RelojTest {

	private Reloj obj;
	private ControlVelocidad cv; 
	
	@Before
	public void setUp() throws Exception {
		cv = new ControlVelocidad();
		obj = new Reloj(cv);
	}

	@Test
	public void testReloj() {
		assertNotNull(obj);
	}
	
	@Test
	public void testRun() {
		
		obj.start();
		
		boolean valorObtenido = obj.isAlive();
		assertTrue(valorObtenido);
	}
	
	@Test
	public void testEquals(){
		ControlVelocidad cv2 = new ControlVelocidad();
		Reloj obj1 = new Reloj(cv2);
		Reloj obj2 = new Reloj(cv2);
		Reloj obj3 = new Reloj(cv2);
		
		

		
		//Comprobamos que se han inicializado bien los valores en el test del constructor

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
