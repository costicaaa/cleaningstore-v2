package app.ticket;

import app.util.*;
import spark.*;
import java.util.*;
import static app.Application.*;
import app.service.ServiceDao;

public class TicketController {
    public static Route serveIndexPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        //model.put("users", userDao.getAllUserNames());
        model.put("book", bookDao.getRandomBook());
        return ViewUtil.render(request, model, Path.Template.TICKETS);
    };

    public static Route serveAddPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("services", serviceDao.getAllServices());

        return ViewUtil.render(request, model, Path.Template.TICKETS_ADD);
    };
}
