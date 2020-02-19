package HilfreicheFunktionen;

import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Hilfsklasse, welche übliche Dateizugriffe bzw. Dateiabfragen vereinfacht
 * 
 */
public class Datei {

	/**
	 * Methode welche überprüft ob eine Datei bereist existiert
	 * 
	 * @param String dateiPfad, Pfad unter dem überprüft werden soll ob die Datei existert
	 * 
	 * @return Wahrheitswert ob die Datei extistiert oder nicht
	 */
	public static boolean istVorhanden(String dateiPfad) {
		
		return Files.exists(Paths.get(dateiPfad));
	}
}
