package Benutzeroberflaeche;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import BusinessLogik.Artikel;

/**
 * Dies ist ein Bestätigungsfenster, welches kommt, wenn ein Artikel erfolgreich gelöscht wurde
 * @author @author Marie Diekmann, Thi Thu Trinh
 *
 */
public class FrameArtikelGeloescht extends JFrame implements ActionListener{
	
	JLabel labelBestaetigung = new JLabel ("Der Artikel wurde gelöscht",JLabel.CENTER);
	JButton btnOK = new JButton ("OK");
	JPanel unten = new JPanel ();//JPanel teilt GUI in verscheidene Bereiche auf
	ArrayList<Artikel> gefundeneArtikel;
	
	
	/**
	 * Konstruktor für das Fenster, hier werden Werte für die Größe des Fensters gesetzt etc. 
	 * Außerdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugefügt, sowie durch ein GridLayout auf dem ContentPane platziert.
	 * 
	 * @param fenstertitel, um den Fenstertitel individuell angeben zu können
	 * @param gefundeneArtikel, Ergebnisliste von der letzten Suche
	 */
	public  FrameArtikelGeloescht (String fenstertitel, ArrayList<Artikel> gefundeneArtikel) {
		super(fenstertitel);
		this.setSize(400,200); // Setzt die Groesse des Fensters
		this.setLocationRelativeTo(null); // setzt das Fenster in die Mitte beim oeffnen
		
		this.gefundeneArtikel = gefundeneArtikel;
		
		this.getContentPane().add(labelBestaetigung);
		this.getContentPane().add(unten, BorderLayout.SOUTH);
		
		this.unten.add(btnOK);
		
		btnOK.addActionListener(this);
	}
	
/**
 * Funktion gibt an was passiert, wenn der Button btnOK geklickt wird.
 * Wenn der Button btnOK geklickt wird, dann wird das Fenster FrameGefundeneArtikel aufgerufen und das aktuelle Fenster wird geschlossen.
 * 
 * 
 */
	public void actionPerformed (ActionEvent aktion){
		
		if(aktion.getSource() == this.btnOK){
			
			this.dispose();
			FrameGefundeneArtikel frame = new FrameGefundeneArtikel("Artikel gefunden", this.gefundeneArtikel);
			frame.setVisible(true);
		}
	}
}