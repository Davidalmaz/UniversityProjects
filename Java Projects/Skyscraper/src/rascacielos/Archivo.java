package rascacielos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
    private Centro centro;
    
    public Archivo(final String inputName, final String outputName, final String dir) {
        inputFilePath  = FileSystems.getDefault().getPath(dir, inputName);
        outputFilePath = FileSystems.getDefault().getPath(dir, outputName);
        //readFile();
    }
    
    private boolean isLineEmpty(final String line) {
        return line.isEmpty() || line.trim().isEmpty();
    }
    
    /*private String checkForBlankLines(BufferedReader reader) throws IOException {
        String check = null;
        check = reader.readLine();
        if (check == null)
            throw new IOException("Archivo vacío");
            
        for (; check != null && isLineEmpty(check); check = reader.readLine());
            
        if (check == null)
            throw new IOException("Archivo vacío");
            
        return check;
    }*/
    
    private short checkForBlankLines(Scanner scanner) throws IOException {
        if (!scanner.hasNextShort())
            throw new IOException("No se encontraron números en el archivo");
  
        return scanner.nextShort();
    }
    
    public void readFile() throws NoSuchElementException, Exception {
        //BufferedReader reader = Files.newBufferedReader(inputFilePath, Charset.defaultCharset());
        Scanner scanner = new Scanner(inputFilePath);
            
        //short n = Short.parseShort(checkForBlankLines(reader));
        
        short n = checkForBlankLines(scanner);
        
        ArrayList<Rascacielo> rascacielos = new ArrayList<>(n);
        
        while(scanner.hasNextShort()) {
            rascacielos.add(new Rascacielo(
                    scanner.nextShort(), 
                    scanner.nextShort(), 
                    scanner.nextShort()
            ));
        }
        
        scanner.close();
        
        centro = new Centro(n, rascacielos);
    }
    
    public void writeFile() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(outputFilePath, Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        writer.write(centro.getSiluetaString() + System.getProperty("line.separator"));
        writer.close();
        
    }
    
    public final Path getInputFilePath() {
         return inputFilePath;
    }
     
    public final Path getOutputFilePath() {
         return outputFilePath;
    }
    
    public final Centro getCentro() {
    	return centro;
    }
}
