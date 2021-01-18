package gui;

import java.awt.*;
import javax.swing.*;

public class MoveTroops extends JFrame {
    public MoveTroops() {
        initComponents();
    }

    private void initComponents() {
        setMinimumSize(new Dimension(430, 267));
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{0, 0, 0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{0, 0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0E-4};
        ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{1.0, 1.0, 1.0, 1.0E-4};

        //sPane
        JScrollPane sPane = new JScrollPane();
        sPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        //sOriginCountryPane
        JEditorPane sOriginCountryPane = new JEditorPane();
        sOriginCountryPane.setText("Territory: \nOwner: \nTroops");
        sOriginCountryPane.setEditable(false);
        sPane.setViewportView(sOriginCountryPane);

        contentPane.add(sPane, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 10, 10), 0, 0));

        //sPane2
        JScrollPane sPane2 = new JScrollPane();
        sPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        //sDestinationCountryPane
        JEditorPane sDestinationCountryPane = new JEditorPane();
        sDestinationCountryPane.setText("Territory: \nOwner: \nTroops");
        sDestinationCountryPane.setEditable(false);
        sPane2.setViewportView(sDestinationCountryPane);

        contentPane.add(sPane2, new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 10, 0), 0, 0));

        //panel1
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        //comboBox1
        JComboBox comboBox = new JComboBox();
        comboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        comboBox.setMaximumSize(new Dimension(121, 23));
        panel1.add(comboBox);

        //cButton
        JButton cButton = new JButton();
        cButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cButton.setText("confirm");
        panel1.add(cButton);

        contentPane.add(panel1, new GridBagConstraints(0, 2, 4, 1, 0.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }
}
