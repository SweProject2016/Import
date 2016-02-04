package bghimport.bgh;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class BghProvider {
    private static final String MIME_PDF = "application/pdf";
    private static final String BGH_FILE_URL = "http://juris.bundesgerichtshof.de/cgi-bin/rechtsprechung/document.py?Gericht=bgh&nr=%d&Frame=0";

    /**
     * Speichert das PDF-Dokument der BGH-Seite mit der gegebenen Id im angegebenen Pfad. Der resultierende Dateiname folgt dann diesem Schema: {@code <id>_<filename>.pdf}
     *
     * @param id
     *            Id des zu speichernden Dokuments
     * @param path
     *            Pfad, in dem gespeichert werden soll.
     * @throws IOException
     */
    public static void download(final int id, final Path path) throws IOException {
        // TODO: besseres Logging, Code aufschlüsseln
        final URL url = new URL(String.format(BghProvider.BGH_FILE_URL, id));
        final URLConnection con = url.openConnection();

        if (con.getContentType().equals(BghProvider.MIME_PDF)) {
            // TODO: fileName-Parsing solider machen
            final String fileName = con.getHeaderField("Content-Disposition").replace("inline; ", "").replace("filename=", "").replace("?", "_");

            if (fileName.startsWith("PM_")) {
                System.out.print("! " + id + " " + fileName);
                return; // Pressemitteilungen herausfiltern
            }

            System.out.print(id + " " + fileName);
            try (InputStream in = con.getInputStream()) {
                Files.copy(in, Paths.get(path.toString(), id + "_" + fileName), StandardCopyOption.REPLACE_EXISTING);
                System.out.println(" OK");
            } catch (IOException e) {
                System.out.println(" ERROR");
            }
        } else {
            System.out.println("! " + id);
        }
    }
}
