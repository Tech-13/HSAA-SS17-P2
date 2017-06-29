package logik;

/**
 * Enthält alle Würfel und berechnet die Zufallswerte von nicht markierten
 * Würfeln
 */
public class Würfelbecher {
	private byte[] würfel;
	private boolean[] würfelMarkiert;
	private int counter;

	/**
	 * Erzeugt ein Array zum speichern der Werte der 5 Würfel und initialisiert
	 * sie
	 */
	public Würfelbecher() {
		würfel = new byte[5];
		würfelMarkiert = new boolean[5];
		// würfeln();
		alleWürfelAbmarkieren();
		counter = 3;

	}

	/**
	 * Würfelt alle nicht markierten Würfel neu
	 * 
	 * @return true wenn wirklich gewürfelt wurde und noch Versuche übrig waren
	 */
	public boolean würfeln() {
		if (counter < 1) {
			return false;
		}
		for (int i = 0; i < würfel.length; i++) {
			if (!würfelMarkiert[i]) {
				würfel[i] = (byte) ((Math.random() * 6) + 1);
			}
		}
		counter--;
		return true;
	}

	/**
	 * Markiert einen angegebenen Würfel
	 * 
	 * @param nr
	 *            Der zu markierende Würfel
	 */
	public void würfelMarkieren(int nr) {
		if (nr >= 0 && nr < würfelMarkiert.length)
			würfelMarkiert[nr] = true;
		else
			System.out.println("Fehler: Würfel existiert nicht");
	}

	/**
	 * Entfernt die Markierung des angegebenen Würfels
	 * 
	 * @param nr
	 *            Der zu markierende Würfel
	 */
	public void würfelAbmarkieren(int nr) {
		if (nr >= 0 && nr < würfelMarkiert.length)
			würfelMarkiert[nr] = false;
		else
			System.out.println("Fehler: Würfel existiert nicht");
	}

	/**
	 * Entfernet alle Markierungen
	 */
	public void alleWürfelAbmarkieren() {
		for (int i = 0; i < würfelMarkiert.length; i++) {
			würfelMarkiert[i] = false;
		}
	}

	/**
	 * Gibt einen Würfel zurück
	 * 
	 * @param nr
	 *            Der zu markierende Würfel
	 * @return
	 */
	public int getWürfel(int nr) {
		if (nr >= 0 && nr < würfel.length)
			return würfel[nr];
		else
			return -1;
	}

	public byte[] getAlleWürfel() {
		return würfel;
	}

	/**
	 * @param nr
	 *            Der Würfel
	 * @return true, wenn der angegebene Würfel markiert ist
	 */
	public boolean istWürfelMarkiert(int nr) {
		return würfelMarkiert[nr];
	}

	/**
	 * @return Die Zahl der übrigen Würfelversuche
	 */
	public int getCounter() {
		return counter;
	}

}
