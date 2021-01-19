package gui;

import classes.Area;
import classes.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Stage_1 extends JPanel {
    private int troops;
    private String playername;
    private Area land;
    private Player player;
    private JEditorPane sCountryPane;
    private JButton nStage;
    private JButton mKarte;
    private JLabel pName;

    public Stage_1(Player player) {

        troops = player.getTroopsPerTurn();
        this.playername = player.getPlayername();
        this.player = player;
        initComponents();
    }

    public void setTroops(int troops) {
        this.troops = troops;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public void setLand(Area land) {
        sCountryPane.setText("Land: " + land.getName()  + " \nTruppen Anzahl: " + land.getTroopCount());
        sCountryPane.setForeground(land.getFarbeOwner());
        this.land = land;
    }

    JLabel aTroops = new JLabel();
    JSpinner aTroopsSpinner = new JSpinner();
    JButton cButton = new JButton();

    private void initComponents() {
        setOpaque(true);

        setBackground(Color.white);
        setLayout(new GridBagLayout());
        ((GridBagLayout) getLayout()).columnWidths = new int[]{0, 0, 0};
        ((GridBagLayout) getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout) getLayout()).columnWeights = new double[]{1.0, 1.0, 1.0E-4};
        ((GridBagLayout) getLayout()).rowWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};

        //pName
        pName = new JLabel();
        pName.setText(playername + " players turn.");
        pName.setForeground(player.getFarbe());
        add(pName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //cStage
        JLabel cStage = new JLabel();
        cStage.setText("Schritt 1/3: Einheiten platzieren");
        add(cStage, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));

        //rTroops
        JLabel rTroops = new JLabel();
        rTroops.setText("Anzahl der zu plazierenden Truppen " );
        add(rTroops, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //sCountryLabel
        JLabel sCountryLabel = new JLabel();
        sCountryLabel.setText("Ausgewähltes Land: ");
        add(sCountryLabel, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //sPane
        JScrollPane sPane = new JScrollPane();

        //sCountryPane
        sCountryPane = new JEditorPane();
        sCountryPane.setText("Land: \nBesitzer: \nTruppen Anzahl");
        sCountryPane.setEditable(false);
        sPane.setViewportView(sCountryPane);

        add(sPane, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //aTroops
        aTroops.setText("Anzahl der Truppen: " + troops);
        add(aTroops, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //aTroopsSpinner
        aTroopsSpinner.setModel(new SpinnerNumberModel(0, 0, troops, 1));
        add(aTroopsSpinner, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //cButton

        cButton.addActionListener(new TileListener());
        cButton.setText("Bestätigen");
        add(cButton, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //mKarte
        mKarte = new JButton();
        mKarte.addActionListener(new TileListener());
        mKarte.setText("Missionskarte\nansehen\n");
        add(mKarte, new GridBagConstraints(0, 7, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //aKarte
        JButton aKarte = new JButton();
        aKarte.setText("Angriffskarten\neintauschen");
        add(aKarte, new GridBagConstraints(1, 7, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //nStage
        nStage = new JButton();
        nStage.addActionListener(new TileListener());
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

    public void addTroops(int troops){
        this.troops = troops;
        aTroopsSpinner.setModel(new SpinnerNumberModel(0, 0, troops, 1));
    }



    class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource() instanceof  JButton){
                JButton btn = (JButton) e.getSource();
                if(btn.equals(cButton)){
                    if(land != null && land.getFarbeOwner().equals(player.getFarbe())) {
                        int z = (int) aTroopsSpinner.getValue();
                        troops = troops - z;
                        land.addTroops(z);
                        aTroopsSpinner.setModel(new SpinnerNumberModel(0, 0, troops, 1));
                        aTroops.setText("Anzahl der Truppen: " + troops);
                    }
                }else if(btn.equals(nStage)&& troops == 0){
                    System.out.println("next stage");
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
