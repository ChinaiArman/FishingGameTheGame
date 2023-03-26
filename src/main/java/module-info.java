module com.example.fishinggamethegame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fishinggamethegame to javafx.fxml;
    exports com.example.fishinggamethegame;
    exports com.example.fishinggamethegame.classes;
    opens com.example.fishinggamethegame.classes to javafx.fxml;
}