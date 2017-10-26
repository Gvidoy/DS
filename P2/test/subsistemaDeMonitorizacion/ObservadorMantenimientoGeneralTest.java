package subsistemaDeMonitorizacion;

import static org.junit.Assert.*;


import javax.swing.JProgressBar;

import org.junit.Before;
import org.junit.Test;

import subsistemaDeControl.Coche;
import subsistemaDeControl.ETiposNiveles;

public class ObservadorMantenimientoGeneralTest {
	private Observable observable;
	private JProgressBar estado_combustible;
	private Coche coche;
	private ObservadorMantenimientoGeneral obj1;
	@Before
	public void setUp() throws Exception {
		  coche = Coche.getCoche();
		  observable = new Observable(coche);
		  estado_combustible = new JProgressBar();
		  obj1 = new ObservadorMantenimientoGeneral(observable,estado_combustible);
	}

	@Test
	public void testOObservadorMantenimientoGeneral() {
		assertNotNull(obj1);
	}

	@Test
	public void testUpdate() {
		//Nivel intermedio
		coche.getNivel(ETiposNiveles.GENERAL).setRotacion(5);
		coche.getMotor().setRotacionTotalMotor(6);
	
		double valor = coche.getMotor().getRotacionTotalMotor() - coche.getNivel(ETiposNiveles.GENERAL).getRotacion();
		int valor_esperado = 100-(int)(obj1.porcentaje(valor, coche.getNivel(ETiposNiveles.GENERAL).getMAX()));
		
		obj1.update();
		assertEquals(valor_esperado,estado_combustible.getValue());
		
		coche.getMotor().setRotacionTotalMotor(160);
		
		//Nivel gastado
		valor_esperado = 0;
		obj1.update();
		
		assertEquals(valor_esperado,estado_combustible.getValue());
	}

	@Test
	public void testPorcentaje() {
		double valor_esperado = 50.0;
		assertEquals(valor_esperado,obj1.porcentaje(2, 4),0.0);
	}

	@Test
	public void testEqualsObject() {
		JProgressBar estado_combustible3 = new JProgressBar();
		JProgressBar estado_combustible4 = new JProgressBar();
		JProgressBar estado_combustible5 = new JProgressBar();
		ObservadorMantenimientoGeneral obj3 = new ObservadorMantenimientoGeneral(observable, estado_combustible3);
		ObservadorMantenimientoGeneral obj4 = new ObservadorMantenimientoGeneral(observable, estado_combustible4);
		ObservadorMantenimientoGeneral obj5 = new ObservadorMantenimientoGeneral(observable, estado_combustible5);
		
		
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
