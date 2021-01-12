package gui;

import classes.Area;
import classes.Board;
import classes.Player;
import classes.Region;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class Main {

    private static LinkedList<Area> areas = new LinkedList<>();
    private static LinkedList<Region> regions = new LinkedList<>();
    private static Player[] players;
    private static int activePlayer;
    private static int stage = 0;
    private static First f;
    public static void main(String[] args) throws IOException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Look and feel not set.");
        }
        Map m = new Map();

        addAreas();
        addRegions();
        stage1Gui();
        Board board = new Board(areas, regions);


    }

    public static void addAreas() {

    }

    public static void addRegions() {

    }

    public static void nextStage() {

        stage = stage + 1;
        if (stage > 3) {
            activePlayer = activePlayer + 1;
            stage = 1;

        }

    }

    public static void stage1Gui() {

        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 750);
        f = new First(players[activePlayer % players.length]);
        f.setOpaque(true);
        frame.add(f);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);

    }


    public static void act() {

        if (stage == 1) {

        }


    }

}
