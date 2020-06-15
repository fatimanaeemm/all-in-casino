package application;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.Initializable; 
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class Login extends Application implements Initializable{
	//username field, password field, cash field, PrintWriter,FileWriter, File, BufferedReader are created.
	Stage window;
	public static int totalCash;
	Button loginButton = new Button("Login");
	TextField usernameText = new TextField();
	TextField cash = new TextField();
	PasswordField passText = new PasswordField();
	Label validPass = new Label();
	Boolean loginSuccess = false;
	Boolean userPresent = false;
	String[] lineSplit;
	Glow glow = new Glow(0.75);
	static String enteredUsername;
	String enteredPassword;
	String enteredCash;
	String password;
	String cash2;
	PrintWriter pw;
	FileWriter fw;
	static File file= new File("text.dat");
	BufferedReader br = null;

	@Override
	public void start(Stage window2) throws Exception {
		window = window2;
		
		window2.setWidth(1500);
		window2.setHeight(640);
		window2.setX(-7);
		window2.setY(10);
	    window2.setTitle("All-In Casino");
	    window2.show();
	    
	    loginButton.setPrefHeight(65);
	    loginButton.setPrefWidth(287);
	    loginButton.setTranslateX(-200);
	    loginButton.setTranslateY(375);
	    loginButton.setFont(Font.font("System", FontWeight.BOLD, 18));

	    usernameText.setTranslateX(-200);
	    usernameText.setTranslateY(50);
	    usernameText.setFont(Font.font("System", FontWeight.BOLD, 18));
	    usernameText.setPrefHeight(58);
	    usernameText.setPrefWidth(427);
	    usernameText. setPromptText("Enter Username");
	    
	    passText.setTranslateX(-200);
	    passText.setTranslateY(70);
	    passText.setFont(Font.font("System", FontWeight.BOLD, 18));
	    passText.setPrefHeight(58);
	    passText.setPrefWidth(427);
	    passText.setPromptText("Enter Password");
	    
	    cash.setTranslateX(-200);
	    cash.setTranslateY(40);
	    cash.setFont(Font.font("System", FontWeight.BOLD, 18));
	    cash.setPrefHeight(58);
	    cash.setPrefWidth(427);
	    cash.setPromptText("Enter Cash");
	    
	    validPass.setTranslateX(-156);
	    validPass.setTranslateY(-33);
	    validPass.setFont(Font.font("System", FontWeight.BOLD, 18));
	    validPass.setPrefHeight(38);
	    validPass.setPrefWidth(267);
	    validPass.setStyle("-fx-text-fill: red;");
	    
	    loginButton.setOnAction(e -> {
	    	try {
				makeFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    });
	    
	    
	    
	    Pane background = new Pane();
		BackgroundImage myBI = new BackgroundImage(new Image(getClass().getResourceAsStream("/images/blackBg2.png")),
		BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
		new BackgroundSize(1500,640, false, false, false, true));
		background.setBackground(new Background(myBI));
		Scene loginScene = new Scene(background);
		window.setScene(loginScene);
		VBox contents = new VBox();
		contents.setTranslateX(670);
        contents.setTranslateY(40);
        contents.setSpacing(10);
        contents.setAlignment(Pos.CENTER);
		contents.getChildren().addAll(loginButton, usernameText, passText, validPass,cash);
		background.getChildren().add(contents);
		
		
	}
	
	//makeFile method decides whether the login is successful or not
	public void makeFile() throws FileNotFoundException, IOException{
		enteredUsername = usernameText.getText();
		enteredPassword = passText.getText();
		enteredCash = cash.getText();
		password = null;
		cash2 = null;
		
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			fw = new FileWriter(file,true);
			pw = new PrintWriter(fw);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		editFile2();
		
		try {
			br = new BufferedReader(new FileReader("text.dat"));
			String line;
			if (file.length() != 0) {
				while((line = br.readLine()) != null) {
					
					String[] lineSplit = line.split(" ");
					cash2 = lineSplit[2];
					
					if (enteredUsername.compareTo(lineSplit[0]) == 0) {
						password = lineSplit[1];
						userPresent = true;
						break;
					}
				}
				
				
				if (userPresent) {
					while (!loginSuccess) {
						if (enteredPassword.compareTo(password) == 0) {
							loginSuccess = true;
							totalCash = Integer.parseInt(cash2);
							try {
		 		 				new Main().start(window);
		 		 			} catch (Exception e1) {
		 		 				e1.printStackTrace();
		 		 			}
							break;
						}
						else {
							validPass.setText("Invalid Password");
							break;
						}
						
					}
				}
				else { //if user does not exist
					if(enteredUsername.length() != 0 && enteredCash.length() != 0 && Integer.parseInt(enteredCash)>=0) {
						totalCash = Integer.parseInt(enteredCash);
						try {
	 		 				new Main().start(window);
	 		 			} catch (Exception e1) {
	 		 				e1.printStackTrace();
	 		 			}
						pw.println(enteredUsername + " " + enteredPassword + " " + enteredCash);
						pw.close();
						loginSuccess = true;
					}
					else {
						validPass.setText("Invalid Entry");
					}
				}
			}
			else { //if file is empty
				if(enteredUsername.length() != 0 && enteredPassword.length() != 0 && enteredCash.length() != 0 && Integer.parseInt(enteredCash)>=0) {
					totalCash = Integer.parseInt(enteredCash);
					try {
	 		 			new Main().start(window);
	 		 		} catch (Exception e1) {
	 		 			e1.printStackTrace();
	 		 		}
					pw.println(enteredUsername + " " + enteredPassword + " " + enteredCash);
					pw.close();
					loginSuccess = true;
				}
				else {
					validPass.setText("Invalid Entry");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	PrintWriter pw2;
	File file2= new File("newText.dat");
	PrintWriter pw3;
	File file3= new File("newTextt.dat");
	
	//copyFileUsingStream method copies one file into another
	private static void copyFileUsingStream(File source, File dest) throws IOException {
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	}
	
	//editFile allows us to edit a record by making another file, copying data into that, emptying the first file and then copying the data back into the original file
	public void editFile() throws FileNotFoundException, IOException{
		try {
			if(!file2.exists()) {
				file2.createNewFile();
			}
			FileWriter fw2 = new FileWriter(file2,true);
			pw2 = new PrintWriter(fw2);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		
		try {
			String filename = file.getName();
			br = new BufferedReader(new FileReader(filename));
			String line;
			if (file.length() != 0) {
				while((line = br.readLine()) != null) {
					String[] lineSplit = line.split(" ");
					
					if (enteredUsername.compareTo(lineSplit[0]) == 0) {
						if(totalCash>=0) {
							pw2.println(lineSplit[0] + " " + lineSplit[1] + " " + totalCash);
						}else {
							pw2.println(lineSplit[0] + " " + lineSplit[1] + " " + 0);
						}
					}else {
						pw2.println(lineSplit[0]+" "+lineSplit[1]+" "+lineSplit[2]);
					}
				}
			}
			pw2.close();
			pw2.flush();
			copyFileUsingStream(file2, file);
			file2.delete();
			file3.delete();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	//editFile2 allows us to add cash to an existing account
	public void editFile2() throws FileNotFoundException, IOException{
		try {
			if(!file3.exists()) {
				file3.createNewFile();
			}
			FileWriter fw3 = new FileWriter(file3,true);
			pw3 = new PrintWriter(fw3);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		
		try {
			String filename = file.getName();
			br = new BufferedReader(new FileReader(filename));
			String line;
			if (file.length() != 0) {
				while((line = br.readLine()) != null) {
					String[] lineSplit = line.split(" ");
					if (enteredUsername.compareTo(lineSplit[0]) == 0) {
						if(enteredCash.length()!=0) {
							if(Integer.parseInt(enteredCash)>=0) {
								pw3.println(lineSplit[0] + " " + lineSplit[1] + " " + String.valueOf(Integer.parseInt(lineSplit[2])+Integer.parseInt(enteredCash)));
							}else {
								validPass.setText("Invalid Entry");
							}
							}else {
							pw3.println(lineSplit[0]+" "+lineSplit[1]+" "+lineSplit[2]);
						}
					}else {
						pw3.println(lineSplit[0]+" "+lineSplit[1]+" "+lineSplit[2]);
					}
				}
			}
			pw3.close();
			pw3.flush();
			copyFileUsingStream(file3, file);
			file3.delete();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static void main(String args []) {
		Application.launch(args);
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loginButton.setOnMouseEntered(e -> loginButton.setEffect(glow));
		loginButton.setOnMouseExited(e -> loginButton.setEffect(null));
	}
}