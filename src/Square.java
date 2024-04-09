public class Square {

    private final boolean colored;
    public final String name;

    public final int[] location;

    private Piece piece = null;

    public Square(boolean colored, String name, int[] location){

        this.colored = colored;
        this.name = name;
        this.location = location;

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