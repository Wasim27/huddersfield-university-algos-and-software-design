package restaurantmenuselector.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentCreditCardController implements Initializable {

    @FXML
    ComboBox comboCard;
    @FXML
    TextField cardNumber;
    @FXML
    DatePicker date;


    @FXML
    private void pay(ActionEvent e){
        String card= cardNumber.getText();
        if(card.length()==0 || date.getValue()==null || comboCard.getSelectionModel().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"All fields are required").showAndWait();
        }else if(validateCard(card)==false || card.length()!=16){
            new Alert(Alert.AlertType.ERROR,"Enter a valid card number "+ card.length()).showAndWait();
        }else{
            String date= this.date.getValue().toString();
            String type=comboCard.getValue().toString();
            String payment="Card Number: "+card+"\tDate:"+date+"\t"+type;
            MenuController.order.setPaymentMethod(payment);
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/receipt.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Scene scene = new Scene(root1);
                Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            }catch(IOException ex) {
                ex.printStackTrace();
            }
        }

    }
    private boolean validateCard(String input){
        try{
            Long.parseLong(input);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboCard.getItems().add("Master Card");
        comboCard.getItems().add("Visa");
        comboCard.getItems().add("American Express");

    }
}

