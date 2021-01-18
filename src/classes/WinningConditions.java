package classes;

import java.awt.*;
import java.util.LinkedList;

public class WinningConditions {
    public boolean mkColor(LinkedList<Area> areas, Player player, Color enemy){
        if (player.getFarbe() == enemy){
            int count = 0;
            for (int i = 0; i < areas.size(); i++) {
                if(areas.get(i).getFarbeOwner().equals(player.getFarbe())){
                    count++;
                }
            }
            if (count <= 24){
                return true;
            }else {
                return false;
            }
        }

        for (int i = 0; i < areas.size(); i++) {
            if(areas.get(i).getFarbeOwner().equals(enemy)){
                return false;
            }
        }
        return true;
    }

    public boolean twoRegions(LinkedList<Region> regions, Region one, Region two){


        return true;
    }
}
