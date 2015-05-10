package bomberman.ecs;

import bomberman.ecs.component.Component;

/** Is it really good idea to use Builder Pattern to fill (set) component?
 *
 * Z GoF:
 *  "Budowniczy (Przeznaczenie): Oddziela tworzenie zlozonego obiektu od jego reprezentacji,
 *  dzieki czemu ten sam proces konstrukcji moze prowadzic do powstawania roznych reprezentacji."
 *
 *  Chyba zrobie tak że buildery uzyje
 *
 *
 * @param <T>
 */

public interface ComponentFactory<T extends Component> {
}
