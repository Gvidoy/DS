package ControlVelocidad;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControlVelocidadTest {
	private ControlVelocidad obj;
	private Almacenamiento almacena;
	private Automatico automatico;
	private Acelerador acelerador;
	private Freno freno;
	private Motor motor;
	private Palanca palanca;
	private Eje eje;
	
	
	@Before
	public void setUp() throws Exception {
		obj = new ControlVelocidad();
		almacena = new Almacenamiento();
		automatico = new Automatico();
		acelerador = new Acelerador();
		freno = new Freno();
		motor = new Motor();
		palanca = new Palanca();
		eje = new Eje();
	}

	@Test
	public void testControlVelocidad() {
		assertNotNull(obj);
	}

	@Test
	public void testStart() {
		obj.start();
		boolean valorObtenido = obj.getReloj().isAlive();
		assertTrue(valorObtenido);
	}

	@Test
	public void testControlarEstado() {

		int valorEsperado = 0;
		int valorObtenido = 0;
		
		
		obj.getMotor().cambiarEstado();
		obj.getEstadoPalanca().cambiarEstado(Palanca.APAGADO);
		obj.getAcelera().pisarAcelerador();
		obj.controlarEstado();
		valorObtenido = obj.obtenerVel();
		
		
		
		acelerador.pisarAcelerador();
		
		int incremento = (int) acelerador.actualizarAcelerador(eje.velAnterior);
		acelerador.incrementar(incremento, eje);
		eje.calcularVelocidad(almacena);
		valorEsperado = almacena.leerVelocidad();
		
		assertEquals("ControlarEstado Caso 1 ",valorEsperado,valorObtenido);
		
		obj.getAcelera().soltarAcelerador();
		obj.getFreno().presionarFreno();
		obj.controlarEstado();
		valorObtenido = obj.obtenerVel();

		
		acelerador.soltarAcelerador();
		freno.presionarFreno();
		
		int decremento = (int) freno.actualizarFreno();
		freno.decremento(decremento, eje);
		eje.calcularVelocidad(almacena);
		valorEsperado = almacena.leerVelocidad();
		
		assertEquals("ControlarEstado Caso 2 ",valorEsperado,valorObtenido);
		
		
		obj.getFreno().soltarFreno();
		obj.controlarEstado();
		valorObtenido = obj.obtenerVel();
		
		freno.soltarFreno();
		freno.decremento(Freno.ROZAMIENTO, eje);
		eje.calcularVelocidad(almacena);
		valorEsperado = almacena.leerVelocidad();
		
		assertEquals("ControlarEstado Caso 3 ",valorEsperado,valorObtenido);

		
		obj.getEstadoPalanca().cambiarEstado(Palanca.MANTENIENDO);
		obj.controlarEstado();
		valorObtenido = obj.obtenerVel();
		
		almacena.almacenarVelSeleccionada();
		automatico.mantenerVelocidad(acelerador, freno,almacena, eje);
		eje.calcularVelocidad(almacena);
		valorEsperado = almacena.leerVelocidad();
		
		
		assertEquals("ControlarEstado Caso 4 ",valorEsperado,valorObtenido);
		
		
		
		obj.getEstadoPalanca().cambiarEstado(Palanca.REINICIANDO);
		obj.controlarEstado();
		
		valorObtenido = obj.obtenerVel();

		
		automatico.mantenerVelocidad(acelerador, freno,almacena, eje);
		valorEsperado = almacena.leerVelocidad();
		
		assertEquals("ControlarEstado Caso 5 ",valorEsperado,valorObtenido);

		obj.getMotor().cambiarEstado();
		obj.getFreno().presionarFreno();
		obj.controlarEstado();
		valorObtenido = obj.obtenerVel();
		
		freno.presionarFreno();
		decremento = (int) freno.actualizarFreno();
		freno.decremento(decremento, eje);
		valorEsperado = almacena.leerVelocidad();
		
		assertEquals("ControlarEstado Caso 6 ",valorEsperado,valorObtenido);
			
	}

	
	
	@Test
	public void testEqualsObject() {
		ControlVelocidad obj1 = new ControlVelocidad();
		ControlVelocidad obj2 = new ControlVelocidad();
		ControlVelocidad obj3 = new ControlVelocidad();
		
		//Comprobamos que se han inicializado bien los valores en el test del constructor
		

		assertNotNull(obj1); //Comprobamos que no son nulos
		assertNotNull(obj2); //Comprobamos que no son nulos
		assertNotNull(obj3); //Comprobamos que no son nulos
		
		
		//Cambiolor valores de los objetos para que sean diferentes
		obj2.cambiarPalanca(2);
		obj3.cambiarPalanca(3);
		
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
