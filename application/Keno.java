package application;
//Fatima Naeem
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.application.Application;
import javafx.collections.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class Keno extends Dealer {

	Stage window;
	Scene scene1, scene2, scene3;

	//int bet=1000;//hard coded bet, to be changed later
	private final int[] playerNumbers = new int[10];
	private final int[] randomNumbers = new int[22];
	private final List<Button> buttonList = new ArrayList<>();
	private final ObservableList<Integer> selectedList = FXCollections.observableArrayList();
	private final ObservableList<Integer> storeBet = FXCollections.observableArrayList();

	@Override
	public void start(Stage primaryStage){
			window=primaryStage;
		
			
			//								SETTING SCENE 1: INSTRUCTIONS AND PLAY GAME OPTION
			
			Pane pane=new Pane();
			pane.setBorder(new Border(new BorderStroke(Color.rgb(21, 59, 31), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(20))));
			pane.setStyle("-fx-background-color: #4d4c4c;");
			
			//setting scene 1 and stage
			scene1=new Scene(pane);
			window.setScene(scene1);
			Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
			window.setWidth(primScreenBounds.getWidth());
		    window.setHeight(primScreenBounds.getHeight());
			window.show();
			
			//creating label for title
			Label label=new Label("KENO");
			label.setTextFill(Color.web("#FFFFFF"));
			label.setFont(Font.font("Cooper Black", FontWeight.BOLD, 30));
			label.setTranslateX(650);
			label.setTranslateY(150);
			
			
			//creating textbox for instructions
			Text instruct=new Text(450,250,"\t\t\t\t\tWelcome to KENO.\nThe rules are simple.\nSelect 10 numbers between 1 and 80.\nWe will randomly generate 22 numbers, and for every match you win 10% of your bet!\nIf you get ten matches, your money is doubled!\nIf you get no match, you lose all your money.\n\t\t\t\t\tYou may now begin.");
			instruct.setFont(Font.font("Arial", 16));
			instruct.setFill(Color.WHITE);
			
			//requesting bet
			Label placeBet=new Label("Place a bet greater than $100");
			placeBet.setTranslateX(550);
			placeBet.setTranslateY(380);
			placeBet.setTextFill(Color.web("#FFFFFF"));
			placeBet.setFont(Font.font("Arial", FontWeight.BOLD,20));
			
			TextField textBox=new TextField();
			textBox.setTranslateX(620);
			textBox.setTranslateY(420);
			
			
			//adding play game button
			Button play=new Button("Play Game");
			play.setPrefSize(100, 30);
			play.setLayoutX(650);
			play.setLayoutY(470);
			play.setTextFill(Color.web("#FFFFFF"));
			play.setStyle("-fx-background-color: #008080;");
			play.setDisable(true);
			
			
			//placing bet
			textBox.setOnAction(event->{
				storeBet.add(Integer.parseInt(textBox.getText()));
				if(storeBet.get(0)>=100)
					play.setDisable(false);
				else
					storeBet.remove(0);
			});
			
			//setting pane
			pane.getChildren().addAll(label,instruct,placeBet,textBox,play);
	
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
				});
			
			//			SETTING SCENE 2 AFTER CLICKING PLAY GAME: PICK 10 NUMBERS
			

			 TilePane tile = new TilePane();
			  tile.setVgap(5);
			  tile.setHgap(5);
			  tile.setPrefColumns(10);
			  tile.setPrefTileWidth(120);
			  tile.setPrefHeight(10);
			  tile.setStyle("-fx-background-color: #4d4c4c;");
			  tile.setBorder(new Border(new BorderStroke(Color.rgb(21, 59, 31), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(10))));
			  
			  //Adding numbers to choose from
			 
			  Button b;
			    for(int i=1; i<=80; i++) {
			        b = new Button(""+i);
			        b.setPrefSize(35,35);
			        //customizing buttons
			        tile.setMargin(b, new Insets(30, 0, 0, 30));
			        if(i<=25)
			        b.setStyle("-fx-base: rgb("+(10*i)+","+(20*i)+","+(10*i)+");");
			        if(i>=25&&i<=50)
			        	b.setStyle("-fx-base: rgb("+(10*(i-25))+","+(20*(i-25))+","+(10*(i-25))+");");
			        if(i>50&&i<=75)
			        	b.setStyle("-fx-base: rgb("+(10*(i-50))+","+(20*(i-50))+","+(10*(i-50))+");");
			        if(i>75)
			        	b.setStyle("-fx-base: rgb("+(10*(i-75))+","+(20*(i-75))+","+(10*(i-75))+");");
			        tile.getChildren().add(b);
			        buttonList.add(b);
			    }

			  
		    	//Button when numbers are selected, proceed to scene 3  
			    Button done=new Button("Done!");
			    done.setPrefSize(60,40);
			    done.setTranslateX(100);
				done.setTranslateY(90);
				done.setTextFill(Color.web("#FFFFFF"));
				done.setStyle("-fx-background-color: #008080;");
			    tile.getChildren().add(done);
			    done.setDisable(true);
			   	done.setOnAction(e->{
					try {
						(new Player()).playSound("buttonClicked", false);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
			   		window.setScene(scene3);
			   		});			    
				   
				   // Allowing user to pick 10 numbers 
			     EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
			            public void handle(ActionEvent e)
			            {
							try {
								(new Player()).playSound("buttonClicked", false);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
			            	
			            	if(selectedList.size()<10)
			            	{
			            		selectedList.add(Integer.parseInt(((Button)e.getSource()).getText()));
			            		((Button)e.getSource()).setStyle("-fx-base: #cded15;");
			            	}
			            	else
			            		{
			            		buttonList.forEach(button -> button.setDisable(true));
			            	}
			            	if(selectedList.size()==10)
			            	{
			            		done.setDisable(false);
			            		buttonList.forEach(button->button.setDisable(true));
			            	}
			            }
			        };
			   	
			    buttonList.forEach(button -> button.setOnAction(event5));

				   	
				   	//Adding scene instructions
				   	Text t2=new Text("Pick ten numbers!\n");
				   	t2.setTranslateX(-300);
				   	t2.setTranslateY(100);
				   	t2.setFont(Font.font("Arial", FontWeight.BOLD, 25));
				   	t2.setFill(Color.WHITE);
				   	tile.getChildren().add(t2);
				
					  //setting scene 2
					  scene2=new Scene(tile);
			  
			
                //			    SETTING SCENE 3: AFTER CLICKING DONE: GENERATING RANDOM NUMBERS AND GIVING RESULT
			    
			    Pane box=new Pane();
			   	box.setStyle("-fx-background-color: #4d4c4c;");
			    box.setBorder(new Border(new BorderStroke(Color.rgb(21, 59, 31), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(20))));
				
				//creating button to generate numbers
				Button gen= new Button("Click here to generate numbers.");
				gen.setPrefSize(200, 40);
				gen.setLayoutX(520);
				gen.setLayoutY(50);
				gen.setTextFill(Color.web("#FFFFFF"));
				gen.setStyle("-fx-background-color: #008080;");
				box.getChildren().add(gen);
				
				
				//generating numbers
				 EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() { 
			            public void handle(ActionEvent e2) 
			            {    
							try {
								(new Player()).playSound("buttonClicked", false);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							
			            	gen.setDisable(true);
			            	//generating random numbers
			            	for (int j=0;j<22;j++)
			            		randomNumbers[j]=(int)(Math.random()*80)+1;
			            	
			            	
			            	//giving heading
			            	Text head=new Text("The generated numbers are: ");
			            	head.setTranslateX(100);
			            	head.setTranslateY(150);
			            	head.setFont(Font.font("Courier New",FontWeight.BOLD,20));
			            	head.setFill(Color.WHITE);
			            	box.getChildren().add(head);
			            	
			            	//displaying the numbbers
			                for (int i=0;i<22;i++)
			                {
			            	Text randNums= new Text(""+randomNumbers[i]);
			            	randNums.setFill(Color.WHITE);
			            	randNums.setFont(Font.font(20));
			            	randNums.setTranslateX(100+i*50);
			            	randNums.setTranslateY(200);
			            	box.getChildren().add(randNums);
			                }
			                
			                //button to view results
			            	Button res= new Button("Click here to view results.");
			        		res.setPrefSize(200, 40);
			        		res.setLayoutX(520);
			        		res.setLayoutY(300);
			        		res.setTextFill(Color.web("#FFFFFF"));
			    			res.setStyle("-fx-background-color: #008080;");
			        		box.getChildren().add(res);
			        		
			        		//comparing player's numbers with generated numbers
			        		int c=0, bet=storeBet.get(0);
			        		
			        		for(int i = 0; i < selectedList.size(); i++) 
			        			{
			        			playerNumbers[i] = selectedList.get(i);
			        			}
			        		for(int i=0;i<10;i++)
			        		{
			        			for (int j=0;j<22;j++)
			        			{
			        				if (playerNumbers[i]==randomNumbers[j])
			        					c++;
			        			}
			        		}
			        		
			        		//displaying results
			        		final int count=c;
			        		 EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() { 
			 		            public void handle(ActionEvent e3) 
			 		            {    
									try {
										(new Player()).playSound("buttonClicked", false);
									} catch (Exception e1) {
										e1.printStackTrace();
									}
									
			 		            	res.setDisable(true);
			 		           	//printing number of matches
			 		        		Text match=new Text("You matched "+count+" times");
			 		        		  match.setFill(Color.WHITE);
			 						  match.setTranslateX(400);
			 						  match.setTranslateY(400);
			 						  match.setFont(Font.font("Arial", 20));
			 						  box.getChildren().add(match);
			 						  
			 		            //if player has won
			 		           	if (count>0)
			 		           	{
			 		           		final int amountWon=(int)(bet+(0.1*bet*count));
			 		         	  Text t=new Text("Congratulations!\nYou win $"+amountWon);
			 					  t.setTranslateX(400);
			 					  t.setTranslateY(450);
			 					  t.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			 					  t.setFill(Color.LIGHTGREEN);
			 					  box.getChildren().add(t);
			 						//add update amount
				 		           	Player access=new Player();
				 		           	access.updateCash(amountWon);
			 		           	}
			 		           	//if player has lost
			 		           	else
			 		           	{
			 		           		final int amountWon=-bet;
			 		           		Text t=new Text("You lost.");
			 		           		t.setTranslateX(400);
			 		           		t.setTranslateY(450);
			 		           		t.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			 		           		t.setFill(Color.rgb(255, 51, 51));
			 		           		box.getChildren().add(t);
			 		           	//add update amount
				 		           	Player access=new Player();
				 		           	access.updateCash(amountWon);
			 		           	}
			 		           	
			 		           	
			 		           	//proceed to main menu button
			 		           Button mainMenu= new Button("Proceed to Main Menu");
			 		           mainMenu.setPrefSize(200, 40);
			 		           mainMenu.setLayoutX(520);
			 		           mainMenu.setLayoutY(550);
			 		           mainMenu.setTextFill(Color.web("#FFFFFF"));
			 		           mainMenu.setStyle("-fx-background-color: #008080;");
			 		           box.getChildren().add(mainMenu);
			 		           mainMenu.setOnAction(e->{
									try {
										(new Player()).playSound("buttonClicked", false);
									} catch (Exception e1) {
										e1.printStackTrace();
									}
									
			 		 			try {
			 		 				editFile();
			 		 				new Main().start(window);
			 		 			} catch (Exception e1) {
			 		 				// TODO Auto-generated catch block
			 		 				e1.printStackTrace();
			 		 			}
			 		 		});
			 		           } 
			 		        }; 
			 			res.setOnAction(event3);
			            } 
			        }; 
			        gen.setOnAction(event2);
				
				scene3=new Scene(box);
		
			
	}

	public static void main(String[] args) {

		Application.launch(args);
	}
}
