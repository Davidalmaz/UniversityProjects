package chess;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.jpl7.*;

public class King {
    private int width;
    private int height;
    private BufferedImage piece;
    //private static BufferedImage white, black;
    private static final String IMAGE_DIRECTORY             = "images/pieces/";
     //                           IMAGE_NAME_KING_WHITE       = "White King60.png",
     //                           IMAGE_NAME_KING_BLACK       = "Black King60.png";
    
    public King(final int pixelSize, final String imageName) {
        try {
            this.width = this.height = pixelSize;
            piece = ImageIO.read(new File(IMAGE_DIRECTORY + imageName));
            //white = ImageIO.read(new File(IMAGE_DIRECTORY + IMAGE_NAME_KING_WHITE));
            //black = ImageIO.read(new File(IMAGE_DIRECTORY + IMAGE_NAME_KING_BLACK));
        }
        catch(final IOException e) {
            e.printStackTrace();
        }
    }
    
    public Image instanciaEscalada() {
        return piece.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    }
    
}
