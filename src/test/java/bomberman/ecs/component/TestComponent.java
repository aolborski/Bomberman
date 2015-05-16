package bomberman.ecs.component;

import bomberman.ecs.component.Component;
import org.jetbrains.annotations.NotNull;

public class TestComponent implements Component {
    public final int primaryKey;

    public TestComponent(@NotNull final int primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestComponent that = (TestComponent) o;

        return primaryKey == that.primaryKey;

    }

    @Override
    public int hashCode() {
        return primaryKey;
    }
}
