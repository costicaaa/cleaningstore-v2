package app.receipt;

import app.util.HibernateUtility;
import com.google.common.collect.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import javax.persistence.Entity;

import java.util.*;

public class ReceiptDao extends HibernateUtility{

    public void storeReceipt(Receipt receipt)
    {
        getSessionFactory().openSession().save(receipt);
    }

//    private final List<Service> services = ImmutableList.of(
//            new Service(1, "Camasa", 999)
//    );
//

//
//    public Book getBookByIsbn(String isbn) {
//        return books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
//    }
//
//    public Book getRandomBook() {
//        return books.get(new Random().nextInt(books.size()));
//    }
}
