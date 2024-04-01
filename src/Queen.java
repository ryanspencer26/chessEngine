import javax.swing.*;
import java.awt.*;

public class Queen extends Piece {

    public final static String possMoves = "straight+diagonal";

    public Queen(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whiteQueen.png"), new ImageIcon("Pieces/blackQueen.png"));

    }

}