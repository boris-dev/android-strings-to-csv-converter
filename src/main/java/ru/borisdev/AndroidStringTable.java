package ru.borisdev;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bshestakov on 27.03.2017.
 */
public class AndroidStringTable {
    private final List<String> csvContent;

    public AndroidStringTable(List<String> csvContent) {
        this.csvContent = csvContent;
    }

    public List<AndroidStringColumn> getColumns() {
        List<AndroidStringColumn> columns = new ArrayList<>();

        for (int i = 0; i < csvContent.size(); i++) {
            String[] row = csvContent.get(i).split("\t");
            for (int j = 1; j < row.length; j++) {
                if (i == 0) {
                    columns.add(new AndroidStringColumn(row[j]));
                } else {
                    if (columns.size() > j - 1) {
                        AndroidStringColumn androidStringColumn = columns.get(j - 1);
                        androidStringColumn.content().put(row[0], row[j]);
                    }
                }
            }
        }

        return columns;
    }

}
