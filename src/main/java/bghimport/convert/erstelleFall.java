package bghimport.convert;
import java.io.IOException;

public class erstelleFall {
	
	public Fall getnewFall(String dateipfad) throws IOException{
		
	PDFManager pdfManager = new PDFManager();
    pdfManager.setFilePath(dateipfad);//D:\\Profile\\ksx\\Eigene Dateien\\SWE2\\Test2.pdf
    String s=pdfManager.ToText();
    //System.out.println(s);
   
    
    Fall f= new Fall();
    int index1;// Hielfsvariabel zum durchsuchen des Strings
    int index2;// Hielfsvariabel zum durchsuchen des Strings
    String z="";// Hielfsvariabel zum durchsuchen des Strings
    
    if (s.contains( "IM NAMEN DES VOLKES" )){ // mir sind zwei Typen von rechts PDFs aufgefallen, 
 	   										//vieleicht gibt es mehr, es w�re nicht schlecht wenn 
 	   										//man einen h�tte der sich damit auskennt...
	       //Aktenzeichen
	       
	       index1 = s.indexOf( "URTEIL" );
	       index2 = s.indexOf( "Verk�ndet" );
	       
	       z=s.substring( index1 + 7, index2-1 );
	       
	       f.setAktenzeichen(z);
	       
	       //Datum
	       index1 = s.indexOf( "Verk�ndet am:" );
	       z=s.substring( index1 + 15 );
	       
	       index2 = z.indexOf( "\n"  );
	       z=z.substring(0,index2 );
	      
	       f.setDatum(z);
	       f.setUeberschrift("BUNDESGERICHTSHOF IM NAMEN DES VOLKES URTEIL");
	       
    } 
    
    else if(s.contains( "BESCHLUSS" )){
 	 //Aktenzeichen
	       
	       index1 = s.indexOf( "BESCHLUSS" );
	       index2 = s.indexOf( "vom" );
	      
	       z=s.substring( index1 + 10, index2-1 );
	       f.setAktenzeichen(z);
 	   
	     //Datum
	       index1 = s.indexOf( "vom" );
	       z=s.substring( index1 + 5 );
	       
	       index2 = z.indexOf( "\n"  );
	       z=z.substring(0,index2 );
	       f.setDatum(z);
	       f.setUeberschrift("BUNDESGERICHTSHOF BESCHLUSS");
	       
    }
    
    
    // Verhandlungsbestand --> Unterueberschrift
    // Bereich (z.B. Zivil Recht, Strafrecht) // musste von einem Rechtsexperten gepr�ft werden
    if(s.contains( "in dem Rechtsstreit" )){
 	   f.setUnterueberschrift("in dem Rechtsstreit");
 	   f.setRechtsBereich("Zivil Recht");
 	 
 	   // es gibt kein vergehen
 	   
 	 //strafma� --> beschlossen:
 	   z= strafma�Ausgeben(s);
	       f.setStrafma�(z);
 	   
    }
    else if(s.contains( "in der Strafsache" )){
 	   f.setUnterueberschrift("in der Strafsache");
 	   f.setRechtsBereich("Strafrecht");
 	   
 	   // Vergehen
    	   z=VergehenAusgeben(s);
 	   f.setVergehen(z);
 	   
	       //strafma� --> beschlossen:
	       z= strafma�Ausgeben(s);
	       f.setStrafma�(z);
    }
    else if(s.contains( "in der Landwirtschaftssache" )){
 	   f.setUnterueberschrift("in der Landwirtschaftssache");
 	   f.setRechtsBereich("Zivil Recht"); //// Oder �ffentliches Recht keine Ahnung!
 	   
 	   // es gibt kein vergehen gfunden
 	   
 	 //strafma� --> beschlossen:
 	   z= strafma�Ausgeben(s);
	       f.setStrafma�(z);
 	   
    }
    else if(s.contains( "in der Familiensache" )){ //17768_xii_zb__28-00
 	   f.setUnterueberschrift("in der Familiensache");
 	   f.setRechtsBereich("Zivil Recht");
 	   
 	 //strafma� --> beschlossen:
 	   z= strafma�Ausgeben(s);
	       f.setStrafma�(z);
    }
    else if(s.contains( "in dem Verfahren" )){ //17776_anwz_(b)__51-00
 	   f.setUnterueberschrift("in dem Verfahren");
 	   f.setRechtsBereich("Zivil Recht"); /// keine Ahnung 
 	   
 	// Vergehen
    	   z=VergehenAusgeben(s);
 	   f.setVergehen(z);
 	   
	       //strafma� --> beschlossen:
	       z= strafma�Ausgeben(s);
	       f.setStrafma�(z);

 	   
 	 //strafma� --> beschlossen:
 	   z= strafma�Ausgeben(s);
	       f.setStrafma�(z);
    }
    else if(s.contains( "in dem Entsch�digungsrechtsstreit" )){ //17786_ix_zb__64-01
 	   f.setUnterueberschrift("in dem Entsch�digungsrechtsstreit");
 	   f.setRechtsBereich("Zivil Recht");
 	   
 	 //strafma� --> beschlossen:
 	   z= strafma�Ausgeben(s);
	       f.setStrafma�(z);
    }
    
    
    //System.out.println(f.Ausgabe());
    
    return f;
    
}  
 
 public static String strafma�Ausgeben(String s){ // sucht das strafma� bzw. den beschluss und gibt ihn zur�ck
 	//strafma� --> beschlossen:
	       int index1 = s.indexOf( "beschlossen:" );
	       int index2 = s.indexOf( "Gr�nde:" );
	       if (index2==-1) {
	    	   index2 = s.indexOf("G r � n d e :"); // vieleicht falch geschrieben
	    	   if (index2==-1) { // nicht vorhanden --> bis ende des Dokuments augeben
		    	   index2=s.length();
		       }
	       }
	      
	    	   
	       String z=s.substring( index1, index2 );
	       return z;
 	
 }
 
 public static String VergehenAusgeben (String s){
 	 // Vergehen
	       int index1 = s.indexOf( "wegen" );
	       String z=s.substring( index1 );
	       int index2 = z.indexOf( "\n" );      
	       z=z.substring( 0, index2 );
 	
 	 return z;
 }
}
