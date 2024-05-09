import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {

    public static void main(String[] args){

        JFrame gameFrame = new JFrame("Chess");
        gameFrame.setSize(600, 625);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(false);
        MyPanel panel = new MyPanel();
        gameFrame.add(panel);

        JFrame menuFrame = new JFrame("Menu");
        menuFrame.setSize(600, 625);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setResizable(false);
        menuFrame.add(new Menu());
        menuFrame.setVisible(true);

        menuFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == KeyEvent.VK_DOWN){

                    Menu.quit = true;
                    Menu.start = false;
                    System.out.println("down");

                }

                if(e.getKeyCode() == KeyEvent.VK_UP){

                    Menu.start = true;
                    Menu.quit = false;
                    System.out.println("up");

                }

                if(e.getKeyCode() == KeyEvent.VK_ENTER){

                    if(Menu.start){

                        menuFrame.setVisible(false);
                        gameFrame.setVisible(true);

                    } else if(Menu.quit){

                        System.exit(0);

                    }

                    System.out.println("enter");

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

}