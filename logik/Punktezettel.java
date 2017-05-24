package logik;
import java.util.*;

/**
 * 
 */
public class Punktezettel {

    /**
     * Default constructor
     */
    public Punktezettel() {
    }

    /**
     * 
     */
    private int gesamtObererBlock;

    /**
     * 
     */
    private int gesamtUntererBlock;


    /**
     * 
     */
    private int[] punkte = new int[12];

    /**
     * @param kombiTyp 
     * @param würfel byte[] 
     * @return
     */
    public int punkteBerechen(int kombiTyp, byte[] würfel, int augen) {
        int punkte = 0;
        
        if(kombiTyp <= 6) {
        	augen = kombiTyp;
        	punkte = zähleWürfel(würfel, augen)*kombiTyp;
        } else {
        	switch (kombiTyp) {
				case Kombi.PASCH_3X:
					
					break;
				// TODO Pasch und Chance
				case Kombi.FULL_HOUSE:
					punkte = 25;
					break;
				case Kombi.KLEINE_STRASSE:
					punkte = 30;
					break;
				case Kombi.GROSSE_STRASSE:
					punkte = 40;
					break;
				default:
					break;
			}
        }
  
        return punkte;
    }
    
    private int zähleWürfel(byte[] würfel, int augen) {
    	int n = 0;
    	for (byte w : würfel) {
			if (w == augen) {
				n++;
			}
		}
    	return n;
    }

    /**
     * @param kombiTyp 
     * @param punkte 
     * @return
     */
    public boolean eintragen(int kombiTyp, int punkte) {
        // TODO implement here
        return false;
    }

    /**
     * @param kombiTyp 
     * @return
     */
    public boolean checkBelegt(int kombiTyp) {
        return punkte[kombiTyp] != 0;
    }

    /**
     * @return
     */
    public int getGesamtPkt() {
        // TODO Bonus...
        return gesamtObererBlock + gesamtUntererBlock;
    }

}