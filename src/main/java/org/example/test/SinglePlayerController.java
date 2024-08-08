package org.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.stage.Stage;
import java.io.IOException;

public class SinglePlayerController extends StartController implements Checkable{
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;

    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img7;
    @FXML
    private ImageView img8;
    @FXML
    private ImageView img9;


    @Override
    public char XorO(){
        char symbol;
        if (counter%2!=0){
            symbol = 'O';
        }else{
            symbol='X';
        }
        counter++;
        return symbol;
    }

    @Override
    public void setAlert(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Already filled");
        alert.setHeaderText("Slot is already filled");
        alert.setContentText("Choose another slot to play in");
        alert.showAndWait();
    }

    public void setChoice(int btnID) throws IOException {
        Image image;
        char symbol = XorO();
        if (symbol == 'O') {
            image = new Image("/o.png");
        } else {
            image = new Image("/x.png");
        }
        switch (btnID) {
            case 1:
                img1.setImage(image);
                break;
            case 2:
                img2.setImage(image);
                break;
            case 3:
                img3.setImage(image);
                break;
            case 4:
                img4.setImage(image);
                break;
            case 5:
                img5.setImage(image);
                break;
            case 6:
                img6.setImage(image);
                break;
            case 7:
                img7.setImage(image);
                break;
            case 8:
                img8.setImage(image);
                break;
            case 9:
                img9.setImage(image);
                break;
        }
        choices.add(btnID);
    }

    public void AiChoice() throws IOException {
        if(choices.size()!=9) {
            int choice = (int) (Math.random() * 10);
            while (choice < 1 || choice > 9 || choices.contains(choice)) {
                choice = (int) (Math.random() * 10);
            }
            setChoice(choice);
        }
    }

    @Override
    public boolean detectWinner(){
        return ( (compareImages(img1,img5)) && (compareImages(img1,img9)) ) ||
                ( (compareImages(img3,img5)) && (compareImages(img3,img7))  ) ||
                ( (compareImages(img1,img4)) && (compareImages(img4,img7))  ) ||
                ( (compareImages(img2,img5)) && (compareImages(img2,img8))  ) ||
                ( (compareImages(img3,img6)) && (compareImages(img3,img9))  ) ||
                ( (compareImages(img1,img2)) && (compareImages(img1,img3))  ) ||
                ( (compareImages(img4,img5)) && (compareImages(img5,img6))  ) ||
                ( (compareImages(img7,img8)) && (compareImages(img8,img9))  );
    }

    @Override
    public void changeToWinner(ActionEvent event) throws IOException{
        if (detectWinner() || choices.size() == 9) {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("winner.fxml"));
            Parent root = loader.load();
            winnerController controller = loader.getController();
            controller.checkWinner(detectWinner());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            if (stage != null) {
                stage.setTitle("The Winner");
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }

    public boolean compareImages(ImageView imageView1, ImageView imageView2){
        if (imageView1==null || imageView2==null){
            return false;
        }
        Image img1 = imageView1.getImage();
        Image img2 = imageView2.getImage();
        if(img1==null || img2==null){
            return false;
        }
        if(img1.getWidth()!=img2.getWidth() || img1.getHeight()!=img2.getHeight()){
            return false;
        }
        PixelReader pixelReader1 = img1.getPixelReader();
        PixelReader pixelReader2 = img2.getPixelReader();
        for(int y=0;y<img1.getHeight();y++){
            for(int x=0;x<img1.getWidth();x++){
                if (pixelReader1.getArgb(x,y)!=pixelReader2.getArgb(x,y)){
                    return false;
                }
            }
        }
        return true;
    }


    @FXML
    private void btn1(ActionEvent event) throws IOException {
        if(!choices.contains(1)) {
            setChoice(1);
            changeToWinner(event);
            AiChoice();
            changeToWinner(event);
        }else {
            if(counter%2!=0) {
                setAlert();
            }
        }
    }

    @FXML
    private void btn2(ActionEvent event) throws IOException {
        if(!choices.contains(2)) {
            setChoice(2);
            changeToWinner(event);
            AiChoice();
            changeToWinner(event);
        }else {
            if(counter%2!=0) {
                setAlert();
            }
        }
    }

    @FXML
    private void btn3(ActionEvent event) throws IOException {
        if(!choices.contains(3)) {
            setChoice(3);
            changeToWinner(event);
            AiChoice();
            changeToWinner(event);
        }else {
            if(counter%2!=0) {
                setAlert();
            }
        }
    }

    @FXML
    private void btn4(ActionEvent event) throws IOException {
        if(!choices.contains(4)) {
            setChoice(4);
            changeToWinner(event);
            AiChoice();
            changeToWinner(event);
        }else {
            if(counter%2!=0) {
                setAlert();
            }
        }
    }

    @FXML
    private void btn5(ActionEvent event) throws IOException {
        if(!choices.contains(5)) {
            setChoice(5);
            changeToWinner(event);
            AiChoice();
            changeToWinner(event);
        }else {
            if(counter%2!=0) {
                setAlert();
            }
        }
    }

    @FXML
    private void btn6(ActionEvent event) throws IOException {
        if(!choices.contains(6)) {
            setChoice(6);
            changeToWinner(event);
            AiChoice();
            changeToWinner(event);
        }else {
            if(counter%2!=0) {
                setAlert();
            }
        }
    }

    @FXML
    private void btn7(ActionEvent event) throws IOException {
        if(!choices.contains(7)) {
            setChoice(7);
            changeToWinner(event);
            AiChoice();
            changeToWinner(event);
        }else {
            if(counter%2!=0) {
                setAlert();
            }
        }
    }

    @FXML
    private void btn8(ActionEvent event) throws IOException {
        if(!choices.contains(8)) {
            setChoice(8);
            changeToWinner(event);
            AiChoice();
            changeToWinner(event);
        }else {
            if(counter%2!=0) {
                setAlert();
            }
        }
    }

    @FXML
    private void btn9(ActionEvent event) throws IOException {
        if(!choices.contains(9)) {
            setChoice(9);
            changeToWinner(event);
            AiChoice();
            changeToWinner(event);
        }else {
            if(counter%2!=0) {
                setAlert();
            }
        }
    }

}