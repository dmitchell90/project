package BusinessLogik;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Datenspeicherung.XmlAusgabe;
import Datenspeicherung.XmlEingabe;
import Datenspeicherung.XmlSerialisierbar;
import HilfreicheFunktionen.Datei;

/**
 * Klasse welche die Businesslogik in Bezug auf Artikel bzw auf Listen von Arikeln bereitstellt.
 * 
 */
public class Artikel_Businesslogik {
	
	/**
	 * L�dt eine Liste an Artikeln aus der Datei "artikel.xml", sollte die Datei nicht vorhanden sein wird eine leere Liste zur�ckgegeben
	 * 
	 * @return ArrayList<Artikel>, Liste der eingelesenen Artikel 
	 * 
	 */
	public static ArrayList<Artikel> artikelLaden() {
		
		ArrayList<Artikel> artikelListe;
		
		if(Datei.istVorhanden("artikel.xml")) {
			
			artikelListe = listeDerArtikelLaden();
			
		} else {
			
			artikelListe = new ArrayList<Artikel>();
		}
		
		return artikelListe;
	}
	
	/**
	 * L�dt eine Liste an Artikeln aus der Datei "artikel.xml"
	 * 
	 * @return ArrayList<Artikel>, Liste der eingelesenen Artikel 
	 * 
	 */
	private static ArrayList<Artikel> listeDerArtikelLaden() {
		
		ArrayList<XmlSerialisierbar> geleseneListe = XmlEingabe.xmlDateiLesen("artikel.xml", "Artikelliste");
		
		ArrayList<Artikel> artikelListe = new ArrayList<Artikel>();
		
		for(int i = 0; i < geleseneListe.size(); i++) {
			
			artikelListe.add((Artikel) geleseneListe.get(i));
		}
		
		return artikelListe;
	}
	
	/**
	 * Speichert eine Liste von Artikeln in der Datei "artikel.xml"
	 * 
	 * @param  ArrayList<Artikel>, Liste von Artikeln welche gespeichert werden soll
	 * 
	 */
	public static void artikelListeSpeichern(ArrayList<Artikel> artikelListe) {
		
		ArrayList<XmlSerialisierbar> zuSpeicherndeListe = new ArrayList<XmlSerialisierbar>();
		
		for(int i = 0; i < artikelListe.size(); i++) {
			
			zuSpeicherndeListe.add((XmlSerialisierbar) artikelListe.get(i));
		}
		
		XmlAusgabe.xmlDateiSchreiben("artikel.xml", "Artikelliste", zuSpeicherndeListe);
	}
	
