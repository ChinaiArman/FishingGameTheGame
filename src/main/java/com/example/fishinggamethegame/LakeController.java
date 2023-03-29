package com.example.fishinggamethegame;

        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.image.ImageView;
        import javafx.scene.input.MouseEvent;
        import javafx.stage.Stage;

        import java.io.IOException;

public class LakeController {

    @FXML
    private ImageView fishButton;

    @FXML
    private ImageView mainMenuButton;

    @FXML
    private ImageView mapButton;

    @FXML
    private ImageView fishingRod;

    @FXML
    void castRod(MouseEvent event) {
        fishingRod.setVisible(!fishingRod.isVisible());
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

}

