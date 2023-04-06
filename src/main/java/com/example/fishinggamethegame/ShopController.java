package com.example.fishinggamethegame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ShopController {

    @FXML
    private Button mapButton;

    @FXML
    private Button mainMenuButton;

    @FXML
    private Button unlockOceanBtn;

    @FXML
    private Button upgradeRodBtn;

    @FXML
    private Button upgradeBaitBtn;

    @FXML
    public void initialize() {
        upgradeRodBtn.setVisible(Player.getCatchThreshold() >= 50);
        upgradeRodBtn.setText("Upgrade Rod - " + (int) Math.pow(10, 1 + Player.getRodLevel() * 0.1));
        upgradeBaitBtn.setVisible(Player.getMaxBaitStrength() >= 50);
        upgradeBaitBtn.setText("Upgrade Bait - " + (int) Math.pow(10, 1 + Player.getBaitLevel() * 0.1));
        unlockOceanBtn.setVisible(!(Player.isOceanUnlocked()));
    }

    @FXML
    void openMap(MouseEvent event) throws IOException {
        Player.setLastScene("ShopController.fxml");
        Stage stage = (Stage) mapButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("MapController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Map)");
        stage.setScene(scene);
    }

    @FXML
    void visitMainMenu(MouseEvent event) throws IOException {
        Player.setLastScene("ShopController.fxml");
        Stage stage = (Stage) mainMenuButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("HomeController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Main Menu)");
        stage.setScene(scene);
    }

    @FXML
    void unlockOcean(MouseEvent event) {
        System.out.println("button things");
        if (!(Player.isOceanUnlocked()) && Player.getCoinCount() >= 50) {
            Player.unlockOcean();
            Player.setCoinCount(Player.getCoinCount() - 50);
        }
    }

    @FXML
    void upgradeBait(MouseEvent event) {
        if (Player.getMaxBaitStrength() >= 50 && Player.getCoinCount() > (int) Math.pow(10, 1 + Player.getBaitLevel() * 0.1)) {
            Player.increaseBaitStrength();
            Player.setCoinCount(Player.getCoinCount() - (int) Math.pow(10, 1 + Player.getBaitLevel() * 0.1));
            Player.incrementBaitLevel();
        }
    }

    @FXML
    void upgradeRod(MouseEvent event) {
        if (Player.getCatchThreshold() >= 50 && Player.getCoinCount() > (int) Math.pow(10, 1 + Player.getRodLevel() * 0.1)) {
            Player.decrementThreshold();
            Player.setCoinCount(Player.getCoinCount() - (int) Math.pow(10, 1 + Player.getRodLevel() * 0.1));
            Player.incrementRodLevel();
        }
    }

    @FXML
    void sellFish(MouseEvent event) {
        if (Player.getFishCount() == 0) {
            System.out.println("no fish");
        } else {
            Player.setCoinCount(Player.getFishCount() * 10);
            Player.setFishCount(0);
        }
    }
}
