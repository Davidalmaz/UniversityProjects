// "Taller de Análisis y Diseño de Algoritmos"
// "Asignación #3 — Rascacielos"
//
// Descripción:
// 
//
// Entrada:
// Línea 1: número N de rascacielos, mediate uno o dos caracteres que representan un
// número entero entre 1 y 99
// Líneas de la 2 a la N+1: cada una de las líneas tiene el formato:
// izq der alt
// Donde los tres componenetes son uno o dos caracters que representan un número
// entero entre 1 y 99. El significado de los componentes es: izq y der, coordenadas
// izquierda y derecha del rascacielos, y alt, altura del mismo. Los componentes
// de la línea están separados por un único caracter blanco, y no existen blancos no otro tipo de 
// caracteres al principio o final de la línea.
//
// Salida:
// Un número indeterminado de líneas, cada una de las cuales con el formato:
// hor ver. Siendo "hor" y "ver" uno o dos caracteres que representan un número entero
// entre 1 y 99. La primera componente representa una coordenada horizontal y la segunda
// la altura de la silueta en ese punto. Tan solo deben incluirse en la salida aquellas
// coordenadas horizontales en las que la silueta cambia de altura; obligatoriamente,
// debe aparecer la coordenada 1, con su correspondiente altura. Los componentes de la
// línea están separados por un único carácter blanco, y no existen blanco ni otro tipo
// de caracters al principio o al final de la línea. Las líneas deben aparecer ordenadas
// crecientemente según el componente horizontal.
//
// Realizado por:
// Gonzalo Rodulfo (C.I.: 26.237.568)
//

package rascacielos;

import java.util.NoSuchElementException;
import javax.swing.JFrame;

public class TestRascacielos {
    
     final static String INPUT_FILE_NAME     = "RASCAC.in",      //Nombre del archivo de entrada
                         OUTPUT_FILE_NAME    = "RASCAC.out",     //Nombre del archivo de salida
                         FILES_DIRECTORY     = "files";         //Directorio donde se encuentran
     
     final static short FRAME_H = 854,
                        FRAME_V = 480;

    public static void main(String[] args) {
        try {
            Archivo archivo = new Archivo(INPUT_FILE_NAME, OUTPUT_FILE_NAME, FILES_DIRECTORY);
            archivo.readFile();
            
            Centro c = archivo.getCentro();
            archivo.writeFile();
            
            Graficar points = new Graficar(c);
            JFrame frame = new JFrame("Rascacielos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(points);
            
            frame.setSize(FRAME_H, FRAME_V);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
        catch(final NoSuchElementException nse) {
            System.err.println(
                    "No se cumplió el formato de izq, der, alt "
                            + "para agregar rascacielo"
            );
            nse.printStackTrace();
        }
        catch(final Exception exception) {
            exception.printStackTrace();
        }
    }
    
}
