package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(dest.getY() - position.getY());
        Cell[] steps = new Cell[size];
        int deltaX = position.getX() > dest.getX() ? -1 : 1;
        int deltaY = position.getY() > dest.getY() ? -1 : 1;
        for (int i = 1; i <= size; i++) {
            int x = position.getX() + (i * deltaX);
            int y = position.getY() + (i * deltaY);
            steps[i - 1] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(source.getX() - dest.getX())
                == Math.abs(source.getY() - dest.getY());

    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
