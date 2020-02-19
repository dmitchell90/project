package Benutzeroberflaeche;

import BusinessLogik.Kategorie;

/**
 * Klasse zur Sammlung aller Methoden, die genutzt werden um die Eingaben des Nutzers auf ihre Korrektheit zu �berpr�fen.
 *
 */

public class EingabeRegeln {
	
	public static String fehlerNachricht = "";
	public static int fehlerZaehler = 0;
	
	/**
	 * Methode um die ausgegebene Fehlernachricht und den Fehlerz�hler zur�ckzusetzten.
	 */
	public static void aufNullSetzten() {
		fehlerNachricht = "";
		fehlerZaehler = 0;
	}
	
	/**
	 * Methode welche �berprf�t ob "zeichenKette" l�nger als 256 Zeichen ist.
	 * 
	 * @param String zeichenkette, welche auf ihre L�nge �berpr�ft wird
	 * 
	 * @return Wahrheitswert ob die Zecihenkette l�nger als 256 Zeichen war oder nicht.
	 */
	public static boolean mehrAls256Zeichen(String zeichenkette) {
		
		boolean ergebnis = true;
		
		if (zeichenkette.length()<=256) {
			
			ergebnis = false;	
		}
		
		return ergebnis;
	}
	
	/**
	 * Methode welche �berprf�t ob "zahlenkette" gr��er als 10000000 ist
	 * 
	 * @param String zahlenkette, welche auf ihre Gr��e �berpr�ft wird
	 * 
	 * @return Wahrheitswert ob die Zahlenkette gr��er als 10000000 war oder nicht.
	 */
	public static boolean MaximalGewicht(String zahlenkette) {
		
		boolean ergebnis = true;
		
		if (Double.parseDouble(zahlenkette)>10000000) {
			
			ergebnis = false;
		}
		
		return ergebnis;	
	}
	
	/**
	 * Methode welche �berprf�t ob "zahlenkette" gr��er als 0.01 ist
	 * 
	 * @param String zahlenkette, welche auf ihre Gr��e �berpr�ft wird
	 * 
	 * @return Wahrheitswert ob die Zahlenkette gr��er als 0.01 war oder nicht.
	 */
	public static boolean MinimalGewicht(String zahlenkette) {
		
		boolean ergebnis = true;
		
		if (Double.parseDouble(zahlenkette)<0.01) {
			
			ergebnis = false;
			
		}
		
		return ergebnis;
	}
	
	/**
	 * Methode welche �berprf�t ob "zahlenkette" gr��er als 100000000 ist
	 * 
	 * @param String zahlenkette, welche auf ihre Gr��e �berpr�ft wird
	 * 
	 * @return Wahrheitswert ob die Zahlenkette gr��er als 100000000 war oder nicht.
	 */
	public static boolean MaximalBestand(String zahlenkette) {
		
		boolean ergebnis = true;
		
		if (Integer.parseInt(zahlenkette)>100000000) {
			
			ergebnis = false;
			
		}
		
		return ergebnis;
		
	}
	
	/**
	 * Methode welche �berprf�t ob "zahlenkette" gr��er/gleich 0 ist. 
	 * 
	 * @param String zahlenkette, welche auf ihre Gr��e �berpr�ft wird
	 * 
	 * @return Wahrheitswert ob die Zahlenkette gr��er als 0 war oder nicht.
	 */
	public static boolean MinimalBestand(String zahlenkette) {
		
		boolean ergebnis = true;	
		
		if (Integer.parseInt(zahlenkette)<0) {
			
			ergebnis = false;
			
		}
		
		return ergebnis;
	}
	
	/**
	 * Methode welche �berprf�t ob "zahlenkette" kleiner als 99999 ist
	 * 
	 * @param String zahlenkette, welche auf ihre Gr��e �berpr�ft wird
	 * 
	 * @return Wahrheitswert ob die Zahlenkette kleiner als 99999 war oder nicht.
	 */
	public static boolean MaximalPreis(String zahlenkette) {
		
		boolean ergebnis = true;
		
		if (Double.parseDouble(zahlenkette)>99999) {
			
			ergebnis = false;
			
		}
		
		return ergebnis;	
	}
	
