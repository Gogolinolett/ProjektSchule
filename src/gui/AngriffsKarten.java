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
    private JSpinner spinner;
    private JButton cancelButton;

    public AngriffsKarten(Player player) throws IOException {
        this.player = player;

        initComponents();
    }

    private void initComponents() throws IOException {
        setVisible(true);
        setMinimumSize(new Dimension(430, 300));
        setResizable(false);
        setIconImage(ImageIO.read(new File("src\\resources\\other\\star.png")));
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
        spinner = new JSpinner();
        if(player.getSterne() < 10){
            spinner.setModel(new SpinnerNumberModel(0, 0, player.getSterne(), 1));
        }else{
            spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        }

        spinner.setMaximumSize(new Dimension(121, 23));
        spinner.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(spinner);

        //confirmButton
        confirmButton = new JButton();
        confirmButton.addActionListener(new TileListener());
        confirmButton.setText("Bestätigen");
        confirmButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPane.add(confirmButton);

        

        pack();
        setLocationRelativeTo(getOwner());
    }

    class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JButton btn  = (JButton) e.getSource();

            if(btn.equals(confirmButton)){
                int t = 0;
                if((int) spinner.getValue() ==  2){
                    t = 2;
                }else  if((int) spinner.getValue() ==  3){
                    t = 4;
                }else if((int) spinner.getValue() ==  4){
                    t = 7;
                }else  if((int) spinner.getValue() ==  5){
                    t = 10;
                }else  if((int) spinner.getValue() ==  6){
                    t = 13;
                }else  if((int) spinner.getValue() ==  7){
                    t = 17;
                }else  if((int) spinner.getValue() ==  8){
                    t = 21;
                }else  if((int) spinner.getValue() ==  9){
                    t = 25;
                }else if((int) spinner.getValue() ==  10){
                    t = 30;
                }

                Main.redeemedCardTroops(t);

            }else if(btn.equals(cancelButton)){

            }
        }

    }


}
