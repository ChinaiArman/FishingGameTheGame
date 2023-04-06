module com.example.fishinggamethegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.fishinggamethegame to javafx.fxml;
    exports com.example.fishinggamethegame;
    exports Test;
    opens Test to javafx.fxml;
}