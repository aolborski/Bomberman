package bomberman.error;

import org.jetbrains.annotations.NotNull;

public class EntityWasKilled extends RuntimeException {

    public EntityWasKilled(@NotNull final String message) {
        super(message);
    }
}
