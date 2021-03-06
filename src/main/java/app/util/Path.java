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


        @Getter public static final String REPORTS_MONTHLY = "/reports/monthly/";
        @Getter public static final String REPORTS_CLIENT_SEARCH = "/reports/search/";
        @Getter public static final String REPORTS_CLIENT_VIEW = "/reports/client/";


        @Getter public static final String USERS = "/users/";
        @Getter public static final String USERS_ADD = "/users/add/";
        @Getter public static final String USERS_VIEW = USERS + helperID;
        @Getter public static final String USERS_SAVE = "/users/save/";



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

        public static final String USERS = "/velocity/user/all.vm";
        public static final String USERS_VIEW = "/velocity/user/view.vm";
        public static final String USERS_ADD = "/velocity/user/add.vm";

        public static final String REPORTS_MONTHLY = "/velocity/report/monthly.vm";
        public static final String REPORTS_CLIENT_SEARCH = "/velocity/report/search_by_client.vm";
        public static final String REPORTS_CLIENT_VIEW = "/velocity/report/client_view.vm";

    }

}
