package kubrik;

public class TestKubrik {
    
    final static String INPUT_FILE_NAME     = "KUBR_DAT.txt",      //Nombre del archivo de entrada
                        OUTPUT_FILE_NAME    = "KUBR_OUT.txt",     //Nombre del archivo de salida
                        FILES_DIRECTORY     = "files";         //Directorio donde se encuentran

    public static void main(String[] args) {
        try {
            Archivo archivo = new Archivo(INPUT_FILE_NAME, OUTPUT_FILE_NAME, FILES_DIRECTORY);
            archivo.readFile();
            archivo.writeFile();
        }
        catch(final Exception e) {
            e.printStackTrace();
        }
    }
    
}
