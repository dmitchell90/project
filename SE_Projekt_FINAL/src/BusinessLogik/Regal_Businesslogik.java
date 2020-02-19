package BusinessLogik;

import java.util.ArrayList;

import Datenspeicherung.XmlAusgabe;
import Datenspeicherung.XmlEingabe;
import Datenspeicherung.XmlSerialisierbar;
import HilfreicheFunktionen.Datei;

/**
 * Klasse welche die Businesslogik in Bezug auf Regale bzw auf Listen von Regalen bereitstellt.
 * 
 */
public class Regal_Businesslogik {
	
	/**
	 * Methode welche die RegakNummer eines Artikels in einen Array aus Regal, Abteilungs, UnterAbteilungs und Fach Nummer auteilt
	 * 
	 * @return String[] geteilteRegalNummer, einen Array aus Regal, Abteilungs, UnterAbteilungs und Fach Nummer
	 */
	public static String[] regalNummerAufteilen(String regalNummer) {
		
		String[] geteilteRegalNummer = new String[4];
		
		geteilteRegalNummer[0] = regalNummer.substring(0, 1);
		geteilteRegalNummer[1] = regalNummer.substring(1, 2);
		geteilteRegalNummer[2] = regalNummer.substring(2, 3);
		geteilteRegalNummer[3] = regalNummer.substring(3, 6);
		
		return geteilteRegalNummer;
	}

	/**
	 * Lädt eine Liste an Regalen aus der Datei "regale.xml", sollte die Datei nicht vorhanden sein wird eine leere Liste zurückgegeben
	 * 
	 * @return ArrayList<Regal>, Liste der eingelesenen Regale 
	 * 
	 */
	public static ArrayList<Regal> regaleLaden() {
		
		ArrayList<Regal> regalListe;
		
		if(Datei.istVorhanden("regale.xml")) {
			
			regalListe = listeDerRegaleLaden();
			
		} else {
			
			regalListe = new ArrayList<Regal>();
		}
		
		return regalListe;
	}
	
	/**
	 * Gibt ein Regal anhand der Regal+Abteilungs+UnterAbteilungs aus einer Liste von Regalen zurück
	 * 
	 * @param ArrayList<Regal> regalListe, Liste an Regalen
	 * @param String regalNummer, Nummer des Regals was gesucht wird 
	 * 
	 * @return Regal regal, gefundenes regal ansonsten wird ein neues regal erstellt und der Liste hinzugefügt 
	 * 
	 */
	public static Regal regalAusListeBekommen(ArrayList<Regal> regalListe, String regalNummer) {
		
		if(regalListe.contains(new Regal(regalNummer, 0))) {
			
			System.out.println("Regal wurde gefunden");
			return regalListe.get(regalListe.indexOf(new Regal(regalNummer, 0)));
			
		} else {
			
			// 10 Mio Gramm = 10 Tonnen
			Regal neuesRegal = new Regal(regalNummer, 10000000);
			regalListe.add(neuesRegal);
			
			return neuesRegal;
		}
	}
	
	/**
	 * Lädt eine Liste an Regalen aus der Datei "regale.xml"
	 * 
	 * @return ArrayList<Regal>, Liste der eingelesenen Regale 
	 * 
	 */
	public static ArrayList<Regal> listeDerRegaleLaden() {
		
		ArrayList<XmlSerialisierbar> geleseneListe = XmlEingabe.xmlDateiLesen("regale.xml", "Regale");
		
		ArrayList<Regal> regalListe = new ArrayList<Regal>();
		
		for(int i = 0; i < geleseneListe.size(); i++) {
			
			regalListe.add((Regal) geleseneListe.get(i));
		}
		
		return regalListe;
	}
	
	/**
	 * Speichert eine Liste an Regalen in die Datei "regale.xml"
	 * 
	 * @param ArrayList<Regal> regalListe, Liste der zu speichernden Regale 
	 * 
	 */
	public static void listeDerRegalSpeichern(ArrayList<Regal> regalListe) {
		
		ArrayList<XmlSerialisierbar> zuSpeicherndeListe = new ArrayList<XmlSerialisierbar>();
		
		for(int i = 0; i < regalListe.size(); i++) {
			
			zuSpeicherndeListe.add((XmlSerialisierbar) regalListe.get(i));
		}
		
		XmlAusgabe.xmlDateiSchreiben("regale.xml", "Regale", zuSpeicherndeListe);
	}
}
