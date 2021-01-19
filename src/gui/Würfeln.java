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

    private static Image[] g;
    private static Image[] z;

    static {
        try {
            g = new Image[]{ImageIO.read(new File("C:\\Users\\janoh\\OneDrive\\Dokumente\\GitHub\\ProjektSchule\\src\\resources\\würfel\\b1.png")), ImageIO.read(new File("C:\\Users\\janoh\\OneDrive\\Dokumente\\GitHub\\ProjektSchule\\src\\resources\\würfel\\b2.png")), ImageIO.read(new File("C:\\Users\\janoh\\OneDrive\\Dokumente\\GitHub\\ProjektSchule\\src\\resources\\würfel\\b3.png")), ImageIO.read(new File("C:\\Users\\janoh\\OneDrive\\Dokumente\\GitHub\\ProjektSchule\\src\\resources\\würfel\\b4.png")), ImageIO.read(new File("C:\\Users\\janoh\\OneDrive\\Dokumente\\GitHub\\ProjektSchule\\src\\resources\\würfel\\b5.png")), ImageIO.read(new File("C:\\Users\\janoh\\OneDrive\\Dokumente\\GitHub\\ProjektSchule\\src\\resources\\würfel\\b6.png")),};
            z = new Image[]{ImageIO.read(new File("C:\\Users\\janoh\\OneDrive\\Dokumente\\GitHub\\ProjektSchule\\src\\resources\\würfel\\r1.png")), ImageIO.read(new File("C:\\Users\\janoh\\OneDrive\\Dokumente\\GitHub\\ProjektSchule\\src\\resources\\würfel\\r2.png")), ImageIO.read(new File("C:\\Users\\janoh\\OneDrive\\Dokumente\\GitHub\\ProjektSchule\\src\\resources\\würfel\\r3.png")), ImageIO.read(new File("C:\\Users\\janoh\\OneDrive\\Dokumente\\GitHub\\ProjektSchule\\src\\resources\\würfel\\r4.png")), ImageIO.read(new File("C:\\Users\\janoh\\OneDrive\\Dokumente\\GitHub\\ProjektSchule\\src\\resources\\würfel\\r5.png")), ImageIO.read(new File("C:\\Users\\janoh\\OneDrive\\Dokumente\\GitHub\\ProjektSchule\\src\\resources\\würfel\\r6.png")),};
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private JCheckBox aDice1;
    private JCheckBox dDice1;
    private JCheckBox aDice2;
    private JCheckBox dDice2;
    private JCheckBox aDice3;
    private JLabel aDice1L;
    private JLabel dDice1L;
    private JLabel aDice2L;
    private JLabel dDice2L;
    private JLabel aDice3L;
    private JLabel aCountry;
    private JLabel dCountry;
    private JButton rollButton;
    private JButton retreatButton;
    private Container contentPane;
    private LinkedList<Integer> aDiceList;
    private LinkedList<Integer> dDiceList;
    private final Area aggressor;
    private final Area defender;
    private int count;

    public Würfeln(Area aggressor, Area defender) throws InterruptedException {
        this.aggressor = aggressor;
        this.defender = defender;
        initComponents();
    }

    private void initComponents() throws InterruptedException {
        setMinimumSize(new Dimension(430, 267));
        setResizable(false);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

    public void delLabels(int count) {
        contentPane = getContentPane();
        contentPane.remove(aDice1L);
        contentPane.remove(aDice2L);
        contentPane.remove(aDice3L);
        contentPane.remove(dDice1L);
        if (count != 1) {
            contentPane.remove(dDice2L);
        }
    }

    public void delBoxes() {
        contentPane = getContentPane();
        contentPane.remove(aDice1);
        contentPane.remove(aDice2);
        contentPane.remove(aDice3);
        contentPane.remove(dDice1);
        if (defender.getTroopCount() != 1) {
            contentPane.remove(dDice2);
        }
    }

    public void setLabels() {
        //aDice1
        aDice1L = new JLabel("");
        aDice1L.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(aDice1L, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //aDice2
        aDice2L = new JLabel("");
        aDice2L.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(aDice2L, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //aDice3
        aDice3L = new JLabel("");
        aDice3L.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(aDice3L, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //dDice1
        dDice1L = new JLabel("");
        contentPane.add(dDice1L, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        if (defender.getTroopCount() != 1) {
            //dDice2
            dDice2L = new JLabel("");
            contentPane.add(dDice2L, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
        }
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

    public void animation(int count) throws InterruptedException {
        aDice1.setVisible(false);
        aDice2.setVisible(false);
        aDice3.setVisible(false);
        //delBoxes();
        aDice1L = new JLabel("a");
        aDice1L.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(aDice1L, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //aDice2
        aDice2L = new JLabel("a");
        aDice2L.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(aDice2L, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //aDice3
        aDice3L = new JLabel("a");
        aDice3L.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(aDice3L, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //dDice1
        dDice1L = new JLabel("d");
        contentPane.add(dDice1L, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        if (defender.getTroopCount() != 1) {
            //dDice2
            dDice2L = new JLabel("d");
            contentPane.add(dDice2L, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));
        }
        //setLabels();
        for (int i = 0; i<15; i++) {
            if (count == 1) {
                aDice1L.setIcon(rollAttack());
            } else if (count == 2) {
                aDice1L.setIcon(rollAttack());
                aDice2L.setIcon(rollAttack());
            } else if (count == 3) {
                aDice1L.setIcon(rollAttack());
                aDice2L.setIcon(rollAttack());
                aDice3L.setIcon(rollAttack());
            }

            if (defender.getTroopCount() == 1) {
                dDice1L.setIcon(rollDef());
            } else {
                dDice1L.setIcon(rollDef());
                dDice2L.setIcon(rollDef());
            }
            Thread.sleep(200);
        }
    }

    public void roll(int count) throws InterruptedException {
        int defDice = defender.getTroopCount();
        Board.fight(aggressor, defender, count, aDiceList, dDiceList);

        aDiceList.sort(Comparator.reverseOrder());
        dDiceList.sort(Comparator.reverseOrder());
        System.out.println(aDiceList);
        System.out.println(dDiceList);
        if (count == 1) {
            aDice1L.setIcon(aroll(0));
        } else if (count == 2) {
            aDice1L.setIcon(aroll(0));
            aDice2L.setIcon(aroll(1));
        } else if (count == 3) {
            aDice1L.setIcon(aroll(0));
            aDice2L.setIcon(aroll(1));
            aDice3L.setIcon(aroll(2));
        }

        System.out.println(defDice);
        dDice1L.setIcon(droll(0));
        if (defDice != 1) {
            dDice2L.setIcon(droll(1));
        }
    }

    public ImageIcon rollAttack(){
        int num = (int)(Math.random() * ((6 - 1) + 1));
        ImageIcon icon = new ImageIcon(g[num]);
        Image i = icon.getImage();
        Image f = i.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(f);
    }

    public ImageIcon rollDef() {
        int num = (int) (Math.random() * ((6 - 1) + 1));
        ImageIcon icon = new ImageIcon(z[num]);
        Image i = icon.getImage();
        Image f = i.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(f);
    }

    public ImageIcon aroll(int num) {
        ImageIcon icon = new ImageIcon(g[aDiceList.get(num) - 1]);
        Image i = icon.getImage();
        Image f = i.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(f);
    }

    public ImageIcon droll(int num) {
        ImageIcon icon = new ImageIcon(z[aDiceList.get(num) - 1]);
        Image i = icon.getImage();
        Image f = i.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(f);
    }

    class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                JButton btn = (JButton) e.getSource();
                if (btn.equals(rollButton)) {
                    aDiceList = new LinkedList<>();
                    dDiceList = new LinkedList<>();
                    count = 0;
                    if (aDice1.isSelected()) {
                        count++;
                    }
                    if (aDice2.isSelected()) {
                        count++;
                    }
                    if (aDice3.isSelected()) {
                        count++;
                    }


                    try {
                        delBoxes();
                        setLabels();
                        roll(count);
                        aCountry.setText(aggressor.getName() + " (" + aggressor.getTroopCount() + ")");
                        dCountry.setText(defender.getName() + " (" + defender.getTroopCount() + ")");
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }

                } else if (btn.equals(retreatButton)) {

                }
                //delLabels(count);
                //setCheckBox();
            }
        }
    }
}