import java.io.Serializable;

public class Square implements Cloneable{

    private final boolean colored;
    public final String name;

    public final int[] loc;

    private Piece piece = null;

    public Square(boolean colored, String name, int[] loc){

        this.colored = colored;
        this.name = name;
        this.loc = loc;

    }

    public Square(Square other){

        this.colored = other.colored;
        this.name = other.name;
        this.loc = other.loc;
        if(other.piece != null){
            this.piece = new Piece(other.piece);
        } else {
            this.piece = null;
        }

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