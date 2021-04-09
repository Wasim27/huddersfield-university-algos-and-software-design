package restaurantmenuselector.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Stage;
import restaurantmenuselector.Model.Product;
import restaurantmenuselector.Model.Notification;
import restaurantmenuselector.Model.Order;

public class MenuController implements Initializable {

    static ArrayList<Product> basket=new ArrayList<>();
    static ArrayList<Product> menu=new ArrayList<>();
    static Order order=null;
    static double total=0;
    static double totalCalories=0;

    @FXML TableView tableOrders;
    @FXML TableColumn colName;
    @FXML TableColumn colType;
    @FXML TableColumn colCalories;
    @FXML TableColumn colPrice;
    @FXML TableColumn colCustomer;
    @FXML ComboBox comboTable;
    @FXML ComboBox comboCustomers;
    @FXML Label labelTotal;
    @FXML Label labelCalories;
    @FXML ListView listCustomers;
    @FXML TextArea textReceipt;

    @FXML
    private void removeItem(ActionEvent e){
        if(tableOrders.getSelectionModel().getSelectedIndex()<0){
            new Alert(AlertType.WARNING,"Select an item to remove").show();
        }else{
            int index=tableOrders.getSelectionModel().getSelectedIndex();
            tableOrders.getItems().remove(tableOrders.getSelectionModel().getSelectedIndex());
            total=total-basket.get(index).getCost();
            totalCalories=totalCalories-basket.get(index).getCalories();
            labelTotal.setText("Total : £"+ ((total)));
            labelCalories.setText("TOTAL CALORIES : "+totalCalories);
            basket.remove(index);
            new Alert(AlertType.INFORMATION,"Item removed!").show();
        }
    }
    private void populateBasket(){
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colCalories.setCellValueFactory(new PropertyValueFactory<>("calories"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("cost"));
        colCustomer.setCellValueFactory(new PropertyValueFactory<>("customer"));

    }

    @FXML
    private void submitOrder (ActionEvent e) throws IOException{
        if(comboCustomers.getSelectionModel().isEmpty() || basket.isEmpty() || comboTable.getSelectionModel().isEmpty()){
            new Alert(AlertType.WARNING,"Fill all fields").show();
        }else{
            List<String> customers=listCustomers.getItems();
            order=new Order(basket,customers, this.comboCustomers.getSelectionModel().getSelectedItem().toString());
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/payment.fxml"));
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

    private String selectCustomer(){
        List<String> customers=listCustomers.getItems();
        Iterator<String> iter=customers.iterator();
        ChoiceDialog<String> choiceDialog = new ChoiceDialog<>(iter.next(),customers);
        choiceDialog.showingProperty().addListener((a, b, c) -> {
            if (c) {
                choiceDialog.setContentText("");
            }else {
                choiceDialog.setContentText(null);
            }

            if (c) {
                Node comboBox = choiceDialog.getDialogPane().lookup(".combo-box");

                comboBox.requestFocus();
            }
        });
        choiceDialog.setTitle("SELECT CUSTOMER");
        choiceDialog.showAndWait();
        return choiceDialog.getSelectedItem();
    }
    public void preload(){
        Product product =new Product("Tomato Soup","starter",80,12.00,"");
        menu.add(product);
        Product product1 =new Product("Prawn Noodle Salad","starter",80,12.00,"");
        menu.add(product1);
        Product product2 =new Product("Mackerel Pate","starter",80,12.00,"");
        menu.add(product2);
        Product product3 =new Product("Avocado Panzanella","starter",80,12.00,"");
        menu.add(product3);
        Product product4 =new Product("Mixed Bean Goulash","starter",80,12.00,"");
        menu.add(product4);
        Product product5 =new Product("Persian Lamb Tagine","main",80,12.00,"");
        menu.add(product5);
        Product product6 =new Product("Steak and Chips","main",80,12.00,"");
        menu.add(product6);
        Product product7 =new Product("Salt and Pepper Tofu","main",80,12.00,"");
        menu.add(product7);
        Product product8 =new Product("Baked Sea Bass","main",80,12.00,"");
        menu.add(product8);
        Product product9 =new Product("Chickpea Fajitas","main",80,12.00,"");
        menu.add(product9);
        Product product10 =new Product("Blueberry Pie","main",80,12.00,"");
        menu.add(product10);
        Product product11 =new Product("Vegan Eton Mess","dessert",80,12.00,"");
        menu.add(product11);
        Product product12 =new Product("Cranachan","dessert",80,12.00,"");
        menu.add(product12);
    }

    @FXML
    private void s1(ActionEvent e){

        Product product =new Product("Tomato Soup","starter",268,3.50,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void s2(ActionEvent e){

        Product product =new Product("Prawn Noodle Salad","starter",316,2.50,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void s3(ActionEvent e){
        Product product =new Product("Mackerel Pate","starter",283,4.30,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void s4(ActionEvent e){
        Product product =new Product("Avocado Panzanella","starter",332,4.50,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void s5(ActionEvent e){
        Product product =new Product("Mixed Bean Goulash","starter",460,5.00,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void m1(ActionEvent e){
        Product product =new Product("Persian Lamb Tagine","main",667,8.20,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void m2(ActionEvent e){
        Product product =new Product("Steak and Chips","main",600,7.95,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void m3(ActionEvent e){
        Product product =new Product("Salt and Pepper Tofu","main",254,4.90,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void m4(ActionEvent e){
        Product product =new Product("Baked Sea Bass","main",196,5.50,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void m5(ActionEvent e){
        Product product =new Product("Chickpea Fajitas","main",782,6.30,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void d1(ActionEvent e){
        Product product =new Product("Blueberry Pie","main",360,4.70,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void d2(ActionEvent e){
        Product product =new Product("Vegan Eton Mess","dessert",383,3.75,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    private void showData(int index){
        textReceipt.setText(order.toString());
    }
    @FXML
    private void d3(ActionEvent e){
        Product product =new Product("Cranachan","dessert",529,3.50,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void d4(ActionEvent e){
        Product product =new Product("Lemon Drizzle Cake","dessert",514,6.75,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void d5(ActionEvent e){
        Product product =new Product("Pudding Trifles","dessert",617,4.00,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void dr1(ActionEvent e){
        Product product =new Product("Vegan Eggnog","starter",78,3.00,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void dr2(ActionEvent e){
        Product product =new Product("Crystal Colada","drink",168,3.75,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void dr3(ActionEvent e){
        Product product =new Product("Gingerbread Latte","drink",280,4.50,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void dr4(ActionEvent e){
        Product product =new Product("Banana Smoothie","drink",250,1.75,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }
    @FXML
    private void dr5(ActionEvent e){
        Product product =new Product("Coco Fizz","drink",110,2.50,"");
        if(listCustomers.getItems().size()==0){
            Alert alert=new Alert(AlertType.ERROR,"You have not added any customers");
            alert.show();
        }else{
            Alert alert=new Alert(AlertType.CONFIRMATION,"Select customer for the item");
            alert.showAndWait();
            if(alert.getResult().equals(ButtonType.OK)){
                String customer=selectCustomer();
                product.setCustomer(customer);
                basket.add(product);
                total=total+ product.getCost();
                totalCalories=totalCalories+ product.getCalories();
                labelTotal.setText("Total : £"+total);
                labelCalories.setText("TOTAL CALORIES: "+totalCalories);
                tableOrders.getItems().add(product);
            }
        }
    }

    @FXML
    private void prepopulate(ActionEvent e) {
        try {
            listCustomers.getItems().clear();
            int customerCount = Integer.parseInt(comboCustomers.getSelectionModel().getSelectedItem().toString());
            for (int i = 1; i <= customerCount; i++) {
                String customer = "Click here to change customer name " + i + "";
                listCustomers.getItems().add(customer);
            }
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(AlertType.INFORMATION, "Enter a number");
            alert.show();
            e.consume();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Notification.infoBox("Pick number of customers and table number in the basket first", "Notification");
        listCustomers.setEditable(true);
        listCustomers.setCellFactory(TextFieldListCell.forListView());
        for (int i=1;i<=6;i++){
            comboCustomers.getItems().add(i);
        }
        for (int i=1;i<=12;i++){
            comboTable.getItems().add(i);
        }
        preload();
        populateBasket();
    }
}
