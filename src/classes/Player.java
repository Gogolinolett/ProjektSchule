package classes;

import java.awt.*;

public class Player {
    private Color farbe;
    private Board board;
    private String playername;
    private int sterne = 0;
    private WinningConditions winningConditions;
    private boolean hatErobert;

    public Player(Color farbe, Board board, String playername) {
        this.farbe = farbe;
        this.board = board;
        this.playername = playername;
    }

    public boolean isHatErobert() {
        return hatErobert;
    }

    public void setHatErobert(boolean hatErobert) {
        this.hatErobert = hatErobert;
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

    public void drawn() {
        int rand = (int) (Math.random() * (52 + 1));

        if (rand < 12) {
            sterne += 2;
        } else {
            sterne++;
        }
    }

    public int getSterne() {
        return sterne;
    }
}
