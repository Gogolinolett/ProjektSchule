package classes;

import java.util.LinkedList;

public class Area {
    private int troopCount;
    private Farben farbeOwner;
    LinkedList<Area> neighbours = new LinkedList<>();

    public Area(Farben farbeOwner){
        this.farbeOwner = farbeOwner;
        troopCount = 1;
    }

    public void setFarbeOwner(Farben farbeOwner) {
        this.farbeOwner = farbeOwner;
    }

    public Farben getFarbeOwner() {
        return farbeOwner;
    }

    public void setTroopCount(int troopCount) {
        this.troopCount = troopCount;
    }

    public int getTroopCount(){
        return troopCount;
    }

    public void addNeighbour(Area area){
        if(neighbours.contains(area)){
            return;
        }
        neighbours.add(area);
        area.addNeighbour(this);


    }
}
