package app.receipt;

import app.book.Book;
import app.login.*;
import app.util.*;
import app.receipt.*;
import spark.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static app.Application.*;
import static app.util.JsonUtil.*;
import static app.util.RequestUtil.*;
import app.item.*;

public class ReceiptController {

    public static Route serveIndexPage = (Request request, Response response) -> {
        Map<String, Object> model = new HashMap<>();

        List<Receipt> receipts = receiptDao.getAllReceipts();
        model.put("receipts", receipts);

        return ViewUtil.render(request, model, Path.Template.RECEIPTS);
    };

    public static Route serveViewPage = (Request request, Response response) -> {
        HashMap<String, Object> model = new HashMap<>();

        Receipt receipt = receiptDao.getReceiptById(getParamId(request));
        model.put("receipt", receipt);

        return ViewUtil.render(request, model, Path.Template.RECEIPTS_VIEW);
    };

    public static Route cleanItem = (Request request, Response response) -> {
        Item item = itemDao.updateCleanStatus(getParamId(request));
        response.redirect(Path.Web.RECEIPTS + item.getReceipt_id() + "/");
        return null;
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
        }
        //end

        Receipt new_receipt = new Receipt();
        new_receipt.customer_name = name;
        new_receipt.customer_email = email;
        new_receipt.price = total;
        new_receipt.entry_date = date;
        receiptDao.store(new_receipt);
        System.out.println("new receipt id ==== " + new_receipt.getId());

        for(String s : services)
        {
            Item tempItem = new Item();
            tempItem.setReceipt_id(new_receipt.getId());
            tempItem.setService_id(Integer.parseInt(s));
            itemDao.store(tempItem);
        }
        Map<String, Object> model = new HashMap<>();
        model.put("services", serviceDao.getAllServices());

        return ViewUtil.render(request, model, Path.Template.RECEIPTS_ADD);
    };
}
