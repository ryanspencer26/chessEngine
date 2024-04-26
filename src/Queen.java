import javax.swing.*;
import java.awt.*;

public class Queen extends Piece {

    public final static int value = 9;

    public Queen(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whiteQueen.png"), new ImageIcon("Pieces/blackQueen.png"), value);

    }

    public Queen(Piece other){
        super(other.getColor(), other.getSquare().name, new ImageIcon("Pieces/whiteQueen.png"), new ImageIcon("Pieces/BlackQueen.png"), value);
    }

    public int getValue(){

        return value;

    }

}