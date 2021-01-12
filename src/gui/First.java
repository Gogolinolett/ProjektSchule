package gui;

import javax.swing.*;
import java.awt.*;

public class First extends JPanel {
    private int troops;

    public First(int troopsPlaceble, String Playername) {
        initComponents();
        troops = troopsPlaceble;

    }

    private void initComponents() {
        setOpaque(true);

        setBackground(Color.white);
        setLayout(new GridBagLayout());
        ((GridBagLayout) getLayout()).columnWidths = new int[]{0, 0, 0};
        ((GridBagLayout) getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout) getLayout()).columnWeights = new double[]{1.0, 1.0, 1.0E-4};
        ((GridBagLayout) getLayout()).rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};


        //pName
        JLabel pName = new JLabel();
        pName.setText("[Spieler Name]\u00b4s Zug");
        add(pName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //cStage
        JLabel cStage = new JLabel();
        cStage.setText("Schritt 1/3: Einheiten platzieren");
        add(cStage, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        //rTroops
        JLabel rTroops = new JLabel();
        rTroops.setText("Anzahl der zu plazierenden Truppen []");
        add(rTroops, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //sCountryLabel
        JLabel sCountryLabel = new JLabel();
        sCountryLabel.setText("Ausgewähltes Land:");
        add(sCountryLabel, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //sPane
        JScrollPane sPane = new JScrollPane();

        //sCountryPane
        JEditorPane sCountryPane = new JEditorPane();
        sCountryPane.setText("Land: \nBesitzer: \nTruppen Anzahl");
        sCountryPane.setEditable(false);
        sPane.setViewportView(sCountryPane);

        add(sPane, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //aTroops
        JLabel aTroops = new JLabel();
        aTroops.setText("Anzahl der Truppen:");
        add(aTroops, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //aTroopsSpinner
        JSpinner aTroopsSpinner = new JSpinner();
        aTroopsSpinner.setModel(new SpinnerNumberModel(0, 0, tro, 1));
        add(aTroopsSpinner, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //cButton
        JButton cButton = new JButton();
        cButton.setText("Bestätigen");
        add(cButton, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //mKarte
        JButton mKarte = new JButton();
        mKarte.setText("Missionskarte\nansehen\n");
        add(mKarte, new GridBagConstraints(0, 7, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //aKarte
        JButton aKarte = new JButton();
        aKarte.setText("Angriffskarten\neintauschen");
        add(aKarte, new GridBagConstraints(1, 7, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //nStage
        JButton nStage = new JButton();
        nStage.setText("Nächster Schritt");
        add(nStage, new GridBagConstraints(0, 9, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //sPane2
        JScrollPane sPane2 = new JScrollPane();
        sPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //sLogPane
        JTextPane sLogPane = new JTextPane();
        sLogPane.setEditable(false);
        sPane2.setViewportView(sLogPane);

        add(sPane2, new GridBagConstraints(0, 10, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    }
}
