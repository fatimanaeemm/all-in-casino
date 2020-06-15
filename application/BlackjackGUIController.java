//MARYAM FAROOQ
//299778

package application;

import java.util.ArrayList;
import java.util.ResourceBundle;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.image.*;
import javafx.stage.Stage;

public class BlackjackGUIController extends Dealer implements Initializable {
	
	@FXML
	private Label pC1 = new Label();
	@FXML
	private Label pC2 = new Label();
	@FXML
	private Label pC3 = new Label();
	@FXML
	private Label pC4 = new Label();
	@FXML
	private Label pC5 = new Label();
	@FXML
	private Label dC1 = new Label();
	@FXML
	private Label dC2 = new Label();
	@FXML
	private Label dC3 = new Label();
	@FXML
	private Label dC4 = new Label();
	@FXML
	private Label dC5 = new Label();
	@FXML
	private Label playerSumLabel;
	@FXML
	private Label dealerSumLabel;
	@FXML
	private Label winOrLose;
	@FXML
	private Label bustOrBlackjack;
	@FXML
	private Image image;
	@FXML
	private Label currAmountLabel;
	@FXML
	private Button dealButton;
	@FXML
	private Button hitButton;
	@FXML
	private Button splitButton;
	@FXML
	private Button standButton;
	@FXML
	protected Button continueSplit;
	@FXML
	private Button doubleButton;
	@FXML
	private Button playAgainButton;
	@FXML
	private Button returnToMainButton;
	@FXML
	private Button displayRulesButton;
	
	
	String splitCard;
	static int bet = 0;
	boolean doublePlayer = false;
	boolean playerSplit = false;
	boolean playerWin = false;
	boolean draw = false;
	int temp = 0;
	int playerHits = 2;
	int dealerHits = 2;
	int ace;
	int playerSum = 0;
	int dealerSum = 0;
	char c;
	ArrayList<String> playerCards = new ArrayList<String>(5);
	ArrayList<String> dealerCards = new ArrayList<String>(5);
	Glow glow = new Glow(0.75);
	URL url;

	//DEAL FIRST TWO CARDS TO PLAYER AND DEALER
	public void deal(ActionEvent event) throws Exception {
		playSound("buttonClicked", false);
	    currAmountLabel.setText(Integer.toString(totalCash)); //DISPLAY CURRENT AMOUNT
	    	
		ShuffleDeck();
		
		playerCards.add(DrawCard());
		displayCardImage(pC1, playerCards.get(0));
		playerSum = sum(playerCards);
			
		playerCards.add(DrawCard());
		displayCardImage(pC2, playerCards.get(1));
		playerSum = sum(playerCards);
		displayPlayerSum();
		checkSum(); 
		
		dealerCards.add(DrawCard()); //DRAW CARD FROM DECK
		//DISPLAY CARDS
		image = new Image(getClass().getResourceAsStream("/images/faceDown.png")); 
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(110);
		imageView.setFitWidth(90);
		dC1.setGraphic(imageView);
			
		dealerCards.add(DrawCard());
		displayCardImage(dC2, dealerCards.get(1));
		dealerSum = sum(dealerCards); //CALCULATE SUM
		
		//ENABLE 'SPLIT' BUTTON IF PLAYER GETS CARDS OF SAME DENOMINATION
		if ((playerCards.get(0)).charAt(0) == (playerCards.get(1)).charAt(0)) {
			splitButton.setDisable(false);
			splitButton.setVisible(true);
		}
		//ENABLE 'HIT', 'STAND', 'DOUBLE' BUTTONS AND DISABLE AND HIDE DEAL BUTTON
		dealButton.setDisable(true);
		dealButton.setVisible(false);
		playerSplit = false;
		standButton.setDisable(false);
		hitButton.setDisable(false);
		doubleButton.setDisable(false);
		displayRulesButton.setDisable(true);
	}
	
	//DISPLAY IMAGE OF THE GIVEN CARD IN THE GIVEN LABEL
	public void displayCardImage(Label l, String card) {
		image = new Image(getClass().getResourceAsStream("/images/" + card + ".png"));
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(110);
		imageView.setFitWidth(90);
		l.setGraphic(imageView);
	}
	
	//CALCULATE SUM
	public int sum(ArrayList<String> array) {
		int x;
		int sum = 0;
		temp = 0;
		for (String s : array) {
			c = s.charAt(0);
			if (c == 'A') {
				checkAceValue(temp);
				x = ace;
			}
			else if (c == 'K' || c == 'Q' || c == 'J' || c == '1') x = 10;
			else x = Character.getNumericValue(c);
			sum = sum + x;
			temp = sum;
		}
		return sum;
	}
	
