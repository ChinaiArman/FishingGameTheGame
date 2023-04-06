package com.example.fishinggamethegame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * An Application.
 * @author Arman Chinai & Colin Doig
 * @version 06042023
 */
public class Application extends javafx.application.Application {

    /**
     * Starts and runs the Application.
     * @param stage an object of the Stage class
     * @throws IOException if Files or Resources that are attempted to be called cannot be found
     */
    @Override
    public void start(final Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("HomeController.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fishing Game, The Game! (Main Menu)");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Drive the program.
     * @param args No command line arguments need to be entered
     */
    public static void main(String[] args) {
        launch();
    }
}
