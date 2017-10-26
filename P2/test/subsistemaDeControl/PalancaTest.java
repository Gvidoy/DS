package subsistemaDeControl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PalancaTest {

	private static Palanca obj1;
	private static Palanca obj2;
	
	@Before
	public void setUp() throws Exception{
		obj1 = new Palanca();
		obj2 = new Palanca();
	}
	
	@Test
	public void testEquals(){
		Palanca obj3 = new Palanca();
		Palanca obj4 = new Palanca();
		Palanca obj5 = new Palanca();
		
		
		//Comprobamos que se han creado bien En el Test del constructor
		
		//Cambiamos los objetos para que no sean iguales
		
		obj4.setEstado(EEstadoPalanca.AUTOMATICO);
		obj5.setEstado(EEstadoPalanca.REINICIAR);
		
		
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
	
	@Test
	public void testPalanca() {
		assertNotNull(obj1);
		assertEquals(EEstadoPalanca.APAGADO,obj1.getEstado());
	}

	@Test
	public void testGetEstado() {
		assertEquals(EEstadoPalanca.APAGADO,obj2.getEstado());
	}

	@Test
	public void testSetEstado() {
		obj1.setEstado(EEstadoPalanca.AUTOMATICO);
		assertEquals(EEstadoPalanca.AUTOMATICO,obj1.getEstado());
	}

}
