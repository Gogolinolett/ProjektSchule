package gui;

import classes.Area;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Map implements ComponentListener, WindowStateListener {
    private static final int width = 16;
    private static final int height = 39;
    private static final JFrame frame = new JFrame("");
    private static final JLayeredPane layeredPane = new JLayeredPane();
    private static final JPanel pane = new JPanel();
    private static final int num = 40;
    private static final JButton[][] t = new JButton[num][num];
    private static final LinkedList<JButton> btns = new LinkedList<>();
    private final Image img = ImageIO.read(new File("src\\resources\\other\\map.png"));
    private final ImagePanel lime = new ImagePanel(img);

    public Map() throws IOException {
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setIconImage(ImageIO.read(new File("src\\resources\\other\\star.png")));
        layeredPane.setBounds(0, 0, 1000, 1000);

        //ImagePanel
        lime.setOpaque(true);
        lime.setBounds(0, 0, frame.getWidth() - width, frame.getHeight() - height);
        layeredPane.add(lime, Integer.valueOf(0));

        pane.setLayout(new GridLayout(num, num, 0, 0));

        for (int r = 0; r < num; r++) {
            for (int c = 0; c < num; c++) {
                t[r][c] = new JButton(r + " " + c);
                t[r][c].addActionListener(new TileListener());
                pane.add(t[r][c]);
                t[r][c].setVisible(false);
                t[r][c].putClientProperty("column", r);
                t[r][c].putClientProperty("row", c);
                t[r][c].setVerticalTextPosition(SwingConstants.TOP);
            }
        }

        //Buttons
        pane.setOpaque(false);
        pane.setBounds(0, 0, frame.getWidth() - width, frame.getHeight() - height);
        layeredPane.add(pane, Integer.valueOf(1));

        frame.addComponentListener(this);
        frame.addWindowStateListener(this);

        countries();
        frame.add(layeredPane);
    }

    public static void countries() {
        //for (int r = 0; r < num; r++) {
        //    for (int c = 0; c < num; c++) {
        //        if ((r + c) % 2 != 0) {
        //            t[r][c].setVisible(false);
        //        }
        //    }
        //}
        //NordAmerika
        t[6][2].setVisible(true);
        t[6][2].putClientProperty("country", "ALASKA");
        btns.add(t[6][2]);

        t[10][6].setVisible(true);
        t[10][6].putClientProperty("country", "ALBERTA");
        btns.add(t[10][6]);

        t[6][6].setVisible(true);
        t[6][6].putClientProperty("country", "NORDWESTTERRITORIUM");
        btns.add(t[6][6]);

        t[4][14].setVisible(true);
        t[4][14].putClientProperty("country", "GRÖNLAND");
        btns.add(t[4][14]);

        t[11][9].setVisible(true);
        t[11][9].putClientProperty("country", "ONTARIO");
        btns.add(t[11][9]);

        t[11][11].setVisible(true);
        t[11][11].putClientProperty("country", "OSTKANADA");
        btns.add(t[11][11]);

        t[14][6].setVisible(true);
        t[14][6].putClientProperty("country", "WESTSTAATEN");
        btns.add(t[14][6]);

        t[15][9].setVisible(true);
        t[15][9].putClientProperty("country", "OSTSTAATEN");
        btns.add(t[15][9]);

        t[19][7].setVisible(true);
        t[19][7].putClientProperty("country", "MITTELAMERIKA");
        btns.add(t[19][7]);

        //SüdAmerika
        t[24][9].setVisible(true);
        t[24][9].putClientProperty("country", "VENEZUELA");
        btns.add(t[24][9]);

        t[27][12].setVisible(true);
        t[27][12].putClientProperty("country", "BRASILIEN");
        btns.add(t[27][12]);

        t[29][11].setVisible(true);
        t[29][11].putClientProperty("country", "PERU");
        btns.add(t[29][11]);

        t[33][11].setVisible(true);
        t[33][11].putClientProperty("country", "ARGENTINIEN");
        btns.add(t[33][11]);

        //Europa
        t[8][17].setVisible(true);
        t[8][17].putClientProperty("country", "ISLAND");
        btns.add(t[8][17]);

        t[14][16].setVisible(true);
        t[14][16].putClientProperty("country", "GROSSBRITANNIEN");
        btns.add(t[14][16]);

        t[17][17].setVisible(true);
        t[17][17].putClientProperty("country", "WESTEUROPA");
        btns.add(t[17][17]);

        t[7][21].setVisible(true);
        t[7][21].putClientProperty("country", "SKANDINAVIEN");
        btns.add(t[7][21]);

        t[14][20].setVisible(true);
        t[14][20].putClientProperty("country", "NORDEUROPA");
        btns.add(t[14][20]);

        t[18][20].setVisible(true);
        t[18][20].putClientProperty("country", "SÜDEUROPA");
        btns.add(t[18][20]);

        t[10][24].setVisible(true);
        t[10][24].putClientProperty("country", "RUSSLAND");
        btns.add(t[10][24]);

        //Afrika
        t[24][22].setVisible(true);
        t[24][22].putClientProperty("country", "ÄGYPTEN");
        btns.add(t[24][22]);

        t[26][18].setVisible(true);
        t[26][18].putClientProperty("country", "NORDAFRIKA");
        btns.add(t[26][18]);

        t[28][23].setVisible(true);
        t[28][23].putClientProperty("country", "OSTAFRIKA");
        btns.add(t[28][23]);

        t[31][21].setVisible(true);
        t[31][21].putClientProperty("country", "ZENTRALAFRIKA");
        btns.add(t[31][21]);

        t[36][22].setVisible(true);
        t[36][22].putClientProperty("country", "SÜDAFRIKA");
        btns.add(t[36][22]);

        t[36][26].setVisible(true);
        t[36][26].putClientProperty("country", "MADAGASKAR");
        btns.add(t[36][26]);

        //Asien
        t[21][25].setVisible(true);
        t[21][25].putClientProperty("country", "MITTLEREROSTEN");
        btns.add(t[21][25]);

        t[16][27].setVisible(true);
        t[16][27].putClientProperty("country", "AFGHANISTAN");
        btns.add(t[16][27]);

        t[10][28].setVisible(true);
        t[10][28].putClientProperty("country", "URAL");
        btns.add(t[10][28]);

        t[7][30].setVisible(true);
        t[7][30].putClientProperty("country", "SIBIRIEN");
        btns.add(t[7][30]);

        t[5][33].setVisible(true);
        t[5][33].putClientProperty("country", "JAKUTIEN");
        btns.add(t[5][33]);

        t[11][32].setVisible(true);
        t[11][32].putClientProperty("country", "IRKUTSK");
        btns.add(t[11][32]);

        t[15][33].setVisible(true);
        t[15][33].putClientProperty("country", "MONGOLEI");
        btns.add(t[15][33]);

        t[19][32].setVisible(true);
        t[19][32].putClientProperty("country", "CHINA");
        btns.add(t[19][32]);

        t[22][29].setVisible(true);
        t[22][29].putClientProperty("country", "INDIEN");
        btns.add(t[22][29]);

        t[24][32].setVisible(true);
        t[24][32].putClientProperty("country", "SÜDOSTASIEN");
        btns.add(t[24][32]);

        t[5][36].setVisible(true);
        t[5][36].putClientProperty("country", "KAMTSCHATKA");
        btns.add(t[5][36]);

        t[15][37].setVisible(true);
        t[15][37].putClientProperty("country", "JAPAN");
        btns.add(t[15][37]);

        //Australien
        t[31][33].setVisible(true);
        t[31][33].putClientProperty("country", "INDONESIEN");
        btns.add(t[31][33]);

        t[29][37].setVisible(true);
        t[29][37].putClientProperty("country", "NEUGUINEA");
        btns.add(t[29][37]);

        t[37][35].setVisible(true);
        t[37][35].putClientProperty("country", "WESTAUSTRALIEN");
        btns.add(t[37][35]);

        t[35][38].setVisible(true);
        t[35][38].putClientProperty("country", "OSTAUSTRALIEN");
        btns.add(t[35][38]);
    }

    public void updateMap (LinkedList<Area> areas){
        for (int i = 0; i < areas.size(); i++) {
            for (int f = 0; f < btns.size(); f++) {
                if(areas.get(i).equals(Main.stringToArea((String) btns.get(f).getClientProperty("country")))){
                    btns.get(f).setText(String.valueOf(areas.get(i).getTroopCount()));

                    if(areas.get(i).getFarbeOwner() == Color.BLUE){
                        btns.get(f).setBackground(Color.BLUE);
                    } else if (areas.get(i).getFarbeOwner() == Color.BLACK){
                        btns.get(f).setBackground(Color.BLACK);
                    }else if (areas.get(i).getFarbeOwner() == Color.GREEN){
                        btns.get(f).setBackground(Color.GREEN);
                    }else if (areas.get(i).getFarbeOwner() == Color.PINK){
                        btns.get(f).setBackground(Color.PINK);
                    }else if (areas.get(i).getFarbeOwner() == Color.RED){
                        btns.get(f).setBackground(Color.RED);
                    }else if (areas.get(i).getFarbeOwner() == Color.YELLOW){
                        btns.get(f).setBackground(Color.YELLOW);
                    }
                }
            }
        }
    }

    public void toggleButtons(boolean x) {
        for (int i = 0; i < btns.size(); i++) {
            btns.get(i).setEnabled(x);
        }
    }

    private static boolean isMaximized(int state) {
        return (state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH;
    }

    public void windowStateChanged(WindowEvent event) {
        boolean isMaximized = isMaximized(event.getNewState());
        boolean wasMaximized = isMaximized(event.getOldState());
        if (isMaximized && !wasMaximized) {
            System.out.println("User maximized window.");
        } else if (wasMaximized && !isMaximized) {
            System.out.println("User unmaximized window.");
        }
        layeredPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        pane.setBounds(0, 0, frame.getWidth() - width, frame.getHeight() - height);
        lime.setBounds(0, 0, frame.getWidth() - width, frame.getHeight() - height);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        layeredPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        pane.setBounds(0, 0, frame.getWidth() - width, frame.getHeight() - height);
        lime.setBounds(0, 0, frame.getWidth() - width, frame.getHeight() - height);
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    class ImagePanel extends JPanel {
        private final Image img;
        private Image scaled;

        public ImagePanel(Image img) {
            this.img = img;
        }

        @Override
        public void invalidate() {
            super.invalidate();
            int width = getWidth();
            int height = getHeight();

            if (width > 0 && height > 0) {
                scaled = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return img == null ? new Dimension(200, 200) : new Dimension(
                    img.getWidth(this), img.getHeight(this));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(scaled, 0, 0, lime.getWidth(), lime.getHeight(), null);
        }
    }

    class TileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            Main.act(Main.stringToArea((String) btn.getClientProperty("country")));
            System.out.println("clicked column " + btn.getClientProperty("column") + ", row " + btn.getClientProperty("row"));
            String country = (String) btn.getClientProperty("country");
            System.out.println(country);
        }
    }

    public void setVisible(boolean b){
        frame.setVisible(b);
    }
}
