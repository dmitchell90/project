package Datenspeicherung;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Klasse welches das Schreiben der XMLDaten in eine Datei �bernimmt
 */
public class XmlAusgabe {

	/**
	 * Methode welche eine Liste an XmlSerialisierbar Instanzen in eine Datei unter dem Pfad dateiPfad ab dem XmlKnoten wurzelElement schreibt.
	 * 
	 * @param String dateiPfad, Pfad zur Datei in welche das Xml geschrieben werden soll
	 * @param String wurzelElement, Name des Wurzelelements der XmlDatei
	 * @param ArrayList<XmlSerialisierbar> xmlSerialsierbareKlassen, eine Liste von XmlSerialisierbar Instanzen, welche in die Daten geschrieben werden sollen
	 */
	public static void xmlDateiSchreiben(String dateiPfad, String wurzelElement, ArrayList<XmlSerialisierbar> xmlSerialsierbareKlassen) {
		
		XMLOutputFactory xmlAusgabeFabrik = XMLOutputFactory.newInstance();
		
		try {
			
			FileOutputStream ausgabeDatenfluss = new FileOutputStream(dateiPfad);
			XMLStreamWriter xmlSchreiber = xmlAusgabeFabrik.createXMLStreamWriter( ausgabeDatenfluss );
			
			xmlSchreiber.writeStartDocument();
			xmlSchreiber.writeStartElement(wurzelElement);
			
			for(int i = 0; i < xmlSerialsierbareKlassen.size(); i++) {
				
				xmlSerialsierbareKlassen.get(i).zuXml(xmlSchreiber);
			}
			
			xmlSchreiber.writeEndElement();
			xmlSchreiber.writeEndDocument();
			
			xmlSchreiber.close();
			ausgabeDatenfluss.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (XMLStreamException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
}
