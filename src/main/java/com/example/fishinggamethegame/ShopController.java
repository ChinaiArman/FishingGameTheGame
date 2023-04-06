package com.example.fishinggamethegame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class ShopController {

    @FXML
    private ImageView mapButton;

    @FXML
    private ImageView mainMenuButton;

    @FXML
    private ImageView unlockOceanBtn;

    @FXML
    private ImageView upgradeRodBtn;

    @FXML
    private ImageView upgradeBaitBtn;

    @FXML
    private Text unlockOceanText;

    @FXML
    private Text upgradeRodText;

    @FXML
    private Text upgradeBaitText;

    @FXML
    private Text successText;

    @FXML
    private Text oceanUnlockedSuccessText;

    @FXML
    private Text rodStrengthSuccessText;

    @FXML
    private Text baitStrengthSuccessText;

    @FXML
    public void initialize() {
        upgradeRodBtn.setVisible(Player.getCatchThreshold() >= 50);
        upgradeRodText.setVisible(Player.getCatchThreshold() >= 50);
        upgradeRodText.setText("Upgrade Rod - " + (int) Math.pow(10, 1 + Player.getRodLevel() * 0.1));
        upgradeBaitBtn.setVisible(Player.getMaxBaitStrength() >= 50);
        upgradeBaitText.setVisible(Player.getMaxBaitStrength() >= 50);
        upgradeBaitText.setText("Upgrade Bait - " + (int) Math.pow(10, 1 + Player.getBaitLevel() * 0.1));
        unlockOceanBtn.setVisible(!(Player.isOceanUnlocked()));
        unlockOceanText.setVisible(!(Player.isOceanUnlocked()));
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
        if (!(Player.isOceanUnlocked()) && Player.getCoinCount() >= 50) {
            Player.unlockOcean();
            Player.setCoinCount(Player.getCoinCount() - 50);
            successText.setVisible(true);
            oceanUnlockedSuccessText.setVisible(true);
            oceanUnlockedSuccessText.setText("Ocean Unlocked");
            oceanUnlockedSuccessText.setFill(Paint.valueOf("#72c95e"));
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> {
            }));
            timeline.setCycleCount(10);
            timeline.play();
            timeline.setOnFinished(e -> {
                successText.setVisible(false);
                oceanUnlockedSuccessText.setVisible(false);
            });
        } else {
            oceanUnlockedSuccessText.setVisible(true);
            oceanUnlockedSuccessText.setText("Purchase Failed");
            oceanUnlockedSuccessText.setFill(Paint.valueOf("#cd2c2c"));
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> {
            }));
            timeline.setCycleCount(10);
            timeline.play();
            timeline.setOnFinished(e -> {
                oceanUnlockedSuccessText.setVisible(false);
            });
        }
    }

    @FXML
    void upgradeBait(MouseEvent event) {
        if (Player.getMaxBaitStrength() >= 50 && Player.getCoinCount() > (int) Math.pow(10, 1 + Player.getBaitLevel() * 0.1)) {
            Player.increaseBaitStrength();
            Player.setCoinCount(Player.getCoinCount() - (int) Math.pow(10, 1 + Player.getBaitLevel() * 0.1));
            Player.incrementBaitLevel();
            upgradeBaitText.setText("Upgrade Bait - " + (int) Math.pow(10, 1 + Player.getBaitLevel() * 0.1));
            System.out.println(Player.getBaitLevel());
            successText.setVisible(true);
            baitStrengthSuccessText.setVisible(true);
            baitStrengthSuccessText.setText("+1 Bait Strength");
            baitStrengthSuccessText.setFill(Paint.valueOf("#72c95e"));
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> {
            }));
            timeline.setCycleCount(10);
            timeline.play();
            timeline.setOnFinished(e -> {
                successText.setVisible(false);
                baitStrengthSuccessText.setVisible(false);
            });
        } else {
            baitStrengthSuccessText.setVisible(true);
            baitStrengthSuccessText.setText("Purchase Failed");
            baitStrengthSuccessText.setFill(Paint.valueOf("#cd2c2c"));
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> {
            }));
            timeline.setCycleCount(10);
            timeline.play();
            timeline.setOnFinished(e -> {
                baitStrengthSuccessText.setVisible(false);
            });
        }
    }

    @FXML
    void upgradeRod(MouseEvent event) {
        if (Player.getCatchThreshold() >= 50 && Player.getCoinCount() > (int) Math.pow(10, 1 + Player.getRodLevel() * 0.1)) {
            Player.decrementThreshold();
            Player.setCoinCount(Player.getCoinCount() - (int) Math.pow(10, 1 + Player.getRodLevel() * 0.1));
            Player.incrementRodLevel();
            upgradeRodText.setText("Upgrade Rod - " + (int) Math.pow(10, 1 + Player.getRodLevel() * 0.1));
            System.out.println(Player.getRodLevel());
            successText.setVisible(true);
            rodStrengthSuccessText.setVisible(true);
            rodStrengthSuccessText.setText("+1 Rod Strength");
            rodStrengthSuccessText.setFill(Paint.valueOf("#72c95e"));
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> {
            }));
            timeline.setCycleCount(10);
            timeline.play();
            timeline.setOnFinished(e -> {
                successText.setVisible(false);
                rodStrengthSuccessText.setVisible(false);
            });
        } else {
            rodStrengthSuccessText.setVisible(true);
            rodStrengthSuccessText.setText("Purchase Failed");
            rodStrengthSuccessText.setFill(Paint.valueOf("#cd2c2c"));
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> {
            }));
            timeline.setCycleCount(10);
            timeline.play();
            timeline.setOnFinished(e -> {
            rodStrengthSuccessText.setVisible(false);
        });
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

    /**
     * Change the size of the mainMenuButton on user hover.
     */
    @FXML
    void hoverExit() {
        mainMenuButton.setFitWidth(100);
    }

    /**
     * Change the size of the mainMenuButton when the user stops hovering over it.
     */
    @FXML
    void stopExitHover() {
        mainMenuButton.setFitWidth(75);
    }

    /**
     * Change the size of the mapButton on user hover.
     */
    @FXML
    void hoverMap() {
        mapButton.setFitWidth(250);
    }

    /**
     * Change the size of the mapButton when the user stops hovering over it.
     */
    @FXML
    void stopMapHover() {
        mapButton.setFitWidth(200);
    }
}
