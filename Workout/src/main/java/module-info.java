module org.ucentralasia.workout {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.ucentralasia.workout to javafx.fxml;
    exports org.ucentralasia.workout;
}