	/**
	 * Sucht Artikel anhand von Parametern in einer Liste von Artikeln. Die Parameter sind geb�ndelt im Artikel suchArtikel und k�nnen frei kombiniert werden.
	 * 
	 * @param ArrayList<Artikel>, Liste von Artikeln in der gesucht wird
	 * @param Artikel suchArtikel, Artikel welche alle Suchparameter vereinigt
	 * 
	 * @return ArrayList<Artikel>, Liste von Artikeln bei denen die Felder mit denen des suchArtikels �bereinstimmen
	 */
	public static ArrayList<Artikel> artikelSuchen(ArrayList<Artikel> artikelListe, Artikel suchArtikel) {
		
		ArrayList<Artikel> gefundeneArtikel = new ArrayList<Artikel>();
		int suchParameterAnzahl = 0;
		
		System.out.println(suchArtikel.regalNummer);
		
		String[] geteilteRegalNummer = Regal_Businesslogik.regalNummerAufteilen(suchArtikel.regalNummer);
		
		for(int i = 0; i < geteilteRegalNummer.length; i++) {
			
			System.out.println(geteilteRegalNummer[i]);
		}
		
		if(!suchArtikel.name.isEmpty()) {
			
			suchParameterAnzahl++;
		}
		
		if(suchArtikel.preis != 0) {
			
			suchParameterAnzahl++;
		}
		
		if(suchArtikel.gewicht != 0) {
			
			suchParameterAnzahl++;
		}
		
		if(suchArtikel.bestand != 0) {
			
			suchParameterAnzahl++;
		}
		
		if(!suchArtikel.kategorie.equals("Keine Kategorie")) {
			
			suchParameterAnzahl++;
		}
		
		if(!geteilteRegalNummer[0].equals("_")) {
			
			suchParameterAnzahl++;
		}
		
		if(!geteilteRegalNummer[1].equals("_")) {
			
			suchParameterAnzahl++;
		}
		
		if(!geteilteRegalNummer[2].equals("_")) {
			
			suchParameterAnzahl++;
		}
		
		if(!geteilteRegalNummer[3].equals("___")) {
			
			suchParameterAnzahl++;
		}
		
		for(int i = 0; i < artikelListe.size(); i++) {
			
			Artikel aktuellerArtikel = artikelListe.get(i);
			String[] geteilteReaglnummerDesAktuellenArtikels = Regal_Businesslogik.regalNummerAufteilen(aktuellerArtikel.regalNummer);			
			int gefundeneParameter = 0;
			
			if(!suchArtikel.name.isEmpty()) {
				
				if(aktuellerArtikel.name.toLowerCase().contains(suchArtikel.name.toLowerCase())) {
					
					gefundeneParameter++;
				
				} else {
					
					continue;
				}
			}
			
			if(suchArtikel.preis != 0) {
				
				if(aktuellerArtikel.preis == suchArtikel.preis) {
					
					gefundeneParameter++;
					
				}  else {
					
					continue;
				}
			}

			if(suchArtikel.gewicht != 0) {
				
				if(aktuellerArtikel.gewicht == suchArtikel.gewicht) {
					
					gefundeneParameter++;
					
				}  else {
					
					continue;
				}
			}
			
			if(suchArtikel.bestand != 0) {
				
				if(aktuellerArtikel.bestand == suchArtikel.bestand) {
					
					gefundeneParameter++;
					
				}  else {
					
					continue;
				}
			}
			
			if(!suchArtikel.kategorie.equals("Keine Kategorie")) {
				
				if(aktuellerArtikel.kategorie.equals(suchArtikel.kategorie)) {
					
					gefundeneParameter++;
					
				}   else {
					
					continue;
				}
			}
			
			if(!geteilteRegalNummer[0].equals("_")) {
				
				if(geteilteReaglnummerDesAktuellenArtikels[0].equals(geteilteRegalNummer[0])) {
					
					gefundeneParameter++;
					
				} else {
					
					continue;
				}
			}
			
			if(!geteilteRegalNummer[1].equals("_")) {
						
				if(geteilteReaglnummerDesAktuellenArtikels[1].equals(geteilteRegalNummer[1])) {
					
					gefundeneParameter++;
					
				} else {
					
					continue;
				}
			}
			
			if(!geteilteRegalNummer[2].equals("_")) {
				
				if(geteilteReaglnummerDesAktuellenArtikels[2].equals(geteilteRegalNummer[2])) {
					
					gefundeneParameter++;
					
				}  else {
					
					continue;
				}
			}
			
			if(!geteilteRegalNummer[3].equals("___")) {
				
				if(geteilteReaglnummerDesAktuellenArtikels[3].equals(geteilteRegalNummer[3])) {
					
					gefundeneParameter++;
					
				} else {
					
					continue;
				}
			}
			
			if(gefundeneParameter == suchParameterAnzahl) {
				
				gefundeneArtikel.add(aktuellerArtikel);
			}
		}
		
		return gefundeneArtikel;
	}
	
	/**
	 * �bersetzt eine Liste von Artikeln in eine Darstellung, die in einem JTable dargestellt werden kann
	 * 
	 * @param ArrayList<Artikel>, Liste von Artikeln die in der Tabelle angezeigt werden sollen
	 * 
	 * @return  String[][], Array welcher in der Tabelle angezeigt wird
	 */
	public static String[][] artikelListeZuTabelle(ArrayList<Artikel> artikelListe) {
		
		String[][] tabelle = new String[artikelListe.size()][2];
		
		for(int i = 0; i < artikelListe.size(); i++) {
			
			tabelle[i][0] = artikelListe.get(i).name;
			tabelle[i][1] = artikelListe.get(i).regalNummer;
		}
		
		return tabelle;
	}
	
