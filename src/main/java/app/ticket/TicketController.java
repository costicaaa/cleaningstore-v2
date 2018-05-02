package app.ticket;

import app.util.*;
import spark.*;

import java.lang.reflect.Array;
import java.util.*;
import static app.Application.*;
import app.service.ServiceDao;

public class TicketController {
    public static Route serveIndexPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        //model.put("users", userDao.getAllUserNames());
        model.put("book", bookDao.getRandomBook());
        return ViewUtil.render(request, model, Path.Template.RECEIPTS);
    };

    public static Route serveAddPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("services", serviceDao.getAllServices());

        return ViewUtil.render(request, model, Path.Template.RECEIPTS_ADD);
    };

    public static Route storeReceipt = (Request request, Response response) -> {
        String name = request.queryParams("name");
        String email = request.queryParams("email");
        String services_raw = request.queryParams("services[]");
        String[] services = services_raw.split(",");


        for(String a : services)
        {
            System.out.println(a);
        }


        Map<String, Object> model = new HashMap<>();
        model.put("services", serviceDao.getAllServices());

        return ViewUtil.render(request, model, Path.Template.RECEIPTS_ADD);
    };
}
