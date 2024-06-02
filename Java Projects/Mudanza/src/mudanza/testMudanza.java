// "Taller de Análisis y Diseño de Algoritmos"
// "Asignación #2 — Mudanza"
//
// Descripción:
// Una familia va a cambiar de residencia y para ello
// va a utilizar dos camiones de mudanza. La empresa de mudanzas
// desea que todas las pertenencias de la familia se repartan
// equitativamente entre los dos camiones de manera que:
// 1) Ambos transporten el mismo número de objetos
// 2) El peso que carga un camión sea lo más parecido al peso que
// carga el otro, es decir, la diferencia entre los pesos debe ser
// la misma
//
// Escribe un programa que dada la lista de los pesos de las pertenencias de la
// familia, determine el peso que cada camión deberá llevar para cumplir con los
// requerimientos de la empresa. Nota: No hay límite para el peso que pueden cargar
// los camiones.
//
// Entrada:
// La entrada deberá realizarse del archivo de texto INPUT.TXT . La primera
// línea contiene el número N de pertenencias de la familia (10 <= N <= 10000, con N par).
// Las siguientes N líneas contienen el peso de cada uno de los objetos representado como
// un entero positivo menor o igual a 60000.
//
// Salida:
// En el archivo de texto OUTPUT.TXT o por pantalla, deberá escribirse el peso que
// cargará cada uno de los camiones, en cualquier orden, separados por un espacio.
// Ambos pesos son números enteros.
//
// Realizado por:
// Gonzalo Rodulfo (C.I.: 26.237.568)
//

package mudanza;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class testMudanza {
    
    final static String INPUT_FILE_NAME     = "INPUT.txt",      //Nombre del archivo de entrada
                        OUTPUT_FILE_NAME    = "OUTPUT.txt",     //Nombre del archivo de salida
                        FILES_DIRECTORY     = "files";         //Directorio donde se encuentran
    
    final static byte  MIN_N      = 10;
    final static short MAX_N      = (short)10000;
    
    final static int   MAX_WEIGHT = 60000,
                       MIN_WEIGHT = 0;
    
    public static void main(String[] args) {
        
        try {
            Archivo archivo = new Archivo(INPUT_FILE_NAME, OUTPUT_FILE_NAME, FILES_DIRECTORY);
            archivo.readFile();
            archivo.writeFile();
        }
        catch(final Exception exception) {
            exception.printStackTrace();
        }
        
    }
    
}
