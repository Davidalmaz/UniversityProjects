package chess;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Board extends JPanel {
    private BufferedImage m_board;
    private final int PIECES_SIZE = 62;
    private final static String IMAGE_WHITE_KING = "White King60.png",
                                IMAGE_BLACK_KING = "Black King60.png";
    private King whiteKing, blackKing;
        
    private final int m_boardWidth;
    private final int m_boardHeight;
    
    // Los parámetros boardWidth y boardHeight
    // tendrán el valor del tamaño de la ventana.
    // De manera que la imagen del tablero ocupe toda la pantalla (frame principal).
    public Board(int boardWith, int boardHeight) {
        m_boardWidth  = boardWith;
        m_boardHeight = boardHeight;
        
        try {
            // Se carga la imagen del tablero.
            
            // NOTA: El parámetro para cargar la imagen se usa de esta forma
            // ya que se asume que siempre tendrá esa ruta.
            // Para las piezas el parámetro será tipeado dinámicamente por el desarrollador
            // para que seleccione la pieza con que le haya tocado trabajar.
            m_board = ImageIO.read(new File("images/board/board.jpg"));
            whiteKing = new King(PIECES_SIZE, IMAGE_WHITE_KING);
            blackKing = new King(PIECES_SIZE, IMAGE_BLACK_KING);
            
        } catch (IOException ex1) {
            System.err.println(ex1.toString());
        } 
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Se pinta el tablero adaptando la imagen al tamaño del frame principal.
        // NOTA: La resta de '-7' y '-30' se hace para una mejor presentación a la hora de desplegar el tablero.
        // Ya que esos parámetros representan la esquina inferior derecha de la imagen.
        // Y al intentarla despleglar del mismo tamaño de la ventana, sobresale un poco.
        g.drawImage(m_board.getScaledInstance(m_boardWidth, m_boardHeight, Image.SCALE_DEFAULT), 0, 0, m_boardWidth - 7, m_boardHeight - 30, null);
        g.drawImage(whiteKing.instanciaEscalada(), 250, 411, null);
        g.drawImage(blackKing.instanciaEscalada(), 249, -1, null);
        //g.drawImage(p_kingWhite.getScaledInstance(p_kingWidth, p_kingHeight, Image.SCALE_DEFAULT), 250, 411, null);
       // g.drawImage(p_kingBlack.getScaledInstance(p_kingWidth, p_kingHeight, Image.SCALE_DEFAULT), 249, -1, null);
    }
}
