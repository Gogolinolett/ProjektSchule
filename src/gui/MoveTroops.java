package gui;

import classes.Area;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MoveTroops extends JFrame {

    Area a1;
    Area a2;
    int troops;

    public MoveTroops(Area a1, Area a2, int attacking) {
        this.a1 = a1;
        this.a2 = a2;
        troops = attacking;
        initComponents();
    }
    
    JButton cButton;
    JSpinner spinner;

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
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        //spinner
        spinner = new JSpinner();
        spinner.setAlignmentX(Component.CENTER_ALIGNMENT);
        spinner.setMaximumSize(new Dimension(121, 23));
        panel.add(spinner);

        //cButton
        cButton = new JButton();
        cButton.addActionListener(new TileListener());
        cButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        cButton.setText("Bestätigen");
        panel.add(cButton);

        contentPane.add(panel, new GridBagConstraints(0, 2, 4, 1, 0.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }

    class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            if(btn.equals(cButton)){
                a2.setFarbeOwner(a1.getFarbeOwner());
                if(troops < (int)spinner.getValue() && (int)spinner.getValue() < a1.getTroopCount()){
                    Main.getBoard().moveTroop(a1, a2, (int) spinner.getValue());
                    setVisible(false);
                }
            }
        }
    }
}
