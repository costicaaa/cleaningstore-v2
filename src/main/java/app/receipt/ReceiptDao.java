package app.receipt;

import app.item.Item;
import app.service.Service;
import app.util.HibernateUtility;
import com.google.common.collect.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import javax.persistence.Entity;
import app.service.ServiceDao;

import java.util.*;

@SuppressWarnings("ALL")
public class ReceiptDao extends HibernateUtility{

    public List<Receipt> getAllReceipts()
    {
        String hql = "FROM app.receipt.Receipt order by id desc";
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Receipt> results = query.list();

        return results;
    }

    public List<Item> getItemsForReceipt(int receipt_id)
    {
        String hql = "FROM app.item.Item where receipt_id = :id";
        Session session = getSessionFactory().openSession();
        Query query = session.createQuery(hql);

        List<Item> results = query
                .setParameter("id", receipt_id)
                .list();

// get service info for item
        ServiceDao serviceDao;
        serviceDao = new ServiceDao();
        for(Item item : results)
        {
            Service service = serviceDao.getServiceById(item.service_id);
            item.service = service;

        }

        return results;
    }

    public Receipt getReceiptById(int id)
    {
        Session session = getSessionFactory().openSession();
        Receipt receipt =  (Receipt) session.get(Receipt.class, id);
        receipt.assignedItems = getItemsForReceipt(id);

        return receipt;
    }

    public void store(Receipt receipt)
    {
        getSessionFactory().openSession().save(receipt);
    }

}
