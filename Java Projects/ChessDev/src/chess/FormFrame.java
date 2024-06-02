package chess;
import javax.swing.*;
import java.awt.*;

public class FormFrame extends JFrame {
    
    // Para el tamaño de la ventana.
    private final int m_width;
    private final int m_height;
    
    public FormFrame(int width, int height) {
        m_width  = width;
        m_height = height;
        
        // Propiedades de la ventana.
        setSize(m_width, m_height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chess");
        setResizable(false);
        
        // Se inserta el tablero al frame.
        add(new Board(m_width, m_height));
    }
}
