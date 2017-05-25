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
					punkte = check_Pasch3(würfel)? augenzahlSumme(würfel) : 0; 
					break;
				case Kombi.PASCH_4X:
					punkte = check_Pasch4(würfel)? augenzahlSumme(würfel) : 0; 
					break;
				case Kombi.PASCH_5X:
					punkte = check_Pasch5(würfel)? augenzahlSumme(würfel) : 0; 
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
    	byte[] eins = {1,2,3,4};
    	byte[] zwei = {2,3,4,5};
    	byte[] drei = {3,4,5,6};
    	byte[] anfang = Arrays.copyOfRange(sortierteWürfel, 0, 4);
    	byte[] ende = Arrays.copyOfRange(sortierteWürfel, 1, 5);

    	boolean str1 = Arrays.equals(anfang, eins) || Arrays.equals(anfang, zwei) || Arrays.equals(anfang, drei);
    	boolean str2 = Arrays.equals(ende, eins) || Arrays.equals(ende, zwei) || Arrays.equals(ende, drei);
    	return str1 || str2;
	}
    private boolean check_GroßeStraße(byte[] sortierteWürfel) {
    	byte[] eins = {1,2,3,4,5};
    	byte[] zwei = {2,3,4,5,6};
    	return Arrays.equals(sortierteWürfel, eins) || Arrays.equals(sortierteWürfel, zwei);
	}
    
    private boolean check_Pasch3(byte[] sortierteWürfel) {
	boolean P31 = (sortierteWürfel[4]) == (sortierteWürfel[3]) && (sortierteWürfel[3]) == (sortierteWürfel[2]);
	boolean P32 = (sortierteWürfel[3]) == (sortierteWürfel[2]) && (sortierteWürfel[2]) == (sortierteWürfel[1]);
	boolean P33 = (sortierteWürfel[2]) == (sortierteWürfel[1]) && (sortierteWürfel[1]) == (sortierteWürfel[0]);
    	return P31 || P32 || P33;
    	}

    private boolean check_Pasch4(byte[] sortierteWürfel) {
	boolean P41 = (sortierteWürfel[4]) == (sortierteWürfel[3]) && (sortierteWürfel[3]) == (sortierteWürfel[2]) && (sortierteWürfel[2]) == (sortierteWürfel[1]);
	boolean P42 = (sortierteWürfel[0]) == (sortierteWürfel[1]) && (sortierteWürfel[1]) == (sortierteWürfel[2]) && (sortierteWürfel[2]) == (sortierteWürfel[3]); 
	return P41 || P42;
    }
	    
    private boolean check_Pasch5(byte[] sortierteWürfel) {	    
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
