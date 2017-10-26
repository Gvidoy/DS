package Monitorizacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ControlVelocidad.Eje;

public class ReseteoTest {
	public Reseteo obj;
	@Before
	public void setUp() throws Exception {
		obj = new Reseteo();
	}

	@Test
	public void testInicializarValores() {
		Eje eje = new Eje();
		CalculadorVelMed calculadorVelMed = new CalculadorVelMed();
		obj.inicializarValores(calculadorVelMed, eje);
		/*eje.resetear();
		velMed.resetearTiempo();*/
		eje.resetear();
		long valorEsperado = 0;
		assertEquals("InicializarValores eje",valorEsperado,eje.leerRevolucionesTotales());
		
		double valorEsperado1 = 0;
		double valorObtenido1 = calculadorVelMed.getSumatoria_gas();
		
		assertEquals("InicializarValores CalculadorVelMed 1",valorEsperado1,valorObtenido1,0.0);
		
		int valorEsperado2 = 1;
		int valorObtenido2 = calculadorVelMed.getTiempo_vel();
		
		assertEquals("InicializarValores CalculadorVelMed 2",valorEsperado2,valorObtenido2);
		
	}

	@Test
	public void testEqualsObject() {
		Reseteo obj1 = new Reseteo();
		Reseteo obj2 = new Reseteo();
		Reseteo obj3 = new Reseteo();
		
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
