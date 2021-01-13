package gui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Start extends JFrame {

    private final Image img = ImageIO.read(new File("resources/other/Risiko_Logo.png"));

    public Start() throws IOException {
        initComponents();
    }

    private void initComponents() {

        JPanel vSpacer1 = new JPanel(null);
        JButton button1 = new JButton();
        JPanel vSpacer2 = new JPanel(null);
        JButton button2 = new JButton();
        JPanel vSpacer3 = new JPanel(null);
        JPanel vSpacer4 = new JPanel(null);

        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setMinimumSize(new Dimension(267, 430));
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(vSpacer1);

        //label1
        JLabel label1 = new JLabel();
        label1.setText("");
        ImageIcon icon = new ImageIcon(img);
        label1.setIcon(icon);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(label1);
        contentPane.add(vSpacer2);

        //button1
        button1.setText("Spiel starten");
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(button1);
        contentPane.add(vSpacer3);

        //button2
        button2.setText("Regeln");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(button2);
        contentPane.add(vSpacer4);
        pack();
        setLocationRelativeTo(getOwner());
    }
}