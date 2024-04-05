import javax.swing.*;
import java.awt.*;

public class Piece {

    private Color color;
    private String square;

    public final ImageIcon whitePic;
    public final ImageIcon blackPic;

    public Piece(Color color, String square, ImageIcon whitePic, ImageIcon blackPic){

        this.color = color;
        this.square = square;
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

    public ImageIcon getPic(){

        if(color == Color.WHITE){

            return whitePic;

        }

        return blackPic;

    }

}