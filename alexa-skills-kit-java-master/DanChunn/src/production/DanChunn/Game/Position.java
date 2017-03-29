package production.DanChunn.Game;

public class Position {
    protected int rank;
    protected int file;

    public Position(int rank, int file) {
        this.rank = rank;
        this.file = file;
    }

    public int getRank() {
        return this.rank;
    }

    public int getFile() {
        return this.file;
    }
}
