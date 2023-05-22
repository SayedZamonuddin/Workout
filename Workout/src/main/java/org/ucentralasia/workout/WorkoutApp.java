package org.ucentralasia.workout;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WorkoutApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/org/ucentralasia/workout/WorkoutApp.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("/org/ucentralasia/workout/Styles.css").toExternalForm());

            primaryStage.setTitle("Sayed Workout Tracker");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

