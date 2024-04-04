import javax.swing.*;
import java.awt.*;

public class King extends Piece {

    public final static int value = 0;

    public King(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whiteKing.png"), new ImageIcon("Pieces/blackKing.png"));

    }

}