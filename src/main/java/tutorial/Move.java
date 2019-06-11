package tutorial;

public class Move {

    //data-type?
    private int fromPosition;
    private int toPosition;

    //data-type again?
    public Move(int fromPosition, int toPosition) {
        this.fromPosition = fromPosition;
        this.toPosition = toPosition;
    }

    public int getFromPosition() {
        return fromPosition;
    }

    public int getToPosition() {
        return toPosition;
    }

    public void setToPosition(int toPosition) {
        this.toPosition = toPosition;
    }
}
