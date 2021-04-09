package restaurantmenuselector.Model;

import java.util.ArrayList;
import java.util.List;


public class Order {
    private ArrayList<Product> basket;
    private List<String> customers;
    private String table;
    private String paymentMethod;

    public Order(ArrayList<Product> basket, List<String> customers, String table) {
        this.basket = basket;
        this.customers = customers;
        this.table = table;
    }

    public String getPaymentMethod() { return paymentMethod; }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public double getTotal(){
        double total=0;
        for (int i=0;i<this.basket.size();i++){
            total=total+basket.get(i).getCost();
        }
        return total;
    }

    public ArrayList<Product> getBasket() {
        return basket;
    }

    public void setBasket(ArrayList<Product> basket) { this.basket = basket; }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<String> customers) { this.customers = customers; }

    public String getTable() {
        return table;
    }

    public void setTable(String table) { this.table = table; }
    

    @Override
    public String toString() {
        return "Customer:\t"+this.customers+"\nTable:\t"+this.table+"\n\tITEMS\n"+this.basket.toString();
        
    }
    
} 
