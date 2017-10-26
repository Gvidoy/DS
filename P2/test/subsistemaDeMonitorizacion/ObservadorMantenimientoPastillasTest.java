package subsistemaDeMonitorizacion;

import static org.junit.Assert.*;


import javax.swing.JProgressBar;

import org.junit.Before;
import org.junit.Test;

import subsistemaDeControl.Coche;
import subsistemaDeControl.ETiposNiveles;

public class ObservadorMantenimientoPastillasTest {
	private Observable observable;
	private JProgressBar estado_pastillas;
	private Coche coche;
	private ObservadorMantenimientoPastillas obj1;
	@Before
	public void setUp() throws Exception {
		  coche = Coche.getCoche();
		  observable = new Observable(coche);
		  estado_pastillas = new JProgressBar();
		  obj1 = new ObservadorMantenimientoPastillas(observable,estado_pastillas);
	}

	@Test
	public void testObservadorMantenimientoPastillas() {
		assertNotNull(obj1);
	}

	@Test
	public void testUpdate() {
		//Nivel intermedio
		coche.getNivel(ETiposNiveles.ACEITE).setRotacion(10);
		coche.getMotor().setRotacionTotalMotor(15);
	
		double valor = coche.getMotor().getRotacionTotalMotor() - coche.getNivel(ETiposNiveles.PASTILLAS).getRotacion();
		int valor_esperado = 100-(int)(obj1.porcentaje(valor, coche.getNivel(ETiposNiveles.PASTILLAS).getMAX()));
		
		obj1.update();
		assertEquals(valor_esperado,estado_pastillas.getValue());
		
		coche.getMotor().setRotacionTotalMotor(110);
		
		//Nivel gastado
		valor_esperado = 0;
		obj1.update();
		
		assertEquals(valor_esperado,estado_pastillas.getValue());
	}

	@Test
	public void testPorcentaje() {
		double valor_esperado = 50.0;
		assertEquals(valor_esperado,obj1.porcentaje(2, 4),0.0);
	}

	@Test
	public void testEqualsObject() {
		JProgressBar estado_pastillas3 = new JProgressBar();
		JProgressBar estado_pastillas4 = new JProgressBar();
		JProgressBar estado_pastillas5 = new JProgressBar();
		ObservadorMantenimientoPastillas obj3 = new ObservadorMantenimientoPastillas(observable, estado_pastillas3);
		ObservadorMantenimientoPastillas obj4 = new ObservadorMantenimientoPastillas(observable, estado_pastillas4);
		ObservadorMantenimientoPastillas obj5 = new ObservadorMantenimientoPastillas(observable, estado_pastillas5);
		
		
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
