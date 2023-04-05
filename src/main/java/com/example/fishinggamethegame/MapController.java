package com.example.fishinggamethegame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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

    /**
     * Reveal the oceanButton to the Player once Player.getOceanUnlocked() returns true
     */
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
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(Player.getLastScene()));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Main Menu)");
        stage.setScene(scene);
    }

    /**
     * Change the size of the lakeButton on user hover.
     */
    @FXML
    void hoverLake() {
        lakeButton.setFitWidth(300);
    }

    /**
     * Change the size of the lakeButton when the user stops hovering over it.
     */
    @FXML
    void stopLakeHover() {
        lakeButton.setFitWidth(275);
    }

    /**
     * Change the size of the oceanButton on user hover.
     */
    @FXML
    void hoverOcean() {
        oceanButton.setFitWidth(300);
    }

    /**
     * Change the size of the oceanButton when the user stops hovering over it.
     */
    @FXML
    void stopOceanHover() {
        oceanButton.setFitWidth(275);
    }

    /**
     * Change the size of the shopButton on user hover.
     */
    @FXML
    void hoverShop() {
        shopButton.setFitWidth(350);
    }

    /**
     * Change the size of the shopButton when the user stops hovering over it.
     */
    @FXML
    void stopShopHover() {
        shopButton.setFitWidth(325);
    }

    /**
     * Change the size of the closeButton on user hover.
     */
    @FXML
    void hoverExit() {
        closeButton.setFitWidth(100);
    }

    /**
     * Change the size of the closeButton when the user stops hovering over it.
     */
    @FXML
    void stopExitHover() {
        closeButton.setFitWidth(75);
    }
}
