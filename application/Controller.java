package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import logik.Würfelbecher;

public class Controller {
	@FXML private TableView<Punktewerte> tb;
	@FXML private ImageView w1, w2, w3, w4, w5;
	@FXML private Button wurfBtn;
	private Würfelbecher w;
	
    @FXML
    public void initialize() {
        System.out.println("second");
        w = new Würfelbecher();
        ObservableList<Punktewerte> list = FXCollections.observableArrayList();
        list.add(new Punktewerte());
        list.add(new Punktewerte());
        tb.getColumns().get(0).setCellValueFactory(new PropertyValueFactory("spieler1"));
        tb.setItems(list);
        
        
    }
	
	@FXML
	protected void handleMouse(MouseEvent m){
		ImageView im = (ImageView)m.getSource();
		ImageView[] würfelViews = {w1, w2, w3, w4, w5};
		
		for (int i = 0; i < würfelViews.length; i++) {
			if (im.getId() == (würfelViews[i]).getId()) {
				w.würfelMarkieren(i);
				System.out.println(i);
			}
		}
		Image grau = new Image("pictures/gr.png");
		//im.setImage(grau);
		
		im.setEffect(new GaussianBlur());
		
	}
	
	@FXML
	protected void handleWurf(MouseEvent m){
		//ImageView im = (ImageView)m.getSource();
		Image[] würfelImages = new Image[6];
		for (int i = 0; i < würfelImages.length; i++) {
			würfelImages[i] = new Image("pictures/" + (i+1) + ".png");
		}
		w.würfeln();
		byte[] würfelWerte = w.getAlleWürfel();
		ImageView[] würfelViews = {w1, w2, w3, w4, w5};
		for (int i = 0; i < würfelViews.length; i++) {
			würfelViews[i].setImage(würfelImages[würfelWerte[i]-1]);
		}
		wurfBtn.setText(w.getCounter() + "x Würfeln");
		if (w.getCounter() < 1) {
			wurfBtn.setDisable(true);
		}
		
	    
	}	
	

}


