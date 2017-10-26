package Simulador;
import javax.swing.*;
import ControlVelocidad.*;
import Monitorizacion.*;

@SuppressWarnings("serial")
public class Interfaz extends JApplet {
	JLabel etiquetaVelAuto, etiquetaEstado;
	Simulacion simulacion;
	Monitorizacion monitor;
	ControlVelocidad control;
	public void init(){
		this.setSize(800,600);
	}
	public Interfaz(){
		PanelEtiquetas panelE = new PanelEtiquetas(this);
		PanelBotones panelB = new PanelBotones(this);
		simulacion =new Simulacion(panelE,panelB);
		control = new ControlVelocidad();
		monitor = new Monitorizacion(control.eje);		
		panelE.aniadirComponentes(monitor, control);
		panelB.aniadirComponentes(monitor, control);
		simulacion.start();			
		control.start();
		monitor.start();
		add(panelB);		
		add(panelE);
		setVisible(true);
		destroy();
	}
	//Metodo equalr sobreescrito
	@Override 
	public boolean equals(Object obj){
		boolean result = false;
		
		if(obj instanceof Interfaz){
			Interfaz aux = (Interfaz) obj;
		
			if(this.simulacion.equals(aux.simulacion))
						result = true;
		}
		return result;
	}
}