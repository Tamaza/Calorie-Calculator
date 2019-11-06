package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Main extends Application {
    @FXML
    private FXMLLoader loader;
    @FXML private Parent welcomeParent;


    @Override
    public void start(Stage primaryStage) throws Exception{
        loader = new FXMLLoader(getClass().getResource( "Main.fxml"));
        try{
            welcomeParent = loader.load();
        } catch (IOException e){
            e.printStackTrace();
        }

        Scene scene = new Scene(welcomeParent);
       primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
       primaryStage.initStyle(StageStyle.UNDECORATED); //This line makes the program fullScreen without messing up popup windows.
       primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        System.exit(0);
    }
}