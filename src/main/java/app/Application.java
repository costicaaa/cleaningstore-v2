package app;

import app.book.*;
import app.index.*;
import app.login.*;
import app.receipt.ReceiptController;
import app.report.ReportController;
import app.ticket.TicketController;
import app.user.*;
import app.util.*;
import app.service.*;
import app.receipt.*;
import app.item.*;

import static spark.Spark.*;
import static spark.debug.DebugScreen.*;
import app.util.HibernateUtility;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.mindrot.jbcrypt.BCrypt;

import java.util.List;

public class Application {

    // Declare dependencies
    public static BookDao bookDao;
    public static UserDao userDao;
    public static ServiceDao serviceDao;
    public static ReceiptDao receiptDao;
    public static ItemDao itemDao;



    public static void main(String[] args) {
//        User uu = new User();
//        uu.setPassword("asd123");


        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();

        // Instantiate your dependencies
        bookDao = new BookDao();
        userDao = new UserDao();
        serviceDao = new ServiceDao();
        receiptDao = new ReceiptDao();
        itemDao = new ItemDao();

        // Configure Spark
        port(4567);
        staticFiles.location("/public");
        staticFiles.expireTime(600L);
        enableDebugScreen();

        // Set up before-filters (called before each get/post)
        before("*",                       Filters.addTrailingSlashes);
        before("*",                       Filters.handleLocaleChange);
        // Set up routes
        get(    Path.Web.INDEX,                 IndexController.serveIndexPage);
        get(    Path.Web.BOOKS,                 BookController.fetchAllBooks);
        get(    Path.Web.ONE_BOOK,              BookController.fetchOneBook);
        get(    Path.Web.LOGIN,                 LoginController.serveLoginPage);
        post(   Path.Web.LOGIN,                 LoginController.handleLoginPost);
        post(   Path.Web.LOGOUT,                LoginController.handleLogoutPost);
        //
        get(    Path.Web.RECEIPTS,              ReceiptController.serveIndexPage);
        get(    Path.Web.RECEIPTS_ADD,          ReceiptController.serveAddPage);
        get(    Path.Web.RECEIPTS_RETURN,       ReceiptController.returnReceipt);
        get(    Path.Web.RECEIPTS_VIEW,         ReceiptController.serveViewPage);
        post(   Path.Web.RECEIPTS_STORE,        ReceiptController.storeReceipt);
        get(    Path.Web.RECEIPTS_CLEAN_ITEM,   ReceiptController.cleanItem);
        //
        get(    Path.Web.USERS,                 UserController.serveIndexPage);
        get(    Path.Web.USERS_ADD,             UserController.serveAddPage);
        get(    Path.Web.USERS_VIEW,            UserController.serveViewPage);
        post(   Path.Web.USERS_SAVE,            UserController.saveUser);
        //
        get(    Path.Web.REPORTS_MONTHLY,       ReportController.serveReportsMonthlyPage);
        get(    Path.Web.REPORTS_CLIENT_SEARCH, ReportController.serveSearchClientPage);
        post(   Path.Web.REPORTS_CLIENT_VIEW,   ReportController.serveViewClientPage);



        get("*",                     ViewUtil.notFound);
        //Set up after-filters (called after each get/post)
        after("*",                   Filters.addGzipHeader);

    }

}
