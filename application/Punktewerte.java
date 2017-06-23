package application;

import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Punktewerte {
	public String kombi;
	private int[] punkte = {0, 0, 0};
	private int spielerAnzahl = 3;
	
	public Punktewerte(String pKombi) {
		this.kombi = (pKombi);
	}

	public String getKombi() {
		return kombi;
	}

	public void setKombi(String kombi) {
		this.kombi = kombi;
	}

	public int[] getPunkte() {
		return punkte;
	}
	
	public int getPunkt(int nr) {
		return punkte[nr];
	}

	public void setPunkte(int[] punkte) {
		this.punkte = punkte;
	}
	
	public void setPunkt(int nr, int wert) {
		punkte[nr] = wert;
	}

	
}
	
	
