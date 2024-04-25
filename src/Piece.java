import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Piece implements Cloneable{

    private Color color;

    private String squareName;

    private Square square;

    public final ImageIcon whitePic;
    public final ImageIcon blackPic;
    public final int value;

    public Piece(Color color, String squareName, ImageIcon whitePic, ImageIcon blackPic, int value){

        this.color = color;
        this.squareName = squareName;
        this.whitePic = whitePic;
        this.blackPic = blackPic;
        this.value = value;

    }

    public Piece(Piece other){

        this.color = other.color;
        this.squareName = other.squareName;
        this.whitePic = other.whitePic;
        this.blackPic = other.blackPic;
        this.value = other.value;
        setSquare(other.square);

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

}