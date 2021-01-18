package gui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AngriffsKarten extends JFrame {
    private final Image img = ImageIO.read(new File("src\\resources\\other\\einheiten.png"));

    public AngriffsKarten() throws IOException {
        initComponents();
    }

    private void initComponents() {
        setVisible(true);
        setMinimumSize(new Dimension(430, 300));
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        //img
        Image i = img.getScaledInstance(430, 212, Image.SCALE_SMOOTH);
        JLabel imgLabel= new JLabel();
        imgLabel.setIcon(new ImageIcon(i));
        imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(imgLabel);

        //label
        JLabel label= new JLabel();
        label.setText("Wie viele Sterne wollen Sie geben Truppen eintauschen?");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(label);

        //label2
        JLabel label2 = new JLabel();
        label2.setText("Sie haben [ ]");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(label2);

        //confirmButton
        JButton confirmButton= new JButton();
        confirmButton.setText("Bestätigen");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(confirmButton);

        //cancelButton
        JButton cancelButton= new JButton();
        cancelButton.setText("Abrechen");
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(cancelButton);

        pack();
        setLocationRelativeTo(getOwner());
    }
}
