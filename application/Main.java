package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage window) throws Exception {
		
		
		//setting stage
        //Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		///window.setWidth(primScreenBounds.getWidth());
	    //window.setHeight(primScreenBounds.getHeight());
		window.setWidth(1500);
		window.setHeight(640);
		window.setX(-7);
		window.setY(10);
	    window.setTitle("All-In Casino");
	    window.show();
	    
	    //setting background pane and scene
		Pane background = new Pane();
		BackgroundImage myBI= new BackgroundImage(new Image(getClass().getResourceAsStream("/images/background.jpg")),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          //new BackgroundSize(primScreenBounds.getWidth(),primScreenBounds.getHeight(), false, false, false, true));
		        new BackgroundSize(1500,640, false, false, false, true));
		background.setBackground(new Background(myBI));
        Scene scene = new Scene(background);
        window.setScene(scene);
        
        //creating vertical box to hold contents i.e. title and games
        VBox contents=new VBox();
        contents.setTranslateX(670);
        contents.setTranslateY(40);
        contents.setSpacing(10);
        contents.setAlignment(Pos.CENTER);
        
        Label name=new Label("ALL-IN CASINO");
        name.setFont(Font.font("Cooper Black", FontWeight.BOLD, 50));
		name.setTextFill(Color.web("#C0C0C0"));
        contents.getChildren().add(name);
        background.getChildren().add(contents);
        
        //creating all options
        Button backToLogin=new Button("Logout");
        setButton(backToLogin);
        backToLogin.setOnAction(e->{
			try {
				(new Player()).playSound("buttonClicked", false);
				new Login().start(window);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        
        Button roulette=new Button("Roulette");
        setButton(roulette);
        roulette.setOnAction(e->{
			try {
				(new Player()).playSound("buttonClicked", false);
				Stage primaryStage = new Stage();
		        Parent root = FXMLLoader.load(getClass().getResource("/application/Roulettefxml.fxml"));
		    	Scene scenecraps = new Scene(root,1500,600);
		    	primaryStage.setScene(scenecraps);
		    	primaryStage.show();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        Button blackjack=new Button("Blackjack");
        setButton(blackjack);
        blackjack.setOnAction(e->{
			try {
				(new Player()).playSound("buttonClicked", false);
				Stage primaryStage = new Stage();
		        Parent root = FXMLLoader.load(getClass().getResource("/application/BlackjackGUIDealScene.fxml"));
		    	Scene scenecraps = new Scene(root,1500,600);
		    	//primaryStageCraps.setScene(scenecraps);
		    	//primaryStageCraps.show();
		    	primaryStage.setScene(scenecraps);
		    	primaryStage.show();
			} catch (Exception e1) {
				// TODO Auto-generated catch block //you sent this
				e1.printStackTrace();
			}
		});
        Button baccarat=new Button("Baccarat");
        setButton(baccarat);
        baccarat.setOnAction(e->{
			try {
				(new Player()).playSound("buttonClicked", false);
				new Baccarat().start(window);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        Button slots=new Button("Slots");
        setButton(slots);
        slots.setOnAction(e->{
			try {
				(new Player()).playSound("buttonClicked", false);
				Stage primaryStage = new Stage();
		        Parent root = FXMLLoader.load(getClass().getResource("/application/SlotsGUIScene2.fxml"));
		    	Scene scenecraps = new Scene(root,1500,600);
		    	primaryStage.setScene(scenecraps);
		    	primaryStage.show();
			} catch (Exception e1) { 
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        Button craps=new Button("Craps");
        setButton(craps);
        craps.setOnAction(e->{
			try {
				(new Player()).playSound("buttonClicked", false);
		        Stage primaryStage = new Stage();
		        Parent root = FXMLLoader.load(getClass().getResource("/application/One.fxml"));
		    	Scene scenecraps = new Scene(root,1500,600);
		    	primaryStage.setScene(scenecraps);
		    	primaryStage.show();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        Button keno=new Button("Keno");
        setButton(keno);
        keno.setOnAction(e->{
			try {
				(new Player()).playSound("buttonClicked", false);
				new Keno().start(window);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        contents.getChildren().addAll(backToLogin,roulette,blackjack,baccarat,slots,craps,keno);
        
		
	}
	
	//sets button size and background
	private void setButton(Button button)
	{
		button.setPrefHeight(50);
		button.setPrefWidth(200);
		button.setFont(Font.font("Cooper Black", FontWeight.BOLD, 20));
		BackgroundImage buttonImage = new BackgroundImage( new Image(getClass().getResourceAsStream("/images/label.jpg")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(button.getWidth(),button.getHeight(), false, false, true, true));
		button.setBackground(new Background(buttonImage));
	}
	
	/*public void craps(ActionEvent event) throws Exception{
		Stage primaryStageCraps = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/application/One.fxml"));
    	Scene scenecraps = new Scene(root,1500,600);
    	scenecraps.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
    	primaryStageCraps.setScene(scenecraps);
    	primaryStageCraps.show();
	}*/
	

	public static void main(String[] args) {

		Application.launch(args);
	}
	

}
