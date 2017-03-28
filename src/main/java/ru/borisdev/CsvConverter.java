package ru.borisdev;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class CsvConverter {
    private static final Logger log = LoggerFactory.getLogger(CsvConverter.class);

    private final String csvFile;
    private final String resFolder;

    public CsvConverter(String csvFile, String resFolder) {
        this.csvFile = csvFile;
        this.resFolder = resFolder;
    }

    public void convert() {
        try {
            AndroidStringTable androidStringTable = new AndroidStringTable(FileUtils.readLines(new File(csvFile), Charset.forName("UTF-8")));
            List<AndroidStringColumn> androidStringColumnList = androidStringTable.getColumns();
            for (AndroidStringColumn androidStringColumn : androidStringColumnList) {
                new StringFileName(
                        resFolder,
                        androidStringColumn.header(),
                        androidStringColumn.content())
                        .create();
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
