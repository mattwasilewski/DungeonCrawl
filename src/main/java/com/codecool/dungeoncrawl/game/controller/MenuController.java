package com.codecool.dungeoncrawl.game.controller;

import com.codecool.dungeoncrawl.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private Button exitButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button startButton;

    @FXML
    private Label tfName;


    public static boolean nextWindow = true;

    @FXML
    void exit(ActionEvent event) {
        nextWindow = false;
        Stage stageToClose = (Stage) tfName.getScene().getWindow();
        stageToClose.close();
    }

    @FXML
    void loadGame(ActionEvent event) {

    }

    @FXML
    void startGame() {
        if (nextWindow) {
            ViewController.setNameSelectView();
//            try {
////                Stage stage = new Stage(); // nie tworzyc nowego okna bo po chuj
//                Stage stage = (Stage) tfName.getScene().getWindow();
//                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("name-view.fxml"));
//                Scene scene = new Scene(fxmlLoader.load());
//                stage.setTitle("Name input");
//                stage.setScene(scene);
//                stage.show();
////                stage.showAndWait();
////                Stage stageToClose = (Stage) tfName.getScene().getWindow();  // to do wyjebania no bo nie zamykamy okna
////                stageToClose.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }

}
