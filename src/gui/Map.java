package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Map implements ComponentListener, WindowStateListener {

    private static final int width = 16;
    private static final int height = 39;

    private static final JFrame frame = new JFrame("");
    private static final JLayeredPane layeredPane = new JLayeredPane();
    private static final JPanel pane = new JPanel();
    private static final int num = 50;
    private static final JButton[][] t = new JButton[num][num];

    private final Image img = ImageIO.read(new File("E:\\!Risiko\\untitled1\\map.png"));
    private final ImagePanel lime = new ImagePanel(img);

    public Map() throws IOException {

        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);


        layeredPane.setBounds(0, 0, 1000, 1000);

        //ImagePanel
        lime.setOpaque(true);
        lime.setBounds(0, 0, frame.getWidth() - width, frame.getHeight() - height);
        layeredPane.add(lime, Integer.valueOf(0));


        //pane.setBackground(Color.DARK_GRAY);

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

        frame.add(layeredPane);
        countries();
    }

    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            System.err.println("Look and feel not set.");
        }
        new Map();
    }

    public static void countries() {
        /*
        for (int r = 0; r < num; r++) {
            for (int c = 0; c < num; c++) {
                if ((r + c) % 2 != 0) {
                    t[r][c].setVisible(false);
                }

            }
        }
        */

        //NordAmerika

        t[8][3].setVisible(true);
        t[8][3].putClientProperty("country", "ALASKA");

        t[12][7].setVisible(true);
        t[12][7].putClientProperty("country", "ALBERTA");

        t[8][8].setVisible(true);
        t[8][8].putClientProperty("country", "NORDWESTTERRITORIUM");

        t[4][17].setVisible(true);
        t[4][17].putClientProperty("country", "GRÖNLAND");

        t[14][11].setVisible(true);
        t[14][11].putClientProperty("country", "ONTARIO");

        t[14][14].setVisible(true);
        t[14][14].putClientProperty("country", "OSTKANADA");

        t[18][7].setVisible(true);
        t[18][7].putClientProperty("country", "WESTSTAATEN");

        t[20][11].setVisible(true);
        t[20][11].putClientProperty("country", "OSTSTAATEN");

        t[24][8].setVisible(true);
        t[24][8].putClientProperty("country", "MITTELAMERIKA");

        //SüdAmerika

        t[30][11].setVisible(true);
        t[30][11].putClientProperty("country", "VENEZUELA");

        t[34][15].setVisible(true);
        t[34][15].putClientProperty("country", "BRASILIEN");

        t[36][13].setVisible(true);
        t[36][13].putClientProperty("country", "PERU");

        t[41][13].setVisible(true);
        t[41][13].putClientProperty("country", "ARGENTINIEN");


        //Europa

        t[8][21].setVisible(true);
        t[8][21].putClientProperty("country", "ISLAND");

        t[17][20].setVisible(true);
        t[17][20].putClientProperty("country", "GROSSBRITANNIEN");

        t[24][21].setVisible(true);
        t[24][21].putClientProperty("country", "WESTEUROPA");

        t[9][26].setVisible(true);
        t[9][26].putClientProperty("country", "SKANDINAVIEN");

        t[18][25].setVisible(true);
        t[18][25].putClientProperty("country", "NORDEUROPA");

        t[22][25].setVisible(true);
        t[22][25].putClientProperty("country", "SÜDEUROPA");

        t[12][30].setVisible(true);
        t[12][30].putClientProperty("country", "RUSSLAND");


        //Afrika

        t[30][27].setVisible(true);
        t[30][27].putClientProperty("country", "ÄGYPTEN");

        t[32][23].setVisible(true);
        t[32][23].putClientProperty("country", "NORDAFRIKA");

        t[35][29].setVisible(true);
        t[35][29].putClientProperty("country", "OSTAFRIKA");

        t[39][27].setVisible(true);
        t[39][27].putClientProperty("country", "ZENTRALAFRIKA");

        t[44][27].setVisible(true);
        t[44][27].putClientProperty("country", "SÜDAFRIKA");

        t[48][31].setVisible(true);
        t[48][31].putClientProperty("country", "MADAGASKAR");


        //Asien

        t[26][31].setVisible(true);
        t[26][31].putClientProperty("country", "MITTLEREROSTEN");

        t[20][34].setVisible(true);
        t[20][34].putClientProperty("country", "AFGHANISTAN");

        t[13][35].setVisible(true);
        t[13][35].putClientProperty("country", "URAL");

        t[8][38].setVisible(true);
        t[8][38].putClientProperty("country", "SIBIRIEN");

        t[6][41].setVisible(true);
        t[6][41].putClientProperty("country", "JAKUTIEN");

        t[14][40].setVisible(true);
        t[14][40].putClientProperty("country", "IRKUTSK");

        t[18][41].setVisible(true);
        t[18][41].putClientProperty("country", "MONGOLEI");

        t[24][40].setVisible(true);
        t[24][40].putClientProperty("country", "CHINA");

        t[27][37].setVisible(true);
        t[27][37].putClientProperty("country", "INDIEN");

        t[29][40].setVisible(true);
        t[29][40].putClientProperty("country", "SÜDOSTASIEN");

        t[6][46].setVisible(true);
        t[6][46].putClientProperty("country", "KAMTSCHATKA");

        t[19][47].setVisible(true);
        t[19][47].putClientProperty("country", "JAPAN");

        //Australien

        t[39][41].setVisible(true);
        t[39][41].putClientProperty("country", "INDONESIEN");

        t[36][46].setVisible(true);
        t[36][46].putClientProperty("country", "NEUGUINEA");

        t[46][43].setVisible(true);
        t[46][43].putClientProperty("country", "WESTAUSTRALIEN");

        t[44][47].setVisible(true);
        t[44][47].putClientProperty("country", "OSTAUSTRALIEN");

    }

    private static boolean isMaximized(int state) {
        return (state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH;
    }

    public void enableButtons() {
        t[4][17].setEnabled(true);
        t[6][41].setEnabled(true);
        t[6][46].setEnabled(true);
        t[8][21].setEnabled(true);
        t[8][38].setEnabled(true);
        t[8][3].setEnabled(true);
        t[8][8].setEnabled(true);
        t[9][26].setEnabled(true);
        t[12][7].setEnabled(true);
        t[12][30].setEnabled(true);
        t[13][35].setEnabled(true);
        t[14][11].setEnabled(true);
        t[14][14].setEnabled(true);
        t[14][40].setEnabled(true);
        t[17][20].setEnabled(true);
        t[18][25].setEnabled(true);
        t[18][41].setEnabled(true);
        t[18][7].setEnabled(true);
        t[19][47].setEnabled(true);
        t[20][11].setEnabled(true);
        t[20][34].setEnabled(true);
        t[22][25].setEnabled(true);
        t[24][21].setEnabled(true);
        t[24][40].setEnabled(true);
        t[24][8].setEnabled(true);
        t[26][31].setEnabled(true);
        t[27][37].setEnabled(true);
        t[29][40].setEnabled(true);
        t[30][11].setEnabled(true);
        t[30][27].setEnabled(true);
        t[32][23].setEnabled(true);
        t[34][15].setEnabled(true);
        t[35][29].setEnabled(true);
        t[36][13].setEnabled(true);
        t[36][46].setEnabled(true);
        t[39][27].setEnabled(true);
        t[39][41].setEnabled(true);
        t[41][13].setEnabled(true);
        t[44][27].setEnabled(true);
        t[44][47].setEnabled(true);
        t[46][43].setEnabled(true);
        t[48][31].setEnabled(true);
    }

    public void disableButtons() {
        t[4][17].setEnabled(false);
        t[6][41].setEnabled(false);
        t[6][46].setEnabled(false);
        t[8][21].setEnabled(false);
        t[8][38].setEnabled(false);
        t[8][3].setEnabled(false);
        t[8][8].setEnabled(false);
        t[9][26].setEnabled(false);
        t[12][7].setEnabled(false);
        t[12][30].setEnabled(false);
        t[13][35].setEnabled(false);
        t[14][11].setEnabled(false);
        t[14][14].setEnabled(false);
        t[14][40].setEnabled(false);
        t[17][20].setEnabled(false);
        t[18][25].setEnabled(false);
        t[18][41].setEnabled(false);
        t[18][7].setEnabled(false);
        t[19][47].setEnabled(false);
        t[20][11].setEnabled(false);
        t[20][34].setEnabled(false);
        t[22][25].setEnabled(false);
        t[24][21].setEnabled(false);
        t[24][40].setEnabled(false);
        t[24][8].setEnabled(false);
        t[26][31].setEnabled(false);
        t[27][37].setEnabled(false);
        t[29][40].setEnabled(false);
        t[30][11].setEnabled(false);
        t[30][27].setEnabled(false);
        t[32][23].setEnabled(false);
        t[34][15].setEnabled(false);
        t[35][29].setEnabled(false);
        t[36][13].setEnabled(false);
        t[36][46].setEnabled(false);
        t[39][27].setEnabled(false);
        t[39][41].setEnabled(false);
        t[41][13].setEnabled(false);
        t[44][27].setEnabled(false);
        t[44][47].setEnabled(false);
        t[46][43].setEnabled(false);
        t[48][31].setEnabled(false);
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

            System.out.println("clicked column " + btn.getClientProperty("column")
                    + ", row " + btn.getClientProperty("row"));

            String country = (String) btn.getClientProperty("country");

            System.out.println(country);
        }
    }
}
