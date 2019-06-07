package tutorial;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void checkWhenGameIsComplete() {
        // given
        game.initialiseGame(1);

        // when
        boolean isComplete = game.isComplete();

        // then
        assertThat(isComplete).isFalse();
    }

    @Test
    public void checkGameHasBeenInitialisedWithOneDisc() {
        // given
        game.initialiseGame(1);

        // when
        Stack<Disc> actual = game.getTower(0).getDiscs();
        Disc[] expected = {new Disc(1)};

        // then
        assertThat(actual).containsOnly(expected);
    }

    @Test
    public void checkGameHasBeenInitialisedWithTwoDiscs() {
        // given
        game.initialiseGame(2);

        // when
        Stack<Disc> actual = game.getTower(0).getDiscs();
        Disc[] expected = {new Disc(2), new Disc(1)};

        // then
        assertThat(actual).containsSequence(expected);
    }

    @Test
    public void checkDiscHasMovedOffOneTower() {
        // given
        game.initialiseGame(1);
        game.moveDisc(0, 1);

        // when
        Stack<Disc> towerOneDiscs = game.getTower(0).getDiscs();

        // then
        assertThat(towerOneDiscs).isEmpty();
    }

    @Test
    public void checkDiscHasMovedToAnotherTower() {
        // given
        game.initialiseGame(1);
        game.moveDisc(0, 1);

        // when
        Disc towerTwoDiscs = game.getTower(1).getDiscs().peek();
        Disc expected = new Disc(1);

        // then
        assertThat(towerTwoDiscs).isEqualTo(expected);

    }

    @Test
    public void checkGameWithTwoStartingDiscsIsComplete() {
        // given
        game.initialiseGame(2);
        game.solve();

        // when
        Stack<Disc> towerTwoDiscs = game.getTower(2).getDiscs();
        Disc[] expected = {new Disc(1), new Disc(2)};

        // then
        assertThat(towerTwoDiscs).containsOnly(expected);
    }

    @Test
    public void checkIllegalMoveHasReversedTheMove() {
        // given
        game.initialiseGame(2);
        game.moveDisc(0, 1);


        // when
        game.moveDisc(0, 1);
        Stack<Disc> towerTwoDiscs = game.getTower(0).getDiscs();
        Disc[] expected = {new Disc(2), new Disc(1)};

        // then
        assertThat(towerTwoDiscs).containsOnly(expected);
    }

    @Test
    public void checkGameWithFourStartingDiscsIsComplete() {
        // given
        game.initialiseGame(4);
        game.solve();

        // when
        Stack<Disc> towerTwoDiscs = game.getTower(2).getDiscs();
        Disc[] expected = {new Disc(4), new Disc(3), new Disc(2), new Disc(1)};

        // then
        assertThat(towerTwoDiscs).containsSequence(expected);
    }

    @Test
    public void checkGameWithFiveStartingDiscsIsComplete() {
        // given
        game.initialiseGame(5);
        game.solve();

        // when
        Stack<Disc> towerTwoDiscs = game.getTower(2).getDiscs();
        Disc[] expected = {new Disc(5), new Disc(4), new Disc(3), new Disc(2), new Disc(1)};

        // then
        assertThat(towerTwoDiscs).containsSequence(expected);
    }

    @Test
    public void checkGameWithNineStartingDiscsIsComplete() {
        // given
        game.initialiseGame(9);
        game.solve();

        // when
        Stack<Disc> towerTwoDiscs = game.getTower(2).getDiscs();
        Disc[] expected = {new Disc(9), new Disc(8), new Disc(7), new Disc(6), new Disc(5), new Disc(4), new Disc(3), new Disc(2), new Disc(1)};

        // then
        assertThat(towerTwoDiscs).containsSequence(expected);
    }
}
