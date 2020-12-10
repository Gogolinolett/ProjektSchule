public class Area {
    private int troopCount;
    private Farben farbeOwner;

    public Area(Farben farbeOwner){
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

    //todo
}
