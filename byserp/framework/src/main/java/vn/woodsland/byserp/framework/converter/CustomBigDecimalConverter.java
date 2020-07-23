package vn.woodsland.byserp.framework.converter;

import org.apache.commons.beanutils.Converter;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public final class CustomBigDecimalConverter implements Converter {

    @SuppressWarnings("rawtypes")
    public Object convert(Class type, Object value) {
        if (value == null) {
            return null;
        } else if (value instanceof BigDecimal) {
            if (StringUtils.isNotBlank(value.toString())) {
                return (new BigDecimal(value.toString()));
            } else {
                return null;
            }
        } else {
            return (new BigDecimal(value.toString()));
        }
    }

}
