package subsistemaDeControl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MantenimientosTest {

	Mantenimientos obj1;
	Mantenimientos obj2;
	
	IMantenimiento creadorMantenimientos = new FactoriaNiveles();

	Nivel aceite = creadorMantenimientos.crearNivel(ETiposNiveles.ACEITE);
	Nivel pastillas = creadorMantenimientos.crearNivel(ETiposNiveles.PASTILLAS);
	Nivel general = creadorMantenimientos.crearNivel(ETiposNiveles.GENERAL);
	Nivel combustible = creadorMantenimientos.crearNivel(ETiposNiveles.COMBUSTIBLE);
	
	@Before
	public void setUp() throws Exception {
		this.obj1 = new Mantenimientos();
		this.obj2 = new Mantenimientos();
	}

	@Test
	public void testMantenimientos() {
		assertNotNull(obj1);
		assertNotNull(obj2);
	}

	@Test
	public void testGetNivel() {
		obj1.addNivel(aceite);
		obj1.addNivel(pastillas);
		obj1.addNivel(general);
		obj1.addNivel(combustible);
		
		assertEquals(aceite,obj1.getNivel(ETiposNiveles.ACEITE));
		assertEquals(pastillas,obj1.getNivel(ETiposNiveles.PASTILLAS));
		assertEquals(general,obj1.getNivel(ETiposNiveles.GENERAL));
		assertEquals(combustible,obj1.getNivel(ETiposNiveles.COMBUSTIBLE));
		
	}

	@Test
	public void testAddNivel() {
		obj2.addNivel(aceite);
		obj2.addNivel(pastillas);
		obj2.addNivel(general);
		obj2.addNivel(combustible);
		
		assertEquals(aceite,obj2.getNivel(ETiposNiveles.ACEITE));
		assertEquals(pastillas,obj2.getNivel(ETiposNiveles.PASTILLAS));
		assertEquals(general,obj2.getNivel(ETiposNiveles.GENERAL));
		assertEquals(combustible,obj2.getNivel(ETiposNiveles.COMBUSTIBLE));
	}
	
	@Test
	public void testEqualsObject() {
		Mantenimientos obj3 = new Mantenimientos();
		Mantenimientos obj4 = new Mantenimientos();
		Mantenimientos obj5 = new Mantenimientos();
		
		
		//Comprobamos que se han creado bien En el Test del constructor
	
		//Cambiamos los objetos para que no sean iguales
		
		obj3.addNivel(aceite);
		obj4.addNivel(pastillas);
		obj4.addNivel(aceite);

		obj5.addNivel(general);
		
		
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
