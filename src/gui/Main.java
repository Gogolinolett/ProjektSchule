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
    private static Second s;
    private static JFrame frame = new JFrame();
    private static Map m;

    public static void main(String[] args) throws IOException {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Look and feel not set.");
        }
        m = new Map();


        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 750);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);

        setupAreasAndRegions();
        stage1Gui();
        Board board = new Board(areas, regions);

        stage1Gui();

    }

    public static void setupAreasAndRegions() {
        //NordAmerika
        LinkedList<Area> z = new LinkedList<>();
        Area Alberta = new Area("ALBERTA");
        areas.add(Alberta);
        z.add(Alberta);
        Area Alaska = new Area("ALASKA");
        areas.add(Alaska);
        z.add(Alaska);
        Area NordwestTerritorium = new Area("NORDWESTTERRITORIUM");
        areas.add(NordwestTerritorium);
        z.add(NordwestTerritorium);
        Area Ontario = new Area("ONTARIO");
        areas.add(Ontario);
        z.add(Ontario);
        Area WestStaaten = new Area("WESTSTAATEN");
        areas.add(WestStaaten);
        z.add(WestStaaten);
        Area OstStaaten = new Area("OSTSTAATEN");
        areas.add(OstStaaten);
        z.add(OstStaaten);
        Area MittelAmerika = new Area("MITTELAMERIKA");
        areas.add(MittelAmerika);
        z.add(MittelAmerika);
        Area OstKanada = new Area("OSTKANADA");
        areas.add(OstKanada);
        z.add(OstKanada);
        Area Grönland = new Area("GRÖNLAND");
        areas.add(Grönland);
        z.add(Grönland);
        Region nordamerika = new Region(z, 5);
        regions.add(nordamerika);

        //SüdAmerika
        z = new LinkedList<>();
        Area Venezuela = new Area("VENEZUELA");
        areas.add(Venezuela);
        z.add(Venezuela);
        Area Brasilien = new Area("BRASILIEN");
        areas.add(Brasilien);
        z.add(Brasilien);
        Area Peru = new Area("PERU");
        areas.add(Peru);
        z.add(Peru);
        Area Argentinien = new Area("ARGENTINIEN");
        areas.add(Argentinien);
        z.add(Argentinien);
        Region südamerika = new Region(z, 2);
        regions.add(südamerika);

        //Europa
        z = new LinkedList<>();
        Area Island = new Area("ISLAND");
        areas.add(Island);
        z.add(Island);
        Area Großbritannien = new Area("GROSSBRITANNIEN");
        areas.add(Großbritannien);
        z.add(Großbritannien);
        Area WestEuropa = new Area("WESTEUROPA");
        areas.add(WestEuropa);
        z.add(WestEuropa);
        Area Skandinavien = new Area("SKANDINAVIEN");
        areas.add(Skandinavien);
        z.add(Skandinavien);
        Area Russland = new Area("RUSSLAND");
        areas.add(Russland);
        z.add(Russland);
        Area NordEuropa = new Area("NORDEUROPA");
        areas.add(NordEuropa);
        z.add(NordEuropa);
        Area SüdEuropa = new Area("SÜDEUROPA");
        areas.add(SüdEuropa);
        z.add(SüdEuropa);
        Region Europa = new Region(z, 5);
        regions.add(Europa);

        //Afrika
        z = new LinkedList<>();
        Area Ägypten = new Area("ÄGYPTEN");
        areas.add(Ägypten);
        z.add(Ägypten);
        Area NordAfrika = new Area("NORDAFRIKA");
        areas.add(NordAfrika);
        z.add(NordAfrika);
        Area OstAfrika = new Area("OSTAFRIKA");
        areas.add(OstAfrika);
        z.add(OstAfrika);
        Area ZentralAfrika = new Area("ZENTRALAFRIKA");
        areas.add(ZentralAfrika);
        z.add(ZentralAfrika);
        Area SüdAfrika = new Area("SÜDAFRIKA");
        areas.add(SüdAfrika);
        z.add(SüdAfrika);
        Area Madagaskar = new Area("MADAGASKAR");
        areas.add(Madagaskar);
        z.add(Madagaskar);
        Region Afrika = new Region(z, 3);
        regions.add(Afrika);

        //Australien
        z = new LinkedList<>();
        Area OstAustralien = new Area("OSTAUSTRALIEN");
        areas.add(OstAustralien);
        z.add(OstAustralien);
        Area Neuguinea = new Area("NEUGUINEA");
        areas.add(Neuguinea);
        z.add(Neuguinea);
        Area Indonesien = new Area("INDONESIEN");
        areas.add(Indonesien);
        z.add(Indonesien);
        Area WestAustralien = new Area("WESTAUSTRALIEN");
        areas.add(WestAustralien);
        z.add(WestAustralien);
        Region Australien = new Region(z, 2);
        regions.add(Australien);

        //Asien
        z = new LinkedList<>();
        Area MittlererOsten = new Area("MITTLEREROSTEN");
        areas.add(MittlererOsten);
        z.add(MittlererOsten);
        Area Indien = new Area("INDIEN");
        areas.add(Indien);
        z.add(Indien);
        Area SüdostAsien = new Area("SÜDOSTASIEN");
        areas.add(SüdostAsien);
        z.add(SüdostAsien);
        Area China = new Area("CHINA");
        areas.add(China);
        z.add(China);
        Area Afghanistan = new Area("AFGHANISTAN");
        areas.add(Afghanistan);
        z.add(Afghanistan);
        Area Mongolei = new Area("MONGOLEI");
        areas.add(Mongolei);
        z.add(Mongolei);
        Area Japan = new Area("JAPAN");
        areas.add(Japan);
        z.add(Japan);
        Area Ural = new Area("URAL");
        areas.add(Ural);
        z.add(Ural);
        Area Irkutsk = new Area("IRKUTSK");
        areas.add(Irkutsk);
        z.add(Irkutsk);
        Area Sibirien = new Area("SIBIRIEN");
        areas.add(Sibirien);
        z.add(Sibirien);
        Area Jakutien = new Area("JAKUTIEN");
        areas.add(Jakutien);
        z.add(Jakutien);
        Area Kamtschatka = new Area("KAMTSCHATKA");
        areas.add(Kamtschatka);
        z.add(Kamtschatka);
        Region Asien = new Region(z, 7);
        regions.add(Asien);

        Alaska.addNeighbour(NordwestTerritorium);
        Alaska.addNeighbour(Kamtschatka);
        Alaska.addNeighbour(Alberta);
        NordwestTerritorium.addNeighbour(Alaska);
        NordwestTerritorium.addNeighbour(Alberta);
        NordwestTerritorium.addNeighbour(Ontario);
        NordwestTerritorium.addNeighbour(Grönland);
        Alberta.addNeighbour(NordwestTerritorium);
        Alberta.addNeighbour(Alaska);
        Alberta.addNeighbour(WestStaaten);
        Alberta.addNeighbour(Ontario);
        WestStaaten.addNeighbour(MittelAmerika);
        WestStaaten.addNeighbour(OstStaaten);
        WestStaaten.addNeighbour(Ontario);
        WestStaaten.addNeighbour(Alberta);
        MittelAmerika.addNeighbour(WestStaaten);
        MittelAmerika.addNeighbour(OstStaaten);
        OstStaaten.addNeighbour(Ontario);
        OstStaaten.addNeighbour(OstKanada);
        Ontario.addNeighbour(OstKanada);
        Ontario.addNeighbour(Grönland);
        OstKanada.addNeighbour(Grönland);
        Venezuela.addNeighbour(MittelAmerika);
        Venezuela.addNeighbour(Brasilien);
        Venezuela.addNeighbour(Peru);
        Brasilien.addNeighbour(NordAfrika);
        Argentinien.addNeighbour(Peru);
        Argentinien.addNeighbour(Brasilien);
        Brasilien.addNeighbour(Peru);
        NordAfrika.addNeighbour(WestEuropa);
        NordAfrika.addNeighbour(Ägypten);
        NordAfrika.addNeighbour(OstAfrika);
        NordAfrika.addNeighbour(ZentralAfrika);
        Ägypten.addNeighbour(SüdEuropa);
        Ägypten.addNeighbour(OstAfrika);
        OstAfrika.addNeighbour(MittlererOsten);
        OstAfrika.addNeighbour(ZentralAfrika);
        OstAfrika.addNeighbour(SüdAfrika);
        ZentralAfrika.addNeighbour(SüdAfrika);
        Madagaskar.addNeighbour(OstAfrika);
        Madagaskar.addNeighbour(SüdAfrika);
        WestEuropa.addNeighbour(SüdEuropa);
        WestEuropa.addNeighbour(NordEuropa);
        WestEuropa.addNeighbour(Großbritannien);
        NordEuropa.addNeighbour(SüdEuropa);
        Großbritannien.addNeighbour(Island);
        Großbritannien.addNeighbour(Skandinavien);
        Großbritannien.addNeighbour(NordEuropa);
        Skandinavien.addNeighbour(NordEuropa);
        Skandinavien.addNeighbour(Island);
        Skandinavien.addNeighbour(Russland);
        Russland.addNeighbour(NordEuropa);
        Russland.addNeighbour(SüdEuropa);
        Russland.addNeighbour(Ural);
        Russland.addNeighbour(Afghanistan);
        Russland.addNeighbour(MittlererOsten);
        MittlererOsten.addNeighbour(Afghanistan);
        MittlererOsten.addNeighbour(Indien);
        Indien.addNeighbour(SüdostAsien);
        Indien.addNeighbour(Afghanistan);
        Indien.addNeighbour(China);
        Afghanistan.addNeighbour(China);
        Afghanistan.addNeighbour(Ural);
        China.addNeighbour(Mongolei);
        China.addNeighbour(Sibirien);
        China.addNeighbour(Ural);
        China.addNeighbour(SüdostAsien);
        Ural.addNeighbour(Sibirien);
        Sibirien.addNeighbour(Jakutien);
        Sibirien.addNeighbour(Irkutsk);
        Sibirien.addNeighbour(Mongolei);
        Jakutien.addNeighbour(Kamtschatka);
        Jakutien.addNeighbour(Irkutsk);
        Irkutsk.addNeighbour(Kamtschatka);
        Mongolei.addNeighbour(Irkutsk);
        Mongolei.addNeighbour(Kamtschatka);
        Japan.addNeighbour(Mongolei);
        Japan.addNeighbour(Kamtschatka);
        SüdostAsien.addNeighbour(Indonesien);
        Indonesien.addNeighbour(WestAustralien);
        Neuguinea.addNeighbour(Indonesien);
        Neuguinea.addNeighbour(OstAustralien);
        WestAustralien.addNeighbour(OstAustralien);
    }

    public static void nextStage() {

        stage = stage + 1;
        if (stage > 3) {
            activePlayer = activePlayer + 1;
            stage = 1;
            stage1Gui();
        }

    }

    public static void stage1Gui() {

        frame.getContentPane().removeAll();
        f = new First(players[activePlayer % players.length]);
        f.setOpaque(true);
        frame.add(f);
        frame.revalidate();

    }

    public static void stage2Gui() {

        frame.getContentPane().removeAll();
        s = new Second();
        s.setOpaque(true);
        frame.add(s);
        frame.revalidate();

    }

    public static void updateGui() {
        frame.revalidate();
        //m.refresh();
    }


    public static void act(Area area) {

        if (stage == 1) {
            f.setLand(area);
            updateGui();
        } else if (stage == 2) {

            if (area.getFarbeOwner().equals(players[activePlayer].getFarbe())) {
                s.setAttackingArea(area);
            } else {
                s.setDefendingArea(area);
            }
            updateGui();
        }


    }

    public static Area stringToArea(String name) {

        for (Area a : areas) {
            if (a.getName().equalsIgnoreCase(name)) {
                return a;
            }
        }

        return null;
    }

}
