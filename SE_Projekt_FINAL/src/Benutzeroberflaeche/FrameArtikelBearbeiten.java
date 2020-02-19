package Benutzeroberflaeche;
import javax.swing.*;

import BusinessLogik.Artikel;
import BusinessLogik.Artikel_Businesslogik;
import BusinessLogik.Kategorie_Businesslogik;
import BusinessLogik.Kategorie;
import BusinessLogik.Regal_Businesslogik;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Das Fenster Artikel Anzeigen gibt die Werte des Artikels an, welcher vorher ausgew�hlt wurde. Man hat hier die M�glichkeit den Artikel zu bearbeiten, oder zu l�schen
 * @author Marie Diekmann
 *
 */
public class FrameArtikelBearbeiten extends JFrame implements ActionListener{
	
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
	JLabel labelBestandAndern = new JLabel("Bestand �ndern: "); 
	JLabel labeluberschrift = new JLabel("Artikel ");
	JLabel labelGewicht = new JLabel("Gewicht: ");
	JLabel labelGramm = new JLabel("Gramm");
	JLabel labelStueck1 = new JLabel("St�ck");
	JLabel labelStueck2 = new JLabel("St�ck");
	JLabel labelEuro = new JLabel("Euro");
	
	
	//Textfelder sind wei� hinterlegte Felder, wo man als Nuzter Texte eingeben kann. JTextfield(20) gibt an, dass das Textfeld 20 pixel gro� ist.
	JTextField textfieldArtikelbezeichnung = new JTextField(20);
	JTextField textfieldBestand = new JTextField(20);
	JTextField textfieldPreis = new JTextField(20);
	JTextField textfieldRegal = new JTextField(5);
	JTextField textfieldAbteilung = new JTextField(5);
	JTextField textfieldUnterabteilung = new JTextField(5);
	JTextField textfieldFach = new JTextField(10);
	JTextField textfieldBestandAendern = new JTextField(5);
	JTextField textfieldGewicht = new JTextField(10);
	
	//Eine Combobox dient zur Auswahl von verschiedenen M�glichkeiten, welche vorher in einem Array festgelegt sind
	JComboBox cmbKategorie;
	
	//Buttons sind Schaltfl�chen f�r Benutzer, um eine Aktion auszuf�hren, wie zb. das Programm beenden etc.
	JButton btnArtikelSpeichern = new JButton (" Artikel Speichern");
	JButton btnAbbrechen = new JButton (" Abbrechen");
	JButton btnBestandHinzufuegen = new JButton (" + ");
	JButton btnBestandMindern = new JButton (" - ");
	
	//Panels teilen  das Fenster in verschiedene Bereiche auf
	JPanel hauptPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0) );
	JPanel panelOben = new JPanel(new GridBagLayout()); //GridBagLayout teilt das Fenster in eine Art Tabelle ein, welche im Konstruktor festgelegt wird
	JPanel panelUnten = new JPanel(new GridBagLayout());
	
	//Wird f�r das Grid ben�tigt, es muss n�mlich erst erstellt werden.
	GridBagConstraints gitterOben = new GridBagConstraints();
	GridBagConstraints gitterUnten = new GridBagConstraints();
	
	ArrayList<Kategorie> kategorieListe;
	Artikel bearbeiteterArtikel;
	ArrayList<Artikel> gefundeneArtikel;
	
	
/**
 * Konstruktor f�r das Fenster, hier werden Werte f�r die Gr��e des Fensters gesetzt etc. 
 * Au�erdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugef�gt, sowie durch ein GridLayout auf dem ContentPane platziert.
 * 
 * @param fenstertitel, um den Fenstertitel individuell zu setzten
 * @param artikel, da Artikel hier bearbeitet werden soll
 * @param gefundeneArtikel, Ergebnisliste von der letzten Suche
 * 
 */
