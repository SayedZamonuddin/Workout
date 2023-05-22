package org.ucentralasia.workout;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;


public class WorkoutController {
    @FXML
    private ComboBox<String> dayComboBox;
    @FXML
    private TextField pushUpsField, pullUpsField, chinUpsField, squatsField;
    @FXML
    private ListView<Workout> workoutListView;

    private ObservableList<Workout> workoutList;

    public void initialize() {
        workoutList = FXCollections.observableArrayList();
        dayComboBox.setItems(FXCollections.observableArrayList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
        workoutListView.setItems(workoutList);
    }

    @FXML
    public void addWorkout() {
        if (dayComboBox.getValue() == null || pushUpsField.getText().isEmpty() || pullUpsField.getText().isEmpty() ||
                chinUpsField.getText().isEmpty() || squatsField.getText().isEmpty()) {
            showErrorDialog("All fields must be filled in.");
        } else {
            try {
                int pushups = Integer.parseInt(pushUpsField.getText());
                int pullups = Integer.parseInt(pullUpsField.getText());
                int chinups = Integer.parseInt(chinUpsField.getText());
                int squats = Integer.parseInt(squatsField.getText());

                if (pushups < 0 || pullups < 0 || chinups < 0 || squats < 0) {
                    showErrorDialog("Number of repetitions cannot be negative.");
                } else {
                    Workout workout = new Workout(dayComboBox.getValue(), pushups, pullups, chinups, squats);
                    workoutList.add(workout);
                    // Removed the line that adds the workout to workoutListView
                    clearFields();
                }
            } catch (NumberFormatException e) {
                showErrorDialog("Repetitions must be an integer.");
            }
        }
    }


    private void showErrorDialog(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }


    @FXML
    public void deleteWorkout() {
        Workout selectedWorkout = workoutListView.getSelectionModel().getSelectedItem();
        workoutList.remove(selectedWorkout);
    }

    @FXML
    public void showWorkout() {
        Workout selectedWorkout = workoutListView.getSelectionModel().getSelectedItem();
        if (selectedWorkout != null) {
            dayComboBox.setValue(selectedWorkout.getDay());
            pushUpsField.setText(String.valueOf(selectedWorkout.getPushUps()));
            pullUpsField.setText(String.valueOf(selectedWorkout.getPullUps()));
            chinUpsField.setText(String.valueOf(selectedWorkout.getChinUps()));
            squatsField.setText(String.valueOf(selectedWorkout.getSquats()));
        }
    }

    private void clearFields() {
        dayComboBox.setValue(null);
        pushUpsField.clear();
        pullUpsField.clear();
        chinUpsField.clear();
        squatsField.clear();
    }
}
