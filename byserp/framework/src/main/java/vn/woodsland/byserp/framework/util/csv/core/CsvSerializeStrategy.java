package vn.woodsland.byserp.framework.util.csv.core;

import java.io.File;
import java.util.List;

public interface CsvSerializeStrategy<T> {
	File write(String fileName, List<T> beans) throws Exception;

	File writeWithEncoding(String fileName, List<T> beans, int encoding) throws Exception;
}
