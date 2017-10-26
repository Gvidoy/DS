
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class PanelBotones extends JPanel {

	private javax.swing.JButton BotonAcelerar;
	private javax.swing.JToggleButton BotonEncender;
	private javax.swing.JLabel EtiqMostrarEstado;
	private JPanel Panel1;
	private JPanel Panel2;

	
	
	public PanelBotones() {

		//Botones
		this.BotonAcelerar = new javax.swing.JButton("Acelerar");
		this.BotonAcelerar.setFont(new Font("Arial", Font.ITALIC, 12));
		this.BotonAcelerar.setForeground(Color.red);
		
		this.BotonEncender = new javax.swing.JToggleButton("Encender");
		this.BotonEncender.setFont(new Font("Arial", Font.BOLD, 12));
		this.BotonEncender.setForeground(Color.blue);
		
		//Etiqueta
		this.EtiqMostrarEstado = new javax.swing.JLabel("APAGADO");
		this.EtiqMostrarEstado.setFont(new Font("Arial", Font.BOLD, 12));
		this.EtiqMostrarEstado.setForeground(Color.RED);
		this.EtiqMostrarEstado.setBounds(12, 12, 426, 51);
		this.EtiqMostrarEstado.setHorizontalAlignment(SwingConstants.CENTER);
		
		setLayout(null);
		
		//Paneles
		this.Panel1 = new JPanel();
		this.Panel1.setBounds(0, 0, 450, 75);
		this.Panel1.setLayout(null);
		this.Panel1.add(EtiqMostrarEstado);
		add(Panel1);
		
		this.Panel2 = new JPanel();
		this.Panel2.setBounds(0, 82, 450, 75);
		this.Panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.Panel2.add(BotonEncender);
		this.Panel2.add(BotonAcelerar);
		add(Panel2);
		
		
		
		BotonAcelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAcelerarActionPerformed(evt);
            }
        });
		
		BotonEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEncenderActionPerformed(evt);
            }
        });
		
	}
	
	synchronized private void BotonEncenderActionPerformed(java.awt.event.ActionEvent evt) {
		
		if (this.BotonEncender.isSelected()) {
			this.BotonEncender.setText("Apagar");
			this.EtiqMostrarEstado.setText("ENCENDIDO");
			this.EtiqMostrarEstado.setForeground(Color.blue);
			this.BotonEncender.setForeground(Color.red);
			repaint();
		}
		else {
			this.BotonEncender.setText("Encender");
			this.EtiqMostrarEstado.setText("APAGADO");
			this.EtiqMostrarEstado.setForeground(Color.red);
			this.BotonEncender.setForeground(Color.blue);
			repaint();
		}
		
	}
	
	synchronized private void BotonAcelerarActionPerformed(java.awt.event.ActionEvent evt) {
		
		if (this.BotonEncender.isSelected()) {
			
			this.EtiqMostrarEstado.setText("ACELERANDO ");
			this.EtiqMostrarEstado.setForeground(Color.green);
			repaint();
		}
		
	}

}

