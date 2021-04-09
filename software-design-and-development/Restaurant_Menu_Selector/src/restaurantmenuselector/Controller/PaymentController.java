package restaurantmenuselector.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PaymentController implements Initializable {

    @FXML
    ComboBox comboPaymentMethod;
    @FXML
    TextField textTotal;

    @FXML
    private void cancelOrder(ActionEvent event) {

        MenuController.order=null;
        MenuController.total=0;
        MenuController.totalCalories=0;
        MenuController.basket=new ArrayList();

        Alert a = new Alert(AlertType.INFORMATION);
        a.setContentText("Order Cancelled!");
        a.show();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/homepage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root1);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void printReceipt(ActionEvent e) {
        if (comboPaymentMethod.getSelectionModel().isEmpty()) {
            new Alert(AlertType.WARNING, "Select a payment method").show();
        } else {
            String payment = comboPaymentMethod.getSelectionModel().getSelectedItem().toString();
            if (payment.equals("Credit Card")) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/paymentCreditCard.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Scene scene = new Scene(root1);
                    Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    appStage.setScene(scene);
                    appStage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                MenuController.order.setPaymentMethod(payment);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/receipt.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Scene scene = new Scene(root1);
                    Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                    appStage.setScene(scene);
                    appStage.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboPaymentMethod.getItems().add("Cash");
        comboPaymentMethod.getItems().add("Credit Card");
        textTotal.setText(Double.toString(MenuController.order.getTotal()));
    }
}
