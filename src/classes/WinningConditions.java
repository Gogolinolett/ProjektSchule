package classes;

import gui.Main;

import java.awt.*;
import java.util.LinkedList;

public class WinningConditions {

    private Region region1;
    private Region region2;
    private Color color;
    private int wincon;
    private Image img;

    public Color getColor() {
        return color;
    }

    public WinningConditions(Region region1, Region region2, Color color, int wincon, Image img){
        this.region1 = region1;
        this.region2 = region2;
        this.color = color;
        this.wincon = wincon;
        this.img = img;

    }




    public boolean istGewonnen(LinkedList<Area> areas,LinkedList<Region>regions, Player player){

        if(wincon == 0){
            return mkColor(areas,player,color);
        }
        if(wincon == 1){
            return twoRegions(regions, region1, region2, player);
        }
        if(wincon == 2){
            return twentyFour(areas, player);
        }
        if(wincon == 3){
            return eighteenTwo(areas, player);
        }
        if(wincon == 4){
            return twoOne(regions,player,region1,region2);
        }
        Main.errorMessage("No win con found", "ERRRJHUP");
        return false;

    }

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

    public boolean twoOne(LinkedList<Region> regions, Player player, Region r1, Region r2){
        boolean z = true;
        boolean z2 = false;
        for(Region r : regions){
            z = true;
            if(r.equals(r1)){
                for(Area a : r.getAreas()){
                    if(!a.getFarbeOwner().equals(player)){
                        return false;
                    }
                }
            }else if(r.equals(r2)){
                for(Area a : r.getAreas()){
                    if(!a.getFarbeOwner().equals(player)){
                        return false;
                    }
                }
            }else{
                for(Area a : r.getAreas()){
                    if(!a.getFarbeOwner().equals(player)){
                        z = false;
                    }
                }

                if(z == true){
                    z2 = true;
                }
            }

        }
        return z2;
    }
}
