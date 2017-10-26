package Monitorizacion;
import ControlVelocidad.Almacenamiento;

import ControlVelocidad.Eje;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculadorVelMedTest {

	private CalculadorVelMed obj;		
	@Before
	public void setUp() throws Exception {
		obj = new CalculadorVelMed();
	}

	@Test
	public void testCalculadorVelMed() {

		assertNotNull(obj);
		assertEquals("Atriburo en constructor 1",0,obj.get_velMedia(),0.0);
		assertEquals("Atriburo en constructor 2",0,obj.getSumatoria_vel());
		assertEquals("Atriburo en constructor 3",0,obj.getSumatoria_gas(),0.0);
		assertEquals("Atriburo en constructor 4",1,obj.get_tiempo_gas());
		assertEquals("Atriburo en constructor 5",1,obj.getTiempo_vel());
		assertEquals("Atriburo en constructor 6",100,obj.get_gastoValorAnterior(),0.0);


		
	}

	@Test
	public void testCalcularVelocidadMedia() {
		Eje eje = new Eje();
		eje.setVelAnterior(10);
		obj.calcularVelocidadMedia(eje);
		
		double valorEsperado = 10;
		
		assertEquals("CalcularVelMedia caso 1",valorEsperado,obj.get_velMedia(),0.0);
		
		obj.setSumatoria_vel(1000000030);
		obj.calcularVelocidadMedia(eje);
		
		valorEsperado = 0;
			
		assertEquals("CalcularVelMedia caso 2",valorEsperado,obj.getSumatoria_gas(),0.0);
	}

	@Test
	public void testResetearTiempo() {
		
		obj.resetearTiempo();
		
		double valorEsperado = 0;
		double valorObtenido = obj.getSumatoria_gas();
		
		assertEquals("ResetearTiempo valor 1",valorEsperado,valorObtenido,0.0);
		
		int valorEsperado2 = 1;
		int valorObtenido2 = obj.getTiempo_vel();
		
		assertEquals("ResetearTiempo valor 2",valorEsperado2,valorObtenido2);

		
	}


	@Test
	public void testCalcularGastoMedio() {
		Eje eje = new Eje();
		eje.setVelAnterior(10);
		Deposito deposito = new Deposito();
		deposito.set_nivelactual(1);
		obj.calcularGastoMedio(eje, deposito);
		assertEquals("Calculas gasto Medio caso 1",99,obj.getSumatoria_gas(),0.0);
		
		assertEquals("Calculas gasto Medio caso 2",2,obj.get_tiempo_gas(),0.0);
		
		obj.setSumatoria_gas(1002000000);
		obj.calcularGastoMedio(eje, deposito);
		
		double valorEsperado = 0;
		double valorObtenido = obj.getSumatoria_gas();
		
		assertEquals("Calculas gasto Medio caso 3 valor 1",valorEsperado,valorObtenido,0.0);
		
		int valorEsperado2 = 1;
		int valorObtenido2 = obj.getTiempo_vel();
		
		assertEquals("Calculas gasto Medio caso 3 valor 2s",valorEsperado2,valorObtenido2);
		
		
		
		
	}


	@Test
	public void testEqualsObject() {
		CalculadorVelMed obj1 = new CalculadorVelMed();
		CalculadorVelMed obj2 = new CalculadorVelMed();
		CalculadorVelMed obj3 = new CalculadorVelMed();
		
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
