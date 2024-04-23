import java.io.Serializable;

public class Square implements Serializable, Cloneable{

    private final boolean colored;
    public final String name;

    public final int[] loc;

    private Piece piece = null;

    public Square(boolean colored, String name, int[] loc){

        this.colored = colored;
        this.name = name;
        this.loc = loc;

    }

    public boolean isColored(){

        return colored;

    }

    public void setPiece(Piece p){

        piece = p;
        if(piece != null)
            piece.setSquare(this);

    }

    public Piece getPiece(){

        return piece;

    }

    public String toString(){

        return name;

    }

}