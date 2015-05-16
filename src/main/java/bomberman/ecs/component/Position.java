package bomberman.ecs.component;

import org.jetbrains.annotations.NotNull;

public class Position implements Component {

    @NotNull
    public int x;

    @NotNull
    public int y;

    public Position(@NotNull final int x, @NotNull final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
