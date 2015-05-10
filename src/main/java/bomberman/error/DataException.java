package bomberman.error;

import org.jetbrains.annotations.NotNull;

public class DataException extends RuntimeException {

    public DataException(@NotNull final String message) {
        super(message);
    }
}
