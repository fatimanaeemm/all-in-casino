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
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.stage.Stage;

public class BlackjackRulesSceneController extends BlackjackGUIController implements Initializable{
	
	@FXML
	private Button returnButton;
	Glow glow = new Glow(0.75);
	
	public void returnButton(ActionEvent event) throws Exception{
		(new Dealer()).playSound("buttonClicked", false);
		Parent root = FXMLLoader.load(getClass().getResource("/application/BlackjackGUI.fxml"));
		Scene scene = new Scene(root);
		Stage secondScene = (Stage)((Node)event.getSource()).getScene().getWindow();
		secondScene.setScene(scene);
		secondScene.show();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		returnButton.setOnMouseEntered(e -> returnButton.setEffect(glow));
		returnButton.setOnMouseExited(e -> returnButton.setEffect(null));
		
	}
}
