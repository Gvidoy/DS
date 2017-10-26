package subsistemaDeMonitorizacion;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import subsistemaDeControl.Coche;

public class ObservadorDeEstadoMotorTest {
	 Coche coche;
	 Observable observable;
	 JLabel estado_motor;
	 ObservadorDeEstadoMotor obj1;
	
	@Before
	public void setUp() throws Exception {
		  coche = Coche.getCoche();
		  observable = new Observable(coche);
		  estado_motor = new JLabel();
		  obj1 = new ObservadorDeEstadoMotor(observable,estado_motor);
	}

	@Test
	public void testObservadorDeEstadoMotor() {
		assertNotNull(obj1);
	}

	@Test
	public void testUpdate() {
		  coche.encenderMotor();
		  obj1.update();
		  assertEquals("encendido",coche.getMotor().getEstadoToString());
	}

	@Test
	public void testEqualsObject() {
		JLabel estado_motor3 = new JLabel();
		JLabel estado_motor4 = new JLabel();
		JLabel estado_motor5 = new JLabel();
		ObservadorDeEstadoMotor obj3 = new ObservadorDeEstadoMotor(observable, estado_motor3);
		ObservadorDeEstadoMotor obj4 = new ObservadorDeEstadoMotor(observable, estado_motor4);
		ObservadorDeEstadoMotor obj5 = new ObservadorDeEstadoMotor(observable, estado_motor5);
		
		
		//Comprobamos que se han creado bien En el Test del constructor
	
		
		
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

}
