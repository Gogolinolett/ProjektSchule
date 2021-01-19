package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Start extends JFrame {
    private Image img = ImageIO.read(new File("src\\resources\\other\\Risiko_Logo.png"));
    private JButton button1;
    private JButton button2;

    public Start() throws IOException {
        initComponents();
    }

    private void initComponents() throws IOException {
        JPanel vSpacer1 = new JPanel(null);
        button1 = new JButton();
        JPanel vSpacer2 = new JPanel(null);
        button2 = new JButton();
        JPanel vSpacer3 = new JPanel(null);
        JPanel vSpacer4 = new JPanel(null);

        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setMinimumSize(new Dimension(267, 430));
        setResizable(false);
        setIconImage(ImageIO.read(new File("src\\resources\\other\\star.png")));
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
        button1.addActionListener(new TileListener());
        contentPane.add(button1);
        contentPane.add(vSpacer3);

        //button2
        button2.setText("Regeln");
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.addActionListener(new TileListener());
        contentPane.add(button2);
        contentPane.add(vSpacer4);

        pack();
        setLocationRelativeTo(getOwner());
    }

    class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            if (btn == button1) {
                try {
                    Main.startPlayerSelection();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } else if (btn == button2) {
                if (Desktop.isDesktopSupported()) {
                    try {
                        File myFile = new File("src\\resources\\rules.pdf");
                        Desktop.getDesktop().open(myFile);
                    } catch (IOException ex) {
                    }
                }
            }
        }
    }
}
