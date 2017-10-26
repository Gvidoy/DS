package Simulador;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class ListaObservadoresObservablesTest {
	private ListaObservadoresObservables obj;
	private PanelEtiquetas observador;

	@Before
	public void setUp() throws Exception {
		
		obj = new ListaObservadoresObservables();
		Interfaz interfaz = new Interfaz();
		observador = new PanelEtiquetas(interfaz); 
		
	}

	@Test
	public void insertarYAsertarObservadorInsertado(){

	   obj.agregarObservador(observador);

	   assertEquals("Insertado en instancia de Sujeto",(((ListaObservadoresObservables)obj).coleccionObservadores()).size(),1);

	   assertTrue("El objeto es un Observador",(((ListaObservadoresObservables)obj).coleccionObservadores()).contains(observador));

	}
	@Test
	public void sujetoInsertaObservador() {

	    insertarYAsertarObservadorInsertado();

	}
	
	@Test
	public void sujetoEliminaObservador() {

		   insertarYAsertarObservadorInsertado();

		   obj.eliminarObservador(observador);

		   assertEquals("Observador eliminado",(((ListaObservadoresObservables)obj).coleccionObservadores()).size(),0);

	}
	
	@Test
	public void sujetoNotificaObservador() {

		  assertFalse("No se ha llamado a actualizar()", observador.actualizarLlamado());

		  insertarYAsertarObservadorInsertado();

		  assertFalse("Todavia no se ha llamado a actualizar()",observador.actualizarLlamado());

		  obj.notificarObservador();

		  assertTrue("Se ha llamado ya a actualizar()",observador.actualizarLlamado());

		}

}
