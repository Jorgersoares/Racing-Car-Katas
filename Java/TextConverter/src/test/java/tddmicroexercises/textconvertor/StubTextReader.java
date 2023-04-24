package tddmicroexercises.textconvertor;

import java.io.Reader;
import java.io.StringReader;

public class StubTextReader implements TextReader {

    private final String text;

    public StubTextReader(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public Reader getTextReader() {
        return new StringReader(getText());
    }
}
