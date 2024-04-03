import javax.swing.*;
import java.awt.*;

public class Rook extends Piece {

    public final static int value = 5;

    public Rook(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whiteRook.png"), new ImageIcon("Pieces/BlackRook.png"));

    }

}