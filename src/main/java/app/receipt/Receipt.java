package app.receipt;


import app.Application;
import app.item.Item;
import app.util.Misc;

import java.util.List;

// All fields are private and final. Getters (but not setters) are generated (https://projectlombok.org/features/Value.html)
public class Receipt {
    int id;
    String customer_name;
    String customer_email;
    double price;
    java.util.Date entry_date;
    java.util.Date return_date;
    List<Item> assignedItems;
    boolean allItemsClean = false;


    public List<Item> getAssignedItems() {
        return assignedItems;
    }

    public void setAssignedItems(List<Item> assignedItems) {
        this.assignedItems = assignedItems;
    }


     public int getId() {
         return id;
     }

     public void setId(int id) {
         this.id = id;
     }

     public String getCustomer_name() {
         return customer_name;
     }

     public void setCustomer_name(String customer_name) {
         this.customer_name = customer_name;
     }

     public String getCustomer_email() {
         return customer_email;
     }

     public void setCustomer_email(String customer_email) {
         this.customer_email = customer_email;
     }

     public double getPrice() {
         return price;
     }

     public void setPrice(double price) {
         this.price = price;
     }

     public java.util.Date getEntry_date() {
         return entry_date;
     }

     public void setEntry_date(java.util.Date entry_date) {
         this.entry_date = entry_date;
     }

     public java.util.Date getReturn_date() {
         return return_date;
     }

     public void setReturn_date(java.util.Date return_date) {
         this.return_date = return_date;
     }

     public boolean checkIfAllItemsClean()
     {
         boolean truth = true;
         for(Item i : assignedItems)
         {
             if(i.getStatus() == Misc.STATUS_ITEM_DIRTY)
             {
                 truth = false;
                 break;
             }
         }
         this.allItemsClean = truth;
         return truth;
     }

 }
