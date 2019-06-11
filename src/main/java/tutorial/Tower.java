package tutorial;

import java.util.Stack;

class Tower {

    private Stack<Disc> discs = new Stack<>();

    //encapsulation?
    Stack<Disc> getDiscs() {
        return discs;
    }

    //constructor?
    void initialiseDiscsOntoTower(int numberOfDiscs) {
        for (int discSize = numberOfDiscs; discSize > 0; discSize--) {
            discs.push(new Disc(discSize));
        }
    }

    //used?
    int getNumberOfDiscs() {
        return discs.size();
    }

    //naming?
    Disc removedTopDisc() {
        return discs.pop();
    }

    void addDisc(Disc disc) {
        discs.push(disc);
    }
}
