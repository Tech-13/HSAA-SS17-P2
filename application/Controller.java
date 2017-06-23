package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Effect;
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
	
    final ObservableList<Punktewerte> data =
            FXCollections.observableArrayList(
            new Punktewerte("KNIFFEL"),
            new Punktewerte("Nein"));
	
    @FXML
    public void initialize() {
        System.out.println("second");
        w = new Würfelbecher();

        
        TableColumn firstNameCol = tb.getColumns().get(0);
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Punktewerte, String>("Kombi"));
        
        tb.setItems(data);
        tb.getSelectionModel().clearSelection();
        
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
		//Image grau = new Image("pictures/gr.png");
		//im.setImage(grau);
		updateWürfel(w);
		
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
		data.get(0).setKombi("was anderes");
	    data.set(0, data.get(0));
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


