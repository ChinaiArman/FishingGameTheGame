package com.example.fishinggamethegame;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A FishCaughtController.
 * @author Arman Chinai & Colin Doig
 * @version 06042023
 */
public class FishCaughtController {

    @FXML
    private ImageView exit;

    @FXML
    private ImageView fishCaughtBackground;

    @FXML
    private Text fishCaughtText;

    @FXML
    private ImageView fishFailedBackground;

    @FXML
    private Text fishFailedText;

    @FXML
    public void initialize() {
        if (Player.getCurrentScore() > Player.getCatchThreshold()) {
            fishCaughtBackground.setVisible(true);
            fishCaughtText.setVisible(true);
        } else {
            fishFailedBackground.setVisible(true);
            fishFailedText.setVisible(true);
        }
    }

    /**
     * Set the Scene to the LakeController.
     * @throws IOException if Files or Resources that are attempted to be called cannot be found
     */
    @FXML
    void exitMenu() throws IOException {
        Stage stage = (Stage) exit.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(Player.getLastStage()));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (" + Player.getLastStage().replace("Controller.fxml", "") + ")");
        stage.setScene(scene);
    }

    @FXML
    void hoverExit() {
        exit.setFitWidth(300);
    }

    @FXML
    void stopExitHover() {
        exit.setFitWidth(275);
    }
}
