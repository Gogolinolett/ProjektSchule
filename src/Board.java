import java.util.LinkedList;
import java.util.Random;

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

        Random rndm = new Random();
        int[] angreiferErgebniss = {0,0};
        int[] verteiderEgebniss = new int[defender.getTroopCount()];

        for (int i = 0; i < troops && i < 3; i++) {
            int z = rndm.nextInt(6);

            if(z > angreiferErgebniss[0] && angreiferErgebniss[0] < angreiferErgebniss[1]){
                angreiferErgebniss[0] = z;
            }else if(z > angreiferErgebniss[1]){
                angreiferErgebniss[1] = z;
            }

        }

        for (int i = 0; i < defender.getTroopCount() && i < 2; i++) {
            verteiderEgebniss[i] = rndm.nextInt(6);
        }



        if(angreiferErgebniss[0] < angreiferErgebniss[1]){
            int z = angreiferErgebniss[0];
            angreiferErgebniss[0] = angreiferErgebniss[1];
            angreiferErgebniss[1] = z;
        }

        if (defender.getTroopCount() > 2) {
            if(verteiderEgebniss[0] < verteiderEgebniss[1]){
                int z = verteiderEgebniss[0];
                verteiderEgebniss[0] = verteiderEgebniss[1];
                verteiderEgebniss[1] = z;
            }

            if(angreiferErgebniss[1] > verteiderEgebniss[1]){
                defender.setTroopCount(defender.getTroopCount() - 1);
            }else{
                aggressor.setTroopCount(aggressor.getTroopCount() - 1);
            }
        }

        if(angreiferErgebniss[0] > verteiderEgebniss[0]){
            defender.setTroopCount(defender.getTroopCount() - 1);
        }else{
            aggressor.setTroopCount(aggressor.getTroopCount() - 1);
        }

    }

    public void moveTroop(Area a, Area b){
        if(a.getFarbeOwner().equals(b.getFarbeOwner())) {
            a.setTroopCount(a.getTroopCount() - 1);
            b.setTroopCount(b.getTroopCount() + 1);
        }
    }


}
