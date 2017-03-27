package ru.borisdev;

import java.util.List;

/**
 * Created by bshestakov on 27.03.2017.
 */
public class AndroidStringTable {
    private List<AndroidStringColumn> columns;

    public AndroidStringTable(String csvContent) {
    }

    public List<AndroidStringColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<AndroidStringColumn> columns) {
        this.columns = columns;
    }
}
