package gui;

import classes.Area;

import javax.swing.*;
import java.awt.*;

public class Second extends JPanel {

    private Area attackingArea;
    private Area defendingArea;

    public Second() {
        initComponents();
    }

    private void initComponents() {
        setOpaque(true);

        setBackground(Color.white);
        setLayout(new GridBagLayout());
        ((GridBagLayout) getLayout()).columnWidths = new int[]{0, 0, 0};
        ((GridBagLayout) getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout) getLayout()).columnWeights = new double[]{1.0, 1.0, 1.0E-4};
        ((GridBagLayout) getLayout()).rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};

        //pName
        JLabel pName = new JLabel();
        pName.setText("[Spieler Name]\u00b4s Zug");
        add(pName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //cStage
        JLabel cStage = new JLabel();
        cStage.setText("Schritt 2/3: Erobern");
        add(cStage, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        //sAttackCountry
        JLabel sAttackCountry = new JLabel();
        sAttackCountry.setText("Ausgewähltes  Angreifer Land:");
        add(sAttackCountry, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //sPane
        JScrollPane sPane = new JScrollPane();

        //sAttackCountryPane
        JEditorPane sAttackCountryPane = new JEditorPane();
        sAttackCountryPane.setText("Land: \nBesitzer: \nTruppen Anzahl");
        sAttackCountryPane.setEditable(false);
        sPane.setViewportView(sAttackCountryPane);

        add(sPane, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //sDefendCountry
        JLabel sDefendCountry = new JLabel();
        sDefendCountry.setText("Ausgewähltes  Verteidiger Land:");
        add(sDefendCountry, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //sPane2
        JScrollPane sPane2 = new JScrollPane();

        //sDefendCountryPane
        JEditorPane sDefendCountryPane = new JEditorPane();
        sDefendCountryPane.setText("Land: \nBesitzer: \nTruppen Anzahl");
        sDefendCountryPane.setEditable(false);
        sPane2.setViewportView(sDefendCountryPane);

        add(sPane2, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

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

        //sPane3
        JScrollPane sPane3 = new JScrollPane();
        sPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //sLogPane
        JTextPane sLogPane = new JTextPane();
        sLogPane.setEditable(false);
        sPane3.setViewportView(sLogPane);

        add(sPane3, new GridBagConstraints(0, 10, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    }

    public void setAttackingArea(Area attackingArea) {
        this.attackingArea = attackingArea;
    }

    public void setDefendingArea(Area defendingArea) {
        this.defendingArea = defendingArea;
    }
}
