package com.example.fishinggamethegame;

        import javafx.animation.KeyFrame;
        import javafx.animation.Timeline;
        import javafx.concurrent.Task;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.KeyCode;
        import javafx.scene.input.KeyEvent;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import javafx.util.Duration;

        import java.io.IOException;
        import java.util.Random;

public class LakeController {

    Random randInt = new Random();

    int cycleCounter = randInt.nextInt(100, 150);

    boolean isUp;

    @FXML
    private Text fishCount;

    @FXML
    private Text coinCount;

    @FXML
    private ImageView fishingMeter;

    @FXML
    private ImageView fishingTarget;

    @FXML
    private ImageView userFishingBar;

    @FXML
    private ImageView fishingSwirl;

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
        fishingRod.setVisible(true);
        fishingSwirl.setVisible(true);
        fishButton.setVisible(false);
        mainMenuButton.setVisible(false);
        mapButton.setVisible(false);
        delay(randInt.nextInt(3, 8) * 1000L, () -> fishingGameManager());
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
        }));
        timeline.setCycleCount(randInt.nextInt(10, 16));
        timeline.play();
        timeline.setOnFinished(e -> {
            fishingGame();
        });
    }

    @FXML
    void fishingGame() {
        Player.setCurrentScore(0);
        isUp = false;
        fishingTarget.setVisible(true);
        userFishingBar.setVisible(true);
        fishingMeter.setVisible(true);


        Timeline fishTimeline = new Timeline(new KeyFrame(Duration.seconds(0.035), e -> {
            if (fishingTarget.getLayoutY() > 720) {
                fishingTarget.setLayoutY(fishingTarget.getLayoutY() - randInt.nextInt(20));
            } else if (fishingTarget.getLayoutY() < 250) {
                fishingTarget.setLayoutY(fishingTarget.getLayoutY() + randInt.nextInt(20));
            } else {
                fishingTarget.setLayoutY(fishingTarget.getLayoutY() + randInt.nextInt(-20, 20));
            }
        }));
        fishTimeline.setCycleCount(cycleCounter);
        fishTimeline.play();

        Timeline userTimeLine = new Timeline(new KeyFrame(Duration.seconds(0.035), e -> {
            if (isUp && !(userFishingBar.getLayoutY() < 270)) {
                userFishingBar.setLayoutY(userFishingBar.getLayoutY() - 8);
            } else if (!isUp && !(userFishingBar.getLayoutY() > 600)) {
                userFishingBar.setLayoutY(userFishingBar.getLayoutY() + 8);
            }
            if ((fishingTarget.getLayoutY() - 10) > userFishingBar.getLayoutY()
                    && fishingTarget.getLayoutY() < (userFishingBar.getLayoutY() + 150)) {
                Player.setCurrentScore(Player.getCurrentScore() + 1);
            }
            System.out.println(Player.getCurrentScore());
        }));
        userTimeLine.setCycleCount(cycleCounter);
        userTimeLine.play();
        userTimeLine.setOnFinished(e -> {
            try {
                goToFishCaught();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    @FXML
    void moveBarDown(KeyEvent event) {
        isUp = false;
    }

    @FXML
    void moveBarUp(KeyEvent event) {
        isUp = true;
    }

    @FXML
    void goToFishCaught() throws IOException {
        Stage stage = (Stage) mapButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("FishCaughtController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Fish Caught)");
        stage.setScene(scene);
    }
}