	/**
	 * F�gt einen Artikel zu der Datei "artikel.xml" hinzu.
	 * 
	 * @param Artikel neuerArtikel, artikel der neu hinzugef�gt werden soll
	 * @param ArrayList<Regal> regalListe, Liste der Regale, welche zur �berpr�fung der Kapazit�t n�tig sind
	 * @param Kategorie kategorie, kategorie des neuen Artikels
	 * 
	 * @return boolean erfolgreich, Wahrheitswert, ob der neue Artikel ohne Problem hinzugef�gt werden konnte.
	 */
	public static boolean artikelHinzufuegen(Artikel neuerArtikel, ArrayList<Regal> regalListe, Kategorie kategorie) {
		
		Regal regalDesArtikels = Regal_Businesslogik.regalAusListeBekommen(regalListe, (String) neuerArtikel.regalNummer.substring(0, 3));
		boolean erfolgreich = false;
		
		if(regalDesArtikels.regalUeberfuellt(neuerArtikel.gewicht * neuerArtikel.bestand)) {
			
			JOptionPane.showMessageDialog(null, "Der Artikel konnte nicht zum Regal hinzugef�gt werden, da es sonst �berladen w�re. Ben�tigt: " + neuerArtikel.gewicht * neuerArtikel.bestand + " Verf�gbar: " + (regalDesArtikels.maximaleKapazitaet - regalDesArtikels.aktuelleKapazitaet));
			
		} else {
			
			ArrayList<Artikel> artikelListe = Artikel_Businesslogik.artikelLaden();
			
			if(artikelListe.contains(neuerArtikel)) {
				
				JOptionPane.showMessageDialog(null, "Ein Artikel mit diesem Namen oder dieser Regalnummer existiert bereits.");
				
			} else {
				
				regalDesArtikels.aktuelleKapazitaet -= neuerArtikel.gewicht * neuerArtikel.bestand;
				
				artikelListe.add(neuerArtikel);
				
				Artikel_Businesslogik.artikelListeSpeichern(artikelListe);
				
				Regal_Businesslogik.listeDerRegalSpeichern(regalListe);
				
				ArrayList<Kategorie> kategorieListe = Kategorie_Businesslogik.kategorienLaden();
				
				Kategorie benutzeKategorie = kategorieListe.get(kategorieListe.indexOf(kategorie));
				
				benutzeKategorie.zugehoerigeArtikelErhoehen();
				
				Kategorie_Businesslogik.listeDerKategorienSpeichern(kategorieListe);
				
				erfolgreich = true;
			}
		}
		
		return erfolgreich;
	}
	
	/**
	 * Methode welche den Fall behandelt, das beim Bearbeiten eines Artikels das Gewicht, der Bestand und die Regal/Abteilungs/UnterABteilungsNummer ver�ndert wird
	 * 
	 * @return boolean erfolgreich, Wahrheitswert ob das bearbeiten erfolgreich war
	 */
	private static boolean gewichtUndBestandUndRegalAbteilungUnterAbteilungAktualisieren(Artikel neuerArtikel, Artikel alterArtikel, ArrayList<Regal> regalListe, ArrayList<Artikel> artikelListe, ArrayList<Artikel> gefundeneArtikel) {
		
		boolean erfolgreich = false;
		
		Regal regal = Regal_Businesslogik.regalAusListeBekommen(regalListe, neuerArtikel.regalNummer.substring(0, 3));
		Regal altesRegal = Regal_Businesslogik.regalAusListeBekommen(regalListe, alterArtikel.regalNummer.substring(0, 3));
		
		if(regal.regalUeberfuellt(neuerArtikel.gewicht * neuerArtikel.bestand)) {
			
			JOptionPane.showMessageDialog(null, "Das Regal w�re �berf�llt.");
			
		} else {
			
			if(artikelListe.contains(new Artikel("", neuerArtikel.regalNummer, 0, 0, 0, ""))) {
				
				JOptionPane.showMessageDialog(null, "Ein Artikel mit dieser Regalnummer existiert bereits.");
				
			} else {
				
				regal.aktuelleKapazitaet -= neuerArtikel.gewicht * neuerArtikel.bestand;
				altesRegal.aktuelleKapazitaet += alterArtikel.gewicht * alterArtikel.bestand;
				
				erfolgreich = true;
			}
		}
		
		if(erfolgreich) {
			
			artikelListe.remove(alterArtikel);
			artikelListe.add(neuerArtikel);
			
			gefundeneArtikel.remove(alterArtikel);
			gefundeneArtikel.add(neuerArtikel);
			
			Regal_Businesslogik.listeDerRegalSpeichern(regalListe);
			artikelListeSpeichern(artikelListe);
		}
		
		
		return erfolgreich;
	}
	
