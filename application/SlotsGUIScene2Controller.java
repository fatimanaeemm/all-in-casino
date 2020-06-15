package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
//Maryam Farooq
public class SlotsGUIScene2Controller extends Dealer implements Initializable {
	
	@FXML 
	private Button spinWheel;
	@FXML
	private Button enterBet;
	@FXML
	private Button rulesButton;
	@FXML 
	private Button payTableButton;
	@FXML
	private Button betOneButton;
	@FXML
	private Button betMaxButton;
	@FXML
	private Button playAgainButton;
	@FXML
	private Button returnToMainButton;
	@FXML
	private Label slot1;
	@FXML
	private Label slot2;
	@FXML
	private Label slot3;
	@FXML
	private Label currAmountLabel;
	@FXML
	private Label amountWonLabel;
	@FXML
	private Label coinsLabel;
	@FXML
	private Image image;
	@FXML 
	private ImageView imageView;
	

	String [] symbols = {"Seven", "Dollar Sign", "Shamrock", "Star", "Diamond", "Cherry"};
	
	int symbolNum;
	int match = 1;
	int coins = 0;
	int [] twoMatches = {50, 30, 16, 15, 12, 10};
	int [] threeMatches = {100, 60, 32, 30, 24, 20};
	int [] choice = new int[3];
	double amountWon = 0;
	Glow glow = new Glow(0.75);
    
    public int bet;
	
    //SUBTRACT 10 FROM THE BET AND ENABLE 'SPIN WHEELS' BUTTON
	public void betOne(ActionEvent event) throws Exception{
		
		playSound("buttonClicked", false);
		
		rulesButton.setDisable(true);
		payTableButton.setDisable(true);
		bet = bet + 10;
		totalCash=totalCash-10;
		coins++;
		coinsLabel.setText(Integer.toString(coins));
		spinWheel.setDisable(false);
		spinWheel.setOnMouseEntered(e -> spinWheel.setEffect(glow));
		spinWheel.setOnMouseExited(e -> spinWheel.setEffect(null));
	}
	
	//BET ALL CURRENT CASH
	public void betMax(ActionEvent event) throws Exception{
		
		playSound("buttonClicked", false);
		rulesButton.setDisable(true);
		payTableButton.setDisable(true);
		coins=totalCash/10;
		bet = totalCash;
		totalCash = 0;
		coinsLabel.setText(Integer.toString(coins));
		spinWheel.setDisable(false);
		spinWheel.setOnMouseEntered(e -> spinWheel.setEffect(glow));
		spinWheel.setOnMouseExited(e -> spinWheel.setEffect(null));
	}

