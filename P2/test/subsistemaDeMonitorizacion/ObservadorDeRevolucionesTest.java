package subsistemaDeMonitorizacion;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import subsistemaDeControl.Coche;

public class ObservadorDeRevolucionesTest {

	 Coche coche;
	 Observable observable;
	 JLabel revoluciones_actuales;
	 ObservadorDeRevoluciones obj1;
	
	@Before
	public void setUp() throws Exception {
		  coche = Coche.getCoche();
		  observable = new Observable(coche);
		  revoluciones_actuales = new JLabel();
		  obj1 = new ObservadorDeRevoluciones(observable,revoluciones_actuales);
	}

	@Test
	public void testObservadorDeRevoluciones() {
		assertNotNull(obj1);
	}

	@Test
	public void testUpdate() {
		coche.setVelocidad(100);
		obj1.update();
		DecimalFormat formateador = new DecimalFormat("########");
		assertEquals(formateador.format(coche.getRevoluciones()) + " RPM",revoluciones_actuales.getText());
	}

	@Test
	public void testEqualsObject() {
		JLabel revoluciones_actuales3 = new JLabel();
		JLabel revoluciones_actuales4 = new JLabel();
		JLabel revoluciones_actuales5 = new JLabel();
		ObservadorDeRevoluciones obj3 = new ObservadorDeRevoluciones(observable, revoluciones_actuales3);
		ObservadorDeRevoluciones obj4 = new ObservadorDeRevoluciones(observable, revoluciones_actuales4);
		ObservadorDeRevoluciones obj5 = new ObservadorDeRevoluciones(observable, revoluciones_actuales5);
		
		
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
