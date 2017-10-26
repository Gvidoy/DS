package subsistemaDeMonitorizacion;

import static org.junit.Assert.*;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.Test;

import subsistemaDeControl.Coche;
import subsistemaDeControl.EEstadoPalanca;

public class ObservadorPalancaTest {

	Coche coche;
	Observable observable;
	JLabel estado_palanca;
	ObservadorPalanca oPalanca;

	@Before
	public void setUp() throws Exception {
		coche = Coche.getCoche();
		observable = new Observable(coche);
		estado_palanca = new JLabel();
		oPalanca = new ObservadorPalanca(observable,estado_palanca);
	}

	@Test
	public void testObservadorPalanca() {
		ObservadorPalanca aux = new ObservadorPalanca(observable,estado_palanca);
		assertNotNull(aux);	
	}

	@Test
	public void testUpdate() {
		coche.getPalanca().setEstado(EEstadoPalanca.ACELERANDO);
		oPalanca.update();
		String valor_esperado = "ACELERAR";
		assertEquals(valor_esperado,estado_palanca.getText());
		
		coche.getPalanca().setEstado(EEstadoPalanca.APAGADO);
		oPalanca.update();
		valor_esperado = "PARAR";
		assertEquals(valor_esperado,estado_palanca.getText());
		
		coche.getPalanca().setEstado(EEstadoPalanca.AUTOMATICO);
		oPalanca.update();
		valor_esperado = "MANTENER";
		assertEquals(valor_esperado,estado_palanca.getText());
		
		coche.getPalanca().setEstado(EEstadoPalanca.REINICIAR);
		oPalanca.update();
		valor_esperado = "REINICIAR";
		assertEquals(valor_esperado,estado_palanca.getText());
	}

	@Test
	public void testEqualsObject() {
		ObservadorPalanca obj3 = new ObservadorPalanca(observable,estado_palanca);
		ObservadorPalanca obj4 = new ObservadorPalanca(observable,estado_palanca);
		ObservadorPalanca obj5 = new ObservadorPalanca(observable,estado_palanca);
		
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
