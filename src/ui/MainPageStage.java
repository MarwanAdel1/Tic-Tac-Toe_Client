
package ui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.fxml.MainPageFXML;

public class MainPageStage extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Parent root = new MainPageFXML();
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}