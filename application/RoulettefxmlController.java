package application;
//Ajwad Masood
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import javafx.util.Duration;
public class RoulettefxmlController extends Dealer implements Initializable{
	//All the bets are given buttons and labels are made
	@FXML
	private Button spin;
	@FXML
	private Button returnToMainButton;
	@FXML
	private int totalBet=0;
	private int finalCash=0;
	public static int profit,prevCash;
	private int bet[]=new int[37];
	private int column1,column2,column3,first,second,third,firstHalf,secondHalf,even,odd,red,black;
	@FXML
	private Label Bbet,label2,total,second3;
	@FXML
	private Button one1,two,three,four,five,six,seven,eight,nine,ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen,twenty,twentyOne,twentyTwo,twentyThree,twentyFour,twentyFive,twentySix,twentySeven,twentyEight,twentyNine,thirty,thirtyOne,thirtyTwo,thirtyThree,thirtyFour,thirtyFive,thirtySix;
	@FXML
	private Button red1,black1,firstHalf1,secondHalf1,even1,odd1,column1s,column2s,column3s,first1,second1,third1;
	
	Image image = new Image(getClass().getResourceAsStream("/images/fChip.PNG"));
	ImageView imageView = new ImageView(image);
	
	//This method displays a chip on the buttons and places a particular bet.
	public void buttonPress(Button b, int betNo) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		b.setGraphic(imageView);
		b.setContentDisplay(ContentDisplay.CENTER);
		bet[betNo]+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
	}
	
	//buttonPress method is called in each of the following methods
	@FXML
	public void methodOne(ActionEvent e) {
		buttonPress(one1,1);
	}
	public void methodTwo(ActionEvent e) {
		buttonPress(two,2);
	}
	public void methodThree(ActionEvent e) {
		buttonPress(three,3);
	}
	public void methodFour(ActionEvent e) {
		buttonPress(four,4);
	}
	public void methodFive(ActionEvent e) {
		buttonPress(five,5);
	}
	public void methodSix(ActionEvent e) {
		buttonPress(six,6);
	}
	public void methodSeven(ActionEvent e) {
		buttonPress(seven,7);
	}
	public void methodEight(ActionEvent e) {
		buttonPress(eight,8);
	}
	public void methodNine(ActionEvent e) {
		buttonPress(nine,9);
	}
	public void methodTen(ActionEvent e) {
		buttonPress(ten,10);
	}
	public void methodEleven(ActionEvent e) {
		buttonPress(eleven,4);
	}
	public void methodTwelve(ActionEvent e) {
		buttonPress(twelve,12);
	}
	public void methodThirteen(ActionEvent e) {
		buttonPress(thirteen,13);
	}
	public void methodFourteen(ActionEvent e) {
		buttonPress(fourteen,14);
	}
	public void methodFifteen(ActionEvent e) {
		buttonPress(fifteen,15);
	}
	public void methodSixteen(ActionEvent e) {
		buttonPress(sixteen,16);
	}
	public void methodSeventeen(ActionEvent e) {
		buttonPress(seventeen,17);
	}
	public void methodEighteen(ActionEvent e) {
		buttonPress(eighteen,18);
	}
	public void methodNineteen(ActionEvent e) {
		buttonPress(nineteen,19);
	}
	public void methodTwenty(ActionEvent e) {
		buttonPress(twenty,20);
	}
	public void methodTwentyOne(ActionEvent e) {
		buttonPress(twentyOne,21);
	}
	public void methodTwentyTwo(ActionEvent e) {
		buttonPress(twentyTwo,22);
	}
	public void methodTwentyThree(ActionEvent e) {
		buttonPress(twentyThree,23);
	}
	public void methodTwentyFour(ActionEvent e) {
		buttonPress(twentyFour,24);
	}
	public void methodTwentyFive(ActionEvent e) {
		buttonPress(twentyFive,25);
	}
	public void methodTwentySix(ActionEvent e) {
		buttonPress(twentySix,26);
	}
	public void methodTwentySeven(ActionEvent e) {
		buttonPress(twentySeven,27);
	}
	public void methodTwentyEight(ActionEvent e) {
		buttonPress(twentyEight,28);
	}
	public void methodTwentyNine(ActionEvent e) {
		buttonPress(twentyNine,29);
	}
	public void methodThirty(ActionEvent e) {
		buttonPress(thirty,30);
	}
	public void methodThirtyOne(ActionEvent e) {
		buttonPress(thirtyOne,31);
	}
	public void methodThirtyTwo(ActionEvent e) {
		buttonPress(thirtyTwo,32);
	}
	public void methodThirtyThree(ActionEvent e) {
		buttonPress(thirtyThree,33);
	}
	public void methodThirtyFour(ActionEvent e) {
		buttonPress(thirtyFour,34);
	}
	public void methodThirtyFive(ActionEvent e) {
		buttonPress(thirtyFive,35);
	}
	public void methodThirtySix(ActionEvent e) {
		buttonPress(thirtySix,36);
	}
	
	public void column1(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		column1s.setGraphic(imageView);
		column1s.setContentDisplay(ContentDisplay.CENTER);
		column1+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
	}
	
	public void column2(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		column2s.setGraphic(imageView);
		column2s.setContentDisplay(ContentDisplay.CENTER);
		column2+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
		
	}
	
	public void column3(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		column3s.setGraphic(imageView);
		column3s.setContentDisplay(ContentDisplay.CENTER);
		column3+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
	}
	
	public void first(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		first1.setGraphic(imageView);
		first1.setContentDisplay(ContentDisplay.CENTER);
		first+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
	}
	
	public void second(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		second1.setGraphic(imageView);
		second1.setContentDisplay(ContentDisplay.CENTER);
		second+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
	}
	
	public void thirdm(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		third1.setGraphic(imageView);
		third1.setContentDisplay(ContentDisplay.CENTER);
		third+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
	}
	
	public void firstHalf(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		firstHalf1.setGraphic(imageView);
		firstHalf1.setContentDisplay(ContentDisplay.CENTER);
		firstHalf+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
	}
	
	public void secondHalf(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		secondHalf1.setGraphic(imageView);
		secondHalf1.setContentDisplay(ContentDisplay.CENTER);
		secondHalf+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
	}
	
	public void even(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		even1.setGraphic(imageView);
		even1.setContentDisplay(ContentDisplay.CENTER);
		even+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
	}
	
	public void odd(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		odd1.setGraphic(imageView);
		odd1.setContentDisplay(ContentDisplay.CENTER);
		odd+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
	}
	
	public void red(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		red1.setGraphic(imageView);
		red1.setContentDisplay(ContentDisplay.CENTER);
		red+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
	}
	
	public void black(ActionEvent e) {
		ImageView imageView = new ImageView(image);
		imageView.setFitHeight(15);
		imageView.setFitWidth(15);
		black1.setGraphic(imageView);
		black1.setContentDisplay(ContentDisplay.CENTER);
		black+=100;
		totalBet+=100;
		Bbet.setText("bet: $"+Integer.toString(totalBet));
		spin.setDisable(false);
	}
	
	public int rmethod(int a,int b) {
		return (a-b);
	}
	
	public void returnToMain(ActionEvent e) throws Exception{
		playSound("buttonClicked", false);
		editFile();
	    Stage primaryStage = (Stage) returnToMainButton.getScene().getWindow();
	    primaryStage.close();
	}
	
	//Spin button spins the wheel and displays the result
	@FXML
	public void spin(ActionEvent e) throws Exception{
		  roll = rouletteRoll();
		  prevCash = totalCash;
		  
		for(int i=1;i<37;i++) {
			if(bet[i]!=0) {
				if(roll==i) {
					bet[i]*=35;
					betWon(bet[i]);
					bet[i] = 0;
				}else {
					betLost(bet[i]);
					bet[i] = 0;
				}
			}
		}
		
		if(bet[1]==0) {
			one1.setGraphic(null);
		}
		if(bet[2]==0) {
			two.setGraphic(null);
		}
		if(bet[3]==0) {
			three.setGraphic(null);
		}
		if(bet[4]==0) {
			four.setGraphic(null);
		}
		if(bet[5]==0) {
			five.setGraphic(null);
		}
		if(bet[6]==0) {
			six.setGraphic(null);
		}
		if(bet[7]==0) {
			seven.setGraphic(null);
		}
		if(bet[8]==0) {
			eight.setGraphic(null);
		}
		if(bet[9]==0) {
			nine.setGraphic(null);
		}
		if(bet[10]==0) {
			ten.setGraphic(null);
		}
		if(bet[11]==0) {
			eleven.setGraphic(null);
		}
		if(bet[12]==0) {
			twelve.setGraphic(null);
		}
		if(bet[13]==0) {
			thirteen.setGraphic(null);
		}
		if(bet[14]==0) {
			fourteen.setGraphic(null);
		}
		if(bet[15]==0) {
			fifteen.setGraphic(null);
		}
		if(bet[16]==0) {
			sixteen.setGraphic(null);
		}
		if(bet[17]==0) {
			seventeen.setGraphic(null);
		}
		if(bet[18]==0) {
			eighteen.setGraphic(null);
		}
		if(bet[19]==0) {
			nineteen.setGraphic(null);
		}
		if(bet[20]==0) {
			twenty.setGraphic(null);
		}
		if(bet[21]==0) {
			twentyOne.setGraphic(null);
		}
		if(bet[22]==0) {
			twentyTwo.setGraphic(null);
		}
		if(bet[23]==0) {
			twentyThree.setGraphic(null);
		}
		if(bet[24]==0) {
			twentyFour.setGraphic(null);
		}
		if(bet[25]==0) {
			twentyFive.setGraphic(null);
		}
		if(bet[26]==0) {
			twentySix.setGraphic(null);
		}
		if(bet[27]==0) {
			twentySeven.setGraphic(null);
		}
		if(bet[28]==0) {
			twentyEight.setGraphic(null);
		}
		if(bet[29]==0) {
			twentyNine.setGraphic(null);
		}
		if(bet[30]==0) {
			thirty.setGraphic(null);
		}
		if(bet[31]==0) {
			thirtyOne.setGraphic(null);
		}
		if(bet[32]==0) {
			thirtyTwo.setGraphic(null);
		}
		if(bet[33]==0) {
			thirtyThree.setGraphic(null);
		}
		if(bet[34]==0) {
			thirtyFour.setGraphic(null);
		}
		if(bet[35]==0) {
			thirtyFive.setGraphic(null);
		}
		if(bet[36]==0) {
			thirtySix.setGraphic(null);
		}
		
		//The following are conditions of bet won or bet lost
		if(column1!=0) {
			if(roll == 3 || roll == 6 || roll == 9 || roll == 12 || roll == 15 || roll == 18 || roll == 21 || roll == 24 || roll == 27 || roll == 30 || roll == 33 || roll == 36) {
				column1*=2;
				betWon(column1);
				column1 = 0;
				column1s.setGraphic(null);
			}else {
				betLost(column1);
				column1 = 0;
				column1s.setGraphic(null);
			}
		}
		
		if(column2!=0) {
			if(roll == 2 || roll == 5 || roll == 8 || roll == 11 || roll == 14 || roll == 17 || roll == 20 || roll == 23 || roll == 26 || roll == 29 || roll == 32 || roll == 35) {
				column2*=2;
				betWon(column2);
				column2 = 0;
				column2s.setGraphic(null);
			}else {
				betLost(column2);
				column2 = 0;
				column2s.setGraphic(null);
			}
		}
		
		if(column3!=0) {
			if(roll == 1 || roll == 4 || roll == 7 || roll == 10 || roll == 13 || roll == 16 || roll == 19 || roll == 22 || roll == 25 || roll == 28 || roll == 31 || roll == 34) {
				column3*=2;
				betWon(column3);
				column3 = 0;
				column3s.setGraphic(null);
			}else {
				betLost(column3);
				column3 = 0;
				column3s.setGraphic(null);
			}
		}
		
		if(first!=0) {
			if(roll == 1 || roll == 2 || roll == 3 || roll == 4 || roll == 5 || roll == 6 || roll == 7 || roll == 8 || roll == 9 || roll == 10 || roll == 11 || roll == 12) {
				first*=2;
				betWon(first);
				first = 0;
				first1.setGraphic(null);
			}else {
				betLost(first);
				first = 0;
				first1.setGraphic(null);
			}
		}
		
		if(second!=0) {
			if(roll == 13 || roll == 14 || roll == 15 || roll == 16 || roll == 17 || roll == 18 || roll == 19 || roll == 20 || roll == 21 || roll == 22 || roll == 23 || roll == 24) {
				second*=2;
				betWon(second);
				second = 0;
				second1.setGraphic(null);
			}else {
				betLost(second);
				second = 0;
				second1.setGraphic(null);
			}
		}
		
		if(third!=0) {
			if(roll == 25 || roll == 26 || roll == 27 || roll == 28 || roll == 29 || roll == 30 || roll == 31 || roll == 32 || roll == 33 || roll == 34 || roll == 35 || roll == 36) {
				third*=2;
				betWon(third);
				third = 0;
				third1.setGraphic(null);
			}else {
				betLost(third);
				third = 0;
				third1.setGraphic(null);
			}
		}
		
		if(firstHalf!=0) {
			if(roll == 1 || roll == 2 || roll == 3 || roll == 4 || roll == 5 || roll == 6 || roll == 7 || roll == 8 || roll == 9 || roll == 10 || roll == 11 || roll == 12 || roll == 13 || roll == 14 || roll == 15 || roll == 16 || roll == 17 || roll == 18) {
				betWon(firstHalf);
				firstHalf = 0;
				firstHalf1.setGraphic(null);
			}else {
				betLost(firstHalf);
				firstHalf = 0;
				firstHalf1.setGraphic(null);
			}
		}
		
		if(secondHalf!=0) {
			if(roll == 19 || roll == 20 || roll == 21 || roll == 22 || roll == 23 || roll == 24 || roll == 25 || roll == 26 || roll == 27 || roll == 28 || roll == 29 || roll == 30 || roll == 31 || roll == 32 || roll == 33 || roll == 34 || roll == 35 || roll == 36) {
				betWon(secondHalf);
				secondHalf = 0;
				secondHalf1.setGraphic(null);
			}else {
				betLost(secondHalf);
				secondHalf = 0;
				secondHalf1.setGraphic(null);
			}
		}
		
		if(even!=0) {
			if(roll%2==0) {
				betWon(even);
				even = 0;
				even1.setGraphic(null);
			}else {
				betLost(even);
				even = 0;
				even1.setGraphic(null);
			}
		}
		
		if(odd!=0) {
			if(roll%2!=0) {
				betWon(odd);
				odd = 0;
				odd1.setGraphic(null);
			}else {
				betLost(odd);
				odd = 0;
				odd1.setGraphic(null);
			}
		}
		
		if(black!=0) {
			if(roll == 2 || roll == 4 || roll == 6 || roll == 8 || roll == 10 || roll == 11 || roll == 13 || roll == 15 || roll == 17 || roll == 20 || roll == 22 || roll == 24 || roll == 26 || roll == 28 || roll == 29 || roll == 31 || roll == 33 || roll == 35) {
				betWon(black);
				black = 0;
				black1.setGraphic(null);
			}else {
				betLost(black);
				black = 0;
				black1.setGraphic(null);
			}
		}
		
		if(red!=0) {
			if(roll == 1 || roll == 3 || roll == 5 || roll == 7 || roll == 9 || roll == 12 || roll == 14 || roll == 16 || roll == 18 || roll == 19 || roll == 21 || roll == 23 || roll == 25 || roll == 27 || roll == 30 || roll == 32 || roll == 34 || roll == 36) {
				betWon(red);
				red = 0;
				red1.setGraphic(null);
			}else {
				betLost(red);
				red = 0;
				red1.setGraphic(null);
			}
		}
		 profit = totalCash - prevCash;
		 total.setText("Total: $"+Integer.toString(totalCash));
		 //To open the popup window(wheel)
		  Stage primaryStage = new Stage();
		  Parent root1 = FXMLLoader.load(getClass().getResource("/application/PopUp.fxml")); 
		  Scene scene = new Scene(root1);
		  scene.getStylesheets().add(getClass().getResource("roulette.css").toExternalForm());
		  primaryStage.setX(400);
		  primaryStage.setY(175);
		  primaryStage.setTitle("wheel");
		  primaryStage.setScene(scene); 
		  primaryStage.show();
		  PauseTransition delay = new PauseTransition(Duration.seconds(12));
		  delay.setOnFinished( event -> primaryStage.close() );
		  delay.play();
		  spin.setDisable(true);
		}

	//Things to be done as soon as the game starts
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		total.setText("total: $"+String.valueOf(totalCash));
		spin.setDisable(true);
	}

		
}
