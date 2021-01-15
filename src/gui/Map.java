package gui;

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
    private static final int num = 50;
    private static final JButton[][] t = new JButton[num][num];
    private static final LinkedList<JButton> btns = new LinkedList<>();
    private final Image img = ImageIO.read(new File("src\\resources\\other\\map.png"));
    private final ImagePanel lime = new ImagePanel(img);

    public Map() throws IOException {
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

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

        frame.add(layeredPane);
        frame.setVisible(true);
        countries();
    }

    public static void countries() {
        //NordAmerika
        t[8][3].setVisible(true);
        t[8][3].putClientProperty("country", "ALASKA");
        btns.add(t[8][3]);

        t[12][7].setVisible(true);
        t[12][7].putClientProperty("country", "ALBERTA");
        btns.add(t[12][7]);

        t[8][8].setVisible(true);
        t[8][8].putClientProperty("country", "NORDWESTTERRITORIUM");
        btns.add(t[8][8]);

        t[4][17].setVisible(true);
        t[4][17].putClientProperty("country", "GRÖNLAND");
        btns.add(t[4][17]);

        t[4][17].setVisible(true);
        t[14][11].putClientProperty("country", "ONTARIO");
        btns.add(t[4][17]);

        t[14][14].setVisible(true);
        t[14][14].putClientProperty("country", "OSTKANADA");
        btns.add(t[14][14]);

        t[18][7].setVisible(true);
        t[18][7].putClientProperty("country", "WESTSTAATEN");
        btns.add(t[18][7]);

        t[20][11].setVisible(true);
        t[20][11].putClientProperty("country", "OSTSTAATEN");
        btns.add(t[20][11]);

        t[24][8].setVisible(true);
        t[24][8].putClientProperty("country", "MITTELAMERIKA");
        btns.add(t[24][8]);

        //SüdAmerika
        t[30][11].setVisible(true);
        t[30][11].putClientProperty("country", "VENEZUELA");
        btns.add(t[30][11]);

        t[34][15].setVisible(true);
        t[34][15].putClientProperty("country", "BRASILIEN");
        btns.add(t[34][15]);

        t[36][13].setVisible(true);
        t[36][13].putClientProperty("country", "PERU");
        btns.add(t[36][13]);

        t[41][13].setVisible(true);
        t[41][13].putClientProperty("country", "ARGENTINIEN");
        btns.add(t[41][13]);

        //Europa
        t[8][21].setVisible(true);
        t[8][21].putClientProperty("country", "ISLAND");
        btns.add(t[8][21]);

        t[17][20].setVisible(true);
        t[17][20].putClientProperty("country", "GROSSBRITANNIEN");
        btns.add(t[17][20]);

        t[24][21].setVisible(true);
        t[24][21].putClientProperty("country", "WESTEUROPA");
        btns.add(t[24][21]);

        t[9][26].setVisible(true);
        t[9][26].putClientProperty("country", "SKANDINAVIEN");
        btns.add(t[9][26]);

        t[18][25].setVisible(true);
        t[18][25].putClientProperty("country", "NORDEUROPA");
        btns.add(t[18][25]);

        t[22][25].setVisible(true);
        t[22][25].putClientProperty("country", "SÜDEUROPA");
        btns.add(t[22][25]);

        t[12][30].setVisible(true);
        t[12][30].putClientProperty("country", "RUSSLAND");
        btns.add(t[12][30]);

        //Afrika
        t[30][27].setVisible(true);
        t[30][27].putClientProperty("country", "ÄGYPTEN");
        btns.add(t[30][27]);

        t[32][23].setVisible(true);
        t[32][23].putClientProperty("country", "NORDAFRIKA");
        btns.add(t[32][23]);

        t[35][29].setVisible(true);
        t[35][29].putClientProperty("country", "OSTAFRIKA");
        btns.add(t[35][29]);

        t[39][27].setVisible(true);
        t[39][27].putClientProperty("country", "ZENTRALAFRIKA");
        btns.add(t[39][27]);

        t[44][27].setVisible(true);
        t[44][27].putClientProperty("country", "SÜDAFRIKA");
        btns.add(t[44][27]);

        t[48][31].setVisible(true);
        t[48][31].putClientProperty("country", "MADAGASKAR");
        btns.add(t[48][31]);

        //Asien
        t[26][31].setVisible(true);
        t[26][31].putClientProperty("country", "MITTLEREROSTEN");
        btns.add(t[26][31]);

        t[20][34].setVisible(true);
        t[20][34].putClientProperty("country", "AFGHANISTAN");
        btns.add(t[20][34]);

        t[13][35].setVisible(true);
        t[13][35].putClientProperty("country", "URAL");
        btns.add(t[13][35]);

        t[8][38].setVisible(true);
        t[8][38].putClientProperty("country", "SIBIRIEN");
        btns.add(t[8][38]);

        t[6][41].setVisible(true);
        t[6][41].putClientProperty("country", "JAKUTIEN");
        btns.add(t[6][41]);

        t[14][40].setVisible(true);
        t[14][40].putClientProperty("country", "IRKUTSK");
        btns.add(t[14][40]);

        t[18][41].setVisible(true);
        t[18][41].putClientProperty("country", "MONGOLEI");
        btns.add(t[18][41]);

        t[24][40].setVisible(true);
        t[24][40].putClientProperty("country", "CHINA");
        btns.add(t[24][40]);

        t[27][37].setVisible(true);
        t[27][37].putClientProperty("country", "INDIEN");
        btns.add(t[27][37]);

        t[29][40].setVisible(true);
        t[29][40].putClientProperty("country", "SÜDOSTASIEN");
        btns.add(t[29][40]);

        t[6][46].setVisible(true);
        t[6][46].putClientProperty("country", "KAMTSCHATKA");
        btns.add(t[6][46]);

        t[19][47].setVisible(true);
        t[19][47].putClientProperty("country", "JAPAN");
        btns.add(t[19][47]);

        //Australien
        t[39][41].setVisible(true);
        t[39][41].putClientProperty("country", "INDONESIEN");
        btns.add(t[39][41]);

        t[36][46].setVisible(true);
        t[36][46].putClientProperty("country", "NEUGUINEA");
        btns.add(t[36][46]);

        t[46][43].setVisible(true);
        t[46][43].putClientProperty("country", "WESTAUSTRALIEN");
        btns.add(t[46][43]);

        t[44][47].setVisible(true);
        t[44][47].putClientProperty("country", "OSTAUSTRALIEN");
        btns.add(t[44][47]);
    }

    private static boolean isMaximized(int state) {
        return (state & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH;
    }

    public void toggleButtons(boolean x) {
        for (int i = 0; i < btns.size(); i++) {
            btns.get(i).setEnabled(x);
        }
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

            System.out.println("clicked column " + btn.getClientProperty("column")
                    + ", row " + btn.getClientProperty("row"));

            String country = (String) btn.getClientProperty("country");

            System.out.println(country);
        }
    }
}
