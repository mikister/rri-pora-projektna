package si.um.feri.zzz.sonda2022.ecs.component;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.utils.Pool.Poolable;

public class PositionComponent implements Component, Poolable {
    public float x;
    public float y;
    public float z;

    @Override
    public void reset() {
        x = 0;
        y = 0;
        z = 0;
    }
}
