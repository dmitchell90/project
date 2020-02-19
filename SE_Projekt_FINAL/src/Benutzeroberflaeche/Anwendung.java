package Benutzeroberflaeche;

import java.awt.event.ActionEvent;
/**
 * 
 * 
 * Führt das Programm aus
 * @author Marie Diekmann, Thi Thu Trinh 
 * 
 * 
 *
 */
public class Anwendung  {
/**
 *  Die Main Methode ruft das Auswahlfenster auf und startet somit das Programm
 * @param args
 */
	public static void main(String[] args) {
		
		FrameAuswahlfenster frame = new FrameAuswahlfenster ("Lagerverwaltung");
		
		frame.setVisible(true);
	}
		
}
