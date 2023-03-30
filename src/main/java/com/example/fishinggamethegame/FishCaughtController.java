package com.example.fishinggamethegame;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class FishCaughtController {

    @FXML
    private Button placeholder;

    @FXML
    void fishAgain() throws IOException {
        Stage stage = (Stage) placeholder.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("LakeController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Lake)");
        stage.setScene(scene);
    }
}
