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
    	boolean FH1 =  (sortierteWürfel[0]) == (sortierteWürfel[1]) &&  (sortierteWürfel[2]) == (sortierteWürfel[3]) && (sortierteWürfel[2]) == (sortierteWürfel[4]) && (sortierteWürfel[1]) != (sortierteWürfel[2]);
    	boolean FH2 =  (sortierteWürfel[4]) == (sortierteWürfel[3]) &&  (sortierteWürfel[2]) == (sortierteWürfel[1]) && (sortierteWürfel[2]) == (sortierteWürfel[0]) && (sortierteWürfel[3]) != (sortierteWürfel[2]);
		return FH1 || FH2;
	}
    
    private boolean check_KleineStraße(byte[] sortierteWürfel) {
		
	}
    private boolean check_GroßeStraße(byte[] sortierteWürfel) {

	}
    
    private boolean check_Pasch(byte[] sortierteWürfel, 3) {
	boolean P31 = (sortierteWürfel[4]) == (sortierteWürfel[3]) && (sortierteWürfel[3]) == (sortierteWürfel[2]);
	boolean P32 = (sortierteWürfel[3]) == (sortierteWürfel[2]) && (sortierteWürfel[2]) == (sortierteWürfel[1]);
	boolean P33 = (sortierteWürfel[2]) == (sortierteWürfel[1]) && (sortierteWürfel[1]) == (sortierteWürfel[0]);
    	return P31 || P32 || P33;
    	}

    private boolean check_Pasch(byte[] sortierteWürfel, 4) {
	boolean P41 = (sortierteWürfel[4]) == (sortierteWürfel[3]) && (sortierteWürfel[3]) == (sortierteWürfel[2]) && (sortierteWürfel[2]) == (sortierteWürfel[1]);
	boolean P42 = (sortierteWürfel[0]) == (sortierteWürfel[1]) && (sortierteWürfel[1]) == (sortierteWürfel[2]) && (sortierteWürfel[2]) == (sortierteWürfel[3]); 
	return P41 || P42;
    }
	    
    private boolean check_Pasch(byte[] sortierteWürfel, 5) {	    
	boolean P50 = (sortierteWürfel[4]) == (sortierteWürfel[3]) && (sortierteWürfel[3]) == (sortierteWürfel[2]) && (sortierteWürfel[2]) == (sortierteWürfel[1]) && (sortierteWürfel[1]) == (sortierteWürfel[0]);
	return P50;
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
