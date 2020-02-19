package Benutzeroberflaeche;

import javax.swing.*;
import BusinessLogik.Kategorie_Businesslogik;
import BusinessLogik.Kategorie;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Dies ist das Fenster welches angezeigt wird, wenn man eine Kategorie hinzuf�gen m�chte.
 * 
 * @author Marie Diekmann, Thi Thu Trinh
 *
 */
public class FrameKategorieHinzufuegen extends JFrame implements ActionListener{
	
	JComboBox cmbKategorie;
	JTextField textfieldKategoriename = new JTextField(20);
	
	JLabel labelKategoriename = new JLabel("Kategoriename: ");
	
	JButton btnKategorieHinzufuegen = new JButton("Kategorie hinzufügen");
	JButton btnAbbrechen = new JButton("Abbrechen");
	JButton btnKategorieLoeschen = new JButton("Kategorie löschen");
	
	JTable alleKategorien;
	
	JPanel oben = new JPanel();
	JPanel unten = new JPanel();//JPanel teilt GUI in verscheidene Bereiche auf
	
	ArrayList<Kategorie> kategorieListe;
	
	/**
	 * Dem Konstruktor wird sowohl die Kategorieliste als auch die KomboBox cmbKategroie �bergeben um die �nderungen an den Kategorien zwischen allen Fenstern synchron zu halten
	 * 
	 * @author Marie Diekmann, Thi Thu Trinh
	 *
	 */
	public FrameKategorieHinzufuegen(String fenstertitel, JComboBox cmbKategroie, ArrayList<Kategorie> kategorieliste) {
		
		super(fenstertitel);
		this.kategorieListe = kategorieliste;
		this.cmbKategorie = cmbKategroie;
		
		this.setSize(600,400); // Setzt die Groesse des Fensters
		this.setLocationRelativeTo(null); // setzt das Fenster in die Mitte beim oeffnen
		
		this.getContentPane().add(oben, BorderLayout.NORTH);
		oben.add(labelKategoriename);
		oben.add(textfieldKategoriename);
		oben.add(btnKategorieHinzufuegen);
		
		String[] spalten = {"Kategorie"}; 
		this.alleKategorien = new JTable(Kategorie_Businesslogik.kategorieListeZuTabelle(kategorieliste), spalten);
		this.getContentPane().add(alleKategorien,BorderLayout.CENTER);
		
		this.getContentPane().add(unten, BorderLayout.SOUTH);
		unten.add(btnKategorieLoeschen);
		unten.add(btnAbbrechen);
		
		btnKategorieHinzufuegen.addActionListener(this);
		btnAbbrechen.addActionListener(this);
		btnKategorieLoeschen.addActionListener(this);
	}
	
	/**
	 * Funktion gibt an was passiert, wenn der Button btnKategorieHinzufuegen, btnKategorieLoeschen oder btnAbbrechen geklickt wird.
	 * Wenn der Button btnKategorieHinzufuegen geklickt wird, dann wird basierend auf dem Namen im Textfeld "textfieldKategoriename" eine neue Kategorie hinzugef�gt, ein Best�tigungsfenster ge�ffnet und das aktuelle Fenster geschlossen
	 * Wenn der Button btnKategorieLoeschen geklickt wird, dann wird die aktuell in der Tabelle ausgew�hlte Kategorie gel�scht, sowohl in der KomboBox als auch in der XmlDatei
	 * Wenn der Button btnAbbrechen geklickt wird, dann wird das aktuelle Fenster geschlossen
	 */
	public void actionPerformed (ActionEvent aktion){
		
		String kategoriename = textfieldKategoriename.getText();
	
		if(aktion.getSource() == this.btnKategorieHinzufuegen){
			
			boolean fehler = false;
			
			if (!EingabeRegeln.korrektheitKategoriename(kategoriename)) {
				
				fehler = true;
			}
			
			if (fehler) {
					
				JOptionPane.showMessageDialog(null, "Sie haben " + EingabeRegeln.fehlerZaehler +" gemacht.\n"+EingabeRegeln.fehlerNachricht +"Bitte berichtigen Sie diese Fehler!!");
				EingabeRegeln.aufNullSetzten();
			} 
			else {
					
				if(this.kategorieListe.contains(new Kategorie(textfieldKategoriename.getText()))) {
					
					JOptionPane.showMessageDialog(null, "Eine Kategoriel mit diesem Namen existiert bereits.");
					
				} else {
					
					this.cmbKategorie.addItem(new Kategorie(textfieldKategoriename.getText()));
					this.kategorieListe.add(new Kategorie(textfieldKategoriename.getText()));
					
					Kategorie_Businesslogik.listeDerKategorienSpeichern(this.kategorieListe);
					
					this.dispose();
					FrameKategorieGespeichert frame = new FrameKategorieGespeichert("Bestätigung");
					frame.setVisible(true);
				}	
			}
		}
		
		if(aktion.getSource() == this.btnKategorieLoeschen) {
			
			if(this.alleKategorien.getSelectedRow() != -1) {
				
				Kategorie kategorie = this.kategorieListe.get(this.alleKategorien.getSelectedRow() + 1);
				
				if(kategorie.zugehoerigeArtikel == 0) {
					
					this.cmbKategorie.removeItem(kategorie);
					
					this.kategorieListe.remove(this.alleKategorien.getSelectedRow() + 1);
					
					this.cmbKategorie.updateUI();
					
					Kategorie_Businesslogik.listeDerKategorienSpeichern(this.kategorieListe);
					
					this.dispose();
					FrameKategorieGespeichert frame = new FrameKategorieGespeichert("Best�tigung");
					frame.setVisible(true);
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Die Kategorie kann nicht gelöscht werden. Sie wird von " + kategorie.zugehoerigeArtikel + " Artikeln benutzt.");
				}
				
			} else {
				
				JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Kategorie aus.");
			}
		}
		
		if(aktion.getSource() == this.btnAbbrechen){
			this.dispose();
		}
	}
}
