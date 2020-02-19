package Datenspeicherung;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Klasse welches das Lesen einer XmlDatei übernimmt
 */
public class XmlEingabe {

	/**
	 * Methode welche die unter dem Pfad angegebene XmlDatei ab dem WurzelElement lesen soll.
	 * 
	 * @param String dateiPfad, dateiPfad an dem sich die zu lesende Datei befindet
	 * @param String wurzelElement, Name des Elements ab dem gelesen werden soll
	 * 
	 * @return ArrayList<XmlSerialisierbar>, eingelesene Instanzen basierend auf der XmlDatei
	 */
	public static ArrayList<XmlSerialisierbar> xmlDateiLesen(String dateiPfad, String wurzelElement) {
		
		ArrayList<XmlSerialisierbar> eingeleseneInstanzen = new ArrayList<XmlSerialisierbar>();
		XMLInputFactory factory = XMLInputFactory.newInstance();
		
		try {
			
			FileInputStream eingabeDatenfluss = new FileInputStream(dateiPfad);
			XMLStreamReader parser = factory.createXMLStreamReader( eingabeDatenfluss );

			while ( parser.hasNext() ) {
				
				switch ( parser.getEventType() ) {
			  		case XMLStreamConstants.START_DOCUMENT:

			  			break;

			  		case XMLStreamConstants.END_DOCUMENT:

			  			parser.close();
			  			break;

			  		case XMLStreamConstants.NAMESPACE:

			  			break;

			  		case XMLStreamConstants.START_ELEMENT:
			  			
			
			  			if(!parser.getLocalName().equals(wurzelElement)) {
			  				
			  				//System.out.println("aaa" + Class.forName(parser.getLocalName()).getConstructor(Class.forName("javax.xml.stream.XMLStreamReader")).newInstance(parser));
			  			
			  				eingeleseneInstanzen.add((XmlSerialisierbar) Class.forName(parser.getLocalName()).getConstructor(Class.forName("javax.xml.stream.XMLStreamReader")).newInstance(parser));
			  			}
			  			
			  			
			  			break;

			  		case XMLStreamConstants.CHARACTERS:

			  			break;

			  		case XMLStreamConstants.END_ELEMENT:

			  			break;

			  		default:
			  			
			  			break;
				}
				
				parser.next();
			}
			
			parser.close();
			eingabeDatenfluss.close();
			
		} catch (FileNotFoundException | XMLStreamException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return eingeleseneInstanzen;
	}
}
