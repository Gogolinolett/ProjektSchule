package classes;

import java.util.LinkedList;

public class MainClass {

    public static void initialize() {

        LinkedList<Area> areas = new LinkedList<>();
        LinkedList<Region> regions = new LinkedList<>();

        addAreas(areas);
        addRegions(regions);

        Board board = new Board(areas, regions);





    }
    //todo

    public static void addAreas(LinkedList<Area> areas){

    }

    public static void addRegions(LinkedList<Region> regions){

    }
}
