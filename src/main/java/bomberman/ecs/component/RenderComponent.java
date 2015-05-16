package bomberman.ecs.component;

import javafx.scene.Node;
import org.jetbrains.annotations.NotNull;

public class RenderComponent implements Component {

    @NotNull
    public final Node node;

    public RenderComponent(@NotNull final Node node) {
        this.node = node;
    }
}
