package tddmicroexercises.textconvertor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HtmlTextConverterTest {

    @Test
    public void shouldConverterTextToHtml() throws Exception {
        TextReader source = new StubTextReader("teste");
        HtmlTextConverter converter = new HtmlTextConverter(source);
        assertEquals("teste<br />", converter.convertToHtml());
    }

    @Test
    public void shouldConverterMultilineTextToHtml() throws Exception {
        TextReader source = new StubTextReader("teste\nOlá");
        HtmlTextConverter converter = new HtmlTextConverter(source);
        assertEquals("teste<br />Olá<br />", converter.convertToHtml());
    }

}
