import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyPanel extends JPanel{

    private Square[][] board = new Square[8][8];
    private Piece curr = null; // current square
    private Square nMove = null;
    private final Piece whiteKing;
    private final Piece blackKing;
    private boolean moving;
    private boolean gameOver;
    private int timer;
    private boolean whiteCastle = false;
    private boolean blackCastle = false;
    private ArrayList<Square> possMoves = new ArrayList<Square>();
    private ArrayList<Square> scope = new ArrayList<Square>();
    private ArrayList<Piece> blackPieces = new ArrayList<Piece>();
    private ArrayList<Piece> whitePieces = new ArrayList<Piece>();
    private Color turn;

    public MyPanel(){

        setBackground(Color.LIGHT_GRAY);
        turn = Color.WHITE;
        moving = false;

        for(int i = 1, n = 8; i <= 8; i++, n--){
            board[i-1][0] = new Square(i % 2 == 0, "a" + n, new int[]{i - 1, 0});
        }
        for(int i = 2, n = 8; i <= 9; i++, n--){
            board[i-2][1] = new Square(i % 2 == 0, "b" + n, new int[]{i - 2, 1});
        }
        for(int i = 1, n = 8; i <= 8; i++, n--){
            board[i-1][2] = new Square(i % 2 == 0, "c" + n, new int[]{i - 1, 2});
        }
        for(int i = 2, n = 8; i <= 9; i++, n--){
            board[i-2][3] = new Square(i % 2 == 0, "d" + n, new int[]{i - 2, 3});
        }
        for(int i = 1, n = 8; i <= 8; i++, n--){
            board[i-1][4] = new Square(i % 2 == 0, "e" + n, new int[]{i - 1, 4});
        }
        for(int i = 2, n = 8; i <= 9; i++, n--){
            board[i-2][5] = new Square(i % 2 == 0, "f" + n, new int[]{i - 2, 5});
        }
        for(int i = 1, n = 8; i <= 8; i++, n--){
            board[i-1][6] = new Square(i % 2 == 0, "g" + n, new int[]{i - 1, 6});
        }
        for(int i = 2, n = 8; i <= 9; i++, n--){
            board[i-2][7] = new Square(i % 2 == 0, "h" + n, new int[]{i - 2, 7});
        }

        board[0][0].setPiece(new Rook(Color.BLACK, "a8"));
        blackPieces.add(board[0][0].getPiece());
        board[0][1].setPiece(new Knight(Color.BLACK, "b8"));
        blackPieces.add(board[0][1].getPiece());
        board[0][2].setPiece(new Bishop(Color.BLACK, "c8"));
        blackPieces.add(board[0][2].getPiece());
        board[0][3].setPiece(new Queen(Color.BLACK, "d8"));
        blackPieces.add(board[0][3].getPiece());
        board[0][4].setPiece(new King(Color.BLACK, "e8"));
        blackPieces.add(board[0][4].getPiece());
        blackKing = board[0][4].getPiece();
        board[0][5].setPiece(new Bishop(Color.BLACK, "f8"));
        blackPieces.add(board[0][5].getPiece());
        board[0][6].setPiece(new Knight(Color.BLACK, "g8"));
        blackPieces.add(board[0][6].getPiece());
        board[0][7].setPiece(new Rook(Color.BLACK, "h8"));
        blackPieces.add(board[0][7].getPiece());

        board[1][0].setPiece(new Pawn(Color.BLACK, "a7"));
        blackPieces.add(board[1][0].getPiece());
        board[1][1].setPiece(new Pawn(Color.BLACK, "b7"));
        blackPieces.add(board[1][1].getPiece());
        board[1][2].setPiece(new Pawn(Color.BLACK, "c7"));
        blackPieces.add(board[1][2].getPiece());
        board[1][3].setPiece(new Pawn(Color.BLACK, "d7"));
        blackPieces.add(board[1][3].getPiece());
        board[1][4].setPiece(new Pawn(Color.BLACK, "e7"));
        blackPieces.add(board[1][4].getPiece());
        board[1][5].setPiece(new Pawn(Color.BLACK, "f7"));
        blackPieces.add(board[1][5].getPiece());
        board[1][6].setPiece(new Pawn(Color.BLACK, "g7"));
        blackPieces.add(board[1][6].getPiece());
        board[1][7].setPiece(new Pawn(Color.BLACK, "h7"));
        blackPieces.add(board[1][7].getPiece());

        board[7][0].setPiece(new Rook(Color.WHITE, "a1"));
        whitePieces.add(board[7][0].getPiece());
        board[7][1].setPiece(new Knight(Color.WHITE, "b1"));
        whitePieces.add(board[7][1].getPiece());
        board[7][2].setPiece(new Bishop(Color.WHITE, "c1"));
        whitePieces.add(board[7][2].getPiece());
        board[7][3].setPiece(new Queen(Color.WHITE, "d1"));
        whitePieces.add(board[7][3].getPiece());
        board[7][4].setPiece(new King(Color.WHITE, "e1"));
        whitePieces.add(board[7][4].getPiece());
        whiteKing = board[7][4].getPiece();
        board[7][5].setPiece(new Bishop(Color.WHITE, "f1"));
        whitePieces.add(board[7][5].getPiece());
        board[7][6].setPiece(new Knight(Color.WHITE, "g1"));
        whitePieces.add(board[7][6].getPiece());
        board[7][7].setPiece(new Rook(Color.WHITE, "h1"));
        whitePieces.add(board[7][7].getPiece());

        board[6][0].setPiece(new Pawn(Color.WHITE, "a2"));
        whitePieces.add(board[6][0].getPiece());
        board[6][1].setPiece(new Pawn(Color.WHITE, "b2"));
        whitePieces.add(board[6][1].getPiece());
        board[6][2].setPiece(new Pawn(Color.WHITE, "c2"));
        whitePieces.add(board[6][2].getPiece());
        board[6][3].setPiece(new Pawn(Color.WHITE, "d2"));
        whitePieces.add(board[6][3].getPiece());
        board[6][4].setPiece(new Pawn(Color.WHITE, "e2"));
        whitePieces.add(board[6][4].getPiece());
        board[6][5].setPiece(new Pawn(Color.WHITE, "f2"));
        whitePieces.add(board[6][5].getPiece());
        board[6][6].setPiece(new Pawn(Color.WHITE, "g2"));
        whitePieces.add(board[6][6].getPiece());
        board[6][7].setPiece(new Pawn(Color.WHITE, "h2"));
        whitePieces.add(board[6][7].getPiece());

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

                if(e.getX() > 525){

                    if(e.getY() > 525) {
                        if(board[7][7].getPiece() != null && board[7][7].getPiece().getColor() == turn){
                            curr = board[7][7].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[7][7];
                        }
                    } else if(e.getY() > 450){
                        if(board[6][7].getPiece() != null && board[6][7].getPiece().getColor() == turn){
                            curr = board[6][7].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[6][7];
                        }
                    } else if(e.getY() > 375){
                        if(board[5][7].getPiece() != null && board[5][7].getPiece().getColor() == turn){
                            curr = board[5][7].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[5][7];
                        }
                    } else if(e.getY() > 300){
                        if(board[4][7].getPiece() != null && board[4][7].getPiece().getColor() == turn){
                            curr = board[4][7].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[4][7];
                        }
                    } else if(e.getY() > 225){
                        if(board[3][7].getPiece() != null && board[3][7].getPiece().getColor() == turn){
                            curr = board[3][7].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[3][7];
                        }
                    } else if(e.getY() > 150){
                        if(board[2][7].getPiece() != null && board[2][7].getPiece().getColor() == turn){
                            curr = board[2][7].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[2][7];
                        }
                    } else if(e.getY() > 75){
                        if(board[1][7].getPiece() != null && board[1][7].getPiece().getColor() == turn){
                            curr = board[1][7].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[1][7];
                        }
                    } else {
                        if(board[0][7].getPiece() != null && board[0][7].getPiece().getColor() == turn){
                            curr = board[0][7].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[0][7];
                        }
                    }

                } else if(e.getX() > 450){

                    if(e.getY() > 525) {
                        if(board[7][6].getPiece() != null && board[7][6].getPiece().getColor() == turn){
                            curr = board[7][6].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[7][6];
                        }
                    } else if(e.getY() > 450){
                        if(board[6][6].getPiece() != null && board[6][6].getPiece().getColor() == turn){
                            curr = board[6][6].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[6][6];
                        }
                    } else if(e.getY() > 375){
                        if(board[5][6].getPiece() != null && board[5][6].getPiece().getColor() == turn){
                            curr = board[5][6].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[5][6];
                        }
                    } else if(e.getY() > 300){
                        if(board[4][6].getPiece() != null && board[4][6].getPiece().getColor() == turn){
                            curr = board[4][6].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[4][6];
                        }
                    } else if(e.getY() > 225){
                        if(board[3][6].getPiece() != null && board[3][6].getPiece().getColor() == turn){
                            curr = board[3][6].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[3][6];
                        }
                    } else if(e.getY() > 150){
                        if(board[2][6].getPiece() != null && board[2][6].getPiece().getColor() == turn){
                            curr = board[2][6].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[2][6];
                        }
                    } else if(e.getY() > 75){
                        if(board[1][6].getPiece() != null && board[1][6].getPiece().getColor() == turn){
                            curr = board[1][6].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[1][6];
                        }
                    } else {
                        if(board[0][6].getPiece() != null && board[0][6].getPiece().getColor() == turn){
                            curr = board[0][6].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[0][6];
                        }
                    }

                } else if(e.getX() > 375){

                    if(e.getY() > 525) {
                        if(board[7][5].getPiece() != null && board[7][5].getPiece().getColor() == turn){
                            curr = board[7][5].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[7][5];
                        }
                    } else if(e.getY() > 450){
                        if(board[6][5].getPiece() != null && board[6][5].getPiece().getColor() == turn){
                            curr = board[6][5].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[6][5];
                        }
                    } else if(e.getY() > 375){
                        if(board[5][5].getPiece() != null && board[5][5].getPiece().getColor() == turn){
                            curr = board[5][5].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[5][5];
                        }
                    } else if(e.getY() > 300){
                        if(board[4][5].getPiece() != null && board[4][5].getPiece().getColor() == turn){
                            curr = board[4][5].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[4][5];
                        }
                    } else if(e.getY() > 225){
                        if(board[3][5].getPiece() != null && board[3][5].getPiece().getColor() == turn){
                            curr = board[3][5].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[3][5];
                        }
                    } else if(e.getY() > 150){
                        if(board[2][5].getPiece() != null && board[2][5].getPiece().getColor() == turn){
                            curr = board[2][5].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[2][5];
                        }
                    } else if(e.getY() > 75){
                        if(board[1][5].getPiece() != null && board[1][5].getPiece().getColor() == turn){
                            curr = board[1][5].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[1][5];
                        }
                    } else {
                        if(board[0][5].getPiece() != null && board[0][5].getPiece().getColor() == turn){
                            curr = board[0][5].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[0][5];
                        }
                    }

                } else if(e.getX() > 300){

                    if(e.getY() > 525) {
                        if(board[7][4].getPiece() != null && board[7][4].getPiece().getColor() == turn){
                            curr = board[7][4].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[7][4];
                        }
                    } else if(e.getY() > 450){
                        if(board[6][4].getPiece() != null && board[6][4].getPiece().getColor() == turn){
                            curr = board[6][4].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[6][4];
                        }
                    } else if(e.getY() > 375){
                        if(board[5][4].getPiece() != null && board[5][4].getPiece().getColor() == turn){
                            curr = board[5][4].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[5][4];
                        }
                    } else if(e.getY() > 300){
                        if(board[4][4].getPiece() != null && board[4][4].getPiece().getColor() == turn){
                            curr = board[4][4].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[4][4];
                        }
                    } else if(e.getY() > 225){
                        if(board[3][4].getPiece() != null && board[3][4].getPiece().getColor() == turn){
                            curr = board[3][4].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[3][4];
                        }
                    } else if(e.getY() > 150){
                        if(board[2][4].getPiece() != null && board[2][4].getPiece().getColor() == turn){
                            curr = board[2][4].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[2][4];
                        }
                    } else if(e.getY() > 75){
                        if(board[1][4].getPiece() != null && board[1][4].getPiece().getColor() == turn){
                            curr = board[1][4].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[1][4];
                        }
                    } else {
                        if(board[0][4].getPiece() != null && board[0][4].getPiece().getColor() == turn){
                            curr = board[0][4].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[0][4];
                        }
                    }

                } else if(e.getX() > 225){

                    if(e.getY() > 525) {
                        if(board[7][3].getPiece() != null && board[7][3].getPiece().getColor() == turn){
                            curr = board[7][3].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[7][3];
                        }
                    } else if(e.getY() > 450){
                        if(board[6][3].getPiece() != null && board[6][3].getPiece().getColor() == turn){
                            curr = board[6][3].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[6][3];
                        }
                    } else if(e.getY() > 375){
                        if(board[5][3].getPiece() != null && board[5][3].getPiece().getColor() == turn){
                            curr = board[5][3].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[5][3];
                        }
                    } else if(e.getY() > 300){
                        if(board[4][3].getPiece() != null && board[4][3].getPiece().getColor() == turn){
                            curr = board[4][3].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[4][3];
                        }
                    } else if(e.getY() > 225){
                        if(board[3][3].getPiece() != null && board[3][3].getPiece().getColor() == turn){
                            curr = board[3][3].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[3][3];
                        }
                    } else if(e.getY() > 150){
                        if(board[2][3].getPiece() != null && board[2][3].getPiece().getColor() == turn){
                            curr = board[2][3].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[2][3];
                        }
                    } else if(e.getY() > 75){
                        if(board[1][3].getPiece() != null && board[1][3].getPiece().getColor() == turn){
                            curr = board[1][3].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[1][3];
                        }
                    } else {
                        if(board[0][3].getPiece() != null && board[0][3].getPiece().getColor() == turn){
                            curr = board[0][3].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[0][3];
                        }
                    }

                } else if(e.getX() > 150){

                    if(e.getY() > 525) {
                        if(board[7][2].getPiece() != null && board[7][2].getPiece().getColor() == turn){
                            curr = board[7][2].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[7][2];
                        }
                    } else if(e.getY() > 450){
                        if(board[6][2].getPiece() != null && board[6][2].getPiece().getColor() == turn){
                            curr = board[6][2].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[6][2];
                        }
                    } else if(e.getY() > 375){
                        if(board[5][2].getPiece() != null && board[5][2].getPiece().getColor() == turn){
                            curr = board[5][2].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[5][2];
                        }
                    } else if(e.getY() > 300){
                        if(board[4][2].getPiece() != null && board[4][2].getPiece().getColor() == turn){
                            curr = board[4][2].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[4][2];
                        }
                    } else if(e.getY() > 225){
                        if(board[3][2].getPiece() != null && board[3][2].getPiece().getColor() == turn){
                            curr = board[3][2].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[3][2];
                        }
                    } else if(e.getY() > 150){
                        if(board[2][2].getPiece() != null && board[2][2].getPiece().getColor() == turn){
                            curr = board[2][2].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[2][2];
                        }
                    } else if(e.getY() > 75){
                        if(board[1][2].getPiece() != null && board[1][2].getPiece().getColor() == turn){
                            curr = board[1][2].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[1][2];
                        }
                    } else {
                        if(board[0][2].getPiece() != null && board[0][2].getPiece().getColor() == turn){
                            curr = board[0][2].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[0][2];
                        }
                    }

                }  else if(e.getX() > 75){

                    if(e.getY() > 525) {
                        if(board[7][1].getPiece() != null && board[7][1].getPiece().getColor() == turn){
                            curr = board[7][1].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[7][1];
                        }
                    } else if(e.getY() > 450){
                        if(board[6][1].getPiece() != null && board[6][1].getPiece().getColor() == turn){
                            curr = board[6][1].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[6][1];
                        }
                    } else if(e.getY() > 375){
                        if(board[5][1].getPiece() != null && board[5][1].getPiece().getColor() == turn){
                            curr = board[5][1].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[5][1];
                        }
                    } else if(e.getY() > 300){
                        if(board[4][1].getPiece() != null && board[4][1].getPiece().getColor() == turn){
                            curr = board[4][1].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[4][1];
                        }
                    } else if(e.getY() > 225){
                        if(board[3][1].getPiece() != null && board[3][1].getPiece().getColor() == turn){
                            curr = board[3][1].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[3][1];
                        }
                    } else if(e.getY() > 150){
                        if(board[2][1].getPiece() != null && board[2][1].getPiece().getColor() == turn){
                            curr = board[2][1].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[2][1];
                        }
                    } else if(e.getY() > 75){
                        if(board[1][1].getPiece() != null && board[1][1].getPiece().getColor() == turn){
                            curr = board[1][1].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[1][1];
                        }
                    } else {
                        if(board[0][1].getPiece() != null && board[0][1].getPiece().getColor() == turn){
                            curr = board[0][1].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[0][1];
                        }
                    }

                } else {

                    if(e.getY() > 525) {
                        if(board[7][0].getPiece() != null && board[7][0].getPiece().getColor() == turn){
                            curr = board[7][0].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[7][0];
                        }
                    } else if(e.getY() > 450){
                        if(board[6][0].getPiece() != null && board[6][0].getPiece().getColor() == turn){
                            curr = board[6][0].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[6][0];
                        }
                    } else if(e.getY() > 375){
                        if(board[5][0].getPiece() != null && board[5][0].getPiece().getColor() == turn){
                            curr = board[5][0].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[5][0];
                        }
                    } else if(e.getY() > 300){
                        if(board[4][0].getPiece() != null && board[4][0].getPiece().getColor() == turn){
                            curr = board[4][0].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[4][0];
                        }
                    } else if(e.getY() > 225){
                        if(board[3][0].getPiece() != null && board[3][0].getPiece().getColor() == turn){
                            curr = board[3][0].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[3][0];
                        }
                    } else if(e.getY() > 150){
                        if(board[2][0].getPiece() != null && board[2][0].getPiece().getColor() == turn){
                            curr = board[2][0].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[2][0];
                        }
                    } else if(e.getY() > 75){
                        if(board[1][0].getPiece() != null && board[1][0].getPiece().getColor() == turn){
                            curr = board[1][0].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[1][0];
                        }
                    } else {
                        if(board[0][0].getPiece() != null && board[0][0].getPiece().getColor() == turn){
                            curr = board[0][0].getPiece();
                            possMoves = new ArrayList<Square>();
                            nMove = null;
                        } else if(moving){
                            nMove = board[0][0];
                        }
                    }

                }

                if(curr != null){
                    findAllMoves(curr);
                }

            }

        });

    }

