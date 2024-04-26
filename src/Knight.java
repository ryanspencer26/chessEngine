import javax.swing.*;
import java.awt.*;

public class Knight extends Piece {

    public final static int value = 3;

    public Knight(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whiteKnight.png"), new ImageIcon("Pieces/blackKnight.png"), value);

    }

    public Knight(Piece other){
        super(other.getColor(), other.getSquare().name, new ImageIcon("Pieces/whiteKnight.png"), new ImageIcon("Pieces/BlackKnight.png"), value);
    }

    public int getValue(){

        return value;

    }

}