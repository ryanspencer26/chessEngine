import java.io.Serializable;

public class Square implements Cloneable{

    private final boolean colored;
    public final String name;

    public int[] loc;

    private Piece piece = null;

    public Square(boolean colored, String name, int[] loc){

        this.colored = colored;
        this.name = name;
        this.loc = loc;

    }

    public Square(Square other){

        this.colored = other.colored;
        this.name = other.name.substring(0);
        this.loc = other.loc.clone();
        if(other.piece == null) {
            this.piece = null;
        } else {
            if (other.piece instanceof Rook) {
                this.piece = new Rook(other.piece);
            } else if (other.piece instanceof Knight) {
                this.piece = new Knight(other.piece);
            } else if (other.piece instanceof Bishop) {
                this.piece = new Bishop(other.piece);
            } else if (other.piece instanceof Queen) {
                this.piece = new Queen(other.piece);
            } else if (other.piece instanceof King) {
                this.piece = new King(other.piece);
            } else {
                this.piece = new Pawn(other.piece);
            }
            this.piece.setSquare(other.piece.getSquare());
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