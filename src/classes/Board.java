package classes;

import java.util.LinkedList;
import java.util.Random;

public class Board {
    private LinkedList<Region> regions;
    private LinkedList<Area> areas;
    private LinkedList<Card> cardPile;

    public Board(LinkedList<Area> areas, LinkedList<Region> regions){
        this.areas = areas;
        this.regions = regions;
    }

    public int getOwnedRegionsTroopsAmount(Player player){
        int troops = 0;
        boolean z = true;
        for(Region r : regions){
            z  = true;
            for(Area a : r.getAreas()){

                if(!a.getFarbeOwner().equals(player.getFarbe())){
                    z = false;
                }

            }

            if(z == true){
                troops += r.getTroops();
            }

        }
        return troops;


    }

    public int getOwnedAreasAmount(Player player) {
        int count = 0;
        for(int i = 0; i < areas.size() ;i ++){
            if(areas.get(i).getFarbeOwner().equals(player.getFarbe())){
                count ++;
            }
        }

        if(count < 9){
            return 3;
        }

        if(count < 36){
            return  count  / 3;
        }

        if(count < 40){
            return 12;
        }

        return 13;

    }

    public void placeTroop(Area area, int amount){
        area.setTroopCount(area.getTroopCount() + amount);
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

    public void moveTroop(Area a, Area b, int amount){
        if(a.getFarbeOwner().equals(b.getFarbeOwner()) && a.getTroopCount() > amount) {
            a.setTroopCount(a.getTroopCount() - amount);
            b.setTroopCount(b.getTroopCount() + amount);
        }
    }
}
