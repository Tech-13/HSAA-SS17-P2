package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Punktewerte {
	private String kombi;
	private IntegerProperty[] punkte;
	private int spielerAnzahl = 3;
	
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
	
	
