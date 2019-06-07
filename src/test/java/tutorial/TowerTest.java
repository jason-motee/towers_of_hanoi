package tutorial;

import org.junit.Before;
import org.junit.Test;
import java.util.Stack;
import static org.assertj.core.api.Assertions.assertThat;

public class TowerTest {

    private Tower tower;

    @Before
    public void setup() {
        tower = new Tower();
    }

    @Test
    public void initialiseTowerWithDiscs() {
        // given
        tower.initialiseDiscsOntoTower(2);

        // when
        int numberOfDiscs = tower.getNumberOfDiscs();

        // then
        assertThat(numberOfDiscs).isEqualTo(2);
    }

    @Test
    public void getTopDisc() {
        // given
        tower.initialiseDiscsOntoTower(1);

        // when
        Disc actual = tower.removeTopDisc();
        Disc expected = new Disc(1);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void checkDiscSizesAreInDescendingOrder() {
        // given
        tower.initialiseDiscsOntoTower(2);

        // when
        Stack<Disc> actual = tower.getDiscs();
        Disc[] expected = {new Disc(2), new Disc(1)};

        // then
        assertThat(actual).containsSequence(expected);
    }

}
