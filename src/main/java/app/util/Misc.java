package app.util;

import com.google.common.hash.Hashing;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static app.util.JsonUtil.dataToJson;
import lombok.*;
public class Misc {

    @Getter public static final  Integer STATUS_ITEM_DIRTY = 0;
    @Getter public static final  Integer USER_ROLE_ADMIN = 1;
    @Getter public static final  Integer USER_ROLE_EMPLOYEE = 2;

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
