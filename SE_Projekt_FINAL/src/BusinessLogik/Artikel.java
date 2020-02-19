package BusinessLogik;

import javax.xml.stream.XMLStreamReader;
import Datenspeicherung.XmlSerialisierbar;

/**
 * Klasse welche einen Artikel und seine Eigenschaften widerspiegelt.
 * Artikel erbt von XmlSerialisierbar um als Xml gelesen und geschrieben werden zu k�nnen.
 * 
 */
public class Artikel extends XmlSerialisierbar {

	public String name;
	public String regalNummer;
	public double preis;
	public double gewicht;
	public int bestand;
	public String kategorie;
	
	/**
	 * Implementierung des Mutter Konstruktors zur Inizialisierung auf Basis einer XmlDatei
	 * 
	 */
	public Artikel(XMLStreamReader xmlLeser) {
		
		super(xmlLeser);
	}
	
	
	/**
	 * Konstruktor um Instanz auf Basis von Nutzereinagben zu erstellen
	 * 
	 */
	public Artikel(String name, String regalNummer, double preis, double gewicht, int bestand, String kategorie) {
		
		this.name = name;
		this.regalNummer = regalNummer;
		this.preis = preis;
		this.gewicht = gewicht;
		this.bestand = bestand;
		this.kategorie = kategorie;
	}
	
	/**
	 * toString wird zur �berpr�fung �berschrieben
	 * 
	 */
	@Override
	public String toString() {
		
		return "Name: " + this.name + " regalNummer: " + this.regalNummer + " preis: " + this.preis + " gewicht: " + this.gewicht + " bestand: " + this.bestand + " kategorie: " + this.kategorie;
	}
	
	/**
	 * equals wird zur einfacheren Nutzung von Listenoperationen �berschrieben. Artikel werden anhand der Regalnummer und des Names verglichen.
	 * 
	 */
	@Override
	public boolean equals(Object vergleich) {
		
		if(vergleich instanceof Artikel) {
			
			Artikel vergleichsArtikel = (Artikel) vergleich;
			
			if(vergleichsArtikel.name.equals(this.name) || vergleichsArtikel.regalNummer.equals(this.regalNummer)) {
				
				return true;
			}
		}
		
		return false;
	}
}
