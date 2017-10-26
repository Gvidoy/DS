package subsistemaDeMonitorizacion;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import controlDeCrucero.VelocidadAutomatica;
import subsistemaDeControl.Coche;

public class ObservadorVelocidadAutomaticaTest {
	
	Coche coche;
	Observable observable;
	JLabel velocidad_crucero;
	ObservadorVelocidadAutomatica oVelocidadAutomatica;
	VelocidadAutomatica controlDeVelocidad;

	@Before
	public void setUp() throws Exception {
		coche = Coche.getCoche();
		observable = new Observable(coche);
		velocidad_crucero = new JLabel();
		controlDeVelocidad = new VelocidadAutomatica();
		oVelocidadAutomatica = new ObservadorVelocidadAutomatica(observable,velocidad_crucero,controlDeVelocidad);
	}

	@Test
	public void testObservadorVelocidadAutomatica() {
		ObservadorVelocidadAutomatica oVelAut = new ObservadorVelocidadAutomatica(observable,velocidad_crucero,controlDeVelocidad);
		assertNotNull(oVelAut);
	}

	@Test
	public void testUpdate() {
		coche.setVelocidad(777.7);
		coche.setVelocidadAutomatica();
		controlDeVelocidad.setVelocidadMantener(coche.getVelocidadAutomatica());
		DecimalFormat formateador = new DecimalFormat("########.#");
		String valor_esperado = formateador.format(observable.getCoche().getVelocidadAutomatica()) + " Km/h";
		oVelocidadAutomatica.update();
		assertEquals(valor_esperado,velocidad_crucero.getText());
		
		coche.setVelocidad(666.6);
		controlDeVelocidad.automatica(coche.getVelocidad());
		assertTrue(controlDeVelocidad.getEstadoAceleradorAuto());
		assertFalse(controlDeVelocidad.getEstadoFrenoAuto());
		
		coche.setVelocidad(888.8);
		controlDeVelocidad.automatica(coche.getVelocidad());
		assertFalse(controlDeVelocidad.getEstadoAceleradorAuto());
		assertTrue(controlDeVelocidad.getEstadoFrenoAuto());
	}

	@Test
	public void testEqualsObject() {
		ObservadorVelocidadAutomatica obj3 = new ObservadorVelocidadAutomatica(observable,velocidad_crucero,controlDeVelocidad);
		ObservadorVelocidadAutomatica obj4 = new ObservadorVelocidadAutomatica(observable,velocidad_crucero,controlDeVelocidad);
		ObservadorVelocidadAutomatica obj5 = new ObservadorVelocidadAutomatica(observable,velocidad_crucero,controlDeVelocidad);
		
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
