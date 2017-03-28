package ru.borisdev;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by bshestakov on 27.03.2017.
 */
public class StringFileName {
    private final String resFolder;
    private final String header;
    private final Map<String, String> content;

    public StringFileName(String resFolder, String header, Map<String, String> content) {
        this.resFolder = resFolder;
        this.header = header;
        this.content = content;
    }

    public void create() throws IOException {
        FileUtils.forceMkdir(new File(resFolder + "/" + header));
        File file = new File(resFolder + "/" + header + "/strings.xml");
        List<String> list = new ArrayList<>();
        list.add("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        list.add("<resources>");
        List<String> collect = content.keySet().stream()
                .map(k -> createString(k, content.get(k)))
                .collect(Collectors.toList());
        list.addAll(collect);
        list.add("</resources>");
        FileUtils.writeLines(file, list);
    }

    private String createString(String k, String s) {
        return "<string name = \"" + k + "\">" + s + "</string>";
    }

}
