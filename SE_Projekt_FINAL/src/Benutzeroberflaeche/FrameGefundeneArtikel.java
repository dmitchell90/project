package Benutzeroberflaeche;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import BusinessLogik.Artikel;
import BusinessLogik.Artikel_Businesslogik;

/**
 * Dieses Fenster soll alle gefundenen Artikel in einer Tabelle anzeigen und die Möglichkeit dienen Artikel auszuwählen um sie anzuzeigen
 * @author Marie Diekmann
 *
 */
public class FrameGefundeneArtikel extends JFrame implements ActionListener{
	
	JLabel labelUberschrift = new JLabel("Es wurden folgende Artikel gefunden:",JLabel.CENTER);
	
	JTable artikelTabelle;
	
	JButton btnArtikelAnzeigen =new JButton (" Artikel Anzeigen");
	JButton btnAbbrechen =new JButton (" Abbrechen");
	
	JPanel unten = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	
	 ArrayList<Artikel> gefundeneArtikel;
	/**
	 * Konstruktor für das Fenster, hier werden Werte für die Größe des Fensters gesetzt etc. 
	 * Außerdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugefügt, sowie durch ein GridLayout auf dem ContentPane platziert.
	 *  
	 * @param fenstertitel, um den Fenstertitel individuell zu setzen
	 * @param gefundeneArtikel, aktuellste Liste der gefundenen Artikel
	 */
	public FrameGefundeneArtikel(String fenstertitel, ArrayList<Artikel> gefundeneArtikel) {
		super(fenstertitel);//Gibt dem Fenster oben einen Titel
		this.setSize(800,400); // Setzt die Groesse des Fensters
		this.setLocationRelativeTo(null);
		
		this.gefundeneArtikel = gefundeneArtikel;
		
		String[] spalten = {"Name", "RegalNummer"}; 
		this.artikelTabelle = new JTable(Artikel_Businesslogik.artikelListeZuTabelle(gefundeneArtikel), spalten);
		
		this.getContentPane().add(labelUberschrift, BorderLayout.NORTH);
		this.getContentPane().add(artikelTabelle, BorderLayout.CENTER);
		this.add( new JScrollPane( artikelTabelle ) );
		this.getContentPane().add(unten, BorderLayout.SOUTH);
		this.unten.add(btnArtikelAnzeigen);
		this.unten.add(btnAbbrechen);
		
		btnArtikelAnzeigen.addActionListener(this);
		btnAbbrechen.addActionListener(this);
	}

	/**
	 * Definiert was passiert, wenn die einzelnen Button gedrückt werden
	 */
	public void actionPerformed (ActionEvent aktion){
		
	/**
	 * Wenn der Button btnArtikelAnzeigen gedrückt wird, dann überprüfe ob ein Artikel in der Tabelle ausgwählt wurde,
	 * wurde kein Artikel in der Tabelle ausgewählt zeige eine Fehlermeldung
	 * wurde ein Artikel ausgewählt führe die Funktion gefundeneArtikel.get() aus
	 * und öffne das Fenster FrameArtikelAnzeigen, schließe das aktielle Fenster
	 */
		if(aktion.getSource() == this.btnArtikelAnzeigen){
			
			if(this.artikelTabelle.getSelectedRow() != -1) {
			
				Artikel anzuzeigenderArtikel = this.gefundeneArtikel.get(this.artikelTabelle.getSelectedRow());
				this.dispose();
				FrameArtikelAnzeigen frame = new FrameArtikelAnzeigen("Artikel anzeigen", anzuzeigenderArtikel,this.gefundeneArtikel );
				frame.setVisible(true);
			
			} else {
				
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie einen Artikel aus.");
			}
		}
		
		/**
		 * Wenn der Button btnAbbrechen gedrückt wurde, dann schließe das aktuelle Fenster und öffne das Fenster FrameArtikelSuchen
		 * 
		 */
		if(aktion.getSource() == this.btnAbbrechen){
			this.dispose();
			FrameArtikelSuchen frame = new FrameArtikelSuchen("Artikel suchen");
			frame.setVisible(true);
		}
	
	}

}

