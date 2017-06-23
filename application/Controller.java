package application;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
import logik.Würfelbecher;

public class Controller {
	@FXML private TableView<Punktewerte> tb;
	@FXML private ImageView w1, w2, w3, w4, w5;
	@FXML private Button wurfBtn;
	private Würfelbecher w;
	RotateTransition rt;
	
    final ObservableList<Punktewerte> data = FXCollections.observableArrayList();
	
    @FXML
    public void initialize() {
        w = new Würfelbecher();

        
        TableColumn kombiCol = tb.getColumns().get(0);
        kombiCol.setMinWidth(100);
        kombiCol.setCellValueFactory(new PropertyValueFactory<Punktewerte, String>("Kombi"));
        for (String kombiBezeichnug : Kombi.bezeichnungen) {
			data.add(new Punktewerte(kombiBezeichnug));
		}
        data.add(new Punktewerte("==="));
        data.add(new Punktewerte("Punkte: obererer Block"));
        data.add(new Punktewerte("Punkte: unterer Block"));
        data.add(new Punktewerte("Gesamtpunkte"));
        
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
		rt.play();
		
		//rt.playFromStart();
		//Image grau = new Image("pictures/gr.png");
		//im.setImage(grau);
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
		
		wurfBtn.setText(w.getCounter() + "x Würfeln");
		if (w.getCounter() < 1) {
			wurfBtn.setDisable(true);
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
			würfelViews[i].setImage(würfelImages[würfelWerte[i]-1]);
			
			Effect effect = wb.istWürfelMarkiert(i)? new GaussianBlur() : null;
			würfelViews[i].setEffect(effect);
		}
	}
	
	@FXML
	protected void handleTableClick(MouseEvent m) {
		System.out.println(tb.getSelectionModel().getSelectedIndex());
		
	}
	

}


