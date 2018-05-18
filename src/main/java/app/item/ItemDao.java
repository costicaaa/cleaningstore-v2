package app.item;


import app.receipt.Receipt;
import app.util.HibernateUtility;
import app.item.Item;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ItemDao extends HibernateUtility{

    public void store(Item tempItem)
    {
        getSessionFactory().openSession().save(tempItem);
    }

    public List<Item> getAllItemsCleanedMonth(Integer month_number)
    {
        String hql = "FROM app.item.Item where month(cleaning_date) = :search_constraint";
        Session session = getSessionFactory().openSession();
        Query query = session
                .createQuery(hql)
                .setParameter("search_constraint", month_number);
        List<Item> items = query.list();

        return items;
    }

    public Item getItemById(int id)
    {
        Session session = getSessionFactory().openSession();
        Item item =  (Item) session.get(Item.class, id);
        return item;
    }

    public Item updateCleanStatus(int id) throws Exception // we return item so we can redirect back to the receipt view page :D
    {

        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        Item item = new Item();
        java.util.Date dt = new java.util.Date();

        //todo :: redirect messages
        try{
            tx = session.beginTransaction();
            item = getItemById(id);
            item.setStatus(1);

            item.setCleaning_date(dt);
            session.update(item);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return item;
    }

}
