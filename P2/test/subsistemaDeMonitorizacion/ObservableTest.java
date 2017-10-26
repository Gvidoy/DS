package subsistemaDeMonitorizacion;
import javax.swing.JLabel;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;


import subsistemaDeControl.Coche;


public class ObservableTest {
	
	private Coche coche;
	private Observable obj1;
	private Observable obj2;
	
	
	
	
	@Before
	public void setUp() throws Exception {
		coche = Coche.getCoche();
		obj1 = new Observable(coche);
		obj2 = new Observable(coche);
	}

	@Test
	public void testObservable() {
		assertNotNull(obj1);
		assertEquals(coche,obj1.getCoche());
	}

	@Test
	public void testGetCoche() {
		assertEquals(coche,obj1.getCoche());
	}

	@Test
	public void testAddObserver() {
		JLabel velocidad_actual= new JLabel();
		new ObservadorVelocidad(obj1,velocidad_actual);
		coche.encenderMotor();
		obj1.start();
		coche.setVelocidad(10);
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		assertEquals("10 Km/h",velocidad_actual.getText());
		
	}

	@Test
	public void testRemoveObserver() {
		JLabel velocidad_actual= new JLabel();
		ObservadorVelocidad oVelocidad= new ObservadorVelocidad(obj1,velocidad_actual);
		obj1.removeObserver(oVelocidad);
		coche.encenderMotor();
		obj1.start();
		coche.setVelocidad(10);
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		assertNotEquals("10 Km/h",velocidad_actual.getText());
	}

	@Test
	public void testStart() {
		JLabel velocidad_actual= new JLabel();
		new ObservadorVelocidad(obj1,velocidad_actual);
		coche.encenderMotor();
		obj1.start();
		coche.setVelocidad(10);
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		assertEquals("10 Km/h",velocidad_actual.getText());
	}

	@Test
	public void testRun() {
		JLabel velocidad_actual= new JLabel();
		new ObservadorVelocidad(obj2,velocidad_actual);
		obj2.start();
		coche.setVelocidad(10);
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		assertEquals("",velocidad_actual.getText());
	}

	@Test
	public void testEqualsObject() {
		Observable obj3 = new Observable(coche);
		Observable obj4 = new Observable(coche);
		Observable obj5 = new Observable(coche);
		
		
		//Comprobamos que se han creado bien En el Test del constructor
	
		//Cambiamos los objetos para que no sean iguales
		JLabel velocidad_actual= new JLabel();
		ObservadorVelocidad oVel = new ObservadorVelocidad(obj3,velocidad_actual);
		
		JLabel revoluciones_actuales= new JLabel();
		ObservadorDeRevoluciones oRev = new ObservadorDeRevoluciones(obj4,revoluciones_actuales);
		
		JLabel distancia_recorrida= new JLabel();
		ObservadorRotacionesTotales oRot = new ObservadorRotacionesTotales(obj5,distancia_recorrida);
		
		
		
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


