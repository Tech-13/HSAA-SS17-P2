package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Punktewerte {
	private StringProperty spieler1;
	public Punktewerte() {
		spieler1 = new SimpleStringProperty(this, "Hallo");
	}
}
