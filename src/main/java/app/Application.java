package app;

import app.book.*;
import app.index.*;
import app.login.*;
import app.ticket.TicketController;
import app.user.*;
import app.util.*;
import app.service.*;

import static spark.Spark.*;
import static spark.debug.DebugScreen.*;
import app.util.HibernateUtility;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class Application {

    // Declare dependencies
    public static BookDao bookDao;
    public static UserDao userDao;
    public static ServiceDao serviceDao;

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

        // Instantiate your dependencies
        bookDao = new BookDao();
        userDao = new UserDao();
        serviceDao = new ServiceDao();



        // Configure Spark
        port(4567);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        enableDebugScreen();

        // Set up before-filters (called before each get/post)
        before("*",                  Filters.addTrailingSlashes);
        before("*",                  Filters.handleLocaleChange);

        // Set up routes
        get(Path.Web.INDEX,          IndexController.serveIndexPage);
        get(Path.Web.BOOKS,          BookController.fetchAllBooks);
        get(Path.Web.ONE_BOOK,       BookController.fetchOneBook);
        get(Path.Web.LOGIN,          LoginController.serveLoginPage);
        post(Path.Web.LOGIN,         LoginController.handleLoginPost);
        post(Path.Web.LOGOUT,        LoginController.handleLogoutPost);

        get(Path.Web.TICKETS_ADD,        TicketController.serveAddPage);
        get(Path.Web.TICKETS,        TicketController.serveIndexPage);


        get("*",                     ViewUtil.notFound);

        //Set up after-filters (called after each get/post)
        after("*",                   Filters.addGzipHeader);

    }

}
