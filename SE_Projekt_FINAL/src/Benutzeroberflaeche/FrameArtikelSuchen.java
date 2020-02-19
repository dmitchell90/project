package Benutzeroberflaeche;
import javax.swing.*;

import BusinessLogik.Artikel;
import BusinessLogik.Artikel_Businesslogik;
import BusinessLogik.Kategorie_Businesslogik;
import BusinessLogik.Kategorie;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Das Fenster Artikel Suchen gibt die M�glichkeit nach allen Eigenschaften eines Artikels zu suchen und sich alle Artikel anzeigen zu lassen
 * @author Marie Diekmann
 *
 */
public class FrameArtikelSuchen extends JFrame implements ActionListener{
	
	
	//Initialisierung
	
	ArrayList<Kategorie> kategorieListe = new ArrayList <Kategorie>();
	
	//Labels sind normale Schriftzuege
	JLabel labelArtikelbezeichnung = new JLabel("Artikelbezeichnung: "); 
	JLabel labelKategorie = new JLabel("Kategorie: "); 
	JLabel labelBestand = new JLabel("Bestand: "); 
	JLabel labelPreis = new JLabel("Preis: "); 
	JLabel labelPlatznummer = new JLabel("Platznummer: "); 
	JLabel labelRegal = new JLabel("Regal "); 
	JLabel labelAbteilung = new JLabel("Abteilung "); 
	JLabel labelUnterabteilung = new JLabel("Unterabteilung "); 
	JLabel labelFach = new JLabel("Fach "); 
	JLabel labeluberschrift = new JLabel("Artikel suchen: ");
	JLabel labelGewicht = new JLabel("Gewicht: ");
	JLabel labelGramm = new JLabel("Gramm");
	JLabel labelStueck = new JLabel("Stück");
	JLabel labelEuro = new JLabel("Euro");
	
	//Textfelder sind wei� hinterlegte Felder, wo man als Nuzter Texte eingeben kann. JTextfield(20) gibt an, dass das Textfeld 20 pixel gro� ist.
	JTextField textfieldArtikelbezeichnung = new JTextField(20);
	JTextField textfieldBestand = new JTextField(20);
	JTextField textfieldPreis = new JTextField(20);
	JTextField textfieldRegal = new JTextField(5);
	JTextField textfieldAbteilung = new JTextField(5);
	JTextField tetxfieldUnterabteilung = new JTextField(5);
	JTextField textefieldFach = new JTextField(10);
	JTextField textfieldGewicht = new JTextField(10);
	
	//Eine Combobox dient zur Auswahl von verschiedenen M�glichkeiten, welche vorher in einem Array festgelegt sind
	JComboBox cmbKategorie;
	
	//Buttons sind Schaltfl�chen f�r Benutzer, um eine Aktion auszuf�hren, wie zb. das Programm beenden etc.
	JButton btnArtikelSuchen =new JButton (" Artikel suchen");
	JButton btnAbbrechen =new JButton (" Abbrechen");
	
