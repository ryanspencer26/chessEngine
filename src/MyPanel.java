import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{

    private Square[][] board = new Square[8][8];

    public MyPanel(){

        setBackground(Color.LIGHT_GRAY);

        for(int i = 1, n = 8; i <= 8; i++, n--){

            board[i-1][0] = new Square(i % 2 == 0, "a" + n);

        }

        for(int i = 2, n = 8; i <= 9; i++, n--){

            board[i-2][1] = new Square(i % 2 == 0, "b" + n);

        }

        for(int i = 1, n = 8; i <= 8; i++, n--){

            board[i-1][2] = new Square(i % 2 == 0, "c" + n);

        }

        for(int i = 2, n = 8; i <= 9; i++, n--){

            board[i-2][3] = new Square(i % 2 == 0, "d" + n);

        }

        for(int i = 1, n = 8; i <= 8; i++, n--){

            board[i-1][4] = new Square(i % 2 == 0, "e" + n);

        }

        for(int i = 2, n = 8; i <= 9; i++, n--){

            board[i-2][5] = new Square(i % 2 == 0, "f" + n);

        }

        for(int i = 1, n = 8; i <= 8; i++, n--){

            board[i-1][6] = new Square(i % 2 == 0, "g" + n);

        }

        for(int i = 2, n = 8; i <= 9; i++, n--){

            board[i-2][7] = new Square(i % 2 == 0, "h" + n);

        }

        board[0][0].setPiece(new Rook(Color.BLACK, "a8"));
        board[0][1].setPiece(new Knight(Color.BLACK, "b8"));
        board[0][2].setPiece(new Bishop(Color.BLACK, "c8"));
        board[0][3].setPiece(new Queen(Color.BLACK, "d8"));
        board[0][4].setPiece(new King(Color.BLACK, "e8"));
        board[0][5].setPiece(new Bishop(Color.BLACK, "f8"));
        board[0][6].setPiece(new Knight(Color.BLACK, "g8"));
        board[0][7].setPiece(new Rook(Color.BLACK, "h8"));

        board[1][0].setPiece(new Pawn(Color.BLACK, "a7"));
        board[1][1].setPiece(new Pawn(Color.BLACK, "b7"));
        board[1][2].setPiece(new Pawn(Color.BLACK, "c7"));
        board[1][3].setPiece(new Pawn(Color.BLACK, "d7"));
        board[1][4].setPiece(new Pawn(Color.BLACK, "e7"));
        board[1][5].setPiece(new Pawn(Color.BLACK, "f7"));
        board[1][6].setPiece(new Pawn(Color.BLACK, "g7"));
        board[1][7].setPiece(new Pawn(Color.BLACK, "h7"));

        board[7][0].setPiece(new Rook(Color.WHITE, "a1"));
        board[7][1].setPiece(new Knight(Color.WHITE, "b1"));
        board[7][2].setPiece(new Bishop(Color.WHITE, "c1"));
        board[7][3].setPiece(new Queen(Color.WHITE, "d1"));
        board[7][4].setPiece(new King(Color.WHITE, "e1"));
        board[7][5].setPiece(new Bishop(Color.WHITE, "f1"));
        board[7][6].setPiece(new Knight(Color.WHITE, "g1"));
        board[7][7].setPiece(new Rook(Color.WHITE, "h1"));

        board[6][0].setPiece(new Pawn(Color.WHITE, "a2"));
        board[6][1].setPiece(new Pawn(Color.WHITE, "b2"));
        board[6][2].setPiece(new Pawn(Color.WHITE, "c2"));
        board[6][3].setPiece(new Pawn(Color.WHITE, "d2"));
        board[6][4].setPiece(new Pawn(Color.WHITE, "e2"));
        board[6][5].setPiece(new Pawn(Color.WHITE, "f2"));
        board[6][6].setPiece(new Pawn(Color.WHITE, "g2"));
        board[6][7].setPiece(new Pawn(Color.WHITE, "h2"));

    }


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        for(int r = 0, y = 0; r < board.length; r++, y+=100){

            for(int c = 0, x = 0; c < board[r].length; c++, x+=100){

                if(board[r][c].isColored())
                    g.setColor(new Color(76, 187, 23));
                else
                    g.setColor(Color.WHITE);

                g.fillRect(x, y, 100,100);
                if(board[r][c].getPiece() != null)
                    g.drawImage(board[r][c].getPiece().getPic().getImage(), x, y, 100, 100, null);

            }

        }

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        repaint();

    }

}