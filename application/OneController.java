package application;
//Ajwad Masood
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OneController extends Dealer implements Initializable{
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		}catch(Exception e) {}
	}
	@FXML
	private int totalBet=0;
	private int finalCash=0;
	private int passBet,dontPassBet,k,j,fieldBet,placeFour,placeFive,placeSix,placeEight,placeNine,placeTen,seven,hardFour,hardSix,hardEight,hardTen,sumTwo,sumThree,sumEleven,sumTwelve,bigSix,bigEight;
	private int count = 0,count2=0,count3=0,countp = 0,pcount=0;
	private boolean stop[]= new boolean[20];
	public static int profit,prevCash;
	@FXML
	private Label Bbet;
	@FXML
	private Label Ffinal;
	@FXML
	private Pane pane2;
	@FXML
	private Label diceNum;
	@FXML
	private Label kay;
	@FXML
	private Label dice1;
	@FXML
	private Label dice2;
	@FXML
	private Label countTwo;
	@FXML
	private Label countThree;
	@FXML
	private Button four;
	@FXML
	private Button five;
	@FXML
	private Button six;
	@FXML
	private Button eight;
	@FXML
	private Button nine;
	@FXML
	private Button ten;
	@FXML
	private Button passLine;
	@FXML
	private Button dPassLine;
	@FXML
	private Button field;
	@FXML
	private Button sevenf;
	@FXML
	private Button hardFour1;
	@FXML
	private Button hardTen1;
	@FXML
	private Button hardSix1;
	@FXML
	private Button hardEight1;
	@FXML
	private Button sumThree1;
	@FXML
	private Button sumEleven1;
	@FXML
	private Button sumTwo1;
	@FXML
	private Button sumTwelve1;
	@FXML
	private Button bigSix1;
	@FXML
	private Button bigEight1;
	@FXML
	private Button throwButton;
	@FXML
	private Label winnings;
	@FXML
	private Button returnToMainButton;
	
	Image image = new Image(getClass().getResourceAsStream("/images/fChip.PNG"));
	ImageView imageView = new ImageView(image);
	
	Image imgdice1 = new Image(getClass().getResourceAsStream("/images/dice1.PNG"));
	ImageView imageView1 = new ImageView(imgdice1);
	
	Image imgdice2 = new Image(getClass().getResourceAsStream("/images/dice2.PNG"));
	ImageView imageView2 = new ImageView(imgdice2);
	
	Image imgdice3 = new Image(getClass().getResourceAsStream("/images/dice3.PNG"));
	ImageView imageView3 = new ImageView(imgdice3);
	
	Image imgdice4 = new Image(getClass().getResourceAsStream("/images/dice4.PNG"));
	ImageView imageView4 = new ImageView(imgdice4);
	
	Image imgdice5 = new Image(getClass().getResourceAsStream("/images/dice5.PNG"));
	ImageView imageView5 = new ImageView(imgdice5);
	
	Image imgdice6 = new Image(getClass().getResourceAsStream("/images/dice6.PNG"));
	ImageView imageView6 = new ImageView(imgdice6);
	
	public void pass(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		passLine.setGraphic(imageView);
		passBet+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void passOdds(ActionEvent e) {
		passBet+=passBet;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
	}
	public void dontPass(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		dPassLine.setGraphic(imageView);
		dontPassBet+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void dontPassOdds(ActionEvent e) {
		dontPassBet+=dontPassBet;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
	}
	public void field(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		field.setGraphic(imageView);
		fieldBet+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void placeFour(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		four.setGraphic(imageView);
		placeFour+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void placeFive(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		five.setGraphic(imageView);
		placeFive+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void placeSix(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		six.setGraphic(imageView);
		placeSix+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void placeEight(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		eight.setGraphic(imageView);
		placeEight+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void placeNine(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		nine.setGraphic(imageView);
		placeNine+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void placeTen(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		ten.setGraphic(imageView);
		placeTen+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void seven(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		sevenf.setGraphic(imageView);
		seven+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void hardFour(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		hardFour1.setGraphic(imageView);
		hardFour+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void hardTen(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		hardTen1.setGraphic(imageView);
		hardTen+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void hardEight(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		hardEight1.setGraphic(imageView);
		hardEight+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void hardSix(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		hardSix1.setGraphic(imageView);
		hardSix+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void sumThree(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		sumThree1.setGraphic(imageView);
		sumThree+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void sumEleven(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		sumEleven1.setGraphic(imageView);
		sumEleven+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void sumTwo(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		sumTwo1.setGraphic(imageView);
		sumTwo+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void sumTwelve(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		sumTwelve1.setGraphic(imageView);
		sumTwelve+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void bigSix(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		bigSix1.setGraphic(imageView);
		bigSix+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	public void bigEight(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(30);
		imageView.setFitWidth(30);
		bigEight1.setGraphic(imageView);
		bigEight+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		throwButton.setDisable(false);
	}
	
	
	@FXML
	public void returnToMain(ActionEvent e)  throws Exception{
		playSound("buttonClicked", false);
		editFile();
		
	    Stage primaryStage = (Stage) returnToMainButton.getScene().getWindow();
	    primaryStage.close();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Ffinal.setText("total: $"+String.valueOf(totalCash));
		throwButton.setDisable(true);
		//File nFile = new File(file);
	}
	
	@FXML
	public void throwDice(ActionEvent e) {
		prevCash = totalCash;
		int roll1 = DiceRoll();
		int roll2 = DiceRoll();
		
		int sum =  roll1 + roll2;
		
		if(roll1 == 1) {
			ImageView imageView1 = new ImageView(imgdice1);
			imageView1.setFitHeight(65);
			imageView1.setFitWidth(78);
			dice1.setGraphic(imageView1);
		}
		
		if(roll2 == 1) {
			ImageView imageView1 = new ImageView(imgdice1);
			imageView1.setFitHeight(65);
			imageView1.setFitWidth(78);
			dice2.setGraphic(imageView1);
		}
		
		if(roll1 == 2) {
			ImageView imageView2 = new ImageView(imgdice2);
			imageView2.setFitHeight(65);
			imageView2.setFitWidth(78);
			dice1.setGraphic(imageView2);
		}
		
		if(roll2 == 2) {
			ImageView imageView2 = new ImageView(imgdice2);
			imageView2.setFitHeight(65);
			imageView2.setFitWidth(78);
			dice2.setGraphic(imageView2);
		}
		
		if(roll1 == 3) {
			ImageView imageView3 = new ImageView(imgdice3);
			imageView3.setFitHeight(65);
			imageView3.setFitWidth(78);
			dice1.setGraphic(imageView3);
		}
		
		if(roll2 == 3) {
			ImageView imageView3 = new ImageView(imgdice3);
			imageView3.setFitHeight(65);
			imageView3.setFitWidth(78);
			dice2.setGraphic(imageView3);
		}
		
		if(roll1 == 4) {
			ImageView imageView4 = new ImageView(imgdice4);
			imageView4.setFitHeight(65);
			imageView4.setFitWidth(78);
			dice1.setGraphic(imageView4);
		}
		
		if(roll2 == 4) {
			ImageView imageView4 = new ImageView(imgdice4);
			imageView4.setFitHeight(65);
			imageView4.setFitWidth(78);
			dice2.setGraphic(imageView4);
		}
		
		if(roll1 == 5) {
			ImageView imageView5 = new ImageView(imgdice5);
			imageView5.setFitHeight(65);
			imageView5.setFitWidth(78);
			dice1.setGraphic(imageView5);
		}
		
		if(roll2 == 5) {
			ImageView imageView5 = new ImageView(imgdice5);
			imageView5.setFitHeight(65);
			imageView5.setFitWidth(78);
			dice2.setGraphic(imageView5);
		}
		
		if(roll1 == 6) {
			ImageView imageView6 = new ImageView(imgdice6);
			imageView6.setFitHeight(65);
			imageView6.setFitWidth(78);
			dice1.setGraphic(imageView6);
		}
		
		if(roll2 == 6) {
			ImageView imageView6 = new ImageView(imgdice6);
			imageView6.setFitHeight(65);
			imageView6.setFitWidth(78);
			dice2.setGraphic(imageView6);
		}
		
		if(passBet!=0){
			if(count == 0) {
				k = sum;
			if(sum==7 || sum==11){
				betWon(passBet);
				passBet = 0;
				count3++;
				passLine.setGraphic(null);
			}else if(sum==2 || sum==3 || sum==12){
				betLost(passBet);
				passBet = 0;
				count3++;
				passLine.setGraphic(null);
			}
			
			}else if(sum==4 || sum==5 || sum==6 || sum==8 || sum ==9 || sum==10 || sum == 7) {
				if(count == 1) {
					if(sum == 7) {
						betLost(passBet);
						passBet = 0;
						count3++;
						passLine.setGraphic(null);
					}
					if(sum == k){
						betWon(passBet);
						passBet = 0;
						count3++;
						passLine.setGraphic(null);
					}
				
				}
			}
			count = 1;
			
		}
		if(dontPassBet!=0) {
			if(countp == 0) {
				j = sum;
			if(sum==7 || sum==11){
				betLost(dontPassBet);
				dontPassBet = 0;
				count3++;
				dPassLine.setGraphic(null);
			}
			if(sum==2 || sum==3){
				betWon(dontPassBet);
				dontPassBet = 0;
				count3++;
				dPassLine.setGraphic(null);
			}
			if(sum==12) {
				dontPassBet = 0;
				count3++;
				dPassLine.setGraphic(null);
			}
			
			}else if(sum==4 || sum==5 || sum==6 || sum==8 || sum ==9 || sum==10 || sum == 7) {
				if(countp == 1) {
					if(sum == j) {
						betLost(dontPassBet);
						dontPassBet = 0;
						count3++;
						dPassLine.setGraphic(null);
					}
					if(sum == 7){
						betWon(dontPassBet);
						dontPassBet = 0;
						count3++;
						dPassLine.setGraphic(null);
					}
				
				}
			}
			
		}
		
		if(fieldBet!=0) {
			if(sum==5 || sum==6|| sum==7 || sum==8){
				betLost(fieldBet);
				fieldBet=0;
				count3++;
				field.setGraphic(null);
			}
			if(sum==2 || sum==3 || sum == 4 || sum==9 || sum==10 || sum==11|| sum==12){
				if(sum == 2){
					fieldBet*=2;
					betWon(fieldBet);
					fieldBet=0;
					count3++;
					field.setGraphic(null);
				}
				if(sum == 12){
					fieldBet*=3;
					betWon(fieldBet);
					fieldBet=0;
					count3++;
					field.setGraphic(null);
				}
				if(sum==3 || sum == 4 || sum==9 || sum==10 || sum==11){
					betWon(fieldBet);
					fieldBet=0;
					count3++;
					field.setGraphic(null);
				}
			}
		
		}
		
		if(placeFour!=0) {
			if(sum == 4){
				placeFour*=1.8;
				betWon(placeFour);
				placeFour = 0;
				count3++;
				four.setGraphic(null);
			}
			if(sum == 7){
				betLost(placeFour);
				placeFour = 0;
				count3++;
				four.setGraphic(null);
			}
		}
		
		if(placeFive!=0) {
			if(sum == 5){
				placeFive*=1.4;
				betWon(placeFive);
				placeFive = 0;
				count3++;
				five.setGraphic(null);
			}
			if(sum == 7){
				betLost(placeFive);
				placeFive = 0;
				count3++;
				five.setGraphic(null);
			}
		}
		
		if(placeSix!=0) {
			if(sum == 6){
				placeSix*=1;     
				betWon(placeSix);
				placeSix = 0;
				count3++;
				six.setGraphic(null);
			}
			if(sum == 7){
				betLost(placeSix);
				//finalCash -= placeSix;
				placeSix = 0;
				count3++;
				six.setGraphic(null);
			}
		}
		
		if(placeEight!=0) {
			if(sum == 8){
				placeEight*=1;       
				betWon(placeEight);
				placeEight = 0;
				count3++;
				eight.setGraphic(null);
			}
			if(sum == 7){
				betLost(placeEight);
				placeEight = 0;
				count3++;
				eight.setGraphic(null);
			}
		}
		
		if(placeNine!=0) {
			if(sum == 9){
				placeNine*=1.4;
				betWon(placeNine);
				placeNine = 0;
				count3++;
				nine.setGraphic(null);
			}
			if(sum == 7){
				betLost(placeNine);
				placeNine = 0;
				count3++;
				nine.setGraphic(null);
			}
		}
		
		if(placeTen!=0) {
			if(sum == 10){
				placeTen*=1.8;
				betWon(placeTen);
				//finalCash += placeTen;
				placeTen = 0;
				count3++;
				ten.setGraphic(null);
			}
			if(sum == 7){
				betLost(placeTen);
				placeTen = 0;
				count3++;
				ten.setGraphic(null);
			}
		}
		
		if(seven!=0){
				if(sum == 7){
					seven*=4;
					betWon(seven);
					seven = 0;
					count3++;
					sevenf.setGraphic(null);
				}else{
					betLost(seven);
					seven = 0;
					count3++;
					sevenf.setGraphic(null);
				}
		}
		
		if(hardFour!=0){
				if(roll1 == 2 && roll2 == 2){
					hardFour*=7;
					betWon(hardFour);
					hardFour = 0;
					count3++;
					hardFour1.setGraphic(null);
				}else{
					betLost(hardFour);
					hardFour = 0;
					count3++;
					hardFour1.setGraphic(null);
				}
			}
		
		if(hardTen!=0){
				if(roll1 == 5 && roll2 == 5){
					hardTen*=7;
					betWon(hardTen);
					hardTen = 0;
					count3++;
					hardTen1.setGraphic(null);
				}else{
					betLost(hardTen);
					hardTen = 0;
					count3++;
					hardTen1.setGraphic(null);
				}
			}
		
		if(hardSix!=0){
				if(roll1 == 3 && roll2 == 3){
					hardSix*=9;
					betWon(hardSix);
					hardSix = 0;
					count3++;
					hardSix1.setGraphic(null);
				}else{
					betLost(hardSix);
					hardSix = 0;
					count3++;
					hardSix1.setGraphic(null);
				}
			}
		
		if(hardEight!=0){
				if(roll1 == 4 && roll2 == 4){
					hardEight*=9;
					betWon(hardEight);
					hardEight = 0;
					count3++;
					hardEight1.setGraphic(null);
				}else{
					betLost(hardEight);
					hardEight = 0;
					count3++;
					hardEight1.setGraphic(null);
				}
			}
		
		if(sumThree!=0){
				if(sum == 3){
					sumThree*=15;
					betWon(sumThree);
					sumThree = 0;
					count3++;
					sumThree1.setGraphic(null);
				}else{
					betLost(sumThree);
					sumThree = 0;
					count3++;
					sumThree1.setGraphic(null);
				}
			}
		
		if(sumEleven!=0){
				if(sum == 11){
					sumEleven*=15;
					betWon(sumEleven);
					sumEleven = 0;
					count3++;
					sumEleven1.setGraphic(null);
				}else{
					betLost(sumEleven);
					//finalCash -= sumEleven;
					sumEleven = 0;
					count3++;
					sumEleven1.setGraphic(null);
				}
			}
		
		if(sumTwo!=0){
				if(sum == 2){
					sumTwo*=30;
					betWon(sumTwo);
					sumTwo = 0;
					count3++;
					sumTwo1.setGraphic(null);
				}else{
					betLost(sumTwo);
					sumTwo = 0;
					count3++;
					sumTwo1.setGraphic(null);
				}
			}
		
		if(sumTwelve!=0){
				if(sum == 12){
					sumTwelve*=30;
					betWon(sumTwelve);
					sumTwelve = 0;
					count3++;
					sumTwelve1.setGraphic(null);
				}else{
					betLost(sumTwelve);
					sumTwelve = 0;
					count3++;
					sumTwelve1.setGraphic(null);
				}
			}
		
		if(bigSix!=0) {
			if(sum == 6){
				betWon(bigSix);
				bigSix = 0;
				count3++;
				bigSix1.setGraphic(null);
			}
			if(sum == 7){
				betLost(bigSix);
				bigSix = 0;
				count3++;
				bigSix1.setGraphic(null);
			}
		}
		
		if(bigEight!=0) {
			if(sum == 8){
				betWon(bigEight);
				bigEight = 0;
				count3++;
				bigEight1.setGraphic(null);
			}
			if(sum == 7){
				betLost(bigEight);
				bigEight = 0;
				count3++;
				bigEight1.setGraphic(null);
			}
		}
		count2 = 0;
		if(passBet!=0){
			count = 1;
		}else {
			count=0;
		}
		if(dontPassBet!=0){
			countp = 1;
		}else {
			countp=0;
		}
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		
		profit = totalCash - prevCash;
		if(passBet==0||dontPassBet==0||fieldBet==0||placeFour==0||placeFive==0||placeSix==0||placeEight==0||placeNine==0||placeTen==0||seven==0||hardFour==0||hardSix==0||hardEight==0||hardTen==0||sumTwo==0||sumThree==0||sumEleven==0||sumTwelve==0||bigSix==0||bigEight==0) {
			if(profit>=0) {
				winnings.setStyle("-fx-text-fill:gold;");
				winnings.setText("You won "+Integer.toString(profit));
				}
				if(profit<=0) {
					winnings.setStyle("-fx-text-fill:red;");
					winnings.setText("You Lost "+Integer.toString(profit));
					}
			}
		Ffinal.setText("total: $"+Integer.toString(totalCash));
		if((passBet+dontPassBet+fieldBet+placeFour+placeFive+placeSix+placeEight+placeNine+placeTen+seven+hardFour+hardSix+hardEight+hardTen+sumTwo+sumThree+sumEleven+sumTwelve+bigSix+bigEight)==0) {
			throwButton.setDisable(true);
		}
		
	}
}