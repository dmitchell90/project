package BusinessLogik;

import javax.xml.stream.XMLStreamReader;

import Datenspeicherung.XmlSerialisierbar;

/**
 * Klasse welche eine Kategorie und seine Eigenschaften widerspiegelt.
 * 
 */
public class Kategorie extends XmlSerialisierbar {

	public String name;
	public int zugehoerigeArtikel;
	
	/**
	 * Implementierung des Mutter Konstruktors zur Inizialisierung auf Basis einer XmlDatei
	 * 
	 */
	public Kategorie(XMLStreamReader xmlLeser) {
		
		super(xmlLeser);
	}
	
	/**
	 * Konstruktor um Instanz auf Basis von Nutzereinagben zu erstellen
	 * 
	 */
	public Kategorie(String name) {
		
		this.name = name;
		this.zugehoerigeArtikel = 0;
	}
	
	/**
	 * Methode zum Inkrementieren der Anzahl an Artikeln, welche diese Kategorie nutzen
	 * 
	 */
	public void zugehoerigeArtikelErhoehen() {
		
		this.zugehoerigeArtikel++;
	}
	
	/**
	 * Methode zum Dekrementieren der Anzahl an Artikeln, welche diese Kategorie nutzen
	 * 
	 */
	public void zugehoerigeArtikelVeringern() {
		
		this.zugehoerigeArtikel--;
	}
	
	/**
	 * toString wird zur korrekten Anziege in einer KomboBox überschrieben
	 * 
	 */
	@Override
	public String toString() {
		
		return this.name;
	}
	
	/**
	 * equals wird zur einfacheren Nutzung von Listenoperationen überschrieben. Verglichen wird anhand des Namens.
	 * 
	 */
	@Override
	public boolean equals(Object vergleich) {
		
		if(vergleich instanceof Kategorie) {
			
			Kategorie vergleichsKategorie = (Kategorie) vergleich;
			
			if(vergleichsKategorie.name.equals(this.name)) {
				
				return true;
			}
		}
		
		return false;
	}
}
