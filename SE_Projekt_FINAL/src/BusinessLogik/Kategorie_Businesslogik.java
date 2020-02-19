package BusinessLogik;

import java.util.ArrayList;

import Datenspeicherung.XmlAusgabe;
import Datenspeicherung.XmlEingabe;
import Datenspeicherung.XmlSerialisierbar;
import HilfreicheFunktionen.Datei;

/**
 * Klasse welche die Businesslogik in Bezug auf Kategorien bzw auf Listen von Kategorien bereitstellt.
 * 
 */
public class Kategorie_Businesslogik {
	
	/**
	 * L�dt eine Liste an Kategorien aus der Datei "kategorien.xml"
	 * 
	 * @return ArrayList<Kategorie>, Liste der eingelesenen Kategorien 
	 * 
	 */
	public static ArrayList<Kategorie> listeDerKategorienLaden() {
		
		ArrayList<XmlSerialisierbar> geleseneListe = XmlEingabe.xmlDateiLesen("kategorien.xml", "Kategorien");
		
		ArrayList<Kategorie> kategorieListe = new ArrayList<Kategorie>();
		
		for(int i = 0; i < geleseneListe.size(); i++) {
			
			kategorieListe.add((Kategorie) geleseneListe.get(i));
		}
		
		return kategorieListe;
	}
	
	/**
	 * Schreibt eine Liste von Kategorien in die Datei "kategorien.xml"
	 * 
	 * @param ArrayList<Kategorie> kategorieListe, Liste von Kategorien welche in die xmlDatei "kategorien.xml" geschrieben werden sollen
	 * 
	 */
	public static void listeDerKategorienSpeichern(ArrayList<Kategorie> kategorieListe) {
		
		ArrayList<XmlSerialisierbar> zuSpeicherndeListe = new ArrayList<XmlSerialisierbar>();
		
		for(int i = 0; i < kategorieListe.size(); i++) {
			
			zuSpeicherndeListe.add((XmlSerialisierbar) kategorieListe.get(i));
		}
		
		XmlAusgabe.xmlDateiSchreiben("kategorien.xml", "Kategorien", zuSpeicherndeListe);
	}
	
	/**
	 * L�dt eine Liste an Kategorien aus der Datei "kategorien.xml", sollte die Datei nicht vorhanden sein wird eine leere Liste zur�ckgegeben
	 * 
	 * @return ArrayList<Kategorie>, Liste der eingelesenen Kategorien 
	 * 
	 */
	public static ArrayList<Kategorie> kategorienLaden() {
		
		ArrayList<Kategorie> kategorieListe;
		
		if(Datei.istVorhanden("kategorien.xml")) {
			
			kategorieListe = listeDerKategorienLaden();
			
		} else {
			
			kategorieListe = new ArrayList<Kategorie>();
			
			kategorieListe.add(new Kategorie("Keine Kategorie"));
		}
		
		return kategorieListe;
	}
	
	/**
	 * �bersetzt eine Liste von Kategorien in eine Darstellung, die in einem JTable dargestellt werden kann
	 * 
	 * @param ArrayList<Kategorie>, Liste von Kategorien die in der Tabelle angezeigt werden sollen
	 * 
	 * @return  String[][], Array welcher in der Tabelle angezeigt wird
	 */
	public static String[][] kategorieListeZuTabelle(ArrayList<Kategorie> kategorieListe) {
		
		String[][] kategorieTabelle = new String[kategorieListe.size() - 1][1];
		
		for(int i = 1; i < kategorieListe.size(); i++) {
			
			kategorieTabelle[i-1][0] = kategorieListe.get(i).name;
		}
		
		return kategorieTabelle;
	}
}