	/**
	 * Methode welche den Fall behandelt, das beim Bearbeiten eines Artikels das Gewicht und die Regal/Abteilungs/UnterABteilungsNummer ver�ndert wird
	 * 
	 * @return boolean erfolgreich, Wahrheitswert ob das bearbeiten erfolgreich war
	 */
	private static boolean gewichtUndRegalAbteilungUnterAbteilungAktualisieren(Artikel neuerArtikel, Artikel alterArtikel, ArrayList<Regal> regalListe, ArrayList<Artikel> artikelListe, ArrayList<Artikel> gefundeneArtikel) {
		
		boolean erfolgreich = false;
		Regal regal = Regal_Businesslogik.regalAusListeBekommen(regalListe, neuerArtikel.regalNummer.substring(0, 3));
		Regal altesRegal = Regal_Businesslogik.regalAusListeBekommen(regalListe, alterArtikel.regalNummer.substring(0, 3));
		
		if(regal.regalUeberfuellt(neuerArtikel.gewicht * neuerArtikel.bestand)) {
			
			JOptionPane.showMessageDialog(null, "Das Regal w�re �berf�llt.");
			
		} else {
			
			if(artikelListe.contains(new Artikel("", neuerArtikel.regalNummer, 0, 0, 0, ""))) {
				
				JOptionPane.showMessageDialog(null, "Ein Artikel mit dieser Regalnummer existiert bereits.");
				
			} else {
				
				regal.aktuelleKapazitaet -= neuerArtikel.gewicht * neuerArtikel.bestand;
				altesRegal.aktuelleKapazitaet += alterArtikel.gewicht * neuerArtikel.bestand;
				
				erfolgreich = true;
			}
		}
		
		if(erfolgreich) {
			
			artikelListe.remove(alterArtikel);
			artikelListe.add(neuerArtikel);
			
			gefundeneArtikel.remove(alterArtikel);
			gefundeneArtikel.add(neuerArtikel);
			
			Regal_Businesslogik.listeDerRegalSpeichern(regalListe);
			artikelListeSpeichern(artikelListe);
		}
		
		return erfolgreich;
	}
	
	/**
	 * Methode welche den Fall behandelt, das beim Bearbeiten eines Artikels das Gewicht ver�ndert wird
	 * 
	 * @return boolean erfolgreich, Wahrheitswert ob das bearbeiten erfolgreich war
	 */
	private static boolean gewichtAktualisieren(Artikel neuerArtikel, Artikel alterArtikel, ArrayList<Regal> regalListe, ArrayList<Artikel> artikelListe, ArrayList<Artikel> gefundeneArtikel) {
				
		Regal regal = Regal_Businesslogik.regalAusListeBekommen(regalListe, alterArtikel.regalNummer.substring(0, 3));	
		double auslastungsZuwachs;
		boolean erfolgreich = false;
			
		if(alterArtikel.gewicht > neuerArtikel.gewicht) {
				
			auslastungsZuwachs = (alterArtikel.gewicht - neuerArtikel.gewicht) * neuerArtikel.bestand;
				
			regal.aktuelleKapazitaet += auslastungsZuwachs;
			
			erfolgreich = true;
				
		} else {
				
			if(alterArtikel.gewicht < neuerArtikel.gewicht) {
					
				auslastungsZuwachs = (neuerArtikel.gewicht - alterArtikel.gewicht) * neuerArtikel.bestand;
					
				if(regal.regalUeberfuellt(auslastungsZuwachs)) {
						
					JOptionPane.showMessageDialog(null, "Das Regal w�re �berf�llt.");
						
				} else {
						
					regal.aktuelleKapazitaet -= auslastungsZuwachs;
					
					erfolgreich = true;
				}
			}
		}
		
		if(erfolgreich) {
			
			artikelListe.remove(alterArtikel);
			artikelListe.add(neuerArtikel);
			
			gefundeneArtikel.remove(alterArtikel);
			gefundeneArtikel.add(neuerArtikel);
			
			artikelListeSpeichern(artikelListe);
			
			Regal_Businesslogik.listeDerRegalSpeichern(regalListe);
		}
		
		return erfolgreich;
	}
	
