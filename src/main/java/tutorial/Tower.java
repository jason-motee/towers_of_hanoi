package tutorial;

import java.util.Stack;

class Tower {

    private Stack<Disc> discs = new Stack<>();

    Stack<Disc> getDiscs() {
        return discs;
    }

    void initialiseDiscsOntoTower(int numberOfDiscs) {
        for (int discSize = numberOfDiscs; discSize > 0; discSize--) {
            discs.push(new Disc(discSize));
        }
    }

    int getNumberOfDiscs() {
        return discs.size();
    }

    Disc removeTopDisc() {
        return discs.pop();
    }

    Disc addDisc(Disc disc) {
        return discs.push(disc);
    }
}
