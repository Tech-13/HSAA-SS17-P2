package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Punktewerte {
	private String kombi;
	private IntegerProperty[] punkte;
	
	public Punktewerte(String pKombi, int spieler) {
		this.kombi = (pKombi);
		punkte = new SimpleIntegerProperty[spieler];
		for (int i = 0; i < punkte.length; i++) {
			punkte[i] = new SimpleIntegerProperty();
		}
	}

	public String getKombi() {
		return kombi;
	}

	public void setKombi(String kombi) {
		this.kombi = kombi;
	}

	public IntegerProperty punkteProperty(int nr) {
		return punkte[nr];
	}

	
}
	
	
