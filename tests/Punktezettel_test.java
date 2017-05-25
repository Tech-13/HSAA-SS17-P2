package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import logik.Kombi;
import logik.Punktezettel;

public class Punktezettel_test {

	Punktezettel pz = new Punktezettel();
	
	@Test
	public void testAlle3er() {
		byte[] würfel = {2,2,3,5,6};
		int ergebnis = pz.punkteBerechen(Kombi.ALLE_3ER, würfel);
		assertEquals(3, ergebnis);
	}
	
	@Test
	public void testAlle5er() {
		byte[] würfel = {2,2,5,5,6};
		int ergebnis = pz.punkteBerechen(Kombi.ALLE_5ER, würfel);
		assertEquals(10, ergebnis);
	}	

	@Test
	public void testFullHouse1() {
		byte[] würfel = {2,2,4,5,6};
		int ergebnis = pz.punkteBerechen(Kombi.FULL_HOUSE, würfel);
		assertEquals(0, ergebnis);
	}	
	@Test
	public void testFullHouse2() {
		byte[] würfel = {2,2,2,5,5};
		int ergebnis = pz.punkteBerechen(Kombi.FULL_HOUSE, würfel);
		assertEquals(25, ergebnis);
	}	
	@Test
	public void testFullHouse3() {
		byte[] würfel = {2,2,6,6,6};
		int ergebnis = pz.punkteBerechen(Kombi.FULL_HOUSE, würfel);
		assertEquals(25, ergebnis);
	}
	
	@Test
	public void testKleineStraße1() {
		byte[] würfel = {1,2,3,6,6};
		int ergebnis = pz.punkteBerechen(Kombi.KLEINE_STRASSE, würfel);
		assertEquals(0, ergebnis);
	}	
	@Test
	public void testKleineStraße2() {
		byte[] würfel = {2,2,3,4,5};
		int ergebnis = pz.punkteBerechen(Kombi.KLEINE_STRASSE, würfel);
		assertEquals(30, ergebnis);
	}
	@Test
	public void testKleineStraße3() {
		byte[] würfel = {1,3,4,5,6};
		int ergebnis = pz.punkteBerechen(Kombi.KLEINE_STRASSE, würfel);
		assertEquals(30, ergebnis);
	}
	
	@Test
	public void testGroßeStraße1() {
		byte[] würfel = {1,3,4,5,6};
		int ergebnis = pz.punkteBerechen(Kombi.GROSSE_STRASSE, würfel);
		assertEquals(0, ergebnis);
	}
	@Test
	public void testGroßeStraße2() {
		byte[] würfel = {2,3,4,5,6};
		int ergebnis = pz.punkteBerechen(Kombi.GROSSE_STRASSE, würfel);
		assertEquals(40, ergebnis);
	}
	
	@Test
	public void test4erPasch1() {
		byte[] würfel = {3,3,3,5,6};
		int ergebnis = pz.punkteBerechen(Kombi.PASCH_4X, würfel);
		assertEquals(0, ergebnis);
	}
	
	@Test
	public void test4erPasch2() {
		byte[] würfel = {2,5,5,5,5};
		int ergebnis = pz.punkteBerechen(Kombi.PASCH_4X, würfel);
		assertEquals(22, ergebnis);
	}
	
	@Test
	public void test3erPasch1() {
		byte[] würfel = {2,5,5,5,1};
		int ergebnis = pz.punkteBerechen(Kombi.PASCH_3X, würfel);
		assertEquals(18, ergebnis);
	}
	
	@Test
	public void test3erPasch2() {
		byte[] würfel = {2,5,3,5,1};
		int ergebnis = pz.punkteBerechen(Kombi.PASCH_3X, würfel);
		assertEquals(0, ergebnis);
	}
	
	@Test
	public void test5erPasch1() {
		byte[] würfel = {1,1,1,1,1};
		int ergebnis = pz.punkteBerechen(Kombi.PASCH_5X, würfel);
		assertEquals(50, ergebnis);
	}
	
	@Test
	public void testchance() {
		byte[] würfel = {2,5,1,6,3};
		int ergebnis = pz.punkteBerechen(Kombi.CHANCE, würfel);
		assertEquals(17, ergebnis);
	}

}
