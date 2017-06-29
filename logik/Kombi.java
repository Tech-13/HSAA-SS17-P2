 

import java.util.*;

/**
 * Definiert die möglichen Würfel Kombinationen in Kniffel
 */
public class Kombi {
		
    /**
     * Beschreibt wieviele Einser vorhaden sind und zum Punktefeld "1er" zählen
     */
    public static final int ALLE_1ER = 1;

    /**
     * Beschreibt wieviele Zweier vorhanden sind und zum Punktefeld "2er" zählen
     */
    public static final int ALLE_2ER = 2;

    /**
     * Beschreibt wieviele Dreier vorhanden sind und zum Punktefeld "3er" zählen
     */
    public static final int ALLE_3ER = 3;

    /**
     * Beschreibt wieviele Vierer vorhanden sind und zum Punktefeld "4er" zählen
     */
    public static final int ALLE_4ER = 4;

    /**
     * Beschreibt wieviele Fünfer vorhanden sind und zum Punktefeld "5er" zählen
     */
    public static final int ALLE_5ER = 5;

    /**
     * Beschreibt wieviele Sechser vorhanden sind und zum Punktefeld "6er" zählen
     */
    public static final int ALLE_6ER = 6;

    /**
     * Beschreibt ob von einer Würfelzahl mindestens drei vorhanden sind
     */
    public static final int PASCH_3X = 7;

    /**
     * Beschreibt ob von einer Würfelzahl mindestens vier vorhanden sind
     */
    public static final int PASCH_4X = 8;

    /**
     * Beschreibt ob von einer Würfelzahl fünf vorhanden sind
     */
    public static final int PASCH_5X = 9;

    /**
     * Beschreibt ob ein Full House vorliegt, also zwei gleiche Augenzahlen plus drei gleiche andere Augenzahlen
     */
    public static final int FULL_HOUSE = 10;

    /**
     * Beschreibt die kleine Strasse, also ein aufeinander Reihung vier fortlaufender Augenzaheln
     */
    public static final int KLEINE_STRASSE = 11;

    /**
     * Beschreibt die große Strasse, also ein aufeinander Reihung fünf fortlaufender Augenzaheln
     */
    public static final int GROSSE_STRASSE = 12;

    /**
     * Beschreibt das Feld Chance, bei dem alle Augenzahlen zusammen addiert werden und ein Punktzahl ergeben
     */
    public static final int CHANCE = 13;
    
    /**
     * String mit allen Möglichen Punktefeldern
     */
    
    public static final String[] bezeichnungen = {
    	"Einser",
    	"Zweier",
    	"Dreier",
    	"Vierer",
    	"Fünfer",
    	"Sechser",
    	"Dreierpasch",
    	"Viererpasch",
    	"Kniffel (Fünferpasch)",
    	"Full House",
    	"Kleine Straße",
    	"Große Straße",
    	"Chance"
    };

}
