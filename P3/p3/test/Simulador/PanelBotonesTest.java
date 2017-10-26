package Simulador;

import static org.junit.Assert.*;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Before;
import org.junit.Test;

public class PanelBotonesTest {
	PanelBotones obj;
	Interfaz interfaz;
	private MouseEvent eventoRaton;
	private ActionEvent actionEvent;
	
	@Before
	public void setUp() throws Exception {
		interfaz = new Interfaz();
		interfaz.init();
		obj = new PanelBotones(interfaz);
		
		interfaz.init();
	}

	@Test
	public void testPanelBotones() {
		assertNotNull(obj);
	}



	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

}
