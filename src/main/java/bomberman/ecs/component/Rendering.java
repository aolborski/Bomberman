package bomberman.ecs.component;

import static bomberman.ecs.component.ComponentType.RENDERING;

public class Rendering implements Component {

    @Override
    public ComponentType getComponentType() {
        return RENDERING;
    }
}
