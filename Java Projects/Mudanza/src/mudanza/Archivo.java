package mudanza;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class Archivo {
    private final Path inputFilePath, outputFilePath;
    private Mudanza mudanza;
    
    public Archivo(final String inputName, final String outputName, final String dir) {
        inputFilePath  = FileSystems.getDefault().getPath(dir, inputName);
        outputFilePath = FileSystems.getDefault().getPath(dir, outputName);
        //readFile();
    }
    
    private boolean isLineEmpty(final String line) {
        return line.isEmpty() || line.trim().isEmpty();
    }
    
    private String trimFile(BufferedReader reader) throws IOException {
        String check = null;
        //try {
            check = reader.readLine();
            if (check == null)
                throw new IOException("Archivo vacío");
            
            for (; check != null && isLineEmpty(check); check = reader.readLine());
            
            if (check == null)
                throw new IOException("Archivo vacío");
            
        /*}
        catch(IOException exception) {
            exception.printStackTrace();
        }*/
        return check;
    }
    
    public void readFile() throws Exception {
        //try {
            BufferedReader reader = Files.newBufferedReader(inputFilePath, Charset.defaultCharset());
            
            short n = Short.parseShort(trimFile(reader));
            
            ArrayList<Pertenencia> p = new ArrayList<>(n);
            
            for(String line = ""; (line = reader.readLine()) != null; ) {
                if (isLineEmpty(line))
                    continue;
                p.add(new Pertenencia(Short.parseShort(line)));
            }
            
            mudanza = new Mudanza(n, p);
            
            
             
        /*}
        catch(final NumberFormatException exception) {
            System.err.println("Sólo números en el archivo de entrada");
        }
        catch(final IOException exception) {
            exception.printStackTrace();
        }*/
        
    }
    
    public void writeFile() throws IOException {
        //try {
            //mudanza.distributeBelongings();
            
            BufferedWriter writer = Files.newBufferedWriter(outputFilePath, Charset.defaultCharset(), StandardOpenOption.APPEND);
            
            /*Camión c1 = mudanza.getCamión((byte)1),
                   c2 = mudanza.getCamión((byte)2);
            
            writer.write(c1.getPeso() + " " + c2.getPeso() + "\n");*/
            writer.write(mudanza.distributeBelongings() + System.getProperty("line.separator"));
            writer.close();
        /*}
        catch(final IOException exception) {
            exception.printStackTrace();
        }*/
        
    }
    
    public final Mudanza getMudanza() {
        return mudanza;
    }
     
    public final Path getInputFilePath() {
         return inputFilePath;
    }
     
    public final Path getOutputFilePath() {
         return outputFilePath;
    }
}
