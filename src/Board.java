import java.util.LinkedList;

public class Board {

    private LinkedList<Region> regions;
    private LinkedList<Area> areas;


    public Board(LinkedList<Area> areas, LinkedList<Region> regions){
        this.areas = areas;
        this.regions = regions;
    }

    public int getOwnedRegionsTroopsAmount(Player player){
        int ownedRegions = 0;
        for(int i = 0; i < areas.size(); i ++){

            if(areas.get(i).getFarbeOwner().equals(player.getFarbe())){
                ownedRegions ++;
            }

        }
        return ownedRegions;
    }

    public int getOwnedAreasAmount(Player player) {
        int count = 0;
        for(int i = 0; i < areas.size() ;i ++){
            if(areas.get(i).getFarbeOwner().equals(player.getFarbe())){
                count ++;
            }
        }
        return count;
    }

    public void placeTroop(Area area){
        area.setTroopCount(area.getTroopCount() + 1);
    }

    public void fight(Area aggressor, Area defender, int troops){
        if(troops + 1 > aggressor.getTroopCount()){
            return;
        }

        

    }
}
