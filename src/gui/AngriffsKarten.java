package gui;

import classes.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AngriffsKarten extends JFrame {
    private final Image img = ImageIO.read(new File("src\\resources\\other\\einheiten.png"));

    private JButton confirmButton;
    private Player player;

    public AngriffsKarten(Player player) throws IOException {
        this.player = player;

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
        JLabel imgLabel = new JLabel();
        imgLabel.setIcon(new ImageIcon(i));
        imgLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(imgLabel);

        //label
        JLabel label = new JLabel();
        label.setText("Wie viele Sterne wollen Sie geben Truppen eintauschen?");
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(label);

        //label2
        JLabel label2 = new JLabel();
        label2.setText("Sie haben " + player.getSterne() + " Sterne.");
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(label2);

        //spinner
        JSpinner spinner = new JSpinner();
        spinner.setMaximumSize(new Dimension(121, 23));
        spinner.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(spinner);

        //confirmButton
        confirmButton = new JButton();
        confirmButton.addActionListener(new TileListener());
        confirmButton.setText("Bestätigen");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(confirmButton);

        //cancelButton
        JButton cancelButton = new JButton();
        cancelButton.setText("Abrechen");
        cancelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(cancelButton);

        pack();
        setLocationRelativeTo(getOwner());
    }

    class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton btn  = (JButton) e.getSource();

            if(btn.equals(confirmButton)){

            }
        }

    }


}
