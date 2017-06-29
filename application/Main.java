package application;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Zeigt zuerst die Spielereingabe
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Start.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Kniffel");
			primaryStage.getIcons().add(new Image("pictures/5.png"));
			primaryStage.show();
			
		} catch(Exception e) {
			System.err.println("Spielereingabe konnte nicht gestartet werden:");
			e.printStackTrace();
		}
	}
	
	@FXML
	protected void handleStart(ActionEvent e){
		try {
			Button btn = (Button)e.getSource();
			Stage oldStage = (Stage) btn.getScene().getWindow();
			
			List<String> namen = new ArrayList<String>();
			for (Node n : oldStage.getScene().getRoot().getChildrenUnmodifiable()) {
				//Spieler werden aus Textfeldern hinzugefügt, wenn Namen länger als 1 Buchstaben
				if (n instanceof TextField) {
					TextField tf = (TextField) n;
					if (tf.getText().length() > 1) {
						namen.add(tf.getText());
					}
				}
			}
			oldStage.close();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
			Controller control = new Controller(namen.toArray(new String[namen.size()]));
			loader.setController(control);
			Pane root = loader.load();
			Scene scene = new Scene(root);
			System.out.println(root.getChildren());
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("Kniffel");
			stage.getIcons().add(new Image("pictures/5.png"));
			stage.show();
		} catch (IOException e1) {
			System.err.println("Hauptfenster konnte nicht gestartet werden:");
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Willkommen zu Kniffel");
		launch(args);
	}

}
