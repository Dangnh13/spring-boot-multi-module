package vn.woodsland.byserp.framework.util;

public class RequestUtil {
    private static final String API_CONTEXT_PATH = "/auth";

    private RequestUtil() {
    }

    public static String getStandardUriOf(String uri) {
        return API_CONTEXT_PATH + uri;
    }
}
