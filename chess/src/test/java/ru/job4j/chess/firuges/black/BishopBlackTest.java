package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlackTest {

    @Test
    public void whenPositionMatches() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        int[] result = {bishopBlack.position().getX(), bishopBlack.position().getY()};
        int[] expected = {2, 0};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenCopyFigureFromC1ToG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure result = bishopBlack.copy(Cell.G5);
        Cell expected = new BishopBlack(Cell.G5).position();
        Assert.assertEquals(expected, result.position());
    }

    @Test
    public void whenWayFromC1ToG5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] result = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Assert.assertArrayEquals(expected, result);
    }
}