package app.user;

import app.util.HibernateUtility;
import com.google.common.collect.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.*;
import java.util.stream.*;

public class UserDao extends HibernateUtility{

//    private final List<User> users = ImmutableList.of(
//            //        Username    Salt for hash                    Hashed password (the password is "password" for all users)
//            //new User("admin", "$2a$10$h.dl5J86rGH7I8bD9bZeZe", "$2a$10$h.dl5J86rGH7I8bD9bZeZeci0pDt0.VwFTGujlnEaZXPf/q7vM5wO"),
//            //new User("davidase",  "$2a$10$e0MYzXyjpJS7Pd0RVvHwHe", "$2a$10$e0MYzXyjpJS7Pd0RVvHwHe1HlCS4bZJ18JuywdEMLT83E1KDmUhCy"),
//            //new User("federico",  "$2a$10$E3DgchtVry3qlYlzJCsyxe", "$2a$10$E3DgchtVry3qlYlzJCsyxeSK0fftK4v0ynetVCuDdxGVl1obL.ln2")
//    );

    public User getUserByUsername(String username, String password) {
        String hql = "select * from users s where s.name = username and s.password = :password";
        Session session = getSessionFactory().openSession();
        Query query = session.createSQLQuery(hql)
                .addEntity(app.user.User.class)
                .setParameter("username", username)
                .setParameter("password", password);
        User result = new User();
        try
        {
            result = (User) query.getSingleResult();
            System.out.println("ajunge aici");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return result;
//        User u = new User();
//        Query query = u.getSession().createSQLQuery(
//                "select * from users s where s.name = :username")
//                .addEntity(User.class)
//                .setParameter("username", username);
//        User result = new User();
//        try
//        {
//            result = (User) query.getSingleResult();
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//        return result;

        //return users.stream().filter(b -> b.getUsername().equals(username)).findFirst().orElse(null);
    }

//    public Iterable<String> getAllUserNames() {
//        String hql = "SELECT name FROM app.user.User";
//        Session session = getSessionFactory().openSession();
//        Query query = session.createSQLQuery(hql);
////        System.out.println(query.getQueryString());
//        List<User> results = query.list();
////        List<User> results = new ArrayList<Service>();
////        results = query.list();
////        System.out.println(results);
////        for(User a : results)
////        {
////            System.out.println(a.getName());
////        }
//        return results;
//
//        //return users.stream().map(User::getUsername).collect(Collectors.toList());
//    }

}
