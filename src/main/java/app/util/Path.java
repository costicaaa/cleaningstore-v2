package app.util;

import lombok.*;

public class Path {

    // The @Getter methods are needed in order to access
    // the variables from Velocity Templates
    public static class Web {
        private static String helperID = ":id/";

        @Getter public static final String INDEX = "/index/";
        @Getter public static final String LOGIN = "/login/";
        @Getter public static final String LOGOUT = "/logout/";
        @Getter public static final String BOOKS = "/books/";
        @Getter public static final String ONE_BOOK = "/books/:isbn/";

        @Getter public static final String RECEIPTS = "/receipts/";
        @Getter public static final String RECEIPTS_VIEW = RECEIPTS + helperID;
        @Getter public static final String RECEIPTS_ADD = "/receipts/add/";
        @Getter public static final String RECEIPTS_STORE = "/receipts/store/";
        @Getter public static final String RECEIPTS_CLEAN_ITEM_PATH = "/receipts/clean-item/";
        @Getter public static final String RECEIPTS_CLEAN_ITEM = RECEIPTS_CLEAN_ITEM_PATH + helperID;
        @Getter public static final String RECEIPTS_RETURN_PATH = "/receipts/return/";
        @Getter public static final String RECEIPTS_RETURN = RECEIPTS_RETURN_PATH + helperID;

    }

    public static class Template {
        public final static String INDEX = "/velocity/index/index.vm";
        public final static String LOGIN = "/velocity/login/login.vm";
        public final static String BOOKS_ALL = "/velocity/book/all.vm";
        public static final String BOOKS_ONE = "/velocity/book/one.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";

        public static final String RECEIPTS = "/velocity/receipt/all.vm";
        public static final String RECEIPTS_VIEW = "/velocity/receipt/view.vm";
        public static final String RECEIPTS_ADD = "/velocity/receipt/add.vm";
    }

}
