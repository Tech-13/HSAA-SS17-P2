 

import java.util.*;

/**
 * Definiert die möglichen Würfel Kombinationen in Kniffel
 */
public class Kombi {
		
    /**
     * Definiert das Feld 1er
     */
    public static final int ALLE_1ER = 1;

    /**
     * Definiert das Feld 2er
     */
    public static final int ALLE_2ER = 2;

    /**
     * Definiert das Feld 3er
     */
    public static final int ALLE_3ER = 3;

    /**
     * Definiert das Feld 4er
     */
    public static final int ALLE_4ER = 4;

    /**
     * Definiert das Feld 5er
     */
    public static final int ALLE_5ER = 5;

    /**
     * Definiert das Feld 6er
     */
    public static final int ALLE_6ER = 6;

    /**
     * Definiert das Feld 3er Pasch
     */
    public static final int PASCH_3X = 7;

    /**
     * Definiert das Feld 4er Pasch
     */
    public static final int PASCH_4X = 8;

    /**
     * Definiert das Feld Kniffel bzw 5er Pasch
     */
    public static final int PASCH_5X = 9;

    /**
     * Definiert das Feld Full House
     */
    public static final int FULL_HOUSE = 10;

    /**
     * Definiert das Feld Kleine Strasse
     */
    public static final int KLEINE_STRASSE = 11;

    /**
     * Definiert das Feld  Große Strasse
     */
    public static final int GROSSE_STRASSE = 12;

    /**
     * Definiert das Feld Chance
     */
    public static final int CHANCE = 13;
    
    /**
     * Streing mit allen Möglichen Punktefeldern
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
