package org.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class StartController {
    @FXML
    private Button singlePlayer;
    @FXML
    private Button multiPlayer;


    protected static int counter =1;
    protected static ArrayList<Integer> choices = new ArrayList<>();


    public void singlePlayer(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Main.class.getResource("singlePlayer.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Single Player Mode");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void multiPlayer(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Main.class.getResource("multiPlayer.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Multi Player Mode");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
