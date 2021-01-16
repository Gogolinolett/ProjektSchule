package classes;

public class Player {
    private Farben farbe;
    private Board board;
    private String playername;

    public Player(Farben farbe, Board board, String playername){
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

    public Farben getFarbe() {
        return farbe;
    }
}
