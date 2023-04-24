package tddmicroexercises.textconvertor;

import java.io.BufferedReader;

/*
    DIP: Dependency Inversion Principle violated fix,
    the HtmlTextConverter was dependent of read text of a file and should be dependent of Abstraction

    OCP: Open Closed Principle violated fixed,
    The HtmlTextConverter would be changed if it's necessary to implement more sources of text not only file text
*/
public class HtmlTextConverter
{
    private final TextReader source;

	public HtmlTextConverter(TextReader source) {
		this.source = source;
	}

	public TextReader getSource() {
		return source;
	}

	public String convertToHtml() throws Exception {
    
	    BufferedReader reader = new BufferedReader(getSource().getTextReader());
	    
	    String line = reader.readLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += StringEscapeUtils.escapeHtml(line);
	        html += "<br />";
	        line = reader.readLine();
	    }
	    return html;

    }
}
