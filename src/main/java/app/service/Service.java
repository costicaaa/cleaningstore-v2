package app.service;

import lombok.*;

 // All fields are private and final. Getters (but not setters) are generated (https://projectlombok.org/features/Value.html)
public class Service {
    int id;
    String name;
    double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

     public void setId(int id) {
         this.id = id;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setPrice(double price) {
         this.price = price;
     }
     //
//    public String getMediumCover() {
//        return "http://covers.openlibrary.org/b/isbn/" + this.isbn + "-M.jpg";
//    }

//    public String getLargeCover() {
//        return "http://covers.openlibrary.org/b/isbn/" + this.isbn + "-L.jpg";
//    }
}
