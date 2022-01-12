package si.um.feri.zzz.sonda2022.ecs.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool.Poolable;

public class DimensionComponent implements Component, Poolable {
    public float width = 1;
    public float height = 1;

    @Override
    public void reset() {
        width = 1;
        height = 1;
    }
}
