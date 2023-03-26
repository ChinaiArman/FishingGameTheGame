package com.example.fishinggamethegame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button btn1;

    @FXML
    void goToTwo(MouseEvent event) throws IOException {
        Stage stage = (Stage) btn1.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("LakeController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game!");
        stage.setScene(scene);
    }

}
