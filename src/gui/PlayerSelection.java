package gui;

import classes.Farben;
import classes.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class PlayerSelection extends JFrame {

    JButton remAll;
    JButton pAdd;
    int pCounter  = 0;
    JComboBox<String> pColor;
    JTextField pName;
    LinkedList<Player> players = new LinkedList<>();

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;

    JLabel[] labels = {label1, label2, label3, label4, label5, label6};

    public PlayerSelection() {
        initComponents();
    }

    private void initComponents() {
        setMaximizedBounds(new Rectangle(0, 0, 400, 640));
        setMinimumSize(new Dimension(267, 430));
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setAlwaysOnTop(true);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout) contentPane.getLayout()).columnWidths = new int[]{0, 0};
        ((GridBagLayout) contentPane.getLayout()).rowHeights = new int[]{0, 0, 0};
        ((GridBagLayout) contentPane.getLayout()).columnWeights = new double[]{1.0, 1.0E-4};
        ((GridBagLayout) contentPane.getLayout()).rowWeights = new double[]{1.0, 0.0, 1.0E-4};

        //players
        JPanel players = new JPanel();
        players.setLayout(new GridBagLayout());
        ((GridBagLayout) players.getLayout()).columnWidths = new int[]{0, 0, 0, 0, 0};
        ((GridBagLayout) players.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout) players.getLayout()).columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout) players.getLayout()).rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0E-4};

        //label1
        label1 = new JLabel();
        label1.setText("text");
        players.add(label1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //delOne
        JButton delOne = new JButton();
        delOne.setText("text");
        players.add(delOne, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        //label2
        JLabel label2 = new JLabel();
        label2.setText("text");
        players.add(label2, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //delTwo
        JButton delTwo = new JButton();

        delTwo.setText("text");
        players.add(delTwo, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        //label3
        JLabel label3 = new JLabel();
        label3.setText("text");
        players.add(label3, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //delThree
        JButton delThree = new JButton();
        delThree.setText("text");
        players.add(delThree, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        //label4
        JLabel label4 = new JLabel();
        label4.setText("text");
        players.add(label4, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //delFour
        JButton delFour = new JButton();
        delFour.setText("text");
        players.add(delFour, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        //label5
        JLabel label5 = new JLabel();
        label5.setText("text");
        players.add(label5, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 5), 0, 0));

        //delFive
        JButton delFive = new JButton();
        delFive.setText("text");
        players.add(delFive, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 5, 0), 0, 0));

        //label6
        JLabel label6 = new JLabel();
        label6.setText("text");
        players.add(label6, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 5), 0, 0));

        //delSix
        JButton delSix = new JButton();
        delSix.setText("text");
        players.add(delSix, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));

        contentPane.add(players, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 14, 0), 0, 0));

        //optPanel
        JPanel optPanel = new JPanel();
        optPanel.setLayout(new BoxLayout(optPanel, BoxLayout.Y_AXIS));

        //remAll
        remAll = new JButton();
        remAll.addActionListener(new TileListener());
        remAll.setText("Alle entfernen");
        remAll.setAlignmentX(Component.CENTER_ALIGNMENT);
        optPanel.add(remAll);

        //pName
        pName = new JTextField();
        pName.setMaximumSize(new Dimension(101, 23));
        pName.setMinimumSize(new Dimension(101, 23));
        pName.setText("Name");
        pName.setAlignmentX(Component.CENTER_ALIGNMENT);
        optPanel.add(pName);

        //pColor
        pColor = new JComboBox<>();
        pColor.setMaximumRowCount(6);
        pColor.setModel(new DefaultComboBoxModel<>(new String[]{"Blau", "Schwarz", "Grün", "Rosa", "Rot", "Gelb"}));
        pColor.setMaximumSize(new Dimension(101, 23));
        pColor.setMinimumSize(new Dimension(121, 23));
        pColor.setAlignmentX(Component.CENTER_ALIGNMENT);
        optPanel.add(pColor);

        //pAdd
        pAdd = new JButton();
        pAdd.addActionListener(new TileListener());
        pAdd.setText("Spieler Hinzufügen");
        pAdd.setAlignmentX(Component.CENTER_ALIGNMENT);
        optPanel.add(pAdd);

        contentPane.add(optPanel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());

    }

    class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(pAdd)) {
                if (pCounter < 6) {

                    for (Player p : players){
                        if (stringToColor((String) pColor.getSelectedItem()).equals(p.getFarbe())) {
                            Main.errorMessage("Diese Farbe ist vergeben", "Bitte andere Farbe wählen!!!");
                            return;
                        }else
                        if(p.getPlayername().equalsIgnoreCase(pName.getText())){
                            Main.errorMessage("Dieser Spielernamen ist schon vergeben","ERRRORORROROR");
                            return;
                        }

                    }
                    Player player = new Player(stringToColor((String) pColor.getSelectedItem()), Main.getBoard(), pName.getText());
                    players.add(player);
                    pCounter ++;
                }
            } else if (e.getSource().equals(remAll)) {
                pCounter = 0;
                players = new LinkedList<>();
                for(JLabel label : labels){
                    label.setText("No player");
                }
            }

        }
    }


    private Farben stringToColor(String s){

        if(s.equalsIgnoreCase("Gelb")){
            return Farben.GELB;
        }else if(s.equalsIgnoreCase("Rot")){
            return Farben.ROT;
        }else if(s.equalsIgnoreCase("Rosa")){
            return Farben.ROSA;
        }else if(s.equalsIgnoreCase("Grün")){
            return Farben.GRÜN;
        }else if(s.equalsIgnoreCase("Schwarz")){
            return Farben.SCHWARZ;
        }
        return Farben.BLAU;
    }

}
