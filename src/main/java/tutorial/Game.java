package tutorial;

import java.util.Arrays;
import java.util.List;

class Game {

    //constructor?
    private Tower towerOne = new Tower();
    private Tower towerTwo = new Tower();
    private Tower towerThree = new Tower();
    //why the array?
    private List<Tower> towersOfHanoi = Arrays.asList(towerOne, towerTwo, towerThree);
    private List<Move> moves = Arrays.asList(new Move(0, 1), new Move(0, 2), new Move(1, 2));

    Tower getTower(int index) {
        return towersOfHanoi.get(index);
    }

    //constructor?
    void initialiseGame(int numberOfDiscs) {
        towersOfHanoi.get(0).initialiseDiscsOntoTower(numberOfDiscs);
        adjustMovesIfOdd(numberOfDiscs);
    }

    void solve() {
        while(!isComplete()){
            for (Move move:moves) {
                //parameter type?
                moveDisc(move.getFromPosition(), move.getToPosition());
                //push this into moveDisc
                if(isComplete()) {
                    break;
                }
            }
        }
    }

    //is move actually a method on Disc?
    void moveDisc(int fromTower, int toTower) {
        Tower startingTower = towersOfHanoi.get(fromTower);
        Tower finishingTower = towersOfHanoi.get(toTower);

        //try to avoid testing negative conditions
        if (!moveIsIllegal(fromTower, toTower)) {
            finishingTower.addDisc(startingTower.removedTopDisc());
        } else {
            startingTower.addDisc(finishingTower.removedTopDisc());
        }
    }

    private boolean isComplete() {
        return towerOne.getDiscs().isEmpty() && towerTwo.getDiscs().isEmpty();
    }

    //parameter types?
    //negated method meaning?
    private boolean moveIsIllegal(int fromTower, int toTower) {
        //could this not be a method on the tower?
        return getTower(fromTower).getDiscs().isEmpty() ||
                (!getTower(toTower).getDiscs().isEmpty() &&
                        //need to expose disc?
                        getTower(fromTower).getDiscs().peek().getSize() >
                                getTower(toTower).getDiscs().peek().getSize());
    }

    //legibility?
    private void adjustMovesIfOdd(int numberOfDiscs) {
        if (!(numberOfDiscs % 2 == 0)) {
            moves.get(0).setToPosition(2);
            moves.get(1).setToPosition(1);
        }
    }
}
