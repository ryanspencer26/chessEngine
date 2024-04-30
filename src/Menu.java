import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel{

    public static boolean start;
    public static boolean quit;
    private final ImageIcon background = new ImageIcon("Backgrounds/chessBackground.png");

    public Menu(){

        setBackground(Color.LIGHT_GRAY);
        start = true;
        quit = false;

    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        g.drawImage(background.getImage(), 0, 0, null);

        if(start && !quit){

            g.setFont(new Font("SansSerif", Font.PLAIN, 65));
            g.setColor(Color.WHITE);
            int textWidth1 = g.getFontMetrics().stringWidth("Pass & Play Chess");
            g.drawString("Pass & Play Chess", (300 - textWidth1 / 2), 200);
            g.setFont(new Font("SansSerif", Font.PLAIN, 35));
            g.setColor(new Color(255, 16, 240));
            int textWidth2 = g.getFontMetrics().stringWidth("Start");
            g.drawString("Start", (300 - textWidth2 / 2), 450);
            g.setColor(Color.WHITE);
            int textWidth3 = g.getFontMetrics().stringWidth("Quit");
            g.drawString("Quit", (300 - textWidth3 / 2), 500);
            g.setFont(new Font("SansSerif", Font.ITALIC, 15));
            int textWidth4 = g.getFontMetrics().stringWidth("Use up/down/enter keys to navigate menu");
            g.drawString("Use up/down/enter keys to navigate menu", (300 - textWidth4 / 2), 250);

        } else if(!start && quit) {

            g.setFont(new Font("SansSerif", Font.PLAIN, 65));
            g.setColor(Color.WHITE);
            int textWidth1 = g.getFontMetrics().stringWidth("Pass & Play Chess");
            g.drawString("Pass & Play Chess", (300 - textWidth1 / 2), 200);
            g.setFont(new Font("SansSerif", Font.PLAIN, 35));
            int textWidth2 = g.getFontMetrics().stringWidth("Start");
            g.drawString("Start", (300 - textWidth2 / 2), 450);
            g.setColor(new Color(255, 16, 240));
            int textWidth3 = g.getFontMetrics().stringWidth("Quit");
            g.drawString("Quit", (300 - textWidth3 / 2), 500);
            g.setColor(Color.WHITE);
            g.setFont(new Font("SansSerif", Font.ITALIC, 15));
            int textWidth4 = g.getFontMetrics().stringWidth("Use up/down/enter keys to navigate menu");
            g.drawString("Use up/down/enter keys to navigate menu", (300 - textWidth4 / 2), 250);

        }

        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        repaint();

    }

}