package classes;

public class Player {

    private Farben farbe;
    private Board board;


    public Player(Farben farbe, Board board){
        this.farbe = farbe;
        this.board = board;

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
