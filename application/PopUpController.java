package application;
//Ajwad Masood
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;

public class PopUpController extends RoulettefxmlController implements Initializable{
	@FXML
	private Button but1;
	@FXML
	private Button spin;
	@FXML
	private Label winningsLabel;
	String text;
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		}catch(Exception e) {}
	}
	Image image2 = new Image(getClass().getResourceAsStream("/images/blankwheel.png"));
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		RotateTransition rotation = new RotateTransition(Duration.seconds(9), but1);
		rotation.setByAngle(3600);
		rotation.play();
		ImageView imageView2 = new ImageView(image2);
		imageView2.setFitHeight(247);
		imageView2.setFitWidth(247);
		but1.setGraphic(imageView2);
		but1.setContentDisplay(ContentDisplay.CENTER);
		//System.out.println(profit);
		if(profit>=0) {
			text = "You won "+Integer.toString(profit)+"!";
			//winningsLabel.setText(text);
			winningsLabel.setStyle("-fx-text-fill:gold;");
		}else {
			text = "You lost "+Integer.toString(profit)+"...";
			//winningsLabel.setText(text);
			winningsLabel.setStyle("-fx-text-fill:#CC0000;");
		}
		
		//System.out.println(text);
		PauseTransition delay = new PauseTransition(Duration.seconds(9));
		delay.setOnFinished( event -> winningsLabel.setText(text) );
		
		delay.play();
	}
	
	
	// Event Listener on Button[#second3].onAction
	@FXML
	public void spin2(ActionEvent event) {
		// TODO Autogenerated
		but1.setGraphic(null);
		
		if(super.roll==1) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (2).png"));
		}
		if(super.roll==2) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (3).png"));
		}
		if(super.roll==3) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (4).png"));
		}
		if(super.roll==4) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (5).png"));
		}
		if(super.roll==5) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (6).png"));
		}
		if(super.roll==6) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (7).png"));
		}
		if(super.roll==7) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (8).png"));
		}
		if(super.roll==8) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (9).png"));
		}
		if(super.roll==9) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (13).png"));
		}
		if(super.roll==10) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (14).png"));
		}
		if(super.roll==11) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (15).png"));
		}
		if(super.roll==12) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (16).png"));
		}
		if(super.roll==13) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (17).png"));
		}
		if(super.roll==14) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (18).png"));
		}
		if(super.roll==15) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (19).png"));
		}
		if(super.roll==16) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (20).png"));
		}
		if(super.roll==17) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (21).png"));
		}
		if(super.roll==18) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (22).png"));
		}
		if(super.roll==19) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (23).png"));
		}
		if(super.roll==20) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (24).png"));
		}
		if(super.roll==21) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (25).png"));
		}
		if(super.roll==22) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (26).png"));
		}
		if(super.roll==23) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (27).png"));
		}
		if(super.roll==24) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (28).png"));
		}
		if(super.roll==25) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (29).png"));
		}
		if(super.roll==26) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (30).png"));
		}
		if(super.roll==27) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (31).png"));
		}
		if(super.roll==28) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (32).png"));
		}
		if(super.roll==29) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (23).png"));
		}
		if(super.roll==30) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (34).png"));
		}
		if(super.roll==31) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (35).png"));
		}
		if(super.roll==32) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (36).png"));
		}
		if(super.roll==33) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (37).png"));
		}
		if(super.roll==34) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (38).png"));
		}
		if(super.roll==35) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (39).png"));
		}
		if(super.roll==35) {
			image2 = new Image(getClass().getResourceAsStream("/images/circle-cropped (40).png"));
		}
		ImageView imageView2 = new ImageView(image2);
		imageView2.setFitHeight(247);
		imageView2.setFitWidth(247);
		but1.setGraphic(imageView2);
		but1.setContentDisplay(ContentDisplay.CENTER);
		//sleep(6000);
		
		
	}
	

	
}