//    public Square[][] deepCopyBoard(Square[][] board){
//        Square[][] boardClone = new Square[8][8];
//        for(int r = 0; r < board.length; r++){
//            for(int c = 0; c < board[r].length; c++){
//                boardClone[r][c] = new Square(board[r][c]);
//            }
//        }
//        return boardClone;
//    }
    private void findRookMoves(Piece curr){
        // up
        if(curr.getSquare().loc[0] > 0){
            for(int r = curr.getSquare().loc[0] - 1; r >= 0; r--){
                if(board[r][curr.getSquare().loc[1]].getPiece() == null){
                    //if(testPosition(curr, board[r][curr.getSquare().loc[1]]))
                        possMoves.add(board[r][curr.getSquare().loc[1]]);
                } else {
                    if(board[r][curr.getSquare().loc[1]].getPiece().getColor() != curr.getColor()){
                        //if(testPosition(curr, board[r][curr.getSquare().loc[1]]))
                            possMoves.add(board[r][curr.getSquare().loc[1]]);
                    }
                    break;
                }
            }
        }
        // down
        if(curr.getSquare().loc[0] < board.length - 1){
            for(int r = curr.getSquare().loc[0] + 1; r < board.length; r++){
                if(board[r][curr.getSquare().loc[1]].getPiece() == null){
                    //if(testPosition(curr, board[r][curr.getSquare().loc[1]]))
                        possMoves.add(board[r][curr.getSquare().loc[1]]);
                } else {
                    if(board[r][curr.getSquare().loc[1]].getPiece().getColor() != curr.getColor()){
                        //if(testPosition(curr, board[r][curr.getSquare().loc[1]]))
                            possMoves.add(board[r][curr.getSquare().loc[1]]);
                    }
                    break;
                }
            }
        }
        // left
        if(curr.getSquare().loc[1] > 0){
            for(int c = curr.getSquare().loc[1] - 1; c >= 0; c--){
                if(board[curr.getSquare().loc[0]][c].getPiece() == null){
                    //if(testPosition(curr, board[curr.getSquare().loc[0]][curr.getSquare().loc[1]]))
                        possMoves.add(board[curr.getSquare().loc[0]][c]);
                } else {
                    if(board[curr.getSquare().loc[0]][c].getPiece().getColor() != curr.getColor()){
                        //if(testPosition(curr, board[curr.getSquare().loc[0]][curr.getSquare().loc[1]]))
                            possMoves.add(board[curr.getSquare().loc[0]][c]);
                    }
                    break;
                }
            }
        }
        // right
        if(curr.getSquare().loc[1] < board[0].length - 1){
            for(int c = curr.getSquare().loc[1] + 1; c < board[0].length; c++){
                if(board[curr.getSquare().loc[0]][c].getPiece() == null){
                    //if(testPosition(curr, board[curr.getSquare().loc[0]][curr.getSquare().loc[1]]))
                        possMoves.add(board[curr.getSquare().loc[0]][c]);
                } else {
                    if(board[curr.getSquare().loc[0]][c].getPiece().getColor() != curr.getColor()){
                        //if(testPosition(curr, board[curr.getSquare().loc[0]][curr.getSquare().loc[1]]))
                            possMoves.add(board[curr.getSquare().loc[0]][c]);
                    }
                    break;
                }
            }
        }
    }
    private void findRookScope(Piece curr, Square[][] board){
        // up
        if(curr.getSquare().loc[0] > 0){
            for(int r = curr.getSquare().loc[0] - 1; r >= 0; r--){
                if(board[r][curr.getSquare().loc[1]].getPiece() == null){
                    scope.add(board[r][curr.getSquare().loc[1]]);
                } else {
                    if(!board[r][curr.getSquare().loc[1]].getPiece().getColor().equals(curr.getColor())){
                        scope.add(board[r][curr.getSquare().loc[1]]);
                    }
                    break;
                }
            }
        }
        // down
        if(curr.getSquare().loc[0] < board.length - 1){
            for(int r = curr.getSquare().loc[0] + 1; r < board.length; r++){
                if(board[r][curr.getSquare().loc[1]].getPiece() == null){
                    scope.add(board[r][curr.getSquare().loc[1]]);
                } else {
                    if(!board[r][curr.getSquare().loc[1]].getPiece().getColor().equals(curr.getColor())){
                        scope.add(board[r][curr.getSquare().loc[1]]);
                    }
                    break;
                }
            }
        }
        // left
        if(curr.getSquare().loc[1] > 0){
            for(int c = curr.getSquare().loc[1] - 1; c >= 0; c--){
                if(board[curr.getSquare().loc[0]][c].getPiece() == null){
                    scope.add(board[curr.getSquare().loc[0]][c]);
                } else {
                    if(!board[curr.getSquare().loc[0]][c].getPiece().getColor().equals(curr.getColor())){
                        scope.add(board[curr.getSquare().loc[0]][c]);
                    }
                    break;
                }
            }
        }
        // right
        if(curr.getSquare().loc[1] < board[0].length - 1){
            for(int c = curr.getSquare().loc[1] + 1; c < board[0].length; c++){
                if(board[curr.getSquare().loc[0]][c].getPiece() == null){
                    scope.add(board[curr.getSquare().loc[0]][c]);
                } else {
                    if(!board[curr.getSquare().loc[0]][c].getPiece().getColor().equals(curr.getColor())){
                        scope.add(board[curr.getSquare().loc[0]][c]);
                    }
                    break;
                }
            }
        }
    }
    private void findBishopMoves(Piece curr){

        // down+right
        if(curr.getSquare().loc[0] < board.length - 1 && curr.getSquare().loc[1] < board[0].length - 1){
            for(int r = curr.getSquare().loc[0] + 1, c = curr.getSquare().loc[1] + 1; r < board.length && c < board[r].length; r++, c++){
                if(board[r][c].getPiece() == null){
                    //if(testPosition(curr, board[r][c]))
                        possMoves.add(board[r][c]);
                } else {
                    if(board[r][c].getPiece().getColor() != curr.getColor()){
                        //if(testPosition(curr, board[r][c]))
                            possMoves.add(board[r][c]);
                    }
                    break;
                }
            }
        }

        // up+left
        if(curr.getSquare().loc[0] > 0 && curr.getSquare().loc[1] > 0){
            for(int r = curr.getSquare().loc[0] - 1, c = curr.getSquare().loc[1] - 1; r >= 0 && c >= 0; r--, c--){
                if(board[r][c].getPiece() == null){
                    //if(testPosition(curr, board[r][c]))
                        possMoves.add(board[r][c]);
                } else {
                    if(board[r][c].getPiece().getColor() != curr.getColor()){
                        //if(testPosition(curr, board[r][c]))
                            possMoves.add(board[r][c]);
                    }
                    break;
                }
            }
        }

        // up+right
        if(curr.getSquare().loc[0] > 0 && curr.getSquare().loc[1] < board[curr.getSquare().loc[0]].length - 1){
            for(int r = curr.getSquare().loc[0] - 1, c = curr.getSquare().loc[1] + 1; r >= 0 && c < board[r].length; r--, c++){
                if(board[r][c].getPiece() == null){
                    //if(testPosition(curr, board[r][c]))
                        possMoves.add(board[r][c]);
                } else {
                    if(board[r][c].getPiece().getColor() != curr.getColor()){
                        //if(testPosition(curr, board[r][c]))
                            possMoves.add(board[r][c]);
                    }
                    break;
                }
            }
        }

        // down+left
        if(curr.getSquare().loc[0] < board.length - 1 && curr.getSquare().loc[1] > 0){
            for(int r = curr.getSquare().loc[0] + 1, c = curr.getSquare().loc[1] - 1; r < board.length && c >= 0; r++, c--){
                if(board[r][c].getPiece() == null){
                    //if(testPosition(curr, board[r][c]))
                        possMoves.add(board[r][c]);
                } else {
                    if(board[r][c].getPiece().getColor() != curr.getColor()){
                        //if(testPosition(curr, board[r][c]))
                            possMoves.add(board[r][c]);
                    }
                    break;
                }
            }
        }

    }
    private void findBishopScope(Piece curr, Square[][] board){
        // down+right
        if(curr.getSquare().loc[0] < board.length - 1 && curr.getSquare().loc[1] < board[0].length - 1){
            for(int r = curr.getSquare().loc[0] + 1, c = curr.getSquare().loc[1] + 1; r < board.length && c < board[r].length; r++, c++){
                if(board[r][c].getPiece() == null){
                    scope.add(board[r][c]);
                } else {
                    if(!board[r][c].getPiece().getColor().equals(curr.getColor())){
                        scope.add(board[r][c]);
                    }
                    break;
                }
            }
        }
        // up+left
        if(curr.getSquare().loc[0] > 0 && curr.getSquare().loc[1] > 0){
            for(int r = curr.getSquare().loc[0] - 1, c = curr.getSquare().loc[1] - 1; r >= 0 && c >= 0; r--, c--){
                if(board[r][c].getPiece() == null){
                    scope.add(board[r][c]);
                } else {
                    if(!board[r][c].getPiece().getColor().equals(curr.getColor())){
                        scope.add(board[r][c]);
                    }
                    break;
                }
            }
        }
        // up+right
        if(curr.getSquare().loc[0] > 0 && curr.getSquare().loc[1] < board[curr.getSquare().loc[0]].length - 1){
            for(int r = curr.getSquare().loc[0] - 1, c = curr.getSquare().loc[1] + 1; r >= 0 && c < board[r].length; r--, c++){
                if(board[r][c].getPiece() == null){
                    scope.add(board[r][c]);
                } else {
                    if(!board[r][c].getPiece().getColor().equals(curr.getColor())){
                        scope.add(board[r][c]);
                    }
                    break;
                }
            }
        }
        // down+left
        if(curr.getSquare().loc[0] < board.length - 1 && curr.getSquare().loc[1] > 0){
            for(int r = curr.getSquare().loc[0] + 1, c = curr.getSquare().loc[1] - 1; r < board.length && c >= 0; r++, c--){
                if(board[r][c].getPiece() == null){
                    scope.add(board[r][c]);
                } else {
                    if(!board[r][c].getPiece().getColor().equals(curr.getColor())){
                        scope.add(board[r][c]);
                    }
                    break;
                }
            }
        }
    }

    public void findPawnMoves(Piece curr){

        // first pawn move
        if(((Pawn)(curr)).getMoves() == 0){
            for(int r = curr.getSquare().loc[0] - 1; r >= curr.getSquare().loc[0] - 2; r--){
                if(board[r][curr.getSquare().loc[1]].getPiece() == null) {
                    //if(testPosition(curr, board[r][curr.getSquare().loc[1]]))
                        possMoves.add(board[r][curr.getSquare().loc[1]]);
                }
            }
        }

        // up 1
        if(curr.getSquare().loc[0] > 0 && board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]].getPiece() == null)
            //if(testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]]))
                possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]]);

        // up 1, left 1
        if(curr.getSquare().loc[0] * curr.getSquare().loc[1] > 0 && board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1].getPiece() != null)
            if(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1].getPiece().getColor() != turn)
                //if(testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1]))
                    possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1]);

        // up 1, right 1
        if((curr.getSquare().loc[0] > 0 && curr.getSquare().loc[1] < board[0].length - 1) && board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1].getPiece() != null)
            if(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1].getPiece().getColor() != turn)
                //if(testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1]))
                    possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1]);

    }
    public void findPawnScope(Piece curr, Square[][] board){

        // up 1, left 1
        if(curr.getSquare().loc[0] * curr.getSquare().loc[1] > 0 && board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1].getPiece() != null)
            if(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1].getPiece().getColor() != curr.getColor())
                scope.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1]);

        // up 1, right 1
        if((curr.getSquare().loc[0] > 0 && curr.getSquare().loc[1] < board[0].length - 1) && board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1].getPiece() != null)
            if(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1].getPiece().getColor() != curr.getColor())
                scope.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1]);

    }
    public void findKnightMoves(Piece curr){

        // up 2, left 1
        if(curr.getSquare().loc[0] > 1 && curr.getSquare().loc[1] > 0) {
            if (board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] - 1].getPiece() != null) {
                if (board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] - 1].getPiece().getColor() != curr.getColor())
                    //if(testPosition(curr, board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] - 1]))
                    possMoves.add(board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] - 1]);
            } else {
                //if(testPosition(curr, board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] - 1]))
                possMoves.add(board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] - 1]);
            }
        }

        // up 2, right 1
        if(curr.getSquare().loc[0] > 1 && curr.getSquare().loc[1] < board[0].length) {
            if (board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] + 1].getPiece() != null) {
                if (board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] + 1].getPiece().getColor() != curr.getColor())
                    //if(testPosition(curr, board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] + 1]))
                    possMoves.add(board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] + 1]);
            } else {
                //if(testPosition(curr, board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] + 1]))
                possMoves.add(board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] + 1]);
            }
        }

        // down 2, left 1
        if(curr.getSquare().loc[0] < board.length - 2 && curr.getSquare().loc[1] > 0) {
            if (board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] - 1].getPiece() != null) {
                if (board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] - 1].getPiece().getColor() != curr.getColor())
                    //if(testPosition(curr, board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] - 1]))
                    possMoves.add(board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] - 1]);
            } else {
                //if(testPosition(curr, board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] - 1]))
                possMoves.add(board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] - 1]);
            }
        }

        // down 2, right 1
        if(curr.getSquare().loc[0] < board.length - 2 && curr.getSquare().loc[1] < board[0].length) {
            if (board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] + 1].getPiece() != null) {
                if (board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] + 1].getPiece().getColor() != curr.getColor())
                    //if(testPosition(curr, board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] + 1]))
                    possMoves.add(board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] + 1]);
            } else {
                //if(testPosition(curr, board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] + 1]))
                possMoves.add(board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] + 1]);
            }
        }

        // up 1, left 2
        if(curr.getSquare().loc[0] > 0 && curr.getSquare().loc[1] > 1) {
            if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2].getPiece() != null) {
                if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2].getPiece().getColor() != curr.getColor())
                    //if(testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2]))
                    possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2]);
            } else {
                //if(testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2]))
                possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2]);
            }
        }

        // up 1, right 2
        if(curr.getSquare().loc[0] > 0 && curr.getSquare().loc[1] < board[0].length - 2) {
            if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 2].getPiece() != null) {
                if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 2].getPiece().getColor() != curr.getColor())
                    //if(testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2]))
                    possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2]);
            } else {
                //if(testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2]))
                possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 2]);
            }
        }

        // down 1, left 2
        if(curr.getSquare().loc[0] < board.length - 1 && curr.getSquare().loc[1] > 1) {
            if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 2].getPiece() != null) {
                if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 2].getPiece().getColor() != curr.getColor())
                    //if(testPosition(curr, board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 2]))
                    possMoves.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 2]);
            } else {
                //if(testPosition(curr, board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 2]))
                possMoves.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 2]);
            }
        }

        // down 1, right 2
        if(curr.getSquare().loc[0] < board.length - 1 && curr.getSquare().loc[1] < board[0].length - 2) {
            if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 2].getPiece() != null) {
                if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 2].getPiece().getColor() != curr.getColor())
                    //if(testPosition(curr, board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 2]))
                    possMoves.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 2]);
            } else {
                //if(testPosition(curr, board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 2]))
                possMoves.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 2]);
            }
        }

    }
    public void findKnightScope(Piece curr, Square[][] board){

        // up 2, left 1
        if(curr.getSquare().loc[0] > 1 && curr.getSquare().loc[1] > 0)
            if(board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] - 1].getPiece() != null) {
                if (!board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] - 1].getPiece().getColor().equals(curr.getColor()))
                    scope.add(board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] - 1]);
            } else {
                scope.add(board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] - 1]);
            }

        // up 2, right 1
        if(curr.getSquare().loc[0] > 1 && curr.getSquare().loc[1] < board[0].length)
            if(board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] + 1].getPiece() != null) {
                if (!board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] + 1].getPiece().getColor().equals(curr.getColor()))
                    scope.add(board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] + 1]);
            } else {
                scope.add(board[curr.getSquare().loc[0] - 2][curr.getSquare().loc[1] + 1]);
            }

        // down 2, left 1
        if(curr.getSquare().loc[0] < board.length - 2 && curr.getSquare().loc[1] > 0)
            if(board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] - 1].getPiece() != null) {
                if (!board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] - 1].getPiece().getColor().equals(curr.getColor()))
                    scope.add(board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] - 1]);
            } else {
                scope.add(board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] - 1]);
            }

        // down 2, right 1
        if(curr.getSquare().loc[0] < board.length - 2 && curr.getSquare().loc[1] < board[0].length)
            if(board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] + 1].getPiece() != null) {
                if (!board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] + 1].getPiece().getColor().equals(curr.getColor()))
                    scope.add(board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] + 1]);
            } else {
                scope.add(board[curr.getSquare().loc[0] + 2][curr.getSquare().loc[1] + 1]);
            }

        // up 1, left 2
        if(curr.getSquare().loc[0] > 0 && curr.getSquare().loc[1] > 1)
            if(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2].getPiece() != null) {
                if (!board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2].getPiece().getColor().equals(curr.getColor()))
                    scope.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2]);
            } else {
                scope.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 2]);
            }

        // up 1, right 2
        if(curr.getSquare().loc[0] > 0 && curr.getSquare().loc[1] < board[0].length - 2)
            if(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 2].getPiece() != null) {
                if (!board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 2].getPiece().getColor().equals(curr.getColor()))
                    scope.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 2]);
            } else {
                scope.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 2]);
            }

        // down 1, left 2
        if(curr.getSquare().loc[0] < board.length - 1 && curr.getSquare().loc[1] > 1)
            if(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 2].getPiece() != null) {
                if (!board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 2].getPiece().getColor().equals(curr.getColor()))
                    scope.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 2]);
            } else {
                scope.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 2]);
            }

        // down 1, right 2
        if(curr.getSquare().loc[0] < board.length - 1 && curr.getSquare().loc[1] < board[0].length - 2)
            if(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 2].getPiece() != null) {
                if (!board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 2].getPiece().getColor().equals(curr.getColor()))
                    scope.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 2]);
            } else {
                scope.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 2]);
            }

    }
    public void findKingMoves(Piece curr){

        // up 1
        if(curr.getSquare().loc[0] > 0) {
            if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]].getPiece() == null) {
                //if (testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]]))
                    possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]]);
            } else if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]].getPiece().getColor() != turn) {
                //if (testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]]))
                    possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]]);
            }
        }

        // down 1
        if(curr.getSquare().loc[0] < board[0].length - 1) {
            if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1]].getPiece() == null) {
                //if (testPosition(curr, board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1]]))
                    possMoves.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1]]);
            } else if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1]].getPiece().getColor() != turn) {
                //if (testPosition(curr, board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1]]))
                    possMoves.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1]]);
            }
        }

        // left 1
        if(curr.getSquare().loc[1] > 0) {
            if (board[curr.getSquare().loc[0]][curr.getSquare().loc[1] - 1].getPiece() == null) {
                //if (testPosition(curr, board[curr.getSquare().loc[0]][curr.getSquare().loc[1] - 1]))
                    possMoves.add(board[curr.getSquare().loc[0]][curr.getSquare().loc[1] - 1]);
            } else if (board[curr.getSquare().loc[0]][curr.getSquare().loc[1] - 1].getPiece().getColor() != turn) {
                //if (testPosition(curr, board[curr.getSquare().loc[0]][curr.getSquare().loc[1] - 1]))
                    possMoves.add(board[curr.getSquare().loc[0]][curr.getSquare().loc[1] - 1]);
            }
        }

        // right 1
        if(curr.getSquare().loc[1] < board.length - 1) {
            if (board[curr.getSquare().loc[0]][curr.getSquare().loc[1] + 1].getPiece() == null) {
                //if (testPosition(curr, board[curr.getSquare().loc[0]][curr.getSquare().loc[1] + 1]))
                    possMoves.add(board[curr.getSquare().loc[0]][curr.getSquare().loc[1] + 1]);
            } else if (board[curr.getSquare().loc[0]][curr.getSquare().loc[1] + 1].getPiece().getColor() != turn) {
                //if (testPosition(curr, board[curr.getSquare().loc[0]][curr.getSquare().loc[1] + 1]))
                    possMoves.add(board[curr.getSquare().loc[0]][curr.getSquare().loc[1] + 1]);
            }
        }

        // up 1, left 1
        if(curr.getSquare().loc[0] * curr.getSquare().loc[1] > 0) {
            if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1].getPiece() == null) {
                //if (testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1]))
                    possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1]);
            } else if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1].getPiece().getColor() != turn) {
                //if (testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1]))
                    possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1]);
            }
        }

        // up 1, right 1
        if((curr.getSquare().loc[0] > 0 && curr.getSquare().loc[1] < board[0].length - 1)) {
            if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1].getPiece() == null) {
                //if (testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1]))
                    possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1]);
            } else if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1].getPiece().getColor() != turn) {
                //if (testPosition(curr, board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1]))
                    possMoves.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1]);
            }
        }

        // down 1, left 1
        if(curr.getSquare().loc[0] < board.length - 1 && curr.getSquare().loc[1] > 0) {
            if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 1].getPiece() == null) {
                //if (testPosition(curr, board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 1]))
                    possMoves.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 1]);
            } else if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 1].getPiece().getColor() != turn) {
                //if (testPosition(curr, board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 1]))
                    possMoves.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 1]);
            }
        }

        // down 1, right 1
        if((curr.getSquare().loc[0] < board.length - 1 && curr.getSquare().loc[1] < board[0].length - 1)) {
            if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 1].getPiece() == null) {
                //if (testPosition(curr, board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 1]))
                    possMoves.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 1]);
            } else if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 1].getPiece().getColor() != turn) {
                //if (testPosition(curr, board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 1]))
                    possMoves.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 1]);
            }
        }
        if(((King)(curr)).getMoves() == 0 && curr.getSquare().name.contains("e")){
            if(curr.getColor() == Color.WHITE){
                if(board[7][0].getPiece().getClass() == Rook.class && board[7][0].getPiece().getColor() == curr.getColor() && ((Rook)(board[7][0].getPiece())).getMoves() == 0) {
                    if(board[7][1].getPiece() == null && board[7][2].getPiece() == null && board[7][3].getPiece() == null) {
                        possMoves.add(board[7][2]);
                        whiteCastle = true;
                    }
                }
                if(board[7][7].getPiece().getClass() == Rook.class && board[7][7].getPiece().getColor() == curr.getColor() && ((Rook)(board[7][7].getPiece())).getMoves() == 0) {
                    if(board[7][6].getPiece() == null && board[7][5].getPiece() == null) {
                        possMoves.add(board[7][6]);
                        whiteCastle = true;
                    }
                }
            } else {
                if(board[7][0].getPiece().getClass() == Rook.class && board[7][0].getPiece().getColor() == curr.getColor() && ((Rook)(board[7][0].getPiece())).getMoves() == 0) {
                    if(board[7][1].getPiece() == null && board[7][2].getPiece() == null) {
                        possMoves.add(board[7][1]);
                        blackCastle = true;
                    }
                }
                if(board[7][7].getPiece().getClass() == Rook.class && board[7][7].getPiece().getColor() == curr.getColor() && ((Rook)(board[7][7].getPiece())).getMoves() == 0) {
                    if(board[7][6].getPiece() == null && board[7][5].getPiece() == null && board[7][4].getPiece() == null) {
                        possMoves.add(board[7][5]);
                        blackCastle = true;
                    }
                }
            }
        }

    }
    public void findKingScope(Piece curr, Square[][] board){

        // up 1
        if(curr.getSquare().loc[0] > 0) {
            if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]].getPiece() == null) {
                scope.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]]);
            } else if (!board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]].getPiece().getColor().equals(curr.getColor())) {
                scope.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1]]);
            }
        }

        // down 1
        if(curr.getSquare().loc[0] < board[0].length - 1) {
            if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1]].getPiece() == null) {
                scope.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1]]);
            } else if (!board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1]].getPiece().getColor().equals(curr.getColor())) {
                scope.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1]]);
            }
        }

        // left 1
        if(curr.getSquare().loc[1] > 0) {
            if (board[curr.getSquare().loc[0]][curr.getSquare().loc[1] - 1].getPiece() == null) {
                scope.add(board[curr.getSquare().loc[0]][curr.getSquare().loc[1] - 1]);
            } else if (!board[curr.getSquare().loc[0]][curr.getSquare().loc[1] - 1].getPiece().getColor().equals(curr.getColor())) {
                scope.add(board[curr.getSquare().loc[0]][curr.getSquare().loc[1] - 1]);
            }
        }

        // right 1
        if(curr.getSquare().loc[1] < board.length - 1) {
            if (board[curr.getSquare().loc[0]][curr.getSquare().loc[1] + 1].getPiece() == null) {
                scope.add(board[curr.getSquare().loc[0]][curr.getSquare().loc[1] + 1]);
            } else if (!board[curr.getSquare().loc[0]][curr.getSquare().loc[1] + 1].getPiece().getColor().equals(curr.getColor())) {
                scope.add(board[curr.getSquare().loc[0]][curr.getSquare().loc[1] + 1]);
            }
        }

        // up 1, left 1
        if(curr.getSquare().loc[0] * curr.getSquare().loc[1] > 0) {
            if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1].getPiece() == null) {
                scope.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1]);
            } else if (!board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1].getPiece().getColor().equals(curr.getColor())) {
                scope.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] - 1]);
            }
        }

        // up 1, right 1
        if((curr.getSquare().loc[0] > 0 && curr.getSquare().loc[1] < board[0].length - 1)) {
            if (board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1].getPiece() == null) {
                scope.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1]);
            } else if (!board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1].getPiece().getColor().equals(curr.getColor())) {
                scope.add(board[curr.getSquare().loc[0] - 1][curr.getSquare().loc[1] + 1]);
            }
        }

        // down 1, left 1
        if(curr.getSquare().loc[0] < board.length - 1 && curr.getSquare().loc[1] > 0) {
            if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 1].getPiece() == null) {
                scope.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 1]);
            } else if (!board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 1].getPiece().getColor().equals(curr.getColor())) {
                scope.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] - 1]);
            }
        }

        // down 1, right 1
        if((curr.getSquare().loc[0] < board.length - 1 && curr.getSquare().loc[1] < board[0].length - 1)) {
            if (board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 1].getPiece() == null) {
                scope.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 1]);
            } else if (!board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 1].getPiece().getColor().equals(curr.getColor())) {
                scope.add(board[curr.getSquare().loc[0] + 1][curr.getSquare().loc[1] + 1]);
            }
        }

    }
