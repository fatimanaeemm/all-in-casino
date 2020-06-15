# all-in-casino
CS - 9B

Ajwad Masood    --   321564
Fatima Naeem    --   294576
Maryam Farooq   --   299778

How to Run:
     Additional JAR files needed to run this program are:
          1. javafx.controls.jar
          2. javafx.fxml.jar
          3. javafx.graphics.jar
          4. javafx.base.jar
     In addition to the .JAVA files their respective FXMl files are also required. After opening the .JAVA and FXML files in a java IDE, like eclipse or netBeans, a login window will appear. Enter a username and password to create a new account or login to an exisiting account. While creating a new account it is required to enter some initial cash. After logging in, the main menu will appear which will have a list of all the games and a logout button which will take you back to the login window.

Files Included With This Project:
     application.css                                 Baccarat.java                                       BlackjackGUI.fxml                         BlackjackGUIController.java                
     BlackjackGUIDealScene.fxml                      BlackjackGUIDealSceneController.java                BlackjackRulesScene.fxml                  BlackjackRulesSceneController.java
     Dealer.java                                     DisplayPayTable.fxml                                DisplayPayTableController.java            DisplayRules.fxml
     DisplayRulesController.java                     Keno.java                                           Login.java                                Main.java
     One.fxml                                        OneController.java                                  Player.java                               PopUp.fxml
     PopUpController.java                            roulette.css                                        Roulettefxml.fxml                         RoulettefxmlController.java
     SlotsGUIScene2.fxml                             SlotsGUIScene2Controller.java                       

Design Decisions:
     We have made Dealer class the parent of all the game classes since all games have a dealer and because a lot of the methods in Dealer class are being used in the games. Similarly, the Dealer class extends the Player class since all players play against a Dealer. The Login class contains the variable totalCash which is used in all of the game classes and the Player class, which is a subclass of the Login class, to keep track of the player's current cash. Any additional windows that need to be opened in a game extend that specific game, for example the place bet window in Blackjack extnds the BlackjackController class.

Project Issues:
     Most of the errors we encountered while working on the project were run-time errors, some of them occuring due to logical mistakes, for example comparing the value of a variable with a number when the variable hasn't been assigned a numerical value yet or not adding a backslash while specifying the source of an image. Some of the problems we faced while designing the GUI of the games were not linking an ActionEvent method with any button or using the sleep method when we wanted to display a label after a small delay while the program kept running (which stopped the whole game instead of only delaying the label) instead of the pause transition method. Issues faced during file handling while maing the login class include not closing the file after writing data in the file. As a result, none of the data would get stored. 