	//ASSIGN LABELS DEPENDING  ON THE NUMBER OF HITS
	public void displayPlayerCard() {
		switch (playerHits) {
		case 3 : displayCardImage(pC3, playerCards.get(playerHits - 1)); break;
		case 4 : displayCardImage(pC4, playerCards.get(playerHits - 1)); break;
		case 5 : displayCardImage(pC5, playerCards.get(playerHits - 1)); break;
		}
	}
	
	public void displayDealerCard() {
		switch (dealerHits) {
		case 3 : displayCardImage(dC3, dealerCards.get(dealerHits - 1)); break;
		case 4 : displayCardImage(dC4, dealerCards.get(dealerHits - 1)); break;
		case 5 : displayCardImage(dC5, dealerCards.get(dealerHits - 1)); break;
		}
	}
	
	//DISPLAY PLAYER SUM 
	public void displayPlayerSum() {
		playerSumLabel.setText(Integer.toString(playerSum));
	}
	
	//DISPLAY DEALER SUM 
	public void displayDealerSum() {
		dealerSumLabel.setText(Integer.toString(dealerSum));
	}

	//IF PLAYER HITS DRAW CARD FROM DECK AND DISPLAY
	public void hitPlayer(ActionEvent e) throws Exception{
		if (!doublePlayer) playSound("buttonClicked", false);
		if (playerHits <= 5) { //PLAYER CANNOT HIT MORE THAN 5 TIMES
			playerHits++;
			playerCards.add(DrawCard());
			playerSum = sum(playerCards);
			displayPlayerSum();
			displayPlayerCard();
			checkSum();
		}
		if (playerHits > 5) {
			dealer();
		}
		if (playerHits > 2) { //PLAYER CANNOT DOUBLE BET AFTER HITTING EVEN ONCE
			doubleButton.setDisable(true);
		}
	}
	
	public void standPlayer(ActionEvent e) throws Exception{
		if (!doublePlayer) playSound("buttonClicked", false);
		dealer();
	}
	
	//DRAW CARD FOR DEALER AND DISPLAY
	public void hitDealer() throws Exception{
		dealerHits++;
	    dealerCards.add(DrawCard());
		dealerSum = sum(dealerCards);
		displayDealerSum();
		displayDealerCard();
		checkSum();
	}
	
	//CHECK WHO WON
	 public void standDealer() throws Exception{
		 if (bustOrBlackjack.getText() != "BUST" && bustOrBlackjack.getText() != "BLACKJACK")
		 checkWinOrLose();
	 }
	
	 //IF PLAYER DECIDES TO DOUBLE, DOUBLE BET AND HIT ONCE ONLY
	public void doublePlayer(ActionEvent e) throws Exception {
		doublePlayer = true;
		playSound("buttonClicked", false);
		bet *= 2;
		standButton.setDisable(true);
		hitButton.setDisable(true);
		hitPlayer(null);
		standPlayer(null);
	}
	
	//CHECK IF DEALER HAS TO HIT OR STAND DEPENDING ON THE SUM
	public void dealer() throws Exception{
		hitButton.setDisable(true);
		standButton.setDisable(true);
		splitButton.setDisable(true);
		doubleButton.setDisable(true);
		displayCardImage(dC1, dealerCards.get(0));
		displayDealerSum();
		while (sum(dealerCards) <= 16 || sum(dealerCards) < sum(playerCards)) { //HIT IF SUM IS LESS THAN OR EQUAL TO 16 
			System.out.println(dealerSum);
			hitDealer();
		}
			standDealer(); //ELSE STAND
	}
	
	//IF SUM EXCEEDS 21 WHEN 11 IS ADDED, ACE = 1 ELSE ACE = 11
	public void checkAceValue(int sum) {
		if (sum + 11 > 21) {
			ace = 1;
		}
		else ace = 11;
	}
	
	//IF PLAYER SPLITS, DOUBLE THE BET AND MAKE TWO HANDS
	public void split(ActionEvent e) throws Exception {
		playSound("buttonClicked", false);
		continueSplit.setVisible(true);
		continueSplit.setDisable(false);
		splitButton.setDisable(true);
		playerSplit = true;
		splitCard = playerCards.get(1); 
		playerCards.remove(1);
		playerCards.add(DrawCard());
		playerSum = sum(playerCards);
		displayCardImage(pC2, playerCards.get(1));
		displayPlayerSum();
	}
	
