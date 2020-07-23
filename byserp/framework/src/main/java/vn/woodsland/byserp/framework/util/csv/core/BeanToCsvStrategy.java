package vn.woodsland.byserp.framework.util.csv.core;

import com.opencsv.CSVWriter;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.List;

@Slf4j
public class BeanToCsvStrategy<T extends CsvBean> implements CsvSerializeStrategy<T> {

    private boolean throwExceptions;

    private Class<T> type;

    public BeanToCsvStrategy(Class<T> type) {
        this.type = type;
        this.throwExceptions = true;
    }

    @Override
    public File write(String fileName, List<T> beans) throws Exception {
        return writeWithEncoding(fileName, beans, 0);
    }

    @Override
    public File writeWithEncoding(String fileName, List<T> beans, int encoding) throws Exception {
        try (OutputStream os = new FileOutputStream(fileName);) {

            if (encoding == 0) {
                os.write(239);
                os.write(187);
                os.write(191);
            }
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, getEncoding(encoding)));
            CustomColumnPositionMappingStrategy<T> columnPositionMappingStrategy = new CustomColumnPositionMappingStrategy();
            columnPositionMappingStrategy.setType(type);
            CustomStatefulBeanToCsv<T> sbc = this.buildCustomStatefulBeanToCsv(writer, columnPositionMappingStrategy);
            sbc.write(beans);
            writer.close();

            File localCsvFile = new File(fileName);
            if (!localCsvFile.exists()) {
                log.error("SAVE CSV TO TEMP DIRECTORY NOT SUCCESS");
                throw new Exception("File not found, Create csv failed!");
            }
            log.info("SAVE CSV TO TEMP DIRECTORY SUCCESS: {} size: {}", localCsvFile.length());
            return localCsvFile;
        }
    }

    private String getEncoding(int encoding) {
        return encoding == 0 ? "UTF-8" : "Shift-JIS";
    }

    private CustomStatefulBeanToCsv<T> buildCustomStatefulBeanToCsv(PrintWriter writer,
                                                                    CustomColumnPositionMappingStrategy<T> columnPositionMappingStrategy) {
        return new CustomStatefulBeanToCsv<>(CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END, columnPositionMappingStrategy,
                CSVWriter.DEFAULT_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_SEPARATOR,
                throwExceptions,
                writer);
    }
}
