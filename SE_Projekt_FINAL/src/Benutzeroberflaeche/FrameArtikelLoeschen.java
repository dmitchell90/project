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
 * Dieses Fenster dient dazu um den Nutzer abzufragen, ob sie wirklich den Artikel l�schen m�chten. 
 * 
 * @author Marie Diekmann, Thi Thu Trinh
 *
 */
public class FrameArtikelLoeschen extends JFrame implements ActionListener{
	
	JLabel labelAbfrage = new JLabel ("Sind Sie sich sicher, dass Sie diesen Artikel l�schen m�chten?",JLabel.CENTER);
	JButton btnJa = new JButton ("Ja");
	JButton btnNein = new JButton ("Nein");
	JPanel unten = new JPanel();//JPanel teilt GUI in verscheidene Bereiche auf
	ArrayList<Artikel> gefundeneArtikel;
	Artikel angezeigterArtikel;
	FrameArtikelAnzeigen mutterFenster;
	
	/**
	 * Konstruktor f�r das Fenster, hier werden Werte f�r die Gr��e des Fensters gesetzt etc. 
	 * Au�erdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugef�gt, sowie durch ein GridLayout auf dem ContentPane platziert.
	 * 
	 * @param fenstertitel, um einen individuellen fenstertitel einzugeben
	 * @param gefundeneArtikel, Ergebnisliste der letzten Suche
	 * @param angezeigterArtikel, Artikel, welcher im Fenster ArtikelAnzeigen angezeigt wurde und nun gel�scht werden soll
	 * @param mutterFenster, das vorherige Fenster, um es am Ende mit zu schlie�en
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
 * Gibt an, was beim dr�cken der Buttons passieren soll
 * 
 */
	public void actionPerformed (ActionEvent aktion){
		
		/**
		 * Wird der Button btnNein gedr�ckt, dann wird das Fenster einfach geschlossen
		 */
		
		if(aktion.getSource() == this.btnNein){
			
			this.dispose();
		}
		
		/**
		 * Wird der Button btnJa gedr�ckt, dann wird das Fenster, sowie das vorherige Fenster geschlossen. 
		 * Au�erderm werden folgende Funktionen ausgef�hrt: Artikel_Businesslogik.artikelLaden(), Kategorie_Businesslogik.kategorienLaden(),kategorienListe.get(),gefundeneArtikel.remove(),geladeneArtikel.remove()
		 * Sowie das Fenster FrameArtikelGeloescht wird ge�ffnet
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
			
			FrameArtikelGeloescht frame = new FrameArtikelGeloescht("Best�tigung", this.gefundeneArtikel);
			frame.setVisible(true);
					
			}
		}
	}


