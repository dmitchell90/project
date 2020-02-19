package Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import abdeckung.MyClass;

public class Abdeckungskriterien {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(originalOut);
	}
	
	@Test
	public void fehler1Test() {
		new MyClass(1,2000,3).validate(2, 3, 4);
		assertEquals("Fehler 1", outContent.toString());
	}

	@Test
	public void fehler2Test(){
		new MyClass(1,2,60).validate(2, 3, 4);
		assertEquals("Fehler 2", outContent.toString());
	}

	@Test
	public void additionAttributeTest(){
		MyClass myClass = new MyClass(1,2,10);
		int i = myClass.getS();
		myClass.validate(2, 3, 4);

		assertTrue(i != myClass.getS());
		assertEquals(12,myClass.getS());
	}
}
