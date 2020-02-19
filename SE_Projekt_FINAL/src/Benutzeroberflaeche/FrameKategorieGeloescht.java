package Benutzeroberflaeche;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Dies ist ein Best�tigungsfenster, welches kommt, wenn eine Kategorie erfolgreich gel�scht wurde
 * 
 * @author Marie Diekmann, Thi Thu Trinh
 *
 */
public class FrameKategorieGeloescht extends JFrame implements ActionListener{
	
	JLabel labelBestaetigung = new JLabel ("Die Kategorie wurde gel�scht",JLabel.CENTER);
	JButton btnOK = new JButton ("OK");
	JPanel unten = new JPanel ();//JPanel teilt GUI in verscheidene Bereiche auf
	
	/**
	 * Konstruktor f�r das Fenster, hier werden Werte f�r die Gr��e des Fensters gesetzt etc. 
	 * Au�erdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugef�gt
	 */
	public  FrameKategorieGeloescht (String fenstertitel) {
		super(fenstertitel);
		this.setSize(400,200); // Setzt die Groesse des Fensters
		this.setLocationRelativeTo(null); // setzt das Fenster in die Mitte beim oeffnen
		
		this.getContentPane().add(labelBestaetigung);
		this.getContentPane().add(unten, BorderLayout.SOUTH);
		
		this.unten.add(btnOK);
		
		btnOK.addActionListener(this);
	}

	/**
	 * Funktion gibt an was passiert, wenn der Button btnOK geklickt wird.
	 * Wenn der Button btnOK geklickt wird, dann wird ein Fenster FrameAuswahlfenster ge�ffnet und  das aktuelle Fenster wird geschlossen.
	 */
	public void actionPerformed (ActionEvent aktion){
		
		if(aktion.getSource() == this.btnOK){
			
			this.dispose();
			FrameAuswahlfenster frame = new FrameAuswahlfenster("Lagerverwaltung");
			frame.setVisible(true);	
		}
	}
}