public  FrameArtikelBearbeiten (String fenstertitel, Artikel artikel, ArrayList<Artikel> gefundeneArtikel) {
		
		super(fenstertitel);//Gibt dem Fenster oben einen Titel
		this.setSize(900,500); // Setzt die Groesse des Fensters
		this.setLocationRelativeTo(null); // setzt das Fenster in die Mitte beim oeffnen
		this.getContentPane().add(hauptPanel);// Das Hauptpanel wird dem ContentPane (eine Ebene des Frames) hinzugef�gt
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Das Fenster schlie�t sich, wenn ein anderes Fenster ge�ffnet wird.
		
		//Die Panels werden dem hauptPanel hinzugef�gt
		hauptPanel.add(panelOben);
		hauptPanel.add(panelUnten);
		
		this.bearbeiteterArtikel = artikel;
		this.gefundeneArtikel = gefundeneArtikel;
		
		this.kategorieListe = Kategorie_Businesslogik.kategorienLaden();
		cmbKategorie = new JComboBox(this.kategorieListe.toArray());
		
		cmbKategorie.setSelectedItem(new Kategorie(artikel.kategorie));
		
		
		//Die einzelnen Elemente, welche genutzt werden sollen und eine Aktion ausl�sen sollen, werden dem Action Listener hinzugef�gt.
		btnArtikelSpeichern.addActionListener(this);
		btnAbbrechen.addActionListener(this);
		btnBestandHinzufuegen.addActionListener(this);
		btnBestandMindern.addActionListener(this);
		
		textfieldArtikelbezeichnung.addActionListener(this);
		cmbKategorie.addActionListener(this);
		textfieldBestand.addActionListener(this);
		textfieldPreis.addActionListener(this);
		textfieldGewicht.addActionListener(this);
		textfieldRegal.addActionListener(this);
		textfieldAbteilung.addActionListener(this);
		textfieldUnterabteilung.addActionListener(this);
		textfieldFach.addActionListener(this);
		
		textfieldArtikelbezeichnung.setText(artikel.name);
		
		textfieldBestand.setText(artikel.bestand + "");
		textfieldBestand.setEditable(false);
		textfieldPreis.setText(artikel.preis + "");
		textfieldGewicht.setText(artikel.gewicht + "");
		
		String[] geteilteRegalNummer = Regal_Businesslogik.regalNummerAufteilen(artikel.regalNummer);
		
		textfieldRegal.setText(geteilteRegalNummer[0]);
		textfieldAbteilung.setText(geteilteRegalNummer[1]);
		textfieldUnterabteilung.setText(geteilteRegalNummer[2]);
		textfieldFach.setText(geteilteRegalNummer[3]);
		

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
		panelOben.add(labelStueck1,gitterOben);
		
		gitterOben.gridy = 4;
		gitterOben.gridx = 3;//neben textfeld zu Bestand
		panelOben.add(labelBestandAndern,gitterOben);
		gitterOben.gridx = 4;//neben dem label Bestand �ndern
		panelOben.add(textfieldBestandAendern,gitterOben);
		gitterOben.gridx = 5;//neben dem label Bestand
		panelOben.add(labelStueck2,gitterOben);
		gitterOben.gridx = 6;//neben dem Textfeld Bestand �ndern
		panelOben.add(btnBestandHinzufuegen,gitterOben);
		gitterOben.gridx = 7;//neben dem Button Bestand hinzuf�gen
		panelOben.add(btnBestandMindern, gitterOben);
		
		gitterOben.gridx = 0;
		gitterOben.gridy = 5;//unter vorherigem label
		panelOben.add(labelGewicht,gitterOben);
		gitterOben.gridx = 1;//neben dem label Preis
		panelOben.add(textfieldGewicht,gitterOben);
		gitterOben.gridx = 2;//neben dem label Bestand
		panelOben.add(labelGramm,gitterOben);
		
		
		gitterOben.gridx = 0;
		gitterOben.gridy = 6;//unter vorherigem label
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
		panelUnten.add(textfieldUnterabteilung, gitterUnten);
		
		gitterUnten.gridx = 4;
		gitterUnten.gridy = 2;
		panelUnten.add(labelUnterabteilung, gitterUnten);

		gitterUnten.gridx = 5;
		gitterUnten.gridy = 1;
		panelUnten.add(textfieldFach, gitterUnten);
		
		gitterUnten.gridx = 5;
		gitterUnten.gridy = 2;
		panelUnten.add(labelFach, gitterUnten);
	
		gitterUnten.gridx = 0;
		gitterUnten.gridy = 5;
		panelUnten.add(btnArtikelSpeichern, gitterUnten);
		
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
	String unterabteilung = textfieldUnterabteilung.getText();
	String fach = textfieldFach.getText();
	Kategorie kategorie = (Kategorie) cmbKategorie.getSelectedItem();
	
	/**
	 * Wenn der Button btnAbbrechen gedr�ckt wird, dann schlie�e das Fenster und �ffne das Auswahlfenster 
	 */
	if(aktion.getSource() == this.btnAbbrechen) {
		
		this.dispose();
		FrameAuswahlfenster frame = new FrameAuswahlfenster ("Lagerverwaltung");
		frame.setVisible(true);
	}
	/**
	 * Wenn der Button btnBestandHinzufuegen gedr�ckt wird, dann erh�he den Bestand im Textfeld textfieldBestand um den Betrag im TextfieldBestandAendern
	 */
	if(aktion.getSource() == this.btnBestandHinzufuegen) {
		
		int neuerBestand = Integer.parseInt(textfieldBestand.getText()) + Integer.parseInt(textfieldBestandAendern.getText());
		textfieldBestand.setText(neuerBestand + "");
		
	}
	
	/**
	 * Wenn der Button btnBestandMindern gedr�ckt wird, dann verringer den Bestand im Textfeld textfieldBestand um den Betrag im TextfieldBestandAendern
	 */
	if(aktion.getSource() == this.btnBestandMindern) {
		
		//textfieldBestand.setText(artikel.bestand + "");
		
		int neuerBestand = Integer.parseInt(textfieldBestand.getText()) - Integer.parseInt(textfieldBestandAendern.getText());
		textfieldBestand.setText(neuerBestand + "");
		
	}
	
	/**
	 * Wenn der Button btnArtikelSpeichern gedr�ckt wird, dann �berpr�fe ob die einzelnen Textfelder mit den EingabeRegeln korrekt gef�llt wurden, 
	 * wenn nicht dann gib eine Fehlermeldung aus, 
	 * wenn ja dann f�hre die Funktion Artikel_Businesslogik.artikelBearbeiten aus und schlie�e das aktuelle Fenster, �ffne das Fenster FrameArtikelBearbeitet
	 * 
	 * 
	 */
	
	if(aktion.getSource() == this.btnArtikelSpeichern) {
		
		boolean fehler = false;
		int fehlerZaehler = 0;
		String fehlernachricht = ""; 
	
		if (!EingabeRegeln.korrektheitArtikelbezeichnung(artikelbezeichnung)) {
			
			fehler = true;
		}
		
		if (!EingabeRegeln.korrektheitBestand(bestand)) {
			
			fehler = true;
		}
		
		if (!EingabeRegeln.korrektheitGewicht(gewicht)) {
			
			fehler = true;
		}
		
		if (!EingabeRegeln.korrektheitPreis(preis)) {
			
			fehler = true;
		}
		
		if (!EingabeRegeln.korrektheitRegal(regal)) {
			
			fehler = true;
		}
		
		if (!EingabeRegeln.korrektheitAbteilung(abteilung)) {
			
			fehler = true;
		}
		
		if (!EingabeRegeln.korrektheitUnterabteilung(unterabteilung)) {
			
			fehler = true;
		}
		
		if (!EingabeRegeln.korrektheitFach(fach)) {
			
			fehler = true;
		}
		
		if (fehler) {
			
			JOptionPane.showMessageDialog(null, "Sie haben " + EingabeRegeln.fehlerZaehler +" gemacht.\n"+EingabeRegeln.fehlerNachricht +"Bitte berichtigen Sie diese Fehler!!");
			EingabeRegeln.aufNullSetzten();
		
		} else {
			
			if(Artikel_Businesslogik.artikelBearbeiten(new Artikel(artikelbezeichnung, (regal + abteilung + unterabteilung + fach), Double.parseDouble(preis), Double.parseDouble(gewicht), Integer.parseInt(bestand), kategorie.name), this.bearbeiteterArtikel, this.gefundeneArtikel)) {
			
				this.dispose();
				FrameArtikelBearbeitet frame = new FrameArtikelBearbeitet("Best�tigung", this.gefundeneArtikel);
				frame.setVisible(true);	
			}
		}	
	}
	
	}
}