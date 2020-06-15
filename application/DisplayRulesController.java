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

public class DisplayRulesController implements Initializable {
	
	@FXML
	private Label rulesLabel;
	@FXML
	private Button returnButton;
	Glow glow = new Glow(0.75);
	
	//RETURN TO GAME SCENE
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
		
		//DISPLAY RULES
		rulesLabel.setText("1. Make a bet\n   One coin is equal to 10$. Press \"Bet One\" to bet one coin or press \"Bet Max\" to bet all of your current cash."
				+ "\n\n2. Spin the wheels\n   Press \"Spin\"."
				+ "\n\n3. If you get 2 or more matches you win a certain amount of money.\n   To check how much, look at the pay table."); 
	}
	
}

