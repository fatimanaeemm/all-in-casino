package application;
//Maryam Farooq
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.stage.Stage;

public class BlackjackGUIDealSceneController extends BlackjackGUIController implements Initializable{
			
	@FXML
	private Label currAmountLabel;
	@FXML
	private Button placeButton;
	@FXML
	private Button chip1;
	@FXML
	private Button chip10;
	@FXML
	private Button chip100;
	@FXML
	private Button chip500;
	@FXML
	private Button changeBetButton;
	Glow glow = new Glow(0.75);
	
	//CHANGE BET
	public void changeBet(ActionEvent e) throws Exception{
		
		playSound("buttonClicked", false);
		bet = 0;
		chip1.setDisable(false);
		chip10.setDisable(false);
		chip100.setDisable(false);
		chip500.setDisable(false);
		changeBetButton.setDisable(true);
		placeButton.setDisable(true);
	}
	
	//CHOOSE BET AND ENABLE 'PLACE BET' AND 'CANCEL BET' BUTTONS
	
	public void chip1(ActionEvent event) throws Exception{
		
		playSound("buttonClicked", false);
		placeButton.setOnMouseEntered(e -> placeButton.setEffect(glow));
		placeButton.setOnMouseExited(e -> placeButton.setEffect(null));
		bet += 1;
		currAmountLabel.setText(Integer.toString(totalCash-=bet));
		placeButton.setDisable(false);
		changeBetButton.setDisable(false);
	}
	
	public void chip10(ActionEvent event) throws Exception{
		
		playSound("buttonClicked", false);
		placeButton.setOnMouseEntered(e -> placeButton.setEffect(glow));
		placeButton.setOnMouseExited(e -> placeButton.setEffect(null));
		bet += 10;
		currAmountLabel.setText(Integer.toString(totalCash-=bet));
		placeButton.setDisable(false);
		changeBetButton.setDisable(false);
	}
	
	public void chip100(ActionEvent event) throws Exception{
		
		playSound("buttonClicked", false);
		placeButton.setOnMouseEntered(e -> placeButton.setEffect(glow));
		placeButton.setOnMouseExited(e -> placeButton.setEffect(null));
		bet += 100;
		currAmountLabel.setText(Integer.toString(totalCash-=bet));
		placeButton.setDisable(false);
		changeBetButton.setDisable(false);
	}
	
	public void chip500(ActionEvent event) throws Exception{
		
		playSound("buttonClicked", false);
		placeButton.setOnMouseEntered(e -> placeButton.setEffect(glow));
		placeButton.setOnMouseExited(e -> placeButton.setEffect(null));
		bet += 500;
		currAmountLabel.setText(Integer.toString(totalCash-=bet));
		placeButton.setDisable(false);
		changeBetButton.setDisable(false);
	}
	
	//CHANGE SCENE WHEN 'PLACE BET' BUTTON IS PRESSED
	
	public void place(ActionEvent event) throws Exception{
		
		playSound("buttonClicked", false);
		//totalCash-=bet;
		
		Parent root = FXMLLoader.load(getClass().getResource("/application/BlackjackGUI.fxml"));
		Scene scene = new Scene(root);
		Stage secondScene = (Stage)((Node)event.getSource()).getScene().getWindow();
		secondScene.setScene(scene);
		secondScene.show();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//DISPLAY CURRENT AMOUNT
		currAmountLabel.setText(Integer.toString(totalCash));
		
		//ADD EFFECTS TO BUTTONS
		placeButton.setOnMouseEntered(e -> placeButton.setEffect(glow));
		placeButton.setOnMouseExited(e -> placeButton.setEffect(null));
		changeBetButton.setOnMouseEntered(e -> changeBetButton.setEffect(glow));
		changeBetButton.setOnMouseExited(e -> changeBetButton.setEffect(null));
		chip1.setOnMouseEntered(e -> chip1.setEffect(glow));
		chip1.setOnMouseExited(e -> chip1.setEffect(null));
		chip10.setOnMouseEntered(e -> chip10.setEffect(glow));
		chip10.setOnMouseExited(e -> chip10.setEffect(null));
		chip100.setOnMouseEntered(e -> chip100.setEffect(glow));
		chip100.setOnMouseExited(e -> chip100.setEffect(null));
		chip500.setOnMouseEntered(e -> chip500.setEffect(glow));
		chip500.setOnMouseExited(e -> chip500.setEffect(null));
		
	}
}
