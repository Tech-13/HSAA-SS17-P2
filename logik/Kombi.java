package logik;

/**
 * Definiert die möglichen Würfel Kombinationen in Kniffel
 */
public class Kombi {

	/**
	 * Zur Kombination "1er" zählen nur die gewürfelten Einser, ihre Summe
	 * ergibt die Punktzahl.
	 */
	public static final int ALLE_1ER = 1;

	/**
	 * Zur Kombination "2er" zählen nur die gewürfelten Zweier, ihre Summe
	 * ergibt die Punktzahl.
	 */
	public static final int ALLE_2ER = 2;

	/**
	 * Zur Kombination "3er" zählen nur die gewürfelten Dreier, ihre Summe
	 * ergibt die Punktzahl.
	 */
	public static final int ALLE_3ER = 3;

	/**
	 * Zur Kombination "4er" zählen nur die gewürfelten Vierer, ihre Summe
	 * ergibt die Punktzahl.
	 */
	public static final int ALLE_4ER = 4;

	/**
	 * Zur Kombination "5er" zählen nur die gewürfelten Fünfer, ihre Summe
	 * ergibt die Punktzahl.
	 */
	public static final int ALLE_5ER = 5;

	/**
	 * Zur Kombination "6er" zählen nur die gewürfelten Sechser, ihre Summe
	 * ergibt die Punktzahl.
	 */
	public static final int ALLE_6ER = 6;

	/**
	 * Zur Kombination 3er Pasch werden drei gleiche augenzahlen benötigt, die
	 * Punktzahl ergibt sich aus der Summe aller Augenzahlen.
	 */
	public static final int PASCH_3X = 7;

	/**
	 * Zur Kombination 4er Pasch werden vier gleiche augenzahlen benötigt, die
	 * Punktzahl ergibt sich aus der Summe aller Augenzahlen.
	 */
	public static final int PASCH_4X = 8;

	/**
	 * Der Kniffel beschreibt einen Wurf fünf gleicher Augenzahlen und bringt 50
	 * Punkte.
	 */
	public static final int PASCH_5X = 9;

	/**
	 * Das Full House beschreibt den Wurf eines Dreierpasches plus eines anderen
	 * Pasches und ergibt 25 Punkte.
	 */
	public static final int FULL_HOUSE = 10;

	/**
	 * Die kleine Strasse beschreibt eine aufeinander Reihung vier fortlaufender
	 * Augenzaheln un bringt 30 Punkte.
	 */
	public static final int KLEINE_STRASSE = 11;

	/**
	 * Die große Strasse beschreibt eine aufeinander Reihung fünf fortlaufender
	 * Augenzaheln un bringt 40 Punkte.
	 */
	public static final int GROSSE_STRASSE = 12;

	/**
	 * Bei der Chance kann jeder Wurf eingetragen werden. Die Punktzahl ergibt
	 * sich aus der Summe aller Augenzahlen.
	 */
	public static final int CHANCE = 13;

	/**
	 * Auflistung aller möglichen Punktefeldern.
	 */
	public static final String[] bezeichnungen = { "Einser", "Zweier", "Dreier", "Vierer", "Fünfer", "Sechser",
			"Dreierpasch", "Viererpasch", "Kniffel (Fünferpasch)", "Full House", "Kleine Straße", "Große Straße",
			"Chance" };

}
