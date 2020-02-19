package Benutzeroberflaeche;
import javax.swing.*;

import BusinessLogik.Artikel;
import BusinessLogik.Regal_Businesslogik;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Das Fenster Artikel Anzeigen gibt die Werte des Artikels an, welcher vorher ausgewählt wurde. Man hat hier die Möglichkeit den Artikel zu bearbeiten, oder zu löschen
 * @author Marie Diekmann, Thi Thu Trinh 
 *
 */
public class FrameArtikelAnzeigen extends JFrame implements ActionListener{
	
	
	//Initialisierung
	ArrayList<String> kategorieListe = new ArrayList <String>();
	
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
	JLabel labeluberschrift = new JLabel("Artikel ");
	JLabel labelGewicht = new JLabel("Gewicht: ");
	JLabel labelGramm = new JLabel("Gramm");
	JLabel labelStueck = new JLabel("Stück");
	JLabel labelEuro = new JLabel("Euro");
	
	
	//Textfelder sind weiß hinterlegte Felder, wo man als Nuzter Texte eingeben kann. JTextfield(20) gibt an, dass das Textfeld 20 pixel groß ist.
	JTextField textfieldArtikelbezeichnung = new JTextField(20);
	JTextField textfieldBestand = new JTextField(20);
	JTextField textfieldPreis = new JTextField(20);
	JTextField textfieldRegal = new JTextField(5);
	JTextField textfieldAbteilung = new JTextField(5);
	JTextField tetxfieldUnterabteilung = new JTextField(5);
	JTextField textfieldFach = new JTextField(10);
	JTextField textfieldGewicht = new JTextField(10);
	
	//Eine Combobox dient zur Auswahl von verschiedenen Möglichkeiten, welche vorher in einem Array festgelegt sind
	JComboBox cmbKategorie = new JComboBox(kategorieListe.toArray());
	
	//Buttons sind Schaltflächen für Benutzer, um eine Aktion auszuführen, wie zb. das Programm beenden etc.
	JButton btnArtikelBearbeiten =new JButton (" Artikel bearbeiten");
	JButton btnAbbrechen =new JButton (" Abbrechen");
	JButton btnArtikelLoeschen =new JButton (" Artikel löschen");
	
	//Panels teilen  das Fenster in verschiedene Bereiche auf
	JPanel hauptPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0) );
	JPanel panelOben = new JPanel(new GridBagLayout()); //GridBagLayout teilt das Fenster in eine Art Tabelle ein, welche im Konstruktor festgelegt wird
	JPanel panelUnten = new JPanel(new GridBagLayout());
	
	//Wird für das Grid benötigt, es muss nämlich erst erstellt werden.
	GridBagConstraints gitterOben = new GridBagConstraints();
	GridBagConstraints gitterUnten = new GridBagConstraints();
	
	ArrayList<Artikel> gefundeneArtikel;
	Artikel angezeigterArtikel;
	
//Konstruktor
	/**
	 * Konstruktor für das Fenster, hier werden Werte für die Größe des Fensters gesetzt etc. 
	 * Außerdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugefügt, sowie durch ein GridLayout auf dem ContentPane platziert.
	 * 
	 * 
	 * @param fenstertitel, um den fenstertitel individuell setzten zu können
	 * @param artikel, um die Werte von Artikel anzeigen zu können
	 * @param gefundeneArtikel,Ergebnisliste von der letzten Suche
	 */