	/**
	 * Methode welche den Fall behandelt, das beim Bearbeiten eines Artikels die Regal/Abteilungs/UnterABteilungsNummer ver�ndert wird
	 * 
	 * @return boolean erfolgreich, Wahrheitswert ob das bearbeiten erfolgreich war
	 */
	private static boolean regalAbteilungUnterAbteilungAktualisieren(Artikel neuerArtikel, Artikel alterArtikel, ArrayList<Regal> regalListe, ArrayList<Artikel> artikelListe, ArrayList<Artikel> gefundeneArtikel) {
		
		boolean erfolgreich = false;
		
		if(artikelListe.contains(new Artikel("", neuerArtikel.regalNummer, 0,0,0,""))) {
			
			JOptionPane.showMessageDialog(null, "Es existiert bereits ein Artikel mit dieser Nummer.");
			
		} else {
			
			Regal regal = Regal_Businesslogik.regalAusListeBekommen(regalListe, (String) neuerArtikel.regalNummer.substring(0, 3));
			Regal altesRegal = Regal_Businesslogik.regalAusListeBekommen(regalListe, (String) alterArtikel.regalNummer.substring(0, 3));
			
			if(regal.regalUeberfuellt((neuerArtikel.gewicht * neuerArtikel.bestand))) {
				
				JOptionPane.showMessageDialog(null, "Das Regal w�re �berf�llt.");
				
			} else {
				
				altesRegal.aktuelleKapazitaet += (neuerArtikel.gewicht * neuerArtikel.bestand);
				regal.aktuelleKapazitaet -= (neuerArtikel.gewicht * neuerArtikel.bestand);
				
				erfolgreich = true;
			}
		}
		
		if(erfolgreich) {
			
			artikelListe.remove(alterArtikel);
			artikelListe.add(neuerArtikel);
			
			gefundeneArtikel.remove(alterArtikel);
			gefundeneArtikel.add(neuerArtikel);
			
			Regal_Businesslogik.listeDerRegalSpeichern(regalListe);
			
			artikelListeSpeichern(artikelListe);
		}
		
		return erfolgreich;
	}
	
	/**
	 * Methode welche den Fall behandelt, das beim Bearbeiten eines Artikels die Fachnummer ver�ndert wird
	 * 
	 * @return boolean erfolgreich, Wahrheitswert ob das bearbeiten erfolgreich war
	 */
	private static boolean fachAktualisieren(Artikel neuerArtikel, Artikel alterArtikel, ArrayList<Artikel> artikelListe, ArrayList<Artikel> gefundeneArtikel) {
		
		boolean erfolgreich = false;
		
		if(artikelListe.contains(new Artikel("", neuerArtikel.regalNummer, 0, 0, 0, ""))) {
			
			JOptionPane.showMessageDialog(null, "Es existiert bereits ein Artikel mit dieser Nummer.");
			
		} else {
			
			artikelListe.remove(alterArtikel);
			artikelListe.add(neuerArtikel);
			
			gefundeneArtikel.remove(alterArtikel);
			gefundeneArtikel.add(neuerArtikel);
			
			artikelListeSpeichern(artikelListe);
			
			erfolgreich = true;
		}
		
		return erfolgreich;
	}
	
