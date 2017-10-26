package subsistemaDeMonitorizacion;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import subsistemaDeControl.Coche;

public class ObservadorVelocidadTest {

	Coche coche;
	Observable observable;
	JLabel velocidad;
	ObservadorVelocidad oVelocidad;

	@Before
	public void setUp() throws Exception {
		coche = Coche.getCoche();
		observable = new Observable(coche);
		velocidad = new JLabel();
		oVelocidad = new ObservadorVelocidad(observable,velocidad);
	}

	@Test
	public void testObservadorVelocidad() {
		ObservadorVelocidadMedia aux = new ObservadorVelocidadMedia(observable,velocidad);
		assertNotNull(aux);	
	}

	@Test
	public void testUpdate() {
		
		coche.setVelocidad(555.5);
		
		DecimalFormat formateador = new DecimalFormat("########");
		String valor_esperado = formateador.format(observable.getCoche().getVelocidad()) + " Km/h";
		
		oVelocidad.update();
		
		assertEquals(valor_esperado,velocidad.getText());
	}

	@Test
	public void testEqualsObject() {
		ObservadorVelocidad obj3 = new ObservadorVelocidad(observable,velocidad);
		ObservadorVelocidad obj4 = new ObservadorVelocidad(observable,velocidad);
		ObservadorVelocidad obj5 = new ObservadorVelocidad(observable,velocidad);
		
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