public  FrameArtikelAnzeigen (String fenstertitel, Artikel artikel, ArrayList<Artikel> gefundeneArtikel) {
		
		super(fenstertitel);//Gibt dem Fenster oben einen Titel
		this.setSize(800,400); // Setzt die Groesse des Fensters
		this.setLocationRelativeTo(null); // setzt das Fenster in die Mitte beim oeffnen
		this.getContentPane().add(hauptPanel);// Das Hauptpanel wird dem ContentPane (eine Ebene des Frames) hinzugefügt
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Das Fenster schließt sich, wenn ein anderes Fenster geöffnet wird.
		
		this.gefundeneArtikel = gefundeneArtikel;
		this.angezeigterArtikel = artikel;
		
		//Die Panels werden dem hauptPanel hinzugefügt
		hauptPanel.add(panelOben);
		hauptPanel.add(panelUnten);
		
		//Die einzelnen Elemente, welche genutzt werden sollen und eine Aktion auslösen sollen, werden dem Action Listener hinzugefügt.
		btnArtikelBearbeiten.addActionListener(this);
		btnAbbrechen.addActionListener(this);
		btnArtikelLoeschen.addActionListener(this);
		
		this.cmbKategorie.addItem(artikel.kategorie);
		this.cmbKategorie.setEditable(false);
		
		this.textfieldBestand.setText(artikel.bestand + "");
		this.textfieldBestand.setEditable(false);
		this.textfieldGewicht.setText(artikel.gewicht + "");
		this.textfieldGewicht.setEditable(false);
		this.textfieldPreis.setText(artikel.preis + "");
		this.textfieldPreis.setEditable(false);
		this.textfieldArtikelbezeichnung.setText(artikel.name);
		this.textfieldArtikelbezeichnung.setEditable(false);
		
		String[] geteilteRegalNummer = Regal_Businesslogik.regalNummerAufteilen(artikel.regalNummer);
		this.textfieldRegal.setText(geteilteRegalNummer[0]);
		this.textfieldRegal.setEditable(false);
		this.textfieldAbteilung.setText(geteilteRegalNummer[1]);
		this.textfieldAbteilung.setEditable(false);
		this.tetxfieldUnterabteilung.setText(geteilteRegalNummer[2]);
		this.tetxfieldUnterabteilung.setEditable(false);
		this.textfieldFach.setText(geteilteRegalNummer[3]);
		this.textfieldFach.setEditable(false);
		
		

		//Den Abstand zwischen den einzelnen Elementen auf 10 pixel setzten
		gitterOben.insets = new Insets(10,10,10,10);
		gitterUnten.insets = new Insets(10,10,10,10);


		//Postitionieren der einzelnen Elemente im Gitter:
		
		//Im Fenster oben
		gitterOben.gridx = 1;
		gitterOben.gridy = 0; //Oben als Überschrift
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
		gitterUnten.gridy = 1;
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
		panelUnten.add(textfieldFach, gitterUnten);
		
		gitterUnten.gridx = 5;
		gitterUnten.gridy = 2;
		panelUnten.add(labelFach, gitterUnten);
	
		gitterUnten.gridx = 0;
		gitterUnten.gridy = 5;
		panelUnten.add(btnArtikelBearbeiten, gitterUnten);
		
		gitterUnten.gridx = 1;
		panelUnten.add(btnArtikelLoeschen, gitterUnten);

		gitterUnten.gridx = 2;
		panelUnten.add(btnAbbrechen, gitterUnten);
		
	}
/**
 * Funktion die definiert was passiert, wenn die einzelnen Buttons gedrückt werden.
 */
public void actionPerformed (ActionEvent aktion){
	
	/**
	 * Wenn der Button btnAbbrechen gedrückt wird soll sich das Fenster schließen und es geht zurück ins Fenster FrameGefundeneArtikel
	 */
	if(aktion.getSource() == this.btnAbbrechen){
		this.dispose();
		FrameGefundeneArtikel frame = new FrameGefundeneArtikel("Artikel gefunden", this.gefundeneArtikel);
		frame.setVisible(true);
	}
	/**
	 * Wenn der Button btnArtikelBearbeiten gedrückt wird, wird das Fenster geschlossen und es geht zum Fenster FrameArtikelBearbeiten
	 */
	if(aktion.getSource() == this.btnArtikelBearbeiten){
		this.dispose();
		FrameArtikelBearbeiten frame = new FrameArtikelBearbeiten ("Artikel bearbeiten", this.angezeigterArtikel, this.gefundeneArtikel);
		frame.setVisible(true);
	}
	
	/**
	 * Wenn der Button btnArtikelLoeschen gedrückt wird, dann geht das Fenster zu und es geht zum Fenster FrameArtikelLoeschen
	 */
	if(aktion.getSource() == this.btnArtikelLoeschen){
		FrameArtikelLoeschen frame = new FrameArtikelLoeschen("Sind Sie sich sicher?", this.gefundeneArtikel, this.angezeigterArtikel, this);
		frame.setVisible(true);
	}
	
	}
}