package application;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.beans.binding.IntegerExpression;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import logik.Kombi;
import logik.Punktezettel;
import logik.Würfelbecher;

public class Controller {
	@FXML private TableView<Punktewerte> tb;
	@FXML private ImageView w1, w2, w3, w4, w5;
	@FXML private Button wurfBtn;
	@FXML private Label	infoLbl;
	private Würfelbecher w; private Punktezettel[] pz;
	private int spielerAnzahl, spielerAktuell = 0;
	public String[] spielerNamen;
	
    final ObservableList<Punktewerte> data = FXCollections.observableArrayList();
	
    public Controller(String[] spielerNamen) {
		this.spielerNamen = spielerNamen;
		spielerAnzahl = spielerNamen.length;
		
	}
    
    @FXML
    public void initialize() {
        w = new Würfelbecher();

        pz = new Punktezettel[spielerAnzahl];
        for (int i = 0; i < pz.length; i++) {
        	pz[i] = new Punktezettel();
        }
        
        TableColumn kombiCol = tb.getColumns().get(0);
        kombiCol.setMinWidth(100);
        kombiCol.setCellValueFactory(new PropertyValueFactory<Punktewerte, String>("Kombi"));
        kombiCol.setStyle("-fx-font-weight: bolder;");
//        
//        TableColumn spieler1 = tb.getColumns().get(1);
//        spieler1.setMinWidth(100);
//        spieler1.setCellValueFactory(new PropertyValueFactory<Punktewerte, Integer>("punkt0"));
//        TableColumn<Punktewerte, Number> spieler2 =	tb.getColumns().get(2);
//        		spieler2.setCellValueFactory(cellData -> cellData.getValue().punkt0Property());
        		
        
        for (int i = 0; i < spielerAnzahl; i++) {
        	TableColumn<Punktewerte, Number> sp = new TableColumn<>();
        	final int index = i;
        	sp.setCellValueFactory(cell -> cell.getValue().punkteProperty(index));
        	sp.setText(spielerNamen[i]);
        	tb.getColumns().add(sp);
		}
        
        
        for (String kombiBezeichnug : Kombi.bezeichnungen) {
			data.add(new Punktewerte(kombiBezeichnug, spielerAnzahl));
		}
        data.add(new Punktewerte("===", spielerAnzahl));
        data.add(new Punktewerte("Punkte: obererer Block", spielerAnzahl));
        data.add(new Punktewerte("Punkte: unterer Block", spielerAnzahl));
        data.add(new Punktewerte("Gesamtpunkte", spielerAnzahl));
        
        tb.setItems(data);
        tb.getSelectionModel().clearSelection();
        
    }
	
	@FXML
	protected void handleMouse(MouseEvent m){
		ImageView im = (ImageView)m.getSource();
		ImageView[] würfelViews = {w1, w2, w3, w4, w5};
		
		for (int i = 0; i < würfelViews.length; i++) {
			if (im.getId() == (würfelViews[i]).getId()) {
				if (w.istWürfelMarkiert(i)) {
					w.würfelAbmarkieren(i);
				} else {
					w.würfelMarkieren(i);
				}
			}
		}
		ScaleTransition sc = new ScaleTransition(Duration.millis(500), im);
		sc.setToX(0.5); sc.setToY(0.5);
//		sc.play();
		RotateTransition rt = new RotateTransition(Duration.millis(200), im);
		rt.setFromAngle(-30);
		rt.setToAngle(30);
		rt.setAutoReverse(true);
		rt.setCycleCount(4);
//		rt.play();
		
		//rt.playFromStart();
		updateWürfel(w);
		
	}
	
	private void updateTable(int index) {
		// JavaFX registriert das neue setzen des Objekts in der Liste
		data.set(index, data.get(index));
	}
	
	@FXML
	protected void handleWurf(MouseEvent m){
		//ImageView im = (ImageView)m.getSource();
		w.würfeln();
		updateWürfel(w);
		updateWurfButton();

	}
	
	private void updateWurfButton() {
		wurfBtn.setText(w.getCounter() + "x Würfeln");
		if (w.getCounter() < 1) {
			wurfBtn.setDisable(true);
		} else {
			wurfBtn.setDisable(false);
		}
	}
	
	private void updateWürfel(Würfelbecher wb) {
		Image[] würfelImages = new Image[6];
		for (int i = 0; i < würfelImages.length; i++) {
			würfelImages[i] = new Image("pictures/" + (i+1) + ".png");
		}
		
		byte[] würfelWerte = wb.getAlleWürfel();
		ImageView[] würfelViews = {w1, w2, w3, w4, w5};		
		for (int i = 0; i < würfelViews.length; i++) {
			try {
				würfelViews[i].setImage(würfelImages[würfelWerte[i]-1]);
			} catch (ArrayIndexOutOfBoundsException e) {
				würfelViews[i].setImage(new Image("pictures/gr.png"));
			}
			
			Effect effect = wb.istWürfelMarkiert(i)? new GaussianBlur() : null;
			würfelViews[i].setEffect(effect);
		}
	}
	
	@FXML
	protected void handleTableClick(MouseEvent m) {
//		System.out.println(tb.getSelectionModel().getSelectedIndex());
		int index = tb.getSelectionModel().getSelectedIndex();
		// Kombi Felder sind nur der obere Teil < 14
		if (index >= 13) {
			return;
		}
		int spieler = spielerAktuell;
		
		
		int punkte = pz[spieler].punkteBerechen(index+1, w.getAlleWürfel());
		data.get(index).punkteProperty(spieler).set(punkte);
		// Bei Doppelclick wird eingetragen, ansonsten nur Punkte berechnet
		if (m.getClickCount() > 1) {
			tb.getSelectionModel().clearSelection();
			spielerAktuell++;
			spielerAktuell = spielerAktuell%spielerAnzahl;
			pz[spieler].eintragen(index+1, punkte);
			updatePunkteSumme(spieler);
			w = new Würfelbecher();
			updateWurfButton();
			updateWürfel(w);
			updateInfo();
		}
		
		
	}
	
	private void updateInfo() {
		infoLbl.setText("Spieler " + (spielerAktuell+1) + " ist an der Reihe!");
	}
	
	private void updatePunkteSumme(int spieler) {
		data.get(14).punkteProperty(spieler).set(pz[spieler].calcObererBlock());
		data.get(15).punkteProperty(spieler).set(pz[spieler].calcUntererBlock());
		data.get(16).punkteProperty(spieler).set(pz[spieler].getGesamtPkt());
	}
	

}


