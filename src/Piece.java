import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Piece implements Cloneable{

    private Color color;

    private String squareName;

    private Square square;

    public final ImageIcon whitePic;
    public final ImageIcon blackPic;

    public Piece(Color color, String squareName, ImageIcon whitePic, ImageIcon blackPic){

        this.color = color;
        this.squareName = squareName;
        this.whitePic = whitePic;
        this.blackPic = blackPic;

    }

    public Color getColor(){

        return color;

    }

    public int getValue(){

        return -1;

    }

    public int getMoves(){

        return -1;

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