	//CONTINUE GAME WITH THE SECOND HAND
	public void continueSplit(ActionEvent e) throws Exception {
		playSound("buttonClicked", false);
		continueSplit.setDisable(true);
		hitButton.setDisable(false);
		standButton.setDisable(false);
		playerSplit = false;
		playerCards.clear();
		dealerCards.clear();
		playerSum = 0;
		dealerSum = 0;
		bustOrBlackjack.setText("");
		winOrLose.setText("");
		dC1.setGraphic(null); dC2.setGraphic(null); dC3.setGraphic(null); dC4.setGraphic(null); dC5.setGraphic(null);
		pC1.setGraphic(null); pC2.setGraphic(null); pC3.setGraphic(null); pC4.setGraphic(null); pC5.setGraphic(null);
		playerCards.add(splitCard);
		dealerCards.add(DrawCard());
		displayCardImage(dC1, dealerCards.get(0));
		dealerSum = sum(dealerCards);
			
		dealerCards.add(DrawCard());
		displayCardImage(dC2, dealerCards.get(1));
		dealerSum = sum(dealerCards);
		displayDealerSum();
		dealerHits = 2;
		checkSum();
		
		displayCardImage(pC1, playerCards.get(0));
		playerSum = sum(playerCards);
		
		playerCards.add(DrawCard());
		displayCardImage(pC2, playerCards.get(1));
		playerSum = sum(playerCards);
		displayPlayerSum();
		playerHits = 2;
		checkSum();
	}
	
	//ENABLE DEAL BUTTON
	public void restart() {
		dealButton.setVisible(true);
		dealButton.setDisable(false);
	}
	
	//CHECK FOR BLACKJACK, BUST, OR PUSH
	public void checkSum() throws Exception{
		if (playerSum == 21 && dealerSum == 21) {
			displayCardImage(dC1, dealerCards.get(0));
			displayDealerSum();
			winOrLose.setText("PUSH");
			draw = true;
			gameEnd();
		}
		else if (playerSum > 21) {
			displayCardImage(dC1, dealerCards.get(0));
			displayDealerSum();
			bustOrBlackjack.setText("BUST");
			winOrLose.setText("YOU LOSE");
			playSound("lose", true);
			gameEnd();
		}
		else if (playerSum == 21 && dealerSum != 21) {
			displayCardImage(dC1, dealerCards.get(0));
			displayDealerSum();
			bustOrBlackjack.setText("BLACKJACK");
			//playSound("win", true);
			winOrLose.setText("YOU WIN");
			playerWin = true;
			gameEnd();
		}
		else if (dealerSum > 21) {
			displayCardImage(dC1, dealerCards.get(0));
			displayDealerSum();
			bustOrBlackjack.setText("BUST");
			//playSound("win", true);
			winOrLose.setText("YOU WIN");
			playerWin = true;
			gameEnd();
		}
		else if (dealerSum == 21) {
			displayCardImage(dC1, dealerCards.get(0));
			displayDealerSum();
			bustOrBlackjack.setText("BLACKJACK");
			winOrLose.setText("YOU LOSE");
			playSound("lose", true);
			gameEnd();
		}
		else if (dealerSum == 21 && playerSum == 21) {
			displayCardImage(dC1, dealerCards.get(0));
			displayDealerSum();
			bustOrBlackjack.setText("");
			winOrLose.setText("PUSH");
			gameEnd(); 
		}
	}

	//CHECK WHO WON
	public void checkWinOrLose() throws Exception {
		displayCardImage(dC1, dealerCards.get(0));
		displayDealerSum();
		if (playerSum > dealerSum) {
			winOrLose.setText("YOU WIN");
			//playSound("win", true);
			playerWin = true;
			gameEnd();
		}
		else if (dealerSum > playerSum) {
			winOrLose.setText("YOU LOSE");
			playSound("lose", true);
			gameEnd();
		}
		else if (playerSum == dealerSum) {
			winOrLose.setText("PUSH");
			draw = true;
			gameEnd();
		}
	}
	
	//DISABLE ALL BUTTONS AND DISPLAY AND ENABLE 'PLAY AGAIN' AND 'RETURN TO MAIN' BUTTONS
	public void gameEnd() throws Exception{
		displayRulesButton.setDisable(true);
		hitButton.setDisable(true);
		standButton.setDisable(true);
		doubleButton.setDisable(true);
		splitButton.setDisable(true);
		continueSplit.setDisable(true);
		playAgainButton.setVisible(true);
		playAgainButton.setDisable(false);
		returnToMainButton.setVisible(true);
		returnToMainButton.setDisable(false);
		updateCurrentAmount();
		editFile();
	}
	
