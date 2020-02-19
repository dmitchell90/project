package Datenspeicherung;

import java.lang.reflect.Field;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * Die Klasse XmlSerialisierbar bietet alle Methoden an, welche benötigt werden,
 * damit die Klassen XmlAusgabe und XmlEingabe eine Xml Repräsentation einer Kinderklasse von XmlSerialisierbar erstellen können.
 * 
 */
public class XmlSerialisierbar {

	public XmlSerialisierbar() {
		
	}
	
	/**
	 * Konstruktor welcher einen XMLStreamReader als Parameter erwartet. Über Reflection werden alle public Felder ausgelsen und mit Werten versehen
	 * 
	 * @param XMLStreamReader xmlLeser, XMLStreamReader welcher gerade eine XmlDatei liest aus der Instanzen erstellt werden sollen.
	 */
	public XmlSerialisierbar(XMLStreamReader xmlLeser) {
		
		Field[] felder;
		
		try {
			
			felder = Class.forName(this.getClass().getName()).getFields();
			
			for(int i = 0; i < felder.length; i++) {
				
				for(int k = 0; k < xmlLeser.getAttributeCount(); k++) {
					
					if(xmlLeser.getAttributeLocalName( k ).equals(felder[i].getName())) {
						
						switch(felder[i].getType() + "") {
						
						case "int":
							
							felder[i].set(this, Integer.parseInt(xmlLeser.getAttributeValue( k )) );
							break;
							
						case "double":
							
							felder[i].set(this, Double.parseDouble(xmlLeser.getAttributeValue( k )) );
							break;
							
						case "class java.lang.String":
							
							felder[i].set(this, xmlLeser.getAttributeValue( k ) );
							break;
							
						default:
							break;
						}		
					}
				}
			}
			
		} catch (SecurityException e) {
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
			
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		}
	}
	
	/**
	 * Methode zum Erstellen der XmlRepräsentation einer Instanz. Über Reflection werden alle public Felder ausgelsen und als XMLAttribut geschrieben.
	 * Als XMLKnotenname dient der Klassenname.
	 * 
	 * @param XMLStreamWriter xmlSchreiber, XMLStreamWriter welcher die XmlKnoten und XMlAttribute in eine Datei schreibt.
	 */
	public void zuXml(XMLStreamWriter xmlSchreiber) {
		
		try {
			
			xmlSchreiber.writeStartElement(this.getClass().getName());
			
			Field[] felder = Class.forName(this.getClass().getName()).getDeclaredFields();
			
			for(int i = 0; i < felder.length; i++) {
				
				xmlSchreiber.writeAttribute(felder[i].getName(), felder[i].get(this) + "");
			}
			
			xmlSchreiber.writeEndElement();
			
		} catch (XMLStreamException e) {
			
			e.printStackTrace();
			
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		}
	}
}
