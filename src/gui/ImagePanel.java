package gui;

import javax.swing.*;
import java.awt.*;


public class ImagePanel extends JPanel {

    private final Image img;
    private final Game game;
    private Image scaled;

    public ImagePanel(Image img, Game game) {
        this.img = img;
        this.game = game;
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
        g.drawImage(scaled, 0, 0, game.getMapPanel().getWidth(), game.getMapPanel().getHeight(), null);
    }
}