	//Panels teilen  das Fenster in verschiedene Bereiche auf
	JPanel hauptPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0) );
	JPanel panelOben = new JPanel(new GridBagLayout()); //GridBagLayout teilt das Fenster in eine Art Tabelle ein, welche im Konstruktor festgelegt wird
	JPanel panelUnten = new JPanel(new GridBagLayout());
	
	//Wird f�r das Grid ben�tigt, es muss n�mlich erst erstellt werden.
	GridBagConstraints gitterOben = new GridBagConstraints();
	GridBagConstraints gitterUnten = new GridBagConstraints();
	
	/**
	* Konstruktor f�r das Fenster, hier werden Werte f�r die Gr��e des Fensters gesetzt etc. 
	* Au�erdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugef�gt, sowie durch ein GridLayout auf dem ContentPane platziert.
	* 
	* @param fenstertitel, um einen individuellen Fenstertitel setzetn zu k�nnen
	*/
	public  FrameArtikelSuchen (String fenstertitel) {
		
		super(fenstertitel);//Gibt dem Fenster oben einen Titel
		this.setSize(800,400); // Setzt die Groesse des Fensters
		this.setLocationRelativeTo(null); // setzt das Fenster in die Mitte beim oeffnen
		this.getContentPane().add(hauptPanel);// Das Hauptpanel wird dem ContentPane (eine Ebene des Frames) hinzugef�gt
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Das Fenster schlie�t sich, wenn ein anderes Fenster ge�ffnet wird.
		
		kategorieListe = Kategorie_Businesslogik.kategorienLaden();
		cmbKategorie = new JComboBox(kategorieListe.toArray());
		
		//Die Panels werden dem hauptPanel hinzugef�gt
		hauptPanel.add(panelOben);
		hauptPanel.add(panelUnten);
		
		//Die einzelnen Elemente, welche genutzt werden sollen und eine Aktion ausl�sen sollen, werden dem Action Listener hinzugef�gt.
		btnArtikelSuchen.addActionListener(this);
		btnAbbrechen.addActionListener(this);
		
		textfieldArtikelbezeichnung.addActionListener(this);
		cmbKategorie.addActionListener(this);
		textfieldBestand.addActionListener(this);
		textfieldPreis.addActionListener(this);
		textfieldGewicht.addActionListener(this);
		textfieldRegal.addActionListener(this);
		textfieldAbteilung.addActionListener(this);
		textefieldFach.addActionListener(this);
		tetxfieldUnterabteilung.addActionListener(this);

		//Den Abstand zwischen den einzelnen Elementen auf 10 pixel setzten
		gitterOben.insets = new Insets(10,10,10,10);
		gitterUnten.insets = new Insets(10,10,10,10);


		//Postitionieren der einzelnen Elemente im Gitter:
		
		//Im Fenster oben
		gitterOben.gridx = 1;
		gitterOben.gridy = 0; //Oben als �berschrift
		panelOben.add(labeluberschrift, gitterOben);
		
		
		gitterOben.gridx = 0;
		gitterOben.gridy = 1;//oben Links
		panelOben.add(labelArtikelbezeichnung,gitterOben);
		gitterOben.gridx = 1;//oben neben Label
		panelOben.add(textfieldArtikelbezeichnung,gitterOben);
		
		
		gitterOben.gridx = 0;
		gitterOben.gridy = 2;//unter vorherigem label
		panelOben.add(labelKategorie,gitterOben);
		gitterOben.gridx = 1;//neben label Kategorie
		panelOben.add(cmbKategorie,gitterOben);
				
		gitterOben.gridx = 0;
		gitterOben.gridy = 3;//unter vorherigem label
		panelOben.add(labelBestand,gitterOben);
		gitterOben.gridx = 1;//neben dem label Bestand
		panelOben.add(textfieldBestand,gitterOben);
		gitterOben.gridx = 2;//neben dem label Bestand
		panelOben.add(labelStueck,gitterOben);
		
		gitterOben.gridx = 0;
		gitterOben.gridy = 4;//unter vorherigem label
		panelOben.add(labelGewicht,gitterOben);
		gitterOben.gridx = 1;//neben dem label Preis
		panelOben.add(textfieldGewicht,gitterOben);
		gitterOben.gridx = 2;//neben dem label Bestand
		panelOben.add(labelGramm,gitterOben);
		
		gitterOben.gridx = 0;
		gitterOben.gridy = 5;//unter vorherigem label
		panelOben.add(labelPreis,gitterOben);
		gitterOben.gridx = 1;//neben dem label Preis
		panelOben.add(textfieldPreis,gitterOben);
		gitterOben.gridx = 2;//neben dem label Preis
		panelOben.add(labelEuro,gitterOben);
		
		//Im Fenster unten
		gitterUnten.gridx = 0;
		gitterUnten.gridy = 1;// 
		panelUnten.add(labelPlatznummer, gitterUnten);
		
		gitterUnten.gridx = 1;
		gitterUnten.gridy = 1;
		panelUnten.add(textfieldRegal, gitterUnten);
		
		gitterUnten.gridx = 1;
		gitterUnten.gridy = 2;
		panelUnten.add(labelRegal, gitterUnten);
		
	
		gitterUnten.gridx = 3;
		gitterUnten.gridy = 1;
		panelUnten.add(textfieldAbteilung, gitterUnten);
		
		gitterUnten.gridx = 3;
		gitterUnten.gridy = 2;
		panelUnten.add(labelAbteilung, gitterUnten);
		

		gitterUnten.gridx = 4;
		gitterUnten.gridy = 1;
		panelUnten.add(tetxfieldUnterabteilung, gitterUnten);
		
		gitterUnten.gridx = 4;
		gitterUnten.gridy = 2;
		panelUnten.add(labelUnterabteilung, gitterUnten);

		gitterUnten.gridx = 5;
		gitterUnten.gridy = 1;
		panelUnten.add(textefieldFach, gitterUnten);
		
		gitterUnten.gridx = 5;
		gitterUnten.gridy = 2;
		panelUnten.add(labelFach, gitterUnten);
	
		gitterUnten.gridx = 0;
		gitterUnten.gridy = 5;
		panelUnten.add(btnArtikelSuchen, gitterUnten);

		gitterUnten.gridx = 1;
		panelUnten.add(btnAbbrechen, gitterUnten);
		
	}

	/**
	 * Zuerst werden alle  textfelder eingelesen, sowie die in der Combobox Ausgew�hlte Kategorie
	 * Dann wird definiert,w as beim dr�cken der einzelnen Buttons passiert
	 * 
	 */
	public void actionPerformed (ActionEvent aktion){
		String artikelbezeichnung = textfieldArtikelbezeichnung.getText();
		String bestand = textfieldBestand.getText();
		String gewicht = textfieldGewicht.getText();
		String preis = textfieldPreis.getText();
		String regal = textfieldRegal.getText();
		String abteilung = textfieldAbteilung.getText();
		String unterabteilung = tetxfieldUnterabteilung.getText();
		String fach = textefieldFach.getText();
		
		
		/**
		 * Wenn der Button btnAbbrechen gedr�ckt wird, dann schlie�e das Fenster und �ffne das Auswahlfenster
		 */
		if(aktion.getSource() == this.btnAbbrechen){
			this.dispose();
			FrameAuswahlfenster frame = new FrameAuswahlfenster ("Lagerverwaltung");
			frame.setVisible(true);
			}
		
		/**
		 * Wennd er Button btnArtikelSuchen gedr�ckt wird, dann werden Regeln der Klasse EingabeRegeln �berpr�ft,
		 * wenn eine Regel verletzt wird, dann kommt eine Fehlermeldung
		 * wenn alles in ordnung ist erstelle einen "suchArtikel", f�hre folgende Funktionen aus: Artikel_Businesslogik.artikelLaden(), Artikel_Businesslogik.artikelSuchen()
		 * wenn kein Artikel gefunden wurde , dann kommt eine Fehlermeldung,
		 * wenn ein Artikel gefunden wurde, dann wird das Fenster geschlossen und das Fenster FrameGefundeneArtikel ge�ffnet.
		 */
		if(aktion.getSource() == this.btnArtikelSuchen){
			
			boolean fehler = false;
			int fehlerZaehler = 0;
			String fehlernachricht = "";
			int suchBestand = 0;
			double suchPreis = 0;
			double suchGewicht = 0;
			String suchRegal = "_";
			String suchAbteilung = "_";
			String suchUnterAbteilung = "_";
			String suchFach = "___";
			String suchKategorie = "Keine Kategorie";
			Kategorie kategorie = (Kategorie) this.cmbKategorie.getSelectedItem();
			
			if(!EingabeRegeln.mindestensEinFeldAusgefuellt(artikelbezeichnung, bestand, gewicht, preis, regal, abteilung, unterabteilung, fach,String.valueOf(cmbKategorie.getSelectedItem()))) {
				
				fehler = true;
				
			} else {
				
				if(!kategorie.name.equals("Keine Kategorie")) {
					
					suchKategorie = kategorie.name;
				}
				
				if (!artikelbezeichnung.isEmpty()) {
					
					if (EingabeRegeln.korrektheitArtikelbezeichnung(artikelbezeichnung)) {
						
						fehler = false;
						
					} else {
						
						fehler = true;
					}
				}
		
				if (!bestand.isEmpty()) {
					
					if(EingabeRegeln.korrektheitBestand(bestand)) {
						
						fehler = false;
						suchBestand = Integer.parseInt(bestand);
						
					} else {
						
						fehler = true;
					}
				}
				
				if (!gewicht.isEmpty()) {
					
					if(EingabeRegeln.korrektheitGewicht(gewicht)) {
						
						fehler = false;
						suchGewicht = Double.parseDouble(gewicht);
						
					} else {
						
						fehler = true;
					}
				}
				
				if (!preis.isEmpty()) {
					
					if(EingabeRegeln.korrektheitPreis(preis)){
						
						fehler = false;
						suchPreis = Double.parseDouble(preis);
						
					} else {
						
						fehler = true;		
					}
				}
				
				if (!regal.isEmpty()) {
					
					if(EingabeRegeln.korrektheitRegal(regal)) {
						
						fehler = false;
						suchRegal = regal;
						
					} else {
						
						fehler = true;
					}	
				}
				
				if (!abteilung.isEmpty()) {
					
					if(EingabeRegeln.korrektheitAbteilung(abteilung)) {
						
						fehler = false;
						suchAbteilung = abteilung;
						
					} else {
						
						fehler = true;
					}
				}
				
				if(!unterabteilung.isEmpty()) {
					
					if(EingabeRegeln.korrektheitUnterabteilung(unterabteilung)) {
						
						fehler = false;
						suchUnterAbteilung = unterabteilung;
						
					} else {
						
						fehler = true;
					}
				}
				
				if(!fach.isEmpty()) {
					
					if(EingabeRegeln.korrektheitFach(fach)) {
						
						fehler = false;
						suchFach = fach;
						
					} else {
					
						fehler = true;
					}
				}	
			}
			
			if (fehler) {
				
				JOptionPane.showMessageDialog(null, "Sie haben " + EingabeRegeln.fehlerZaehler +" gemacht.\n"+EingabeRegeln.fehlerNachricht +"Bitte berichtigen Sie diese Fehler!!");
				EingabeRegeln.aufNullSetzten();
				
			} else {
				
				Artikel suchArtikel = new Artikel(artikelbezeichnung, suchRegal+suchAbteilung+suchUnterAbteilung+suchFach, suchPreis, suchGewicht, suchBestand, suchKategorie);
				
				ArrayList<Artikel> geladeneArtikel = Artikel_Businesslogik.artikelLaden();
				
				ArrayList<Artikel> gefundeneArtikel = Artikel_Businesslogik.artikelSuchen(geladeneArtikel, suchArtikel);
				
				
				if(gefundeneArtikel.isEmpty()) {
					
					JOptionPane.showMessageDialog(null,"Es wurden keine Artikel gefunden.");
					
				} else {
					
					this.dispose();
					FrameGefundeneArtikel frame = new FrameGefundeneArtikel("Artikel gefunden", gefundeneArtikel);
					frame.setVisible(true);	
				}
			}
		}
			
			
		
		
		}
		
		

}