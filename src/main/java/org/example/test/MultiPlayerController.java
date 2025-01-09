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
import java.util.Arrays;
import java.util.HashMap;

public class MultiPlayerController extends StartController implements Checkable{
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
    HashMap<Integer ,ImageView> imagesMap =new HashMap<>();
    HashMap<String ,Integer> buttonsMap =new HashMap<>();
    @FXML
    public void initialize(){
        buttonsMap.put("btn1",1);
        buttonsMap.put("btn2",2);
        buttonsMap.put("btn3",3);
        buttonsMap.put("btn4",4);
        buttonsMap.put("btn5",5);
        buttonsMap.put("btn6",6);
        buttonsMap.put("btn7",7);
        buttonsMap.put("btn8",8);
        buttonsMap.put("btn9",9);
        ///////////////////////////
        imagesMap.put(1,img1);
        imagesMap.put(2,img2);
        imagesMap.put(3,img3);
        imagesMap.put(4,img4);
        imagesMap.put(5,img5);
        imagesMap.put(6,img6);
        imagesMap.put(7,img7);
        imagesMap.put(8,img8);
        imagesMap.put(9,img9);
    }

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
        if(detectWinner() || choices.containsAll(Arrays.asList(1,2,3,4,5,6,7,8,9))) {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("winner.fxml"));
            Parent root = loader.load();
            winnerController controller = loader.getController();
            if(detectWinner()) {
                controller.checkWinner(true);
            }else{
                controller.checkWinner(false);
            }
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("The Winner");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
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
    private void onButtonClicked(ActionEvent event) throws IOException {
        Button btn=(Button) event.getSource();
        int btnID= buttonsMap.get(btn.getId());
        ImageView img=imagesMap.get(btnID);

        if(!choices.contains(btnID)) {
            Image image;
            char symbol = XorO();
            if (symbol == 'O') {
                image = new Image("/o.png");
            } else {
                image = new Image("/x.png");
            }
            img.setImage(image);
            choices.add(btnID);
            changeToWinner(event);
        }else {
            if(counter%2==0) {
                setAlert();
            }
        }
    }


}
