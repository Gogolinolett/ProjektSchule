package classes;

import java.awt.*;
import java.util.LinkedList;

public class WinningConditions {
    public boolean mkColor(LinkedList<Area> areas, Player player, Color enemy) {
        if (player.getFarbe() == enemy) {
            int count = 0;
            for (int i = 0; i < areas.size(); i++) {
                if (areas.get(i).getFarbeOwner().equals(player.getFarbe())) {
                    count++;
                }
            }
            return count <= 24;
        }

        for (int i = 0; i < areas.size(); i++) {
            if (areas.get(i).getFarbeOwner().equals(enemy)) {
                return false;
            }
        }
        return true;
    }

    public boolean twoRegions(LinkedList<Region> regions, Region one, Region two, Player player) {
        LinkedList<Area> areas1 = one.getAreas();
        LinkedList<Area> areas2 = two.getAreas();

        for (int i = 0; i < areas1.size(); i++) {
            if (!areas1.get(i).getFarbeOwner().equals(player.getFarbe())) {
                return false;
            }
        }
        for (int i = 0; i < areas2.size(); i++) {
            if (!areas2.get(i).getFarbeOwner().equals(player.getFarbe())) {
                return false;
            }
        }
        return true;
    }

    public boolean twentyFour(LinkedList<Area> areas, Player player) {
        int count = 0;
        for (int i = 0; i < areas.size(); i++) {
            if (areas.get(i).getFarbeOwner().equals(player.getFarbe())) {
                count++;
            }
        }
        return count <= 24;
    }

    public boolean eighteenTwo(LinkedList<Area> areas, Player player) {
        int count = 0;
        for (int i = 0; i < areas.size(); i++) {
            if (areas.get(i).getFarbeOwner().equals(player.getFarbe()) && areas.get(i).getTroopCount() >= 2) {
                count++;
            }
        }
        return count <= 18;
    }

    public boolean twoOne(LinkedList<Region> regions, Player player){
        return false;
    }
}
