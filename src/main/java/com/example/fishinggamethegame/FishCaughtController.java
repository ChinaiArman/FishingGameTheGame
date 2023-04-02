package com.example.fishinggamethegame;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A FishCaughtController.
 * @author Arman Chinai & Colin Doig
 * @version 06042023
 */
public class FishCaughtController {

    @FXML
    private Button placeholder;

    /**
     * Set the Scene to the LakeController.
     * @throws IOException if Files or Resources that are attempted to be called cannot be found
     */
    @FXML
    void fishAgain() throws IOException {
        Stage stage = (Stage) placeholder.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("LakeController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Lake)");
        stage.setScene(scene);
    }
}
