package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.KingWhite;

public class LogicTest {

    @Test(expected = FigureNotFoundException.class)
    public void whenFiguresNotFound() throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C2, Cell.H6);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveImpossible() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        Cell[] way = bishopBlack.way(Cell.G6);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenMoveNotValid() throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        logic.add(bishopBlack);
        logic.add(new KingWhite(Cell.G5));
        logic.move(Cell.C1, Cell.G5);
    }
}