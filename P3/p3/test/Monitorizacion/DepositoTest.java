package Monitorizacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ControlVelocidad.Eje;

public class DepositoTest {
	private Deposito obj;

	@Before
	public void setUp() throws Exception {
		obj = new Deposito();
	}

	@Test
	public void testDeposito() {
		assertNotNull(obj);
		assertEquals("Atributo constructor",obj.leerNivelInicial(),obj.leerNivelActual(),0.0);
	}

	@Test
	public void testActualizarDeposito() {
		Eje eje = new Eje();
		obj.actualizarDeposito(eje);
		double valorEsperado = obj.leerNivelActual();
		valorEsperado -= (eje.leerRevoluciones()*(eje.leerRevoluciones()/15))*obj.getRATIO_CONUSMO();
		assertEquals("Actualizar deposito",valorEsperado,obj.leerNivelActual(),0.0);

	}

	@Test
	public void testCambiarANivelInicial() {
		obj.cambiarANivelInicial();
		assertEquals("Atributo constructor",obj.leerNivelInicial(),obj.leerNivelActual(),0.0);
	}
	
	@Test
	public void testEquals(){
		Deposito obj1 = new Deposito();
		Deposito obj2 = new Deposito();
		Deposito obj3 = new Deposito();
		
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
