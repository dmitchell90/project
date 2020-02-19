package Benutzeroberflaeche;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Dies ist ein Best�tigungsfenster, welches kommt, wenn ein Artikel erfolgreich gespeichert wurde
 * 
 * @author Marie Diekmann, Thi Thu Trinh
 *
 */
public class FrameKategorieGespeichert extends JFrame implements ActionListener{
	
	JLabel labelBestaetigung = new JLabel ("Die Kategorie wurde gespeichert!",JLabel.CENTER);
	JButton btnOK = new JButton ("OK");
	JPanel unten = new JPanel ();
	
	/**
	 * Konstruktor f�r das Fenster, hier werden Werte f�r die Gr��e des Fensters gesetzt etc. 
	 * Au�erdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugef�gt
	 */
	public  FrameKategorieGespeichert (String fenstertitel) {
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
	 * Wenn der Button btnOK geklickt wird, dann wird das aktuelle Fenster wird geschlossen.
	 */
	public void actionPerformed (ActionEvent aktion){
		
		if(aktion.getSource() == this.btnOK){
			
			this.dispose();
		}
	}
}