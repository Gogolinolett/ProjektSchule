package gui;

import javax.swing.*;
import java.awt.*;

public class Würfeln extends JFrame {
    private JLabel aCountry;
    private JLabel dCountry;
    private JCheckBox aDice1;
    private JCheckBox dDice1;
    private JCheckBox aDice2;
    private JCheckBox dDice2;
    private JCheckBox aDice3;
    private JButton rollButton;
    private JButton retreatButton;

    public Würfeln() {
        initComponents();
    }

    private void initComponents() {
        setMinimumSize(new Dimension(430, 267));
        setResizable(false);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        Container contentPane = getContentPane();
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

        //aCountry
        aCountry = new JLabel();
        aCountry.setText("Land (Truppen)");
        aCountry.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(aCountry, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //dCountry
        dCountry = new JLabel();
        dCountry.setText("Land (Truppen)");
        dCountry.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(dCountry, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

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
        contentPane.add(dDice1, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        //dDice2
        dDice2 = new JCheckBox();
        contentPane.add(dDice2, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        //rollButton
        rollButton = new JButton();
        rollButton.setText("Würfeln");
        contentPane.add(rollButton, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //retreatButton
        retreatButton = new JButton();
        retreatButton.setText("Rückzug");
        contentPane.add(retreatButton, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));

        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }
}
