package vn.woodsland.byserp.framework.util;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.*;
import vn.woodsland.byserp.framework.converter.CustomBigDecimalConverter;

import java.math.BigDecimal;

/**
 * General bean manipulation utilities.
 */
public class BeanUtil {

    private static BeanUtilsBean buNative;

    static {
        buNative = new BeanUtilsBean(new ConvertUtilsBean(), BeanUtilsBean.getInstance().getPropertyUtils());
        buNative.getConvertUtils().register(new LongConverter(null), Long.class);
        buNative.getConvertUtils().register(new IntegerConverter(null), Integer.class);
        buNative.getConvertUtils().register(new ShortConverter(null), Short.class);
        buNative.getConvertUtils().register(new FloatConverter(null), Float.class);
        buNative.getConvertUtils().register(new DoubleConverter(null), Double.class);
        buNative.getConvertUtils().register(new CustomBigDecimalConverter(), BigDecimal.class);
    }

    private BeanUtil() {
    }

    /**
     * Copy property values from the "origin" bean to the "destination" bean
     *
     * @param source origin bean
     * @param target destination bean
     */
    public static void copyProperties(Object source, Object target) {
        try {
            buNative.copyProperties(target, source);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Create "destination" bean and Copy property values from the "origin" bean
     *
     * @param source origin bean
     * @param c      type of destination bean
     * @param <T>    type of destination bean
     * @return new instance of destination bean after copy property values from the "origin" bean
     */
    public static <T> T createAndCopyProperties(Object source, Class<T> c) {
        T target = null;
        try {
            target = c.newInstance();
            buNative.copyProperties(target, source);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return target;
    }

}