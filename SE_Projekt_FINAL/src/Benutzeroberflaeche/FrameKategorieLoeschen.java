package Benutzeroberflaeche;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Dies ist ein Bestätigungsfenster, welches kommt, wenn ein Artikel erfolgreich gelöscht wurde
 * 
 * @author Marie Diekmann, Thi Thu Trinh
 *
 */
public class FrameKategorieLoeschen extends JFrame implements ActionListener{
	
	JLabel labelAbfrage = new JLabel ("Sind Sie sich sicher, dass Sie diese Kategorie löschen möchten?",JLabel.CENTER);
	JButton btnJa = new JButton ("Ja");
	JButton btnNein = new JButton ("Nein");
	JPanel unten = new JPanel();//JPanel teilt GUI in verscheidene Bereiche auf
	
	
	/**
	 * Konstruktor für das Fenster, hier werden Werte für die Größe des Fensters gesetzt etc. 
	 * Außerdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugefügt
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
	 * Wenn der Button btnJa geklickt wird, dann wird das Fenster FrameKategorieGeloescht geöffnet und das aktuelle Fenster wird geschlossen.
	 */
	public void actionPerformed (ActionEvent aktion){
		
		if(aktion.getSource() == this.btnNein){
			
			this.dispose();
		}
		
		if(aktion.getSource() == this.btnJa){
			
			this.dispose();
			FrameKategorieGeloescht frame = new FrameKategorieGeloescht("Bestätigung");
			frame.setVisible(true);
				
		}
	}
}