	/**
	 * Methode welche den Fall behandelt, das beim Bearbeiten eines Artikels die Kategorie ver�ndert wird
	 * 
	 * @return boolean erfolgreich, Wahrheitswert ob das bearbeiten erfolgreich war
	 */
	private static void kategorieAktualisieren(Artikel neuerArtikel, Artikel alterArtikel, ArrayList<Artikel> artikelListe, ArrayList<Artikel> gefundeneArtikel) {
		
		ArrayList<Kategorie> kategorienListe = Kategorie_Businesslogik.kategorienLaden();
		
		Kategorie alteKategorie = kategorienListe.get(kategorienListe.indexOf(new Kategorie(alterArtikel.kategorie)));
		alteKategorie.zugehoerigeArtikelVeringern();
		Kategorie neueKategorie = kategorienListe.get(kategorienListe.indexOf(new Kategorie(neuerArtikel.kategorie)));
		neueKategorie.zugehoerigeArtikelErhoehen();
		
		artikelListe.remove(alterArtikel);
		artikelListe.add(neuerArtikel);
		gefundeneArtikel.remove(alterArtikel);
		gefundeneArtikel.add(neuerArtikel);
		
		artikelListeSpeichern(artikelListe);
		Kategorie_Businesslogik.listeDerKategorienSpeichern(kategorienListe);
	}
	
	/**
	 * Methode welche den Fall behandelt, das beim Bearbeiten eines Artikels der Name ver�ndert wird
	 * 
	 * @return boolean erfolgreich, Wahrheitswert ob das bearbeiten erfolgreich war
	 */
	private static boolean nameAktualisieren(Artikel neuerArtikel, Artikel alterArtikel, ArrayList<Artikel> artikelListe, ArrayList<Artikel> gefundeneArtikel) {
		
		boolean erfolgreich = false;
		
		if(artikelListe.contains(new Artikel(neuerArtikel.name, "", 0, 0, 0, ""))) {
			
			JOptionPane.showMessageDialog(null, "Ein Artikel mit diesem Namen existiert bereits.");
			
		} else {
			
			artikelListe.remove(alterArtikel);
			artikelListe.add(neuerArtikel);
			
			gefundeneArtikel.remove(alterArtikel);
			gefundeneArtikel.add(neuerArtikel);
			
			artikelListeSpeichern(artikelListe);
			
			erfolgreich = true;
		}
		
		return erfolgreich;
	}
	
	/**
	 * Methode welche den Fall behandelt, das beim Bearbeiten eines Artikels der Preis ver�ndert wird
	 * 
	 * @return boolean erfolgreich, Wahrheitswert ob das bearbeiten erfolgreich war
	 */
	private static void preisAktualisieren(Artikel neuerArtikel, Artikel alterArtikel, ArrayList<Artikel> artikelListe, ArrayList<Artikel> gefundeneArtikel) {
		
		artikelListe.remove(alterArtikel);
		artikelListe.add(neuerArtikel);
		
		gefundeneArtikel.remove(alterArtikel);
		gefundeneArtikel.add(neuerArtikel);
		
		artikelListeSpeichern(artikelListe);
	}
	
