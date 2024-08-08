package org.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class winnerController extends StartController{
    @FXML
    private Button playAgain;
    @FXML
    private Button exit;
    @FXML
    private Label result;


    public void checkWinner(boolean win){
        if(choices.containsAll(Arrays.asList(1,2,3,4,5,6,7,8,9)) && !win){
            result.setText("The game ended with a tie🔥");
        }else if(counter%2==0 && win){
            result.setText("O is the winner🎉");
        }else if(counter%2!=0 && win){
            result.setText("X is the winner🎉");
        }
    }

    public void PlayAgain(ActionEvent event) throws IOException {
        choices.clear();
        counter=1;
        Parent root = FXMLLoader.load(Main.class.getResource("start.fxml"));
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Tic Tac Toe");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit(ActionEvent event) throws IOException {
            System.exit(0);
    }


}
