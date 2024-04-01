public class Square {

    private boolean colored;
    private String name;

    private Piece piece = null;

    public Square(boolean colored, String name){

        this.colored = colored;
        this.name = name;

    }

    public boolean isColored(){

        return colored;

    }

    public void setPiece(Piece p){

        piece = p;

    }

    public Piece getPiece(){

        return piece;

    }

    public String toString(){

        return name;

    }

}