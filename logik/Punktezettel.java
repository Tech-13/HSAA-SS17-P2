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
    public int punkteBerechen(int kombiTyp, byte[] würfel) {
        int punkte = 0;
        Arrays.sort(würfel);
        
        if(kombiTyp <= 6) {
        	int augen = kombiTyp;
        	punkte = zähleWürfel(würfel, augen)*kombiTyp;
        } else {
        	switch (kombiTyp) {
				case Kombi.PASCH_3X:
					punkte = check_Pasch(würfel, 3)? augenzahlSumme(würfel) : 0; 
					break;
				case Kombi.PASCH_4X:
					punkte = check_Pasch(würfel, 4)? augenzahlSumme(würfel) : 0; 
					break;
				case Kombi.PASCH_5X:
					punkte = check_Pasch(würfel, 5)? augenzahlSumme(würfel) : 0; 
					break;				
				case Kombi.FULL_HOUSE:
					punkte = check_FullHouse(würfel)? 25 : 0;
					break;
				case Kombi.KLEINE_STRASSE:
					punkte = check_KleineStraße(würfel)? 30 : 0;
					break;
				case Kombi.GROSSE_STRASSE:
					punkte = check_GroßeStraße(würfel)? 40 : 0;
					break;					
				case Kombi.CHANCE:
					punkte = augenzahlSumme(würfel);
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
    
    private int augenzahlSumme(byte[] würfel) {
		int sum = 0;
		for (byte w : würfel) {
			sum += w;
		}
		return sum;
	}
    
    private boolean check_FullHouse(byte[] sortierteWürfel) {
    	boolean zwei =  sortierteWürfel[0] == sortierteWürfel[1];
    	boolean drei = sortierteWürfel[2] == (sortierteWürfel[3]) && (sortierteWürfel[2]) == (sortierteWürfel[4]);
		return zwei && drei;
		// TODO 3 gleiche Würfel am Anfang und 2 am Ende
	}
    
    private boolean check_KleineStraße(byte[] sortierteWürfel) {
		
	}
    private boolean check_GroßeStraße(byte[] sortierteWürfel) {
		
	}
    
    private boolean check_Pasch(byte[] sortierteWürfel, int länge) {
		
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