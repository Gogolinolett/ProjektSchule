package classes;

import java.awt.*;
import java.util.LinkedList;

public class Player {
    private final Color farbe;
    private Board board;
    private String playername;
    private int sterne = 0;
    private WinningConditions winningConditions;


    public Player(Color farbe, Board board, String playername){
        this.farbe = farbe;
        this.board = board;
        this.playername = playername;
    }

    public String getPlayername() {
        return playername;
    }

    public int getTroopsPerTurn() {
        int troops = 0;
        troops = board.getOwnedRegionsTroopsAmount(this);
        troops += (board.getOwnedAreasAmount(this));
        return troops;
    }

    public Color getFarbe() {
        return farbe;
    }

    public WinningConditions getWinningConditions() {
        return winningConditions;
    }

    public void setWinningConditions(WinningConditions winningConditions) {
        this.winningConditions = winningConditions;
    }

    public void drawn(){

        int rand = (int)(Math.random() * (52 + 1));

        if(rand < 12){
            sterne  += 2;
        }else{
            sterne ++;
        }
    }

    public int getSterne() {
        return sterne;
    }
}
