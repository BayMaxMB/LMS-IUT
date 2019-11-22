package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {
    private double xOffSet;
    private double yOffSet;
    private String operator = "";
    @FXML
    private Label nOne;
    @FXML
    private Label nTwo;
    @FXML
    private Label opr;
    double number1 = 0;
    double number2 = 0;
    private boolean start = true;
    @FXML
    private TextField textField;
    @FXML
    private Label closeBtn;
    @FXML
    private void processNumber(ActionEvent event){
        if(start){
            textField.setText("");
            start = false;
            if(operator.isEmpty()) {
                nOne.setText("");
                nTwo.setText("");
                opr.setText("");
            }
        }
        String value = ((Button)event.getSource()).getText();
        textField.setText(textField.getText() + value);
    }
    @FXML
    private void processOperator(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if(value.equals(".")){
            textField.setText(textField.getText() + value);
        }
        else if(!value.equals("=")){
            if(!operator.isEmpty())
                return;
            number1 = Double.parseDouble(textField.getText());
            nOne.setText(String.valueOf(number1));
            operator = value;
            opr.setText(operator);
            textField.clear();
        }
        else if(value.equals("=")){
            if(operator.isEmpty())
                return;
            number2 = Double.parseDouble(textField.getText());
            nTwo.setText(String.valueOf(number2));
            textField.setText(String.format("%10.10s",(Model.calculate(number1, number2, operator))));
            start = true;
            operator = "";
        }
    }
    @FXML
    private void exitApp(){
        Stage stage = (Stage)closeBtn.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void minifyWin(){
        Stage stage = (Stage)closeBtn.getScene().getWindow();
        stage.setIconified(true);
    }
    @FXML
    private void pressedMousehandler(MouseEvent event){
        Stage stage = (Stage)closeBtn.getScene().getWindow();
        xOffSet = stage.getX() - event.getScreenX();
        yOffSet = stage.getY() - event.getScreenY();
    }
    @FXML
    private void dragWindow(MouseEvent event){
        Stage stage = (Stage)closeBtn.getScene().getWindow();
        stage.setX(event.getScreenX() + xOffSet);
        stage.setY(event.getScreenY() + yOffSet);
    }
 }
