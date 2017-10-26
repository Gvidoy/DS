package subsistemaDeMonitorizacion;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import subsistemaDeControl.Coche;

public class ObservadorTiempoTotalTest {

	Coche coche;
	Observable observable;
	JLabel tiempoTotal;
	ObservadorTiempoTotal oTiempoTotal;

	@Before
	public void setUp() throws Exception {
		coche = Coche.getCoche();
		observable = new Observable(coche);
		tiempoTotal = new JLabel();
		oTiempoTotal = new ObservadorTiempoTotal(observable,tiempoTotal);
	}

	@Test
	public void testObservadorTiempoTotal() {
		ObservadorTiempoTotal aux = new ObservadorTiempoTotal(observable,tiempoTotal);
		assertNotNull(aux);	
	}

	@Test
	public void testUpdate() {
		coche.encenderMotor();
		coche.apagarMotor();
		
		String valor_esperado = Long.toString(coche.calcularTiempo()) + " s";
		
		oTiempoTotal.update();
		
		assertEquals(valor_esperado,tiempoTotal.getText());
	}

	@Test
	public void testEqualsObject() {
		ObservadorTiempoTotal obj3 = new ObservadorTiempoTotal(observable,tiempoTotal);
		ObservadorTiempoTotal obj4 = new ObservadorTiempoTotal(observable,tiempoTotal);
		ObservadorTiempoTotal obj5 = new ObservadorTiempoTotal(observable,tiempoTotal);
		
		// Que no se crea un puntero a nulo lo comprobamos también en el constructor
		
		assertNotNull(obj3);
		assertNotNull(obj4);
		assertNotNull(obj5);
		
		assertEquals(obj3,obj3); //Comprobamos que un objeto es igual a si mismo
		assertEquals(obj4,obj4); // P.reflexiva
		assertEquals(obj5,obj5); 
		
		assertEquals(obj3,obj4); // P.Transitiva
		assertEquals(obj4,obj5);
		assertEquals(obj3,obj5);
		
		assertEquals(obj5,obj3); // P.Simetrica
		assertEquals(obj3,obj5);
	}

}
