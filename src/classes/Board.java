package classes;

import gui.Main;
import gui.MoveTroops;
import gui.Würfeln;

import java.util.Comparator;
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

    public static void fight(Area aggressor, Area defender, int troops, LinkedList<Integer> angreiferErgebniss, LinkedList<Integer> verteiderEgebniss, Würfeln aThis){
        if(troops + 1 > aggressor.getTroopCount()){
            return;
        }


        for(int i = 0; i < troops && i  < 3; i ++){
            int num = (int) (Math.random() * 6  + 1);
            angreiferErgebniss.add(num);
        }

        for(int i = 0; i < troops && i  < 2; i ++){
            int num = (int) (Math.random() * 6  + 1);
            verteiderEgebniss.add(num);
        }

        angreiferErgebniss.sort(Comparator.naturalOrder());
        verteiderEgebniss.sort(Comparator.naturalOrder());
        int zz = 0;

        if(angreiferErgebniss.get(0) > verteiderEgebniss.get(0)){
            defender.setTroopCount(defender.getTroopCount() - 1);
        }else{
            aggressor.setTroopCount(aggressor.getTroopCount() - 1);
            zz ++;
        }
        if(defender.getTroopCount() > 0 && troops > 1) {
            if (angreiferErgebniss.get(1) > verteiderEgebniss.get(1)) {
                defender.setTroopCount(defender.getTroopCount() - 1);
            } else {
                aggressor.setTroopCount(aggressor.getTroopCount() - 1);
                zz++;
            }
        }
        if(defender.getTroopCount() < 1){

            MoveTroops moveTroops  = new MoveTroops(aggressor, defender, troops -zz);

        }

        Main.updateGui();
    }

    public void moveTroop(Area a, Area b, int amount){
        System.out.println("moving");
        if(a.getFarbeOwner().equals(b.getFarbeOwner()) && a.getTroopCount() > amount) {
            a.setTroopCount(a.getTroopCount() - amount);
            b.setTroopCount(b.getTroopCount() + amount);
            System.out.println("succes");
        }
        Main.updateGui();
    }
}
