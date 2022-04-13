package mainPkg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GUI extends Application {

    // Had issues making scenes and fxml-loaders into instance variables, using local variables instead...

    private static Stage mainStage; // The main stage which we place all scenes on

    /**
     Takes the user to the "start screen", the first screen the user sees when starting the program.
     This is achieved through a scene change on the default stage.
     */

    public void goToStartScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("StartScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        mainStage.setTitle("startScreen");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     Takes the user to the "admin screen", this is the scene which is only intended for use of an administrator/employer at the cinema.
     */

    public void launchAdminScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("AdminScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        mainStage.setTitle("AdminScreen");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public void launchStaffScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("StaffScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        mainStage.setTitle("StaffScreen");
        mainStage.setScene(scene);
        mainStage.show();
    }
    
    public void launchAddStaffScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("AddStaffScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
    
        mainStage.setTitle("AddStaff");
        mainStage.setScene(scene);
        mainStage.show();
    }
    
    public void launchAddShiftScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("AddShiftScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        mainStage.setTitle("Shifts");
        mainStage.setScene(scene);
        mainStage.show();
    }
    
    public void launchMovieScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("AddMovies.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
    
        mainStage.setTitle("Movies");
        mainStage.setScene(scene);
        mainStage.show();
    }
    
    public void launchAllScreeningsScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("allMovieScreeningsScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        mainStage.setTitle("Screenings");
        mainStage.setScene(scene);
        mainStage.show();
    }
    
    public void launchCustomerScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("CustomerScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        mainStage.setTitle("Greetings");
        mainStage.setScene(scene);
        mainStage.show();
    }
    
    /**
     JavaFX default application start. We ignore the forced "primaryStage" and instead use an instance variable version of the basic FX-stage
     so that it is more easily accessible.
     */

    @Override
    public void start(Stage primaryStage) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(GUI.class.getResource("StartScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        mainStage = primaryStage;
        mainStage.setTitle("StartScreen");
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     The return of the old stupid MAIN method... I want to switch to Python :(
     */
    public static void main(String[] args) {
        launch(args);
    }
}
