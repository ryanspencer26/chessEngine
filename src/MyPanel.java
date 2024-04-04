import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyPanel extends JPanel{

    // NEED TO SHUFFLE TURNS BETWEEN WHITE AND BLACK

    private Square[][] board = new Square[8][8];
    private int[] current = new int[2];
    private ArrayList<Square> possMoves = new ArrayList<Square>();
    private Color turn;

    public MyPanel(){

        setBackground(Color.LIGHT_GRAY);

        turn = Color.WHITE;

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

        for (Square[] squares : board) {

            for (Square square : squares) {

                System.out.print(square.name + "\t");

            }

            System.out.println();

        }

        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e){

                super.mousePressed(e);

                possMoves = new ArrayList<Square>();

                if(e.getX() > 525){

                    if(e.getY() > 525) {
                        current[0] = 7;
                        current[1] = 7;
                    } else if(e.getY() > 450){
                        current[0] = 6;
                        current[1] = 7;
                    } else if(e.getY() > 375){
                        current[0] = 5;
                        current[1] = 7;
                    } else if(e.getY() > 300){
                        current[0] = 4;
                        current[1] = 7;
                    } else if(e.getY() > 225){
                        current[0] = 3;
                        current[1] = 7;
                    } else if(e.getY() > 150){
                        current[0] = 2;
                        current[1] = 7;
                    } else if(e.getY() > 75){
                        current[0] = 1;
                        current[1] = 7;
                    } else {
                        current[0] = 0;
                        current[1] = 7;
                    }

                } else if(e.getX() > 450){

                    if(e.getY() > 525) {
                        current[0] = 7;
                        current[1] = 6;
                    } else if(e.getY() > 450){
                        current[0] = 6;
                        current[1] = 6;
                    } else if(e.getY() > 375){
                        current[0] = 5;
                        current[1] = 6;
                    } else if(e.getY() > 300){
                        current[0] = 4;
                        current[1] = 6;
                    } else if(e.getY() > 225){
                        current[0] = 3;
                        current[1] = 6;
                    } else if(e.getY() > 150){
                        current[0] = 2;
                        current[1] = 6;
                    } else if(e.getY() > 75){
                        current[0] = 1;
                        current[1] = 6;
                    } else {
                        current[0] = 0;
                        current[1] = 6;
                    }

                } else if(e.getX() > 375){

                    if(e.getY() > 525) {
                        current[0] = 7;
                        current[1] = 5;
                    } else if(e.getY() > 450){
                        current[0] = 6;
                        current[1] = 5;
                    } else if(e.getY() > 375){
                        current[0] = 5;
                        current[1] = 5;
                    } else if(e.getY() > 300){
                        current[0] = 4;
                        current[1] = 5;
                    } else if(e.getY() > 225){
                        current[0] = 3;
                        current[1] = 5;
                    } else if(e.getY() > 150){
                        current[0] = 2;
                        current[1] = 5;
                    } else if(e.getY() > 75){
                        current[0] = 1;
                        current[1] = 5;
                    } else {
                        current[0] = 0;
                        current[1] = 5;
                    }

                } else if(e.getX() > 300){

                    if(e.getY() > 525) {
                        current[0] = 7;
                        current[1] = 4;
                    } else if(e.getY() > 450){
                        current[0] = 6;
                        current[1] = 4;
                    } else if(e.getY() > 375){
                        current[0] = 5;
                        current[1] = 4;
                    } else if(e.getY() > 300){
                        current[0] = 4;
                        current[1] = 4;
                    } else if(e.getY() > 225){
                        current[0] = 3;
                        current[1] = 4;
                    } else if(e.getY() > 150){
                        current[0] = 2;
                        current[1] = 4;
                    } else if(e.getY() > 75){
                        current[0] = 1;
                        current[1] = 4;
                    } else {
                        current[0] = 0;
                        current[1] = 4;
                    }

                } else if(e.getX() > 225){

                    if(e.getY() > 525) {
                        current[0] = 7;
                        current[1] = 3;
                    } else if(e.getY() > 450){
                        current[0] = 6;
                        current[1] = 3;
                    } else if(e.getY() > 375){
                        current[0] = 5;
                        current[1] = 3;
                    } else if(e.getY() > 300){
                        current[0] = 4;
                        current[1] = 3;
                    } else if(e.getY() > 225){
                        current[0] = 3;
                        current[1] = 3;
                    } else if(e.getY() > 150){
                        current[0] = 2;
                        current[1] = 3;
                    } else if(e.getY() > 75){
                        current[0] = 1;
                        current[1] = 3;
                    } else {
                        current[0] = 0;
                        current[1] = 3;
                    }

                } else if(e.getX() > 150){

                    if(e.getY() > 525) {
                        current[0] = 7;
                        current[1] = 2;
                    } else if(e.getY() > 450){
                        current[0] = 6;
                        current[1] = 2;
                    } else if(e.getY() > 375){
                        current[0] = 5;
                        current[1] = 2;
                    } else if(e.getY() > 300){
                        current[0] = 4;
                        current[1] = 2;
                    } else if(e.getY() > 225){
                        current[0] = 3;
                        current[1] = 2;
                    } else if(e.getY() > 150){
                        current[0] = 2;
                        current[1] = 2;
                    } else if(e.getY() > 75){
                        current[0] = 1;
                        current[1] = 2;
                    } else {
                        current[0] = 0;
                        current[1] = 2;
                    }

                }  else if(e.getX() > 75){

                    if(e.getY() > 525) {
                        current[0] = 7;
                        current[1] = 1;
                    } else if(e.getY() > 450){
                        current[0] = 6;
                        current[1] = 1;
                    } else if(e.getY() > 375){
                        current[0] = 5;
                        current[1] = 1;
                    } else if(e.getY() > 300){
                        current[0] = 4;
                        current[1] = 1;
                    } else if(e.getY() > 225){
                        current[0] = 3;
                        current[1] = 1;
                    } else if(e.getY() > 150){
                        current[0] = 2;
                        current[1] = 1;
                    } else if(e.getY() > 75){
                        current[0] = 1;
                        current[1] = 1;
                    } else {
                        current[0] = 0;
                        current[1] = 1;
                    }

                } else {

                    if(e.getY() > 525) {
                        current[0] = 7;
                        current[1] = 0;
                    } else if(e.getY() > 450){
                        current[0] = 6;
                        current[1] = 0;
                    } else if(e.getY() > 375){
                        current[0] = 5;
                        current[1] = 0;
                    } else if(e.getY() > 300){
                        current[0] = 4;
                        current[1] = 0;
                    } else if(e.getY() > 225){
                        current[0] = 3;
                        current[1] = 0;
                    } else if(e.getY() > 150){
                        current[0] = 2;
                        current[1] = 0;
                    } else if(e.getY() > 75){
                        current[0] = 1;
                        current[1] = 0;
                    } else {
                        current[0] = 0;
                        current[1] = 0;
                    }

                }

                System.out.println(board[current[0]][current[1]].name);
                findAllMoves();

            }

        });

    }

    private void findRookMoves(){

        if(current[0] > 0){
            for(int r = current[0] - 1; r >= 0; r--){
                if(board[r][current[1]].getPiece() == null){
                    possMoves.add(board[r][current[1]]);
                } else {
                    if(board[r][current[1]].getPiece().getColor() != board[current[0]][current[1]].getPiece().getColor()){
                        possMoves.add(board[r][current[1]]);
                    }
                    break;
                }
            }
        }

        if(current[0] < board.length - 1){
            for(int r = current[0] + 1; r < board.length; r++){
                if(board[r][current[1]].getPiece() == null){
                    possMoves.add(board[r][current[1]]);
                } else {
                    if(board[r][current[1]].getPiece().getColor() != board[current[0]][current[1]].getPiece().getColor()){
                        possMoves.add(board[r][current[1]]);
                    }
                    break;
                }
            }
        }

        if(current[1] > 0){
            for(int c = current[1] - 1; c >= 0; c--){
                if(board[current[0]][c].getPiece() == null){
                    possMoves.add(board[current[0]][c]);
                } else {
                    if(board[current[0]][c].getPiece().getColor() != board[current[0]][current[1]].getPiece().getColor()){
                        possMoves.add(board[current[0]][c]);
                    }
                    break;
                }
            }
        }

        if(current[1] < board[current[0]].length - 1){
            for(int c = current[1] + 1; c < board[current[0]].length; c++){
                if(board[current[0]][c].getPiece() == null){
                    possMoves.add(board[current[0]][c]);
                } else {
                    if(board[current[0]][c].getPiece().getColor() != board[current[0]][current[1]].getPiece().getColor()){
                        possMoves.add(board[current[0]][c]);
                    }
                    break;
                }
            }
        }

    }

    private void findBishopMoves(){

        if(current[0] < board.length - 1 && current[1] < board[current[0]].length - 1){
            for(int r = current[0] + 1, c = current[1] + 1; r < board.length && c < board[r].length; r++, c++){
                if(board[r][c].getPiece() == null){
                    possMoves.add(board[r][c]);
                } else {
                    if(board[r][c].getPiece().getColor() != board[current[0]][current[1]].getPiece().getColor()){
                        possMoves.add(board[r][c]);
                    }
                    break;
                }
            }
        }

        if(current[0] > 0 && current[1] > 0){
            for(int r = current[0] - 1, c = current[1] - 1; r >= 0 && c >= 0; r--, c--){
                if(board[r][c].getPiece() == null){
                    possMoves.add(board[r][c]);
                } else {
                    if(board[r][c].getPiece().getColor() != board[current[0]][current[1]].getPiece().getColor()){
                        possMoves.add(board[r][c]);
                    }
                    break;
                }
            }
        }

        if(current[0] > 0 && current[1] < board[current[0]].length - 1){
            for(int r = current[0] - 1, c = current[1] + 1; r >= 0 && c < board[r].length; r--, c++){
                if(board[r][c].getPiece() == null){
                    possMoves.add(board[r][c]);
                } else {
                    if(board[r][c].getPiece().getColor() != board[current[0]][current[1]].getPiece().getColor()){
                        possMoves.add(board[r][c]);
                    }
                    break;
                }
            }
        }

        if(current[0] < board.length - 1 && current[1] > 0){
            for(int r = current[0] + 1, c = current[1] - 1; r < board.length && c >= 0; r++, c--){
                if(board[r][c].getPiece() == null){
                    possMoves.add(board[r][c]);
                } else {
                    if(board[r][c].getPiece().getColor() != board[current[0]][current[1]].getPiece().getColor()){
                        possMoves.add(board[r][c]);
                    }
                    break;
                }
            }
        }

    }

    // MUST ADD:
    // - Knights
    // - Pawns
    // - Kings
    private void findAllMoves(){

        if(board[current[0]][current[1]].getPiece() != null) {

            if (board[current[0]][current[1]].getPiece().getValue() == 9) {
                findRookMoves();
                findBishopMoves();
            } else if(board[current[0]][current[1]].getPiece().getValue() == 5){
                findRookMoves();
            } else if(board[current[0]][current[1]].getPiece().getValue() == 3 && board[current[0]][current[1]].getPiece().getClass() == Bishop.class){
                findBishopMoves();
            } else if(board[current[0]][current[1]].getPiece().getValue() == 3 && board[current[0]][current[1]].getPiece().getClass() == Knight.class){
//              findKnightMoves();
            } else if(board[current[0]][current[1]].getPiece().getValue() == 1){
//              findPawnMoves();
            } else {
//              findKingMoves();
            }

        }

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

                if(!possMoves.isEmpty()){
                    for (Square possMove : possMoves) {

                        if (board[r][c] == possMove) {

                            g.setColor(new Color(255, 127, 127));

                        }

                    }
                }

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