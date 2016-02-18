package bghimport.convert;

import java.io.IOException;

public class JavaPDFTest {

    public static void main(final String[] args) throws IOException {
        Fall f;
        erstelleFall erstelle = new erstelleFall();
        f = erstelle.getnewFall("D:\\SWE BGH Dokumente\\17786_ix_zb__64-01.pdf");
        System.out.println(f.Ausgabe());
    }

}