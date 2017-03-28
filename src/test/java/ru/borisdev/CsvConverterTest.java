package ru.borisdev;

import org.junit.Test;

/**
 * Created by bshestakov on 28.03.2017.
 */
public class CsvConverterTest {

    @Test
    public void convert() {
        new CsvConverter("C:\\test\\convertfrom\\strings - Sheet2.tsv", "C:/test/convert").convert();

    }

}
