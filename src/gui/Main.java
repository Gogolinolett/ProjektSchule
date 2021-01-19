package gui;

import classes.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    private static LinkedList<Area> areas = new LinkedList<>();
    private static LinkedList<Region> regions = new LinkedList<>();
    private static LinkedList<Player> players;
    private static int activePlayer = 0;
    private static int stage = 1;
    private static First f;
    private static Second s;
    private static Third t;
    private static JFrame frame = new JFrame();
    private static Map m;
    private static PlayerSelection playerSelection;
    private static Start start;
    private static Board board;
    private static LinkedList<WinningConditions> winConCards;

    public static void main(String[] args) throws IOException {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Look and feel not set.");
        }
        m = new Map();
        m.setVisible(false);

         start = new Start();

        setupAreasAndRegions();
        board = new Board(areas, regions);


    }
    public static void setUpWinConCards() throws IOException {
        winConCards = new LinkedList<>();

        WinningConditions mk_18_2 = new WinningConditions(null, null, null, 3, ImageIO.read(new File("src\\resources\\miss_karte\\MK_18_2.png")));
        winConCards.add(mk_18_2);
        WinningConditions mk_24 = new WinningConditions(null, null, null, 2, ImageIO.read(new File("src\\resources\\miss_karte\\MK_24.png")));
        winConCards.add(mk_24);
        WinningConditions mk_af_as = new WinningConditions(regions.get(3), regions.get(5), null, 1, ImageIO.read(new File("src\\resources\\miss_karte\\MK_af&as.png")));
        winConCards.add(mk_af_as);
        WinningConditions mk_as_sa = new WinningConditions(regions.get(5), regions.get(1), null, 1, ImageIO.read(new File("src\\resources\\miss_karte\\MK_as&sa.png")));
        winConCards.add(mk_as_sa);
        WinningConditions mk_bl = new WinningConditions(null,null, Color.BLUE , 0, ImageIO.read(new File("src\\resources\\miss_karte\\MK_bl.png")));
        winConCards.add(mk_bl);
        WinningConditions mk_bla = new WinningConditions(null,null, Color.BLACK , 0, ImageIO.read(new File("src\\resources\\miss_karte\\MK_bla.png")));
        winConCards.add(mk_bla);
        WinningConditions mk_eu_oc_3 = new WinningConditions(regions.get(2), regions.get(4), null, 4, ImageIO.read(new File("src\\resources\\miss_karte\\MK_eu&oc&3.png")));
        winConCards.add(mk_eu_oc_3);
        WinningConditions mk_eu_sa_3 = new WinningConditions(regions.get(2), regions.get(1), null, 4, ImageIO.read(new File("src\\resources\\miss_karte\\MK_eu&sa&3.png")));
        winConCards.add(mk_eu_sa_3);
        WinningConditions mk_gr = new WinningConditions(null,null, Color.GREEN , 0, ImageIO.read(new File("src\\resources\\miss_karte\\MK_gr.png")));
        winConCards.add(mk_gr);
        WinningConditions mk_na_af = new WinningConditions(regions.get(0), regions.get(3), null, 1, ImageIO.read(new File("src\\resources\\miss_karte\\MK_na&af.png")));
        winConCards.add(mk_na_af);
        WinningConditions mk_na_oc = new WinningConditions(regions.get(0), regions.get(4), null, 1, ImageIO.read(new File("src\\resources\\miss_karte\\MK_na&oc.png")));
        winConCards.add(mk_na_oc);
        WinningConditions mk_pi = new WinningConditions(null,null, Color.PINK , 0, ImageIO.read(new File("src\\resources\\miss_karte\\MK_pi.png")));
        winConCards.add(mk_pi);
        WinningConditions mk_re = new WinningConditions(null,null, Color.RED , 0, ImageIO.read(new File("src\\resources\\miss_karte\\MK_re.png")));
        winConCards.add(mk_re);
        WinningConditions mk_ye = new WinningConditions(null,null, Color.YELLOW , 0, ImageIO.read(new File("src\\resources\\miss_karte\\MK_ye.png")));
        winConCards.add(mk_ye);

    }

    public static void setupAreasAndRegions() {

        //NordAmerika
        LinkedList<Area> z = new LinkedList<>();
        Area alberta = new Area("ALBERTA");
        areas.add(alberta);
        z.add(alberta);
        Area alaska = new Area("ALASKA");
        areas.add(alaska);
        z.add(alaska);
        Area nordwestTerritorium = new Area("NORDWESTTERRITORIUM");
        areas.add(nordwestTerritorium);
        z.add(nordwestTerritorium);
        Area ontario = new Area("ONTARIO");
        areas.add(ontario);
        z.add(ontario);
        Area westStaaten = new Area("WESTSTAATEN");
        areas.add(westStaaten);
        z.add(westStaaten);
        Area ostStaaten = new Area("OSTSTAATEN");
        areas.add(ostStaaten);
        z.add(ostStaaten);
        Area mittelAmerika = new Area("MITTELAMERIKA");
        areas.add(mittelAmerika);
        z.add(mittelAmerika);
        Area ostKanada = new Area("OSTKANADA");
        areas.add(ostKanada);
        z.add(ostKanada);
        Area grönland = new Area("GRÖNLAND");
        areas.add(grönland);
        z.add(grönland);
        Region nordAmerika = new Region(z, 5);
        regions.add(nordAmerika);

        //SüdAmerika
        z = new LinkedList<>();
        Area venezuela = new Area("VENEZUELA");
        areas.add(venezuela);
        z.add(venezuela);
        Area brasilien = new Area("BRASILIEN");
        areas.add(brasilien);
        z.add(brasilien);
        Area peru = new Area("PERU");
        areas.add(peru);
        z.add(peru);
        Area argentinien = new Area("ARGENTINIEN");
        areas.add(argentinien);
        z.add(argentinien);
        Region südAmerika = new Region(z, 2);
        regions.add(südAmerika);


        //europa
        z = new LinkedList<>();
        Area island = new Area("ISLAND");
        areas.add(island);
        z.add(island);
        Area grossBritannien = new Area("GROSSBRITANNIEN");
        areas.add(grossBritannien);
        z.add(grossBritannien);
        Area westEuropa = new Area("WESTEUROPA");
        areas.add(westEuropa);
        z.add(westEuropa);
        Area skandinavien = new Area("SKANDINAVIEN");
        areas.add(skandinavien);
        z.add(skandinavien);
        Area russland = new Area("RUSSLAND");
        areas.add(russland);
        z.add(russland);
        Area nordEuropa = new Area("NORDEUROPA");
        areas.add(nordEuropa);
        z.add(nordEuropa);
        Area südEuropa = new Area("SÜDEUROPA");
        areas.add(südEuropa);
        z.add(südEuropa);
        Region europa = new Region(z, 5);
        regions.add(europa);


        //afrika
        z = new LinkedList<>();
        Area ägypten = new Area("ÄGYPTEN");
        areas.add(ägypten);
        z.add(ägypten);
        Area nordAfrika = new Area("NORDAFRIKA");
        areas.add(nordAfrika);
        z.add(nordAfrika);
        Area ostAfrika = new Area("OSTAFRIKA");
        areas.add(ostAfrika);
        z.add(ostAfrika);
        Area zentralAfrika = new Area("ZENTRALAFRIKA");
        areas.add(zentralAfrika);
        z.add(zentralAfrika);
        Area südAfrika = new Area("SÜDAFRIKA");
        areas.add(südAfrika);
        z.add(südAfrika);
        Area madagaskar = new Area("MADAGASKAR");
        areas.add(madagaskar);
        z.add(madagaskar);
        Region afrika = new Region(z, 3);
        regions.add(afrika);


        //australien
        z = new LinkedList<>();
        Area ostAustralien = new Area("OSTAUSTRALIEN");
        areas.add(ostAustralien);
        z.add(ostAustralien);
        Area neuGuinea = new Area("NEUGUINEA");
        areas.add(neuGuinea);
        z.add(neuGuinea);
        Area indonesien = new Area("INDONESIEN");
        areas.add(indonesien);
        z.add(indonesien);
        Area westAustralien = new Area("WESTAUSTRALIEN");
        areas.add(westAustralien);
        z.add(westAustralien);
        Region australien = new Region(z, 2);
        regions.add(australien);


        //asien
        z = new LinkedList<>();
        Area mittlererOsten = new Area("MITTLEREROSTEN");
        areas.add(mittlererOsten);
        z.add(mittlererOsten);
        Area indien = new Area("INDIEN");
        areas.add(indien);
        z.add(indien);
        Area südostAsien = new Area("SÜDOSTASIEN");
        areas.add(südostAsien);
        z.add(südostAsien);
        Area china = new Area("CHINA");
        areas.add(china);
        z.add(china);
        Area afghanistan = new Area("AFGHANISTAN");
        areas.add(afghanistan);
        z.add(afghanistan);
        Area mongolei = new Area("MONGOLEI");
        areas.add(mongolei);
        z.add(mongolei);
        Area japan = new Area("JAPAN");
        areas.add(japan);
        z.add(japan);
        Area ural = new Area("URAL");
        areas.add(ural);
        z.add(ural);
        Area irkutsk = new Area("IRKUTSK");
        areas.add(irkutsk);
        z.add(irkutsk);
        Area sibirien = new Area("SIBIRIEN");
        areas.add(sibirien);
        z.add(sibirien);
        Area jakutien = new Area("JAKUTIEN");
        areas.add(jakutien);
        z.add(jakutien);
        Area kamtschatka = new Area("KAMTSCHATKA");
        areas.add(kamtschatka);
        z.add(kamtschatka);
        Region asien = new Region(z, 7);
        regions.add(asien);

        alaska.addNeighbour(nordwestTerritorium);
        alaska.addNeighbour(kamtschatka);
        alaska.addNeighbour(alberta);
        nordwestTerritorium.addNeighbour(alaska);
        nordwestTerritorium.addNeighbour(alberta);
        nordwestTerritorium.addNeighbour(ontario);
        nordwestTerritorium.addNeighbour(grönland);
        alberta.addNeighbour(nordwestTerritorium);
        alberta.addNeighbour(alaska);
        alberta.addNeighbour(westStaaten);
        alberta.addNeighbour(ontario);
        westStaaten.addNeighbour(mittelAmerika);
        westStaaten.addNeighbour(ostStaaten);
        westStaaten.addNeighbour(ontario);
        westStaaten.addNeighbour(alberta);
        mittelAmerika.addNeighbour(westStaaten);
        mittelAmerika.addNeighbour(ostStaaten);
        ostStaaten.addNeighbour(ontario);
        ostStaaten.addNeighbour(ostKanada);
        ontario.addNeighbour(ostKanada);
        ontario.addNeighbour(grönland);
        ostKanada.addNeighbour(grönland);
        venezuela.addNeighbour(mittelAmerika);
        venezuela.addNeighbour(brasilien);
        venezuela.addNeighbour(peru);
        brasilien.addNeighbour(nordAfrika);
        argentinien.addNeighbour(peru);
        argentinien.addNeighbour(brasilien);
        brasilien.addNeighbour(peru);
        nordAfrika.addNeighbour(westEuropa);
        nordAfrika.addNeighbour(ägypten);
        nordAfrika.addNeighbour(ostAfrika);
        nordAfrika.addNeighbour(zentralAfrika);
        ägypten.addNeighbour(südEuropa);
        ägypten.addNeighbour(ostAfrika);
        ostAfrika.addNeighbour(mittlererOsten);
        ostAfrika.addNeighbour(zentralAfrika);
        ostAfrika.addNeighbour(südAfrika);
        zentralAfrika.addNeighbour(südAfrika);
        madagaskar.addNeighbour(ostAfrika);
        madagaskar.addNeighbour(südAfrika);
        westEuropa.addNeighbour(südEuropa);
        westEuropa.addNeighbour(nordEuropa);
        westEuropa.addNeighbour(grossBritannien);
        nordEuropa.addNeighbour(südEuropa);
        grossBritannien.addNeighbour(island);
        grossBritannien.addNeighbour(skandinavien);
        grossBritannien.addNeighbour(nordEuropa);
        skandinavien.addNeighbour(nordEuropa);
        skandinavien.addNeighbour(island);
        skandinavien.addNeighbour(russland);
        russland.addNeighbour(nordEuropa);
        russland.addNeighbour(südEuropa);
        russland.addNeighbour(ural);
        russland.addNeighbour(afghanistan);
        russland.addNeighbour(mittlererOsten);
        mittlererOsten.addNeighbour(afghanistan);
        mittlererOsten.addNeighbour(indien);
        indien.addNeighbour(südostAsien);
        indien.addNeighbour(afghanistan);
        indien.addNeighbour(china);
        afghanistan.addNeighbour(china);
        afghanistan.addNeighbour(ural);
        china.addNeighbour(mongolei);
        china.addNeighbour(sibirien);
        china.addNeighbour(ural);
        china.addNeighbour(südostAsien);
        ural.addNeighbour(sibirien);
        sibirien.addNeighbour(jakutien);
        sibirien.addNeighbour(irkutsk);
        sibirien.addNeighbour(mongolei);
        jakutien.addNeighbour(kamtschatka);
        jakutien.addNeighbour(irkutsk);
        irkutsk.addNeighbour(kamtschatka);
        mongolei.addNeighbour(irkutsk);
        mongolei.addNeighbour(kamtschatka);
        japan.addNeighbour(mongolei);
        japan.addNeighbour(kamtschatka);
        südostAsien.addNeighbour(indonesien);
        indonesien.addNeighbour(westAustralien);
        neuGuinea.addNeighbour(indonesien);
        neuGuinea.addNeighbour(ostAustralien);
        westAustralien.addNeighbour(ostAustralien);
    }

    public static void nextStage() {

        stage = stage + 1;
        if (stage > 3) {
            activePlayer = activePlayer + 1;
            if(activePlayer >= players.size()) {
                activePlayer = 0;
            }
            stage = 1;
            stage1Gui();
        }else if(stage == 2){
            stage2Gui();
        }else {
            stage3Gui();
        }

    }

    public static void startPlayerSelection() throws IOException {
        start.setVisible(false);
        playerSelection = new PlayerSelection();
    }

    public static void startGame(LinkedList<Player> playerss){
        players = playerss;
        playerSelection.setVisible(false);
        frame.setLayout(new GridLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 750);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
<<<<<<< HEAD

        boolean zwischen2 = false;
=======
/*
>>>>>>> 5a2ba907d9b84b6ff7e303543c85713ceca0e058
        for(WinningConditions winningConditions : winConCards){
            for(Player p : playerss){
                if (winningConditions.getColor().equals(p.getFarbe())){
                    zwischen2 = true;
                }
            }
            if (zwischen2 == false){
                winConCards.remove(winningConditions);
            }
            zwischen2 = false;

        }

        for(Player p : playerss){

            int rand = (int)(Math.random() * (winConCards.size()  + 1));
            p.setWinningConditions(winConCards.get(rand));
            winConCards.remove(winConCards.get(rand));
        }
*/
        m.setVisible(true);

        int size = areas.size();
        LinkedList<Area> zwischen = new LinkedList<>();
        for(Area a : areas ){
            zwischen.add(a);
        }

        for(int i = 0; i < size; i ++){
            int num = (int) (Math.random() * ((zwischen.size() - 1) + 0));

            zwischen.get(num).setFarbeOwner(playerss.get(i % playerss.size()).getFarbe());
            zwischen.remove(num);

        }
        updateGui();
        stage1Gui();
    }

    public static void stage1Gui() {

        frame.getContentPane().removeAll();
        f = new First(players.get(activePlayer));
        f.setOpaque(true);
        frame.add(f);
        frame.revalidate();

    }

    public static void stage2Gui() {

        frame.getContentPane().removeAll();
        s = new Second(players.get(activePlayer));
        s.setOpaque(true);
        frame.add(s);
        frame.revalidate();

    }

    public static void stage3Gui(){
        frame.getContentPane().removeAll();
        t = new Third(players.get(activePlayer));
        t.setOpaque(true);
        frame.add(t);
        frame.revalidate();
    }

    public static void updateGui() {
        m.updateMap(areas);
        frame.revalidate();
    }


    public static void act(Area area) {

        if (stage == 1) {
            f.setLand(area);
            updateGui();
        } else if (stage == 2) {

            if (area.getFarbeOwner().equals(players.get(activePlayer).getFarbe())) {
                s.setAttackingArea(area);
            } else {
                s.setDefendingArea(area);
            }
            updateGui();
        }else if(stage == 3){
            if(players.get(activePlayer).getFarbe().equals(area.getFarbeOwner())){
                t.setArea(area);
            }

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

    public static void errorMessage(String message, String windowname) {
        JOptionPane.showMessageDialog(null, message, windowname, JOptionPane.WARNING_MESSAGE);
    }

    public static Board getBoard() {
        return board;
    }
}
