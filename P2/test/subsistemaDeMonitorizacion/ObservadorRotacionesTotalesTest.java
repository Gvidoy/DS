package subsistemaDeMonitorizacion;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import subsistemaDeControl.Coche;

public class ObservadorRotacionesTotalesTest {
	
	Coche coche;
	Observable observable;
	JLabel rotaciones_totales;
	ObservadorRotacionesTotales oRotacionesTotales;

	@Before
	public void setUp() throws Exception {
		coche = Coche.getCoche();
		observable = new Observable(coche);
		rotaciones_totales = new JLabel();
		oRotacionesTotales = new ObservadorRotacionesTotales(observable,rotaciones_totales);
	}

	@Test
	public void testObservadorRotacionesTotales() {
		ObservadorRotacionesTotales aux = new ObservadorRotacionesTotales(observable,rotaciones_totales);
		assertNotNull(aux);	
	}

	@Test
	public void testUpdate() {
		
		coche.getMotor().setRotacionTotalMotor(0);
		coche.encenderMotor();
		coche.calcularDistancia();
		coche.apagarMotor();
		
		String valor_esperado = ("0 Km");
		oRotacionesTotales.update();
		
		assertEquals(valor_esperado,rotaciones_totales.getText());
	}

	@Test
	public void testEqualsObject() {
		ObservadorRotacionesTotales obj3 = new ObservadorRotacionesTotales(observable,rotaciones_totales);
		ObservadorRotacionesTotales obj4 = new ObservadorRotacionesTotales(observable,rotaciones_totales);
		ObservadorRotacionesTotales obj5 = new ObservadorRotacionesTotales(observable,rotaciones_totales);
		
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
