package com.example.fishinggamethegame;

        import javafx.animation.KeyFrame;
        import javafx.animation.Timeline;
        import javafx.concurrent.Task;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.KeyEvent;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.text.Text;
        import javafx.stage.Stage;
        import javafx.util.Duration;

        import java.io.IOException;
        import java.util.Random;

/**
 * A LakeController.
 * @author Arman Chinai & Colin Doig
 * @version 06042023
 */
public class LakeController {

    private final Random randInt = new Random();

    private final int cycleCounter = randInt.nextInt(100, 150);

    private boolean isUp;

    @FXML
    private Text fishCount;

    @FXML
    private Text coinCount;

    @FXML
    private ImageView fishingMeter;

    @FXML
    private ImageView exclamation;

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

    /**
     * Initialize the LakeController to display correct fish count and coin count of the Player.
     */
    public void initialize() {
        fishCount.setText(String.valueOf(Player.getFishCount()));
        coinCount.setText(String.valueOf(Player.getCoinCount()));
    }

    /**
     * Alter the Scene to be ready for the fishingGame.
     */
    @FXML
    void castRod() {
        fishingRod.setVisible(true);
        fishingSwirl.setVisible(true);
        fishButton.setVisible(false);
        mainMenuButton.setVisible(false);
        mapButton.setVisible(false);
        delay(randInt.nextInt(3, 8) * 1000L, () -> fishingGameManager());
    }

    /**
     * Set the Scene to the MapController.
     * @param event A click MouseEvent
     * @throws IOException if Files or Resources that are attempted to be called cannot be found
     */
    @FXML
    void openMap(final MouseEvent event) throws IOException {
        Player.setLastScene("LakeController.fxml");
        Stage stage = (Stage) mapButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("MapController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Map)");
        stage.setScene(scene);
    }

    /**
     * Set the Scene to the HomeController.
     * @param event A click MouseEvent
     * @throws IOException if Files or Resources that are attempted to be called cannot be found
     */
    @FXML
    void visitMainMenu(final MouseEvent event) throws IOException {
        Player.setLastScene("LakeController.fxml");
        Stage stage = (Stage) mainMenuButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("HomeController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Main Menu)");
        stage.setScene(scene);
    }

    /**
     * Delay the running of a Runnable method by the desired amount of milliseconds.
     * @param millis a long representing the number of milliseconds by which to delay
     * @param continuation a Runnable method to be continued after the delay
     */
    public static void delay(final long millis, final Runnable continuation) {
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

    /**
     * Manage the fishingGame.
     */
    @FXML
    void fishingGameManager() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.25), e -> {
        }));
        timeline.setCycleCount(randInt.nextInt(10, 16));
        timeline.play();
        timeline.setOnFinished(e -> {
            fishingSwirl.setVisible(false);
            exclamation.setVisible(true);
            fishingTarget.setVisible(true);
            userFishingBar.setVisible(true);
            fishingMeter.setVisible(true);
            fishCaught();
        });
    }

    /**
     *Displays the fishCaught exclamation point for several milliseconds before beginning the fishingGame.
     */
    @FXML
    void fishCaught() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.75), e -> {
        }));
        timeline.setCycleCount(1);
        timeline.play();
        timeline.setOnFinished(e -> {
            exclamation.setVisible(false);
            fishingGame();
        });
    }

    /**
     * Run the fishingGame for the user.
     */
    @FXML
    void fishingGame() {
        Player.setCurrentScore(0);
        isUp = false;

        Timeline fishTimeline = new Timeline(new KeyFrame(Duration.seconds(0.025), e -> {
            if (fishingTarget.getLayoutY() > 720) {
                fishingTarget.setLayoutY(fishingTarget.getLayoutY() - randInt.nextInt(15));
            } else if (fishingTarget.getLayoutY() < 250) {
                fishingTarget.setLayoutY(fishingTarget.getLayoutY() + randInt.nextInt(15));
            } else {
                fishingTarget.setLayoutY(fishingTarget.getLayoutY() + randInt.nextInt(-15, 15));
            }
        }));
        fishTimeline.setCycleCount(cycleCounter);
        fishTimeline.play();

        Timeline userTimeLine = new Timeline(new KeyFrame(Duration.seconds(0.025), e -> {
            if (isUp && !(userFishingBar.getLayoutY() < 258)) {
                userFishingBar.setLayoutY(userFishingBar.getLayoutY() - 8);
            } else if (!isUp && !(userFishingBar.getLayoutY() > 600)) {
                userFishingBar.setLayoutY(userFishingBar.getLayoutY() + 8);
            }
            if ((fishingTarget.getLayoutY() - 10) > userFishingBar.getLayoutY()
                    && fishingTarget.getLayoutY() < (userFishingBar.getLayoutY() + 150)) {
                Player.setCurrentScore(Player.getCurrentScore() + 1);
            }
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

    /**
     * Move the catch bar down for the user during the fishingGame.
     * @param event A key press KeyEvent
     */
    @FXML
    void moveBarDown(final KeyEvent event) {
        isUp = false;
    }

    /**
     * Move the catch bar up for the user during the fishingGame.
     * @param event A key press KeyEvent
     */
    @FXML
    void moveBarUp(final KeyEvent event) {
        isUp = true;
    }

    /**
     * Set the Scene to the FishCaughtController.
     * @throws IOException if Files or Resources that are attempted to be called cannot be found
     */
    @FXML
    void goToFishCaught() throws IOException {
        Player.setLastScene("LakeController.fxml");
        Stage stage = (Stage) mapButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("FishCaughtController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Fish Caught)");
        stage.setScene(scene);
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

    /**
     * Change the size of the fishButton on user hover.
     */
    @FXML
    void hoverFish() {
        fishButton.setFitHeight(250);
    }

    /**
     * Change the size of the fishButton when the user stops hovering over it.
     */
    @FXML
    void stopFishHover() {
        fishButton.setFitHeight(200);
    }
}
