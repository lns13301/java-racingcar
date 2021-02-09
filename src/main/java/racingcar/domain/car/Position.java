package racingcar.domain.car;

import java.util.Objects;

public class Position {

    private int position;

    public Position(final int position) {
        this.position = position;
    }

    public Position goForward() {
        return new Position(++position);
    }

    public int getValue() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
