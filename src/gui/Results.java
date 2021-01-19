package gui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Results extends JFrame {

    private JLabel a1;
    private JLabel d1;
    private JLabel a2;
    private JLabel d2;
    private JLabel a3;
    private int aCount;
    private int dCount;
    private LinkedList<Integer> aDiceList;
    private LinkedList<Integer> dDiceList;

    private static Image[] g;
    private static Image[] z;

    static {
        try {
            g = new Image[]{ImageIO.read(new File("src\\resources\\würfel\\b1.png")), ImageIO.read(new File("src\\resources\\würfel\\b2.png")), ImageIO.read(new File("src\\resources\\würfel\\b3.png")), ImageIO.read(new File("src\\resources\\würfel\\b4.png")), ImageIO.read(new File("src\\resources\\würfel\\b5.png")), ImageIO.read(new File("src\\resources\\würfel\\b6.png")),};
            z = new Image[]{ImageIO.read(new File("src\\resources\\würfel\\r1.png")), ImageIO.read(new File("src\\resources\\würfel\\r2.png")), ImageIO.read(new File("src\\resources\\würfel\\r3.png")), ImageIO.read(new File("src\\resources\\würfel\\r4.png")), ImageIO.read(new File("src\\resources\\würfel\\r5.png")), ImageIO.read(new File("src\\resources\\würfel\\r6.png")),};
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Results r = new Results();
    }

    public Results(int aCount, int dCount, LinkedList<Integer> aDiceList, LinkedList<Integer> dDiceList) throws InterruptedException {
        this.aCount = aCount;
        this.dCount = dCount;
        this.aDiceList = aDiceList;
        this.dDiceList = dDiceList;
        initComponents();
    }

    public Results() throws InterruptedException {
        test();
        initComponents();
    }

    public void test(){
        aCount=3;
        dCount=2;
        aDiceList = new LinkedList<>();
        aDiceList.add(3);
        aDiceList.add(6);
        aDiceList.add(1);
        dDiceList = new LinkedList<>();
        dDiceList.add(1);
        dDiceList.add(4);
    }

    private void initComponents() throws InterruptedException {
        //this
        setMinimumSize(new Dimension(430, 267));
        setAlwaysOnTop(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0E-4};

        //titel
        JLabel titel = new JLabel();
        titel.setText("Ergebnisse");
        titel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //a1
        a1 = new JLabel("");
        a1.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(a1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //a2
        a2 = new JLabel("");
        a2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(a2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //a3
        a3 = new JLabel("");
        a3.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(a3, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));

        //d1
        d1 = new JLabel("");
        d1.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(d1, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));


        if (dCount != 1) {
            //dDice2
            d2 = new JLabel("");
            d2.setHorizontalAlignment(SwingConstants.LEFT);
            contentPane.add(d2, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        }

        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        animation();
        roll();
    }

    public void animation() throws InterruptedException {
        //setLabels();
        for (int i = 0; i<15; i++) {
            if (aCount == 1) {
                a1.setIcon(rollAttack());
            } else if (aCount == 2) {
                a1.setIcon(rollAttack());
                a2.setIcon(rollAttack());
            } else if (aCount == 3) {
                a1.setIcon(rollAttack());
                a2.setIcon(rollAttack());
                a3.setIcon(rollAttack());
            }

            if (dCount == 1) {
                d1.setIcon(rollDef());
            } else {
                d1.setIcon(rollDef());
                d2.setIcon(rollDef());
            }
            Thread.sleep(200);
        }
    }

    public void roll() throws InterruptedException {
        aDiceList.sort(Comparator.reverseOrder());
        dDiceList.sort(Comparator.reverseOrder());
        System.out.println(aDiceList);
        System.out.println(dDiceList);
        if (aCount == 1) {
            a1.setIcon(aroll(0));
        } else if (aCount == 2) {
            a1.setIcon(aroll(0));
            a2.setIcon(aroll(1));
        } else if (aCount == 3) {
            a1.setIcon(aroll(0));
            a2.setIcon(aroll(1));
            a3.setIcon(aroll(2));
        }

        d1.setIcon(droll(0));
        if (dCount != 1) {
            d2.setIcon(droll(1));
        }
    }

    public ImageIcon rollAttack(){
        int num = (int)(Math.random() * ((6 - 1) + 1));
        ImageIcon icon = new ImageIcon(g[num]);
        Image i = icon.getImage();
        Image f = i.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        return new ImageIcon(f);
    }

    public ImageIcon rollDef() {
        int num = (int) (Math.random() * ((6 - 1) + 1));
        ImageIcon icon = new ImageIcon(z[num]);
        Image i = icon.getImage();
        Image f = i.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        return new ImageIcon(f);
    }

    public ImageIcon aroll(int num) {
        ImageIcon icon = new ImageIcon(g[aDiceList.get(num) - 1]);
        Image i = icon.getImage();
        Image f = i.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        return new ImageIcon(f);
    }

    public ImageIcon droll(int num) {
        ImageIcon icon = new ImageIcon(z[dDiceList.get(num) - 1]);
        Image i = icon.getImage();
        Image f = i.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        return new ImageIcon(f);
    }
}
