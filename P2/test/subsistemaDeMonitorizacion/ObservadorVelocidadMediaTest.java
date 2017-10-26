package subsistemaDeMonitorizacion;

import static org.junit.Assert.*;

import java.text.DecimalFormat;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import subsistemaDeControl.Coche;
import subsistemaDeMonitorizacion.Observable;
import subsistemaDeMonitorizacion.ObservadorVelocidadMedia;

public class ObservadorVelocidadMediaTest {
	
	Coche coche;
	Observable observable;
	JLabel velocidad_media;
	ObservadorVelocidadMedia oVelocidadMedia;

	@Before
	public void setUp() throws Exception {
		coche = Coche.getCoche();
		observable = new Observable(coche);
		velocidad_media = new JLabel();
		oVelocidadMedia = new ObservadorVelocidadMedia(observable,velocidad_media);
	}

	@Test
	public void testObservadorVelocidadMedia() {
		ObservadorVelocidadMedia oVelMed = new ObservadorVelocidadMedia(observable,velocidad_media);
		assertNotNull(oVelMed);	
	}

	@Test
	public void testUpdate() {
		
		coche.getMotor().setRotacionUltimoEncendido(500);
		coche.encenderMotor();
		coche.apagarMotor();
		
		DecimalFormat formateador = new DecimalFormat("########.#");
		String valor_esperado = formateador.format(observable.getCoche().getVelocidadMedia()) + " Km/h";
		
		oVelocidadMedia.update();
		
		assertEquals(valor_esperado,velocidad_media.getText());
	}

	@Test
	public void testEqualsObject() {
		ObservadorVelocidadMedia obj3 = new ObservadorVelocidadMedia(observable,velocidad_media);
		ObservadorVelocidadMedia obj4 = new ObservadorVelocidadMedia(observable,velocidad_media);
		ObservadorVelocidadMedia obj5 = new ObservadorVelocidadMedia(observable,velocidad_media);
		
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
