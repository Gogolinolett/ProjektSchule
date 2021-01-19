package gui;

import classes.Area;
import classes.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Stage_2 extends JPanel {
    private Area attackingArea;
    private Area defendingArea;
    private Player player;

    private JEditorPane sDefendCountryPane;
    private JEditorPane sAttackCountryPane;
    private JButton cButton;
    private JButton nStage;
    private JButton mKarte;

    public Stage_2(Player player) {
        this.player = player;
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
        pName.setText(player.getPlayername() + "\u00b4s Turn");
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
        sAttackCountryPane = new JEditorPane();
        sAttackCountryPane.setText("Land:  \nTruppen Anzahl");
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
        sDefendCountryPane = new JEditorPane();
        sDefendCountryPane.setText("Land:  \nTruppen Anzahl");
        sDefendCountryPane.setEditable(false);
        sPane2.setViewportView(sDefendCountryPane);

        add(sPane2, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        //cButton
        cButton = new JButton();
        cButton.setText("Bestätigen");
        cButton.addActionListener(new TileListener());
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

    class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof  JButton){
                JButton btn = (JButton) e.getSource();

                if(btn.equals(cButton)){
                    if (attackingArea != null && defendingArea != null){
                        if(attackingArea.getTroopCount() > 1 && attackingArea.isNeighbour(defendingArea)){
                            try {
                                Würfeln würfeln = new Würfeln(attackingArea, defendingArea);
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        }
                    }
                }else if(btn.equals(nStage)){
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

    public void setAttackingArea(Area attackingArea) {
        sAttackCountryPane.setText("Land:" + attackingArea.getName() +" \nTruppen Anzahl: " + attackingArea.getTroopCount());
        sAttackCountryPane.setForeground((attackingArea.getFarbeOwner()));
        this.attackingArea = attackingArea;
    }

    public void setDefendingArea(Area defendingArea) {
        sDefendCountryPane.setText("Land:" + defendingArea.getName() +" \nTruppen Anzahl: " + defendingArea.getTroopCount());
        sDefendCountryPane.setForeground(defendingArea.getFarbeOwner());
        this.defendingArea = defendingArea;
    }
}
