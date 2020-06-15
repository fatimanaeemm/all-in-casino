package application;
//Fatima Naeen

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Baccarat extends Dealer {
	
	Stage window, resultWindow;
	Scene scene1, scene2;
	
    String cards[]=new String[52];
	private String card1,card2,card3,card4,card5,card6; //for cards (1-3: player, 4-6: dealer)
	private int sumOfPlayer=0, sumOfDealer=0, amountWon=0;
	private List<Integer> playerSum = new ArrayList<Integer>();
	private List<Integer> dealerSum = new ArrayList<Integer>();
	Dealer draw=new Dealer();
	private final ObservableList<Integer> storeBet = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// setting window
		window=primaryStage;
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		window.setWidth(primScreenBounds.getWidth());
	    window.setHeight(primScreenBounds.getHeight());
	    
	    //					SETTING SCENE 1: WELCOME TO BACCARAT
	    
	    Pane pane=new Pane();
		pane.setStyle("-fx-background-color: #3aba1a;");
	
		//setting scene 1
		scene1=new Scene(pane);
		window.setScene(scene1);
		window.show();
		
		//creating label for title
		Label label=new Label("BACCARAT");
		label.setFont(Font.font("Cooper Black", FontWeight.BOLD, 30));
		label.setTextFill(Color.web("#000000"));
		label.setTranslateX(400);
		label.setTranslateY(100);
		
		
		//creating textbox for instructions
		Text instruct=new Text(260,180,"\t\t\t\t   Welcome to Baccarat!\n\nHere are the rules:\nYou will be dealt a card. You have the choice to hit, or stand.\nIf sum of your cards is greater than dealer, you win, else you lose.");
		instruct.setFont(Font.font("Arial", 16));
		
		//requesting bet
		Label placeBet=new Label("Place a bet greater than $100");
		placeBet.setTranslateX(350);
		placeBet.setTranslateY(270);
		placeBet.setTextFill(Color.web("#000000"));
		placeBet.setFont(Font.font("Arial", FontWeight.BOLD,20));
		
		TextField textBox=new TextField();
		textBox.setTranslateX(420);
		textBox.setTranslateY(300);
		
		//adding play game button
		Button play=new Button("Play Game");
		play.setPrefSize(100, 30);
		play.setLayoutX(450);
		play.setLayoutY(350);
		play.setTextFill(Color.web("#FFFFFF"));
		play.setStyle("-fx-background-color: #000000;");
		play.setDisable(true);
		
		//placing bet
		textBox.setOnAction(event->{
			storeBet.add(Integer.parseInt(textBox.getText()));
			if(storeBet.get(0)>=100)
				play.setDisable(false);
			else
				storeBet.remove(0);
		});
		
		//display cards on home screen
		ImageView display=new ImageView();
		display.setImage(new Image(getClass().getResourceAsStream("/images/display.png")));
		display.setFitWidth(550);
		display.setFitHeight(350);
		display.setTranslateX(750);
		display.setTranslateY(300);
		
		//setting pane
		pane.getChildren().addAll(label,instruct,placeBet,textBox,play,display);
		
		//use of "Play Game" button
		play.setOnAction(e->{
			try {
				if(totalCash<0) {
					new Main().start(window);
				}
				(new Player()).playSound("buttonClicked", false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			window.setScene(scene2);
			}
		);
		
		 //					SETTING SCENE 1: PLAY GAME
	    
	   //setting layout for scene 2
		Pane box= new VBox();
		box.setStyle("-fx-background-color: #3aba1a;");
		box.setPrefSize(window.getWidth(), window.getHeight());
		HBox dealerBox=new HBox();
		HBox playerBox=new HBox();
		playerBox.setTranslateY(100);
		
		//setting rule box
		Label ruleBox=new Label("\t  Rules for adding your cards:\n\t    Add up your cards to know the sum\n\t    Ace is worth 1 point\n\t    King, Queen, and Jack are worth 0\n\t    When sum is greater than 9,\n\t    subtract 10 to know your actual sum");
		ruleBox.setTranslateX(800);
		ruleBox.setTranslateY(100);
		ruleBox.setPrefSize(300, 150);
		ruleBox.setTextFill(Color.web("#FFFFFF"));
		ruleBox.setStyle("-fx-background-color: #000000;");
		ruleBox.setTextAlignment(TextAlignment.CENTER);
		ruleBox.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
		
		//drawing 1st card for dealer
				draw.ShuffleDeck();
				card4=draw.DrawCard();
				ImageView dealerCard1=new ImageView();
				dealerCard1.setImage(new Image(getClass().getResourceAsStream("/images/"+card4 + ".png")));
				setCardSize(dealerCard1);
				dealerCard1.setTranslateX(100);
			    dealerCard1.setTranslateY(30);
			    dealerBox.getChildren().add(dealerCard1);
			    
			    updateSum(card4,dealerSum);
			    sumOfDealer=tempUpdateDealerSum(card4, sumOfDealer);
			    
				dealerBox.getChildren().add(ruleBox);
				
		//drawing 1st card for player
				card1=draw.DrawCard();
				ImageView playerCard1=new ImageView();
				playerCard1.setImage(new Image(getClass().getResourceAsStream("/images/"+card1 + ".png")));
				setCardSize(playerCard1);
				playerCard1.setFitWidth(250);
				playerCard1.setTranslateX(370);
				playerBox.getChildren().add(playerCard1);
				
				updateSum(card1,playerSum);
			    
				
		//creating labels for dealer's cards and player's cards
				Label dealer=new Label("Dealer's Cards");
				dealerBox.getChildren().add(dealer);
				dealer.setTranslateX(-320);
				dealer.setTranslateY(300);
				dealer.setFont(Font.font("Arial", FontWeight.BOLD, 15));
				dealer.setTextFill(Color.rgb(0,0,0));
				Label player=new Label("Your cards");
				player.setTranslateX(250);
				player.setTranslateY(270);
				player.setFont(Font.font("Arial", FontWeight.BOLD, 15));
				player.setTextFill(Color.rgb(0,0,0));
				playerBox.getChildren().add(player);
				
				
				//hit or stand buttons
				Button hit=new Button("Hit");
				Button stand=new Button("Stand");
				
				hit.setTranslateX(-50);
				hit.setTranslateY(50);
		  		hit.setTextFill(Color.web("#FFFFFF"));
				hit.setStyle("-fx-background-color: #000000;");
				hit.setPrefSize(80, 20);
				
				stand.setTranslateX(-130);
				stand.setTranslateY(100);
		  		stand.setTextFill(Color.web("#FFFFFF"));
				stand.setStyle("-fx-background-color: #000000;");
				stand.setPrefSize(80, 20);
				
				//dealing the player cards when they click hit
			     EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
			            public void handle(ActionEvent e)
			            {
							try {
								(new Player()).playSound("buttonClicked", false);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
			            	//dealing player's card 2
			            	if (card2==null)
			            	{
			            		card2=draw.DrawCard();
			            		ImageView playerCard2=new ImageView();
			            		playerCard2.setImage(new Image(getClass().getResourceAsStream("/images/"+card2 + ".png")));
			            		setCardSize(playerCard2);
			            		playerCard2.setTranslateX(200);
			            		playerBox.getChildren().add(playerCard2);
							
			            		updateSum(card2,playerSum);
			    	      			
			            	}
			            	//dealing player's card 3
			            	else if(card3==null)
			            	{
			            		card3=draw.DrawCard();
				            	ImageView playerCard3=new ImageView();
				            	playerCard3.setImage(new Image(getClass().getResourceAsStream("/images/"+card3 + ".png")));
								setCardSize(playerCard3);
								playerCard3.setTranslateX(280);
								playerCard3.setPreserveRatio(true);
						        playerBox.getChildren().add(playerCard3);
						        
						        updateSum(card3,playerSum);
						        
			    				hit.setDisable(true);
			            	}
			            }
			        };
				  hit.setOnAction(event1);
				  playerBox.getChildren().addAll(hit, stand);
 				 
  				  //deciding and dealing dealer's cards when player clicks stand
  				  EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
  			            public void handle(ActionEvent e)
  			            {
							try {
								(new Player()).playSound("buttonClicked", false);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
  			            	hit.setDisable(true);
  			            	stand.setDisable(true);
  			            	
  			            	//drawing dealer's card 2
  							if(sumOfDealer<5)
  							{
  								card5=draw.DrawCard();
  								ImageView dealerCard2=new ImageView();
  				            	dealerCard2.setImage(new Image(getClass().getResourceAsStream("/images/"+card5 + ".png")));
  								setCardSize(dealerCard2);
  								dealerCard2.setTranslateY(30);
  								dealerCard2.setTranslateX(-215);
  							    dealerBox.getChildren().add(dealerCard2);
  							    
  							   updateSum(card5,dealerSum);
  							   sumOfDealer=tempUpdateDealerSum(card5, sumOfDealer);
  							    
  								
  								//drawing dealer's card 3
  									if(sumOfDealer<5)
  									{
  										card6=draw.DrawCard();
  						            	ImageView dealerCard3=new ImageView();
  						            	dealerCard3.setImage(new Image(getClass().getResourceAsStream("/images/"+card6 + ".png")));
  										setCardSize(dealerCard3);
  										dealerCard3.setTranslateX(-135);
  										dealerCard3.setTranslateY(30);
  									    dealerBox.getChildren().add(dealerCard3);
  									    
  									updateSum(card6,dealerSum);
  									    
  									}
  			            	}

  							//button for proceeding to result of game
  							Button proceed=new Button("Proceed");
  							proceed.setTranslateY(50);
  							proceed.setTranslateX(400);
  					  		proceed.setTextFill(Color.web("#FFFFFF"));
  							proceed.setStyle("-fx-background-color: #000000;");
  							playerBox.getChildren().add(proceed);

  							proceed.setOnAction(e2->computeResults());
  							
  			            }
  			            };
  			            stand.setOnAction(event2);
  			            
		//setting scene 2
		box.getChildren().addAll(dealerBox,playerBox);
		scene2=new Scene(box);
		
	}

	//sets size of cards
	private void setCardSize(ImageView iv)
	{
		iv.setFitHeight(250);
	    iv.setFitWidth(250);
	    iv.setPreserveRatio(true);
	}
	
	//returns numeric worth of each card to and into cards sum
	private int convertToInt(String card)
	{
		char c;
		c=card.charAt(0);
		if(c=='K'||c=='Q'||c=='J')
				return 0;
		else if(c=='A')
			return 1;
		else if(card.charAt(1)=='0')
			return 10;
		else
			return Character.getNumericValue(c);
	}
	
	//updates player and dealer sums in playerSum and dealerSum array lists
	private void updateSum(String card, List<Integer> sum)
	{
		int c=convertToInt(card);
		sum.add(c);
	}

	//temporarily updates dealer sum to help computer decide whether to deal more cards for dealer i.e. for logic purposes
	private int tempUpdateDealerSum(String card, int sum)
	{
		int c=convertToInt(card);
		sum+=c;
		if(sum>9)
			return sum-10;
		else
			return sum;
	}
	
	//computes and displays results
	public void computeResults()
      {
		resultWindow=new Stage();
		resultWindow.setHeight(250);
		resultWindow.setWidth(250);
		BorderPane resultPane=new BorderPane();
		resultPane.setStyle("-fx-background-color: #3aba1a;");
		Scene resultScene=new Scene(resultPane);
		resultWindow.setScene(resultScene);
		resultWindow.show();
		
		//storing sum of player
	  for(int i = 0; i < playerSum.size(); i++) 
	  {
		  sumOfPlayer+= playerSum.get(i);
		  if (sumOfPlayer>9)
				sumOfPlayer=sumOfPlayer-10;
	  }
	  
	  //storing sum of dealer
	  sumOfDealer=0;
		for(int i = 0; i < dealerSum.size(); i++) 
		{
			sumOfDealer+=	dealerSum.get(i);
			if (sumOfDealer>9)
				sumOfDealer=sumOfDealer-10;
		}
		
		int bet= storeBet.get(0);
		
		//if player wins
  		if(sumOfPlayer>sumOfDealer)
  		{
  			amountWon=2*bet;
  			Label win=new Label("You win\n  $"+amountWon);
  			resultPane.setCenter(win);
  			win.setFont(new Font("Arial", 24));
  			win.setTextFill(Color.rgb(0,0,0));
  			win.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
  		}
  		
  		//if it's a draw
  		else if(sumOfPlayer==sumOfDealer)
  		{
  			Label draw=new Label("It's a draw!");
  			resultPane.setCenter(draw);
  			draw.setFont(new Font("Arial", 24));
  			draw.setTextFill(Color.rgb(0,0,0));
  			draw.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
  			amountWon=bet;
  		}
  		
  		//if player loses
  		else
  		{
  			Label lose=new Label("You lose");
  			resultPane.setCenter(lose);
  			lose.setFont(new Font("Arial", 24));
  			lose.setTextFill(Color.rgb(0,0,0));
  			lose.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
  			amountWon=-bet;
  		}
  		
  		Player access=new Player();
  		access.updateCash(amountWon);
  		
  		//button for proceeding to main menu
  		Button mainMenu=new Button("Proceed to Main Menu.");
  		resultPane.setBottom(mainMenu);
  		mainMenu.setTranslateX(50);
  		mainMenu.setTranslateY(-30);
  		
  		mainMenu.setOnAction(e->{
			try {
				(new Player()).playSound("buttonClicked", false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
  			resultWindow.close();
			try {
				editFile();
				new Main().start(window);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
      }
	
	public static void main(String[] args) {

		Application.launch(args);
	}

}