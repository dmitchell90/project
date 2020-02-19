package BusinessLogik;

import javax.xml.stream.XMLStreamReader;
import Datenspeicherung.XmlSerialisierbar;

/**
 * Klasse welche ein Regal und seine Eigenschaften widerspiegelt.
 * 
 */
public class Regal extends XmlSerialisierbar {

	public String regalNummer;
	public double aktuelleKapazitaet;
	public double maximaleKapazitaet;
	
	/**
	 * Implementierung des Mutter Konstruktors zur Inizialisierung auf Basis einer XmlDatei
	 * 
	 */
	public Regal(XMLStreamReader xmlLeser) {
		
		super(xmlLeser);
	}
	
	/**
	 * Konstruktor um Instanz auf Basis von Nutzereinagben zu erstellen
	 * 
	 */
	public Regal(String regalNummer, double maximaleKapazitaet) {
		
		this.regalNummer = regalNummer;
		this.aktuelleKapazitaet = maximaleKapazitaet;
		this.maximaleKapazitaet = maximaleKapazitaet;
	}
	
	/**
	 * Methode welche überprüft ob ein Regal nachdem hinzufügen eines neuen Artikles überfüllt wäre
	 * 
	 * @param double auslastungsZuwachs, Menge an Gewicht die Dazukäme
	 * 
	 * @return boolean Wahrheitswert, ob das Regal überfüllt wäre oder nicht
	 */
	public boolean regalUeberfuellt(double auslastungsZuwachs) {
		
		if(this.aktuelleKapazitaet - auslastungsZuwachs < 0) {
			
			return true;
		}
		
		return false;
	}

	/**
	 * toString wird zur Überprüfung überschrieben
	 * 
	 */
	@Override
	public String toString() {
		
		return "Regal: {\n   regalNummer: " + this.regalNummer + "\n   aktuelleKapazitaet: " + this.aktuelleKapazitaet + "\n   maximaleKapazitaet: " + this.maximaleKapazitaet + "\n}";
	}
	
	/**
	 * equals wird zur einfacheren Nutzung von Listenoperationen überschrieben. Verglichen wird anhand der Regalnummer.
	 * 
	 */
	public boolean equals(Object vergleich) {
		
		if(vergleich instanceof Regal) {
			
			Regal vergleichsRegal = (Regal) vergleich;
			
			if(vergleichsRegal.regalNummer.equals(this.regalNummer)) {
				
				return true;
			}
		}
		
		return false;
	}
}