	//UPDATE AND DISPLAY CURRENT CASH
	public void updateCurrentAmount() {
		currAmountLabel.setText("Current Amount");
		if (playerWin == true) {
			totalCash += bet*2;
		}
		else if (draw == true) {
			totalCash += bet;
		}
		currAmountLabel.setText(Integer.toString(totalCash));
	}
	
	//INITIALIZE ALL VARIABLES AND RETURN TO DEAL SCENE TO PLACE BET
	public void playAgain(ActionEvent e) throws Exception {
		playSound("buttonClicked", false);
		initVariables();
		
		Parent root = FXMLLoader.load(getClass().getResource("/application/BlackjackGUIDealScene.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage secondScene = (Stage)((Node)e.getSource()).getScene().getWindow();
		secondScene.setScene(scene);
		secondScene.show();
	}
	
	//INITIALZIE VARIABLES FOR NEW GAME
	public void initVariables() {
		bet = 0;
		temp = 0;
		continueSplit.setDisable(true);
		hitButton.setDisable(true);
		standButton.setDisable(true);
		dealButton.setVisible(true);
		dealButton.setDisable(false);
		playerSplit = false;
		draw = false;
		playerCards.clear();
		dealerCards.clear();
		playerSum = 0;
		dealerSum = 0;
		playerHits = 0;
		dealerHits = 0;
		playerSumLabel.setText("");
		dealerSumLabel.setText("");
		bustOrBlackjack.setText("");
		winOrLose.setText("");
		currAmountLabel.setText("Current Amount");
		dC1.setGraphic(null); dC2.setGraphic(null); dC3.setGraphic(null); dC4.setGraphic(null); dC5.setGraphic(null);
		pC1.setGraphic(null); pC2.setGraphic(null); pC3.setGraphic(null); pC4.setGraphic(null); pC5.setGraphic(null);
		playAgainButton.setVisible(false);
		playAgainButton.setDisable(true);
	}
	
	//SHOW RULES SCENE
	public void displayRules(ActionEvent event) throws Exception {
		playSound("buttonClicked", false);
		Parent root = FXMLLoader.load(getClass().getResource("/application/BlackjackRulesScene.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage secondScene = (Stage)((Node)event.getSource()).getScene().getWindow();
		secondScene.setScene(scene);
		secondScene.show();
	}
	
	//CLOSE GAME WINDOW AND RETURN TO MAIN
	public void returnToMain(ActionEvent e) throws Exception {
		
		playSound("buttonClicked", false);
		initVariables();
		returnToMainButton.setVisible(false);
		returnToMainButton.setDisable(true);
		
		Stage primaryStage = (Stage) returnToMainButton.getScene().getWindow();
	    primaryStage.close();
	}
	
	//ADD EFFECTS TO BUTTONS AND DISPLAY CUREENT AMOUNT
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		currAmountLabel.setText(Integer.toString(totalCash));

		displayRulesButton.setOnMouseEntered(e -> displayRulesButton.setEffect(glow));
		displayRulesButton.setOnMouseExited(e -> displayRulesButton.setEffect(null));
		hitButton.setOnMouseEntered(e -> hitButton.setEffect(glow));
		hitButton.setOnMouseExited(e -> hitButton.setEffect(null));
		standButton.setOnMouseEntered(e -> standButton.setEffect(glow));
		standButton.setOnMouseExited(e -> standButton.setEffect(null));
		splitButton.setOnMouseEntered(e -> splitButton.setEffect(glow));
		splitButton.setOnMouseExited(e -> splitButton.setEffect(null));
		doubleButton.setOnMouseEntered(e -> doubleButton.setEffect(glow));
		doubleButton.setOnMouseExited(e -> doubleButton.setEffect(null));
		continueSplit.setOnMouseEntered(e -> continueSplit.setEffect(glow));
		continueSplit.setOnMouseExited(e -> continueSplit.setEffect(null));
		returnToMainButton.setOnMouseEntered(e -> returnToMainButton.setEffect(glow));
		returnToMainButton.setOnMouseExited(e -> returnToMainButton.setEffect(null));
		playAgainButton.setOnMouseEntered(e -> playAgainButton.setEffect(glow));
		playAgainButton.setOnMouseExited(e -> playAgainButton.setEffect(null));
		dealButton.setOnMouseEntered(e -> dealButton.setEffect(glow));
		dealButton.setOnMouseExited(e -> dealButton.setEffect(null));
		
	}

}