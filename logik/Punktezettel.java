 
import java.util.*;

/**
 * 
 */
public class Punktezettel {

	/**
	 * Initialisiert alle Punktefelder mit 0 und markiert sie als unbelegt
	 */
	public Punktezettel() {
		Arrays.fill(punkteFelder, 0);
		Arrays.fill(belegteFelder, false);
	}


	/**
	 * Punkte der einzelnen Kombinationen
	 */
	private int[] punkteFelder = new int[14];

	private boolean[] belegteFelder = new boolean[14];

	/**
	 * @param kombiTyp Art der Kombination für die die Punkte berechnet werden sollen (siehe Kombi Klasse)
	 * @param würfel Array von 5 Würfelwerten die geprüft werden
	 * @return Die berechneten Punkte
	 */
	public int punkteBerechen(int kombiTyp, byte[] pwürfel) {
		int punkte = 0;
		byte[] würfel = Arrays.copyOf(pwürfel, pwürfel.length);
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
				punkte = check_Pasch5(würfel)? 50 : 0; 
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

	
	/**
	 * Prüfung ob es sich um ein Full House handelt
	 */
	private boolean check_FullHouse(byte[] sortierteWürfel) {
		boolean FH1 =  (sortierteWürfel[0]) == (sortierteWürfel[1]) &&  (sortierteWürfel[2]) == (sortierteWürfel[3]) && (sortierteWürfel[2]) == (sortierteWürfel[4]) && (sortierteWürfel[1]) != (sortierteWürfel[2]);
		boolean FH2 =  (sortierteWürfel[4]) == (sortierteWürfel[3]) &&  (sortierteWürfel[2]) == (sortierteWürfel[1]) && (sortierteWürfel[2]) == (sortierteWürfel[0]) && (sortierteWürfel[3]) != (sortierteWürfel[2]);
		return FH1 || FH2;
	}

	
	/**
	 * Prüfung ob es sich um eine kleine Strasse handelt
	 */
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
	
	/**
	 * Prüfung ob es sich um eine großeStrasse handelt
	 */
	private boolean check_GroßeStraße(byte[] sortierteWürfel) {
		byte[] eins = {1,2,3,4,5};
		byte[] zwei = {2,3,4,5,6};
		return Arrays.equals(sortierteWürfel, eins) || Arrays.equals(sortierteWürfel, zwei);
	}

	
	/**
	 * Prüfung ob es sich um einen 3er Pasch handelt
	 */
	private boolean check_Pasch3(byte[] sortierteWürfel) {
		boolean P31 = (sortierteWürfel[4]) == (sortierteWürfel[3]) && (sortierteWürfel[3]) == (sortierteWürfel[2]);
		boolean P32 = (sortierteWürfel[3]) == (sortierteWürfel[2]) && (sortierteWürfel[2]) == (sortierteWürfel[1]);
		boolean P33 = (sortierteWürfel[2]) == (sortierteWürfel[1]) && (sortierteWürfel[1]) == (sortierteWürfel[0]);
		return P31 || P32 || P33;
	}

	/**
	 * Prüfung ob es sich um einen 4er Pasch handelt
	 */
	private boolean check_Pasch4(byte[] sortierteWürfel) {
		boolean P41 = (sortierteWürfel[4]) == (sortierteWürfel[3]) && (sortierteWürfel[3]) == (sortierteWürfel[2]) && (sortierteWürfel[2]) == (sortierteWürfel[1]);
		boolean P42 = (sortierteWürfel[0]) == (sortierteWürfel[1]) && (sortierteWürfel[1]) == (sortierteWürfel[2]) && (sortierteWürfel[2]) == (sortierteWürfel[3]); 
		return P41 || P42;
	}

	/**
	 * Prüfung ob es sich um einen Kniffel handelt
	 */
	private boolean check_Pasch5(byte[] sortierteWürfel) {
		if (sortierteWürfel[4] == 0) {
			return false;
		}
		boolean P50 = (sortierteWürfel[4]) == (sortierteWürfel[3]) && (sortierteWürfel[3]) == (sortierteWürfel[2]) && (sortierteWürfel[2]) == (sortierteWürfel[1]) && (sortierteWürfel[1]) == (sortierteWürfel[0]);
		return P50;
	}

	/**
	 * @param kombiTyp Art der Kombination die eigetragen wird
	 * @param punkte Punktzahl die eingetragen wird
	 * @return True falls das Feld frei war und die Punkte erfolgreich eingetragen wurden, ansonsten false
	 */
	public boolean eintragen(int kombiTyp, int punkte) {
		if (istBelegt(kombiTyp)) {
			return false;
		} else {
			punkteFelder[kombiTyp] = punkte;
			belegteFelder[kombiTyp] = true;
			return true;
		}

	}

	/**
	 * @param kombiTyp Art der Kombination die geprüft werden soll
	 * @return True, wenn das Feld der Kombination schon belegt ist, ansonsten false
	 */
	public boolean istBelegt(int kombiTyp) {
		return belegteFelder[kombiTyp];
	}

	/**
	 * Die Punkte der 6 oberen Felder, bestehend aus den Kombinationen von gleichen Würfelwerten
	 * z.B. alle Einser, Zweier, Dreier... 
	 * @return Gesamtpunkte des oberen Blocks
	 */
	public int calcObererBlock() {
		int punkte = 0;
		for (int i = 0; i <= 6; i++) {
			punkte += punkteFelder[i];
		}
		return punkte;
	}

	/**
	 * Alle Punkte der anderen Felder (ohne den oberen Block mit gleichen Würfelwerten)
	 * z.B. Päsche, Straßen, Full House und Chance
	 * @return Gesamtpunkte des unteren Blocks
	 */
	public int calcUntererBlock() {
		int punkte = 0;
		for (int i = 7; i < punkteFelder.length; i++) {
			punkte += punkteFelder[i];
		}
		return punkte;
	}
	
	/**
	 * @return Gesamtpunkte (evtl. inkl. Bonus)
	 */
	public int getGesamtPkt() {
		int oben = calcObererBlock();
		int unten = calcUntererBlock();
		int punkte = oben + unten;
		// Bonus bei min. 63 Punkten
		if (oben > 62) {
			punkte += 35;
		}
		return punkte;
	}

}
