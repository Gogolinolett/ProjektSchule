package classes;

import java.awt.*;
import java.util.LinkedList;

public class Player {
    private final Color farbe;
    private Board board;
    private String playername;
    private WinningConditions winningConditions;
    private LinkedList<Card> cards = new LinkedList<>();

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
        System.out.println(troops);
        troops += (board.getOwnedAreasAmount(this));
        System.out.println(troops);
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
}
