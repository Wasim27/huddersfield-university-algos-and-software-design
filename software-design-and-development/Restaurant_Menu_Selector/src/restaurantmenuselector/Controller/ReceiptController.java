package restaurantmenuselector.Controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ReceiptController implements Initializable {
    
    
    @FXML TextFlow textFlow;
    
    @FXML
    private void closeReceipt(ActionEvent e){
       MenuController.order=null;
       MenuController.total=0;
       MenuController.totalCalories=0;
       MenuController.basket=new ArrayList();
       try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/homepage.fxml"));
                Parent root1 = (Parent) fxmlLoader.load(); 
                Scene scene = new Scene(root1);
                Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            }catch(IOException ex) {
                ex.printStackTrace();
            }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Text title=new Text("THANK YOU FOR VISTING\nRECEIPT\n");
       title.setFill(Color.GREEN);
       title.setFont(new Font(20));
       String today=new SimpleDateFormat("dd-MM-yyyy HHmmss").format(Calendar.getInstance().getTime());
       Text preText=new Text("ORDER # - "+getOrderUniqueOrderNumber(5)+"\nDate - "+today+"\nTable Number "+ MenuController.order.getTable()+"\nTotal Calories "+ MenuController.totalCalories);
       String customer="\n_____________________\nCUSTOMERS\n";
       for(int i = 0; i< MenuController.order.getCustomers().size(); i++){
           int index=i+1;
           customer+="\n"+index+" - "+ MenuController.order.getCustomers().get(i);
       }
       String basket="\n________________________\nORDER\n";
       for(int i = 0; i< MenuController.order.getBasket().size(); i++){
           int index=i+1;
           basket+="\n"+index+" : "+ MenuController.order.getBasket().get(i).getITem();
       }
       basket+="\n_________________________\nTOTAL: £"+ MenuController.order.getTotal();
       textFlow.setTextAlignment(TextAlignment.CENTER);
       ObservableList list=textFlow.getChildren();
       list.addAll(title,preText,new Text(customer),new Text(basket));
       
    }  
    private String getOrderUniqueOrderNumber(int n) {

        String AlphaNumericString =  "0123456789";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
    
}
