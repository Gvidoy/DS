package subsistemaDeMonitorizacion;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import subsistemaDeControl.Coche;

public class ObservadorFrenoTest {

	 Coche coche;
	 Observable observable;
	 JLabel estado_freno;
	 ObservadorFreno obj1;
	
	@Before
	public void setUp() throws Exception {
		  coche = Coche.getCoche();
		  observable = new Observable(coche);
		  estado_freno = new JLabel();
		  obj1 = new ObservadorFreno(observable,estado_freno);
	}

	@Test
	public void testObservadorFreno() {
		assertNotNull(obj1);
	}

	@Test
	public void testUpdate() {
		obj1.update();
		assertEquals(coche.getFreno().getEstadoToString(),estado_freno.getText());
		
		coche.getFreno().setEstado(true);
		obj1.update();
		assertEquals(coche.getFreno().getEstadoToString(),estado_freno.getText());
		
	}

	@Test
	public void testEqualsObject() {
		JLabel estado_freno3 = new JLabel();
		JLabel estado_freno4 = new JLabel();
		JLabel estado_freno5 = new JLabel();
		ObservadorFreno obj3 = new ObservadorFreno(observable, estado_freno3);
		ObservadorFreno obj4 = new ObservadorFreno(observable, estado_freno4);
		ObservadorFreno obj5 = new ObservadorFreno(observable, estado_freno5);
		
		
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
