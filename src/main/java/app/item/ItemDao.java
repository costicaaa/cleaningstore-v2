package app.item;


import app.util.HibernateUtility;
import app.item.Item;

import java.util.*;

public class ItemDao extends HibernateUtility{

    public void store(Item tempItem)
    {
        getSessionFactory().openSession().save(tempItem);
    }

}
