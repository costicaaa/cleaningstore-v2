package app.util;

import com.google.common.hash.Hashing;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static app.util.JsonUtil.dataToJson;

public class Misc {

    public static Integer STATUS_ITEM_DIRTY = 0;
    public static Integer USER_ROLE_ADMIN = 1;
    public static Integer USER_ROLE_EMPLOYEE = 2;
    public static String  salt  = "$2y$10$9LIvdTW1CO8Nxy9Zc8l.eOaGI1hGFbW63u.CBYorwvrJQtVTEazzy";

    public static String formatDate(Date date)
    {
        SimpleDateFormat mdyFormat = new SimpleDateFormat("yyyy-MM-dd");
        return mdyFormat.format(date);
    }

    public static String objectToJson(Object x)
    {
        return dataToJson(x);
    }

    public static String hashPW(String pass)
    {
        return  Hashing.sha256()
                .hashString(pass, StandardCharsets.UTF_8)
                .toString();

    }

}
