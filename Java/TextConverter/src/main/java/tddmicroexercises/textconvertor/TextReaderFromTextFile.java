package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class TextReaderFromTextFile implements TextReader{

    private final String fileName;

    public TextReaderFromTextFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public Reader getTextReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader(getFileName()));
    }



}