//    public Piece getWhiteKing(Square[][] board){
//        for(int r = 0; r < board.length; r++){
//            for(int c = 0; c < board[r].length; c++){
//                if(board[r][c].getPiece() != null && board[r][c].getPiece().getColor() == Color.WHITE && board[r][c].getPiece().getValue() == -1)
//                    return board[r][c].getPiece();
//            }
//        }
//        return null;
//    }

//    public Piece getBlackKing(Square[][] board){
//        for(int r = 0; r < board.length; r++){
//            for(int c = 0; c < board[r].length; c++){
//                if(board[r][c].getPiece() != null && board[r][c].getPiece().getColor() == Color.BLACK && board[r][c].getPiece().getValue() == -1)
//                    return board[r][c].getPiece();
//            }
//        }
//        return null;
//    }

    // NOT WORKING
    // always returns true
//    public boolean testPosition(Piece test, Square move){
//
//        Square [][] tempBoard = deepCopyBoard(this.board);
//
//        Square tempSquare = tempBoard[test.getSquare().loc[0]][test.getSquare().loc[1]];
//        tempBoard[move.loc[0]][move.loc[1]].setPiece(tempBoard[test.getSquare().loc[0]][test.getSquare().loc[1]].getPiece());
//        tempSquare.setPiece(null);
//
//        System.out.println(tempBoard[move.loc[0]][move.loc[1]].getPiece());
//        tempBoard = flipBoard(tempBoard);
//        System.out.println("\n");
//        for(int r = 0; r < tempBoard.length; r++){
//            for(int c = 0; c < tempBoard[r].length; c++){
//                System.out.print(tempBoard[r][c].name + "(" + tempBoard[r][c].loc[0] + "," + tempBoard[r][c].loc[1] + ")\t");
//            }
//            System.out.println();
//        }
//
//        Piece tempBK = getBlackKing(tempBoard);
//        Piece tempWK = getWhiteKing(tempBoard);
//
//        if(tempBoard[0][0].name.equals("h1")){
//            System.out.println("White King: " + tempWK.getSquare());
//            for(int r = 0; r < tempBoard.length; r++){
//                for(int c = 0; c < tempBoard[r].length; c++){
//                    if(tempBoard[r][c].getPiece() != null && tempBoard[r][c].getPiece().getColor() == Color.BLACK){
//                        findScope(tempBoard[r][c].getPiece(), tempBoard);
//                        System.out.println("Scope for piece at " + tempBoard[r][c].name + ": " + scope);
//                        System.out.println(tempBoard[r][c].name + ": [" + tempBoard[r][c].loc[0] + "] [" + tempBoard[r][c].loc[1] + "]");
//                        for(Square square: scope){
//                            if(square.name.equals(tempBK.getSquare().name)){
//                                System.out.println(move.name + " is not valid.");
//                                return false;
//                            }
//                        }
//                    }
//                }
//            }
//        } else if (tempBoard[0][0].name.equals("a8")){
//            System.out.println("Black King: " + tempBK.getSquare());
//            for(int r = 0; r < tempBoard.length; r++){
//                for(int c = 0; c < tempBoard[r].length; c++){
//                    if(tempBoard[r][c].getPiece() != null && tempBoard[r][c].getPiece().getColor() == Color.WHITE){
//                        findScope(tempBoard[r][c].getPiece(), tempBoard);
//                        System.out.println("Scope for piece at " + tempBoard[r][c].name + ": " + scope);
//                        System.out.println(tempBoard[r][c].name + ": [" + tempBoard[r][c].loc[0] + "] [" + tempBoard[r][c].loc[1] + "]");
//                        for(Square square: scope){
//                            if(square.name.equals(tempBK.getSquare().name)){
//                                System.out.println(move.name + " is not valid.");
//                                return false;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println("King not in scope (" + move.name + " = Valid)");
//        return true;
//
//    }

    private void findAllMoves(Piece curr){

        moving = true;
        whiteCastle = false;
        blackCastle = false;

        if (curr instanceof Queen && curr.getValue() == 9) {
            findRookMoves(curr);
            findBishopMoves(curr);
        } else if(curr instanceof Rook && curr.getValue() == 5){
            findRookMoves(curr);
        } else if(curr instanceof Bishop && curr.getValue() == 3){
            findBishopMoves(curr);
        } else if(curr instanceof Knight && curr.getValue() == 3){
            findKnightMoves(curr);
        } else if(curr instanceof Pawn && curr.getValue() == 1){
            findPawnMoves(curr);
        } else {
            findKingMoves(curr);
        }

    }

