import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPanel extends JPanel{

    private Square[][] board = new Square[8][8];
    private Square current;

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

        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e){

                super.mousePressed(e);

                if(e.getX() > 525){

                    if(e.getY() > 525)
                        current = board[7][7];

                    if(e.getY() > 450)
                        current = board[6][7];

                    if(e.getY() > 375)
                        current = board[5][7];

                    if(e.getY() > 300)
                        current = board[4][7];

                    if(e.getY() > 225)
                        current = board[3][7];

                    if(e.getY() > 150)
                        current = board[2][7];

                    if(e.getY() > 75)
                        current = board[1][7];

                    if(e.getY() > 0)
                        current = board[0][7];

                } else if(e.getX() > 450){

                    if(e.getY() > 525)
                        current = board[7][7];

                    if(e.getY() > 450)
                        current = board[6][7];

                    if(e.getY() > 375)
                        current = board[5][7];

                    if(e.getY() > 300)
                        current = board[4][7];

                    if(e.getY() > 225)
                        current = board[3][7];

                    if(e.getY() > 150)
                        current = board[2][7];

                    if(e.getY() > 75)
                        current = board[1][7];

                    if(e.getY() > 0)
                        current = board[0][7];

                } //finish else ifs for x

            }

        });

    }


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        for(int r = 0, y = 0; r < board.length; r++, y+=75){

            for(int c = 0, x = 0; c < board[r].length; c++, x+=75){

                if(board[r][c].isColored())
                    g.setColor(new Color(76, 187, 23));
                else
                    g.setColor(Color.WHITE);

                g.fillRect(x, y, 75,75);
                if(board[r][c].getPiece() != null)
                    g.drawImage(board[r][c].getPiece().getPic().getImage(), x, y, 75, 75, null);

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