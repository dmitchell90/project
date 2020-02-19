package Test;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import BusinessLogik.Artikel;
import Datenspeicherung.XmlAusgabe;
import Datenspeicherung.XmlEingabe;
import Datenspeicherung.XmlSerialisierbar;

public class Validierungstest {
    
    private static Artikel neuerArtikel;
    
    @BeforeClass
    public static void setUp() {
        // hole Liste
        ArrayList<XmlSerialisierbar> artikelliste = XmlEingabe.xmlDateiLesen("artikel.xml", "Artikelliste");
        
        // erstelle neuen Artikel
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String artikelName = "Test_Artikel_" + timestamp.toString();
        neuerArtikel = new Artikel(artikelName, artikelName, 0.0, 0.0, 0, "Test");
        
        // fuege neuen Artikel zur Liste hinzu und schreibe in xml-Datei
        artikelliste.add((XmlSerialisierbar) neuerArtikel);
        
        XmlAusgabe.xmlDateiSchreiben("artikel.xml", "Artikelliste", artikelliste);
    }
    
    @Test
    public void neuerArtikel() {
        // pruefe, ob Artikel nun vorhanden
        ArrayList<XmlSerialisierbar> assertListe = XmlEingabe.xmlDateiLesen("artikel.xml", "Artikelliste");
        Assert.assertTrue(assertListe.contains(neuerArtikel));
    }
    
    @Test
    public void eindeutigerName() {
        // hole Liste
        ArrayList<XmlSerialisierbar> artikelliste = XmlEingabe.xmlDateiLesen("artikel.xml", "Artikelliste");
     
        // pruefe paarweise die Namen.
        boolean gleicherName = false;
        for(XmlSerialisierbar serArtikel : artikelliste) {
            for(XmlSerialisierbar serVergleichsArtikel : artikelliste) {
                Artikel artikel = (Artikel) serArtikel;
                Artikel vergleichsArtikel = (Artikel) serVergleichsArtikel;

                if(artikel != vergleichsArtikel && artikel.name.equals(vergleichsArtikel.name)) {
                    gleicherName = true;
                }
            }
        }
        
        Assert.assertFalse(gleicherName);;
    }
    
    @Test
    public void eindeutigeLagerplatznummer() {
        // hole Liste
        ArrayList<XmlSerialisierbar> artikelliste = XmlEingabe.xmlDateiLesen("artikel.xml", "Artikelliste");
     
        // pruefe paarweise die Namen.
        boolean gleicherLagerplatz = false;
        for(XmlSerialisierbar serArtikel : artikelliste) {
            for(XmlSerialisierbar serVergleichsArtikel : artikelliste) {
                Artikel artikel = (Artikel) serArtikel;
                Artikel vergleichsArtikel = (Artikel) serVergleichsArtikel;

                if(artikel != vergleichsArtikel && artikel.regalNummer.equals(vergleichsArtikel.regalNummer)) {
                    gleicherLagerplatz = true;
                }
            }
        }
        
        Assert.assertFalse(gleicherLagerplatz);;
    }
    
    @Test
    public void eindeutigeKategorie() {
        // hole Liste
        ArrayList<XmlSerialisierbar> artikelliste = XmlEingabe.xmlDateiLesen("artikel.xml", "Artikelliste");
     
        // pruefe paarweise die Namen.
        boolean gleicheKategorie = false;
        for(XmlSerialisierbar serArtikel : artikelliste) {
            for(XmlSerialisierbar serVergleichsArtikel : artikelliste) {
                Artikel artikel = (Artikel) serArtikel;
                Artikel vergleichsArtikel = (Artikel) serVergleichsArtikel;

                if(artikel != vergleichsArtikel && artikel.kategorie.equals(vergleichsArtikel.kategorie)) {
                    gleicheKategorie = true;
                }
            }
        }
        
        Assert.assertFalse(gleicheKategorie);;
    }
    

    @AfterClass
    public static void tearDown() {
        // hole Liste
        ArrayList<XmlSerialisierbar> artikelliste = XmlEingabe.xmlDateiLesen("artikel.xml", "Artikelliste");
        
        // loesche alle Test-Artikel
        ArrayList<XmlSerialisierbar> toDelete = new ArrayList<XmlSerialisierbar>();
        for(XmlSerialisierbar artikel : artikelliste) {
            if(((Artikel) artikel).name.startsWith("Test")) {
                toDelete.add(artikel);
            }
        }
        
        artikelliste.removeAll(toDelete);
        
        XmlAusgabe.xmlDateiSchreiben("artikel.xml", "Artikelliste", artikelliste);
    }
}
