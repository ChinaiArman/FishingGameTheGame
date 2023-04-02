package com.example.fishinggamethegame;

    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Scene;
    import javafx.scene.image.ImageView;
    import javafx.scene.input.MouseEvent;
    import javafx.stage.Stage;

    import java.io.IOException;

/**
 * A HomeController.
 * @author Arman Chinai & Colin Doig
 * @version 06042023
 */
public class HomeController {

    @FXML
    private ImageView exitButton;

    @FXML
    private ImageView playButton;

    /**
     * Set the Scene to the LakeController.
     * @param event A click MouseEvent
     * @throws IOException if Files or Resources that are attempted to be called cannot be found
     */
    @FXML
    void playGame(MouseEvent event) throws IOException {
        Stage stage = (Stage) playButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("LakeController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Lake)");
        stage.setScene(scene);
    }

    /**
     * Close the Stage.
     * @param event A click MouseEvent
     */
    @FXML
    void quitGame(MouseEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}
