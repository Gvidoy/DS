package interfazGrafica;
import subsistemaDeControl.Coche;
import subsistemaDeControl.EEstadoPalanca;
import subsistemaDeControl.ETiposNiveles;
import subsistemaDeMonitorizacion.*;
import controlDeCrucero.VelocidadAutomatica;
import simuladorVelocidad.SimuladorVelocidad;

@SuppressWarnings("serial")
public class SimuladorControlVehiculo extends javax.swing.JApplet {

	// Variables declaration
	private Coche coche;
	VelocidadAutomatica controlDeVelocidad;
	
	//Declaracion observable
	private Observable observableI;

    private javax.swing.JProgressBar barraAceite;
    private javax.swing.JProgressBar barraCombustible;
    private javax.swing.JProgressBar barraPastillas;
    private javax.swing.JProgressBar barraRevision;
    private javax.swing.JButton botonAceite;
    private javax.swing.JToggleButton botonApagarMotor;
    private javax.swing.JButton botonCombustible;
    private javax.swing.JToggleButton botonEncenderMotor;
    private javax.swing.JToggleButton botonFreno;
    private javax.swing.JButton botonPastillas;
    private javax.swing.JButton botonRevision;
    private javax.swing.JLabel distancia_recorrida;
    private javax.swing.JLabel estado_freno;
    private javax.swing.JLabel estado_motor;
    private javax.swing.JLabel estado_palanca;
    private javax.swing.JLabel etiquetaDistanciaRecorrida;
    private javax.swing.JLabel etiquetaEstadoFreno;
    private javax.swing.JLabel etiquetaEstadoMotor;
    private javax.swing.JLabel etiquetaEstadoPalanca;
    private javax.swing.JLabel etiquetaRevolucionesActuales;
    private javax.swing.JLabel etiquetaTiempoEnMarcha;
    private javax.swing.JLabel etiquetaVelocidadCrucero;
    private javax.swing.JLabel etiquetaVelocidadMedia;
    private javax.swing.JToggleButton palancaAcelerar;
    private javax.swing.JToggleButton palancaMantener;
    private javax.swing.JToggleButton palancaParar;
    private javax.swing.JToggleButton palancaReiniciar;
    private javax.swing.JLabel revoluciones_actuales;
    private javax.swing.JLabel tiempo_en_marcha;
    private javax.swing.JLabel velocidad_actual;
    private javax.swing.JLabel velocidad_crucero;
    private javax.swing.JLabel velocidad_media;
    // End of variables declaration  
    