	/**
	 * Methode welche den Fall behandelt, das beim Bearbeiten eines Artikels der Bestand ver�ndert wird
	 * 
	 * @return boolean erfolgreich, Wahrheitswert ob das bearbeiten erfolgreich war
	 */
	private static boolean bestandAktualisieren(Artikel neuerArtikel, Artikel alterArtikel, ArrayList<Regal> regalListe, ArrayList<Artikel> artikelListe, ArrayList<Artikel> gefundeneArtikel) {
		
		boolean erfolgreich = false;
		Regal regal = Regal_Businesslogik.regalAusListeBekommen(regalListe, (String) neuerArtikel.regalNummer.substring(0, 3));
		double auslastungsZuwachs;
		
		if(neuerArtikel.bestand > alterArtikel.bestand) {
			
			auslastungsZuwachs = ( neuerArtikel.bestand - alterArtikel.bestand) * neuerArtikel.gewicht;
			
			if(regal.regalUeberfuellt(auslastungsZuwachs)) {
				
				JOptionPane.showMessageDialog(null, "Das Regal w�re �berlastet.");
				
			} else {
				
				regal.aktuelleKapazitaet -= auslastungsZuwachs;
				
				erfolgreich = true;
			}
			
		} else {
			
			if(neuerArtikel.bestand < alterArtikel.bestand) {
				
				auslastungsZuwachs = (alterArtikel.bestand - neuerArtikel.bestand) * neuerArtikel.gewicht;
				
				regal.aktuelleKapazitaet += auslastungsZuwachs;
				
				erfolgreich = true;
			}
		}
		
		if(erfolgreich) {
			
			Regal_Businesslogik.listeDerRegalSpeichern(regalListe);
			
			artikelListe.remove(alterArtikel);
			artikelListe.add(neuerArtikel);
			
			gefundeneArtikel.remove(alterArtikel);
			gefundeneArtikel.add(neuerArtikel);
			
			artikelListeSpeichern(artikelListe);
		}
		
		return erfolgreich;
	}
	
	/**
	 * Methode welche den Fall behandelt, das beim Bearbeiten eines Artikels das Gewicht und der Bestand ver�ndert wird
	 * 
	 * @return boolean erfolgreich, Wahrheitswert ob das bearbeiten erfolgreich war
	 */
	private static boolean bestandUndGewichtAktualisieren(Artikel neuerArtikel, Artikel alterArtikel, ArrayList<Regal> regalListe, ArrayList<Artikel> artikelListe, ArrayList<Artikel> gefundeneArtikel) {
		
		boolean erfolgreich = false;
		Regal regal = Regal_Businesslogik.regalAusListeBekommen(regalListe, (String) neuerArtikel.regalNummer.substring(0,3));
		
		regal.aktuelleKapazitaet += (alterArtikel.bestand * alterArtikel.gewicht);
		
		if(regal.regalUeberfuellt((neuerArtikel.bestand * neuerArtikel.gewicht))) {
			
			JOptionPane.showMessageDialog(null, "Das Regal w�re �berlastet.");
			
		} else {
			
			regal.aktuelleKapazitaet -= (neuerArtikel.bestand * neuerArtikel.gewicht);
			
			erfolgreich = true;
		}
		
		if(erfolgreich) {
			
			Regal_Businesslogik.listeDerRegalSpeichern(regalListe);
			
			artikelListe.remove(alterArtikel);
			artikelListe.add(neuerArtikel);
			
			gefundeneArtikel.remove(alterArtikel);
			gefundeneArtikel.add(neuerArtikel);
			
			artikelListeSpeichern(artikelListe);
		}
		
		return erfolgreich;
	}
	
