package vn.woodsland.byserp.framework.constant;

public class Router {

    public interface EXCEPTION {
        String ROOT = "/exception";

        interface URI {
            String ERROR = EXCEPTION.ROOT + "/ERROR";
            String FORBIDDEN = EXCEPTION.ROOT + "/FORBIDDEN";
            String UNAUTHORIZED = EXCEPTION.ROOT + "/UNAUTHORIZED";
        }
    }

    public interface OAUTH2 {
        interface URI {
            String LOGIN = "/login";
            String LOGOUT = "/logout";
            String PING = "/ping";
            String USER_INFO = "/user/me";
        }

        interface VIEW {
            String LOGIN = "login";
        }
    }

    public interface API {
        interface BRANCH {
            String ROOT = "/branch";
            String CREATE = ROOT + "/create";
            String SEARCH = ROOT + "/search";
            String UPDATE = ROOT + "/update";
        }

        interface USER {
            String ROOT = "/user";
            String CREATE = ROOT + "/create";
            String SEARCH = ROOT + "/search";
            String UPDATE = ROOT + "/update";
        }

        interface REQUEST_TYPE {
            String ROOT = "/request-type";
            String SEARCH = ROOT + "/search";
            String CREATE = ROOT + "/create";
            String UPDATE = ROOT + "/update";
            String DELETE = ROOT + "/delete";
        }

        interface REQUEST_TYPE_DEPARTMENT {
            String ROOT = "/request-type-department";
            String SEARCH = ROOT + "/search";
            String CREATE = ROOT + "/create";
            String UPDATE = ROOT + "/update";
            String DELETE = ROOT + "/delete";
        }

        interface STEP {
            String ROOT = "/step";
            String SEARCH = ROOT + "/search";
            String CREATE = ROOT + "/create";
            String UPDATE = ROOT + "/update";
            String DELETE = ROOT + "/delete";
        }

        interface TIME_OFF_REQUEST {
            String ROOT = "/time-off-request";
            String SEARCH = ROOT + "/search";
        }

        interface PAYMENT_ORDER {
            String ROOT = "/payment-order";
            String SEARCH = ROOT + "/search";
            String SEARCH_APPROVED = ROOT + "/search-approved";
            String SAVE = ROOT + "/save";
            String UPDATE_REQUEST_STATUS = ROOT + "/update-request-status";
            String UPDATE = ROOT + "/update";
        }

        interface REQUEST {
            String ROOT = "/request";
            String UPDATE_REQUEST_STATUS = ROOT + "/update-request-status";
        }

        interface REQUEST_COMMENT {
            String ROOT = "/request-comment";
            String SEARCH = ROOT + "/search";
        }
    }
}