	/**
	 * Methode welche �berprf�t ob "zahlenkette" gr��er als 0.01 ist
	 * 
	 * @param String zahlenkette, welche auf ihre Gr��e �berpr�ft wird
	 * 
	 * @return Wahrheitswert ob die Zahlenkette gr��er als 0.01 war oder nicht.
	 */
	public static boolean MinimalPreis(String zahlenkette) {
		
		boolean ergebnis = true;
		
		if (Double.parseDouble(zahlenkette)<0.01) {
			
			ergebnis = false;
			
		}
		
		return ergebnis;
		
	}
	
	/**
	 * Methode welche die Fehlernachricht um eine neue fehlermeldung erweitert und den fehlerz�hler um 1 erh�ht. fehlerZaehler und fehlerNachricht sind statische Felder der Klasse EinagebRegeln.
	 * 
	 * @param String fehlermeldung, welche zur fehlerNachricht hinzugef�gt wird.
	 * 
	 */
	public static void fehlermeldungErweitern( String fehlermeldung) {
		
		fehlerZaehler++;
		fehlerNachricht += fehlermeldung + "\n";
	}
	
	/**
	 * Methode welche �berprf�t ob eine Kategorie ausgew�hlt wurde, deren Name nicht "Keine Kategorie" ist.
	 * Dient zur Feststellung ob eine Kategorie ausgew�hlt wurde.
	 * 
	 * @param Kategorie kategorie, welche �berpr�ft wird
	 * 
	 * @return Wahrheitswert ob die kategorie den Namen "Keine Kategorie" hatte oder nicht
	 */
	public static boolean kategorieAusgewaehlt(Kategorie kategorie) {
		
		if(kategorie.name.equals("Keine Kategorie")) {
			
			fehlermeldungErweitern( "- Wählen Sie eine Kategorie aus");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Methode welche �berprf�t ob mindestens ein Eingabefled ausgef�llt wurde.
	 * Dient zur Feststellung ob mindestens ein Feld zur Suche ausgef�llt wurde.
	 * 
	 * @param String artikelbezeichnung, Inhalt des Eingabefeldes Artikelbezeichnung
	 * @param String bestand, Inhalt des Eingabefeldes Bestand
	 * @param String gewicht, Inhalt des Eingabefeldes Gewicht
	 * @param String preis, Inhalt des Eingabefeldes Preis
	 * @param String regal, Inhalt des Eingabefeldes f�r die Ziffer des Regals
	 * @param String abteilung, Inhalt des Eingabefeldes f�r die Ziffer der Abteilung
	 * @param String unterAbteilung, Inhalt des Eingabefeldes f�r die Ziffer der UnterAbteilung
	 * @param String fach, Inhalt des Eingabefeldes f�r die 3-Stellige Zahl zur Fach identifikation
	 * @param String kategorie, Inhalt des DropDownMen�s zur Auswahl der Kategorie
	 * 
	 * 
	 * @return Wahrheitswert ob eines der oben genannten Felder einen validen Wert besitzt
	 */
	public static boolean mindestensEinFeldAusgefuellt(String artikelbezeichnung, String bestand, String gewicht, String preis, String regal, String abteilung, String unterabteilung, String fach, String kategorie) {
		
		boolean istKorrekt = true;
		
		if (artikelbezeichnung.isEmpty() && kategorie.equals("Keine Kategorie") ) {
				
				if(bestand.isEmpty()){
					
					if(gewicht.isEmpty()) {
						
						if(preis.isEmpty()) {
							
							if(regal.isEmpty()) {
								
								if(abteilung.isEmpty()) {
									if(unterabteilung.isEmpty()) {
										
										if(fach.isEmpty()) {
											istKorrekt = false;
											fehlermeldungErweitern( "- Füllen Sie mindestens ein Feld aus!!!");
										}
									}	
								}
							}
						}
					}
				}
			}
			return istKorrekt;
		}
	
	/**
	 * Methode welche �berprf�t ob die Artikelbezeichnung weder leer, noch l�nger als 256 Zeichen ist und nur die folgenden Sonderzeichen enth�lt.
	 * ( ) . !  ? -
	 * 
	 * @param String artikelbezeichnung, welcher auf die oben genannten Regeln �berpr�ft wird.
	 * 
	 * @return Wahrheitswert ob die artikelbezeichnung den Regeln entspricht
	 */
	public static boolean korrektheitArtikelbezeichnung(String artikelbezeichnung) {
		
		boolean istKorrekt = true;
		
		if (artikelbezeichnung.isEmpty()) {
			
			fehlermeldungErweitern( "- Bitte füllen Sie das Feld Artikelbezeichnung aus!!");
			
			istKorrekt = false;
		
		} else {
		
			if (mehrAls256Zeichen(artikelbezeichnung)) {
			
				fehlermeldungErweitern( "- Das Feld Artikelbezeichnung wurde mit mehr als 256 Zeichen ausgefüllt!! ");
				istKorrekt = false;
			}
		
//			if (!artikelbezeichnung.matches("[�������\\d\\w\\(\\)\\.\\!\\?-]+")){
//			
//				fehlermeldungErweitern("- Sie haben unerlaubte Zeichen im Feld Artikelbezeichnung benutzt!! ");
//				istKorrekt = false;	
//			}
		}
		
		return istKorrekt;
	}
	
	/**
	 * Methode welche �berprf�t ob der Name einer Kategorie weder leer, noch l�nger als 256 Zeichen ist und nur Buchstaben und Umlaute enth�lt
	 * 
	 * @param String kategoriename, welcher auf die oben genannten Regeln �berpr�ft wird.
	 * 
	 * @return Wahrheitswert ob der kategoriename den Regeln entspricht
	 */
	public static boolean korrektheitKategoriename(String kategoriename) {
		
		boolean istKorrekt = true;
		
		if (kategoriename.isEmpty()) {
			
			fehlermeldungErweitern( "- Bitte füllen Sie das Feld Kategoriename aus!!");
			istKorrekt = false;
		
		} else {
			
			if (mehrAls256Zeichen(kategoriename)) {
			
				fehlermeldungErweitern( "- Das Feld Kategoriename wurde mit mehr als 256 Zeichen ausgefüllt!! ");
				istKorrekt = false;
			}
		
			if (!kategoriename.matches("[�������0-9A-Za-z]+")){
				
				fehlermeldungErweitern("- Sie haben unerlaubte Zeichen im Feld Kategorienamen benutzt!! ");
				istKorrekt = false;	
	
			}
		}
		
		return istKorrekt;
		
	}
	
	/**
	 * Methode welche �berprf�t ob das Gewicht eines Artikels nicht leer, nur aus Zahlen mit maximal 2 Nachkommastellen, weniger als 100000 Gramm und mehr als 0.1 Gramm besitzt
	 * 
	 * @param String gewicht, welches auf die oben genannten Regeln �berpr�ft wird.
	 * 
	 * @return Wahrheitswert ob das gewicht den Regeln entspricht
	 */
	public static boolean korrektheitGewicht(String gewicht) {
		
		boolean istKorrekt = true;
		
		
		if (gewicht.isEmpty()) {
			
			fehlermeldungErweitern( "- Bitte füllen Sie das Feld Gewicht aus!!");
			istKorrekt = false;
		}
		else {
			if (!gewicht.matches("[0-9]+\\.[0-9][0-9][0-9]")){
			
				fehlermeldungErweitern("-Sie haben unerlaubte Zeichen im Feld Gewicht benutzt!!\\n Bitte geben Sie das Gewicht im Format z.B. 99.99 ein. ");
				istKorrekt = false;	
			}
			else {
		
				if (!MinimalGewicht(gewicht)){
				
					fehlermeldungErweitern("- Das minimal erlaubte Gewicht beträgt 0.01 Gramm ");
					istKorrekt = false;	
	
				}
			
				if (!MaximalGewicht(gewicht)){
				
					fehlermeldungErweitern("- Das maximal erlaubte Gewicht beträgt 10 000 000 Gramm ");
					istKorrekt = false;	
		
				}
			}
		}
		
		return istKorrekt;
	}
	
	/**
	 * Methode welche �berprf�t ob der Bestand eines Artikels nicht leer, nur aus ganzen Zahlen, keine negativen Zahlen und maximal 100 000 000 ist
	 * 
	 * @param String bestand, welcher auf die oben genannten Regeln �berpr�ft wird.
	 * 
	 * @return Wahrheitswert ob der bestand den Regeln entspricht
	 */
	public static boolean korrektheitBestand(String bestand) {
		
		boolean istKorrekt = true;
		
		if (bestand.isEmpty()) {
			
			fehlermeldungErweitern( "- Bitte füllen Sie das Feld Bestand aus!!");
			istKorrekt = false;
		}
		else {
			if (!bestand.matches("[0-9]+")){
			
				fehlermeldungErweitern("- Sie haben unerlaubte Zeichen im Feld Bestand benutzt!! ");
				istKorrekt = false;	
	
			}
			else {
				if (!MinimalBestand(bestand)){
				
					fehlermeldungErweitern("- Das minimal erlaubte Bestand beträgt 0 St�ck ");
					istKorrekt = false;	
		
				}
			
				if (!MaximalBestand(bestand)){
				
					fehlermeldungErweitern("- Das maximal erlaubte Bestand beträgt 100 000 000 St�ck");
					istKorrekt = false;	
		
				}
			}
		}
	
		return istKorrekt;	
	}
	
	/**
	 * Methode welche �berprf�t ob der Preis eines Artikels nicht leer, nur aus Zahlen mit maximal 2 Nachkommastellen, keine negativen Zahlen, minimal 0.01 und maximal 99 999 ist
	 * 
	 * @param String preis, welcher auf die oben genannten Regeln �berpr�ft wird.
	 * 
	 * @return Wahrheitswert ob der preis den Regeln entspricht
	 */
	public static boolean korrektheitPreis(String preis) {
		boolean istKorrekt = true;
		
		if (preis.isEmpty()) {
			
			fehlermeldungErweitern( "- Bitte füllen Sie das Feld Preis aus!!");
			istKorrekt = false;
		}
		else {
			
			if (!preis.matches("[0-9]+\\.[0-9][0-9]")){
			
				fehlermeldungErweitern("-Sie haben unerlaubte Zeichen im Feld Preis benutzt!!\n Bitte geben Sie den Preis im Format 99.99 ein. ");
				istKorrekt = false;	
	
			}
			else {
		
				if (!MinimalPreis(preis)){
				
					fehlermeldungErweitern("- Der minimal erlaubte Preis beträgt 0.01 Euro !!");
					istKorrekt = false;	
		
				}
			
				if (!MaximalPreis(preis)){
				
					fehlermeldungErweitern("- Der maximal erlaubte Preis beträgt 99 999 Euro!!");
					istKorrekt = false;	
		
				}
			}
		}
		return istKorrekt;
		
	}

	
	/**
	 * Methode welche �berprf�t ob die Regalnummer eines Artikels nicht leer ist und nur aus einer Ziffer besteht
	 * 
	 * @param String regalnummer, welche auf die oben genannten Regeln �berpr�ft wird.
	 * 
	 * @return Wahrheitswert ob die regalnummer den Regeln entspricht
	 */
	public static boolean korrektheitRegal(String regalnummer) {
	
		boolean istKorrekt = true;
	
		if (regalnummer.isEmpty()) {
			
			fehlermeldungErweitern( "- Bitte füllen Sie das Feld Regal aus!!");
			istKorrekt = false;
		}
		else {
			if (!regalnummer.matches("[0-9]")) {
				
				if(regalnummer.length()!= 1) {
			
					fehlermeldungErweitern("- Geben Sie für Regal nur eine Zahl zwischen 0-9 ein!!");
					istKorrekt = false;		
				}
			}
		}
		
		return istKorrekt;
	}
	
	/**
	 * Methode welche �berprf�t ob die Abteilungsnummer eines Artikels nicht leer ist und nur aus einer Ziffer besteht
	 * 
	 * @param String abteilungsnummer, welche auf die oben genannten Regeln �berpr�ft wird.
	 * 
	 * @return Wahrheitswert ob die abteilungsnummer den Regeln entspricht
	 */
	public static boolean korrektheitAbteilung(String abteilungsnummer) {
	
		boolean istKorrekt = true;
	
		if (abteilungsnummer.isEmpty()) {
			
			fehlermeldungErweitern( "- Bitte füllen Sie das Feld Abteilung aus!!");
			istKorrekt = false;
		}
		else {
			if (!abteilungsnummer.matches("[0-9]")) {
				
				if(abteilungsnummer.length()!= 1) {
			
					fehlermeldungErweitern("- Geben Sie für Abteilung nur eine Zahl zwischen 0-9 ein!!");
					istKorrekt = false;		
				}
			}
		}
		return istKorrekt;
	}

	/**
	 * Methode welche �berprf�t ob die unterabteilungsnummer eines Artikels nicht leer ist und nur aus einer Ziffer besteht
	 * 
	 * @param String unterabteilungsnummer, welche auf die oben genannten Regeln �berpr�ft wird.
	 * 
	 * @return Wahrheitswert ob die unterabteilungsnummer den Regeln entspricht
	 */
	public static boolean korrektheitUnterabteilung(String unterabteilungsnummer) {
	
		boolean istKorrekt = true;
		
		if (unterabteilungsnummer.isEmpty()) {
			
			fehlermeldungErweitern( "- Bitte füllen Sie das Feld Unterabteilung aus!!");
			istKorrekt = false;
		}
		else {
		
			if (!unterabteilungsnummer.matches("[0-9]")) {
				
				if(unterabteilungsnummer.length()!= 1) {
			
					fehlermeldungErweitern("- Geben Sie für Unterabteilung nur eine Zahl zwischen 0-9 ein!!");
					istKorrekt = false;	
					}
				}
			}
		return istKorrekt;
	}
	
	/**
	 * Methode welche �berprf�t ob die fachnummer eines Artikels nicht leer ist und genau 3 Stellen besitzt
	 * 
	 * @param String fachnummer, welche auf die oben genannten Regeln �berpr�ft wird.
	 * 
	 * @return Wahrheitswert ob die fachnummer den Regeln entspricht
	 */
	public static boolean korrektheitFach(String fachnummer) {
		
		boolean istKorrekt = true;
		
		if (fachnummer.isEmpty()) {
			
			fehlermeldungErweitern( "- Bitte füllen Sie das Feld Fach aus!!");
			istKorrekt = false;
		}
		else {
			
			if (fachnummer.matches("[0-9]+")) {
				
				if(fachnummer.length()!= 3) {
					
						fehlermeldungErweitern("- Geben Sie für Fach nur eine Zahl zwischen 000 - 999 ein!!");
						istKorrekt = false;	
				
				}
			}else {
				
				fehlermeldungErweitern("- Geben Sie für Fach nur eine Zahl zwischen 000 - 999 ein!!");
				istKorrekt = false;	
			}
		}
		
		return istKorrekt;
	}
}
