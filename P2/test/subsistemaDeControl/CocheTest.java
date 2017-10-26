package subsistemaDeControl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CocheTest {
	
	Coche coche;

	@Before
	public void setUp() throws Exception {
		coche = Coche.getCoche();
	}

	@Test
	public void testGetCoche() {
		assertEquals(coche,Coche.getCoche());
	}

	@Test
	public void testGetVelocidad() {
		double valor_esperado = 0.0;
		assertEquals(valor_esperado,coche.getVelocidad(),0.0);
	}

	@Test
	public void testGetVelocidadAutomatica() {
		double valor_esperado = 0.0;
		assertEquals(valor_esperado,coche.getVelocidadAutomatica(),0.0);
	}

	@Test
	public void testGetAceleracion() {
		double valor_esperado = 0;
		coche.setAceleracion(valor_esperado);
		assertEquals(valor_esperado,coche.getAceleracion(),0.0);
	}

	@Test
	public void testGetMotor() {
		Motor objeto_esperado = new Motor();
		assertEquals(objeto_esperado,coche.getMotor());
	}

	@Test
	public void testGetFreno() {
		Pedal objeto_esperado = new Pedal();
		coche.getFreno().setEstado(false);
		assertEquals(objeto_esperado,coche.getFreno());
	}

	@Test
	public void testGetAcelerador() {
		Pedal objeto_esperado = new Pedal();
		coche.getAcelerador().setEstado(false);
		assertEquals(objeto_esperado,coche.getAcelerador());
	}

	@Test
	public void testGetPalanca() {
		Palanca objeto_esperado = new Palanca();
		assertEquals(objeto_esperado,coche.getPalanca());
	}

	@Test
	public void testGetVelocidadMedia() {
		double valor_esperado = 0.0;
		assertEquals(valor_esperado,coche.getVelocidadMedia(),0.0);
	}

	@Test
	public void testGetRevoluciones() {
		double valor_esperado = coche.getVelocidad() / (0.33*0.00377*32);
		assertEquals(valor_esperado,coche.getRevoluciones(),0.0);
	}

	@Test
	public void testGetNivel() {
		Nivel objeto_esperado = new NivelAceite();
		assertEquals(objeto_esperado,coche.getNivel(ETiposNiveles.ACEITE));
	}

	@Test
	public void testSetVelocidadAutomatica() {
		double valor_esperado = 99.9;
		coche.setVelocidad(99.9);
		coche.setVelocidadAutomatica();
		assertEquals(valor_esperado,coche.getVelocidadAutomatica(),0.0);
	}

	@Test
	public void testSetAceleracion() {
		int valor_esperado = 99;
		coche.setAceleracion(99);
		assertEquals(valor_esperado,coche.getAceleracion(),0.0);
	}

	@Test
	public void testSetVelocidad() {
		double valor_esperado = 99.9;
		coche.setVelocidad(99.9);
		assertEquals(valor_esperado,coche.getVelocidad(),0.0);
	}

	@Test
	public void testCalcularTiempo() {
		double valor_esperado_motor_apagado = 1.0;
		assertEquals(valor_esperado_motor_apagado,coche.calcularTiempo(),00.0);
	}

	@Test
	public void testCalcularDistancia() {
		coche.calcularDistancia();
		double valor_esperado_1, valor_esperado_2;
		valor_esperado_1 = coche.getMotor().getRotacionTotalMotor()+(coche.getVelocidad()*1000/3600)/100000;
		valor_esperado_2 = coche.getMotor().getRotacionUltimoEncendido()+(coche.getVelocidad()*1000/3600)/100000;
		
	    assertEquals(valor_esperado_1,coche.getMotor().getRotacionTotalMotor(),1.0);
	    assertEquals(valor_esperado_2,coche.getMotor().getRotacionUltimoEncendido(),1.0);
	}

	@Test
	public void testApagarMotor() {
		double valor_esperado = 0.0;
		coche.apagarMotor();
		assertEquals(valor_esperado,coche.getVelocidadAutomatica(),0.0);
		assertEquals(valor_esperado,coche.getMotor().getRotacionUltimoEncendido(),0.0);
		assertFalse(coche.getMotor().getEstado());
	}

	@Test
	public void testEncenderMotor() {
		double valor_esperado = 0.0;
		coche.apagarMotor();
		assertEquals(valor_esperado,coche.getVelocidadAutomatica(),0.0);
		assertEquals(valor_esperado,coche.getMotor().getRotacionUltimoEncendido(),0.0);
		assertFalse(coche.getMotor().getEstado());
	}

	@Test
	public void testAcelerar() {
		double valor_esperado = 0;
		assertEquals(valor_esperado,coche.getAceleracion(),0.0);
		coche.getMotor().setEstado(true);
		coche.getAcelerador().setEstado(true);
		coche.getFreno().setEstado(false);
		coche.acelerar();
		valor_esperado = 10;
		assertEquals(valor_esperado,coche.getAceleracion(),0.0);
	}

	@Test
	public void testDesacelerar() {
		double valor_esperado = 0;
		coche.desacelerar();
		assertEquals(valor_esperado,coche.getAceleracion(),0.0);
	}

	@Test
	public void testFrenoAutomatico() {
		double valor_esperado = -6;
		coche.frenoAutomatico();
		assertEquals(valor_esperado,coche.getAceleracion(),0.0);
	}

	@Test
	public void testFrenar() {
		double valor_esperado = -6;
		coche.frenar();
		assertEquals(valor_esperado,coche.getAceleracion(),0.0);
	}

	@Test
	public void testRellenarNivel() {
		coche.rellenarNivel(ETiposNiveles.ACEITE);
		assertEquals(coche.getNivel(ETiposNiveles.ACEITE).getRotacion(),coche.getMotor().getRotacionTotalMotor(),0.0);
	}
	
	@Test
	public void testEquals(){
		Coche obj3 = Coche.getCoche();
		
		// Constructor ya comprobado
		
		assertNotNull(obj3); //Comprobamos que no son nulos
		
		assertEquals(obj3,obj3); //Comprobamos que es igual a sí mismo
		//P. Simétrica y P. Transitiva no tiene sentido ya que una clase singleton no va a tener más de una instancia
	}

}
