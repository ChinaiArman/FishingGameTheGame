package com.example.fishinggamethegame;

    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Scene;
    import javafx.scene.image.ImageView;
    import javafx.scene.input.MouseEvent;
    import javafx.stage.Stage;

    import java.io.IOException;

public class HomeController {

    @FXML
    private ImageView exitButton;

    @FXML
    private ImageView playButton;

    @FXML
    void playGame(MouseEvent event) throws IOException {
        Stage stage = (Stage) playButton.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("LakeController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Lake)");
        stage.setScene(scene);
    }

    @FXML
    void quitGame(MouseEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}
