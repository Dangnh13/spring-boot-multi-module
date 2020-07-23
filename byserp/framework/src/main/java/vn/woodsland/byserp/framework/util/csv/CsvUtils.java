package vn.woodsland.byserp.framework.util.csv;

import vn.woodsland.byserp.framework.util.csv.core.CsvBean;
import vn.woodsland.byserp.framework.util.csv.core.CsvSerializeStrategy;

/**
 * General CSV file manipulation utilities.
 */
public class CsvUtils {

	private CsvUtils() {
	}

	/**
	 * Get strategy with that you want
	 *
	 * @param serializeStrategy type of serialize strategy
	 * @param csvBean           bean
	 * @param <S>               which extends of CsvSerializeStrategy
	 * @param <T>               which extends CsvBean
	 * @return csv serialize strategy
	 * @throws Exception when get constructor
	 */
	public static <S extends CsvSerializeStrategy, T extends CsvBean> CsvSerializeStrategy getCsvSerializeStrategy(Class<S> serializeStrategy,
	                                                                                                               Class<T> csvBean) throws Exception {
		return serializeStrategy.getConstructor(csvBean.getClass()).newInstance(csvBean);
	}

}
