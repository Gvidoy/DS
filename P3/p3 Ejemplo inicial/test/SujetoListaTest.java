import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SujetoListaTest {
	SujetoLista sujeto;
	Observador observador;
	
	
	@Before
	public void setUp() throws Exception {
		sujeto = new SujetoLista();
		observador = new Observador();
	}


	@Test
	public void insertarYAsertarObservadorInsertado(){

	   sujeto.insertar(observador);

	   assertEquals("Insertado en instancia de Sujeto",(((SujetoLista)sujeto).coleccionObservadores()).size(),1);

	   assertTrue("El objeto es un Observador",(((SujetoLista)sujeto).coleccionObservadores()).contains(observador));

	}
	@Test
	public void sujetoInsertaObservador() {

	    insertarYAsertarObservadorInsertado();

	}
	
	@Test
	public void sujetoEliminaObservador() {

		   insertarYAsertarObservadorInsertado();

		   sujeto.liberar(observador);

		   assertEquals("Observador eliminado",(((SujetoLista)sujeto).coleccionObservadores()).size(),0);

	}
	
	@Test
	public void sujetoNotificaObservador() {

		  assertFalse("No se ha llamado a actualizar()", ((Observador)observador).actualizarLlamado());

		  insertarYAsertarObservadorInsertado();

		  assertFalse("Todavia no se ha llamado a actualizar()",((Observador)observador).actualizarLlamado());

		  sujeto.notificar();

		  assertTrue("Se ha llamado ya a actualizar()",((Observador)observador).actualizarLlamado());

		}
	
	
}
