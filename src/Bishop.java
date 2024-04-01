import javax.swing.*;
import java.awt.*;

public class Bishop extends Piece {

    public final static String possMoves = "u/d=2, l/r=1";

    public Bishop(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whiteBishop.png"), new ImageIcon("Pieces/blackBishop.png"));

    }

}