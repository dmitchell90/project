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
import BusinessLogik.Artikel_Businesslogik;
import BusinessLogik.Kategorie;
import BusinessLogik.Kategorie_Businesslogik;

/**
 * 
 * Dieses Fenster dient dazu um den Nutzer abzufragen, ob sie wirklich den Artikel löschen möchten. 
 * 
 * @author Marie Diekmann, Thi Thu Trinh
 *
 */
public class FrameArtikelLoeschen extends JFrame implements ActionListener{
	
	JLabel labelAbfrage = new JLabel ("Sind Sie sich sicher, dass Sie diesen Artikel löschen möchten?",JLabel.CENTER);
	JButton btnJa = new JButton ("Ja");
	JButton btnNein = new JButton ("Nein");
	JPanel unten = new JPanel();//JPanel teilt GUI in verscheidene Bereiche auf
	ArrayList<Artikel> gefundeneArtikel;
	Artikel angezeigterArtikel;
	FrameArtikelAnzeigen mutterFenster;
	
	/**
	 * Konstruktor für das Fenster, hier werden Werte für die Größe des Fensters gesetzt etc. 
	 * Außerdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugefügt, sowie durch ein GridLayout auf dem ContentPane platziert.
	 * 
	 * @param fenstertitel, um einen individuellen fenstertitel einzugeben
	 * @param gefundeneArtikel, Ergebnisliste der letzten Suche
	 * @param angezeigterArtikel, Artikel, welcher im Fenster ArtikelAnzeigen angezeigt wurde und nun gelöscht werden soll
	 * @param mutterFenster, das vorherige Fenster, um es am Ende mit zu schließen
	 */
	
	public  FrameArtikelLoeschen (String fenstertitel, ArrayList<Artikel> gefundeneArtikel, Artikel angezeigterArtikel, FrameArtikelAnzeigen mutterFenster) {
		super(fenstertitel);
		this.setSize(400,200); // Setzt die Groesse des Fensters
		this.setLocationRelativeTo(null); // setzt das Fenster in die Mitte beim oeffnen
		
		this.gefundeneArtikel = gefundeneArtikel;
		this.angezeigterArtikel = angezeigterArtikel;
		this.mutterFenster = mutterFenster;
		
		this.getContentPane().add(labelAbfrage);
		this.getContentPane().add(unten, BorderLayout.SOUTH);
		
		this.unten.add(btnJa);
		this.unten.add(btnNein);
		
		btnJa.addActionListener(this);
		btnNein.addActionListener(this);
	}
/**
 * Gibt an, was beim drücken der Buttons passieren soll
 * 
 */
	public void actionPerformed (ActionEvent aktion){
		
		/**
		 * Wird der Button btnNein gedrückt, dann wird das Fenster einfach geschlossen
		 */
		
		if(aktion.getSource() == this.btnNein){
			
			this.dispose();
		}
		
		/**
		 * Wird der Button btnJa gedrückt, dann wird das Fenster, sowie das vorherige Fenster geschlossen. 
		 * Außerderm werden folgende Funktionen ausgeführt: Artikel_Businesslogik.artikelLaden(), Kategorie_Businesslogik.kategorienLaden(),kategorienListe.get(),gefundeneArtikel.remove(),geladeneArtikel.remove()
		 * Sowie das Fenster FrameArtikelGeloescht wird geöffnet
		 * 
		 */
		if(aktion.getSource() == this.btnJa){
			
			this.mutterFenster.dispose();
			this.dispose();
			
			this.gefundeneArtikel.remove(this.angezeigterArtikel);
			
			ArrayList<Artikel> geladeneArtikel = Artikel_Businesslogik.artikelLaden();
			
			geladeneArtikel.remove(this.angezeigterArtikel);
			
			Artikel_Businesslogik.artikelListeSpeichern(geladeneArtikel);
			
			ArrayList<Kategorie> kategorienListe = Kategorie_Businesslogik.kategorienLaden();
			
			kategorienListe.get(kategorienListe.indexOf(new Kategorie(this.angezeigterArtikel.kategorie))).zugehoerigeArtikelVeringern();
			
			Kategorie_Businesslogik.listeDerKategorienSpeichern(kategorienListe);
			
			FrameArtikelGeloescht frame = new FrameArtikelGeloescht("Bestätigung", this.gefundeneArtikel);
			frame.setVisible(true);
					
			}
		}
	}


