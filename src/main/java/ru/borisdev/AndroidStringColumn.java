package ru.borisdev;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bshestakov on 27.03.2017.
 */
public class AndroidStringColumn {

    private String header;
    private Map<String, String> content;

    public AndroidStringColumn(String header) {
        this.header = header;
    }

    public String header() {
        return header;
    }

    public Map<String, String> content() {
        if (content == null)
            content = new HashMap<>();
        return content;
    }
}
