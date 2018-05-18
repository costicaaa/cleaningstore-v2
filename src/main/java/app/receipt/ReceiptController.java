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
        LoginController.ensureUserIsLoggedIn(request, response);
        Map<String, Object> model = new HashMap<>();

        List<Receipt> receipts = receiptDao.getAllReceipts();
        model.put("receipts", receipts);

        return ViewUtil.render(request, model, Path.Template.RECEIPTS);
    };

    public static Route serveViewPage = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);

        HashMap<String, Object> model = new HashMap<>();

        Receipt receipt = receiptDao.getReceiptById(getParamId(request));
        model.put("receipt", receipt);

        return ViewUtil.render(request, model, Path.Template.RECEIPTS_VIEW);
    };

    public static Route cleanItem = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);

        HashMap<String, Object> model = new HashMap<>();

        try
        {
            Item item = itemDao.updateCleanStatus(getParamId(request));
            Receipt receipt = receiptDao.getReceiptById( item.getReceipt_id());
            model.put("receipt", receipt);
            model.put("showMessage", true);
            model.put("message", "Item status updated!");
            return ViewUtil.render(request, model, Path.Template.RECEIPTS_VIEW);
        }
        catch(Exception e)
        {
            model.put("receipts", receiptDao.getAllReceipts());
            model.put("showMessage", true);
            model.put("message", "Something went terribly wrong, or you are trying to do nasty stuff!");
            return ViewUtil.render(request, model, Path.Template.RECEIPTS);
        }

    };

    public static Route returnReceipt = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);

        HashMap<String, Object> model = new HashMap<>();

        Receipt receipt = receiptDao.getReceiptById(getParamId(request));
        if(receipt.checkIfAllItemsClean())
        {
            receiptDao.returnReceipt(receipt);
            model.put("receipts", receiptDao.getAllReceipts());
            model.put("showMessage", true);
            model.put("message", "Status updated");
            return ViewUtil.render(request, model, Path.Template.RECEIPTS);
        }
        else
        {
            System.out.println("THIAAS SHOULD NEVER HAPPEN, THROW SOME FCKIN ERROR");
            model.put("receipts", receiptDao.getAllReceipts());
            model.put("showMessage", true);
            model.put("message", "Something went terribly wrong, or you are trying to do nasty stuff!");
            return ViewUtil.render(request, model, Path.Template.RECEIPTS);
        }
    };

    public static Route serveAddPage = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);

        Map<String, Object> model = new HashMap<>();
        model.put("services", serviceDao.getAllServices());

        return ViewUtil.render(request, model, Path.Template.RECEIPTS_ADD);
    };

    public static Route storeReceipt = (Request request, Response response) -> {
        LoginController.ensureUserIsLoggedIn(request, response);

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
