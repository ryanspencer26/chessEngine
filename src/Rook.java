import javax.swing.*;
import java.awt.*;

public class Rook extends Piece {

    public final static int value = 5;
    public int moves;

    public Rook(Color color, String square){

        super(color, square, new ImageIcon("Pieces/whiteRook.png"), new ImageIcon("Pieces/BlackRook.png"), value);

    }

    public Rook(Piece other){
        super(other.getColor(), other.getSquare().name, new ImageIcon("Pieces/whiteRook.png"), new ImageIcon("Pieces/BlackRook.png"), value);
    }

    public int getValue(){

        return value;

    }

    public void move(){
        moves++;
    }

    public int getMoves(){
        return moves;
    }

}