//    public void findScope(Piece curr, Square[][] board){
//
//        scope.clear();
//
//        if (curr instanceof Queen && curr.getValue() == 9) {
//            findRookScope(curr, board);
//            findBishopScope(curr, board);
//        } else if(curr instanceof Rook && curr.getValue() == 5){
//            findRookScope(curr, board);
//        } else if(curr instanceof Bishop && curr.getValue() == 3){
//            findBishopScope(curr, board);
//        } else if(curr instanceof Knight && curr.getValue() == 3){
//            findKnightScope(curr, board);
//        } else if(curr instanceof Pawn && curr.getValue() == 1){
//            findPawnScope(curr, board);
//        } else {
//            findKingScope(curr, board);
//        }
//
//    }

    public Square[][] flipBoard(Square[][] board){
        Square[][] tempBoard = new Square[8][8];
        for(int c1 = 7, c2 = 0; c1 >= 0 && c2 < 8; c1--, c2++){
            for(int r1 = 7, r2 = 0; r1 >= 0 && r2 < 8; r1--, r2++){
                tempBoard[r2][c2] = board[r1][c1];
                tempBoard[r2][c2].loc[0] = r2;
                tempBoard[r2][c2].loc[1] = c2;
            }
        }
        return tempBoard;
    }

    public void movePiece(Piece c, Square n){

        Square temp = c.getSquare();
        n.setPiece(c);
        temp.setPiece(null);
        if(c.getValue() == 1){
            ((Pawn)(c)).move();
        } else if(c.getValue() == 5){
            ((Rook)(c)).move();
        } else if(c.getValue() == -1) {
            ((King)(c)).move();
        }
        if(turn == Color.WHITE){
            if(whiteCastle) {
                if (c.getSquare().loc == board[7][2].loc) {
                    board[7][3].setPiece(board[7][0].getPiece());
                    board[7][0].setPiece(null);
                } else if(c.getSquare().loc == board[7][6].loc){
                    board[7][5].setPiece(board[7][7].getPiece());
                    board[7][7].setPiece(null);
                }
            }
        } else {
            if(blackCastle){
                if (c.getSquare().loc == board[7][1].loc) {
                    board[7][2].setPiece(board[7][0].getPiece());
                    board[7][0].setPiece(null);
                } else if(c.getSquare().loc == board[7][5].loc){
                    board[7][4].setPiece(board[7][7].getPiece());
                    board[7][7].setPiece(null);
                }
            }
        }
        possMoves = new ArrayList<Square>();
        moving = false;
        if(turn == Color.WHITE){
            turn = Color.BLACK;
            board = flipBoard(board);
        } else {
            turn = Color.WHITE;
            board = flipBoard(board);
        }
        scope.clear();
        curr = null;
        nMove = null;

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (int r = 0, y = 0; r < board.length; r++, y += 75) {
            for (int c = 0, x = 0; c < board[r].length; c++, x += 75) {

                if (board[r][c].isColored())
                    g.setColor(new Color(76, 187, 23));
                else
                    g.setColor(Color.WHITE);

                g.fillRect(x, y, 75, 75);
                if (board[r][c].getPiece() != null)
                    g.drawImage(board[r][c].getPiece().getPic().getImage(), x, y, 75, 75, null);

            }
        }

        g.setColor(new Color(255, 127, 127));
        if (!possMoves.isEmpty()) {
            for (int r = 0, y = 0; r < board.length; r++, y += 75) {
                for (int c = 0, x = 0; c < board[r].length; c++, x += 75) {
                    if (possMoves.contains(board[r][c])) {
                        g.fillOval(x + 25, y + 25, 25, 25);
                    }
                }
            }
        }

        if(moving && nMove != null && possMoves.contains(nMove))
            movePiece(curr, nMove);

        if(whiteKing != whiteKing.getSquare().getPiece()){
            g.setColor(new Color(255, 127, 127));
            g.setFont(new Font("SansSerif", Font.PLAIN, 65));
            int textWidth = g.getFontMetrics().stringWidth("Black Wins!");
            g.drawString("Black Wins!", (300 - textWidth / 2), 325);
            gameOver = true;
            this.setFocusable(false);
        } else if(blackKing != blackKing.getSquare().getPiece()){
            g.setColor(new Color(255, 127, 127));
            g.setFont(new Font("SansSerif", Font.PLAIN, 65));
            int textWidth = g.getFontMetrics().stringWidth("White Wins!");
            g.drawString("White Wins!", (300 - textWidth / 2), 325);
            gameOver = true;
            this.setFocusable(false);
        }
        if(gameOver) {
            timer++;
        }

        if(timer > 150){
            if(whiteKing != whiteKing.getSquare().getPiece() || blackKing != blackKing.getSquare().getPiece()){
                JFrame playAgain = new JFrame("Menu");
                playAgain.setSize(600, 625);
                playAgain.setLocationRelativeTo(null);
                playAgain.setResizable(false);
                playAgain.add(new PlayMenu());
                playAgain.setVisible(true);
                playAgain.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }
                    @Override
                    public void keyPressed(KeyEvent e) {
                        if(e.getKeyCode() == KeyEvent.VK_DOWN){
                            PlayMenu.quit = true;
                            PlayMenu.start = false;
                            System.out.println("down");
                        }
                        if(e.getKeyCode() == KeyEvent.VK_UP){
                            PlayMenu.start = true;
                            PlayMenu.quit = false;
                            System.out.println("up");
                        }
                        if(e.getKeyCode() == KeyEvent.VK_ENTER){
                            if(PlayMenu.start){
                                playAgain.setVisible(false);
                                JFrame gameFrame = new JFrame("Chess");
                                gameFrame.setSize(600, 625);
                                gameFrame.setLocationRelativeTo(null);
                                gameFrame.setResizable(false);
                                gameFrame.add(new MyPanel());
                                gameFrame.setVisible(true);
                            } else if(PlayMenu.quit){
                                System.exit(0);
                            }
                            System.out.println("enter");
                        }
                    }
                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
                this.setVisible(false);
            }
        }

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        repaint();

    }

}