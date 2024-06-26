import javax.swing.*;
import java.awt.*;

public class Bishop extends Piece {

    public final static int value = 3;

    public Bishop(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whiteBishop.png"), new ImageIcon("Pieces/blackBishop.png"), value);

    }

    public Bishop(Piece other){
        super(other.getColor(), other.getSquare().name, new ImageIcon("Pieces/whiteBishop.png"), new ImageIcon("Pieces/BlackBishop.png"), value);
    }

    public int getValue(){

        return value;

    }

}