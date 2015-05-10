package bomberman.error;

import org.jetbrains.annotations.NotNull;

public class EntityHasNotAnyComponent extends RuntimeException {

    public EntityHasNotAnyComponent(@NotNull final String message) {
        super(message);
    }
}
