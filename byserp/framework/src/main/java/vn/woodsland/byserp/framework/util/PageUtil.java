package vn.woodsland.byserp.framework.util;

import vn.woodsland.byserp.framework.constant.CommonConstant;

public class PageUtil {


    private PageUtil() {
    }

    public static final int getOffsetPage(Integer offsetPage) {
        if (offsetPage == null)
            return CommonConstant.PAGING.PAGE_OFFSET_DEFAULT;
        return offsetPage;
    }


}
