package subsistemaDeControl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FactoriaNivelesTest {

	private IMantenimiento creadorMantenimientos;
	
	@Before
	public void setUp() throws Exception {
		creadorMantenimientos = new FactoriaNiveles();
	}

	@Test
	public void testCrearNivel() {
		
		Nivel aceite = creadorMantenimientos.crearNivel(ETiposNiveles.ACEITE);
		Nivel pastillas = creadorMantenimientos.crearNivel(ETiposNiveles.PASTILLAS);
		Nivel general = creadorMantenimientos.crearNivel(ETiposNiveles.GENERAL);
		Nivel combustible = creadorMantenimientos.crearNivel(ETiposNiveles.COMBUSTIBLE);
		
		Nivel aceiteEsperado = new NivelAceite();
		Nivel pastillasEsperado = new NivelPastillas();
		Nivel generalEsperado = new NivelGeneral();
		Nivel combustibleEsperado = new NivelCombustible();
		
		
		assertEquals(aceiteEsperado,aceite);
		assertEquals(pastillasEsperado,pastillas);
		assertEquals(generalEsperado,general);
		assertEquals(combustibleEsperado,combustible);
		
		
	}

}
