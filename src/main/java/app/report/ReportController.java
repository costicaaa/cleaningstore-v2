package app.report;


import app.item.Item;
import app.login.LoginController;
import app.receipt.Receipt;
import app.service.Service;
import app.user.User;
import app.util.Path;
import app.util.ViewUtil;
import spark.Request;
import spark.Response;
import spark.Route;

import java.sql.Array;
import java.util.*;

import static app.Application.*;

public class ReportController {
    public static Route serveReportsMonthlyPage = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        LoginController.ensureUserIsAdmin(request, response);
        Map<String, Object> model = new HashMap<>();

        Calendar now = Calendar.getInstance();
// service_id => number of items
        List<Item> items = itemDao.getAllItemsCleanedMonth(now.get(Calendar.MONTH) + 1);
        Map<String, Double> final_map = new HashMap<String, Double>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Item item : items)
        {
            if(!map.containsKey(item.service_id))
            {
                map.put(item.service_id, 1);
            }
            else
            {
                map.put(item.service_id, map.get(item.service_id) + 1);
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Integer service_id = Integer.parseInt(pair.getKey().toString());
            Double number_bought = Double.parseDouble(pair.getValue().toString());
            Service s = serviceDao.getServiceById(service_id);
            final_map.put(s.getName(), s.getPrice() * number_bought);
            it.remove(); // avoids a ConcurrentModificationException
        }

        model.put("data", final_map);

        return ViewUtil.render(request, model, Path.Template.REPORTS_MONTHLY);
    };

    public static Route serveSearchClientPage = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        LoginController.ensureUserIsAdmin(request, response);
        Map<String, Object> model = new HashMap<>();

        return ViewUtil.render(request, model, Path.Template.REPORTS_CLIENT_SEARCH);
    };

    public static Route serveViewClientPage = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);
        LoginController.ensureUserIsAdmin(request, response);
        Map<String, Object> model = new HashMap<>();
        List<Receipt> receipts = receiptDao.getAllReceiptsForClient(request.queryParams("email"));
        for(Receipt r : receipts)
        {
            r.setAssignedItems(receiptDao.getItemsForReceipt(r.getId()));
        }
        model.put("receipts", receipts);
        model.put("client", request.queryParams("email"));


        return ViewUtil.render(request, model, Path.Template.REPORTS_CLIENT_VIEW);
    };

}
