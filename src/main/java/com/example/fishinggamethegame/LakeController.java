package com.example.fishinggamethegame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LakeController {

    @FXML
    private Button btn2;

    @FXML
    void goToOne(MouseEvent event) throws IOException {
        Stage stage = (Stage) btn2.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("HomeController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game!");
        stage.setScene(scene);
    }

}
