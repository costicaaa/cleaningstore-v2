package app.item;

import lombok.*;
import app.service.*;

import java.util.Date;

// All fields are private and final. Getters (but not setters) are generated (https://projectlombok.org/features/Value.html)
public class Item {
    public int id;
    public int status;
    public java.util.Date cleaning_date;
    public int receipt_id;
    public int service_id;

//    Service service;


    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCleaning_date() {
        return cleaning_date;
    }

    public void setCleaning_date(Date cleaning_date) {
        this.cleaning_date = cleaning_date;
    }

    public int getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
    }

}
