package subsistemaDeControl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NivelesTest {
	
	Nivel nivelAceite;
	Nivel nivelCombustible;

	@Before
	public void setUp() throws Exception {
		nivelAceite = new NivelAceite();
		nivelCombustible = new NivelCombustible();
	}

	@Test
	public void testGetMAX() {
		Nivel nAceite = new NivelAceite();
		Nivel nCombustible = new NivelCombustible();
		Nivel nPastillas = new NivelPastillas();
		Nivel nGeneral = new NivelGeneral();
		
		assertEquals(12500/400,nAceite.getMAX());
		assertEquals(833/100,nCombustible.getMAX());
		assertEquals(40000/400,nPastillas.getMAX());
		assertEquals(50000/400,nGeneral.getMAX());
	}

	@Test
	public void testNivelCombustible() {
		NivelCombustible aux = new NivelCombustible();
		assertNotNull(aux);
		assertTrue(aux.getMAX() == 833/100);
		assertTrue(aux.getRotacion() == 0);
	}

	@Test
	public void testGetTipo() {
		assertTrue(nivelAceite.getTipo() == ETiposNiveles.ACEITE);
	}

	@Test
	public void testGetRotacion() {
		assertTrue(nivelCombustible.getRotacion() == 0);
	}

	@Test
	public void testSetRotacion() {
		double valor_esperado = 100.5;
		nivelCombustible.setRotacion(valor_esperado);
		assertEquals(valor_esperado,nivelCombustible.getRotacion(),0.0);
	}
	
	@Test
	public void testEquals(){
		Nivel obj3 = new NivelCombustible();
		Nivel obj4 = new NivelCombustible();
		Nivel obj5 = new NivelCombustible();
		
		// Constructor ya comprobado
		assertNotNull(obj3); //Comprobamos que no son nulos
		assertNotNull(obj4); //Comprobamos que no son nulos
		assertNotNull(obj5); //Comprobamos que no son nulos
		
		assertEquals(obj3,obj3); //Comprobamos que son iguales a si mismo
		assertEquals(obj4,obj4); // P.reflexiva
		assertEquals(obj5,obj5); 
		
		assertEquals(obj3,obj4); // P.Transitiva
		assertEquals(obj4,obj5);
		assertEquals(obj3,obj5);
		
		assertEquals(obj5,obj3); // P.Simetrica
		assertEquals(obj3,obj5);
		
		
	}

}
