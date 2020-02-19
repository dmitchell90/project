package Benutzeroberflaeche;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Dies ist ein Best�tigungsfenster, welches kommt, wenn ein Artikel erfolgreich gel�scht wurde
 * 
 * @author Marie Diekmann, Thi Thu Trinh
 *
 */
public class FrameKategorieLoeschen extends JFrame implements ActionListener{
	
	JLabel labelAbfrage = new JLabel ("Sind Sie sich sicher, dass Sie diese Kategorie l�schen m�chten?",JLabel.CENTER);
	JButton btnJa = new JButton ("Ja");
	JButton btnNein = new JButton ("Nein");
	JPanel unten = new JPanel();//JPanel teilt GUI in verscheidene Bereiche auf
	
	
	/**
	 * Konstruktor f�r das Fenster, hier werden Werte f�r die Gr��e des Fensters gesetzt etc. 
	 * Au�erdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugef�gt
	 */
	public  FrameKategorieLoeschen (String fenstertitel) {
		super(fenstertitel);
		this.setSize(400,200); // Setzt die Groesse des Fensters
		this.setLocationRelativeTo(null); // setzt das Fenster in die Mitte beim oeffnen
		
		
		this.getContentPane().add(labelAbfrage);
		this.getContentPane().add(unten, BorderLayout.SOUTH);
		
		this.unten.add(btnJa);
		this.unten.add(btnNein);
		
		btnJa.addActionListener(this);
		btnNein.addActionListener(this);
	}

	/**
	 * Funktion gibt an was passiert, wenn der Button btnNein bzw. btnJa geklickt wird.
	 * Wenn der Button btnNein geklickt wird, dann wird das aktuelle Fenster wird geschlossen.
	 * Wenn der Button btnJa geklickt wird, dann wird das Fenster FrameKategorieGeloescht ge�ffnet und das aktuelle Fenster wird geschlossen.
	 */
	public void actionPerformed (ActionEvent aktion){
		
		if(aktion.getSource() == this.btnNein){
			
			this.dispose();
		}
		
		if(aktion.getSource() == this.btnJa){
			
			this.dispose();
			FrameKategorieGeloescht frame = new FrameKategorieGeloescht("Best�tigung");
			frame.setVisible(true);
				
		}
	}
}