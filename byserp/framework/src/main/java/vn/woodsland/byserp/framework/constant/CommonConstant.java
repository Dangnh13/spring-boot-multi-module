package vn.woodsland.byserp.framework.constant;

/**
 * Global constants
 */
public class CommonConstant {

    public static final String RESOURCE_BUNDLE_COMMON = "messages";

    public interface MODEL_ATTRIBUTE {
        String STATUS_CODE = "statusCode";
        String STACK_TRACE = "stackTrace";
    }

    public interface FILE_EXTENSION {
        String CSV = ".csv";
        String DAT = ".dat";
    }

    public interface SYMBOL {

        String SLASH_SYMBOL = "/";

        String TILDE_SYMBOL = "~";

        String BACK_SLASH = "\\";

        String MINUS_SYMBOL = "-";

        String DOT_SYMBOL = ".";

        String COMMA_SYMBOL = ",";
    }

    public interface DATE_FORMAT {

        String YYYY_MM_DD = "yyyy/MM/dd";

        String DD_MM_YYYY = "dd/MM/yyyy";

        String YYYY_MM_DD_HH_MM = "yyyyMMddHHmm";
        String YYYY_MM_DD_HH_MM_SLASH = "yyyy/MM/dd HH:mm";
        String DD_MM_YYYY_HH_MM_SLASH = "dd/MM/yyyy HH:mm";
        String HH_MM = "HHmm";
    }

    public interface MAIL_TEMPLATE {
        String SIMPLE_TEXT = "simple_text_template.ftl";
    }

    public interface PAGING {
        int GET_ALL = 0;
        int PAGE_SIZE = 10;
        int PAGE_OFFSET_DEFAULT = 0;
    }
}
