import javax.swing.*;
import java.awt.*;

public class King extends Piece {

    public final static String possMoves = "1square";

    public King(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whiteKing.png"), new ImageIcon("Pieces/blackKing.png"));

    }

}