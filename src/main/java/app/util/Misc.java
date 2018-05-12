package app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import static app.util.JsonUtil.dataToJson;

public class Misc {

    public static Integer STATUS_ITEM_DIRTY = 0;
    public static String  salt  = "rgbmiesdo453t8A#%drvfseopr";

    public static String formatDate(Date date)
    {
        SimpleDateFormat mdyFormat = new SimpleDateFormat("yyyy-MM-dd");
        return mdyFormat.format(date);
    }

    public static String objectToJson(Object x)
    {
        return dataToJson(x);
    }

}
