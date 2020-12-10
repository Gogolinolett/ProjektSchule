package gui;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{
    private Icon icon = new ImageIcon("src\\resources\\map.png");

    public Game(){
        setTitle("risiko");
        setLayout(new GridBagLayout());
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);


        JLabel label = new JLabel("", icon, JLabel.CENTER);
        label.setBounds(0, 0, 1000, 1000);


        label.setIcon(icon);

        add(label);
        pack();
    }

    public static void main(String args[]) {
        Game game = new Game();
    }
}
