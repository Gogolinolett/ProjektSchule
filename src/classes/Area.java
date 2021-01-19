package classes;

import gui.Main;

import java.awt.*;
import java.util.LinkedList;

public class Area {
    private int troopCount;
    private Color farbeOwner;
    private String name;
    private LinkedList<Area> neighbours = new LinkedList<>();

    public Area(String name) {
        this.name = name;
        troopCount = 1;
    }

    public void addTroops(int amount) {
        troopCount += amount;
        Main.updateGui();
    }

    public String getName() {
        return name;
    }

    public Color getFarbeOwner() {
        return farbeOwner;
    }

    public void setFarbeOwner(Color farbeOwner) {
        this.farbeOwner = farbeOwner;
    }

    public int getTroopCount() {
        return troopCount;
    }

    public void setTroopCount(int troopCount) {
        this.troopCount = troopCount;
    }

    public void addNeighbour(Area area) {
        if (neighbours.contains(area)) {
            return;
        }
        neighbours.add(area);
        area.addNeighbour(this);
    }

    public boolean isNeighbour(Area area) {
        for (Area a : neighbours) {
            if (a.equals(area)) {
                return true;
            }
        }
        return false;
    }
}
