package bghimport;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import bghimport.convert.Fall;
import bghimport.convert.FallParser;

public class ConvertMain {

    public static void main(final String[] args) throws IOException {
        // TODO: bessere Parameter-Verwaltung
        try {
            // TODO: mehrere Dateien als Parameter. Oder Ordner.
            Path path = Paths.get(args[0]);
            Fall f = FallParser.getFromPdf(path);
            System.out.println(f == null ? "Fehler" : f);
        } catch (ArrayIndexOutOfBoundsException | InvalidPathException e) {
            System.out.println("Usage: bgh-convert.jar <pdf-file>");
        }
    }

}