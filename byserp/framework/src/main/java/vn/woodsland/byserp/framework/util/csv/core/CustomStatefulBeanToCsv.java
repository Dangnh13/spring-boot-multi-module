package vn.woodsland.byserp.framework.util.csv.core;

import com.opencsv.CSVWriter;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.commons.collections.CollectionUtils;

import java.io.Writer;
import java.util.List;

public class CustomStatefulBeanToCsv<T extends CsvBean> extends StatefulBeanToCsv<T> {

	private char escapechar;
	private String lineEnd;
	private MappingStrategy<T> mappingStrategy;
	private char quotechar;
	private char separator;
	private Writer writer;

	public CustomStatefulBeanToCsv(char escapechar, String lineEnd, MappingStrategy<T> mappingStrategy, char quotechar, char separator, boolean throwExceptions, Writer writer) {
		super(escapechar, lineEnd, mappingStrategy, quotechar, separator, throwExceptions, writer);
		this.escapechar = escapechar;
		this.lineEnd = lineEnd;
		this.mappingStrategy = mappingStrategy;
		this.quotechar = quotechar;
		this.separator = separator;
		this.writer = writer;
	}

	private void beforeFirstWrite() {
		// Build CSVWriter
		CSVWriter csvwriter = new CSVWriter(writer, separator, quotechar, escapechar, lineEnd);

		// Write the header
		String[] header = mappingStrategy.generateHeader();
		if (header.length > 0) {
			csvwriter.writeNext(header);
		}
	}

	@Override
	public void write(List<T> beans) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		if (CollectionUtils.isEmpty(beans)) {
			this.beforeFirstWrite();
		} else {
			super.write(beans);
		}
	}
}
