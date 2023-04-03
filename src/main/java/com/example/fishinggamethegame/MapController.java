package com.example.fishinggamethegame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * A MapController.
 * @author Arman Chinai & Colin Doig
 * @version 06042023
 */
public class MapController {

    @FXML
    private ImageView lakeButton;

    @FXML
    private ImageView oceanButton;

    @FXML
    private ImageView shopButton;

    @FXML
    private ImageView closeButton;

    @FXML
    public void initialize() {
        if (Player.getOceanUnlocked()) {
            oceanButton.setVisible(true);
        }
    }

    /**
     * Set the Scene to the LakeController.
     * @param event A click MouseEvent
     * @throws IOException if Files or Resources that are attempted to be called cannot be found
     */
    @FXML
    void visitLake(MouseEvent event) throws IOException {
        Stage stage = (Stage) lakeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("LakeController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Lake)");
        stage.setScene(scene);
    }

    /**
     * Set the Scene to the Ocean Controller.
     * @param event A click MouseEvent
     * @throws IOException if Files or Resources that are attempted to be called cannot be found
     */
    @FXML
    void visitOcean(MouseEvent event) throws IOException {
        Stage stage = (Stage) oceanButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("OceanController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Ocean)");
        stage.setScene(scene);
    }

    /**
     * Set the Scene to the ShopController.
     * @param event A click MouseEvent
     * @throws IOException if Files or Resources that are attempted to be called cannot be found
     */
    @FXML
    void visitShop(MouseEvent event) throws IOException {
        Stage stage = (Stage) shopButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("ShopController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Shop)");
        stage.setScene(scene);
    }

    /**
     * Set the Scene to the HomeController.
     * @param event A click MouseEvent
     * @throws IOException if Files or Resources that are attempted to be called cannot be found
     */
    @FXML
    void closeMap(MouseEvent event) throws IOException {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(Player.getLastStage()));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Main Menu)");
        stage.setScene(scene);
    }

}
