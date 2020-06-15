package application;
//Maryam Farooq
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.stage.Stage;

public class DisplayPayTableController implements Initializable {
	
	@FXML
	private Button returnButton;
	Glow glow = new Glow(0.75);
	
	//RETURN TO GAME
	public void returnToGame(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/application/SlotsGUIScene2.fxml"));
		Scene scene = new Scene(root);
		Stage goBack = (Stage)((Node)event.getSource()).getScene().getWindow();
		goBack.setScene(scene);
		goBack.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		returnButton.setOnMouseEntered(e -> returnButton.setEffect(glow));
		returnButton.setOnMouseExited(e -> returnButton.setEffect(null));
	}
}

