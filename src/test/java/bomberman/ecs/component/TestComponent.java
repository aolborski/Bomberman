package bomberman.ecs.component;

import bomberman.ecs.component.Component;
import org.jetbrains.annotations.NotNull;

public class TestComponent implements Component {
    public final int primaryKey;

    public TestComponent(@NotNull final int primaryKey) {
        this.primaryKey = primaryKey;
    }
}
