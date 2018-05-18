package app.receipt;

import app.login.*;
import app.util.*;
import app.receipt.*;
import spark.*;
import java.util.*;

import static app.Application.*;
import static app.util.JsonUtil.*;
import static app.util.RequestUtil.*;

public class ReceiptController {

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
        //request params
        String name = request.queryParams("name");
        String email = request.queryParams("email");
        String services_raw = request.queryParams("services[]");
        // end
        //parsing + vars we need
        String[] services = services_raw.split(",");
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        double total = 0;
        for(String s : services)
        {
            app.service.Service temp = serviceDao.getServiceById(Integer.parseInt(s));
            total += temp.getPrice();
            System.out.println(temp.getName() + "----" + temp.getPrice());
        }
        //end

        Receipt new_receipt = new Receipt();
        new_receipt.customer_name = name;
        new_receipt.customer_email = email;
        new_receipt.price = total;
        new_receipt.entry_date = date;

        receiptDao.storeReceipt(new_receipt);
        System.out.println("worked");




        Map<String, Object> model = new HashMap<>();
        model.put("services", serviceDao.getAllServices());

        return ViewUtil.render(request, model, Path.Template.RECEIPTS_ADD);
    };
}
