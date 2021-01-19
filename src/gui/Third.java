package gui;

import classes.Area;
import classes.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Third extends JPanel {
    private JButton mKarte;
    private  Player player;
    private JButton cButton;
    private Area origin;
    private Area destination;
    private JLabel aTroops;
    private JSpinner aTroopsSpinner;
    private JLabel sOriginCountry;
    private JLabel sDestinationCountry;
    private JButton nStage;

    public void setArea(Area area){
        if(destination == null){
            origin = area;
        }else {
            origin = destination;
        }
        destination = area;
        sOriginCountry.setText("Ausgewähltes  Ziel Land: " + origin.getName());
        sDestinationCountry.setText("Ausgewähltes Ursprungsland: " + destination.getName());
        if(origin.getTroopCount() == 1){
            aTroopsSpinner.setModel(new SpinnerNumberModel(1, 1,  1, 1));
        }else {
            aTroopsSpinner.setModel(new SpinnerNumberModel(1, 1, origin.getTroopCount() - 1, 1));
        }
    }

    public Third(Player player) {

        this.player = player;
        initComponents();
    }

    private void initComponents() {
        setOpaque(true);

        setBackground(Color.white);
        setLayout(new GridBagLayout());
        ((GridBagLayout) getLayout()).columnWidths = new int[]{0, 0, 0};
        ((GridBagLayout) getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout) getLayout()).columnWeights = new double[]{1.0, 1.0, 1.0E-4};
        ((GridBagLayout) getLayout()).rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};

        //pName
        JLabel pName = new JLabel();
        pName.setText(player.getPlayername() + "s Zug");
        pName.setForeground(player.getFarbe());
        add(pName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //cStage
        JLabel cStage = new JLabel();
        cStage.setText("Schritt 3/3: Truppen Bewegen");
        add(cStage, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        //sOriginCountry
        sOriginCountry = new JLabel();
        sOriginCountry.setText("Ausgewähltes  Ursprungs Land:");
        add(sOriginCountry, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //sPane
        JScrollPane sPane = new JScrollPane();

        //sOriginCountryPane
        JEditorPane sOriginCountryPane = new JEditorPane();
        sOriginCountryPane.setText("Land: \nBesitzer: \nTruppen Anzahl");
        sOriginCountryPane.setEditable(false);
        sPane.setViewportView(sOriginCountryPane);

        add(sPane, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //sDestinationCountry
        sDestinationCountry = new JLabel();
        sDestinationCountry.setText("Ausgewähltes  Ziel Land:");
        add(sDestinationCountry, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //sPane2
        JScrollPane sPane2 = new JScrollPane();

        //sDestinationCountryPane
        JEditorPane sDestinationCountryPane = new JEditorPane();
        sDestinationCountryPane.setText("Land: \nBesitzer: \nTruppen Anzahl");
        sDestinationCountryPane.setEditable(false);
        sPane2.setViewportView(sDestinationCountryPane);

        add(sPane2, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //aTroops
        aTroops = new JLabel();
        aTroopsSpinner = new JSpinner();
        aTroops.setText("Anzahl der Truppen:");
        add(aTroops, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        add(aTroopsSpinner, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //cButton
        cButton = new JButton();
        cButton.addActionListener(new TileListener());
        cButton.setText("Bestätigen");
        add(cButton, new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //mKarte
        mKarte = new JButton();
        mKarte.addActionListener(new TileListener());
        mKarte.setText("Missionskarte\nansehen\n");
        add(mKarte, new GridBagConstraints(0, 8, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //aKarte
        JButton aKarte = new JButton();
        aKarte.setText("Angriffskarten\neintauschen");
        add(aKarte, new GridBagConstraints(1, 8, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //nStage
        nStage = new JButton();
        nStage.addActionListener(new TileListener());
        nStage.setText("Zug Beenden");
        add(nStage, new GridBagConstraints(0, 10, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //sPane3
        JScrollPane sPane3 = new JScrollPane();
        sPane3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        sPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //sLogPane
        JTextPane sLogPane = new JTextPane();
        sLogPane.setEditable(false);
        sPane3.setViewportView(sLogPane);

        add(sPane3, new GridBagConstraints(0, 11, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    }

    class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof  JButton){
                JButton btn = (JButton) e.getSource();

                if(btn.equals(cButton) && origin != null){
                    if(origin.getTroopCount() > (int) aTroopsSpinner.getValue() && origin.isNeighbour(destination)){
                        Main.getBoard().moveTroop(origin, destination,(int) aTroopsSpinner.getValue());
                    }
                }else if(nStage.equals(btn)){
                    Main.nextStage();
                } else if(btn.equals(mKarte)){
                    try {
                        MissionsKarte m = new MissionsKarte(player.getWinningConditions().getImg());
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

            }
        }
    }

}
