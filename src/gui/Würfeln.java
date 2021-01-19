package gui;

import classes.Area;
import classes.Board;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;

public class Würfeln extends JFrame {
private JCheckBox aDice1;
    private JCheckBox dDice1;
    private JCheckBox aDice2;
    private JCheckBox dDice2;
    private JCheckBox aDice3;
    private JLabel aCountry;
    private JLabel dCountry;
    private JButton rollButton;
    private JButton retreatButton;
    private Container contentPane;
    private LinkedList<Integer> aDiceList;
    private LinkedList<Integer> dDiceList;
    private final Area aggressor;
    private final Area defender;
    private int acount;
    private Results r;

    public Würfeln(Area aggressor, Area defender, Results r) throws InterruptedException, IOException {
        r.dispose();
        this.aggressor = aggressor;
        this.defender = defender;
        initComponents();
    }

    public Würfeln(Area aggressor, Area defender) throws InterruptedException, IOException {
        this.aggressor = aggressor;
        this.defender = defender;
        initComponents();
    }

    private void initComponents() throws InterruptedException, IOException {
        setMinimumSize(new Dimension(430, 267));
        setResizable(false);
        setAlwaysOnTop(true);
        setIconImage(ImageIO.read(new File("src\\resources\\other\\star.png")));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{0, 0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{1.0, 1.0, 1.0, 1.0E-4};
        ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //aLabel
        JLabel aLabel = new JLabel();
        aLabel.setText("Angriffs Land:");
        aLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(aLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //dLabel
        JLabel dLabel = new JLabel();
        dLabel.setText("Verteidigungs Land:");
        dLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(dLabel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        setCheckBox();

        //aCountry
        aCountry = new JLabel();
        aCountry.setText(aggressor.getName() + " (" + aggressor.getTroopCount() + ")");
        aCountry.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(aCountry, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //dCountry
        dCountry = new JLabel();
        dCountry.setText(defender.getName() + " (" + defender.getTroopCount() + ")");
        dCountry.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(dCountry, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));


        //rollButton
        rollButton = new JButton();
        rollButton.setText("Würfeln");
        rollButton.addActionListener(new TileListener());
        contentPane.add(rollButton, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //retreatButton
        retreatButton = new JButton();
        retreatButton.setText("Rückzug");
        retreatButton.addActionListener(new TileListener());
        contentPane.add(retreatButton, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }

    public void setCheckBox() {
        //aDice1
        aDice1 = new JCheckBox();
        aDice1.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(aDice1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //aDice2
        aDice2 = new JCheckBox();
        aDice2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(aDice2, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //aDice3
        aDice3 = new JCheckBox();
        aDice3.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(aDice3, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //dDice1
        dDice1 = new JCheckBox();
        dDice1.setEnabled(false);
        dDice1.setSelected(true);
        contentPane.add(dDice1, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        if (defender.getTroopCount() != 1) {
            //dDice2
            dDice2 = new JCheckBox();
            dDice2.setEnabled(false);
            dDice2.setSelected(true);
            contentPane.add(dDice2, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
        }

    }

    public Würfeln getThis(){
        return this;
    }

    class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                JButton btn = (JButton) e.getSource();
                if (btn.equals(rollButton)) {
                    aDiceList = new LinkedList<>();
                    dDiceList = new LinkedList<>();
                    acount = 0;
                    if (aDice1.isSelected()) {
                        acount++;
                    }
                    if (aDice2.isSelected()) {
                        acount++;
                    }
                    if (aDice3.isSelected()) {
                        acount++;
                    }
                    int dcount = defender.getTroopCount();
                    boolean b = Board.fight(aggressor, defender, acount, aDiceList, dDiceList, getThis());

                    Results r = null;
                    try {
                        r = new Results(acount, dcount, aDiceList, dDiceList, getThis(), aggressor, defender, b);
                        aCountry.setText(aggressor.getName() + " (" + aggressor.getTroopCount() + ")");
                        dCountry.setText(defender.getName() + " (" + defender.getTroopCount() + ")");
                    } catch (InterruptedException | IOException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                    setCheckBox();
                } else if (btn.equals(retreatButton)) {

                }
            }
        }
    }
}