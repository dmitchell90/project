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
 * Dieses Fenster soll alle gefundenen Artikel in einer Tabelle anzeigen und die M�glichkeit dienen Artikel auszuw�hlen um sie anzuzeigen
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
	 * Konstruktor f�r das Fenster, hier werden Werte f�r die Gr��e des Fensters gesetzt etc. 
	 * Au�erdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugef�gt, sowie durch ein GridLayout auf dem ContentPane platziert.
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
	 * Definiert was passiert, wenn die einzelnen Button gedr�ckt werden
	 */
	public void actionPerformed (ActionEvent aktion){
		
	/**
	 * Wenn der Button btnArtikelAnzeigen gedr�ckt wird, dann �berpr�fe ob ein Artikel in der Tabelle ausgw�hlt wurde,
	 * wurde kein Artikel in der Tabelle ausgew�hlt zeige eine Fehlermeldung
	 * wurde ein Artikel ausgew�hlt f�hre die Funktion gefundeneArtikel.get() aus
	 * und �ffne das Fenster FrameArtikelAnzeigen, schlie�e das aktielle Fenster
	 */
		if(aktion.getSource() == this.btnArtikelAnzeigen){
			
			if(this.artikelTabelle.getSelectedRow() != -1) {
			
				Artikel anzuzeigenderArtikel = this.gefundeneArtikel.get(this.artikelTabelle.getSelectedRow());
				this.dispose();
				FrameArtikelAnzeigen frame = new FrameArtikelAnzeigen("Artikel anzeigen", anzuzeigenderArtikel,this.gefundeneArtikel );
				frame.setVisible(true);
			
			} else {
				
				JOptionPane.showMessageDialog(null, "Bitte w�hlen Sie einen Artikel aus.");
			}
		}
		
		/**
		 * Wenn der Button btnAbbrechen gedr�ckt wurde, dann schlie�e das aktuelle Fenster und �ffne das Fenster FrameArtikelSuchen
		 * 
		 */
		if(aktion.getSource() == this.btnAbbrechen){
			this.dispose();
			FrameArtikelSuchen frame = new FrameArtikelSuchen("Artikel suchen");
			frame.setVisible(true);
		}
	
	}

}

