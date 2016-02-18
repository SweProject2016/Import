package bghimport.convert;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFManager {

    private PDFParser parser;
    private PDFTextStripper pdfStripper;
    private PDDocument pdDoc;
    private COSDocument cosDoc;

    private String Text;
    private String filePath;
    private File file;

    public PDFManager() {

    }

    public String ToText() throws IOException {
        this.pdfStripper = null;
        this.pdDoc = null;
        this.cosDoc = null;

        this.file = new File(this.filePath);
        this.parser = new PDFParser(new RandomAccessFile(this.file, "r")); // update for PDFBox V 2.0

        this.parser.parse();
        this.cosDoc = this.parser.getDocument();
        this.pdfStripper = new PDFTextStripper();
        this.pdDoc = new PDDocument(this.cosDoc);
        this.pdDoc.getNumberOfPages();
        this.pdfStripper.setStartPage(1);
        this.pdfStripper.setEndPage(10);

        // reading text from page 1 to 10
        // if you want to get text from full pdf file use this code
        // pdfStripper.setEndPage(pdDoc.getNumberOfPages());

        this.Text = this.pdfStripper.getText(this.pdDoc);
        return this.Text;
    }

    public void setFilePath(final String filePath) {
        this.filePath = filePath;
    }

}