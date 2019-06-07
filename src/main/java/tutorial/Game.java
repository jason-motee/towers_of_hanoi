package tutorial;

import java.util.Arrays;
import java.util.List;

public class Game {

    private Tower towerOne = new Tower();
    private Tower towerTwo = new Tower();
    private Tower towerThree = new Tower();
    private List<Tower> towersOfHanoi = Arrays.asList(towerOne, towerTwo, towerThree);
    private List<Integer[]> moves = Arrays.asList(new Integer[]{0, 1}, new Integer[]{0, 2}, new Integer[]{1, 2});

    Tower getTower(int index) {
        return towersOfHanoi.get(index);
    }

    void initialiseGame(int numberOfDiscs) {
        towersOfHanoi.get(0).initialiseDiscsOntoTower(numberOfDiscs);
        adjustMovesIfOdd(numberOfDiscs);
    }

    void solve() {
        while(!isComplete()){
            for (Integer[] move:moves) {
                moveDisc(move[0], move[1]);
                if(isComplete()) {
                    break;
                }
            }
        }
    }

    void moveDisc(int fromTower, int toTower) {
        if (!moveIsIllegal(fromTower, toTower)) {
            towersOfHanoi.get(toTower).addDisc(towersOfHanoi.get(fromTower).removeTopDisc());
        } else {
            towersOfHanoi.get(fromTower).addDisc(towersOfHanoi.get(toTower).removeTopDisc());
        }
    }

    boolean isComplete() {
        return towerOne.getDiscs().isEmpty() && towerTwo.getDiscs().isEmpty();
    }

    private boolean moveIsIllegal(int fromTower, int toTower) {
        return getTower(fromTower).getDiscs().isEmpty() ||
                (!getTower(toTower).getDiscs().isEmpty() &&
                        getTower(fromTower).getDiscs().peek().getSize() >
                                getTower(toTower).getDiscs().peek().getSize());
    }

    private void adjustMovesIfOdd(int numberOfDiscs) {
        if (!(numberOfDiscs % 2 == 0)) {
            moves.get(0)[1] = 2;
            moves.get(1)[1] = 1;
        }
    }
}