	//DISPLAY RULES SCENE
	public void displayRules(ActionEvent event) throws Exception{
		
		playSound("buttonClicked", false);
		Parent root = FXMLLoader.load(getClass().getResource("/application/DisplayRules.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage rulesWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
		rulesWindow.setScene(scene);
		rulesWindow.show();
	}
	
	//DISPLAY PAY TABLE SCENE
	public void displayPayTable(ActionEvent event) throws Exception{
		
		playSound("buttonClicked", false);
		Parent root = FXMLLoader.load(getClass().getResource("/application/DisplayPayTable.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage payTableWindow = (Stage)((Node)event.getSource()).getScene().getWindow();
		payTableWindow.setScene(scene);
		payTableWindow.show();
	}
	
	//CALCULATE NUMBER OF MATCHES
	public void numOfMatches() {
		for (int i = 0; i < 3; i++) {
			for (int j = i+1; j < 3; j++) {
				if (choice[i] == choice[j]) {
					match++;
					symbolNum = choice[i];
					break;
				}
			}
		}
		System.out.println(match);
	}
	
	//ASSIGN AN IMAGE TO EACH SYMBOL
	public void assignImagesToSymbols(int i) {
		if (symbols[choice[i]] == "Seven") {
			image = new Image(getClass().getResourceAsStream("/images/sevenSlots.png"));
		}
		else if (symbols[choice[i]] == "Dollar Sign") {
			image = new Image(getClass().getResourceAsStream("/images/dollarSignSlots.png"));
		}
		else if (symbols[choice[i]] == "Shamrock") {
			image = new Image(getClass().getResourceAsStream("/images/shamrockSlots.png"));
		}
		else if (symbols[choice[i]] == "Star") {
			image = new Image(getClass().getResourceAsStream("/images/starSlots.png"));
		}
		else if (symbols[choice[i]] == "Diamond") {
			image = new Image(getClass().getResourceAsStream("/images/diamondSlots.png"));
		}
		else if (symbols[choice[i]] == "Cherry") {
			image = new Image(getClass().getResourceAsStream("/images/cherrySlots.png"));
		}
	}
	
	//RANDOMLY PICK THREE SYMBOLS AND DISPLAY THEM ON THE SCREEN
	public void spinWheels(ActionEvent event) throws Exception{
		
		playSound("buttonClicked", false);
		
		betOneButton.setDisable(true);
		betMaxButton.setDisable(true);
		
		choice[0] = DiceRoll() - 1;
		choice[1] = DiceRoll() - 1;
		choice[2] = DiceRoll() - 1;
		
		assignImagesToSymbols(0);
		imageView = new ImageView(image);
		imageView.setFitHeight(120);
		imageView.setFitWidth(120);
		slot1.setGraphic(imageView);
		
		assignImagesToSymbols(1);
		imageView = new ImageView(image);
		imageView.setFitHeight(120);
		imageView.setFitWidth(120);
		slot2.setGraphic(imageView);
		
		assignImagesToSymbols(2);
		imageView = new ImageView(image);
		imageView.setFitHeight(120);
		imageView.setFitWidth(120);
		slot3.setGraphic(imageView);
		
		checkAmountWon();
		updateCurrentAmount();
		
		spinWheel.setDisable(true);
		playAgainButton.setVisible(true);
		playAgainButton.setDisable(false);
		playAgainButton.setOnMouseEntered(e -> playAgainButton.setEffect(glow));
		playAgainButton.setOnMouseExited(e -> playAgainButton.setEffect(null));
		returnToMainButton.setVisible(true);
		returnToMainButton.setDisable(false);
		returnToMainButton.setOnMouseEntered(e -> returnToMainButton.setEffect(glow));
		returnToMainButton.setOnMouseExited(e -> returnToMainButton.setEffect(null));
	}
	
	//CALCULATE AMOUNT WON
	public void checkAmountWon() {
		numOfMatches();
		if (match == 2) {
			amountWon = bet*(twoMatches[symbolNum]/100.0);
		}
		else if (match == 3) {
			amountWon = bet*(threeMatches[symbolNum]/100.0);
		}
		else {
			amountWon = 0;
		}
		amountWonLabel.setText(Integer.toString((int)amountWon));
	}
	
	//UPDATE CURRENT CASH
	public void updateCurrentAmount() {
		totalCash = (int) (totalCash + amountWon);
		currAmountLabel.setText(Integer.toString(totalCash));
	}
	
	//RSEET VARIABLES FOR NEW GAME
	public void playAgain(ActionEvent event) throws Exception{
		
		playSound("buttonClicked", false);
		bet = 0;
		match = 1;
		amountWon = 0;
		coins = 0;
		choice[0] = DiceRoll() - 1;
		choice[1] = DiceRoll() - 1;
		choice[2] = DiceRoll() - 1;
		amountWonLabel.setText("Amount Won");
		coinsLabel.setText("Coins");
		slot1.setGraphic(null);
		slot2.setGraphic(null);
		slot3.setGraphic(null);
		playAgainButton.setVisible(false);
		playAgainButton.setDisable(true);
		returnToMainButton.setVisible(false);
		returnToMainButton.setDisable(true);
		betOneButton.setDisable(false);
		betMaxButton.setDisable(false);
	}
	
	//CLOSE GAME AND RETURN TO MAIN MENU
	public void returnToMain(ActionEvent e) throws Exception{
		
		playSound("buttonClicked", false); 
		editFile();
	    Stage primaryStage = (Stage) returnToMainButton.getScene().getWindow();
	    primaryStage.close();
	}
	
	//INITALIZE VARIABLES WHEN WINDOW OPENS AND ADD EFFECTS TO BUTTONS
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		currAmountLabel.setText(Integer.toString(totalCash)); //DISPLAY CURRENT CASH
		
		rulesButton.setOnMouseEntered(e -> rulesButton.setEffect(glow));
		rulesButton.setOnMouseExited(e -> rulesButton.setEffect(null));
		payTableButton.setOnMouseEntered(e -> payTableButton.setEffect(glow));
		payTableButton.setOnMouseExited(e -> payTableButton.setEffect(null));
		betOneButton.setOnMouseEntered(e -> betOneButton.setEffect(glow));
		betOneButton.setOnMouseExited(e -> betOneButton.setEffect(null));
		betMaxButton.setOnMouseEntered(e -> betMaxButton.setEffect(glow));
		betMaxButton.setOnMouseExited(e -> betMaxButton.setEffect(null));
	}
}
