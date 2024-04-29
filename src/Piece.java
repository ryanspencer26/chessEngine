import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Piece implements Cloneable{

    private Color color;

    private String squareName;

    private Square square;

    public final ImageIcon whitePic;
    public final ImageIcon blackPic;
    private int value;

    public Piece(Color color, String squareName, ImageIcon whitePic, ImageIcon blackPic, int value){

        this.color = color;
        this.squareName = squareName;
        this.whitePic = whitePic;
        this.blackPic = blackPic;
        this.value = value;

    }

    public Color getColor(){

        return color;

    }

    public int getValue(){

        return value;

    }

    public void setSquare(Square square){

        this.square = square;

    }

    public Square getSquare(){

        return square;

    }

    public ImageIcon getPic(){

        if(color == Color.WHITE){

            return whitePic;

        }

        return blackPic;

    }

    public String toString(){
        if(color == Color.WHITE) {
            if (this instanceof Rook) {
                return "White Rook";
            } else if (this instanceof Knight) {
                return "White Knight";
            } else if (this instanceof Bishop) {
                return "White Bishop";
            } else if (this instanceof Queen) {
                return "White Queen";
            } else if (this instanceof King) {
                return "White King";
            } else {
                return "White Pawn";
            }
        } else {
            if (this instanceof Rook) {
                return "Black Rook";
            } else if (this instanceof Knight) {
                return "Black Knight";
            } else if (this instanceof Bishop) {
                return "Black Bishop";
            } else if (this instanceof Queen) {
                return "Black Queen";
            } else if (this instanceof King) {
                return "Black King";
            } else {
                return "Black Pawn";
            }
        }
    }

}