	/**
	 * Methode welche zwischen verschiedenen F�llen, welche beim Bearebiten auftreten k�nnen unterscheidet. Sie sorgt f�r eine Synchronit�t zwischen den verschiedenen xml Dateien und Regalen
	 * 
	 * @return boolean erfolgreich, Wahrheitswert ob das bearbeiten erfolgreich war
	 */
	public static boolean artikelBearbeiten(Artikel neuerArtikel, Artikel alterArtikel, ArrayList<Artikel> gefundeneArtikel) {
		
		ArrayList<Artikel> artikelListe = Artikel_Businesslogik.artikelLaden();
		ArrayList<Regal> regalListe = Regal_Businesslogik.regaleLaden();
		boolean erfolgreich = false;
		
		if(neuerArtikel.name.equals(alterArtikel.name) && neuerArtikel.regalNummer.equals(alterArtikel.regalNummer) && neuerArtikel.kategorie.equals(alterArtikel.kategorie) && neuerArtikel.preis == alterArtikel.preis && neuerArtikel.bestand == alterArtikel.bestand && neuerArtikel.gewicht == alterArtikel.gewicht) {
			
			
			JOptionPane.showMessageDialog(null, "Es wurden keine �nderungen gemacht.");
			return true;
		}
		
		if(neuerArtikel.gewicht != alterArtikel.gewicht && !neuerArtikel.regalNummer.subSequence(0, 3).equals(alterArtikel.regalNummer.subSequence(0, 3)) && neuerArtikel.bestand != alterArtikel.bestand) {
			
			if(gewichtUndBestandUndRegalAbteilungUnterAbteilungAktualisieren(neuerArtikel, alterArtikel, regalListe, artikelListe, gefundeneArtikel)) {
				
				erfolgreich = true;
			}
			
		} else {
			
			if(neuerArtikel.gewicht != alterArtikel.gewicht) {
			
				if(neuerArtikel.gewicht != alterArtikel.gewicht && !neuerArtikel.regalNummer.subSequence(0, 3).equals(alterArtikel.regalNummer.subSequence(0, 3))) {
					
					if(gewichtUndRegalAbteilungUnterAbteilungAktualisieren(neuerArtikel, alterArtikel, regalListe, artikelListe, gefundeneArtikel)) {
						
						erfolgreich = true;
					}
				
				} else {
					
					if(neuerArtikel.gewicht != alterArtikel.gewicht && neuerArtikel.bestand != alterArtikel.bestand) {
						
						if(bestandUndGewichtAktualisieren(neuerArtikel, alterArtikel, regalListe, artikelListe, gefundeneArtikel)) {
							
							erfolgreich = true;
						}
					
					} else {
						
						if(neuerArtikel.gewicht != alterArtikel.gewicht) {
							
							System.out.println("Nur das Gewicht wurde ver�ndert");
							
							if(gewichtAktualisieren(neuerArtikel, alterArtikel, regalListe, artikelListe, gefundeneArtikel)) {
								
								erfolgreich = true;
							}
						}
					}
				}
				
			} else {
				
				if(neuerArtikel.bestand != alterArtikel.bestand) {
					
					if(bestandAktualisieren(neuerArtikel, alterArtikel, regalListe, artikelListe, gefundeneArtikel)) {
						
						erfolgreich = true;
					}
				}
				
				// Nur das Regal oder die Abteilung / UnterAbteilung wurden ver�ndert
				if(!neuerArtikel.regalNummer.subSequence(0, 3).equals(alterArtikel.regalNummer.subSequence(0, 3))) {
						
					System.out.println(" Nur das Regal oder die Abteilung / UnterAbteilung wurden ver�ndert");
						
					if(regalAbteilungUnterAbteilungAktualisieren(neuerArtikel, alterArtikel, regalListe, artikelListe, gefundeneArtikel)) {
							
						erfolgreich = true;
					}
				}
						
				// Nur das Fach wurde ver�ndert
				if(!neuerArtikel.regalNummer.subSequence(3, 6).equals(alterArtikel.regalNummer.subSequence(3, 6))) {
						
					System.out.println("Nur Fach wurde ver�ndert");
					if(fachAktualisieren(neuerArtikel, alterArtikel, artikelListe, gefundeneArtikel)) {
						
						erfolgreich = true;
					}
				}
				
				
				// Die Kategorie wurde ver�ndert
				if(!neuerArtikel.kategorie.equals(alterArtikel.kategorie)) {
					
					kategorieAktualisieren(neuerArtikel, alterArtikel, artikelListe, gefundeneArtikel);
					
					erfolgreich = true;
				}
				
				// Die Artikelbezeichnung wurde ver�ndert
				if(!neuerArtikel.name.equals(alterArtikel.name)) {
					
					if(nameAktualisieren(neuerArtikel, alterArtikel, artikelListe, gefundeneArtikel)) {
						
						erfolgreich = true;
					}
				}
				
				// Der Preis wurde ver�ndert
				if(neuerArtikel.preis != alterArtikel.preis) {
					
					preisAktualisieren(neuerArtikel, alterArtikel, artikelListe, gefundeneArtikel);
					
					erfolgreich = true;
				}
			}
		}

		return erfolgreich;
	}
}
