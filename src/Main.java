import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args){

        JFrame frame = new JFrame("Chess");

        MyPanel panel = new MyPanel();

        frame.setSize(600, 625);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        frame.add(panel);

        frame.setVisible(true);

    }

}