	@Override
	public void init() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Metal".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(SimuladorControlVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SimuladorControlVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SimuladorControlVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SimuladorControlVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the applet */
		try {
			java.awt.EventQueue.invokeAndWait(new Runnable() {
				public void run() {
					// ----------      INICIALIZAR    ------------  
					coche = Coche.getCoche();
					controlDeVelocidad =new VelocidadAutomatica();
					
					observableI = new Observable(coche);
					SimuladorVelocidad simulador = new SimuladorVelocidad();
					simulador.start();
					initComponents();
					inicializarValores();
					
					new ObservadorVelocidad(observableI,velocidad_actual);
					new ObservadorDeRevoluciones(observableI, revoluciones_actuales);
					new ObservadorRotacionesTotales(observableI, distancia_recorrida);
					new ObservadorDeEstadoMotor(observableI, estado_motor);
					new ObservadorFreno(observableI, estado_freno);
					new ObservadorAceleracion(observableI, simulador);
					new ObservadorPalanca (observableI, estado_palanca);
					new ObservadorVelocidadAutomatica(observableI,velocidad_crucero,controlDeVelocidad);
					new ObservadorTiempoTotal(observableI,tiempo_en_marcha);
					
					new ObservadorVelocidadMedia (observableI, velocidad_media);
					new ObservadorMantenimientoAceite (observableI, barraAceite);
					new ObservadorMantenimientoPastillas (observableI, barraPastillas);
					new ObservadorMantenimientoGeneral (observableI, barraRevision);
					new ObservadorMantenimientoCombustible (observableI, barraCombustible);
					
					observableI.start();
					

					//---------                        -----------
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
                    
    private void inicializarValores() {

        revoluciones_actuales.setText(Double.toString(coche.getMotor().getRevolucionActual()));
        
        botonApagarMotor.setSelected(true);
        botonApagarMotor.setEnabled(false);
        botonEncenderMotor.setEnabled(true);
        botonEncenderMotor.setSelected(false);
        botonFreno.setEnabled(false);
        botonFreno.setSelected(false);
        
        palancaAcelerar.setEnabled(false);
        palancaReiniciar.setEnabled(false);
        palancaParar.setEnabled(false);
        palancaMantener.setEnabled(false);
        
        palancaAcelerar.setSelected(false);
        palancaReiniciar.setSelected(false);
        palancaParar.setSelected(true);
        palancaMantener.setSelected(false);
        
        velocidad_actual.setText("-");     
        estado_freno.setText("-");
        estado_motor.setText("-");
        estado_palanca.setText("-");
        tiempo_en_marcha.setText("-");
        velocidad_crucero.setText("-");
        velocidad_media.setText("-");
        revoluciones_actuales.setText("-");
        distancia_recorrida.setText("-");
        
        botonCombustible.setEnabled(false);
        botonAceite.setEnabled(false);
        botonPastillas.setEnabled(false);
        botonRevision.setEnabled(false);
        
        barraCombustible.setValue(0);
        barraAceite.setValue(0);
        barraPastillas.setValue(0);
        barraRevision.setValue(0);
    }

    private void palancaPararActionPerformed() {                                                   
    	palancaParar.setSelected(true);
    	palancaParar.setEnabled(false);
    	
    	palancaAcelerar.setSelected(false);
    	palancaAcelerar.setEnabled(true);
    	
    	palancaReiniciar.setSelected(false);
    	palancaReiniciar.setEnabled(true);
    	
    	palancaMantener.setSelected(false);
    	palancaMantener.setEnabled(false);
    	
    	coche.getPalanca().setEstado(EEstadoPalanca.APAGADO);
    	coche.getAcelerador().setEstado(false);
    }                                                  

    private void palancaAcelerarActionPerformed() {
		palancaAcelerar.setSelected(true);
		palancaAcelerar.setEnabled(false);
		
		palancaMantener.setEnabled(true);
		palancaMantener.setSelected(false);
		
		palancaParar.setSelected(false);
		palancaParar.setEnabled(true);
		
		palancaReiniciar.setSelected(false);
		palancaReiniciar.setEnabled(false);
		
		coche.getAcelerador().setEstado(true);
		coche.getPalanca().setEstado(EEstadoPalanca.ACELERANDO);
    }                                               

    private void palancaMantenerActionPerformed() {                                                  
    	palancaAcelerar.setSelected(false);
    	palancaAcelerar.setEnabled(true);
    	
    	palancaMantener.setSelected(true);
    	palancaMantener.setEnabled(false);
    	
    	palancaParar.setEnabled(true);
    	palancaParar.setSelected(false);
    	
    	palancaReiniciar.setEnabled(false);
    	palancaReiniciar.setSelected(false);
    	
    	coche.getPalanca().setEstado(EEstadoPalanca.AUTOMATICO);
    	coche.setVelocidadAutomatica();
    	controlDeVelocidad.setVelocidadMantener(coche.getVelocidad());
    }                                                 

    private void palancaReiniciarActionPerformed() {        
    	palancaReiniciar.setSelected(false);
    	if (coche.getFreno().getEstado() == false){
	    	palancaAcelerar.setSelected(false);
	    	palancaAcelerar.setEnabled(true);
	    	
	    	palancaMantener.setSelected(false);
	    	palancaMantener.setEnabled(false);
	    	
	    	palancaParar.setEnabled(true);
	    	palancaParar.setSelected(false);
	    	
	    	palancaReiniciar.setSelected(true);
	    	palancaReiniciar.setEnabled(false);
	    	
	    	coche.getPalanca().setEstado(EEstadoPalanca.REINICIAR);
    	}
    }                                   

    private void botonEncenderMotorActionPerformed() {     
    	botonApagarMotor.setSelected(false);
    	botonEncenderMotor.setSelected(true);
    	botonEncenderMotor.setEnabled(false);
    	palancaAcelerar.setEnabled(true);
    	botonApagarMotor.setEnabled(true);
    	botonFreno.setEnabled(true);
    	
    	botonCombustible.setEnabled(true);
        botonAceite.setEnabled(true);
        botonPastillas.setEnabled(true);
        botonRevision.setEnabled(true);
    	
    	coche.encenderMotor();
    }                                                 

    private void botonApagarMotorActionPerformed() { 
    	
    	coche.getAcelerador().setEstado(false);
    	coche.getFreno().setEstado(false);
    	coche.getPalanca().setEstado(EEstadoPalanca.APAGADO);
    	
        coche.apagarMotor();
    	inicializarValores();
    }                                                

    private void botonFrenoActionPerformed() {
    	coche.getFreno().setEstado(!coche.getFreno().getEstado());
    }                                          

    private void botonCombustibleActionPerformed() {                                                 
        coche.rellenarNivel(ETiposNiveles.COMBUSTIBLE);
    }                                                

    private void botonAceiteActionPerformed() {                                            
        coche.rellenarNivel(ETiposNiveles.ACEITE);
    }                                           

    private void botonPastillasActionPerformed() {                                               
        coche.rellenarNivel(ETiposNiveles.PASTILLAS);
    }                                              

    private void botonRevisionActionPerformed() {                                              
        coche.rellenarNivel(ETiposNiveles.GENERAL);
    }                                             

    private void velocidad_actualPropertyChange() {                                                
        if (!velocidad_actual.getText().contentEquals("0 Km/h"))
        	botonApagarMotor.setEnabled(false);
        else if(coche.getMotor().getEstado() == true)
        	botonApagarMotor.setEnabled(true);
    }   
    
    private void estado_palancaPropertyChange(java.beans.PropertyChangeEvent evt) {                                                
    	if (botonEncenderMotor.isSelected()) {
	    		if (coche.getPalanca().getEstado() == EEstadoPalanca.ACELERANDO)
	    		this.palancaAcelerarActionPerformed();
	    	else if (coche.getPalanca().getEstado() == EEstadoPalanca.APAGADO)
	    		this.palancaPararActionPerformed();
	    	else if (coche.getPalanca().getEstado() == EEstadoPalanca.AUTOMATICO)
	    		this.palancaMantenerActionPerformed();
    	}
    }   
    
    private void initComponents() {

        palancaAcelerar = new javax.swing.JToggleButton();
        palancaParar = new javax.swing.JToggleButton();
        palancaMantener = new javax.swing.JToggleButton();
        palancaReiniciar = new javax.swing.JToggleButton();
        etiquetaRevolucionesActuales = new javax.swing.JLabel();
        revoluciones_actuales = new javax.swing.JLabel();
        velocidad_actual = new javax.swing.JLabel();
        etiquetaVelocidadCrucero = new javax.swing.JLabel();
        velocidad_crucero = new javax.swing.JLabel();
        botonFreno = new javax.swing.JToggleButton();
        botonEncenderMotor = new javax.swing.JToggleButton();
        botonApagarMotor = new javax.swing.JToggleButton();
        etiquetaDistanciaRecorrida = new javax.swing.JLabel();
        etiquetaVelocidadMedia = new javax.swing.JLabel();
        etiquetaTiempoEnMarcha = new javax.swing.JLabel();
        etiquetaEstadoPalanca = new javax.swing.JLabel();
        etiquetaEstadoMotor = new javax.swing.JLabel();
        etiquetaEstadoFreno = new javax.swing.JLabel();
        botonRevision = new javax.swing.JButton();
        botonPastillas = new javax.swing.JButton();
        botonAceite = new javax.swing.JButton();
        botonCombustible = new javax.swing.JButton();
        barraAceite = new javax.swing.JProgressBar();
        barraPastillas = new javax.swing.JProgressBar();
        barraRevision = new javax.swing.JProgressBar();
        barraCombustible = new javax.swing.JProgressBar();
        velocidad_media = new javax.swing.JLabel();
        tiempo_en_marcha = new javax.swing.JLabel();
        distancia_recorrida = new javax.swing.JLabel();
        estado_palanca = new javax.swing.JLabel();
        estado_freno = new javax.swing.JLabel();
        estado_motor = new javax.swing.JLabel();

        palancaAcelerar.setText("Acelerar");
        palancaAcelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palancaAcelerarActionPerformed();
            }
        });

        palancaParar.setText("Parar");
        palancaParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palancaPararActionPerformed();
            }
        });

        palancaMantener.setText("Mantener");
        palancaMantener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palancaMantenerActionPerformed();
            }
        });

        palancaReiniciar.setText("Reiniciar");
        palancaReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palancaReiniciarActionPerformed();
            }
        });

        etiquetaRevolucionesActuales.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaRevolucionesActuales.setText("RPM:");

        revoluciones_actuales.setForeground(new java.awt.Color(40, 40, 187));
        revoluciones_actuales.setText("-");

        velocidad_actual.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        velocidad_actual.setForeground(new java.awt.Color(40, 40, 187));
        velocidad_actual.setText("0 km/h");
        velocidad_actual.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                velocidad_actualPropertyChange();
            }
        });

        etiquetaVelocidadCrucero.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaVelocidadCrucero.setText("Velocidad crucero:");

        velocidad_crucero.setForeground(new java.awt.Color(40, 40, 187));
        velocidad_crucero.setText("-");

        botonFreno.setText("Pisar Freno");
        botonFreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFrenoActionPerformed();
            }
        });

        botonEncenderMotor.setText("Encender motor");
        botonEncenderMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEncenderMotorActionPerformed();
            }
        });

        botonApagarMotor.setText("Apagar motor");
        botonApagarMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonApagarMotorActionPerformed();
            }
        });

        etiquetaDistanciaRecorrida.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaDistanciaRecorrida.setText("Distancia recorrida:");

        etiquetaVelocidadMedia.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaVelocidadMedia.setText("Velocidad media:");

        etiquetaTiempoEnMarcha.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaTiempoEnMarcha.setText("Tiempo en marcha:");

        etiquetaEstadoPalanca.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaEstadoPalanca.setText("Estado palanca:");

        etiquetaEstadoMotor.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaEstadoMotor.setText("Estado motor:");

        etiquetaEstadoFreno.setForeground(new java.awt.Color(0, 0, 0));
        etiquetaEstadoFreno.setText("Estado freno:");

        botonRevision.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        botonRevision.setText("Revisión general");
        botonRevision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRevisionActionPerformed();
            }
        });

        botonPastillas.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        botonPastillas.setText("Cambiar pastillas");
        botonPastillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPastillasActionPerformed();
            }
        });

        botonAceite.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        botonAceite.setText("Rellenar aceite");
        botonAceite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceiteActionPerformed();
            }
        });

        botonCombustible.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        botonCombustible.setText("Repostar combustible");
        botonCombustible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCombustibleActionPerformed();
            }
        });

        barraAceite.setValue(50);
		barraAceite.setString("¡Recarga el aceite!");

        barraPastillas.setValue(50);
		barraPastillas.setString("¡Cambia las pastillas!");

        barraRevision.setValue(50);
        barraRevision.setString("¡Llevar a revisión!");

        barraCombustible.setValue(50);
		barraCombustible.setString("¡Sin combustible!");

        velocidad_media.setForeground(new java.awt.Color(40, 40, 187));
        velocidad_media.setText("-");

        tiempo_en_marcha.setForeground(new java.awt.Color(40, 40, 187));
        tiempo_en_marcha.setText("-");

        distancia_recorrida.setForeground(new java.awt.Color(40, 40, 187));
        distancia_recorrida.setText("-");

        estado_palanca.setForeground(new java.awt.Color(40, 40, 187));
        estado_palanca.setText("-");
        estado_palanca.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                estado_palancaPropertyChange(evt);
            }
        });

        estado_freno.setForeground(new java.awt.Color(40, 40, 187));
        estado_freno.setText("-");

        estado_motor.setForeground(new java.awt.Color(40, 40, 187));
        estado_motor.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(botonFreno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(etiquetaVelocidadCrucero, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(velocidad_crucero))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaEstadoFreno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estado_freno))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaRevolucionesActuales)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(revoluciones_actuales)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(botonApagarMotor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonEncenderMotor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaEstadoMotor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estado_motor)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(palancaAcelerar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(palancaParar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(palancaMantener, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(palancaReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(velocidad_actual)))
                        .addGap(25, 25, 25)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonAceite, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonPastillas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonRevision, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(barraRevision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraPastillas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraAceite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(barraCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaDistanciaRecorrida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(distancia_recorrida))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaEstadoPalanca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estado_palanca))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etiquetaTiempoEnMarcha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tiempo_en_marcha))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(etiquetaVelocidadMedia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(velocidad_media)))
                        .addGap(0, 0, 0)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaVelocidadMedia)
                            .addComponent(velocidad_media))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaTiempoEnMarcha)
                            .addComponent(tiempo_en_marcha))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etiquetaDistanciaRecorrida)
                            .addComponent(distancia_recorrida)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(barraCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, 0)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(botonAceite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(barraAceite, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(botonPastillas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(barraPastillas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, 0)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(botonRevision, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(barraRevision, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(palancaAcelerar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(velocidad_actual)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(palancaParar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(palancaMantener, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(palancaReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(etiquetaEstadoPalanca)
                                .addComponent(estado_palanca))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addComponent(botonEncenderMotor)
                                    .addGap(0, 0, 0)
                                    .addComponent(botonApagarMotor))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(etiquetaVelocidadCrucero)
                                        .addComponent(velocidad_crucero))
                                    .addGap(23, 23, 23)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(etiquetaRevolucionesActuales)
                                        .addComponent(revoluciones_actuales))
                                    .addGap(18, 18, 18)
                                    .addComponent(botonFreno)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(etiquetaEstadoFreno)
                                        .addComponent(estado_freno)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaEstadoMotor)
                    .addComponent(estado_motor)))
        );
    }            
}

