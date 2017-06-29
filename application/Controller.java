package application;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        kombiCol.getStyleClass().add("kombis");
        kombiCol.setSortable(false);
        
        for (int i = 0; i < spielerAnzahl; i++) {
        	TableColumn<Punktewerte, Number> sp = new TableColumn<>();
        	final int index = i;
        	sp.setCellValueFactory(cell -> cell.getValue().punkteProperty(index));
        	sp.setCellFactory(column -> {
                return new TableCell<Punktewerte, Number>() {
                	@Override
                    protected void updateItem(Number item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) return;
                        this.setText(item.toString());
                        // Spalten Index - 1 weil 1. Spalte keine Punkte enthält
                        int colIndex = tb.getColumns().indexOf(column)-1;
                        // Zeilen Index +1 da die Kombis bei 1 anfangen
                        int i = getIndex()+1;
                        if (i < 14) {
                        	if (pz[colIndex].istBelegt(i)) {
                        		this.getStyleClass().add("belegt");
							} else	{
								this.getStyleClass().remove("belegt");
							}
						} else if (i == 14) {
							this.getStyleClass().remove("belegt");
						} else {
							this.getStyleClass().add("belegt");
						}
                        
                    }
                };
            });
        	
            
        	sp.setText(spielerNamen[i]);
        	sp.setSortable(false);
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
        
        updateInfo();
        updateSpielerCol();
        
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

		updateWürfel(w, false);
		
	}
	private void rotate(Node node) {
		RotateTransition rt = new RotateTransition(Duration.millis(500), node);
		rt.setFromAngle(0);
		rt.setToAngle(360);
		rt.setAutoReverse(true);
		rt.setCycleCount(1);
		rt.setInterpolator(Interpolator.EASE_BOTH);
		rt.play();
		
	}
	
	private void updateTable(int index) {
		// JavaFX registriert das neue setzen des Objekts in der Liste
		data.set(index, data.get(index));
	}
	
	@FXML
	protected void handleWurf(MouseEvent m){
		w.würfeln();
		updateWürfel(w, true);
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
	
	private void updateWürfel(Würfelbecher wb, boolean animate) {
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

			würfelMarkiertEffect(würfelViews[i], wb.istWürfelMarkiert(i));
			if(!w.istWürfelMarkiert(i) && animate) rotate(würfelViews[i]);
		}
	}
	
	private void würfelMarkiertEffect(Node n, boolean markiert) {
		ScaleTransition sc = new ScaleTransition(Duration.millis(200), n);
		if (!markiert) {
			sc.setToX(1); sc.setToY(1);
		} else {
			sc.setToX(0.8); sc.setToY(0.8);			
		}
		sc.play();
	}

	
	@FXML
	protected void handleTableClick(MouseEvent m) {
		int index = tb.getSelectionModel().getSelectedIndex();
		// Kombi Felder sind nur der obere Teil < 14
		if (index >= 13 || index < 0) {
			return;
		}
		int spieler = spielerAktuell;
		// Nichts tun wenn Feld schon belegt
		if (pz[spieler].istBelegt(index+1)) return;
		
		int punkte = pz[spieler].punkteBerechen(index+1, w.getAlleWürfel());
		data.get(index).punkteProperty(spieler).set(punkte);
		// Bei Doppelclick wird eingetragen, ansonsten nur Punkte berechnet
		if (m.getClickCount() > 1) {
			tb.getSelectionModel().clearSelection();
			spielerAktuell++;
			spielerAktuell = spielerAktuell%spielerAnzahl;
			pz[spieler].eintragen(index+1, punkte);
			updateSpielerCol();
			updateTable(index);
			updatePunkteSumme(spieler);
			w = new Würfelbecher();
			updateWurfButton();
			updateWürfel(w, true);
			updateInfo();
		}
		
		
	}
	private void updateSpielerCol() {
		for (int i = 0; i < spielerAnzahl; i++) {
			if (i == spielerAktuell) {
				tb.getColumns().get(i+1).getStyleClass().add("aktuell");
			} else {
				tb.getColumns().get(i+1).getStyleClass().remove("aktuell");
			}
		}
	}
	
	private void updateInfo() {
		infoLbl.setText(spielerNamen[spielerAktuell] + "  ist am Zug!");
	}
	
	private void updatePunkteSumme(int spieler) {
		data.get(14).punkteProperty(spieler).set(pz[spieler].calcObererBlock());
		data.get(15).punkteProperty(spieler).set(pz[spieler].calcUntererBlock());
		data.get(16).punkteProperty(spieler).set(pz[spieler].getGesamtPkt());
	}
	

}


