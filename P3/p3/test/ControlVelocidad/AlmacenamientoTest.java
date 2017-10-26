package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlmacenamientoTest {
	private Almacenamiento obj;
	
	@Before
	public void setUp() throws Exception {
		this.obj = new Almacenamiento(); 
	}

	@Test
	public void testAlmacenamiento() {
		int valorEsperado = 0;
		assertNotNull(obj);
		
		assertEquals("Velocidad",valorEsperado,obj.leerVelocidad());
		assertEquals("Distancia",(double)valorEsperado,obj.leerDistancia(),0.0);
		assertEquals("Seleccionada",valorEsperado,obj.leerVelSeleccionada());		
	}

	@Test
	public void testAlmacenarVelocidad() {
		int valorEsperado = 200;
		double valorEsperado2 = (valorEsperado*0.25)/(3600);
		obj.almacenarVelocidad(valorEsperado);
		assertEquals("Velocidad",valorEsperado,obj.leerVelocidad());
		assertEquals("Distancia",valorEsperado2,obj.leerDistancia(),0.0);
	}


	
	@Test
	public void testAlmacenarVelSeleccionada() {
		this.testAlmacenarVelocidad();
		obj.almacenarVelSeleccionada();
		int valorEsperado = 200;
		assertEquals("Velocidad Selecionada",valorEsperado,obj.leerVelSeleccionada());
	}
	
	@Test
	public void testEquals(){
		Almacenamiento obj1 = new Almacenamiento();
		Almacenamiento obj2 = new Almacenamiento();
		Almacenamiento obj3 = new Almacenamiento();
		

		
		//Comprobamos que se han inicializado bien los valores en el test del constructor

		//Cambiamos lor valores para que los objetos sean diferentes
		obj2.almacenarVelocidad(100);
		obj3.almacenarVelocidad(150);
		
		
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
