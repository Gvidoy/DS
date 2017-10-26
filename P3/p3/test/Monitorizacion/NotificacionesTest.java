package Monitorizacion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ControlVelocidad.Eje;

public class NotificacionesTest {
	public Notificaciones obj;
	@Before
	public void setUp() throws Exception {
		obj = new Notificaciones();
	}

	@Test
	public void testNotificaciones() {
		assertNotNull(obj);		
		assertEquals("Atributo 1 constructor",500000, obj.get_inicialAceite());
		assertEquals("Atributo 2 constructor",1000000, obj.get_inicialPastillas());
		assertEquals("Atributo 3 constructor",10000000, obj.get_inicialRevision());
		assertEquals("Atributo 4 constructor",0,obj.leerRevolAceite());
		assertEquals("Atributo 5 constructor",0,obj.get_ateriorRevolAceite());
		assertEquals("Atributo 6 constructor",0,obj.leerRevolPastillas());
		assertEquals("Atributo 7 constructor",0,obj.get_ateriorRevolPastillas());
		assertEquals("Atributo 8 constructor",0,obj.leerRevolRevision());
		assertEquals("Atributo 9 constructor",0,obj.get_anteriorRevolRevision());

		
	}

	@Test
	public void testActualizarNotificaciones() {
		Eje eje = new Eje();
		obj.actualizarNotificaciones(eje);
		assertEquals("Atributo 1 ActualizarNotificaciones",0,obj.get_revActuales());
		assertEquals("Atributo 2 ActualizarNotificaciones",0,obj.leerRevolAceite());
		assertEquals("Atributo 3 ActualizarNotificaciones",0,obj.leerRevolPastillas());
		assertEquals("Atributo 4 ActualizarNotificaciones",0,obj.leerRevolRevision());
	}

	@Test
	public void testIniciarAceite() {
		obj.iniciarAceite();
		assertEquals("Iniciar Aceite",obj.get_revActuales(),obj.get_ateriorRevolAceite());

	}

	@Test
	public void testIniciarPastillas() {
		obj.iniciarAceite();
		assertEquals("Iniciar Pastillas",obj.get_revActuales(),obj.get_ateriorRevolPastillas());
	}

	@Test
	public void testIniciarRevision() {
		obj.iniciarAceite();
		assertEquals("Iniciar Pastillas",obj.get_revActuales(),obj.get_anteriorRevolRevision());
	}

	@Test
	public void testNotificarAceite() {
		assertFalse(obj.notificarAceite());
	}

	@Test
	public void testNotificarPastillas() {
		assertFalse(obj.notificarPastillas());
	}

	@Test
	public void testNotificarRevision() {
		assertFalse(obj.notificarRevision());
	}

	@Test
	public void testEqualsObject() {
		Notificaciones obj1 = new Notificaciones();
		Notificaciones obj2 = new Notificaciones();
		Notificaciones obj3 = new Notificaciones();
		
		//Comprobamos que se han inicializado bien los valores en el test del constructor

		assertNotNull(obj1); //Comprobamos que no son nulos
		assertNotNull(obj2); //Comprobamos que no son nulos
		assertNotNull(obj3); //Comprobamos que no son nulos
		
		assertEquals(obj1,obj1); //Comprobamos que son iguales a sí mismos
		assertEquals(obj2,obj2); // P.reflexiva
		assertEquals(obj3,obj3); 
		
		assertEquals(obj1,obj2); // P.Transitiva
		assertEquals(obj2,obj3);
		assertEquals(obj3,obj1);
		
		assertEquals(obj1,obj2); // P.Simetrica
		assertEquals(obj2,obj1);
	}

}
