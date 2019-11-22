package login;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controller {
    private double xOffSet;
    private double yOffSet;
    @FXML
    Label pleaseLoginLabel;
    @FXML
    private TextField textField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginBtn;
    @FXML
    private Button closeBtn;
    public void initialize(){
        Font font = Font.loadFont("Parisienne-Regular.ttf", 12);
        pleaseLoginLabel.setFont(font);
    }
    @FXML
    private Button minBtn;
    public void mouseClicked(MouseEvent event){
        if(event.getSource() == textField){
            textField.setStyle("-fx-background-color: white;");
        }
        else{
            passwordField.setStyle("-fx-background-color: white;");
        }
    }
    public void closeButtonClickedHandler(MouseEvent event){
        Stage stage = (Stage)closeBtn.getScene().getWindow();
        stage.close();
    }
    public void minButtonClickedHandler(MouseEvent event){
        Stage stage = (Stage)minBtn.getScene().getWindow();
        stage.setIconified(true);
    }
    public void mousePressedHandler(MouseEvent event){
        Stage stage = (Stage)minBtn.getScene().getWindow();
        xOffSet = stage.getX() - event.getScreenX();
        yOffSet = stage.getY() - event.getScreenY();
    }
    public void dragWindow(MouseEvent event){
        Stage stage = (Stage)minBtn.getScene().getWindow();
        stage.setX(xOffSet + event.getScreenX());
        stage.setY(yOffSet + event.getScreenY());
    }
}
