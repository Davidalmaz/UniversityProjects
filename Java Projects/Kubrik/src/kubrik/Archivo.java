package kubrik;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Archivo {
    private final Path inputFilePath, outputFilePath;
    private Kubrik k;
    
    public Archivo(final String inputName, final String outputName, final String dir) {
        inputFilePath  = FileSystems.getDefault().getPath(dir, inputName);
        outputFilePath = FileSystems.getDefault().getPath(dir, outputName);
    }
    
    private boolean isLineEmpty(final String line) {
        return line.isEmpty() || line.trim().isEmpty();
    }
    
    private short checkForBlankLines(Scanner scanner) throws IOException {
        if (!scanner.hasNextShort())
            throw new IOException("No se encontraron números en el archivo");
  
        return scanner.nextShort();
    }
    
    public void readFile() throws NoSuchElementException, Exception {
        Scanner scanner = new Scanner(inputFilePath);
        
        ArrayList<Byte> configuraciónFinal = new ArrayList<>();
        
        while(scanner.hasNextByte())
            configuraciónFinal.add(scanner.nextByte());
        
        k = new Kubrik(configuraciónFinal);
        
        scanner.close();
    }
    
    public void writeFile() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(outputFilePath, Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        writer.write(k.getSolución() + System.getProperty("line.separator"));
        writer.close();
        
    }
    
    public final Kubrik getKubrik() {
        return k;
    }
    
    public final Path getInputFilePath() {
         return inputFilePath;
    }
     
    public final Path getOutputFilePath() {
         return outputFilePath;
    }
}
