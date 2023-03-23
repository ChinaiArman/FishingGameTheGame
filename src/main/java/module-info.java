module com.example.fishinggamethegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fishinggamethegame to javafx.fxml;
    exports com.example.fishinggamethegame;
}