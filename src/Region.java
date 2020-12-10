import java.util.LinkedList;

public class Region {

    private LinkedList<Area> areas;
    private int bonusTroops;

    public Region(LinkedList<Area> areas, int bonusTroops){
        this.areas = areas;
        this.bonusTroops = bonusTroops;
    }


    public int bonusTroopsFor(Player player){

        for(int i = 0; i < areas.size();i++){

            if(!areas.get(i).getFarbeOwner().equals(player.getFarbe())){
                return 0;
            }
        }

        return bonusTroops;

    }
    //todo
}
