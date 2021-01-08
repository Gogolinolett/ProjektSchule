package gui;
import gui.panels.First;
import gui.panels.Map;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;



public class GUI {
    private static final JFrame frame = new JFrame();
    private final JPanel map = new JPanel();
    private final First f = new First();
    private final Map map1 = new Map(this);

    public GUI() throws IOException {
        initComponents();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JPanel getMap() {
        return map;
    }

    private void initComponents() {

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Risiko");
        frame.setMinimumSize(new Dimension(750, 550));
        frame.setSize(750, 550);

        //Frame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Risiko");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};
        ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};


        //imagePanel
        map.setOpaque(true);
        map.setLayout(new GridLayout(1, 1, 0, 0));
        map.add(map1);

        //FirstPanel
        f.setOpaque(true);

        contentPane.add(map, new GridBagConstraints(0, 0, 11, 7, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        contentPane.add(f, new GridBagConstraints(11, 0, 1, 7, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    }
}
