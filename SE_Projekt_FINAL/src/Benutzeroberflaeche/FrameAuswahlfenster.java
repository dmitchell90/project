package Benutzeroberflaeche;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Das Auswahlfenster �ffnet sich, wenn das Programm gestartet wird. Man soll hier die M�glichkeit haben einen zwischen verschiedenen Aktionen auszuw�hlen. Man kann Artikel hier suchen oder hinzuf�gen.
 * @author Marie Diekmann
 *
 */
public class FrameAuswahlfenster extends JFrame implements ActionListener{
	
	//Initialisierung
	
	JPanel unten = new JPanel();//JPanel teilt GUI in verscheidene Bereiche auf
	JLabel label1 = new JLabel("Was wollen Sie tun?", JLabel.CENTER); //Schriftzug in der Mitte des Fensters
	
	//Buttons
	JButton btnArtikelsuchen = new JButton ("Artikel suchen"); 
	JButton btnArtikelhinzufuegen = new JButton ("Artikel hinzufügen");
	JButton btnBeenden = new JButton ("Programm beenden");
	
	/**
	* Konstruktor f�r das Fenster, hier werden Werte f�r die Gr��e des Fensters gesetzt etc. 
	* Au�erdem werden die vorher initialisierten Elemente dem ContentPane und dem ActionListener hinzugef�gt, sowie durch ein GridLayout auf dem ContentPane platziert.
	* 
	* @param fenstertitel, um einen individuellen Fenstertitel setzetn zu k�nnen
	*/
	public  FrameAuswahlfenster (String fenstertitel) {
	
		super(fenstertitel);//Gibt dem Fenster oben einen Titel
		this.setSize(500,200); // Setzt die Groesse des Fensters
		this.setLocationRelativeTo(null); // setzt das Fenster in die Mitte beim oeffnen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Fenster schließt sich, wenn ein anderes geöfftnet wird.
		
		//ContentPane, Teil des Fensters, welcher grau hinterlegt ist (oder wie auch immer man sich die Farbe aussucht) 
		this.getContentPane().add(label1); //Fuegt das label dem ContentPane hinzu
		this.getContentPane().add(unten, BorderLayout.SOUTH); //Setzt das Panel nach Unten
		
		//dem Panel werden Buttons hinzugefuegt
		this.unten.add(btnArtikelsuchen);
		this.unten.add(btnArtikelhinzufuegen);
		this.unten.add(btnBeenden);
		
		//Die Buttons dem ActionListener hinzuf�gen
		btnArtikelhinzufuegen.addActionListener(this);
		btnArtikelsuchen.addActionListener(this);
		btnBeenden.addActionListener(this);
		
		
	}
	
	/**
	 * Gibt an was passiert, wenn die Buttons gedr�ckt werden
	 */
	public void actionPerformed (ActionEvent aktion){
		
		/**
		 * Wenn der Button btnArtikelHinzufuegen gedr�ckt wird, dann geht das Fenster FrameArtikelHinzufuegen auf und das aktuelle Fenster schlie�t sich
		 */
		if(aktion.getSource() == this.btnArtikelhinzufuegen){
			this.dispose();
			FrameArtikelHinzufuegen frame = new FrameArtikelHinzufuegen ("Artikel hinzufügen");
			frame.setVisible(true);
		}
		
		/**
		 * Wenn der Button btnBeenden gedr�ckt wird, dann schlie�t sich das Programm
		 */
		if(aktion.getSource() == this.btnBeenden){
			this.dispose();
		}
		/**
		 * Wenn der Button btnArtikelsuchen gerdr�ckt wird, dann schlie�t sich das Fenster und das Fenster FrameArtikelSuchen wird ge�ffnet
		 */
		if(aktion.getSource() == this.btnArtikelsuchen){
			this.dispose();
			FrameArtikelSuchen frame = new FrameArtikelSuchen ("Artikel Suchen");
			frame.setVisible(true);
		}
	

	}
	
	
	
	

}

