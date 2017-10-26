package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AutomaticoTest {
	
	Automatico obj;
	Freno freno;
	Acelerador acelerador;
	Eje eje;
	Almacenamiento almacena;
	
	
	@Before
	public void setUp() throws Exception {
		obj = new Automatico();
		freno = new Freno();
		acelerador = new Acelerador();
		eje = new Eje();
		almacena = new Almacenamiento();
	}

	@Test
	public void testMantenerVelocidad() {
		
		almacena.almacenarVelocidad(50);		
		almacena.almacenarVelSeleccionada();				
		
		obj.mantenerVelocidad(acelerador, freno, almacena, eje);
		
		Freno auxFreno = new Freno();
		Eje auxEje = new Eje();
		auxFreno.decremento(300, auxEje); 
		
		int valorEsperado = auxEje.leerRevoluciones();
		int valorObtenido = eje.leerRevoluciones();
		
		assertEquals("Mantener condicion 1",valorEsperado, valorObtenido);
		
		
		
		almacena.almacenarVelocidad(70);					
		almacena.almacenarVelSeleccionada();
		almacena.almacenarVelocidad(50);
		
		obj.mantenerVelocidad(acelerador, freno, almacena, eje);
		
		Acelerador auxAcelerador = new Acelerador();
		auxAcelerador.incrementar(300, auxEje); 
		
		valorEsperado = auxEje.leerRevoluciones();
		valorObtenido = eje.leerRevoluciones();
		
		assertEquals("Mantener condicion 2",valorEsperado, valorObtenido);
		
		
		almacena.almacenarVelocidad(100);					
		almacena.almacenarVelSeleccionada();
		almacena.almacenarVelocidad(100);

		
		obj.mantenerVelocidad(acelerador, freno, almacena, eje);
		
		auxAcelerador.incrementar(0, auxEje);
		valorEsperado = auxEje.leerRevoluciones();
		valorObtenido = eje.leerRevoluciones();
		
		assertEquals("Mantener condicion 3",valorEsperado, valorObtenido);
		
	}
	
	@Test
	public void testEqualsObject() {
		Automatico obj1 = new Automatico();
		Automatico obj2 = new Automatico();
		Automatico obj3 = new Automatico();
		
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
