package com.example.fishinggamethegame;

        import javafx.animation.KeyFrame;
        import javafx.animation.Timeline;
        import javafx.concurrent.Task;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import javafx.util.Duration;

        import java.io.IOException;
        import java.util.Random;

public class LakeController {

    @FXML
    private Text fishCount;

    @FXML
    private Text coinCount;

    @FXML
    private ImageView fishButton;

    @FXML
    private ImageView mainMenuButton;

    @FXML
    private ImageView mapButton;

    @FXML
    private ImageView fishingRod;

    public void initialize() {
        fishCount.setText(String.valueOf(Player.getFishCount()));
        coinCount.setText(String.valueOf(Player.getCoinCount()));
        Player.setCoinCount(Player.getCoinCount() + 10);
    }

    @FXML
    void castRod() {
        Random randInt = new Random();
        fishingRod.setVisible(!fishingRod.isVisible());
        if (fishingRod.isVisible()) {
            fishButton.setVisible(false);
            mainMenuButton.setVisible(!mainMenuButton.isVisible());
            mapButton.setVisible(!mapButton.isVisible());
            delay(randInt.nextInt(3, 10) * 1000L, () -> fishingGameManager());
        }
    }

    @FXML
    void openMap(MouseEvent event) throws IOException {
        Stage stage = (Stage) mapButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("MapController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Map)");
        stage.setScene(scene);
    }

    @FXML
    void visitMainMenu(MouseEvent event) throws IOException {
        Stage stage = (Stage) mainMenuButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("HomeController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Main Menu)");
        stage.setScene(scene);
    }

    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<>() {
            @Override
            protected Void call() {
                try {
                    Thread.sleep(millis);
                } catch (InterruptedException e) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }

    @FXML
    void fishingGameManager() {
        Random randInt = new Random();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> {
            // waiting animation
        }));
        timeline.setCycleCount(randInt.nextInt(10, 16));
        timeline.play();
        timeline.setOnFinished(e -> {
            fishingGame();
        });
    }

    @FXML
    void fishingGame() {
        // game mechanics
        // change to fish caught scene
    }
}

