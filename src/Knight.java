import javax.swing.*;
import java.awt.*;

public class Knight extends Piece {

    public final static String possMoves = "L";

    public Knight(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whiteKnight.png"), new ImageIcon("Pieces/blackKnight.png"));

    }

}