package classes;

import java.awt.*;

public class Player {
    private final Color farbe;
    private Board board;
    private String playername;

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
        troops += 3 + (board.getOwnedAreasAmount(this));
        return troops;
    }

    public Color getFarbe() {
        return farbe;
    }
}
