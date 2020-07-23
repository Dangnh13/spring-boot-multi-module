package vn.woodsland.byserp.web.controller;

import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

    protected String redirect(String requestMapping) {
        return "redirect:" + requestMapping;
    }

    protected void saveRequestData(HttpServletRequest request, Object data) {
        String clazzName = data.getClass().getSimpleName();
        String key = clazzName.substring(0, 3).toLowerCase() + clazzName.substring(3);
        FlashMap flashMap = RequestContextUtils.getOutputFlashMap(request);
        flashMap.put(key, data);
    }
}
