package app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Misc {

    public static String formatDate(Date date)
    {
        SimpleDateFormat mdyFormat = new SimpleDateFormat("yyyy-MM-dd");
        return mdyFormat.format(date);
    }

}
